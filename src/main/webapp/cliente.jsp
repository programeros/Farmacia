<%-- 
    Document   : cliente
    Created on : 05/11/2016, 23:28:41
    Author     : Michael Facul
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.sp.senac.programeros.model.Cliente"%>
<%@page import="br.sp.senac.programeros.dao.ClienteDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Clientes Cadastrados</title>    
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a onclick= "window.location.href = 'cadastroCliente.jsp'">Adicionar</a></li>
                <li><a onclick= "window.location.href = 'menu.jsp'">Voltar</a></li> 
                <li><a onclick= "window.location.href = 'index.html'">Sair</a></li>                
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>               
                <h1>Lista de Clientes</h1>                
                <hr />

                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();

                    ClienteDAO dao = new ClienteDAO(conexao);

                    List<Cliente> cliente = dao.listarClientes();

                    conn.fecharConexao();

                %>

                <table id="tblClientes" border="2" cellPadding ="3">         
                    <tr>
                        <th>Codigo</th>
                        <th>Nome</th>
                        <th>Endereço</th>
                        <th>Bairro</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>CEP</th>
                        <th>Sexo</th>
                        <th>Telefone</th>
                        <th>Celular</th>
                        <th>Dta Cadastro</th>
                        <th>Convenio</th>
                        <th>Ativo</th>
                        <th>Deletado</th>
                    </tr>

                    <% for (Cliente c : cliente) {
                    %>
                    <tr>
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
                        <td><%= c.getConvenio()%></td>
                        <td><%= c.getAtivo()%></td>
                        <td><%= c.getDeletado()%></td>
                        </td>
                        <td> <a href="ExcluirCliente?id=<%=c.getCodigo()%>" title="Excluir">
                                <img src="IMAGES/excluir.jpg"/> </a></td>
                        <td> <a href="AlterarCliente?id=<%=c.getCodigo()%>" title="Alterar">
                                <img src="IMAGES/alterar.jpg"/> </a></td>
                    </tr>              
                    <%}%>

            </div>
        </aside> 
    </table>   
</body>
</html>
