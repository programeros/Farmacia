<%-- 
    Document   : usuario
    Created on : 30/10/2016, 00:58:03
    Author     : willian.carvalho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro de Usuarios</title>
    </head>
    <body>
        <nav>
            <h1>Adicionar Usuario</h1>
            <div class="imagem"></div>
        </nav>

        <aside>
            <div>
                    <form action ="AdicionarUsuario" method="get">
                        Login: <input type="text" name="login" /><br /><br/>
                        Nome: <input type="text" name="nome" /><br /><br/>
                        Senha: <input type="text" name="senha" /><br/><br/>
                        <input type="submit" value="Gravar" />
                        <input type="button" value="Voltar" onClick="history.go(-1)"> 
                    </form>              
            </div>
        </aside>
    </body>
</html>
