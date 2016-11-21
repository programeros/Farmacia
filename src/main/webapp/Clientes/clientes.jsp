<%-- 
    Document   : Produtos
    Created on : 20/11/2016, 14:30:08
    Author     : willian.carvalho
--%>

<%@page import="br.sp.senac.programeros.model.Usuario"%>
<%@page import="br.sp.senac.programeros.dao.UsuarioDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
	<head>
            <title>SGF</title>        
            
	</head>
	<link type="text/css" href="clientes.css" rel="stylesheet" />
	<script src="clientes.js" type="text/javascript"></script>     
	<body>
            
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            UsuarioDAO dao = new UsuarioDAO(conexao);
            List<Usuario> usuario = dao.listarUsuarios();
            conn.fecharConexao();
            int cont=0;
        %>        
            
		<div class="cabecalho">
			<img src="../images/logo_1.png" width="75" height="71" alt=""/>
			<div class="pesquisa">
				<label for="select">Pesquisar:</label>				
				<input type="text" name="textfield" id="textfield">
				<label id="pesquisa"><img src="../images/search.png" width="15" height="11" alt=""/></label>
			</div>
		</div>
		<div class="menu">
			<p id="incluir">Incluir</p>
			<p id="visualizar">Visualizar</p>
			<p id="alterar">Alterar</p>
			<p id="excluir">Excluir</p>
                        <p id="sair">Sair</p>
		</div>

		<div class="tela">
                    <table id="usuarios">         
                        <thread>
                            <th id="col1">Codigo</th>
                            <th id="col2">Nome</th>
                            <th id="col3">Estado</th>
                            <th id="col4">Cidade</th>
                            <th id="col5">Cadastro</th>
                        </thread>
                        <%                            
                            for(Usuario c:usuario){
                        %>
                        <tr onclick="selecionar(this)">
                            <td><%= c.getCodigo()%></td>
                            <td><%= c.getLogin()%></td>
                            <td><%= c.getNome() %></td>
                            <td><%= "******" %></td>                                                              
                        </tr>              
                        <%} %>
                    </table>
		</div>	 
	</body>
</html>