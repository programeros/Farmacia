<%-- 
    Document   : almoxarifado
    Created on : 06/11/2016, 13:07:30
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.dao.AlmoxarifadoDAO"%>
<%@page import="br.sp.senac.programeros.model.Almoxarifado"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Almoxarifados Cadastrados</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a onclick= "window.location.href = 'cadastroAlmoxarifado.jsp'">Adicionar</a></li>
                <li><a onclick= "window.location.href = 'menu.jsp'">Voltar</a></li> 
                <li><a onclick= "window.location.href = 'index.html'">Sair</a></li>                
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>               
                <h1>Lista de Almoxarifados</h1>                
                <hr />

                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();
                    
                    AlmoxarifadoDAO dao = new AlmoxarifadoDAO(conexao);

                    List<Almoxarifado> almoxarifado = dao.listarAlmoxarifados();

                    conn.fecharConexao();

                %>

                <table id="tblAlmoxarifados" border="1" cellPadding ="5">         
                    <tr>
                        <th>Codigo</th>
                        <th>Descrição</th>
                        <th>Unidade_Cod</th>
                        
                    </tr>

                    <% for (Almoxarifado a : almoxarifado) {
                    %>
                    <tr>
                        <td><%= a.getCodigo()%></td>
                        <td><%= a.getDescricao()%></td>
                        <td><%= a.getUnidade()%></td>                        
                        </td>
                        <td> <a href="ExcluirAlmoxarifado?id=<%=a.getCodigo()%>">Excluir</a>                        
                        <td> <a href="AlterarAlmoxarifado?id=<%=a.getCodigo()%>&descricao=<%=a.getDescricao()%>
                                &unidade=<%= a.getUnidade()%>">Alterar</a></td>
                    </tr>  
                    <%}%>
                </table>                 
            </div>
        </aside> 
    </body>
</html>
