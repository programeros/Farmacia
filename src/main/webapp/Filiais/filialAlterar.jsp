<%@page import="br.sp.senac.programeros.model.Filiais"%>
<%@page import="br.sp.senac.programeros.dao.FilialDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Atualizar de Filial</title>
    </head>
    <body>        
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            FilialDAO dao = new FilialDAO(conexao);

            Filiais filial = dao.selecionar(Integer.parseInt(request.getParameter("id")));

            conn.fecharConexao();

        %>        
    
        <h2>Alteração da Filial</h2>   
        <hr/><br/>
        <form action ="AlterarFilial" method="post">
            <input type=hidden name="id" value="<%=filial.getCodigo()%>" size="6"  /><br/>                    
            Nome: <input type="text" size="40" name="nome" value="<%=filial.getNome()%>"/>
            Endereço: <input type="text" size="30" name="endereco" value="<%=filial.getEndereco()%>"/><br/><br/>
            Bairro: <input type="text" name="bairro" value="<%=filial.getBairro()%>"/>
            Cidade: <input type="text" name="cidade" value="<%=filial.getCidade()%>"/>
            Estado: <input type="text" name="estado" value="<%=filial.getEstado()%>"/><br/><br/>
            CEP: <input type="text" name="cep" value="<%=filial.getCep()%>" />                    
            Tel.: <input type="text" name="telefone" value="<%=filial.getTelefone()%>"/>
            Fax.: <input type="text" name="fax" value="<%=filial.getFax()%>"/><br/> <br/>  
            Responsável: <input type="text" name="responsavel" value="<%=filial.getResponsavel()%>"/> 
            Email: <input type="text" name="email" value="<%=filial.getEmail()%>"/> 
            Ativo: <select name="ativo" id="selectFilial"><br/><br/> 
                <option value = "S">Sim</option>
                <option value = "N">Não</option>
                <script type="text/javascript">
                    var selected = document.getElementById("selectFilial");
                    switch ("<%=filial.getAtivo()%>") {
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