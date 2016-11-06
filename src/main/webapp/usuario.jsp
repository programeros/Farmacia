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
    <body>
        <c:import url="cabecalho.jsp"/>
        <h1>Lista de Usuários</h1>
        <button onclick= "window.location.href = 'usuarioAdicionar.jsp'">Adicionar</button>
        <button onclick= "window.location.href = 'menu.jsp'">Sair</button>
        <hr />
        
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            
            UsuarioDAO dao = new UsuarioDAO(conexao);
            
            List<Usuario> usuario = dao.listarUsuarios();
            
            conn.fecharConexao();

        %>
        
        <table id="tblUsuarios" border="2" cellPadding ="3">         
            <tr>
                <th>Codigo</th>
                <th>Login</th>
                <th>Nome</th>
                <th>Senha</th>
            </tr>
            
            <% for(Usuario c:usuario){
            %>
            <tr>
                <td><%= c.getCodigo()%></td>
                <td><%= c.getLogin()%></td>
                <td><%= c.getNome() %></td>
                <td><%= "******" %></td>
                </td>
                <td> <a href="ExcluirUsuario?id=<%=c.getCodigo()%>" title="Excluir">
                    <img src="IMAGES/excluir.jpg"/> </a></td>
                <td> <a href="AlterarUsuario?id=<%=c.getCodigo()%>" title="Alterar">
                        <img src="IMAGES/alterar.jpg"/> </a></td>
                <td> <a href="AlterarSenhaUsuario?id=<%=c.getCodigo()%>" title="Alterar Senha">
                        <img src="IMAGES/alterar.jpg"/> </a></td>                                                
            </tr>              
            <%} %>

        </table> 
            <c:import url="rodape.jsp"/>
    </body>
</html>
