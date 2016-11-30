<%-- 
    Document   : trasferencias
    Created on : 30/11/2016, 11:52:00
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.Transferencia"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.TransferenciaDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
         <title>Transferencias Realizadas</title> 
    </head>
    <link type="text/css" href="transferencia.css" rel="stylesheet" />
    <script src="transferencia.js" type="text/javascript"></script>  
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            TransferenciaDAO dao = new TransferenciaDAO(conexao);
            List<Transferencia> transferencia = dao.listarMovimentos();
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
            <table id="fornecedores">         
                <thread>
                    <th id="col1">Chave</th>
                    <th id="col2">Data de Transferencia</th>
                    <th id="col3">Produto</th>
                    <th id="col4">Origem</th>
                    <th id="col5">Destino</th>
                    <th id="col6">Quantidade</th>
                    <th id="col7">Usuario</th>                        
                                           
                </thread>
                <% for (Transferencia f : transferencia) {
                        cont++;
                %>
                <tr onclick="selecionar(this)">
                    <td><%= f.getChave()%></td>
                    <td><%= f.getData()%></td>
                    <td><%= f.getProduto()%></td>
                    <td><%= f.getOrigem()%></td>
                    <td><%= f.getDestino()%></td>
                    <td><%= f.getQuantidade()%></td>
                    <td><%= f.getUsuario()%></td>                                                                       
                </tr>                           
                <%}%>
            </table> 
        </div>
    </body>
</html>
