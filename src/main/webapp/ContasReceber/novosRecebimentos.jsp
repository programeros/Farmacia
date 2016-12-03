<%-- 
    Document   : novosRecebimentos
    Created on : 02/12/2016, 23:19:50
    Author     : Michael Facul
--%>
<%@page import="br.sp.senac.programeros.model.Usuario"%>
<%@page import="br.sp.senac.programeros.dao.UsuarioDAO"%>
<%@page import="br.sp.senac.programeros.model.Notassaida"%>
<%@page import="br.sp.senac.programeros.dao.NotasSaidaDAO"%>
<%@page import="br.sp.senac.programeros.model.Venda"%>
<%@page import="br.sp.senac.programeros.dao.VendaDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.model.Cliente"%>
<%@page import="br.sp.senac.programeros.dao.ClienteDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Novos Recebimentos</title>
    </head>
    <body>
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>            
        </div>
        <hr/>
        <h2>Dados do Produto</h2>
        <form action ="../AdicionarRecebimento" method="get">
            <%
                ConexaoBD conn = new ConexaoBD();
                Connection conexao = conn.obterConexao();

                VendaDAO daoC = new VendaDAO(conexao);
                List<Venda> vendas = daoC.listarPedidos();

                NotasSaidaDAO daoN = new NotasSaidaDAO(conexao);
                List<Notassaida> notas = daoN.listarNotassaida();

                UsuarioDAO daoU = new UsuarioDAO(conexao);
                List<Usuario> usuario = daoU.listarUsuarios();

                ClienteDAO daoF = new ClienteDAO(conexao);
                List<Cliente> clientes = daoF.listarClientes();

                conn.fecharConexao();
            %>
            Serie: <input type="text" required="required" size="30" maxlength="3" name="serie" />
            Titulo: <input type="text" required="required" size="30" maxlength="9" name="titulo" /> 
            Parcela: <input type="text" required="required" size="30" maxlength="1" name="parcela" /><br/><br/>
            Cliente:  <select required="required" name="cliente">
                <option>Selecione fornecedor</option>
                <%
                    for (Cliente cliente : clientes) {
                %>
                <option value="<%=cliente.getCodigo()%>"><%=cliente.getNome()%></option>
                <%}%>
            </select>
            Data de Emissão: <input type="date" required="required" size="30" maxlength="19" name="data_emissao" /><br/><br/> 
            Valor: <input type="text" required="required" size="30" maxlength="12" name="valor" />                    
            Valor Baixado: <input type="text" required="required" size="30" maxlength="12" name="valor_baixado" /><br/><br/>                      
            Pedido de Venda: <select name="pedido"> 
                <option>Selecione codigo do pedido</option>
                <%
                    for (Venda v : vendas ) {
                %>
                <option value="<%=v.getCodigo()%>"><%=v.getCodigo()%></option>
                <%}%>
            </select>
            Notas de Saida:<select name="notassaida"> 
                <option>Selecione notas de entrada</option>
                <%
                    for (Notassaida n : notas) {
                %>
                <option value="<%=n.getChave()%>"><%=n.getSerie()%></option>
                <%}%>
            </select><br/><br/> 
            Data de Baixa: <input type="date" required="required" size="30" maxlength="19" name="data_baixa" />                 
            Usuario:<select name="usuario"> 
                <option>Selecione usuario</option>
                <%
                    for (Usuario u : usuario) {
                %>
                <option value="<%=u.getCodigo()%>"><%=u.getNome()%></option>
                <%}%>
            </select>

            <br/><br/><input type="submit" value="Gravar" />
            <input type="reset" value="Limpar" />                    
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>
    </body>
</html>
