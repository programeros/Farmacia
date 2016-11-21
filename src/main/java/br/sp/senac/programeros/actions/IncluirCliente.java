package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.ClienteDAO;
import br.sp.senac.programeros.model.Cliente;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author willian.carvalho
 */
public class IncluirCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String sexo = request.getParameter("sexo");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String cadastro = request.getParameter("cadastro");
        char ativo = 'S';
        
        Date date=null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(cadastro);
        } catch (ParseException e) {
        }
                
        Cliente novoCliente = new Cliente();
        
        novoCliente.setNome(nome);
        novoCliente.setEndereco(endereco);
        novoCliente.setBairro(bairro);
        novoCliente.setCidade(cidade);
        novoCliente.setEstado(estado);
        novoCliente.setSexo(sexo);
        novoCliente.setTelefone(telefone);
        novoCliente.setCelular(celular);
        novoCliente.setCadastro((java.sql.Date) date);
        novoCliente.setAtivo(Character.toString(ativo));
        
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();

       ClienteDAO dao = new ClienteDAO(conexao);
        dao.inserir(novoCliente);
        
        conn.fecharConexao();
        
        response.sendRedirect("/Farmacia/Usuarios/usuarios.jsp");       
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