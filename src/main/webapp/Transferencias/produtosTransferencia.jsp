<%-- 
    Document   : produtosTransferencia
    Created on : 08/11/2016, 23:50:00
    Author     : willian.carvalho
--%>

<%@page import="br.sp.senac.programeros.model.Usuario"%>
<%@page import="br.sp.senac.programeros.dao.UsuarioDAO"%>
<%@page import="br.sp.senac.programeros.dao.ProdutoDAO"%>
<%@page import="br.sp.senac.programeros.model.Produto"%>
<%@page import="br.sp.senac.programeros.model.Almoxarifado"%>
<%@page import="br.sp.senac.programeros.dao.AlmoxarifadoDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Tranferencias</title>
    </head>
    <body>
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>            
        </div>
        <hr/>
        <h2>Transferencia de produtos</h2>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            ProdutoDAO daoP = new ProdutoDAO(conexao);
            List<Produto> produtos = daoP.listarProdutos();

            AlmoxarifadoDAO daoA = new AlmoxarifadoDAO(conexao);
            List<Almoxarifado> almoxarifados = daoA.listarAlmoxarifados();
            
            UsuarioDAO dao = new UsuarioDAO(conexao);            
            List<Usuario> usuario = dao.listarUsuarios();

            conn.fecharConexao();

        %>
        <form action ="../AdicionarTransferencia" method="get">                       
            Produto: <select name="produto" > 
                <option>Selecione produto</option>
                <%                    
                    for (Produto p : produtos) {
                %> 
                <option value="<%=p.getCodbar()%>"><%=p.getMarca()%> - <%=p.getDescricao()%></option>
                <%}%>
            </select><br/><br/> 
            Quantidade: <input type="number" required="required" size="5" name="quantidade" /><br/><br/>  
            Almoxarifado Origem: <select name="almOri" >
                <option>Selecione almoxarifado origem</option>
                <%
                    for (Almoxarifado a : almoxarifados) {
                %> 
                <option value="<%=a.getCodigo()%>"><%=a.getDescricao()%></option>
                <%}%>
            </select><br/><br/>  
            Almoxarifado Destino: <select name="almDes">
                <option>Selecione almoxarifado destino</option>
                <%
                    for (Almoxarifado a : almoxarifados) {
                %> 
                <option value="<%=a.getCodigo()%>"><%=a.getDescricao()%></option>
                <%}%>
            </select><br/><br/>
            Usuario: <select name="usuario">
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
