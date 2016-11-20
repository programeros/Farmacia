package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.UsuarioDAO;
import br.sp.senac.programeros.model.Usuario;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author willian.carvalho
 */

public class AlterarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        
        request.getRequestDispatcher("usuarioAlterar.jsp").forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String ativo =  request.getParameter("ativo");
       
        Usuario usuario = new Usuario();
        usuario.setCodigo(id);
        usuario.setLogin(login);
        usuario.setNome(nome);
        usuario.setAtivo(ativo);
        
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();

        UsuarioDAO dao = new UsuarioDAO(conexao);
        dao.alterar(usuario);
        
        conn.fecharConexao();
        
        response.sendRedirect("usuario.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
