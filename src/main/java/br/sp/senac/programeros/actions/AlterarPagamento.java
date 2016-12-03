package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.ContasPagarDAO;
import br.sp.senac.programeros.model.ContasPagar;
import com.mysql.jdbc.Connection;
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
public class AlterarPagamento extends HttpServlet {

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
        request.getRequestDispatcher("ContasPagar/pagamentosAlterar.jsp").forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variaveis
        int id = Integer.parseInt(request.getParameter("id"));
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
        novo.setChave(id);
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
        //Obejto
         ContasPagarDAO dao = new ContasPagarDAO(conexao);
        dao.alterar(novo);
        
        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/ContasPagar/pagamentos.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
