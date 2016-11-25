package br.sp.senac.programeros.connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Conexao BD
public class ConexaoBD {
    //Dados do banco
    private String driver ="com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://sgf.mysql.uhserver.com/sgf";
    private String user = "sgf";
    private String senha = "Sen@c2016";
    private Connection conexao;  
    
    //Conecta o banco
    public ConexaoBD() {
        try {
            Class.forName(driver);
            conexao = (Connection) DriverManager.getConnection(url,user,senha);
        } catch (ClassNotFoundException | SQLException e) {
        }   
    }
    //Retorna a conexao
    public Connection obterConexao() {
      return conexao;
    }
    //Fecha a conexao    
    public void fecharConexao(){
        try {
            conexao.close();
        } catch (SQLException e) {
        }
    }

}
