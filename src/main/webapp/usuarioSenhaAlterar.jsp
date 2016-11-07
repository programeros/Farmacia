<%-- 
    Document   : usuario
    Created on : 30/10/2016, 00:58:03
    Author     : willian.carvalho
--%>

<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.connection.Senhas"%>
<%@page import="br.sp.senac.programeros.dao.UsuarioDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@page import="br.sp.senac.programeros.model.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro de Usuarios</title>
    </head>
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            UsuarioDAO dao = new UsuarioDAO(conexao);

            Usuario usuario = dao.selecionar(Integer.parseInt(request.getParameter("id")));

            conn.fecharConexao();

            String senha = Senhas.Descriptografar(usuario.getSenha());

        %>        
        <nav>
            <h1>Alteração de Senha</h1>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>

                <form action ="AlterarSenhaUsuario" method="post">
                    Código: <input type="text" name="codigo" value="<%=usuario.getCodigo()%>" size="6" disabled="disabled" /><br/>
                    Login: <input type="text" name="login" value="<%=usuario.getLogin()%>" size="25" disabled="disabled" /><br />
                    Senha: <input type="password" name="senha" value="<%=senha%>" size="10" /><br/>
                    <input type="submit" value="Confirmar" />
                    <input type="reset" value="Limpar" />
                    <input type="button" value="Voltar" onClick="history.go(-1)"> 
                </form>
            </div>
        </aside>
    </body>
</html>
