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

    @Override
    public void inserir(Produto produto) {
        String sql = "INSERT INTO produtos "
                + "(codigo,descricao,preco,marca,ativo) VALUES "
                + "(?,?,?,?,?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, produto.getCodigo());
            p.setString(2, produto.getDescricao());
            p.setFloat(3, produto.getPreco());
            p.setString(4, produto.getMarca());            
            p.setString(5, produto.getAtivo());            

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void alterar(Produto produto) {

        try {
            String sql = "UPDATE produtos "
                    + " SET descricao = ?, preco = ?, marca = ?, ativo = ?"                    
                    + " WHERE codigo = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);            
            p.setString(1, produto.getDescricao());
            p.setFloat(2, produto.getPreco());
            p.setString(3, produto.getMarca());                       
            p.setString(4, produto.getAtivo());            
            p.setString(5, produto.getCodigo());
            
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();

        try {
            String sql = "SELECT * FROM produtos";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Produto produto = new Produto();

                String codigo = rs.getString("codigo");
                String descricao = rs.getString("descricao");
                float preco = rs.getFloat("preco");
                String marca = rs.getString("marca");
                int categoria = rs.getInt("categoria_codigo");                
                int fornecedor = rs.getInt("fornecedor_codigo");               
                String ativo = rs.getString("ativo");
                String deletado = rs.getString("deletado");
                
                produto.setCodigo(codigo);
                produto.setDescricao(descricao);
                produto.setPreco(preco);
                produto.setMarca(marca);
                produto.setCategoria(categoria);
                produto.setFornecedor(fornecedor);
                produto.setAtivo(ativo);
                produto.setDeletado(deletado);
                
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

        String sql = "SELECT * FROM produtos WHERE codigo = " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            produto.setCodigo(codigo);
            produto.setDescricao(rs.getString("descricao"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setMarca(rs.getString("marca"));
            produto.setCategoria(rs.getInt("categoria_codigo"));
            produto.setFornecedor(rs.getInt("fornecedor_codigo"));
            produto.setAtivo(rs.getString("ativo"));
            produto.setDeletado(rs.getString("deletado"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produto;

    }

    @Override
    public Produto Remove(String codigo) {

        String sql = "DELETE FROM produtos WHERE codigo =?";

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

//    @Override
//    public void inserir(Produto produto) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }    
    
}
