package br.sp.senac.programeros.dao;
/**
 *
 * @author Pedro
 */

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAO implements br.sp.senac.programeros.interfaces.CategoriaInterface {
    //Conexao Banco
    Connection conexao;
    //Construtor
    public CategoriaDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    //Inserir
    public void categoria(Categoria categoria) {
        //Comando do banco
        String sql = "insert into categorias "
                + "(descricao, ativo) values"
                + "(?,?)";
        PreparedStatement p;
        try {
            //Setando os valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, categoria.getDescricao());  
            p.setString(2, "S");
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //Alterar
    @Override
    public void alterar(Categoria categoria) {
        
        try {
            //Comando do banco
            String sql = "update categorias "
                    + " set descricao = ?, ativo = ?"
                    + " where codigo = ?";
            //Setando os valores
            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, categoria.getDescricao());
            p.setString(2, String.valueOf(categoria.getAtivo()));
            p.setInt(3, categoria.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Listar
    @Override
    public List<Categoria> listarCategorias() {
        //Lista
        List<Categoria> categorias = new ArrayList<Categoria>();
        
        try{
            //Comando do banco
            String sql = "SELECT * FROM categorias";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql); 
                        
            while(rs.next()){
                //Setando os valores
                Categoria categoria = new Categoria();
                
                categoria.setCodigo(rs.getInt("codigo"));
                categoria.setDescricao(rs.getString("descricao"));
                categoria.setAtivo(rs.getString("ativo"));
                categoria.setDeletado(rs.getString("deletado"));
                
                categorias.add(categoria);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return categorias;
    }
    
    //Selecionar
    @Override
    public Categoria selecionar(int codigo) {
        //Criando o objeto categoria       
        Categoria categoria = new Categoria();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM categorias WHERE codigo= "+codigo;
        
        try{
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
                categoria.setCodigo(rs.getInt("codigo"));
                categoria.setDescricao(rs.getString("descricao"));
                categoria.setAtivo(rs.getString("ativo"));
                categoria.setDeletado(rs.getString("deletado"));
                
        }catch(Exception e){
            e.printStackTrace();
        }

        return categoria;
    
    }
    
    //Remover
    @Override
    public Categoria Remove(int codigo) {
        //Comando do banco
        String sql = "DELETE FROM categorias WHERE codigo=?";

        PreparedStatement p;
        try {
            //Setando os valores
            p = this.conexao.prepareStatement(sql);
            p.setInt(1,codigo);

            p.execute();

        } catch (SQLException e) {            
            e.printStackTrace();
        }
        return null;
    }
    
    //Inserir
    @Override
    public void inserir(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
