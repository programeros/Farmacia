<%-- 
    Document   : pagamentos
    Created on : 02/12/2016, 20:29:52
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.ContasPagar"%>
<%@page import="br.sp.senac.programeros.dao.ContasPagarDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pagamentos</title>
    </head>
    <link type="text/css" href="pagamentos.css" rel="stylesheet" />
    <script src="pagamentos.js" type="text/javascript"></script>
    <body>
         <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            ContasPagarDAO dao = new ContasPagarDAO(conexao);
            List<ContasPagar> contas = dao.listarContasPagar();
            conn.fecharConexao();
            int cont = 0;
        %>   
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>
            <div class="pesquisa">
                <label for="select">Pesquisar:</label>				
                <input type="text" name="textfield" id="textfield">
                <label id="pesquisa"><img src="../images/search.png" width="15" height="11" alt=""/></label>
            </div>
        </div>
        <div class="menu">
            <p id="incluir">Incluir</p>
            <p id="visualizar">Visualizar</p>
            <p id="alterar">Alterar</p>
            <p id="excluir">Excluir</p>
            <p id="sair">Sair</p>
        </div>

        <div class="tela">
            <table id="pagamento">
            <thread>
                    <th id="col1">Codigo</th>
                    <th id="col2">Serie</th>
                    <th id="col3">Titulo</th>
                    <th id="col4">Parcela</th>
                    <th id="col5">Fornecedor_Cod</th>
                    <th id="col6">Data de Emissão</th>
                    <th id="col7">Valor</th> 
                    <th id="col8">Valor Baixado</th> 
                    <th id="col9">Pedido_Cod</th> 
                    <th id="col10">Notas Entrada_Cod</th> 
                    <th id="col11">Data de Baixa</th> 
                    <th id="col12">Usuario_Cod</th> 
                </thread>

                <% for (ContasPagar p : contas) {
                        cont++;
                %>
                <tr onclick="selecionar(this)">
                    <td><%= p.getChave()%></td>
                    <td><%= p.getSerie()%></td>
                    <td><%= p.getTitulo()%></td>
                    <td><%= p.getParcela()%></td>
                    <td><%= p.getFornecedor()%></td>
                    <td><%= p.getDataEmissao()%></td>
                    <td><%= p.getValor()%></td>
                    <td><%= p.getValorBaixado()%></td>
                    <td><%= p.getPedido()%></td>
                    <td><%= p.getNotasEntrada()%></td>
                    <td><%= p.getDataBaixa()%></td>
                    <td><%= p.getUsuario()%></td>                    
                </tr>              
                <%}%> 
            </table>
        </div>	 
    </body>
</html>    
   