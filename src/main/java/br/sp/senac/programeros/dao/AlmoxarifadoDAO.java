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
    @Override
    public void inserir(Almoxarifado almoxarifado) {
        String sql = "insert into almoxarifados "
                + "(descricao, filial_codigo, ativo, deletado) values"
                + "(?,?,?,'')";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, almoxarifado.getDescricao());
            p.setInt(2, almoxarifado.getFilial());            
            p.setString(3, "S");
            
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlmoxarifadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterar(Almoxarifado almoxarifado) {

        try {
            String sql = "update almoxarifados "
                    + " set descricao = ?, filial_codigo = ?, ativo = ?"
                    + " where codigo = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, almoxarifado.getDescricao());
            p.setInt(2, almoxarifado.getFilial()); 
            p.setString(3, String.valueOf(almoxarifado.getAtivo()));
            p.setInt(4, almoxarifado.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlmoxarifadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public List<Almoxarifado> listarAlmoxarifados() {
        List<Almoxarifado> almoxarifados = new ArrayList<Almoxarifado>();

        try {
            String sql = "select * from almoxarifados WHERE deletado <> '*'";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Almoxarifado almoxarifado = new Almoxarifado();

                int codigo = rs.getInt("codigo");
                String descricao = rs.getString("descricao");
                int unidade = rs.getInt("filial_codigo");
                String ativo = rs.getString("ativo");
                
                almoxarifado.setCodigo(codigo);
                almoxarifado.setDescricao(descricao);
                almoxarifado.setFilial(unidade);                
                almoxarifado.setAtivo(ativo);
                
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

        String sql = "select * from almoxarifados WHERE deletado <> '*' AND codigo= "+codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            almoxarifado.setCodigo(codigo);
            almoxarifado.setDescricao(rs.getString("descricao"));
            almoxarifado.setFilial(rs.getInt("filial_codigo"));
            almoxarifado.setAtivo(rs.getString("ativo"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return almoxarifado;

    }

    @Override
    public Almoxarifado Remove(int codigo) {

        String sql = "update almoxarifado set deletado = '*' WHERE codigo=?";

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
//    public void inserir(Almoxarifado almoxarifado) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
