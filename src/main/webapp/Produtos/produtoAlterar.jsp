<%@page import="br.sp.senac.programeros.model.Produto"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.ProdutoDAO"%>
<%@page import="java.sql.Connection"%>
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
            conn.fecharConexao();
        %>  
        <h1>Alteração de Produto</h1>                          
        <hr/>
        <form action ="AlterarCliente" method="post">
            <input type=hidden name="id" value="<%=produto.getCodigo()%>" size="6" /><br/>                    
            Descrição: <input type="text" size="40" name="nome" value="<%= produto.getDescricao()%>"/>
            Preço: <input type="text" size="30" name="endereco" value="<%=produto.getPreco()%>"/><br/><br/> 
            Fornecedor: <input type="text" name="bairro" value="<%=produto.getFornecedor()%>"/>
            Categoria: <input type="text" name="cidade" value="<%=produto.getCategoria()%>"/>
            Ativo: <select name="ativo" id="selectVendedor">
                <option value = "S">Sim</option>
                <option value = "N">Não</option>
                <script type="text/javascript">
                    var selected = document.getElementById("selectVendedor");
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
   
