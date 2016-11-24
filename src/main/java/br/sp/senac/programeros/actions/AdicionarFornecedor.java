package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.FornecedorDAO;
import br.sp.senac.programeros.model.Fornecedores;
import java.sql.Connection;
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
public class AdicionarFornecedor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep");        
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String ativo = "S";

        Fornecedores novo = new Fornecedores();
        novo.setNome(nome);
        novo.setEndereco(endereco);
        novo.setBairro(bairro);
        novo.setCidade(cidade);
        novo.setEstado(estado);
        novo.setCep(cep);        
        novo.setTelefone(telefone);
        novo.setCelular(celular);
        novo.setAtivo(ativo);

        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();

        FornecedorDAO dao = new FornecedorDAO(conexao);
        dao.inserir(novo);

        conn.fecharConexao();

        response.sendRedirect("/Farmacia/Fornecedores/fornecedor.jsp");

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