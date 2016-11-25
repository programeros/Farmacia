package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.AlmoxarifadoDAO;
import br.sp.senac.programeros.model.Almoxarifado;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @author Michael Facul
 */
public class AlterarAlmoxarifado extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        
        request.getRequestDispatcher("Almoxarifados/almoxarifadoAlterar.jsp").forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        String filial = request.getParameter("filial");        
        String ativo = "S";

        Almoxarifado novo = new Almoxarifado();
        novo.setCodigo(id);
        novo.setDescricao(descricao);
        novo.setFilial(Integer.parseInt(filial));        
        novo.setAtivo(ativo);

        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();

        AlmoxarifadoDAO dao = new AlmoxarifadoDAO(conexao);
        dao.alterar(novo);
        
        conn.fecharConexao();
        
        response.sendRedirect("/Farmacia/Almoxarifados/almoxarifado.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}