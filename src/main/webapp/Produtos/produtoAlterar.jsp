<%@page import="br.sp.senac.programeros.model.Fornecedores"%>
<%@page import="br.sp.senac.programeros.dao.FornecedorDAO"%>
<%@page import="br.sp.senac.programeros.model.Categoria"%>
<%@page import="br.sp.senac.programeros.dao.CategoriaDAO"%>
<%@page import="br.sp.senac.programeros.model.Produto"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.ProdutoDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>         
        <title>Cadastro de Produtos</title>
    </head>  
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            
            ProdutoDAO dao = new ProdutoDAO(conexao);
            Produto produto = dao.selecionar(Integer.parseInt(request.getParameter("id")));

            CategoriaDAO daoC = new CategoriaDAO(conexao);
            List<Categoria> categorias = daoC.listarCategorias();

            FornecedorDAO daoF = new FornecedorDAO(conexao);
            List<Fornecedores> fornecedores = daoF.listarFornecedores();
            
            conn.fecharConexao();
        %>  
        <h1>Alteração de Produto</h1>                          
        <hr/>
        <form action ="AlterarProduto" method="post">
            <input type="hidden" name="id" value="<%=produto.getCodbar()%>" size="6" /><br/>                    
            Código do Produto: <input type="text" size="40" name="codigo" value="<%= produto.getCodigo()%>"/>
            Descrição: <input type="text" size="40" name="descricao" value="<%= produto.getDescricao()%>"/>
            Preço: <input type="float" name="preco" value="<%=produto.getPreco()%>"/><br/><br/>
            Marca: <input type="text" size="40" name="marca" value="<%=produto.getMarca()%>"/><br/><br/>
            Categoria: <select name="categoria" >
            <option selected><%= produto.getCategoria()%></option>
                <%
                    for (Categoria c : categorias) {
                %> 
                <option value="<%=c.getCodigo()%>"><%=c.getDescricao()%></option>
                <%}%>
            </select><br/><br/> 
            Fornecedor: <select name="fornecedor">
                <option selected><%= produto.getFornecedor()%></option>
                <%
                    for (Fornecedores f : fornecedores) {
                %> 
                <option value="<%=f.getCodigo()%>"><%=f.getNome()%></option>
                <%}%>
            </select><br/><br/> 
            Ativo: <select name="ativo" id="selectAtivo">
                <option value = "S">Sim</option>
                <option value = "N">Não</option>
                <script type="text/javascript">
                    var selected = document.getElementById("selectAtivo");
                    switch ("<%=produto.getAtivo()%>") {
                        case "S":
                            selected.selectedIndex = 0;
                            break;
                        case "N":
                            selected.selectedIndex = 1;
                            break;
                    }
                </script>                 
            </select><br/><br/>
            <input type="submit" value="Confirmar" />
            <input type="reset" value="Limpar" />
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>                    
    </body>
</html>

