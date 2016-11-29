<%@page import="br.sp.senac.programeros.dao.CompraDAO"%>
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
<%@page import="br.sp.senac.programeros.model.Compra" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mysql"uri="http://java.sun.com/jstl/sql" %>

<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" href="fornecedores.css" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGF</title>
    </head>
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            CompraDAO dao = new CompraDAO(conexao);
            List<Compra> compra = dao.listarCompras();
            conn.fecharConexao();
        %> 

        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>
            <div class="pesquisa">
                <label for="select">Pesquisar:</label>
                <select name="select" id="select">
                     		<option value="pedido">Pedido</option>
                    <option value="cliente">Cliente</option>
                </select>
                <input type="text" name="textfield" id="textfield">
                <label id="pesquisa"><img src="../images/search.png" width="15" height="11" alt=""/></label>
            </div>
        </div>

        <div class="menu">
            <p id="incluir">Incluir</p>
            <p id="visualizar">Visualizar</p>
            <p id="alterar">Alterar</p>
            <p id="excluir">Excluir</p>
        </div>

        <div class="tela">
            <table class="tblContatos">
                <thead>
                <th id="col1" style="width: 20px">Status</th>
                <th id="col2" style="width: 30px">Pedido</th>
                <th id="col3" style="width: 30px">Cod. Fornecedor</th>
                <th id="col4" style="width: 40px">Nome Fornecedor</th>
                <th id="col5" style="width: 30px">Data</th>
                <th id="col6" style="width: 30px">Valor</th>               
                </thead>

                <tbody>
                    <% for (Compra c : compra) {
                        
                    %>
                    <tr onclick="selecionar(this)">
                        <td><%= c.getNumero()%></td>
                        <td><%= c.getCondicao()%></td>
                        <td><%= c.getFornecedor()%></td>
                        <td><%= c.getNumero()%></td>
                        <td><%=c.getValor()%></td>
                        <%}%> 
                </tbody>
        </div>



    </table>
</body>
</html>