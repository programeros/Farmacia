<%-- 
    Document   : menuprincipal
    Created on : 26/11/2016, 12:47:11
    Author     : smarangoni
--%>
<!--Criação do menu principal da aplicação-->
<nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navegacao">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">SGF</a>
                </div><!--navbar-header-->

                <!-- Inicio do Menu Superior -->
                <div class="collapse navbar-collapse" id="navegacao">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastros <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="Fornecedores/fornecedor.jsp">Fornecedores</a></li>
                                <li><a href="Vendedores/vendedor.jsp">Vendedores</a></li>   
                                <li><a href="Produtos/produtos.jsp">Produtos</a></li>                  
                                <li><a href="almoxarifado.jsp">Almoxarifados</a></li> 
                                <li><a href="filial.jsp">Filiais</a></li> 
                                <li><a href="Usuarios/usuarios.jsp">Usuários</a></li> 
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Atualizações <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="PedidosVendas/pedidosdeVendas.jsp">Vendas</a></li>
                                <li><a href="#">Compras</a></li>
                                <li><a href="#">Recebimentos</a></li>                    
                                <li><a href="#">Pagamentos</a></li>
                                <li><a href="#">Transferencias</a></li>	  
                            </ul>
                        </li>
                        
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Relatórios <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Compras</a></li>
                                <li><a href="#">Recebimentos</a></li>                    
                                <li><a href="#">Pagamentos</a></li>
                                <li><a href="#">Transferencias</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Sobre</a></li>
                    </ul> <!-- .navbar -->     
                </div> <!--Menu id=navegacao-->


            </div> <!--fechamento do container do menu -->
        </nav> <!--Fim do menu-->
