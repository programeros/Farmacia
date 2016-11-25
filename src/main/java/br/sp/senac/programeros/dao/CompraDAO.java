package br.sp.senac.programeros.dao;

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
import br.sp.senac.programeros.model.Compra;
import java.sql.Date;

public class CompraDAO implements br.sp.senac.programeros.interfaces.CompraInterface {
    //Conexao do banco
    Connection conexao;
    //Construtor
    public CompraDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    //Inserir
    public void compra(Compra compra) {
        //Comandos do banco
        String sql = "INSERT INTO compras"
                + "(numero,fornecedor,condicao,usuario,data,valor) VALUES "
                + "(?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, compra.getNumero());
            p.setInt(2, compra.getFornecedor());
            p.setInt(3, compra.getCondicao());
            p.setInt(4, compra.getUsuario());
            p.setDate(5, compra.getData());
            p.setFloat(6, compra.getValor());            

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Alterar
    @Override
    public void alterar(Compra compra) {
        //Comando do banco
        try {
            String sql = "UPDATE compras"
                    + " SET numero = ?, fornecedor = ?, condicao = ?, usuario = ?,data = ?, valor = ?"
                    + " WHERE codigo = ?";
            //Setando valores
            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, compra.getNumero());
            p.setInt(2, compra.getFornecedor());
            p.setInt(3, compra.getCondicao());
            p.setInt(4, compra.getUsuario());
            p.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            p.setFloat(6, compra.getValor());
            p.setInt(7, compra.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Listar
    @Override
    public List<Compra> listarCompras() {
        //Lista 
        List<Compra> compras = new ArrayList<Compra>();
        //Comando do banco
        try {
            String sql = "SELECT * FROM compras";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Compra compra = new Compra();
                //Setando valores
                int codigo = rs.getInt("codigo");
                int numero = rs.getInt("numero");  
                int fornecedor = rs.getInt("fornecedor"); 
                int condicao = rs.getInt("condicao");  
                int usuario = rs.getInt("usuario");  
                Date data = rs.getDate("data");
                int valor = rs.getInt("valor");                                           
                
                compra.setCodigo(codigo);
                compra.setNumero(numero); 
                compra.setFornecedor(fornecedor); 
                compra.setCondicao(condicao); 
                compra.setUsuario(usuario); 
                compra.setData(data);
                compra.setValor(valor);                                                

                compras.add(compra);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return compras;
    }
    //Selecionar
    @Override
    public Compra selecionar(int codigo) {
        //Criando o objetco compra
        Compra compra = new Compra();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM compras WHERE codigo= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            //Setando valores
            compra.setCodigo(codigo);
            compra.setNumero(rs.getInt("numero"));
            compra.setFornecedor(rs.getInt("fornecedor"));
            compra.setCondicao(rs.getInt("condicao"));
            compra.setUsuario(rs.getInt("usuario"));
            compra.setData(rs.getDate("data"));
            compra.setValor(rs.getInt("valor"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return compra;

    }
    //Remover
    @Override
    public Compra Remove(int codigo) {

        String sql = "DELETE FROM compras WHERE codigo=?";

        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, codigo);

            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void inserir(Compra compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}