package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.connection.Senhas;
import br.sp.senac.programeros.dao.UsuarioDAO;
import br.sp.senac.programeros.model.Usuario;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variaveis
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        char ativo = '1';
        senha = Senhas.Criptografar(senha);
        //Obejtos e valores
        Usuario novoUsuario = new Usuario();
        novoUsuario.setLogin(login);
        novoUsuario.setNome(nome);
        novoUsuario.setSenha(senha);
        novoUsuario.setAtivo(Character.toString(ativo));
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto
        UsuarioDAO dao = new UsuarioDAO(conexao);
        dao.inserir(novoUsuario);
        
        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/Usuarios/usuarios.jsp");       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}