<%-- 
    Document   : vendedor
    Created on : 06/11/2016, 10:48:49
    Author     : Michael Facul
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.sp.senac.programeros.model.Vendedor"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.VendedorDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Vendedores Cadastrados</title>    
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a onclick= "window.location.href = 'cadastroVendedor.jsp'">Adicionar</a></li>
                <li><a onclick= "window.location.href = 'menu.jsp'">Voltar</a></li>                
                <li><a onclick= "window.location.href = 'index.html'">Sair</a></li>                
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>               
                <h1>Lista de Vendedores</h1>                
                <hr />
                
                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();

                    VendedorDAO dao = new VendedorDAO(conexao);

                    List<Vendedor> vendedor = dao.listarVendedores();

                    conn.fecharConexao();

                %>
                <table id="tblVendedor" border="2" cellPadding ="3">         
                    <tr>
                        <th>Codigo</th>
                        <th>Nome</th>
                        <th>Endereço</th>
                        <th>Bairro</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>CEP</th>                        
                        <th>Telefone</th>
                        <th>Celular</th>
                        <th>Dta Cadastro</th>                        
                        <th>Ativo</th>
                        <th>Deletado</th>
                    </tr>

                    <% for (Vendedor v : vendedor) {
                    %>
                    <tr>
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
                        <td><%= v.getDeletado()%></td> 
                        </td>
                        <td> <a href="ExcluirVendedor?id=<%=v.getCodigo()%>" title="Excluir">
                                <img src="IMAGES/excluir.jpg"/> </a></td>
                        <td> <a href="AlterarVendedor?id=<%=v.getCodigo()%>" title="Alterar">
                                <img src="IMAGES/alterar.jpg"/> </a></td>
                    </tr>              
                    <%}%>
                </table>                 
            </div>
        </aside> 
    </body>
</html>
