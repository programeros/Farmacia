<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page import="br.sp.senac.programeros.model.Usuario"%>
<html>
    <head>
        <title>Cadastro de Usuarios</title>
    </head>
    <body>
        <h1>Adicionar Usuario</h1>
        <hr />
        <form action ="AdicionarUsuario" method="post">
            Login: <input type="text" name="login" /><br />
            Nome: <input type="text" name="nome" /><br />
            Senha: <input type="text" name="senha" /><br />
            <input type="submit" value="Gravar" />
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>
        
        <c:import url="rodape.jsp"/>
    </body>
</html>
