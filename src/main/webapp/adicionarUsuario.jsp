<!DOCTYPE html>
<%@page import="br.sp.senac.programeros.model.Usuario"%>
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
                <form action ="AdicionarUsuario" method="post">
                    Login: <input type="text" name="login" /><br /><br/>
                    Nome: <input type="text" name="nome" /><br /><br/>
                    Senha: <input type="text" name="senha" /><br /><br/>
                    <input type="submit" value="Gravar" />
                    <input type="button" value="Voltar" onClick="history.go(-1)"> 
                </form>
            </div>
        </aside> 
    </body>
</html>
