<%-- 
    Document   : logado
    Created on : 29/10/2016, 10:15:57
    Author     : willian.carvalho
--%>

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
                        <li><a href="cliente.jsp">Clientes</a></li>
                        <li><a href="fornecedor.jsp">Fornecedores</a></li>
                        <li><a href="cadastroVendedor.jsp">Vendedores</a></li>   
                        <li><a href="cadastroProduto.jsp">Produtos</a></li>                  
                        <li><a href="cadastroAlmoxarifado.jsp">Almoxarifados</a></li> 
                        <li><a href="cadastroFilial.jsp">Filiais</a></li> 
                        <li><a href="usuario.jsp">Usu�rios</a></li> 
                    </ul>
                </li>
                <li><a href="#">Atualiza��es</a>
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
                        Usu�rio: ${nome}</a></li>
            </ul>
            <div class="imagem"></div>
        </nav>
        
    </body>
</html>
