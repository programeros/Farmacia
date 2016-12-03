<%-- 
    Document   : recebimentosAlterar
    Created on : 02/12/2016, 23:21:30
    Author     : Michael Facul
--%>
<%@page import="br.sp.senac.programeros.model.ContasReceber"%>
<%@page import="br.sp.senac.programeros.dao.ContasReceberDAO"%>
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
        <title>Alteração de Recebimento</title>
    </head>
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            ContasReceberDAO daoP = new ContasReceberDAO(conexao);
            ContasReceber contas = daoP.selecionar(Integer.parseInt(request.getParameter("id")));

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
        <h1>Alteração de Recebimento</h1>                          
        <hr/>
    <form action ="AlterarPagamento" method="post">
            <input type="hidden" name="id" value="<%=contas.getChave()%>" /><br/>   
            Serie: <input type="text" required="required" size="30" maxlength="3" name="serie" value="<%= contas.getSerie()%>"/>
            Titulo: <input type="text" required="required" size="30" maxlength="9" name="titulo" value="<%= contas.getTitulo()%>"/>
            Parcela: <input type="text" required="required" size="30" maxlength="1" name="parcela" value="<%= contas.getParcela()%>"/><br/><br/>
            Cliente:  <select required="required" name="cliente">
                <option selected><%= contas.getCliente()%></option>
                <%
                    for (Cliente c : clientes) {
                %>
                <option value="<%=c.getCodigo()%>"><%=c.getNome()%></option>
                <%}%>
            </select>
            Data de Emissão: <input type="date" required="required" size="30" maxlength="19" name="data_emissao" value="<%= contas.getDataEmissao()%>"/><br/><br/> 
            Valor: <input type="text" required="required" size="30" maxlength="12" name="valor" value="<%= contas.getValor()%>"/>                    
            Valor Baixado: <input type="text" required="required" size="30" maxlength="12" name="valor_baixado" value="<%= contas.getValorBaixado()%>"/><br/><br/>                      
            Pedido de Venda: <select name="pedido"> 
                <option selected><%= contas.getPedido()%></option>
                <%
                    for (Venda v : vendas) {
                %>
                <option value="<%=v.getCodigo()%>"><%=v.getCodigo()%></option>
                <%}%>
            </select>
            Notas de Entrada:<select name="notassaida"> 
                <option selected><%= contas.getNotasSaida()%></option>
                <%
                    for (Notassaida n : notas) {
                %>
                <option value="<%=n.getChave()%>"><%=n.getSerie()%></option>
                <%}%>
            </select><br/><br/> 
            Data de Baixa: <input type="date" required="required" size="30" maxlength="19" name="data_baixa" value="<%= contas.getDataBaixa()%>"/>                 
            Usuario:<select name="usuario"> 
                <option selected><%= contas.getUsuario()%></option>
                <%
                    for (Usuario u : usuario) {
                %>
                <option value="<%=u.getCodigo()%>"><%=u.getNome()%></option>
                <%}%>
            </select>
            <input type="submit" value="Confirmar" />
            <input type="reset" value="Limpar" />
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>                    
    </body>
</html>
