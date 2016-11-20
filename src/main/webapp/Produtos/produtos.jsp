<%-- 
    Document   : Produtos
    Created on : 20/11/2016, 14:30:08
    Author     : willian.carvalho
--%>

<%@page import="br.sp.senac.programeros.model.Produto"%>
<%@page import="br.sp.senac.programeros.dao.ProdutoDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
	<head>
            <title>SGF</title>
	</head>
	<link type="text/css" href="produtos.css" rel="stylesheet" />
	<script src="produtos.js" type="text/javascript"></script>
	<body>
            
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            ProdutoDAO dao = new ProdutoDAO(conexao);
            List<Produto> produto = dao.listarProdutos();
            conn.fecharConexao();
        %>            
            
		<div class="cabecalho">
			<img src="images/logo_1.png" width="75" height="71" alt=""/>
			<div class="pesquisa">
				<label for="select">Pesquisar:</label>				
				<input type="text" name="textfield" id="textfield">
				<label id="pesquisa"><img src="images/search.png" width="15" height="11" alt=""/></label>
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
					<th id="col1">Codigo Barras</th>
					<th id="col2">Codigo</th>
					<th id="col3">Descricao</th>
					<th id="col4">Preco</th>
					<th id="col5">Fornecedor</th>
					<th id="col6">Categoria</th>               
				</tr>

                                <% for(Produto p:produto){
                                %>
                                <tr>
                                    <td><%= p.getCodbar()%></td>
                                    <td><%= p.getCodigo()%></td>
                                    <td><%= p.getDescricao()%></td>
                                    <td><%= p.getPreco()%></td>
                                    <td><%= p.getFornecedor()%></td>
                                    <td><%= p.getCategoria()%></td>                                                                                    
                                </tr>              
                                <%} %> 
			</table>

		</div>	 
	</body>
</html>