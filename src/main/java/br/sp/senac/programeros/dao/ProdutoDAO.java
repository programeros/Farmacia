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
import br.sp.senac.programeros.model.Produto;

public class ProdutoDAO implements br.sp.senac.programeros.interfaces.ProdutoInterface {
    Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void produto(Produto produto) {
        String sql = "INSERT INTO PRODUTOS "
                + "(CODIGO, DESCRICAO, PRECO, MARCA,CATEGORIAS_CODIGO,FORNECEDORES_CODIGO,UNIDADES_CODIGO) VALUES "
                + "(?,?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, produto.getCodigo());
            p.setString(2, produto.getDescricao());
            p.setFloat(3, produto.getPreco());
            p.setString(4, produto.getMarca());
            p.setInt(5, produto.getCategoria());
            p.setInt(6, produto.getFornecedor());            
            p.setInt(7, produto.getUnidade());            

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void alterar(Produto produto) {

        try {
            String sql = "UPDATE PRODUTOS "
                    + " SET DESCRICAO = ?, PRECO = ?, MARCA = ?, "
                    + " CATEGORIAS_CODIGO = ?, FORNECEDORES_CODIGO = ?, UNIDADES_CODIGO = ?"                   
                    + " WHERE CODIGO = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);            
            p.setString(1, produto.getDescricao());
            p.setFloat(2, produto.getPreco());
            p.setString(3, produto.getMarca());
            p.setInt(4, produto.getCategoria());
            p.setInt(5, produto.getFornecedor());            
            p.setInt(6, produto.getUnidade());            
            p.setString(7, produto.getCodigo());
            
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();

        try {
            String sql = "SELECT * FROM PRODUTOS";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Produto produto = new Produto();

                String codigo = rs.getString("CODIGO");
                String descricao = rs.getString("DESCRICAO");
                float preco = rs.getFloat("PRECO");
                String marca = rs.getString("MARCA");
                int categoria = rs.getInt("CATEGORIAS_CODIGO");                
                int fornecedor = rs.getInt("FORNECEDORES_CODIGO");
                int unidade = rs.getInt("UNIDADES_CODIGO");

                produto.setCodigo(codigo);
                produto.setDescricao(descricao);
                produto.setPreco(preco);
                produto.setMarca(marca);
                produto.setCategoria(categoria);
                produto.setFornecedor(fornecedor);
                produto.setUnidade(unidade);
                
                produtos.add(produto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }

    @Override
    public Produto selecionar(String codigo) {

        Produto produto = new Produto();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM PRODUTOS WHERE CODIGO= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            produto.setCodigo(codigo);
            produto.setDescricao(rs.getString("DESCRICAO"));
            produto.setPreco(rs.getFloat("PRECO"));
            produto.setMarca(rs.getString("MARCA"));
            produto.setCategoria(rs.getInt("CATEGORIAS_CODIGO"));
            produto.setFornecedor(rs.getInt("FORNECEDORES_CODIGO"));
            produto.setUnidade(rs.getInt("UNIDADES_CODIGO"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produto;

    }

    @Override
    public Produto Remove(String codigo) {

        String sql = "DELETE FROM PRODUTOS WHERE CODIGO=?";

        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, codigo);

            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void inserir(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    
}
