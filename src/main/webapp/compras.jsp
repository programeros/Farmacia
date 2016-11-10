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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
    </head>
    <body>
        <h1>Compras</h1>
        
        <form>
            <fieldset>
                <label for="cliente">Cliente</label>
                <input type="search" name="cliente" value="<c:out value="${cliente.getcodigo}" />" />
                <label for="vendedor">Vendedor</label>
                <input type="search" name="vendedor" value="<c:out value="${vendedor.getcodigo}" />" />
            </fieldset>
        </form>
        <table>
            <thead>
                <tr>
                    <th>Codigo Produto</th>
                    <th>Descrição do Produto</th>
                    <th>Preço Unitário</th>
                    <th>Quantidade</th>
                    <th>Subtotal</th>
                </tr>
            </thead>
            <tbody>
                
                <% 
                    List <ProdutoDAO> produto = (List)request.getAttribute("lista");
                    for (int i = 0; i < produto.size(); i++) {
                         
                        //Utilizar o laço para retornar os itens
                        
                        }                 
                
                %>
                
                
                
                <td></td>
                
                
            </tbody>
        </table>
        
        <c:import url="rodape.jsp" />
    </body>
</html>
