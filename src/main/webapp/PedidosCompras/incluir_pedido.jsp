<%-- 
    Document   : incluir_pedido
    Created on : 23/11/2016, 12:34:50
    Author     : smarangoni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>Pedidos de Compras</h1>



<form class="form-inline">
    <div class="form-inline">

        <label for="codigo">Codigo do Produto</label>
        <input type="search" name="codigo" value="" />
    </div>
    <div class="form-inline">
        <label for="data">Data</label>
        <input type="date" name="data" value="" />
    </div>
    <div class="form-group">
        <label for="fornecedor_codigo">Fornecedor</label>
        <input type="number" name="fornecedor_codigo" value="" />
    </div>
    <div class="form-group">
        <label for="almoxarifado_codigo">Almoxarifado</label>
        <select name="armazem_codigo">
            <option value="1">Armazem 1</option>
            <option value="2">Armazem 2</option>
        </select>
    </div>

    <div class="form-group">
        <label for="quantidade">Quantidade</label>
        <input type="number" name="quantidade" step="5">
    </div>
    <hr />
</form>
    </body>
</html>
