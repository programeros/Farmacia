<%-- 
    Document   : cliente
    Created on : 03/11/2016, 12:59:31
    Author     : Michael Facul
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/cadastro.css"/>
        <title>Cadastro de Cliente</title>
    </head>
    <body>  
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>            
        </div>
         <hr/>               
            <h2>Dados Pessoais do Cliente</h2><br/>
            
            <form action ="AdicionarCliente" method="get">
                Nome: <input type="text" size="40" name="nome" />
                Endereço: <input type="text" size="30" name="endereco" /><br/><br/> 
                Bairro: <input type="text" name="bairro" />
                Cidade: <input type="text" name="cidade" />
                Estado: <input type="text" name="estado" /><br/><br/> 
                CEP: <input type="text" name="cep" />
                Sexo: <select name="sexo">
                    <option value="M">Masculino</option>
                    <option value="F">Feminino</option>
                </select><br /><br/> 
                Tel.: <input type="text" name="telefone" />
                Cel.: <input type="text" name="celular" /><br/><br/>                                                                                           
                <br/><input type="submit" value="Gravar" />
                <input type="reset" value="Limpar" />                    
                <input type="button" value="Voltar" onClick="history.go(-1)"> 
            </form>
                      
    </body>
</html>
