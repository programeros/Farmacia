<%-- 
    Document   : cadastroFilial
    Created on : 05/11/2016, 21:54:57
    Author     : Michael Facul
--%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro Filial</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a href="#">Pesquisar</a>
                    <ul>
                        <li><a href="filial.jsp">Unidades Cadastradas</a></li>                        
                    </ul>
                </li> 
                <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        Usuário: ${nome}</a></li>
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>
                <fieldset>
                    <legend><h2>Dados da Filial</h2></legend>
                <form class="formulario" action ="AdicionarFilial" method="post">
                    Nome: <input type="text" size="40" name="nome" />
                    Endereço: <input type="text" size="30" name="endereco" /><br/>
                    Bairro: <input type="text" name="bairro" />
                    Cidade: <input type="text" name="cidade" />
                    Estado: <input type="text" name="estado" /><br/>
                    CEP: <input type="text" name="cep" />                    
                    Tel.: <input type="text" name="telefone" />
                    Email: <input type="text" name="email" /><br/>                    
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
