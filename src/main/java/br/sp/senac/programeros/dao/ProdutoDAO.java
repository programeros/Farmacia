package br.sp.senac.programeros.dao;


import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.connection.Senhas;
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

public class ProdutoDAO implements br.sp.senac.programeros.interfaces.ProdutoInterface{
Connection conexao;
    
    public ProdutoDAO(Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public void inserir(Produto produto) {
        
        String sql = "insert into produtos "
            + "(codbar,codigo,descricao,preco,marca,categoria_codigo,"
            + " fornecedor_codigo,ativo) "
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement p;
                     
        try {
            p = this.conexao.prepareStatement(sql);
 
            p.setInt(1, produto.getCodbar());
            p.setString(2, produto.getCodigo());            
            p.setString(3, produto.getDescricao());
            p.setFloat(4, produto.getPreco());            
            p.setString(5, produto.getMarca());
            p.setInt(6, produto.getCategoria());
            p.setInt(7, produto.getFornecedor());
            p.setString(8, produto.getAtivo());
            
            p.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void alterar(Produto produto) {
        
        try {
            String sql = "UPDATE produtos "
                + " SET codbar = ?, descricao = ?, preco = ?, marca = ?,"
                + " categoria_codigo = ?, fornecedor_codigo = ?, ativo = ?,"
                + " deletado = ?"
                + " WHERE codigo = ?";

            PreparedStatement p;            
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, produto.getCodbar());
            p.setString(2, produto.getDescricao());
            p.setFloat(3, produto.getPreco());
            p.setString(4, produto.getMarca());
            p.setInt(5, produto.getCategoria());
            p.setInt(6, produto.getFornecedor());
            p.setString(7, produto.getAtivo());
            p.setString(8, produto.getDeletado());
            
            p.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }   
    
     
    @Override
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();
        
        try{
            String sql = "SELECT * FROM produtos";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql); 
                        
            while(rs.next()){
                Produto produto = new Produto();
                
                int codbar = rs.getInt("codbar");
                String codigo = rs.getString("codigo");
                String descricao = rs.getString("descricao");
                float preco = rs.getFloat("preco");
                String marca = rs.getString("marca");
                int categoria = rs.getInt("categoria_codigo");
                int fornecedor = rs.getInt("fornecedor_codigo");
                String ativo = rs.getString("ativo");
                
                produto.setCodbar(codbar);
                produto.setCodigo(codigo);
                produto.setDescricao(descricao);
                produto.setPreco(preco);
                produto.setMarca(marca);
                produto.setCategoria(categoria);
                produto.setFornecedor(fornecedor);
                produto.setAtivo(ativo);
                                
                produtos.add(produto);
            }
            
        }catch(SQLException e){
        }
        
        return produtos;
    }
    
    @Override
    public Produto selecionar(int codigo){
       
        Produto produto = new Produto();
        ConexaoBD conn = new ConexaoBD();
       
        String sql = "SELECT * FROM produtos WHERE codbar= "+codigo;
        
        try{
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            
                produto.setCodbar(codigo);
                produto.setCodigo(rs.getString("codigo"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setMarca(rs.getString("marca"));
                produto.setCategoria(rs.getInt("categoria_codigo"));
                produto.setFornecedor(rs.getInt("fornecedor_codigo"));
                produto.setAtivo(rs.getString("ativo"));

        }catch(SQLException e){
        }

        return produto;

    }       
    
    @Override
    public void remove(int codigo) {
        
        try {
            String sql = "UPDATE produtos "
                + " SET deletado = '*'  WHERE codigo = "+codigo;

            PreparedStatement p;            
            p = this.conexao.prepareStatement(sql);
            
            p.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }   
}
