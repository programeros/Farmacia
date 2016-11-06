/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.programeros.dao;

/**
 *
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
import br.sp.senac.programeros.model.Vendedor;
import java.sql.Date;

public class VendedorDAO implements br.sp.senac.programeros.interfaces.VendedorInterface {
    Connection conexao;

    public VendedorDAO(Connection conexao) {
        this.conexao = conexao;
    }
    public void vendedor(Vendedor vendedor) {
        String sql = "INSERT INTO VENDEDORES"
                + "(NOME, ENDERECO, BAIRRO, CIDADE,ESTADO,CEP,TELEFONE,CELULAR,"
                + "CADASTRO,ATIVO) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, vendedor.getNome());
            p.setString(2, vendedor.getEndereco());
            p.setString(3, vendedor.getBairro());
            p.setString(4, vendedor.getCidade());
            p.setString(5, vendedor.getEstado());
            p.setString(6, vendedor.getCep());
            p.setString(7, vendedor.getTelefone());
            p.setString(8, vendedor.getCelular());
            p.setDate(9, new java.sql.Date(System.currentTimeMillis()));
            p.setString(10, "S");

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public void alterar(Vendedor vendedor) {

        try {
            String sql = "UPDATE VENDEDORES"
                    + " SET NOME = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, "
                    + " ESTADO = ?, CEP = ?, TELEFONE = ?, CELULAR = ?,"
                    + " ATIVO = ?"
                    + " WHERE CODIGO = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, vendedor.getNome());
            p.setString(2, vendedor.getEndereco());
            p.setString(3, vendedor.getBairro());
            p.setString(4, vendedor.getCidade());
            p.setString(5, vendedor.getEstado());
            p.setString(6, vendedor.getCep());
            p.setString(7, vendedor.getTelefone());
            p.setString(8, vendedor.getCelular());
            p.setString(9, String.valueOf(vendedor.getAtivo()));
            p.setInt(10, vendedor.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Vendedor> listarVendedores() {
        List<Vendedor> vendedores = new ArrayList<Vendedor>();

        try {
            String sql = "SELECT * FROM VENDEDORES";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Vendedor vendedor = new Vendedor();

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

                vendedor.setCodigo(codigo);
                vendedor.setNome(nome);
                vendedor.setEndereco(endereco);
                vendedor.setBairro(bairro);
                vendedor.setCidade(cidade);
                vendedor.setEstado(estado);
                vendedor.setCep(cep);
                vendedor.setTelefone(telefone);
                vendedor.setCelular(celular);
                vendedor.setCadastro(cadastro);
                vendedor.setAtivo(ativo);
                vendedor.setDeletado(deletado);

                vendedores.add(vendedor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendedores;
    }

    @Override
    public Vendedor selecionar(int codigo) {

        Vendedor vendedor = new Vendedor();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM VENDEDORES WHERE CODIGO= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            vendedor.setCodigo(codigo);
            vendedor.setNome(rs.getString("NOME"));
            vendedor.setEndereco(rs.getString("ENDERECO"));
            vendedor.setBairro(rs.getString("BAIRRO"));
            vendedor.setCidade(rs.getString("CIDADE"));
            vendedor.setEstado(rs.getString("ESTADO"));
            vendedor.setCep(rs.getString("CEP"));
            vendedor.setTelefone(rs.getString("TELEFONE"));
            vendedor.setCelular(rs.getString("CELULAR"));
            vendedor.setCadastro(rs.getDate("CADASTRO"));
            vendedor.setAtivo(rs.getString("ATIVO").charAt(0));
            vendedor.setDeletado(rs.getString("DELETADO").charAt(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendedor;

    }

    @Override
    public Vendedor Remove(int codigo) {

        String sql = "DELETE FROM VENDEDORES WHERE CODIGO=?";

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
    public void inserir(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
