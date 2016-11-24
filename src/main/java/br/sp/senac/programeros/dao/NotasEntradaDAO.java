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
import br.sp.senac.programeros.model.Notasentrada;
import java.sql.Date;

public class NotasEntradaDAO implements br.sp.senac.programeros.interfaces.NotasEntradaInterface {

     Connection conexao;

    public NotasEntradaDAO(Connection conexao) {
        this.conexao = conexao;
    }
   
    public void NotasEntrada(Notasentrada notasEntrada) {
        String sql = "insert into notasentrada "
                + "(serie, numero, pedido, valor, data, vencimento, parcelas, usuario)"
                + " VALUES (?,?,?,?,?,?,?,?)";              
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, notasEntrada.getSerie());
            p.setString(2, notasEntrada.getNumero());
            p.setInt(3, notasEntrada.getPedido());
            p.setFloat(4, notasEntrada.getValor());
            p.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            p.setDate(6, (Date) notasEntrada.getVencimento());
            p.setInt(7, notasEntrada.getParcelas());   
            p.setInt(8, notasEntrada.getUsuario());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(NotasEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterar(Notasentrada notasEntrada) {

        try {
            String sql = "UPDATE notasentrada "
                    + " SET serie = ?, numero = ?, pedido = ?, valor = ?, "
                    + " data = ?, vencimento = ?, parcelas = ?, usuario = ? "                   
                    + " WHERE codigo = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, notasEntrada.getSerie());
            p.setString(2, notasEntrada.getNumero());
            p.setInt(3, notasEntrada.getPedido());
            p.setFloat(4, notasEntrada.getValor());
            p.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            p.setDate(6, (Date) notasEntrada.getVencimento());
            p.setInt(7, notasEntrada.getParcelas());   
            p.setInt(8, notasEntrada.getUsuario());
            p.setInt(9, notasEntrada.getChave());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(NotasEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Notasentrada> listarNotasentrada() {
        List<Notasentrada> notaseS = new ArrayList<Notasentrada>();

        try {
            String sql = "SELECT * FROM notasentrada";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Notasentrada notase = new Notasentrada();

                int chave = rs.getInt("chave");
                String serie = rs.getString("serie");
                String numero = rs.getString("numero");
                int pedido = rs.getInt("pedido");
                float valor = rs.getFloat("valor");
                Date data = rs.getDate("data");
                Date vencimento = rs.getDate("vencimento");
                int parcelas = rs.getInt("parcelas");
                int usuario = rs.getInt("usuario");                             

                notase.setChave(chave);
                notase.setSerie(serie);
                notase.setNumero(numero);
                notase.setPedido(pedido);
                notase.setValor(valor);
                notase.setData(data);
                notase.setVencimento(vencimento);
                notase.setParcelas(parcelas);
                notase.setUsuario(usuario);
                               
                notaseS.add(notase);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return notaseS;
    }

    @Override
    public Notasentrada selecionar(int chave) {

        Notasentrada notase = new Notasentrada();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM notasentrada WHERE chave = "+chave;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            notase.setChave(chave);
            notase.setSerie(rs.getString("serie"));
            notase.setNumero(rs.getString("numero"));
            notase.setPedido(rs.getInt("pedido"));
            notase.setValor(rs.getFloat("valor"));
            notase.setData(rs.getDate("data"));
            notase.setVencimento(rs.getDate("vencimento"));
            notase.setParcelas(rs.getInt("parcelas"));
            notase.setUsuario(rs.getInt("usuario"));
                       
        } catch (Exception e) {
            e.printStackTrace();
        }

        return notase;

    }

    @Override
    public Notasentrada Remove(int codigo) {

        String sql = "UPDATE notasentrada WHERE chave = ?";

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
    public void inserir(Notasentrada notasentrada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

