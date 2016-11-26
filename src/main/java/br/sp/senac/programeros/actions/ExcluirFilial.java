package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.FilialDAO;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirFilial extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variavel do id
        String codigo = request.getParameter("id");
        int id = Integer.parseInt(codigo);
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto
        FilialDAO dao = new FilialDAO(conexao);
        dao.Remove(id);

        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/Filiais/filial.jsp");    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
