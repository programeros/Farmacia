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
        String sql = "INSERT INTO fornecedores"
                + "(nome,endereco,bairro,cidade,estado,cep,telefone,celular,"
                + "cadastro,ativo) VALUES "
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
            p.setString(10, "S");

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterar(Fornecedor fornecedor) {

        try {
            String sql = "UPDATE fornecedores "
                    + " SET nome = ?, endereco = ?, bairro = ?, cidade = ?, "
                    + " estado = ?, cep = ?, telefone = ?, celular = ?,"
                    + " ativo = ?"
                    + " WHERE codigo = ?";

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
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Fornecedor> listarFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

        try {
            String sql = "SELECT * FROM fornecedores";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();

                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String cep = rs.getString("cep");
                String telefone = rs.getString("telefone");
                String celular = rs.getString("celular");
                Date cadastro = rs.getDate("cadastro");
                String ativo = rs.getString("ativo");
                String deletado = rs.getString("deletado");

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

        String sql = "SELECT * FROM fornecedores WHERE codigo = " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            fornecedor.setCodigo(codigo);
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setEndereco(rs.getString("endereco"));
            fornecedor.setBairro(rs.getString("bairro"));
            fornecedor.setCidade(rs.getString("cidade"));
            fornecedor.setEstado(rs.getString("estado"));
            fornecedor.setCep(rs.getString("cep"));
            fornecedor.setTelefone(rs.getString("telefone"));
            fornecedor.setCelular(rs.getString("celular"));
            fornecedor.setCadastro(rs.getDate("cadastro"));
            fornecedor.setAtivo(rs.getString("ativo"));
            fornecedor.setDeletado(rs.getString("deletado"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fornecedor;

    }

    @Override
    public Fornecedor Remove(int codigo) {

        String sql = "DELETE FROM fornecedores WHERE codigo = ?";

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

}
