<%-- 
    Document   : incluir_pedido
    Created on : 23/11/2016, 12:34:50
    Author     : smarangoni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>
            <div class="pesquisa">
                <label for="select">Pesquisar:</label>
                <select name="select" id="select">
                     		<option value="pedido">Pedido</option>
                    <option value="cliente">Cliente</option>
                </select>
                <input type="text" name="textfield" id="textfield">
                <label id="pesquisa"><img src="../images/search.png" width="15" height="11" alt=""/></label>
            </div>
        </div>

        <h1>Pedidos de Compras</h1>


        <fieldset>
            <form>
                <label for="codigo">Codigo do Produto</label>
                <input class="input-default" type="search" name="codigo" value="" />

                <label for="data">Data</label>
                <input type="date" name="data" value="" />

                <label for="fornecedor_codigo">Fornecedor</label>
                <input type="number" name="fornecedor_codigo" value="" />

                <label for="almoxarifado_codigo">Almoxarifado</label>
                <select name="armazem_codigo" >
                    <option value="1">Armazem 1</option>
                    <option value="2">Armazem 2</option>
                </select>
                <label for="quantidade">Quantidade</label>
                <input type="number" name="quantidade" step="5">
            </form>
        </fieldset>



        <div class="container-fluid">
            <div class="col-md-12 infCompras">
                <table class="table table-hover text-primary">
                    <thead>
                    <th id="col1" style="width: 80px">Produto</th>
                    <th id="col2" style="width: 240px">Descrição</th>
                    <th id="col3" style="width: 80px">Quantidade</th>
                    <th id="col4" style="width: 130px">Preço unitário</th>
                    <th id="col5" style="width: 80px">Valor</th>
                    <th id="col6" style="width: 60px">Excluir</th>
                    <th id="col7" style="width: 60px">Alterar</th>
                    </thead>

                    <tbody>
                        <tr>
                            <td style="width: 20px">col1</td>
                            <td style="width: 40px">col2</td>
                            <td style="width: 30px">col3</td>
                            <td style="width: 30px">col4</td>
                            <td style="width: 20px">col5</td>
                            <td>
                                <button type="button" class="btn btn-default" aria-label="Remover">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                </button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-default" aria-label="Editar">
                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                </button>
                            </td>

                        </tr>

                    </tbody>
                </table>
            </div>
    </body>
</html>