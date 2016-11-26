package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.VendedorDAO;
import br.sp.senac.programeros.model.Vendedor;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarVendedor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Varaiavel do id
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        //Request diretorio
        request.getRequestDispatcher("Vendedores/vendedorAlterar.jsp").forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variaveis
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep");        
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String ativo =  request.getParameter("ativo");
        //Objeto e variaveis
        Vendedor novoCliente = new Vendedor();
        novoCliente.setCodigo(id);
        novoCliente.setNome(nome);
        novoCliente.setEndereco(endereco);
        novoCliente.setBairro(bairro);
        novoCliente.setCidade(cidade);
        novoCliente.setEstado(estado);
        novoCliente.setCep(cep);        
        novoCliente.setTelefone(telefone);
        novoCliente.setCelular(celular);
        novoCliente.setAtivo(ativo);
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto
        VendedorDAO dao = new VendedorDAO(conexao);
        dao.alterar(novoCliente);
        
        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/Vendedores/vendedor.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}