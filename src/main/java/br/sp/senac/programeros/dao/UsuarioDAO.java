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
import br.sp.senac.programeros.model.Usuario;

public class UsuarioDAO implements br.sp.senac.programeros.interfaces.UsuarioInterface{
Connection conexao;
    
    public UsuarioDAO(Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public void inserir(Usuario usuario) {
        
        String sql = "insert into usuarios "
            + "(login, nome, senha, ativo) VALUES (?, ?, ?, ?)";
        PreparedStatement p;
             
        
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, usuario.getLogin());
            p.setString(2, usuario.getNome());
            p.setString(3, usuario.getSenha());            
            p.setString(4, usuario.getAtivo());
            
            p.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void alterar(Usuario usuario) {
        
        try {
            String sql = "UPDATE usuarios "
                + " SET nome = ?, ativo = ? "
                + " WHERE codigo = ?";

            PreparedStatement p;            
            p = this.conexao.prepareStatement(sql);
            p.setString(1, usuario.getNome());
            p.setString(2, usuario.getAtivo());
            p.setInt(3, usuario.getCodigo());
            p.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }   
    
    @Override
    public void alterarSenha(Usuario usuario) {
        
        try {
            String sql = "UPDATE usuarios "
                + " SET senha = ? "
                + " WHERE codigo = ?";

            PreparedStatement p;            
            p = this.conexao.prepareStatement(sql);
            p.setString(1, usuario.getSenha());
            p.setInt(2, usuario.getCodigo());
            p.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        try{
            String sql = "SELECT * FROM usuarios";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql); 
                        
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                int codigo = rs.getInt("codigo");
                String login = rs.getString("login");
                String nome = rs.getString("nome");
                String senha = Senhas.Descriptografar(rs.getString("senha"));
                String ativo = rs.getString("ativo");
                
                usuario.setCodigo(codigo);
                usuario.setLogin(login);
                usuario.setNome(nome);
                usuario.setSenha(senha);
                usuario.setAtivo(ativo);
                
                usuarios.add(usuario);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuarios;
    }
    
    @Override
    public Usuario selecionar(int codigo){
       
        Usuario usuario = new Usuario();
        ConexaoBD conn = new ConexaoBD();
       
        String sql = "SELECT * FROM usuarios WHERE codigo= "+codigo;
        
        try{
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
                usuario.setCodigo(codigo);
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha")); 
                usuario.setAtivo(rs.getString("ativo"));
        }catch(Exception e){
            e.printStackTrace();
        }

        return usuario;

    }       
    
    @Override
    public Usuario Remove(int codigo){

        String sql = "DELETE FROM usuarios WHERE codigo=?";

        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setInt(1,codigo);

            p.execute();

        } catch (SQLException e) {            
            e.printStackTrace();
        }
        return null;

    }   
    
    public String verificar(String login, String senha){
        ConexaoBD conn = new ConexaoBD();
        String ret = null;
        String user = null;
        String pass = null;
       
        String sql = "SELECT * FROM usuarios WHERE login= '"+login+"'";
        
        try{
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql); 

            while(rs.next()){
                user = rs.getString("login");
                pass = rs.getString("senha");

                if(login.equals(user) && senha.equals(pass)){
                    ret = rs.getString("nome");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return ret;
    }       
}
