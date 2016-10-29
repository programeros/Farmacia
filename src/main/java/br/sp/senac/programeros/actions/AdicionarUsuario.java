package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.dao.ConexaoBD;
import br.sp.senac.programeros.dao.Senhas;
import br.sp.senac.programeros.dao.UsuarioDAO;
import br.sp.senac.programeros.model.Usuario;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author willian.carvalho
 */
public class AdicionarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        
        senha = Senhas.Criptografar(senha);

        Usuario novoUsuario = new Usuario();
        novoUsuario.setLogin(login);
        novoUsuario.setNome(nome);
        novoUsuario.setSenha(senha);

        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();

        UsuarioDAO dao = new UsuarioDAO(conexao);
        dao.inserir(novoUsuario);
        
        conn.fecharConexao();
        
        response.sendRedirect("logado.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
