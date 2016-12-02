package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.TransferenciaDAO;
import br.sp.senac.programeros.model.Transferencia;
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
public class AlterarTransferencia extends HttpServlet {

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
        request.getRequestDispatcher("Transferencias/transferenciaAlterar.jsp").forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variaveis
        int id = Integer.parseInt(request.getParameter("id"));        
        String produto = request.getParameter("produto");
        String qtde = request.getParameter("quantidade");
        String almOri = request.getParameter("almOri");
        String almDes = request.getParameter("almDes");
        String usuario = request.getParameter("usuario");
        
        //Objeto e valores
        Transferencia novo = new Transferencia();
        novo.setChave(id);
        novo.setProduto(Integer.parseInt(produto));
        novo.setQuantidade(Float.parseFloat(qtde));
        novo.setOrigem(Integer.parseInt(almOri));
        novo.setDestino(Integer.parseInt(almDes));
        novo.setUsuario(Integer.parseInt(usuario));
        
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto
        TransferenciaDAO dao = new TransferenciaDAO(conexao);
        dao.alterar(novo);

        conn.fecharConexao();
                          
        //Diretorio
        response.sendRedirect("/Farmacia/Transferencias/transferencias.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
