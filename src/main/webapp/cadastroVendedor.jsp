<%-- 
    Document   : vendedor
    Created on : 03/11/2016, 15:33:22
    Author     : Michael Facul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro do Vendedor</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a href="#">Inserir</a>
                    <ul>
                        <li><a href="#">Novo Vendedor</a></li>                        
                    </ul>
                </li>
                <li><a href="#">Pesquisar</a></li>
                <li><a href="#">Alterar</a></li>
                <li><a href="#">Excluir</a></li>
                <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        Usuário: ${nome}</a></li>
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>
                <fieldset>
                    <legend><h2>Dados Pessoais do Vendedor</h2></legend>
                <form class="formulario" action ="AdicionarCliente" method="post">
                    Nome: <input type="text" size="40" name="nome" />
                    Endereço: <input type="text" size="30" name="endereco" /><br/>
                    Bairro: <input type="text" name="bairro" />
                    Cidade: <input type="text" name="cidade" />
                    Estado: <input type="text" name="estado" /><br/>
                    CEP: <input type="text" name="cep" />
                    Sexo: <select name="sexo">
                            <option value="m">Masculino</option>
                            <option value="f">Feminino</option>
                          </select><br />
                    Tel.: <input type="text" name="telefone" />
                    Cel.: <input type="text" name="celular" /><br/>
                    Convenio: <input type="text" name="convenio" />
                    Data de Cadastro: <input type="date" name="data" />                   
                    Ativo: <input type="checkbox" name="ativo" /><br /><br/>
                </fieldset>
                    <br/><input type="submit" value="Gravar" />
                    <input type="reset" value="Limpar" />                    
                    <input type="button" value="Voltar" onClick="history.go(-1)"> 
                </form>
            </div>
        </aside> 
    </body>
</html>
