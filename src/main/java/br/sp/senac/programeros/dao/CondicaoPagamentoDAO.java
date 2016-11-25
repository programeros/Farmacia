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
import br.sp.senac.programeros.model.CondicaoPagamento;
import java.sql.Date;

public class CondicaoPagamentoDAO implements br.sp.senac.programeros.interfaces.CondicaoPagamentoInterface {

    //Conexao Banco
    Connection conexao;

    //Construtor 
    public CondicaoPagamentoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir

    public void CondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        //Comando do banco
        String sql = "INSERT INTO condicaopagamento"
                + "(descricao,condicao,ativo, deletado) VALUES "
                + "(?,?,?,'')";
        PreparedStatement p;
        try {
            //Setando os valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, condicaoPagamento.getDescricao());
            p.setString(2, condicaoPagamento.getCondicao());
            p.setString(3, "S");

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CondicaoPagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Alterar
    @Override
    public void alterar(CondicaoPagamento condicaoPagamento) {

        try {
            //Comando do banco
            String sql = "UPDATE condicaopagamento"
                    + " SET descricao = ?, condicao = ?, ativo = ?"
                    + " WHERE codigo = ?";
            //Setando os valores
            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, condicaoPagamento.getDescricao());
            p.setString(2, condicaoPagamento.getCondicao());
            p.setString(3, condicaoPagamento.getAtivo());
            p.setInt(4, condicaoPagamento.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CondicaoPagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Listar 
    @Override
    public List<CondicaoPagamento> listarCondicaoPagametos() {
        //Lista
        List<CondicaoPagamento> condicaoPagamentos = new ArrayList<CondicaoPagamento>();
        //Comando do banco
        try {
            String sql = "SELECT * FROM condicaopagamento WHERE deletado <> '*'";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //Setando os valores
            while (rs.next()) {
                CondicaoPagamento condicaoPagamento = new CondicaoPagamento();

                int codigo = rs.getInt("codigo");
                String descricao = rs.getString("descricao");
                String condicao = rs.getString("condicao");
                String ativo = rs.getString("ativo");
                String deletado = rs.getString("deletado");

                condicaoPagamento.setCodigo(codigo);
                condicaoPagamento.setDescricao(descricao);
                condicaoPagamento.setCondicao(condicao);
                condicaoPagamento.setAtivo(ativo);
                condicaoPagamento.setDeletado(deletado);

                condicaoPagamentos.add(condicaoPagamento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return condicaoPagamentos;
    }
    //Selecionar
    @Override
    public CondicaoPagamento selecionar(int codigo) {
        //Criando o objeto condicapagamento  
        CondicaoPagamento condicapagamento = new CondicaoPagamento();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM condicaopagamento WHERE deletado <> '*' AND codigo= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            //Setando os valores
            condicapagamento.setCodigo(codigo);
            condicapagamento.setDescricao(rs.getString("descricao"));
            condicapagamento.setCondicao(rs.getString("condicao"));
            condicapagamento.setAtivo(rs.getString("ativo"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return condicapagamento;

    }

    //Remove
    @Override
    public CondicaoPagamento Remove(int codigo) {
        //Comando do banco
        String sql = "UPDATE condicaopagamento set deletado = '*' WHERE codigo = ?";

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
    @Override
    public void inserir(CondicaoPagamento condicaoPagamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
