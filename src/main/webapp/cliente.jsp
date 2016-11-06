<%-- 
    Document   : cliente
    Created on : 05/11/2016, 23:28:41
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.Cliente"%>
<%@page import="br.sp.senac.programeros.dao.ClienteDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Clientes Cadastrados</title>    
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a onclick= "window.location.href = 'cadastroCliente.jsp'">Adicionar</a></li>
                <li><a onclick= "window.location.href = 'menu.jsp'">Voltar</a></li> 
                <li><a onclick= "window.location.href = 'index.html'">Sair</a></li>                
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>               
                <h1>Lista de Clientes</h1>                
                <hr />

                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();
                    
                    ClienteDAO dao = new ClienteDAO(conexao);

                    List<Cliente> cliente = dao.listarClientes();

                    conn.fecharConexao();

                %>

                <table id="tblClientes" border="1" cellPadding ="5">         
                    <tr>
                        <th>Codigo</th>
                        <th>Nome</th>
                        <th>Endereço</th>
                        <th>Bairro</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>CEP</th>
                        <th>Sexo</th>
                        <th>Telefone</th>
                        <th>Celular</th>
                        <th>Dta Cadastro</th>
                        <th>Convenio</th>
                        <th>Ativo</th>
                        <th>Deletado</th>
                    </tr>

                    <% for (Cliente c : cliente) {
                    %>
                    <tr>
                        <td><%= c.getCodigo()%></td>
                        <td><%= c.getNome()%></td>
                        <td><%= c.getEndereco()%></td>
                        <td><%= c.getBairro()%></td>
                        <td><%= c.getCidade()%></td>
                        <td><%= c.getEstado()%></td>
                        <td><%= c.getCep()%></td>
                        <td><%= c.getSexo()%></td>
                        <td><%= c.getTelefone()%></td>
                        <td><%= c.getCelular()%></td>
                        <td><%= c.getCadastro()%></td>
                        <td><%= c.getConvenio()%></td>
                        <td><%= c.getAtivo()%></td>
                        <td><%= c.getDeletado()%></td>
                        </td>
                        <td> <a href="ExcluirUsuario?id=<%=c.getCodigo()%>">Excluir</a></td>
                        <td> <a href="AlterarUsuario?id=<%=c.getCodigo()%>&nome=<%=c.getNome()%>
                                &endereco=<%= c.getEndereco()%>&bairro=<%= c.getBairro()%>
                                &cidade=<%= c.getCidade()%>&estado=<%= c.getEstado()%>
                                &cep=<%= c.getCep()%>&sexo=<%= c.getSexo()%>
                                &telefone=<%= c.getTelefone()%>&celular=<%= c.getCelular()%>
                                &convenios_codigo=<%= c.getConvenio()%>&ativo=<%= c.getAtivo()%>">                               
                                Alterar</a></td>
                    </tr>              
                    <%}%>
                </table>                 
            </div>
        </aside> 
    </body>
</html>
