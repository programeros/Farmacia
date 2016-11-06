<%-- 
    Document   : cadastroProduto
    Created on : 05/11/2016, 20:36:01
    Author     : Michael Facul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro Produto</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a href="#">Inserir</a></li>
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
                    <legend><h2>Dados do Produto</h2></legend>
                <form class="formulario" action ="AdicionarProduto" method="post">
                    Código: <input type="text" size="40" name="codigo" />
                    Descrição: <input type="text" size="60" name="descricao" /><br/>
                    Preço: <input type="float" placeholder="0,00" name="preco" />
                    Marca: <input type="text" size="40" name="marca" /><br/>                    
                    Categoria: <select name="categoria">                            
                          </select>
                    Fornecedor: <select name="fornecedor">                            
                          </select>
                    Unidade: <select name="unidade">                            
                          </select><br/><br/>                                                    
                </fieldset>
                    <br/><input type="submit" value="Gravar" />
                    <input type="reset" value="Limpar" />                    
                    <input type="button" value="Voltar" onClick="history.go(-1)"> 
                </form>
            </div>
        </aside>  
    </body>
</html>
