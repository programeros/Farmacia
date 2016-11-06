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
import br.sp.senac.programeros.model.Fornecedor;
import java.sql.Date;

public class FornecedorDAO implements br.sp.senac.programeros.interfaces.FornecedorInterface {

    Connection conexao;

    public FornecedorDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void fornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO FORNECEDORES"
                + "(NOME, ENDERECO, BAIRRO, CIDADE,ESTADO,CEP,TELEFONE,CELULAR,"
                + "CADASTRO,ATIVO) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, fornecedor.getNome());
            p.setString(2, fornecedor.getEndereco());
            p.setString(3, fornecedor.getBairro());
            p.setString(4, fornecedor.getCidade());
            p.setString(5, fornecedor.getEstado());
            p.setString(6, fornecedor.getCep());
            p.setString(7, fornecedor.getTelefone());
            p.setString(8, fornecedor.getCelular());
            p.setDate(9, new java.sql.Date(System.currentTimeMillis()));
            p.setString(10, String.valueOf(fornecedor.getAtivo()));

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterar(Fornecedor fornecedor) {

        try {
            String sql = "UPDATE FORNECEDORES "
                    + " SET NOME = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, "
                    + " ESTADO = ?, CEP = ?, TELEFONE = ?, CELULAR = ?,"
                    + " ATIVO = ?"
                    + " WHERE CODIGO = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, fornecedor.getNome());
            p.setString(2, fornecedor.getEndereco());
            p.setString(3, fornecedor.getBairro());
            p.setString(4, fornecedor.getCidade());
            p.setString(5, fornecedor.getEstado());
            p.setString(6, fornecedor.getCep());
            p.setString(7, fornecedor.getTelefone());
            p.setString(8, fornecedor.getCelular());
            p.setString(9, String.valueOf(fornecedor.getAtivo()));
            p.setInt(10, fornecedor.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Fornecedor> listarFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

        try {
            String sql = "SELECT * FROM FORNECEDORES";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();

                int codigo = rs.getInt("CODIGO");
                String nome = rs.getString("NOME");
                String endereco = rs.getString("ENDERECO");
                String bairro = rs.getString("BAIRRO");
                String cidade = rs.getString("CIDADE");
                String estado = rs.getString("ESTADO");
                String cep = rs.getString("CEP");
                String telefone = rs.getString("TELEFONE");
                String celular = rs.getString("CELULAR");
                Date cadastro = rs.getDate("CADASTRO");
                char ativo = rs.getString("ATIVO").charAt(0);
                char deletado = rs.getString("DELETADO").charAt(0);

                fornecedor.setCodigo(codigo);
                fornecedor.setNome(nome);
                fornecedor.setEndereco(endereco);
                fornecedor.setBairro(bairro);
                fornecedor.setCidade(cidade);
                fornecedor.setEstado(estado);
                fornecedor.setCep(cep);
                fornecedor.setTelefone(telefone);
                fornecedor.setCelular(celular);
                fornecedor.setCadastro(cadastro);
                fornecedor.setAtivo(ativo);
                fornecedor.setDeletado(deletado);

                fornecedores.add(fornecedor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedores;
    }

    @Override
    public Fornecedor selecionar(int codigo) {

        Fornecedor fornecedor = new Fornecedor();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM FORNECEDORES WHERE CODIGO= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            fornecedor.setCodigo(codigo);
            fornecedor.setNome(rs.getString("NOME"));
            fornecedor.setEndereco(rs.getString("ENDERECO"));
            fornecedor.setBairro(rs.getString("BAIRRO"));
            fornecedor.setCidade(rs.getString("CIDADE"));
            fornecedor.setEstado(rs.getString("ESTADO"));
            fornecedor.setCep(rs.getString("CEP"));
            fornecedor.setTelefone(rs.getString("TELEFONE"));
            fornecedor.setCelular(rs.getString("CELULAR"));
            fornecedor.setCadastro(rs.getDate("CADASTRO"));
            fornecedor.setAtivo(rs.getString("ATIVO").charAt(0));
            fornecedor.setDeletado(rs.getString("DELETADO").charAt(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fornecedor;

    }

    @Override
    public Fornecedor Remove(int codigo) {

        String sql = "DELETE FROM FORNECEDORES WHERE CODIGO=?";

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
    public void inserir(Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fornecedor> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
