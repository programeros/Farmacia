<%-- 
    Document   : fornecedor
    Created on : 03/11/2016, 15:28:49
    Author     : Michael Facul
--%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro de Fornecedor</title>
    </head>
    <body> 
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>            
        </div>
        <hr/> 
        <h2>Dados Pessoais do Fornecedor</h2><br/>
        <form action ="../AdicionarFornecedor" method="get">
            Nome: <input type="text" size="40" name="nome" />
            Endereço: <input type="text" size="30" name="endereco" /><br/><br/>
            Bairro: <input type="text" name="bairro" />
            Cidade: <input type="text" name="cidade" />
            Estado: <input type="text" name="estado" /><br/><br/>
            CEP: <input type="text" name="cep" />                    
            Tel.: <input type="text" name="telefone" />
            Cel.: <input type="text" name="celular" /><br/><br/>                                                        
            <br/><input type="submit" value="Gravar" />
            <input type="reset" value="Limpar" />                    
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>
    </body>
</html>
