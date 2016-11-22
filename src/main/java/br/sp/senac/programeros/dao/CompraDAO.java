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
import br.sp.senac.programeros.model.Compra;
import java.sql.Date;

public class CompraDAO implements br.sp.senac.programeros.interfaces.CompraInterface {
    Connection conexao;

    public CompraDAO(Connection conexao) {
        this.conexao = conexao;
    }
    public void compra(Compra compra) {
        String sql = "INSERT INTO compras"
                + "(numero,fornecedor,condicao,usuario,data,valor) VALUES "
                + "(?,?,?,?,?,?)";
        PreparedStatement p;
        try {
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
    @Override
    public void alterar(Compra compra) {

        try {
            String sql = "UPDATE compras"
                    + " SET numero = ?, fornecedor = ?, condicao = ?, usuario = ?,data = ?, valor = ?"
                    + " WHERE codigo = ?";

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

    @Override
    public List<Compra> listarCompras() {
        List<Compra> compras = new ArrayList<Compra>();

        try {
            String sql = "SELECT * FROM compras";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Compra compra = new Compra();

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

    @Override
    public Compra selecionar(int codigo) {

        Compra compra = new Compra();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM compras WHERE codigo= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

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