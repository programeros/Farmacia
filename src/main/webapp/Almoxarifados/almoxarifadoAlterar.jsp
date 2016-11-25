<%-- 
    Document   : almoxarifadoAlterar
    Created on : 25/11/2016, 15:26:49
    Author     : Michael Facul
--%>
<%@page import="br.sp.senac.programeros.model.Almoxarifado"%>
<%@page import="br.sp.senac.programeros.dao.AlmoxarifadoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Atualização de Almoxarifados</title>
    </head>
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            AlmoxarifadoDAO dao = new AlmoxarifadoDAO(conexao);
            Almoxarifado almoxarifado = dao.selecionar(Integer.parseInt(request.getParameter("id")));
            conn.fecharConexao();
        %>      
    <h2>Alteração do Almoxarifado</h2>   
        <hr/><br/>
        <form action ="AlterarAlmoxarifado" method="post">
            <input type=hidden name="id" value="<%=almoxarifado.getCodigo()%>" size="6"  /><br/>                    
            Descrição: <input type="text" size="60" name="descricao" value="<%=almoxarifado.getDescricao()%>"/><br/><br/>
            Filial <input type="text" size="30" name="filial" value="<%=almoxarifado.getFilial()%>"/><br/><br/>             
            Ativo: <select name="ativo" id="selectAlmoxarifado">
                <option value = "S">Sim</option>
                <option value = "N">Não</option>
                <script type="text/javascript">
                    var selected = document.getElementById("selectAlmoxarifado");
                    switch ("<%=almoxarifado.getAtivo()%>") {
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