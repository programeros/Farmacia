<%-- 
    Document   : filial
    Created on : 06/11/2016, 13:07:12
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.dao.FilialDAO"%>
<%@page import="br.sp.senac.programeros.model.Filiais"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<!DOCTYPE html>
<html>
    <head>       
        <title>Filiais Cadastradas</title>    
    </head>
    <link type="text/css" href="filiais.css" rel="stylesheet" />
    <script src="filiais.js" type="text/javascript"></script>   
    <body>  
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            FilialDAO dao = new FilialDAO(conexao);
            List<Filiais> filial = dao.listarFiliais();

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
            <table id="filiais">    
                <thread>
                    <th id="col1">Codigo</th>
                    <th id="col2">Nome</th>
                    <th id="col3">Cidade</th>
                    <th id="col4">Estado</th>                
                    <th id="col5">Telefone</th>
                </thread>

                <% for (Filiais fil : filial) {
                        cont++;
                %>
                <tr onclick="selecionar(this)">
                    <td><%= fil.getCodigo()%></td>
                    <td><%= fil.getNome()%></td>
                    <td><%= fil.getCidade()%></td>
                    <td><%= fil.getEstado()%></td>                     
                    <td><%= fil.getTelefone()%></td>                                                
                </tr>              
                <%}%>
            </table>                 
        </div> 
</body>
</html>
