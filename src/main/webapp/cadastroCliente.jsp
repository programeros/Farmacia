<%-- 
    Document   : cliente
    Created on : 03/11/2016, 12:59:31
    Author     : Michael Facul
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro de Cliente</title>
    </head>
    <body>
             
        <nav>
            <ul class="menu">
                <li><a href="#">Pesquisar</a>
                    <ul>
                        <li><a href="cliente.jsp">Clientes Cadastrados</a></li>                        
                    </ul>
                </li>              
                <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        Usu�rio: ${nome}</a></li>
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>
                
                    <legend><h2>Dados Pessoais do Cliente</h2></legend>
                <form action ="AdicionarCliente" method="get">
                    Nome: <input type="text" size="40" name="nome" />
                    Endere�o: <input type="text" size="30" name="endereco" /><br/>
                    Bairro: <input type="text" name="bairro" />
                    Cidade: <input type="text" name="cidade" />
                    Estado: <input type="text" name="estado" /><br/>
                    CEP: <input type="text" name="cep" />
                    Sexo: <select name="sexo">
                            <option value="M">Masculino</option>
                            <option value="F">Feminino</option>
                          </select><br />
                    Tel.: <input type="text" name="telefone" />
                    Cel.: <input type="text" name="celular" /><br/>                                                                      
                    Convenio: <select name="convenio" id="selectConvenio">
                            <option value="1">Amil</option>
                            <option value="2">Allians</option>
                            <option value="3">Bradesco Saude</option>                              
                          </select><br />
                    <br/><input type="submit" value="Gravar" />
                    <input type="reset" value="Limpar" />                    
                    <input type="button" value="Voltar" onClick="history.go(-1)"> 
                </form>
            </div>
        </aside>        
    </body>
</html>
