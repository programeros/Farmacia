<%-- 
    Document   : usuario
    Created on : 30/10/2016, 00:58:03
    Author     : willian.carvalho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Cadastro de Usuarios</title>
    </head>
    <body>
        <h1>Adicionar Usuario</h1>
        <hr />
        <form action ="../AdicionarUsuario" method="get">
            Login: <input type="text" name="login" /><br />
            Nome: <input type="text" name="nome" /><br />
            Senha: <input type="text" name="senha" /><br/>
            <input type="submit" value="Gravar" />
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>
    </body>
</html>
