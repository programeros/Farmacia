package br.sp.senac.programeros.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    private java.sql.Connection conexao;  
    
    public Connection obterConexao(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDataSource");

            conexao = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/sgf;SecurityMechanism=3",
                    "sgf", 
                    "sgf");            
        } catch (ClassNotFoundException | SQLException e) {
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
