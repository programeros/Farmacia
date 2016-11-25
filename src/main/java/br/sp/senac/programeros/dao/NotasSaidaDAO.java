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
import br.sp.senac.programeros.model.Notassaida;
import java.sql.Date;

public class NotasSaidaDAO implements br.sp.senac.programeros.interfaces.NotasSaidaInterface {

    //Conexao do banco
    Connection conexao;

    //Construtor
    public NotasSaidaDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir
    public void NotasSaida(Notassaida notasS) {
        //Comando do banco
        String sql = "insert into notassaida "
                + "(serie, numero, pedido, valor, data, vencimento, parcelas, usuario)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, notasS.getSerie());
            p.setString(2, notasS.getNumero());
            p.setInt(3, notasS.getPedido());
            p.setFloat(4, notasS.getValor());
            p.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            p.setDate(6, (Date) notasS.getVencimento());
            p.setInt(7, notasS.getParcelas());
            p.setInt(8, notasS.getUsuario());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(NotasSaidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Alterar
    @Override
    public void alterar(Notassaida notasS) {

        try {
            //Comando do banco
            String sql = "UPDATE notassaida "
                    + " SET serie = ?, numero = ?, pedido = ?, valor = ?, "
                    + " data = ?, vencimento = ?, parcelas = ?, usuario = ? "
                    + " WHERE codigo = ?";
            
            PreparedStatement p;
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, notasS.getSerie());
            p.setString(2, notasS.getNumero());
            p.setInt(3, notasS.getPedido());
            p.setFloat(4, notasS.getValor());
            p.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            p.setDate(6, (Date) notasS.getVencimento());
            p.setInt(7, notasS.getParcelas());
            p.setInt(8, notasS.getUsuario());
            p.setInt(9, notasS.getChave());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(NotasSaidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Listar
    @Override
    public List<Notassaida> listarNotassaida() {
        //Lista
        List<Notassaida> notassS = new ArrayList<Notassaida>();

        try {
            //Comando do banco
            String sql = "SELECT * FROM notassaida";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Notassaida notass = new Notassaida();
                //Setando valores
                int chave = rs.getInt("chave");
                String serie = rs.getString("serie");
                String numero = rs.getString("numero");
                int pedido = rs.getInt("pedido");
                float valor = rs.getFloat("valor");
                Date data = rs.getDate("data");
                Date vencimento = rs.getDate("vencimento");
                int parcelas = rs.getInt("parcelas");
                int usuario = rs.getInt("usuario");

                notass.setChave(chave);
                notass.setSerie(serie);
                notass.setNumero(numero);
                notass.setPedido(pedido);
                notass.setValor(valor);
                notass.setData(data);
                notass.setVencimento(vencimento);
                notass.setParcelas(parcelas);
                notass.setUsuario(usuario);

                notassS.add(notass);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return notassS;
    }
    //Selecionar
    @Override
    public Notassaida selecionar(int chave) {
        //Criando o objeto notass
        Notassaida notass = new Notassaida();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM notassaida WHERE chave = " + chave;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            //Setando valores
            notass.setChave(chave);
            notass.setSerie(rs.getString("serie"));
            notass.setNumero(rs.getString("numero"));
            notass.setPedido(rs.getInt("pedido"));
            notass.setValor(rs.getFloat("valor"));
            notass.setData(rs.getDate("data"));
            notass.setVencimento(rs.getDate("vencimento"));
            notass.setParcelas(rs.getInt("parcelas"));
            notass.setUsuario(rs.getInt("usuario"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return notass;
    }
    //Remover
    @Override
    public Notassaida Remove(int codigo) {
        //Comando do banco
        String sql = "UPDATE notassaida WHERE chave = ?";

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
    public void inserir(Notassaida notassaida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
