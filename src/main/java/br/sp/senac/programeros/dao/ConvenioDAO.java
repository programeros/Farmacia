package br.sp.senac.programeros.dao;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.model.Categoria;
import br.sp.senac.programeros.model.Convenio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvenioDAO implements br.sp.senac.programeros.interfaces.ConvenioInterface {

    //Conexao Banco
    Connection conexao;

    //Construtor
    public ConvenioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    //Inserir
    public void convenio(Convenio convenio) {
        //Comando do banco
        String sql = "insert into convenios "
                + "(nome, telefone, responsavel, email, ativo, deletado) values"
                + "(?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            //Setando os valores    
            p = this.conexao.prepareStatement(sql);
            p.setString(1, convenio.getNome());
            p.setString(2, convenio.getTelefone());
            p.setString(3, convenio.getResponsavel());
            p.setString(4, convenio.getEmail());
            p.setString(5, "S");
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Alterar
    @Override
    public void alterar(Convenio convenio) {
        try {
            //Comando do banco
            String sql = "update convenios "
                    + " set nome = ?, telefone = ?, resposavel = ?,"
                    + " email = ?, ativo = ?"
                    + " where codigo = ?";

            //Setando os valores
            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, convenio.getNome());
            p.setString(2, convenio.getTelefone());
            p.setString(3, convenio.getResponsavel());
            p.setString(4, convenio.getEmail());
            p.setString(5, String.valueOf(convenio.getAtivo()));
            p.setInt(6, convenio.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Listar
    @Override
    public List<Convenio> listarConvenios() {
        //Lista
        List<Convenio> convenios = new ArrayList<Convenio>();

        try {
            //Comando do banco
            String sql = "SELECT * FROM convenios";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Setando valores
                Convenio convenio = new Convenio();

                convenio.setCodigo(rs.getInt("codigo"));
                convenio.setNome(rs.getString("nome"));
                convenio.setTelefone("telefone");
                convenio.setEmail("email");
                convenio.setAtivo(rs.getString("ativo").charAt(0));
                convenio.setDelatado(rs.getString("deletado").charAt(0));

                convenios.add(convenio);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return convenios;
    }

    //Selecionar
    @Override
    public Convenio selecionar(int codigo) {
        //Criando objeto
        Convenio convenio = new Convenio();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM convenios WHERE codigo= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            convenio.setCodigo(rs.getInt("codigo"));
            convenio.setNome("nome");
            convenio.setResponsavel("responsavel");
            convenio.setEmail("email");
            convenio.setAtivo(rs.getString("ativo").charAt(0));
            convenio.setDelatado(rs.getString("deletado").charAt(0));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return convenio;
    }

    //Remover
    @Override
    public Convenio Remove(int codigo) {
        //Comando do banco
        String sql = "DELETE FROM convenios WHERE codigo=?";

        PreparedStatement p;
        try {
            //Setando os valores
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, codigo);

            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Inserir
    @Override
    public void inserir(Convenio convenio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
