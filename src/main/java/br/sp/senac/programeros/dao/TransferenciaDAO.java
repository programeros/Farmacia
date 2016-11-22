package br.sp.senac.programeros.dao;

/**
 * @author Michael Facul
 */
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
    Connection conexao;

    public TransferenciaDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void transferencia(Transferencia transferencia) {
        String sql = "INSERT INTO transferencias"
                + "(data, produto, origem, destino, quantidate, usuario) VALUES "
                + "(?,?,?,?,?,?)";
        PreparedStatement p;
        try {
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
    @Override
    public void alterar(Transferencia tranferencia) {

        try {
            String sql = "UPDATE tranferencias"
                    + " SET data = ?, produto = ?, origem = ?, destino = ?,quantidade = ?, usuario = ?"
                    + " WHERE chave = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            p.setInt(2, tranferencia.getProduto());
            p.setInt(3, tranferencia.getOrigem());
            p.setInt(4, tranferencia.getDestino());                      
            p.setFloat(5, tranferencia.getQuantidade());  
            p.setInt(6, tranferencia.getUsuario());
            p.setInt(7, tranferencia.getChave());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(TransferenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Transferencia> listarMovimentos() {
        List<Transferencia> movimentos = new ArrayList<Transferencia>();

        try {
            String sql = "SELECT * FROM transferencias";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Transferencia movimento = new Transferencia();

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

    @Override
    public Transferencia selecionar(int id) {

        Transferencia movimento = new Transferencia();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM transferencias WHERE chave = " + id;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

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

    @Override
    public Transferencia Remove(int codigo) {

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

    @Override
    public void inserir(Transferencia movimento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
