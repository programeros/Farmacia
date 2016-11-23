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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="../Formularios/head.jsp"></c:import>


    <!--<script type="text/javascript">
        function multiplicacao() {
            var quantidade = document.getElementById("qtd").value;
            var unitario = document.getElementById("s2").value;
            var subtotal = parseInt(s1) * parseInt(s2);
            alert(s3);
        }
    </script> -->

<c:import url="../Formularios/header.jsp"/>


<div class="menu col-md-2 menu-acoes">
    
    <p>
        <a class="btn btn-primary btn-block" href="#">Incluir</a>
    </p>
    <p>
        <a class="btn btn-primary btn-block" href="#">Visualizar</a>
    </p>
    <p>
        <a class="btn btn-primary btn-block" href="#">Alterar</a>
    </p>
    <p>
        <a class="btn btn-primary btn-block" role="button" href="#">Excluir</a>
    </p>
</div>

<div class="col-md-10 infCompras">
    <table class="table table-hover text-primary">
        <thead>
            <th id="col1" style="width: 20px">Status</th>
            <th id="col2" style="width: 30px">Pedido</th>
            <th id="col3" style="width: 30px">Cod. Fornecedor</th>
            <th id="col4" style="width: 40px">Nome Fornecedor</th>
            <th id="col5" style="width: 30px">Data</th>
            <th id="col6" style="width: 30px">Valor</th>               
        </thead>
    </table>
</div>

<c:import url="../Formularios/footer.jsp" />
