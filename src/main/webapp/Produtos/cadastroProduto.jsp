<%-- 
    Document   : cadastroProduto
    Created on : 05/11/2016, 20:36:01
    Author     : Michael Facul
--%>
<%@page import="br.sp.senac.programeros.model.Categoria"%>
<%@page import="br.sp.senac.programeros.dao.CategoriaDAO"%>
<%@page import="br.sp.senac.programeros.model.Fornecedores"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.FornecedorDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro Produto</title>
    </head>
    <body> 
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>            
        </div>
        <hr/>
        <h2>Dados do Produto</h2>
        <form action ="../AdicionarProduto" method="get">
            Código: <input type="text" size="40" name="codigo" />
            Descrição: <input type="text" size="60" name="descricao" /><br/><br/> 
            Preço: <input type="float" placeholder="0.00" name="preco" />
            Marca: <input type="text" size="40" name="marca" /><br/><br/>                     
            Categoria: <select name="categoria"> 
                <option>Selecione a categoria</option>
                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();

                    CategoriaDAO daoC = new CategoriaDAO(conexao);
                    List<Categoria> categorias = daoC.listarCategorias();

                    FornecedorDAO daoF = new FornecedorDAO(conexao);
                    List<Fornecedores> fornecedores = daoF.listarFornecedores();

                    conn.fecharConexao();
                   
                    for (Categoria c : categorias) {                   
                %>
                <option value="<%=c.getCodigo()%>"><%=c.getDescricao()%></option>
                <%}%>
            </select>
            Fornecedor:  <select name="fornecedor">
                <option>Selecione o fornecedor</option>
                <%
                    for (Fornecedores fornecedor : fornecedores) {
                %>
                <option value="<%=fornecedor.getCodigo()%>"><%=fornecedor.getNome()%></option>
                <%}%>
            </select>

            <br/><br/><input type="submit" value="Gravar" />
            <input type="reset" value="Limpar" />                    
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>
    </div>
</aside>  
</body>
</html>
