package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.connection.Senhas;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.sp.senac.programeros.dao.*;
import java.sql.Connection;
import javax.servlet.http.HttpSession;

public class VerificarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variavel da sessao usuario
        HttpSession sessao = request.getSession();
        String login = request.getParameter("username");
        String senha = request.getParameter("password");
        senha = Senhas.Criptografar(senha);
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto
        UsuarioDAO dao = new UsuarioDAO(conexao);
        //Sessao - nome e senha
        sessao.setAttribute("nome", dao.verificar(login, senha));
        String nome = (String) sessao.getAttribute("nome");
        
        conn.fecharConexao();
        //Janelas de abetura de acordo com a senha
        if(nome != null){
            response.sendRedirect("menu.jsp");
        }else{
            response.sendRedirect("index.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
