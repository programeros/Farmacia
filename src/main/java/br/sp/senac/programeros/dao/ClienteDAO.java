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

    @Override
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO clientes "
                + "(nome, endereco, bairro, cidade,estado,cep,sexo,telefone,celular,"
                + "cadastro,ativo) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?)";
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
            p.setDate(10, new java.sql.Date(System.currentTimeMillis()));
            
            p.setString(11, "S");

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterar(Cliente cliente) {

        try {
            String sql = "UPDATE clientes "
                    + " SET nome = ?, endereco = ?, bairro = ?, cidade = ?, "
                    + " estado = ?, cep = ?, sexo = ?, telefone = ?, celular = ?,"
                    + " convenio_codigo = ?"
                    + " WHERE codigo = ?";

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
            p.setInt(13, cliente.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            String sql = "SELECT * FROM clientes";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente();

                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String cep = rs.getString("cep");
                char sexo = rs.getString("sexo").charAt(0);
                String telefone = rs.getString("telefone");
                String celular = rs.getString("celular");
                Date cadastro = rs.getDate("cadastro");
                int convenio = rs.getInt("convenio_codigo");
                String ativo = rs.getString("ativo");
                String deletado = rs.getString("deletado");

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

        String sql = "SELECT * FROM clientes WHERE codigo= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            cliente.setCodigo(codigo);
            cliente.setNome(rs.getString("nome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setEstado(rs.getString("estado"));
            cliente.setCep(rs.getString("cep"));
            cliente.setSexo(rs.getString("sexo").charAt(0));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setCadastro(rs.getDate("cadastro"));
            cliente.setConvenio(rs.getInt("convenio_codigo"));
            cliente.setAtivo(rs.getString("ativo"));
            cliente.setDeletado(rs.getString("deletado"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cliente;

    }

    @Override
    public Cliente Remove(int codigo) {

        String sql = "DELETE FROM clientes WHERE codigo=?";

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
//    public void inserir(Cliente cliente) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
