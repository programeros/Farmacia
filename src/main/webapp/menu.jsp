<%-- 
    Document   : logado
    Created on : 29/10/2016, 10:15:57
    Author     : willian.carvalho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="menu.css"/>
        <title>Menu do SGF</title>
    </head>
    <body>
        
        <nav>
            <ul class="menu">
                <li><a href="#">Cadastros</a>
                    <ul>
                        <li><a href="#">Clientes</a></li>
                        <li><a href="#">Fornecedores</a></li>
                        <li><a href="#">Vendedores</a></li>   
                        <li><a href="#">Produtos</a></li>                  
                        <li><a href="#">Almoxarifados</a></li> 
                        <li><a href="#">Filiais</a></li> 
                        <li><a href="#">Usuários</a></li> 
                    </ul>
                </li>
                <li><a href="#">Atualizações</a>
                    <ul>
                        <li><a href="#">Vendas</a></li>
                        <li><a href="#">Compras</a></li>
                        <li><a href="#">Recebimentos</a></li>                    
                        <li><a href="#">Pagamentos</a></li>
                        <li><a href="#">Transferencias</a></li>	                
                    </ul>
                </li>
                <li><a href="#">Relatorios</a>
                    <ul>
                        <li><a href="#">Relatorio1</a></li>
                        <li><a href="#">Relatorio2</a></li>
                        <li><a href="#">Relatorio3</a></li>                    
                    </ul>
                </li>
                <li><a href="#">Sobre</a>
                </li>
                <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        Usuário: ${nome}</a></li>
            </ul>
        </nav>
        
    </body>
</html>
