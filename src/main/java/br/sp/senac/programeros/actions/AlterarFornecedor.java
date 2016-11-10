/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.FornecedorDAO;
import br.sp.senac.programeros.model.Fornecedor;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael Facul
 */
public class AlterarFornecedor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        
        request.getRequestDispatcher("fornecedorAlterar.jsp").forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        
        Fornecedor novoCliente = new Fornecedor();
        novoCliente.setNome(nome);
        novoCliente.setEndereco(endereco);
        novoCliente.setBairro(bairro);
        novoCliente.setCidade(cidade);
        novoCliente.setEstado(estado);
        novoCliente.setCep(cep);        
        novoCliente.setTelefone(telefone);
        novoCliente.setCelular(celular);
        novoCliente.setAtivo(ativo);
        
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();

        FornecedorDAO dao = new FornecedorDAO(conexao);
        dao.alterar(novoCliente);
        
        conn.fecharConexao();
        
        response.sendRedirect("fornecedor.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}