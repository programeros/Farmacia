<%-- 
    Document   : cadastroFilial
    Author     : Pedro Blasembauer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro Filial</title>
    </head>
    <body>
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>            
        </div>
        <hr/> 
        <h2>Dados Filial</h2><br/>            
        <form action ="../AdicionarFilial" method="get">
            Nome: <input type="text" size="40" name="nome" />
            Endereço: <input type="text" size="30" name="endereco" /><br/><br/>
            Bairro: <input type="text" name="bairro" />
            Cidade: <input type="text" name="cidade" />
            Estado: <input type="text" name="estado" /><br/><br/>
            CEP: <input type="text" name="cep" />                    
            Tel.: <input type="text" name="telefone" />
            Fax.: <input type="text" name="fax" /><br/><br/>
            Responsável: <input type="text" name="responsavel" />
            Email: <input type="text" name="email" /><br/><br/>                  
        <input type="submit" value="Gravar" />
        <input type="reset" value="Limpar" />                    
        <input type="button" value="Voltar" onClick="history.go(-1)"> 
    </form>
</body>
</html>
