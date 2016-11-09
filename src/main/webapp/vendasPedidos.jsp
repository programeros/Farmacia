<%-- 
    Document   : vendasPedidos
    Created on : 08/11/2016, 23:48:08
    Author     : willian.carvalho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <title>Pedidos</title>
    </head>
    <body bgcolor="#ffffff">
        <h1 align="center"><img border="0" height="20" src="PageBreeze/Sample%20Website/locgraphic.jpg" style="height: 42px; width: 47px; float: left" width="22" />Pedidos de Vendas</h1>

        <hr />
        <p>Numero Pedido <input name="pedido" type="text" value="00000001" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Data: <input name="data" type="text" value="08/11/2016" /></p>

        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cliente&nbsp;&nbsp;<input name="codCliente" type="text" value="000001" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Nome:&nbsp;<input name="nomeCliente" size="43" style="height: 22px; width: 465px" type="text" value="Cliente de Testes" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>

        <hr />
        <table border="2" cellpadding="1" cellspacing="2" class="itensPedido" id="tblItensPedido" style="width: 850px">
                <thead>  
                        <tr>
                                <th scope="col" style="width: 30px">Produto</th>
                                <th scope="col" style="width: 30px">Descri&ccedil;&atilde;o</th>
                                <th scope="col" style="width: 30px">Quantidade</th>
                                <th scope="col" style="width: 50px; white-space: nowrap">Pre&ccedil;o&nbsp;Unit&aacute;rio&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                                <th scope="col" style="width: 30px">Valor</th>
                                <th scope="col" style="width: 30px">&nbsp;</th>
                                <th scope="col" style="width: 30px">&nbsp;</th>
                        </tr>
                </thead>
                <tbody>
                        <tr>
                                <td style="vertical-align: middle; text-align: center">XYZPTO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td style="white-space: nowrap">&nbsp;PRODUTO DE TESTES S.A.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;12&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td>
                                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10,00&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                                </td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 120,00</td>
                                <td style="text-align: center">&nbsp; <input name="excluir" type="button" value="Excluir" /></td>
                                <td style="text-align: center">&nbsp;<input name="alterar" type="button" value="Alterar" /></td>
                        </tr>
                </tbody>
        </table>

        <p>&nbsp;&nbsp;<input name="btnConfirmar" size="96" style="height: 24px; width: 84px" type="button" value="Confirmar" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<input name="btnCancelar" type="button" value="Cancelar" /></p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>Total do Pedido:&nbsp;&nbsp; <input name="totalPedido" type="text" value="120,00" /></p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

        <p>&nbsp;</p>

    </body>
</html>

