<%-- 
    Document   : novosPagamentos
    Created on : 02/12/2016, 20:30:31
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.Usuario"%>
<%@page import="br.sp.senac.programeros.dao.UsuarioDAO"%>
<%@page import="br.sp.senac.programeros.model.Notasentrada"%>
<%@page import="br.sp.senac.programeros.dao.NotasEntradaDAO"%>
<%@page import="br.sp.senac.programeros.model.Compra"%>
<%@page import="br.sp.senac.programeros.dao.CompraDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.model.Fornecedores"%>
<%@page import="br.sp.senac.programeros.dao.FornecedorDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Novos Pagamentos</title>
    </head>
    <body>
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>            
        </div>
        <hr/>
        <h2>Dados do Produto</h2>
        <form action ="../AdicionarPagamento" method="get">
            <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();

                    CompraDAO daoC = new CompraDAO(conexao);
                    List<Compra> compras = daoC.listarCompras();
                    
                    NotasEntradaDAO daoN = new NotasEntradaDAO(conexao);
                    List<Notasentrada> notas = daoN.listarNotasentrada();
                    
                    UsuarioDAO daoU = new UsuarioDAO(conexao);
                    List<Usuario> usuario = daoU.listarUsuarios();

                    FornecedorDAO daoF = new FornecedorDAO(conexao);
                    List<Fornecedores> fornecedores = daoF.listarFornecedores();

                    conn.fecharConexao();                    
                %>
            Serie: <input type="text" required="required" size="30" maxlength="3" name="serie" />
            Titulo: <input type="text" required="required" size="30" maxlength="9" name="titulo" /> 
            Parcela: <input type="text" required="required" size="30" maxlength="1" name="parcela" /><br/><br/>
            Fornecedor:  <select required="required" name="fornecedor">
                <option>Selecione fornecedor</option>
                <%
                    for (Fornecedores fornecedor : fornecedores) {
                %>
                <option value="<%=fornecedor.getCodigo()%>"><%=fornecedor.getNome()%></option>
                <%}%>
            </select>
            Data de Emissão: <input type="date" required="required" size="30" maxlength="19" name="data_emissao" /><br/><br/> 
            Valor: <input type="text" required="required" size="30" maxlength="12" name="valor" />                    
            Valor Baixado: <input type="text" required="required" size="30" maxlength="12" name="valor_baixado" /><br/><br/>                      
            Pedido de Compra: <select name="pedido"> 
                <option>Selecione codigo do pedido</option>
                <%
                    for (Compra c : compras) {
                %>
                <option value="<%=c.getCodigo()%>"><%=c.getCodigo()%></option>
                <%}%>
            </select>
            Notas de Entrada:<select name="notasentrada"> 
                <option>Selecione notas de entrada</option>
                <%
                    for (Notasentrada n : notas) {
                %>
                <option value="<%=n.getChave()%>"><%=n.getSerie()%></option>
                <%}%>
            </select><br/><br/> 
            Data de Baixa: <input type="date" required="required" size="30" maxlength="19" name="baixa" />                 
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
