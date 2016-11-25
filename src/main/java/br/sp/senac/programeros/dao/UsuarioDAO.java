package br.sp.senac.programeros.dao;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.connection.Senhas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.sp.senac.programeros.model.Usuario;

public class UsuarioDAO implements br.sp.senac.programeros.interfaces.UsuarioInterface {
    //Conexao do banco
    Connection conexao;

    //Construtor
    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir
    @Override
    public void inserir(Usuario usuario) {
        //Comando do banco
        String sql = "insert into usuarios "
                + "(login, nome, senha, ativo, deletado) VALUES (?, ?, ?, ?, '')";
        PreparedStatement p;

        try {
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, usuario.getLogin());
            p.setString(2, usuario.getNome());
            p.setString(3, usuario.getSenha());
            p.setString(4, usuario.getAtivo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Alterar
    @Override
    public void alterar(Usuario usuario) {

        try {
            //Comando do banco
            String sql = "UPDATE usuarios "
                    + " SET nome = ?, ativo = ? "
                    + " WHERE codigo = ?";

            PreparedStatement p;
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, usuario.getNome());
            p.setString(2, usuario.getAtivo());
            p.setInt(3, usuario.getCodigo());
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Alterar Senha
    @Override
    public void alterarSenha(Usuario usuario) {

        try {
            //Comando do banco
            String sql = "UPDATE usuarios "
                    + " SET senha = ? "
                    + " WHERE codigo = ?";

            PreparedStatement p;
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, usuario.getSenha());
            p.setInt(2, usuario.getCodigo());
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Listar
    @Override
    public List<Usuario> listarUsuarios() {
        //Lista
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            //Comando do banco
            String sql = "SELECT * FROM usuarios WHERE deletado <> '*'";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Usuario usuario = new Usuario();
                //Setando valores
                int codigo = rs.getInt("codigo");
                String login = rs.getString("login");
                String nome = rs.getString("nome");
                String senha = Senhas.Descriptografar(rs.getString("senha"));
                String ativo = rs.getString("ativo");

                usuario.setCodigo(codigo);
                usuario.setLogin(login);
                usuario.setNome(nome);
                usuario.setSenha(senha);
                usuario.setAtivo(ativo);

                usuarios.add(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    //Selecionar
    @Override
    public Usuario selecionar(int codigo) {
        //Criando o objeto usuario
        Usuario usuario = new Usuario();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM usuarios WHERE deletado <> '*' AND codigo= " + codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            //Setando valores
            usuario.setCodigo(codigo);
            usuario.setLogin(rs.getString("login"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getString("ativo"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;

    }
    //Remover
    @Override
    public Usuario Remove(int codigo) {
        //Comando do banco
        String sql = "UPDATE usuarios set deletado = '*' WHERE codigo=?";

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

    public String verificar(String login, String senha) {
        ConexaoBD conn = new ConexaoBD();
        String ret = null;
        String user = null;
        String pass = null;

        String sql = "SELECT * FROM usuarios WHERE deletado <> '*' AND ativo = 1 AND login= '" + login + "'";

        try {
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                user = rs.getString("login");
                pass = rs.getString("senha");

                if (login.equals(user) && senha.equals(pass)) {
                    ret = rs.getString("nome");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }
}
