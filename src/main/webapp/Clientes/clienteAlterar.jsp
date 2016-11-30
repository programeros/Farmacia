<%-- 
    Document   : clienteAlterar
    Created on : 10/11/2016, 11:04:46
    Author     : Michael Facul
--%>
<%@page import="br.sp.senac.programeros.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.ClienteDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>         
        <title>Cadastro de Clientes</title>
    </head>    
    <body>                    
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            ClienteDAO dao = new ClienteDAO(conexao);

            Cliente cliente = dao.selecionar(Integer.parseInt(request.getParameter("id")));

            conn.fecharConexao();

        %>                
                          
        <h1>Alteração de Cliente</h1>                          
        <hr/>
        <form action ="AlterarCliente" method="post">
            <input type=hidden name="id" value="<%=cliente.getCodigo()%>" size="6" /><br/>                    
            Nome: <input type="text" size="40" name="nome" maxlength="30" value="<%=cliente.getNome()%>"/>
            Endereço: <input type="text" size="30" name="endereco" maxlength="30" value="<%=cliente.getEndereco()%>"/><br/><br/> 
            Bairro: <input type="text" name="bairro" maxlength="25" value="<%=cliente.getBairro()%>"/>
            Cidade: <input type="text" name="cidade" maxlength="20" value="<%=cliente.getCidade()%>"/>
            Estado: <input type="text" name="estado" maxlength="2" value="<%=cliente.getEstado()%>"/><br/><br/> 
            CEP: <input type="text" name="cep" maxlength="8" value="<%=cliente.getCep()%>" />
            Sexo: <select name="sexo" id="selectSexo">
                <option value = "M">Masculino</option>
                <option value = "F">Feminino</option>
            </select><br/><br/> 
            Tel.: <input type="text" name="telefone" maxlength="11" value="<%=cliente.getTelefone()%>"/>
            Cel.: <input type="text" name="celular" maxlength="11" value="<%=cliente.getCelular()%>"/><br/><br/>                       
            Ativo: <select name="ativo" id="selectAtivo">
                <option value = "S">Sim</option>
                <option value = "N">Não</option>
                <script type="text/javascript">
                    var selected = document.getElementById("selectAtivo");
                    switch ("<%=cliente.getAtivo()%>") {
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