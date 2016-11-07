package br.sp.senac.programeros.dao;

/**
 *
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
import br.sp.senac.programeros.model.Venda;
import java.sql.Date;

public class VendaDAO implements br.sp.senac.programeros.interfaces.VendaInterface {
    Connection conexao;

    public VendaDAO(Connection conexao) {
        this.conexao = conexao;
    }
    public void venda(Venda venda) {
        String sql = "INSERT INTO vendas"
                + "(data, quantidade) VALUES "
                + "(?,?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setDate(1, venda.getData());
            p.setFloat(2, venda.getQuantidade());            

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public void alterar(Venda venda) {

        try {
            String sql = "UPDATE vendas"
                    + " SET data = ?, quantidade = ?"
                    + " WHERE codigo = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            p.setFloat(2, venda.getQuantidade());            
            p.setInt(3, venda.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Venda> listarVendas() {
        List<Venda> vendas = new ArrayList<Venda>();

        try {
            String sql = "SELECT * FROM vendas";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Venda venda = new Venda();

                int codigo = rs.getInt("codigo");
                Date data = rs.getDate("data");
                int cliente = rs.getInt("cliente_codigo");
                int vendedor = rs.getInt("vendedor_codigo");                
                String produto = rs.getString("produto");
                int almoxarifado = rs.getInt("almoxarifado");
                float quantidade = rs.getFloat("quantidade");
                
                venda.setCodigo(codigo);
                venda.setData(data);
                venda.setCliente(cliente);
                venda.setVendedor(vendedor);
                venda.setProduto(produto);
                venda.setAlmoxarifado(almoxarifado);
                venda.setQuantidade(quantidade);                

                vendas.add(venda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendas;
    }

    @Override
    public Venda selecionar(int codigo) {

        Venda venda = new Venda();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM vendas WHERE codigo= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            venda.setCodigo(codigo);
            venda.setData(rs.getDate("data"));
            venda.setCliente(rs.getInt("cliente_codigo"));
            venda.setVendedor(rs.getInt("vendedor_codigo"));
            venda.setProduto(rs.getString("produto"));
            venda.setAlmoxarifado(rs.getInt("almoxarifado"));
            venda.setQuantidade(rs.getFloat("quantidade"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return venda;

    }

    @Override
    public Venda Remove(int codigo) {

        String sql = "DELETE FROM vendas WHERE codigo=?";

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
    public void inserir(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}