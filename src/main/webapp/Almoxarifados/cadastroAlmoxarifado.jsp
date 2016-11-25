<%-- 
    Document   : cadastroAlmoxarifado
    Created on : 05/11/2016, 21:49:58
    Author     : Michael Facul
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Cadastro Almoxarifado</title>
    </head>
    <body>
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>            
        </div>
        <hr/> 
        <h2>Dados do Almoxarifado</h2>
        <form action ="../AdicionarAlmoxarifado" method="get">                    
            Descrição: <input type="text" size="60" name="descricao" /><br/><br/>                    
            Filial: <select name="filial">  
                <option value="1">Teste</option>
            </select><br/><br/>                                                                    
            <input type="submit" value="Gravar" />
            <input type="reset" value="Limpar" />                    
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>                   
    </body>
</html>
