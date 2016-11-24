<%-- 
    Document   : vendedorAlterar
    Created on : 10/11/2016, 16:13:54
    Author     : Michael Facul
--%>
<%@page import="br.sp.senac.programeros.model.Vendedor"%>
<%@page import="br.sp.senac.programeros.dao.VendedorDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Cadastro de Vendedores</title>
    </head>
    <body>        
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            VendedorDAO dao = new VendedorDAO(conexao);

            Vendedor vendedor = dao.selecionar(Integer.parseInt(request.getParameter("id")));

            conn.fecharConexao();

        %>        
    
        <h2>Alteração do Vendedor</h2>   
        <hr/><br/>
        <form action ="AlterarVendedor" method="post">
            <input type=hidden name="id" value="<%=vendedor.getCodigo()%>" size="6"  /><br/>                    
            Nome: <input type="text" size="40" name="nome" value="<%=vendedor.getNome()%>"/>
            Endereço: <input type="text" size="30" name="endereco" value="<%=vendedor.getEndereco()%>"/><br/><br/>
            Bairro: <input type="text" name="bairro" value="<%=vendedor.getBairro()%>"/>
            Cidade: <input type="text" name="cidade" value="<%=vendedor.getCidade()%>"/>
            Estado: <input type="text" name="estado" value="<%=vendedor.getEstado()%>"/><br/><br/>
            CEP: <input type="text" name="cep" value="<%=vendedor.getCep()%>" />                    
            Tel.: <input type="text" name="telefone" value="<%=vendedor.getTelefone()%>"/>
            Cel.: <input type="text" name="celular" value="<%=vendedor.getCelular()%>"/><br/> <br/>  
            Ativo: <select name="ativo" id="selectVendedor">
                <option value = "S">Sim</option>
                <option value = "N">Não</option>
                <script type="text/javascript">
                    var selected = document.getElementById("selectVendedor");
                    switch ("<%=vendedor.getAtivo()%>") {
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