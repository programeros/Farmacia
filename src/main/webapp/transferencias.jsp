<%-- 
    Document   : transferencias
    Created on : 08/11/2016, 00:16:34
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.Movimento"%>
<%@page import="java.util.List"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Atualizações de Transferências</title>    
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a onclick= "window.location.href = '#'">Adicionar</a></li>
                <li><a onclick= "window.location.href = 'menu.jsp'">Voltar</a></li>                
                <li><a onclick= "window.location.href = 'index.html'">Sair</a></li>                
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>               
                <h1>Transferências</h1>                
                <hr />
                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();

                    MovimentoDAO dao = new MovimentoDAO(conexao);

                    List<Movimento> movimento = dao.listarMovimentos();

                    conn.fecharConexao();

                %>

                <table id="tblMovimentos" border="2" cellPadding ="3">         
                    <tr>
                        <th>Codigo</th>
                        <th>Data</th>
                        <th>Produto</th>                       
                        <th>Almoxarifado_Origem</th>                        
                        <th>Almoxarifado_Destino</th>
                        <th>Qtde</th>
                    </tr>

                    <% for (Movimento c : movimento) {
                    %>
                    <tr>
                        <td><%= c.getCodigo()%></td>
                        <td><%= c.getData()%></td>
                        <td><%= c.getProduto()%></td>
                        <td><%= c.getAlmoxarifadoOrigem()%></td>
                        <td><%= c.getAlmoxarifadoDestino()%></td>                        
                        <td><%= c.getQuantidade()%></td>
                        </td>
                        <td> <a href="ExcluirMovimentos?id=<%=c.getCodigo()%>" title="Excluir">
                                <img src="IMAGES/excluir.jpg"/> </a></td>
                        <td> <a href="AlterarMovimentos?id=<%=c.getCodigo()%>" title="Alterar">
                                <img src="IMAGES/alterar.jpg"/> </a></td>                                                                      
                    </tr>              
                    <%}%>
            </div>
        </aside> 
    </table>           
</body>
</html>
