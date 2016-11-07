<%-- 
    Document   : compra
    Created on : 07/11/2016, 14:29:22
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.dao.CompraDAO"%>
<%@page import="br.sp.senac.programeros.model.Compra"%>
<%@page import="java.util.List"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Atualizações de Compras</title>    
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
                <h1>Compras</h1>                
                <hr />
                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();

                    CompraDAO dao = new CompraDAO(conexao);

                    List<Compra> compra = dao.listarCompras();

                    conn.fecharConexao();

                %>

                <table id="tblCompras" border="2" cellPadding ="3">         
                    <tr>
                        <th>Codigo</th>
                        <th>Data</th>
                        <th>Fornecedor_Cod</th>                                                
                        <th>Produto</th>
                        <th>Almoxarifado_Cod</th>
                        <th>Qtde</th>
                    </tr>

                    <% for (Compra c : compra) {
                    %>
                    <tr>
                        <td><%= c.getCodigo()%></td>
                        <td><%= c.getData()%></td>
                        <td><%= c.getFornecedor()%></td>                        
                        <td><%= c.getProduto()%></td>
                        <td><%= c.getAlmoxarifado()%></td>
                        <td><%= c.getQuantidade()%></td>
                        </td>
                        <td> <a href="ExcluirCompras?id=<%=c.getCodigo()%>" title="Excluir">
                                <img src="IMAGES/excluir.jpg"/> </a></td>
                        <td> <a href="AlterarCompras?id=<%=c.getCodigo()%>" title="Alterar">
                                <img src="IMAGES/alterar.jpg"/> </a></td>                                                                       
                    </tr>              
                    <%}%>
            </div>
        </aside> 
    </table>           
</body>
</html>
