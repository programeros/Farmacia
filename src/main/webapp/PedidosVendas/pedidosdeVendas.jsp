    <%-- 
    Document   : pedidosdeVendas
    Created on : 19/11/2016, 17:17:06
    Author     : willian.carvalho
--%>
<%@page import="br.sp.senac.programeros.model.Venda"%>
<%@page import="br.sp.senac.programeros.dao.VendaDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<title>SGF</title>
	</head>
	<link type="text/css" href="pedidosdeVenda.css" rel="stylesheet" />
	<script src="pedidosdeVenda.js" type="text/javascript"></script>
	<body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            VendaDAO dao = new VendaDAO(conexao);
            List<Venda> venda = dao.listarPedidos();
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
			<table id="tblContatos">         
				<tr>
					<th id="col1">Status</th>
					<th id="col2">Pedido</th>
					<th id="col3">Cod. Cliente</th>
					<th id="col4">Nome Cliente</th>
					<th id="col5">Data</th>
					<th id="col6">Valor</th>               
				</tr>
			</table>

		</div>	 
	</body>
</html>