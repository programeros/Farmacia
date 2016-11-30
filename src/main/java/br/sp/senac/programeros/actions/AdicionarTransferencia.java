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
 *
 * @author Michael Facul
 */
public class AdicionarTransferencia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variaveis
        String produto = request.getParameter("produto");        
        String almOri = request.getParameter("almOri");
        String almDes = request.getParameter("almDes");
        String qtde = request.getParameter("quantidade");
        String usuario = request.getParameter("usuario");
        
        //Objeto e valores
        Transferencia novo = new Transferencia();
        novo.setProduto(Integer.parseInt(produto));        
        novo.setOrigem(Integer.parseInt(almOri));
        novo.setDestino(Integer.parseInt(almDes));
        novo.setQuantidade(Float.parseFloat(qtde));
        novo.setUsuario(Integer.parseInt(usuario));
        
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto
        TransferenciaDAO dao = new TransferenciaDAO(conexao);
        dao.inserir(novo);

        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/Transferencias/transferencias.jsp");

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