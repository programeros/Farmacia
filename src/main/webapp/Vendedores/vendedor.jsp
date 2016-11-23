<%-- 
    Document   : vendedor
    Created on : 06/11/2016, 10:48:49
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.Vendedor"%>
<%@page import="br.sp.senac.programeros.dao.VendedorDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>       
        <title>Vendedores Cadastrados</title>    
    </head>
    <link type="text/css" href="vendedores.css" rel="stylesheet" />
    <script src="vendedores.js" type="text/javascript"></script>   
    <body>            
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            VendedorDAO dao = new VendedorDAO(conexao);

            List<Vendedor> vendedor = dao.listarVendedores();

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
            <table id="vendedores">    
                <thread>
                    <th id="col1">Codigo</th>
                    <th id="col2">Nome</th>
                    <th id="col3">Endereço</th>
                    <th id="col4">Bairro</th>
                    <th id="col5">Cidade</th>
                    <th id="col6">Estado</th>
                    <th id="col7">CEP</th>                   
                    <th id="col8">Telefone</th>
                    <th id="col9">Celular</th>
                    <th id="col10">Dta Cadastro</th>                        
                    <th id="col11">Ativo</th>                       
                </thread>

                <% for (Vendedor v : vendedor) {
                        cont++;
                %>
                <tr onclick="selecionar(this)">
                    <td><%= v.getCodigo()%></td>
                    <td><%= v.getNome()%></td>
                    <td><%= v.getEndereco()%></td>
                    <td><%= v.getBairro()%></td>
                    <td><%= v.getCidade()%></td>
                    <td><%= v.getEstado()%></td>
                    <td><%= v.getCep()%></td>                        
                    <td><%= v.getTelefone()%></td>
                    <td><%= v.getCelular()%></td>
                    <td><%= v.getCadastro()%></td>                                                
                    <td><%= v.getAtivo()%></td>                                                  
                </tr>              
                <%}%>
            </table>                 
        </div>         
    </body>
</html>
