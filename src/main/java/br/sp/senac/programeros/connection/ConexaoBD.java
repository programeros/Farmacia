package br.sp.senac.programeros.connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Conexao BD
public class ConexaoBD {
    
    private String driver ="com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://sgf.mysql.uhserver.com/sgf";
    private String user = "sgf";
    private String senha = "Sen@c2016";
    private Connection conexao;  
    
    public ConexaoBD() {
        try {
            Class.forName(driver);
            conexao = (Connection) DriverManager.getConnection(url,user,senha);
        } catch (ClassNotFoundException | SQLException e) {
        }   
    }
    
    public Connection obterConexao() {
      return conexao;
    }
        
    public void fecharConexao(){
        try {
            conexao.close();
        } catch (SQLException e) {
        }
    }

}
