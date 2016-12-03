<%-- 
    Document   : pagamentosAlterar
    Created on : 02/12/2016, 20:30:56
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.ContasPagar"%>
<%@page import="br.sp.senac.programeros.dao.ContasPagarDAO"%>
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
        <title>Alteração de Pagamento</title>
    </head>
    <body>
        <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();
                    
                    ContasPagarDAO daoP = new ContasPagarDAO(conexao);
                    ContasPagar contas = daoP.selecionar(Integer.parseInt(request.getParameter("id")));

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
               <h1>Alteração de Pagamento</h1>                          
        <hr/>
        <form action ="AlterarPagamento" method="post">
            <input type="hidden" name="id" value="<%=contas.getChave()%>" /><br/>   
            Serie: <input type="text" required="required" size="30" maxlength="3" name="serie" value="<%= contas.getSerie()%>"/>
            Titulo: <input type="text" required="required" size="30" maxlength="9" name="titulo" value="<%= contas.getTitulo()%>"/>
            Parcela: <input type="text" required="required" size="30" maxlength="1" name="parcela" value="<%= contas.getParcela()%>"/><br/><br/>
            Fornecedor:  <select required="required" name="fornecedor">
                <option selected><%= contas.getFornecedor()%></option>
                <%
                    for (Fornecedores fornecedor : fornecedores) {
                %>
                <option value="<%=fornecedor.getCodigo()%>"><%=fornecedor.getNome()%></option>
                <%}%>
            </select>
            Data de Emissão: <input type="date" required="required" size="30" maxlength="19" name="data_emissao" value="<%= contas.getDataEmissao()%>"/><br/><br/> 
            Valor: <input type="text" required="required" size="30" maxlength="12" name="valor" value="<%= contas.getValor()%>"/>                    
            Valor Baixado: <input type="text" required="required" size="30" maxlength="12" name="valor_baixado" value="<%= contas.getValorBaixado()%>"/><br/><br/>                      
            Pedido de Compra: <select name="pedido"> 
                <option selected><%= contas.getPedido()%></option>
                <%
                    for (Compra c : compras) {
                %>
                <option value="<%=c.getCodigo()%>"><%=c.getCodigo()%></option>
                <%}%>
            </select>
            Notas de Entrada:<select name="notasentrada"> 
                <option selected><%= contas.getNotasEntrada()%></option>
                <%
                    for (Notasentrada n : notas) {
                %>
                <option value="<%=n.getChave()%>"><%=n.getSerie()%></option>
                <%}%>
            </select><br/><br/> 
            Data de Baixa: <input type="date" required="required" size="30" maxlength="19" name="baixa" value="<%= contas.getDataBaixa()%>"/>                 
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
