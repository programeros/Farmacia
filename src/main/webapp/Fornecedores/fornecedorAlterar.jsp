<%-- 
    Document   : fornecedorAlterar
    Created on : 10/11/2016, 11:05:11
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.Fornecedores"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.FornecedorDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/cadastro.css"/>
        <title>Cadastro de Fornecedores</title>
    </head>
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            FornecedorDAO dao = new FornecedorDAO(conexao);

            Fornecedores fornecedor = dao.selecionar(Integer.parseInt(request.getParameter("id")));

            conn.fecharConexao();

        %>        

        <h2>Alteração do Fornecedor</h2>                 
        <hr/><br/>
        <form action ="AlterarFornecedor" method="post">
            <input type=hidden name="id" value="<%=fornecedor.getCodigo()%>" size="6"  /><br/>                    
            Nome: <input type="text" size="40" name="nome" value="<%=fornecedor.getNome()%>"/>
            Endereço: <input type="text" size="30" name="endereco" value="<%=fornecedor.getEndereco()%>"/><br/><br/>
            Bairro: <input type="text" name="bairro" value="<%=fornecedor.getBairro()%>"/>
            Cidade: <input type="text" name="cidade" value="<%=fornecedor.getCidade()%>"/>
            Estado: <input type="text" name="estado" value="<%=fornecedor.getEstado()%>"/><br/><br/>
            CEP: <input type="text" name="cep" value="<%=fornecedor.getCep()%>" />                    
            Tel.: <input type="text" name="telefone" value="<%=fornecedor.getTelefone()%>"/>
            Cel.: <input type="text" name="celular" value="<%=fornecedor.getCelular()%>"/><br/><br/>                                                                     

            Ativo: <select name="ativo" id="selectAtivo">
                <option value = "S">Sim</option>
                <option value = "N">Não</option>
                <script type="text/javascript">
                    var selected = document.getElementById("selectAtivo");
                    switch ("<%=fornecedor.getAtivo()%>") {
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