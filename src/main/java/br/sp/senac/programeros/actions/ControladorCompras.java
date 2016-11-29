/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.CompraDAO;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author smarangoni
 */
@WebServlet("/compras.do")
public class ControladorCompras extends HttpServlet {
    
    private CompraDAO dao;
    private static String inserir = "/PedidosCompras/incluir_pedido.jsp";
    private static String listar = "/PedidosCompras/compras.jsp";

    public ControladorCompras() {
        super();
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        dao = new CompraDAO(conexao);
    }
    
    

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comando = "";
        String acao = request.getParameter("comando");
        
        if (acao.equalsIgnoreCase("incluir")) {
            comando = inserir;
            String compras = request.getParameter("idCompra");
            CompraDAO compraDAO = dao.inserir(compras);
            request.setAttribute("compraDAO", compraDAO);
         
        }else if (acao.equalsIgnoreCase("visualizar")) {
            
            
        }else if (acao.equalsIgnoreCase("alterar")) {
            
        }else if (acao.equalsIgnoreCase("excluir")) {
            
        }else{
            comando = listar;
            request.setAttribute("listar", dao.listarCompras());
        }
            
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
