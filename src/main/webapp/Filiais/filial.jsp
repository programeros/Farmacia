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
                    <th id="col9">Fax</th> 
                    <th id="col10">Responsavel</th>
                    <th id="col11">Email</th>
                    <th id="col12">Ativo</th>   
                </thread>

                <% for (Filiais v : filial) {
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
                    <td><%= v.getFax()%></td>
                    <td><%= v.getResponsavel()%></td>    
                    <td><%= v.getEmail()%></td> 
                    <td><%= v.getAtivo()%></td>                                                  
                </tr>              
                <%}%>
            </table>                 
        </div> 
</body>
</html>
