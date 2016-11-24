<%-- 
    Document   : incluir_pedido
    Created on : 23/11/2016, 12:34:50
    Author     : smarangoni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../Formularios/head.jsp" ></c:import>
<c:import url="../Formularios/header.jsp" ></c:import>


    <form class="form-inline">
        <div class="form-group">
            <label for="codigo">Codigo do Produto</label>
            <input class="input-default" type="search" name="codigo" value="" />
        </div>
        <div class="form-group">
            <label for="data">Data</label>
            <input type="date" name="data" value="" />
        </div>
        <div class="form-group">
            <label for="fornecedor_codigo">Fornecedor</label>
            <input type="number" name="fornecedor_codigo" value="" />
        </div>
        <div class="form-group">
            <label for="almoxarifado_codigo">Almoxarifado</label>
            <select name="armazem_codigo" >
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
    <c:import url="../Formularios/footer.jsp" ></c:import>
