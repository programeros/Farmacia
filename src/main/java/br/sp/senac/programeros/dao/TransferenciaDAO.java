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
import br.sp.senac.programeros.model.Transferencia;
import java.sql.Date;

public class TransferenciaDAO implements br.sp.senac.programeros.interfaces.TransferenciaInterface {
    //Conexao do banco
    Connection conexao;
    //Construtor
    public TransferenciaDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir
    @Override
    public void inserir(Transferencia transferencia) {
        //Comando do banco
        String sql = "INSERT INTO transferencias"
                + "(data, produto, origem, destino, quantidade, usuario) VALUES "
                + "(?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setDate(1, new java.sql.Date(System.currentTimeMillis()));  
            p.setInt(2, transferencia.getProduto());
            p.setInt(3, transferencia.getOrigem());
            p.setInt(4, transferencia.getDestino());            
            p.setFloat(5, transferencia.getQuantidade());            
            p.setInt(6, transferencia.getUsuario());
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(TransferenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Alterar
    @Override
    public void alterar(Transferencia tranferencia) {

        try {
            //Comando do banco
            String sql = "UPDATE tranferencias"
                    + " SET produto = ?, origem = ?, destino = ?,quantidade = ?, usuario = ?"
                    + " WHERE chave = ?";

            PreparedStatement p;
            //Setando valores
            p = this.conexao.prepareStatement(sql);            
            p.setInt(1, tranferencia.getProduto());
            p.setInt(2, tranferencia.getOrigem());
            p.setInt(3, tranferencia.getDestino());                      
            p.setFloat(4, tranferencia.getQuantidade());  
            p.setInt(5, tranferencia.getUsuario());
            p.setInt(6, tranferencia.getChave());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(TransferenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Listar
    @Override
    public List<Transferencia> listarMovimentos() {
        //Lista
        List<Transferencia> movimentos = new ArrayList<Transferencia>();

        try {
            //Comando do banco
            String sql = "SELECT * FROM transferencias";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Transferencia movimento = new Transferencia();
                //Setando valores
                int chave = rs.getInt("chave");
                Date data = rs.getDate("data");
                int produto = rs.getInt("produto");
                int origem = rs.getInt("origem");                                
                int destino = rs.getInt("destino");
                float quantidade = rs.getFloat("quantidade");
                int usuario = rs.getInt("usuario");
                
                movimento.setChave(chave);
                movimento.setData(data);
                movimento.setProduto(produto);
                movimento.setOrigem(origem);
                movimento.setDestino(destino);                
                movimento.setQuantidade(quantidade);                
                movimento.setUsuario(usuario); 
                
                movimentos.add(movimento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movimentos;
    }
    //Selecionar
    @Override
    public Transferencia selecionar(int id) {
        //Criando o objeto movimento
        Transferencia movimento = new Transferencia();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM transferencias WHERE chave = " + id;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            //Setando valores
            movimento.setChave(id);
            movimento.setData(rs.getDate("data"));
            movimento.setProduto(rs.getInt("produto"));
            movimento.setOrigem(rs.getInt("origem"));
            movimento.setDestino(rs.getInt("destino"));            
            movimento.setQuantidade(rs.getFloat("quantidade"));
            movimento.setUsuario(rs.getInt("usuario")); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movimento;

    }
    //Remvoer
    @Override
    public Transferencia Remove(int codigo) {
        //Comando do banco
        String sql = "DELETE FROM transferencias WHERE chave=?";

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

//    @Override
//    public void inserir(Transferencia movimento) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
