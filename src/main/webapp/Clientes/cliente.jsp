<%-- 
    Document   : cliente
    Created on : 05/11/2016, 23:28:41
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.Cliente"%>
<%@page import="br.sp.senac.programeros.dao.ClienteDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Clientes Cadastrados</title>    
    </head>
    <link type="text/css" href="clientes.css" rel="stylesheet" />
    <script src="clientes.js" type="text/javascript"></script>    
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            ClienteDAO dao = new ClienteDAO(conexao);
            List<Cliente> cliente = dao.listarClientes();
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
            <table id="cliente">         
                <thread>
                    <th id="col1">Codigo</th>
                    <th id="col2">Nome</th>
                    <th id="col3">Endereço</th>
                    <th id="col4">Bairro</th>
                    <th id="col5">Cidade</th>
                    <th id="col6">Estado</th>
                    <th id="col7">CEP</th>
                    <th id="col8">Sexo</th>
                    <th id="col9">Telefone</th>
                    <th id="col10">Celular</th>
                    <th id="col11">Dta Cadastro</th>                        
                    <th id="col12">Ativo</th>  
                </thread>        
                <% for (Cliente c : cliente) {
                        cont++;
                %>
                <tr onclick="selecionar(this)">
                    <td><%= c.getCodigo()%></td>
                    <td><%= c.getNome()%></td>
                    <td><%= c.getEndereco()%></td>
                    <td><%= c.getBairro()%></td>
                    <td><%= c.getCidade()%></td>
                    <td><%= c.getEstado()%></td>
                    <td><%= c.getCep()%></td>
                    <td><%= c.getSexo()%></td>
                    <td><%= c.getTelefone()%></td>
                    <td><%= c.getCelular()%></td>
                    <td><%= c.getCadastro()%></td>                        
                    <td><%= c.getAtivo()%></td>          
                </tr>              
                <%}%>
            </table>
        </div>	 
    </body>
</html>    



