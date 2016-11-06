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
import br.sp.senac.programeros.model.Cliente;
import java.sql.Date;

public class ClienteDAO implements br.sp.senac.programeros.interfaces.ClienteInterface {

    Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cliente(Cliente cliente) {
        String sql = "INSERT INTO CLIENTES "
                + "(NOME, ENDERECO, BAIRRO, CIDADE,ESTADO,CEP,SEXO,TELEFONE,CELULAR,"
                + "CADASTRO,CONVENIOS_CODIGO,ATIVO) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setString(3, cliente.getBairro());
            p.setString(4, cliente.getCidade());
            p.setString(5, cliente.getEstado());
            p.setString(6, cliente.getCep());
            p.setString(7, String.valueOf(cliente.getSexo()));
            p.setString(8, cliente.getTelefone());
            p.setString(9, cliente.getCelular());
            p.setInt(10, cliente.getConvenio());
            p.setDate(11, new java.sql.Date(System.currentTimeMillis()));
            p.setString(12, "S");

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterar(Cliente cliente) {

        try {
            String sql = "UPDATE USUARIOS "
                    + " SET NOME = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, "
                    + " ESTADO = ?, CEP = ?, SEXO = ?, TELEFONE = ?, CELULAR = ?,"
                    + " CONVENIOS_CODIGO = ?, ATIVO = ?"
                    + " WHERE CODIGO = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setString(3, cliente.getBairro());
            p.setString(4, cliente.getCidade());
            p.setString(5, cliente.getEstado());
            p.setString(6, cliente.getCep());
            p.setString(7, String.valueOf(cliente.getSexo()));
            p.setString(8, cliente.getTelefone());
            p.setString(9, cliente.getCelular());
            p.setInt(10, cliente.getConvenio());
            p.setString(11, String.valueOf(cliente.getAtivo()));
            p.setInt(12, cliente.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            String sql = "SELECT * FROM CLIENTES";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente();

                int codigo = rs.getInt("CODIGO");
                String nome = rs.getString("NOME");
                String endereco = rs.getString("ENDERECO");
                String bairro = rs.getString("BAIRRO");
                String cidade = rs.getString("CIDADE");
                String estado = rs.getString("ESTADO");
                String cep = rs.getString("CEP");
                char sexo = rs.getString("SEXO").charAt(0);
                String telefone = rs.getString("TELEFONE");
                String celular = rs.getString("CELULAR");
                Date cadastro = rs.getDate("CADASTRO");
                int convenio = rs.getInt("CONVENIOS_CODIGO");
                char ativo = rs.getString("ATIVO").charAt(0);
                char deletado = rs.getString("DELETADO").charAt(0);

                cliente.setCodigo(codigo);
                cliente.setNome(nome);
                cliente.setEndereco(endereco);
                cliente.setBairro(bairro);
                cliente.setCidade(cidade);
                cliente.setEstado(estado);
                cliente.setCep(cep);
                cliente.setSexo(sexo);
                cliente.setTelefone(telefone);
                cliente.setCelular(celular);
                cliente.setCadastro(cadastro);
                cliente.setConvenio(convenio);
                cliente.setAtivo(ativo);
                cliente.setDeletado(deletado);

                clientes.add(cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente selecionar(int codigo) {

        Cliente cliente = new Cliente();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM CLIENTES WHERE CODIGO= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            cliente.setCodigo(codigo);
            cliente.setNome(rs.getString("NOME"));
            cliente.setEndereco(rs.getString("ENDERECO"));
            cliente.setBairro(rs.getString("BAIRRO"));
            cliente.setCidade(rs.getString("CIDADE"));
            cliente.setEstado(rs.getString("ESTADO"));
            cliente.setCep(rs.getString("CEP"));
            cliente.setSexo(rs.getString("SEXO").charAt(0));
            cliente.setTelefone(rs.getString("TELEFONE"));
            cliente.setCelular(rs.getString("CELULAR"));
            cliente.setCadastro(rs.getDate("CADASTRO"));
            cliente.setConvenio(rs.getInt("CONVENIOS_CODIGO"));
            cliente.setAtivo(rs.getString("ATIVO").charAt(0));
            cliente.setDeletado(rs.getString("DELETADO").charAt(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cliente;

    }

    @Override
    public Cliente Remove(int codigo) {

        String sql = "DELETE FROM CLIENTES WHERE CODIGO=?";

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
    public void inserir(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
