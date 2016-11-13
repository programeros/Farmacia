<%-- 
    Document   : usuario
    Created on : 30/10/2016, 00:58:03
    Author     : willian.carvalho
--%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.sp.senac.programeros.connection.Senhas"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.UsuarioDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@page import="br.sp.senac.programeros.model.Usuario"%>

<!DOCTYPE html>
<html>
    <head>    
        <title>Usuários do SGF</title>    
    </head>
    <link href="css/usuario.css" type="text/css" rel="stylesheet" />
    <body>
        <c:import url="cabecalho.jsp"/>
        <h1>Lista de Usuários</h1> <br/>
        <button onclick= "window.location.href = 'usuarioAdicionar.jsp'">Adicionar</button>
        <button onclick= "window.location.href = 'menu.jsp'">Sair</button><br/>
        <hr /><br/>
        
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            
            UsuarioDAO dao = new UsuarioDAO(conexao);
            
            List<Usuario> usuario = dao.listarUsuarios();
            
            conn.fecharConexao();

        %>
        
        <table>         
            <tr>
                <th>Codigo</th>
                <th>Login</th>
                <th>Nome</th>
                <th>Senha</th>
                <th>Ações</th>
            </tr>
            
            <% for(Usuario c:usuario){
            %>
            <tr>
                <td><%= c.getCodigo()%></td>
                <td><%= c.getLogin()%></td>
                <td><%= c.getNome() %></td>
                <td><%= "******" %></td>
                </td>
                <td> 
                    <a href="ExcluirUsuario?id=<%=c.getCodigo()%>" title="Excluir">
                    <img src="images/trash.png" height="20" width="20"/> </a>
                    <a href="AlterarUsuario?id=<%=c.getCodigo()%>" title="Alterar">
                    <img src="images/edit.png" height="20" width="20"/> </a>
                    <a href="AlterarSenhaUsuario?id=<%=c.getCodigo()%>" title="Alterar Senha">
                    <img src="images/edit-1.png" height="20" width="20"/> </a>
                </td>                                                
            </tr>              
            <%} %>

        </table> 
            <c:import url="rodape.jsp"/>
    </body>
</html>
