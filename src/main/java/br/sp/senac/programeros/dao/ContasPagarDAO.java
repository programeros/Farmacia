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
import br.sp.senac.programeros.model.ContasPagar;
import java.sql.Date;

public class ContasPagarDAO implements br.sp.senac.programeros.interfaces.ContasPagarInterface {

    //Conexao Banco
    Connection conexao;

    //Construtor 
    public ContasPagarDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir

    public void ContasPagar(ContasPagar contasPagar) {
        //Comando do banco
        String sql = "INSERT INTO contaspagar"
                + "(serie,titulo,parecela,fornecedor,dada_emissao,valor,valor_baixado,pedido,notasentrada_chave,baixa,usuario) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            //Setando os valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, contasPagar.getSerie());
            p.setString(2, contasPagar.getTitulo());
            p.setString(3, contasPagar.getParcela());
            p.setInt(4, contasPagar.getFornecedor());
            p.setDate(5, new java.sql.Date(System.currentTimeMillis())); 
            p.setFloat(6, contasPagar.getValor());
            p.setFloat(7, contasPagar.getValorBaixado());
            p.setInt(8, contasPagar.getPedido());
            p.setInt(9, contasPagar.getNotasEntrada());
            p.setDate(10, (Date) contasPagar.getDataBaixa()); 
            p.setInt(11, contasPagar.getUsuario());
            

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Alterar
    @Override
    public void alterar(ContasPagar contasPagar) {

        try {
            //Comando do banco
            String sql = "UPDATE contaspagar"
                    + " SET serie = ?, titulo = ?, parecela = ?, fornecedor = ?, dada_emissao = ?,"
                    + "valor = ?, valor_baixado = ?, pedido = ?, notasentrada_chave = ?, baixa = ?, usuario = ?"
                    + " WHERE chave = ?";
            //Setando os valores
            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, contasPagar.getSerie());
            p.setString(2, contasPagar.getTitulo());
            p.setString(3, contasPagar.getParcela());
            p.setInt(4, contasPagar.getFornecedor());
            p.setDate(5, new java.sql.Date(System.currentTimeMillis())); 
            p.setFloat(6, contasPagar.getValor());
            p.setFloat(7, contasPagar.getValorBaixado());
            p.setInt(8, contasPagar.getPedido());
            p.setInt(9, contasPagar.getNotasEntrada());
            p.setDate(10, (Date) contasPagar.getDataBaixa());
            p.setInt(11, contasPagar.getUsuario());
            p.setInt(12, contasPagar.getChave());
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Listar 
    @Override
    public List<ContasPagar> listarContasPagar() {
        //Lista
        List<ContasPagar> contasPagar = new ArrayList<ContasPagar>();
        //Comando do banco
        try {
            String sql = "SELECT * FROM contaspagar";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //Setando os valores
            while (rs.next()) {
                ContasPagar contaPagar = new ContasPagar();

                int chave = rs.getInt("chave");
                String serie = rs.getString("serie");
                String titulo = rs.getString("titulo");
                String parcela = rs.getString("parcela");
                int fornecedor = rs.getInt("fornecedor");
                Date dataEmissao = rs.getDate("data_emissao");
                Float valor = rs.getFloat("valor");
                Float valorBaixado = rs.getFloat("valor_baixado");
                int pedido = rs.getInt("pedido");
                int notasEntrada = rs.getInt("notasentrada_chave");
                Date dataBaixa = rs.getDate("baixa");
                int usuario = rs.getInt("usuario");                

                contaPagar.setChave(chave);
                contaPagar.setSerie(serie);
                contaPagar.setTitulo(titulo);
                contaPagar.setParcela(parcela);
                contaPagar.setFornecedor(fornecedor);
                contaPagar.setDataEmissao(dataEmissao);
                contaPagar.setValor(valor);
                contaPagar.setValorBaixado(valorBaixado);
                contaPagar.setPedido(pedido);
                contaPagar.setNotasEntrada(notasEntrada);
                contaPagar.setDataBaixa(dataBaixa);
                contaPagar.setUsuario(usuario);

                contasPagar.add(contaPagar);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return contasPagar;
    }

    @Override
    public ContasPagar selecionar(int chave) {
        //Criando o objeto cotnas pagar  
        ContasPagar contasPagar = new ContasPagar();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM contaspagar WHERE chave= " + chave;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            //Setando os valores
                contasPagar.setChave(chave);                
                contasPagar.setSerie(rs.getString("serie"));
                contasPagar.setTitulo(rs.getString("titulo"));
                contasPagar.setParcela(rs.getString("parcela"));
                contasPagar.setFornecedor(rs.getInt("fornecedor"));
                contasPagar.setDataEmissao(rs.getDate("data_emissao"));
                contasPagar.setValor(rs.getFloat("valor"));
                contasPagar.setValorBaixado(rs.getFloat("valor_baixado"));
                contasPagar.setPedido(rs.getInt("pedido"));
                contasPagar.setNotasEntrada(rs.getInt("notasentrada_chave"));
                contasPagar.setDataBaixa(rs.getDate("baixa"));
                contasPagar.setUsuario(rs.getInt("usuario"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contasPagar;

    }

    //Remove
    @Override
    public ContasPagar Remove(int codigo) {
        //Comando do banco
        String sql = "DELETE contaspagar WHERE chave = ?";

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
    public void inserir(ContasPagar contasPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
