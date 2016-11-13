<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : compras
    Created on : 10/11/2016, 15:21:06
    Author     : smarangoni
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.model.Produto"%>
<%@page import="br.sp.senac.programeros.dao.ProdutoDAO"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a onclick= "window.location.href = 'cadastroFornecedor.jsp'">Adicionar</a></li>
                <li><a onclick= "window.location.href = 'menu.jsp'">Voltar</a></li>                
                <li><a onclick= "window.location.href = 'index.html'">Sair</a></li>                
            </ul>
            <div class="imagem"></div>
        </nav>
        <h1>Compras</h1>

        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            ProdutoDAO dao = new ProdutoDAO(conexao);
            List<Produto> produto = dao.listarProdutos();

            conn.fecharConexao();
        %>

        <form class="form-inline">
            <div class="form-group">

                <label for="cliente">Cliente</label>
                <input type="search" name="cliente" value="<c:out value="${cliente.getcodigo}" />" />
            </div>
            <div class="form-group">
                <label for="vendedor">Vendedor</label>
                <input type="search" name="vendedor" value="<c:out value="${vendedor.getcodigo}" />" />

            </div>
            <hr />
        </form>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col" style="width:60px">Codigo Produto</th>
                    <th scope="col" style="width: 60px">Descrição</th>
                    <th scope="col" style="width: 30px">Quantidade</th>
                    <th scope="col" style="width:40px">Preço Unitário</th>
                    <th scope="col" style="width: 30px">Subtotal</th>
                </tr>
            </thead>
            <tbody>
                <% for (Produto p : produto)
                {
                %>
                <tr>
                    <td><%= p.getCodigo() %></td>
                    <td><%= p.getDescricao() %></td>
                    <td><input id="qtd" type="number">
                    <td><%= p.getPreco() %></td>
                   <!-- <td><output name="subtotal" for="<%= p.getPreco() %> qtd"/></td> -->>
                </tr>
                
               <%}%>
               
            </tbody>
        </table>

        <c:import url="rodape.jsp" />
    </body>
</html>
