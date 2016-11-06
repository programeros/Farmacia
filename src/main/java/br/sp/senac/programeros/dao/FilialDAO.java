package br.sp.senac.programeros.dao;

/** 
 * @author Michael Facul
 */
import br.sp.senac.programeros.connection.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.sp.senac.programeros.model.Filial;

public class FilialDAO implements br.sp.senac.programeros.interfaces.FilialInterface {

    Connection conexao;

    public FilialDAO(Connection conexao) {
        this.conexao = conexao;
    }
    public void filial(Filial filial) {
        String sql = "INSERT INTO UNIDADES "
                + "(NOME, ENDERECO, BAIRRO, CIDADE,ESTADO,CEP,TELEFONE,EMAIL,"
                + "ATIVO) VALUES "
                + "(?,?,?,?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, filial.getNome());
            p.setString(2, filial.getEndereco());
            p.setString(3, filial.getBairro());
            p.setString(4, filial.getCidade());
            p.setString(5, filial.getEstado());
            p.setString(6, filial.getCep());            
            p.setString(7, filial.getTelefone());
            p.setString(8, filial.getEmail());
            p.setString(9, "S");          

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void alterar(Filial filial) {

        try {
            String sql = "UPDATE UNIDADES "
                    + " SET NOME = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, "
                    + " ESTADO = ?, CEP = ?, TELEFONE = ?, EMAIL = ?, ATIVO = ? "                    
                    + " WHERE CODIGO = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, filial.getNome());
            p.setString(2, filial.getEndereco());
            p.setString(3, filial.getBairro());
            p.setString(4, filial.getCidade());
            p.setString(5, filial.getEstado());
            p.setString(6, filial.getCep());            
            p.setString(7, filial.getTelefone());
            p.setString(8, filial.getEmail());            
            p.setString(9, String.valueOf(filial.getAtivo()));
            p.setInt(10, filial.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<Filial> listarFiliais() {
        List<Filial> filiais = new ArrayList<Filial>();

        try {
            String sql = "SELECT * FROM UNIDADES";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Filial filial = new Filial();

                int codigo = rs.getInt("CODIGO");
                String nome = rs.getString("NOME");
                String endereco = rs.getString("ENDERECO");
                String bairro = rs.getString("BAIRRO");
                String cidade = rs.getString("CIDADE");
                String estado = rs.getString("ESTADO");
                String cep = rs.getString("CEP");                
                String telefone = rs.getString("TELEFONE");
                String email = rs.getString("EMAIL");                
                char ativo = rs.getString("ATIVO").charAt(0);
                char deletado = rs.getString("DELETADO").charAt(0);

                filial.setCodigo(codigo);
                filial.setNome(nome);
                filial.setEndereco(endereco);
                filial.setBairro(bairro);
                filial.setCidade(cidade);
                filial.setEstado(estado);
                filial.setCep(cep);                
                filial.setTelefone(telefone);
                filial.setEmail(email);                
                filial.setAtivo(ativo);
                filial.setDeletado(deletado);

                filiais.add(filial);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filiais;
    }

    @Override
    public Filial selecionar(int codigo) {

        Filial filial = new Filial();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM UNIDADES WHERE CODIGO= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            filial.setCodigo(codigo);
            filial.setNome(rs.getString("NOME"));
            filial.setEndereco(rs.getString("ENDERECO"));
            filial.setBairro(rs.getString("BAIRRO"));
            filial.setCidade(rs.getString("CIDADE"));
            filial.setEstado(rs.getString("ESTADO"));
            filial.setCep(rs.getString("CEP"));           
            filial.setTelefone(rs.getString("TELEFONE"));
            filial.setEmail(rs.getString("EMAIL"));           
            filial.setAtivo(rs.getString("ATIVO").charAt(0));
            filial.setDeletado(rs.getString("DELETADO").charAt(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filial;

    }

    @Override
    public Filial Remove(int codigo) {

        String sql = "DELETE FROM UNIDADES WHERE CODIGO=?";

        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, codigo);

            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void inserir(Filial filial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
