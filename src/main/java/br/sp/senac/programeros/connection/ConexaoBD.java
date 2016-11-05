package br.sp.senac.programeros.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoBD {
    
    private Connection conexao;  
    
    public Connection obterConexao() {
	try{
        conexao = new com.mysql.jdbc.Driver().connect(
            "jdbc:mysql://sgf.mysql.uhserver.com:3306/sgf?user=sgf&password=Sen@c2016",null);
	}catch(SQLException e){
		System.out.println("Driver não encontrado "+e);
	}

      return conexao;
    }
        
    public void fecharConexao(){
        try {
            conexao.close();
        } catch (SQLException e) {
        }
    }

}
