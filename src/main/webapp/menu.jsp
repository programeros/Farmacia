<%-- 
    Document   : logado
    Created on : 29/10/2016, 10:15:57
    Author     : willian.carvalho
--%>

<!DOCTYPE html>
<html>
    <head>

        <title>Menu do SGF</title>
        <link rel="stylesheet" href="./css/normalize.min.css" />
        <link rel="stylesheet" href="./css/bootstrap.min.css" />
        <link rel="stylesheet" href="./css/bootstrap-theme.min.css" />
        <script src="./js/jquery-3.1.1.min.js"></script>        
        <script src="./js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        <img src="./images/logo.png" alt="Logotipo" title="SGF" style="height: 30px"/> 
                    </a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                Cadastros <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="Clientes/cliente.jsp">Clientes</a></li>
                                <li><a href="Fornecedores/fornecedor.jsp">Fornecedores</a></li>
                                <li><a href="Vendedores/vendedor.jsp">Vendedores</a></li>   
                                <li><a href="Produtos/produtos.jsp">Produtos</a></li>                  
                                <li><a href="Almoxarifados/almoxarifado.jsp">Almoxarifados</a></li> 
                                <li><a href="Filiais/filial.jsp">Filiais</a></li> 
                                <li><a href="Usuarios/usuarios.jsp">Usuários</a></li> 
                            </ul>
                        </li>
                        <li role="presentation" class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                Atualizações <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="PedidosVendas/pedidosdeVendas.jsp">Vendas</a></li>
                                <li><a href="PedidosCompras/compras.jsp">Compras</a></li>
                                <li><a href="ContasReceber/recebimentos.jsp">Recebimentos</a></li>                    
                                <li><a href="ContasPagar/pagamentos.jsp">Pagamentos</a></li>
                                <li><a href="Transferencias/transferencias.jsp">Transferencias</a></li>	                
                            </ul>
                        </li>
                        <li role="presentation" class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                Relatórios <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Relatorio1</a></li>
                                <li><a href="#">Relatorio2</a></li>
                                <li><a href="#">Relatorio3</a></li>                    
                            </ul>
                        </li>
                        <li role="presentation" class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                Sobre <span class="caret"></span>
                            </a>
                        </li>
                        <li role="presentation" class="dropdown navbar-right">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                Usuário: ${nome} <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="index.html">Logout</a></li>                                                   
                            </ul>
                        </li>                        
                    </ul>                    
                </div>
            </div>
        </nav>
    </body>
</html>
