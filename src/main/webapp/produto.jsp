<%-- 
    Document   : produto
    Created on : 06/11/2016, 11:52:37
    Author     : Michael Facul
--%>

<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.ProdutoDAO"%>
<%@page import="br.sp.senac.programeros.model.Produto"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Produtos Cadastrados</title> 
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a onclick= "window.location.href = 'cadastroProduto.jsp'">Adicionar</a></li>
                <li><a onclick= "window.location.href = 'menu.jsp'">Voltar</a></li>                
                <li><a onclick= "window.location.href = 'index.html'">Sair</a></li>                
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>               
                <h1>Lista de Produtos</h1>                
                <hr />
                
                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();

                    ProdutoDAO dao = new ProdutoDAO(conexao);

                    List<Produto> produto = dao.listarProdutos();

                    conn.fecharConexao();

                %>
                <table id="tblProduto" border="1" cellPadding ="5">         
                    <tr>
                        <th>Codigo</th>
                        <th>Descrição</th>
                        <th>Preço</th>
                        <th>Marca</th>
                        <th>Categoria_Cod</th>
                        <th>Fornecedor_Cod</th>
                        <th>Unidade_Cod</th>                                                
                    </tr>

                    <% for (Produto p : produto) {
                    %>
                    <tr>
                        <td><%= p.getCodigo()%></td>
                        <td><%= p.getDescricao()%></td>
                        <td><%= p.getPreco()%></td>
                        <td><%= p.getMarca()%></td>
                        <td><%= p.getCategoria()%></td>
                        <td><%= p.getFornecedor()%></td>
                        <td><%= p.getUnidade()%></td>                                                                      
                        </td>
                        <td> <a href="ExcluirProduto?id=<%=p.getCodigo()%>">Excluir</a></td>
                        <td> <a href="AlterarProduto?id=<%=p.getCodigo()%>&descricao=<%=p.getDescricao()%>
                                &preco=<%= p.getPreco()%>&marca=<%= p.getMarca()%>
                                &categoria=<%= p.getCategoria()%>&fornecedor=<%= p.getFornecedor()%>
                                &unidade=<%= p.getUnidade()%>">                               
                                Alterar</a></td>
                    </tr>              
                    <%}%>
                </table>                 
            </div>
        </aside> 
    </body>
</html>
