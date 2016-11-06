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
import br.sp.senac.programeros.model.Almoxarifado;

public class AlmoxarifadoDAO implements br.sp.senac.programeros.interfaces.AlmoxarifadoInterface {

    Connection conexao;

    public AlmoxarifadoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    public void almoxarifado(Almoxarifado almoxarifado) {
        String sql = "insert into almoxarifados "
                + "(descricao, unidades_codigo) values"
                + "(?,?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, almoxarifado.getDescricao());
            p.setInt(2, almoxarifado.getUnidade());            

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlmoxarifadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterar(Almoxarifado almoxarifado) {

        try {
            String sql = "update almoxarifados "
                    + " set descricao = ?, unidades_codigo = ?"
                    + " where codigo = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, almoxarifado.getDescricao());
            p.setInt(2, almoxarifado.getUnidade());           
            p.setInt(3, almoxarifado.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlmoxarifadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public List<Almoxarifado> listarAlmoxarifados() {
        List<Almoxarifado> almoxarifados = new ArrayList<Almoxarifado>();

        try {
            String sql = "select * from almoxarifados";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Almoxarifado almoxarifado = new Almoxarifado();

                int codigo = rs.getInt("codigo");
                String descricao = rs.getString("descricao");
                int unidade = rs.getInt("unidades_codigo");
                
                almoxarifado.setCodigo(codigo);
                almoxarifado.setDescricao(descricao);
                almoxarifado.setUnidade(unidade);                

                almoxarifados.add(almoxarifado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return almoxarifados;
    }

    @Override
    public Almoxarifado selecionar(int codigo) {

        Almoxarifado almoxarifado = new Almoxarifado();
        ConexaoBD conn = new ConexaoBD();

        String sql = "select * from almoxarifados where codigo= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            almoxarifado.setCodigo(codigo);
            almoxarifado.setDescricao(rs.getString("descricao"));
            almoxarifado.setUnidade(rs.getInt("unidades_codigo"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return almoxarifado;

    }

    @Override
    public Almoxarifado Remove(int codigo) {

        String sql = "delete from almoxarifado where codigo = ?";

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
    public void inserir(Almoxarifado almoxarifado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
