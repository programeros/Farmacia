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
                + "(data, quantidade) VALUES "
                + "(?,?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setDate(1, compra.getData());
            p.setFloat(2, compra.getQuantidade());            

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public void alterar(Compra compra) {

        try {
            String sql = "UPDATE compras"
                    + " SET data = ?, quantidade = ?"
                    + " WHERE codigo = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            p.setFloat(2, compra.getQuantidade());            
            p.setInt(3, compra.getCodigo());

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
                Date data = rs.getDate("data");
                int fornecedor = rs.getInt("fornecedor_codigo");                           
                String produto = rs.getString("produto");
                int almoxarifado = rs.getInt("almoxarifado");
                float quantidade = rs.getFloat("quantidade");
                
                compra.setCodigo(codigo);
                compra.setData(data);
                compra.setFornecedor(fornecedor);                
                compra.setProduto(produto);
                compra.setAlmoxarifado(almoxarifado);
                compra.setQuantidade(quantidade);                

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
            compra.setData(rs.getDate("data"));
            compra.setFornecedor(rs.getInt("fornecedor_codigo"));            
            compra.setProduto(rs.getString("produto"));
            compra.setAlmoxarifado(rs.getInt("almoxarifado"));
            compra.setQuantidade(rs.getFloat("quantidade"));
            
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