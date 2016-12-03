package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.ContasPagarDAO;
import br.sp.senac.programeros.model.ContasPagar;
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
public class AdicionarPagamento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variaveis
        String serie = request.getParameter("serie");
        String titulo = request.getParameter("titulo");
        String parcela = request.getParameter("parcela");
        int fornecedor = Integer.parseInt(request.getParameter("fornecedor"));
        Date dataEmissao = Date.valueOf(request.getParameter("data_emissao"));
        float valor = Float.parseFloat(request.getParameter("valor"));        
        float valorBaixado = Float.parseFloat(request.getParameter("valor_baixado"));
        int pedido = Integer.parseInt(request.getParameter("pedido"));
        int notasEntrada = Integer.parseInt(request.getParameter("notasentrada"));
        Date baixa = Date.valueOf(request.getParameter("baixa"));
        int usuario = Integer.parseInt(request.getParameter("usuario"));
        
        //Objeto e valores
        ContasPagar novo = new ContasPagar();
        novo.setSerie(serie);
        novo.setTitulo(titulo);
        novo.setParcela(parcela);
        novo.setFornecedor(fornecedor);
        novo.setDataEmissao(dataEmissao);
        novo.setValor(valor); 
        novo.setValorBaixado(valorBaixado);
        novo.setPedido(pedido);
        novo.setNotasEntrada(notasEntrada);
        novo.setDataBaixa(baixa);
        novo.setUsuario(usuario);
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto
        ContasPagarDAO dao = new ContasPagarDAO(conexao);
        dao.inserir(novo);

        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/ContasPagar/pagamentos.jsp");

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