package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.connection.Senhas;
import br.sp.senac.programeros.dao.UsuarioDAO;
import br.sp.senac.programeros.model.Usuario;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarSenhaUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variavel do id        
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        //Request diretorio
        request.getRequestDispatcher("Usuarios/usuarioSenhaAlterar.jsp").forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variaveis
        int id = Integer.parseInt(request.getParameter("id"));
        String senha = request.getParameter("senha"); 
        senha = Senhas.Criptografar(senha);
        Usuario usuario = new Usuario();
        usuario.setCodigo(id);
        usuario.setSenha(senha);
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto 
        UsuarioDAO dao = new UsuarioDAO(conexao);
        dao.alterarSenha(usuario);
        
        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/Usuarios/usuarios.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
