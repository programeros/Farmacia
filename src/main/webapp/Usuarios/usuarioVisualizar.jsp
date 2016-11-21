<%-- 
    Document   : usuario
    Created on : 30/10/2016, 00:58:03
    Author     : willian.carvalho
--%>

<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.connection.Senhas"%>
<%@page import="br.sp.senac.programeros.dao.UsuarioDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@page import="br.sp.senac.programeros.model.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Cadastro de Usuarios</title>
    </head>
    <body>
        <%            
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();            
            UsuarioDAO dao = new UsuarioDAO(conexao);            
            Usuario usuario = dao.selecionar(Integer.parseInt(request.getParameter("id")));            
            conn.fecharConexao();            
            String senha = Senhas.Descriptografar(usuario.getSenha());       
        %>        
        
        <h1>Visualização de Usuario</h1>
        <hr />
        <form action =" " method="post">
            Código: <input type="text" name="val" value="<%=usuario.getCodigo()%>" size="6" disabled="disabled" /><br/>
            Login: <input type="text" name="cred" value="<%=usuario.getLogin()%>" size="25" disabled="disabled" /><br />            
            Nome: <input type="text" name="nome" value="<%=usuario.getNome()%>" size="50" disabled="disabled"/><br />
            Senha: <input type="password" name="senha" value="<%=senha%>" size="10" disabled="disabled"/><br/>
            
            Ativo: <select name="ativo" id="selectAtivo" disabled="disabled">
                <option value = "1">Sim</option>
                <option value = "2">Não</option>
                    <script type="text/javascript">
                            var selected = document.getElementById("selectAtivo");
                            switch ("<%=usuario.getAtivo()%>") {
                                case '1':
                                    selected.selectedIndex = 0;
                                    break;
                                case '2':
                                    selected.selectedIndex = 1;
                                    break;                   
                            }   
                    </script>                 
            </select><br/><br/>
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>
    </body>
</html>
