package br.sp.senac.programeros.dao;

import br.sp.senac.programeros.connection.ControleNumeracao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.sp.senac.programeros.model.Venda;
import br.sp.senac.programeros.model.VendaItem;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO implements br.sp.senac.programeros.interfaces.VendaInterface {
    //Conexao do banco
    Connection conexao;
    //Construtor
    public VendaDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir Cabecalho
    @Override
    public void inserirVenda(Venda venda) {
        //Comando do banco
        String sql = "insert into venda "
                + " (numero,cliente,condicao,desconto,vendedor)"
                + " VALUES (?, ?, ?, ?, ?)";

        PreparedStatement p;

        ControleNumeracao number = new ControleNumeracao(conexao);
        int numped = number.forneceNumero("vendas");

        try {
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, numped);
            p.setInt(2, venda.getCliente());
            p.setInt(3, venda.getCondicao());
            p.setFloat(4, venda.getDesconto());
            p.setInt(5, venda.getVendedor());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        inserirItens(numped);
    }
    //Inserir Item
    @Override
    public void inserirItens(int pedido) {
        //Comando do banco
        String sql = "insert into vendas_itens "
                + " (pedido,item,produto,almoxarifado,preco,quantidade,valor,"
                + " desconto,quantidade_entregue)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement p;

        try {
            VendaItem v = new VendaItem();

            p = this.conexao.prepareStatement(sql);
            //Setando valores
            p.setInt(1, pedido);
            p.setInt(2, v.getItem());
            p.setInt(3, v.getProduto());
            p.setInt(4, v.getAlmoxarifado());
            p.setFloat(5, v.getPreco());
            p.setFloat(6, v.getQuantidade());
            p.setFloat(7, v.getValor());
            p.setFloat(8, v.getDesconto());
            p.setFloat(9, v.getQuantidade_entregue());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Remover
    @Override
    public Venda RemoverVenda(int pedido) {
        //Remove o cabeçalho do pedido da tabela
        String sql = "DELETE FROM vendas WHERE pedido=?";

        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, pedido);

            p.execute();

        } catch (SQLException e) {
        }

        //Remove os itens do pedido da tabela
        String sql2 = "DELETE FROM vendas_itens WHERE pedido=?";

        try {
            p = this.conexao.prepareStatement(sql2);
            p.setInt(1, pedido);

            p.execute();

        } catch (SQLException e) {
        }

        return null;
    }
    //Listar
    @Override
    public List<Venda> listarPedidos() {
        //Lista
        List<Venda> vendas = new ArrayList<>();

        try {
            //Comando do banco
            String sql = "SELECT v.numero, v.cliente, c.nome, v.data, v.valor "
                    + " FROM venda v "
                    + " JOIN cliente c "
                    + " ON c.codigo = v.cliente ";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Venda venda = new Venda();
                //Setando valores
                int numero = rs.getInt("numero");
                int cliente = rs.getInt("cliente");
                String nome = rs.getString("nome");
                Date data = rs.getDate("data");
                float valor = rs.getFloat("valor");

                venda.setNumero(numero);
                venda.setCliente(cliente);
                venda.setNome(nome);
                venda.setData(data);
                venda.setValor(valor);

                vendas.add(venda);
            }

        } catch (SQLException e) {
        }
        return vendas;
    }

}
