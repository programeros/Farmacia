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
import br.sp.senac.programeros.model.Fornecedores;
import java.sql.Date;

public class FornecedorDAO implements br.sp.senac.programeros.interfaces.FornecedorInterface {
    //Conexao do banco
    Connection conexao;
    //Construtor
    public FornecedorDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir
    @Override
    public void inserir(Fornecedores fornecedor) {
        //Comando do banco
        String sql = "INSERT INTO fornecedores"
                + "(nome, endereco, bairro, cidade, estado, cep, telefone, celular, "
                + "cadastro, ativo, deletado) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,'')";
        PreparedStatement p;
        try {
            //Setando Valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, fornecedor.getNome());
            p.setString(2, fornecedor.getEndereco());
            p.setString(3, fornecedor.getBairro());
            p.setString(4, fornecedor.getCidade());
            p.setString(5, fornecedor.getEstado());
            p.setString(6, fornecedor.getCep());
            p.setString(7, fornecedor.getTelefone());
            p.setString(8, fornecedor.getCelular());
            p.setDate(9, new java.sql.Date(System.currentTimeMillis()));
            p.setString(10, "S");

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Alterar
    @Override
    public void alterar(Fornecedores fornecedor) {

        try {
            //Comando do banco
            String sql = "UPDATE fornecedores "
                    + " SET nome = ?, endereco = ?, bairro = ?, cidade = ?, "
                    + " estado = ?, cep = ?, telefone = ?, celular = ?,"
                    + " ativo = ?"
                    + " WHERE codigo = ?";

            PreparedStatement p;
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, fornecedor.getNome());
            p.setString(2, fornecedor.getEndereco());
            p.setString(3, fornecedor.getBairro());
            p.setString(4, fornecedor.getCidade());
            p.setString(5, fornecedor.getEstado());
            p.setString(6, fornecedor.getCep());
            p.setString(7, fornecedor.getTelefone());
            p.setString(8, fornecedor.getCelular());
            p.setString(9, String.valueOf(fornecedor.getAtivo()));
            p.setInt(10, fornecedor.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Listar
    @Override
    public List<Fornecedores> listarFornecedores() {
        //Lista
        List<Fornecedores> fornecedores = new ArrayList<Fornecedores>();

        try {
            //Comando do banco
            String sql = "SELECT * FROM fornecedores WHERE deletado <> '*'";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Fornecedores fornecedor = new Fornecedores();
                //Setando valores
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String cep = rs.getString("cep");
                String telefone = rs.getString("telefone");
                String celular = rs.getString("celular");
                Date cadastro = rs.getDate("cadastro");
                String ativo = rs.getString("ativo");             

                fornecedor.setCodigo(codigo);
                fornecedor.setNome(nome);
                fornecedor.setEndereco(endereco);
                fornecedor.setBairro(bairro);
                fornecedor.setCidade(cidade);
                fornecedor.setEstado(estado);
                fornecedor.setCep(cep);
                fornecedor.setTelefone(telefone);
                fornecedor.setCelular(celular);
                fornecedor.setCadastro(cadastro);
                fornecedor.setAtivo(ativo);                

                fornecedores.add(fornecedor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedores;
    }
    //Selecionar
    @Override
    public Fornecedores selecionar(int codigo) {
        //Criando o objeto selecioar
        Fornecedores fornecedor = new Fornecedores();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM fornecedores WHERE deletado <> '*' AND codigo= "+codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            //Setando valores
            fornecedor.setCodigo(codigo);
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setEndereco(rs.getString("endereco"));
            fornecedor.setBairro(rs.getString("bairro"));
            fornecedor.setCidade(rs.getString("cidade"));
            fornecedor.setEstado(rs.getString("estado"));
            fornecedor.setCep(rs.getString("cep"));
            fornecedor.setTelefone(rs.getString("telefone"));
            fornecedor.setCelular(rs.getString("celular"));
            fornecedor.setCadastro(rs.getDate("cadastro"));
            fornecedor.setAtivo(rs.getString("ativo"));
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fornecedor;

    }
    //Remover
    @Override
    public Fornecedores Remove(int codigo) {
        //Comando do banco
        String sql = "UPDATE fornecedores set deletado = '*' WHERE codigo=?";

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

}
