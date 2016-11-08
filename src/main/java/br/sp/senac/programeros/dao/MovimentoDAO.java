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
import br.sp.senac.programeros.model.Movimento;
import java.sql.Date;

public class MovimentoDAO implements br.sp.senac.programeros.interfaces.MovimentoInterface {
    Connection conexao;

    public MovimentoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    public void venda(Movimento movimento) {
        String sql = "INSERT INTO movimentos"
                + "(data, quantidade) VALUES "
                + "(?,?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setDate(1, movimento.getData());
            p.setFloat(2, movimento.getQuantidade());            

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MovimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public void alterar(Movimento movimento) {

        try {
            String sql = "UPDATE movimentos"
                    + " SET data = ?, quantidade = ?"
                    + " WHERE codigo = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            p.setFloat(2, movimento.getQuantidade());            
            p.setInt(3, movimento.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MovimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Movimento> listarMovimentos() {
        List<Movimento> movimentos = new ArrayList<Movimento>();

        try {
            String sql = "SELECT * FROM movimentos";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Movimento movimento = new Movimento();

                int codigo = rs.getInt("codigo");
                Date data = rs.getDate("data");
                String produto = rs.getString("produto");
                int almoxarifado_o = rs.getInt("almoxarifado_origem");                                
                int almoxarifado_d = rs.getInt("almoxarifado_destino");
                float quantidade = rs.getFloat("quantidade");
                
                movimento.setCodigo(codigo);
                movimento.setData(data);
                movimento.setProduto(produto);
                movimento.setAlmoxarifadoOrigem(almoxarifado_o);
                movimento.setAlmoxarifadoDestino(almoxarifado_d);                
                movimento.setQuantidade(quantidade);                

                movimentos.add(movimento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movimentos;
    }

    @Override
    public Movimento selecionar(int codigo) {

        Movimento movimento = new Movimento();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM movimentos WHERE codigo= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            movimento.setCodigo(codigo);
            movimento.setData(rs.getDate("data"));
            movimento.setProduto(rs.getString("produto"));
            movimento.setAlmoxarifadoOrigem(rs.getInt("almoxarifado_origem"));
            movimento.setAlmoxarifadoDestino(rs.getInt("almoxarifado_destino"));            
            movimento.setQuantidade(rs.getFloat("quantidade"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movimento;

    }

    @Override
    public Movimento Remove(int codigo) {

        String sql = "DELETE FROM movimentos WHERE codigo=?";

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
    public void inserir(Movimento movimento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
