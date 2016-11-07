<%-- 
    Document   : vendas
    Created on : 07/11/2016, 10:28:55
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.dao.VendaDAO"%>
<%@page import="br.sp.senac.programeros.model.Venda"%>
<%@page import="java.util.List"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Atualizações de Vendas</title>    
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
                <h1>Vendas</h1>                
                <hr />
                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();

                    VendaDAO dao = new VendaDAO(conexao);

                    List<Venda> venda = dao.listarVendas();

                    conn.fecharConexao();

                %>

                <table id="tblVendas" border="2" cellPadding ="3">         
                    <tr>
                        <th>Codigo</th>
                        <th>Data</th>
                        <th>Cliente_Cod</th>                        
                        <th>Vendedor_Cod</th>
                        <th>Produto</th>
                        <th>Almoxarifado_Cod</th>
                        <th>Qtde</th>
                    </tr>

                    <% for (Venda c : venda) {
                    %>
                    <tr>
                        <td><%= c.getCodigo()%></td>
                        <td><%= c.getData()%></td>
                        <td><%= c.getCliente()%></td>
                        <td><%= c.getVendedor()%></td>
                        <td><%= c.getProduto()%></td>
                        <td><%= c.getAlmoxarifado()%></td>
                        <td><%= c.getQuantidade()%></td>
                        </td>
                        <td> <a href="ExcluirUsuario?id=<%=c.getCodigo()%>" title="Excluir">
                                <img src="IMAGES/excluir.jpg"/> </a></td>
                        <td> <a href="AlterarUsuario?id=<%=c.getCodigo()%>" title="Alterar">
                                <img src="IMAGES/alterar.jpg"/> </a></td>                                                                      
                    </tr>              
                    <%}%>
            </div>
        </aside> 
    </table>           
</body>
</html>