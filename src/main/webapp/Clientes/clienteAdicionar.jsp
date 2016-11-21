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
        <form action ="../IncluirCliente" method="post">
            Nome: <input type="text" name="nome" /><br />
            Endereco: <input type="text" name="endereco" /><br />
            Bairro: <input type="text" name="bairro" /><br/>
            Cidade:  <input type="text" name="cidade" /><br />
            Estado: <input type="text" name="estado" /><br />
            Cep: <input type="text" name="cep" /><br />
            Sexo: <select name="sexo" id="sexo">
                <option value = "1">Sim</option>
                <option value = "2">Não</option> </select><br/>
            Telefone: <input type="text" name="telefone" /><br />
            Celular: <input type="text" name="celular" /><br />
            Cadastro: <input type="date" name="cadastro" /><br />
            <input type="submit" value="Gravar" />
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>
    </body>
</html>
