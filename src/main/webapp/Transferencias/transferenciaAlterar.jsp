<%-- 
    Document   : transferenciaAlterar
    Created on : 30/11/2016, 12:27:30
    Author     : Michael Facul
--%>
<%@page import="br.sp.senac.programeros.model.Usuario"%>
<%@page import="br.sp.senac.programeros.model.Almoxarifado"%>
<%@page import="br.sp.senac.programeros.dao.AlmoxarifadoDAO"%>
<%@page import="br.sp.senac.programeros.dao.UsuarioDAO"%>
<%@page import="br.sp.senac.programeros.dao.ProdutoDAO"%>
<%@page import="br.sp.senac.programeros.model.Produto"%>
<%@page import="br.sp.senac.programeros.model.Transferencia"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.TransferenciaDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>         
        <title>Alteração de Transferencia</title>
    </head>
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            TransferenciaDAO dao = new TransferenciaDAO(conexao);
            Transferencia t = dao.selecionar(Integer.parseInt(request.getParameter("id")));

            ProdutoDAO daoP = new ProdutoDAO(conexao);
            List<Produto> produtos = daoP.listarProdutos();

            AlmoxarifadoDAO daoA = new AlmoxarifadoDAO(conexao);
            List<Almoxarifado> almoxarifados = daoA.listarAlmoxarifados();

            UsuarioDAO daoU = new UsuarioDAO(conexao);
            List<Usuario> usuario = daoU.listarUsuarios();

            conn.fecharConexao();
        %>  
        <h1>Alteração de Transferencia</h1>                          
        <hr/>
        <form action ="AlterarTransferencia" method="post">
            <input type=hidden name="id" value="<%=t.getChave()%>" size="6" /><br/>                    
            Produto: <select name="produto" >
                <option selected><%= t.getProduto()%></option>
                <%
                    for (Produto p : produtos) {
                %> 
                <option value="<%=p.getCodbar()%>"><%=p.getMarca()%> - <%=p.getDescricao()%></option>
                <%}%>
            </select><br/><br/> 
            Quantidade: <input type="number" required="required" size="5" name="quantidade" value="<%= t.getQuantidade()%>"/><br/><br/>  
            Almoxarifado Origem: <select name="almOri" >
                <option selected><%= t.getOrigem()%></option>
                <%
                    for (Almoxarifado a : almoxarifados) {
                %> 
                <option value="<%=a.getCodigo()%>"><%=a.getDescricao()%></option>
                <%}%>
            </select><br/><br/>  
            Almoxarifado Destino: <select name="almDes">
                <option selected><%= t.getDestino()%></option>
                <%
                    for (Almoxarifado a : almoxarifados) {
                %> 
                <option value="<%=a.getCodigo()%>"><%=a.getDescricao()%></option>
                <%}%>
            </select><br/><br/>
            Usuario: <select name="usuario">
                <option selected><%= t.getUsuario()%></option>
                <%
                    for (Usuario u : usuario) {
                %> 
                <option value="<%=u.getCodigo()%>"><%=u.getNome()%></option>
                <%}%>
            </select>

            <br/><br/><input type="submit" value="Confirmar" />
            <input type="reset" value="Limpar" />
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>                    
    </body>
</html>

