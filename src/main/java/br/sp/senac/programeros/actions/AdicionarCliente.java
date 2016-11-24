package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.ClienteDAO;
import br.sp.senac.programeros.model.Cliente;
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
public class AdicionarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep");
        String sexo = request.getParameter("sexo");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");        
        String ativo = "S";
        
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(nome);
        novoCliente.setEndereco(endereco);
        novoCliente.setBairro(bairro);
        novoCliente.setCidade(cidade);
        novoCliente.setEstado(estado);
        novoCliente.setCep(cep);
        novoCliente.setSexo(sexo);
        novoCliente.setTelefone(telefone);
        novoCliente.setCelular(celular);        
        novoCliente.setAtivo(ativo);

        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();

        ClienteDAO dao = new ClienteDAO(conexao);
        dao.inserir(novoCliente);

        conn.fecharConexao();

        response.sendRedirect("/Farmacia/Clientes/cliente.jsp");

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
