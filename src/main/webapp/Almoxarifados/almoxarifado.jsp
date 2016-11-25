<%-- 
    Document   : almoxarifado
    Created on : 06/11/2016, 13:07:30
    Author     : Michael Facul
--%>
<%@page import="br.sp.senac.programeros.dao.AlmoxarifadoDAO"%>
<%@page import="br.sp.senac.programeros.model.Almoxarifado"%>
<%@page import="java.util.List"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>        
        <title>Almoxarifados Cadastrados</title>
    </head>
    <link type="text/css" href="almoxarifados.css" rel="stylesheet" />
    <script src="almoxarifados.js" type="text/javascript"></script>
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            AlmoxarifadoDAO dao = new AlmoxarifadoDAO(conexao);
            List<Almoxarifado> almoxarifado = dao.listarAlmoxarifados();
            conn.fecharConexao();
            int cont = 0;
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

            <table id="almoxarifados">         
                <thread>
                    <th id="col1">Codigo</th>
                    <th id="col2">Descrição</th>
                    <th id="col3">Filial_Cod</th>
                    <th id="col4">Ativo</th>
                </thread>

                <% for (Almoxarifado a : almoxarifado) {
                        cont++;
                %>
                <tr onclick="selecionar(this)">
                    <td><%= a.getCodigo()%></td>
                    <td><%= a.getDescricao()%></td>
                    <td><%= a.getFilial()%></td>  
                    <td><%= a.getAtivo()%></td>                                                 
                </tr>              
                <%}%>
            </table>                 
        </div>        
    </body>
</html>
