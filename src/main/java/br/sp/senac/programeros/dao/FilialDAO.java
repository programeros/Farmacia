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
import br.sp.senac.programeros.model.Filiais;

public class FilialDAO implements br.sp.senac.programeros.interfaces.FilialInterface {

    Connection conexao;

    public FilialDAO(Connection conexao) {
        this.conexao = conexao;
    }
    public void filial(Filiais filial) {
        String sql = "INSERT INTO filiais "
                + "(nome,endereco,bairro,cidade,estado,cep,telefone,fax,responsavel,email,"
                + "ativo) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?)";
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
            p.setString(8, filial.getFax());
            p.setString(9, filial.getResponsavel());            
            p.setString(10, filial.getEmail());                        
            p.setString(11, "S");          

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void alterar(Filiais filial) {

        try {
            String sql = "UPDATE filiais "
                    + " SET nome = ?, endereco = ?, bairro = ?, cidade = ?, "
                    + " estado = ?, cep = ?, telefone = ?, fax = ?, responsavel = ?, email = ?, ativo = ?, deletado = ? "                    
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
            p.setString(8, filial.getFax());
            p.setString(9, filial.getResponsavel()); 
            p.setString(10, filial.getEmail());            
            p.setString(11, String.valueOf(filial.getAtivo()));
            p.setString(12, String.valueOf(filial.getDeletado()));
            p.setInt(13, filial.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<Filiais> listarFiliais() {
        List<Filiais> filiais = new ArrayList<Filiais>();

        try {
            String sql = "SELECT * FROM filiais";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Filiais filial = new Filiais();

                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String cep = rs.getString("cep");                
                String telefone = rs.getString("telefone");
                String fax = rs.getString("fax");
                String responsavel = rs.getString("responsavel");
                String email = rs.getString("email");                
                String ativo = rs.getString("ativo");
                String deletado = rs.getString("deletado");

                filial.setCodigo(codigo);
                filial.setNome(nome);
                filial.setEndereco(endereco);
                filial.setBairro(bairro);
                filial.setCidade(cidade);
                filial.setEstado(estado);
                filial.setCep(cep);                
                filial.setTelefone(telefone);
                filial.setFax(fax);
                filial.setResponsavel(responsavel);
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
    public Filiais selecionar(int codigo) {

        Filiais filial = new Filiais();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM filiais WHERE codigo= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            filial.setCodigo(codigo);
            filial.setNome(rs.getString("nome"));
            filial.setEndereco(rs.getString("endereco"));
            filial.setBairro(rs.getString("bairro"));
            filial.setCidade(rs.getString("cidade"));
            filial.setEstado(rs.getString("estado"));
            filial.setCep(rs.getString("cep"));           
            filial.setTelefone(rs.getString("telefone"));
            filial.setFax(rs.getString("fax"));
            filial.setResponsavel(rs.getString("responsavel"));
            filial.setEmail(rs.getString("email"));           
            filial.setAtivo(rs.getString("ativo"));
            filial.setDeletado(rs.getString("deletado"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filial;

    }

    @Override
    public Filiais Remove(int codigo) {

        String sql = "DELETE FROM filiais WHERE codigo=?";

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
    public void inserir(Filiais filial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
