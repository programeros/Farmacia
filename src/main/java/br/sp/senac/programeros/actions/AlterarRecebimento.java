package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.ContasReceberDAO;
import br.sp.senac.programeros.model.ContasReceber;
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael Facul
 */
public class AlterarRecebimento extends HttpServlet {

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
        request.getRequestDispatcher("ContasReceber/recebimentosAlterar.jsp").forward(request, response);  
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //Variaveis
        int id = Integer.parseInt(request.getParameter("id"));
        String serie = request.getParameter("serie");
        String titulo = request.getParameter("titulo");
        String parcela = request.getParameter("parcela");
        int cliente = Integer.parseInt(request.getParameter("cliente"));
        Date dataEmissao = Date.valueOf(request.getParameter("data_emissao"));
        float valor = Float.parseFloat(request.getParameter("valor"));        
        float valorBaixado = Float.parseFloat(request.getParameter("valor_baixado"));
        Date baixa = Date.valueOf(request.getParameter("data_baixa"));
        int pedido = Integer.parseInt(request.getParameter("pedido"));
        int notasSaida = Integer.parseInt(request.getParameter("notassaida"));        
        int usuario = Integer.parseInt(request.getParameter("usuario"));
        
        //Objeto e valores
        ContasReceber novo = new ContasReceber();
        novo.setChave(id);
        novo.setSerie(serie);
        novo.setTitulo(titulo);
        novo.setParcela(parcela);
        novo.setCliente(cliente);
        novo.setDataEmissao(dataEmissao);
        novo.setValor(valor); 
        novo.setValorBaixado(valorBaixado);
        novo.setDataBaixa(baixa);
        novo.setPedido(pedido);
        novo.setNotasSaida(notasSaida);        
        novo.setUsuario(usuario);
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto
        ContasReceberDAO dao = new ContasReceberDAO(conexao);
        dao.alterar(novo);

        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/ContasReceber/recebimentos.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}