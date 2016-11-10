<%-- 
    Document   : produtoAlterar
    Created on : 10/11/2016, 16:38:50
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.Produto"%>
<%@page import="br.sp.senac.programeros.dao.ProdutoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro de Fornecedores</title>
    </head>
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            ProdutoDAO dao = new ProdutoDAO(conexao);

            Produto produto = dao.selecionar(request.getParameter("id"));

            conn.fecharConexao();

        %>        
        <nav>
            <h1>Alteração do Produto</h1>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>

                <form action ="AlterarProduto" method="post">
                    Código: <input type="text" name="codigo" value="<%=produto.getCodigo()%>" size="6" disabled="disabled" /><br/>                                        
                    Descrição: <input type="text" size="60" name="descricao" value="<%=produto.getDescricao()%>"/><br/>
                    Preço: <input type="float" placeholder="0,00" name="preco" value="<%=produto.getPreco()%>"/>
                    Marca: <input type="text" size="40" name="marca" value="<%=produto.getMarca()%>"/><br/>                   
                    Categoria: <select name="categoria"> 
                        <option></option>
                          </select>
                    Fornecedor: <select name="fornecedor">                            
                        <option></option>
                          </select>  <br/>
                    <input type="submit" value="Confirmar" />
                    <input type="reset" value="Limpar" />
                    <input type="button" value="Voltar" onClick="history.go(-1)"> 
                </form>
            </div>
        </aside>
    </body>
</html>