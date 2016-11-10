/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.ProdutoDAO;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael Facul
 */
public class ExcluirProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigo = request.getParameter("id");
                        
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();

        ProdutoDAO dao = new ProdutoDAO(conexao);
        dao.Remove(codigo);

        conn.fecharConexao();
        
        response.sendRedirect("produto.jsp");            
        
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
