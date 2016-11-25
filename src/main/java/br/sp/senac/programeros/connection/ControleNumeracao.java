package br.sp.senac.programeros.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControleNumeracao {
    //Conexao do banco
    Connection conexao;
    //Construtor
    public ControleNumeracao(Connection conexao){
        this.conexao = conexao;
    }    
    //Seleciona o numero
    public int forneceNumero(String tabela){
        ConexaoBD conn = new ConexaoBD();
        int number = 0 ;
        //Comando do banco
        String sql = "SELECT count(numero) as 'numero' FROM controle_numeracao "
                + "WHERE tabela= '"+tabela+"'";
        
        try{
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql); 

            while(rs.next()){
                number = rs.getInt("numero")+1;                
                gravaNumero(tabela, number);
            }
            
        }catch(SQLException e){
        }
        
        return number;
    } 
    
    //Inserir o numer
    public void gravaNumero(String tabela, int proxNum) {
        //Comando do banco
        String sql = "insert into controle_numeracao "
            + "(tabela, numero) VALUES (?, ?)";
        
        PreparedStatement p;
             
        
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, tabela);
            p.setInt(2, proxNum);
                       
            p.execute();
            
        } catch (SQLException e) {
        }
        
    }    
}
