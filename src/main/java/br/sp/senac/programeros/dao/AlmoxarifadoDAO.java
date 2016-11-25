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
import br.sp.senac.programeros.model.Almoxarifado;

public class AlmoxarifadoDAO implements br.sp.senac.programeros.interfaces.AlmoxarifadoInterface {
    //Conexao Banco
    Connection conexao;
    //Construtor
    public AlmoxarifadoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir
    @Override
    public void inserir(Almoxarifado almoxarifado) {
        //Comando do banco
        String sql = "insert into almoxarifados "
                + "(descricao, filial_codigo, ativo, deletado) values"
                + "(?,?,?,'')";
        PreparedStatement p;
        try {
            //Setando Valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, almoxarifado.getDescricao());
            p.setInt(2, almoxarifado.getFilial());            
            p.setString(3, "S");
            
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlmoxarifadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Alterar
    @Override
    public void alterar(Almoxarifado almoxarifado) {
        //Comando do banco
        try {
            String sql = "update almoxarifados "
                    + " set descricao = ?, filial_codigo = ?, ativo = ?"
                    + " where codigo = ?";
            //Setando Valores
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

   //Listar
    @Override
    public List<Almoxarifado> listarAlmoxarifados() {
        //Lista
        List<Almoxarifado> almoxarifados = new ArrayList<Almoxarifado>();
        //Comando do banco
        try {
            String sql = "select * from almoxarifados WHERE deletado <> '*'";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //Setando os valores
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
    //Selecionar
    @Override
    public Almoxarifado selecionar(int codigo) {
    //Criando o objeto almoxarifado  
        Almoxarifado almoxarifado = new Almoxarifado();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "select * from almoxarifados WHERE deletado <> '*' AND codigo= "+codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
    //Setando os valores
            almoxarifado.setCodigo(codigo);
            almoxarifado.setDescricao(rs.getString("descricao"));
            almoxarifado.setFilial(rs.getInt("filial_codigo"));
            almoxarifado.setAtivo(rs.getString("ativo"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return almoxarifado;

    }
    //Remove
    @Override
    public Almoxarifado Remove(int codigo) {
        //Comando do banco
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
//Inserir
//    @Override
//    public void inserir(Almoxarifado almoxarifado) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
