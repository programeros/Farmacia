package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.ProdutoDAO;
import br.sp.senac.programeros.model.Produto;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variaveis
        String codigoBar = request.getParameter("codigoBar");
        String codigo = request.getParameter("codigo");
        String descricao = request.getParameter("descricao");
        String preco = request.getParameter("preco");
        String marca = request.getParameter("marca");
        String categoria = request.getParameter("categoria");
        String fornecedor = request.getParameter("fornecedor");                
        String ativo = "S";
        //Objetos e valores
        Produto novo = new Produto();
        novo.setCodbar(Integer.parseInt(codigoBar));
        novo.setCodigo(codigo);
        novo.setDescricao(descricao);
        novo.setPreco(Float.parseFloat(preco)); 
        novo.setMarca(marca);        
        novo.setCategoria(Integer.parseInt(categoria));
        novo.setFornecedor(Integer.parseInt(fornecedor));               
        novo.setAtivo(ativo);
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto
        ProdutoDAO dao = new ProdutoDAO(conexao);
        dao.inserir(novo);

        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/Produtos/produtos.jsp");
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