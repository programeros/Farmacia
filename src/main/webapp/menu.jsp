<%-- 
    Document   : logado
    Created on : 29/10/2016, 10:15:57
    Author     : willian.carvalho
--%>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Menu do SGF</title>
        <link href="css/menu.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        
        <c:import url="cabecalho.jsp"/>
        
        <nav>
            <ul class="menu">
                <li><a href="#">Cadastros</a>
                    <ul>
                        <li><a href="Clientes/cliente.jsp">Clientes</a></li>
                        <li><a href="Fornecedores/fornecedor.jsp">Fornecedores</a></li>
                        <li><a href="Vendedores/vendedor.jsp">Vendedores</a></li>   
                        <li><a href="Produtos/produtos.jsp">Produtos</a></li>                  
                        <li><a href="almoxarifado.jsp">Almoxarifados</a></li> 
                        <li><a href="filial.jsp">Filiais</a></li> 
                        <li><a href="Usuarios/usuarios.jsp">Usuários</a></li> 
                    </ul>
                </li>
                <li><a href="#">Atualizações</a>
                    <ul>
                        <li><a href="PedidosVendas/pedidosdeVendas.jsp">Vendas</a></li>
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
            </ul>
            <strong>Usuário:  ${nome}</strong>
            <div class="imagem"></div>
        </nav>
        
        
            
            <c:import url="rodape.jsp"/>
        
    </body>
</html>
