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
        <link rel="stylesheet" type="text/css" href="clientes.css"/>
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
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>
            <div class="pesquisa">
                <label for="select">Pesquisar:</label>				
                <input type="text" name="textfield" id="textfield">
                <label id="pesquisa"><img src="../images/search.png" width="15" height="11" alt=""/></label>
            </div>
        </div>
        <h1>Alteração de Cliente</h1>                          
        <hr/>
        <form action ="AlterarCliente" method="post">
            <input type=hidden name="id" value="<%=cliente.getCodigo()%>" size="6" /><br/>                    
            Nome: <input type="text" size="40" name="nome" value="<%=cliente.getNome()%>"/>
            Endereço: <input type="text" size="30" name="endereco" value="<%=cliente.getEndereco()%>"/><br/><br/> 
            Bairro: <input type="text" name="bairro" value="<%=cliente.getBairro()%>"/>
            Cidade: <input type="text" name="cidade" value="<%=cliente.getCidade()%>"/>
            Estado: <input type="text" name="estado" value="<%=cliente.getEstado()%>"/><br/><br/> 
            CEP: <input type="text" name="cep" value="<%=cliente.getCep()%>" />
            Sexo: <select name="sexo" id="selectSexo">
                <option value = "M">Masculino</option>
                <option value = "F">Feminino</option>
            </select><br/><br/> 
            Tel.: <input type="text" name="telefone" value="<%=cliente.getTelefone()%>"/>
            Cel.: <input type="text" name="celular" value="<%=cliente.getCelular()%>"/><br/><br/>                       
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