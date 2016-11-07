<%-- 
    Document   : filial
    Created on : 06/11/2016, 13:07:12
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.dao.FilialDAO"%>
<%@page import="br.sp.senac.programeros.model.Filial"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Filiais Cadastradas</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a onclick= "window.location.href = 'cadastroFilial.jsp'">Adicionar</a></li>
                <li><a onclick= "window.location.href = 'menu.jsp'">Voltar</a></li>                
                <li><a onclick= "window.location.href = 'index.html'">Sair</a></li>                
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>               
                <h1>Lista de Filiais</h1>                
                <hr />
                
                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();

                    FilialDAO dao = new FilialDAO(conexao);

                    List<Filial> filial = dao.listarFiliais();

                    conn.fecharConexao();

                %>
                <table id="tblFilial" border="1" cellPadding ="5">         
                    <tr>
                        <th>Codigo</th>
                        <th>Nome</th>
                        <th>Endereço</th>
                        <th>Bairro</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>CEP</th>                        
                        <th>Telefone</th>
                        <th>Email</th>                        
                        <th>Ativo</th>
                        <th>Deletado</th>
                    </tr>

                    <% for (Filial f : filial) {
                    %>
                    <tr>
                        <td><%= f.getCodigo()%></td>
                        <td><%= f.getNome()%></td>
                        <td><%= f.getEndereco()%></td>
                        <td><%= f.getBairro()%></td>
                        <td><%= f.getCidade()%></td>
                        <td><%= f.getEstado()%></td>
                        <td><%= f.getCep()%></td>                        
                        <td><%= f.getTelefone()%></td>
                        <td><%= f.getEmail()%></td>                        
                        <td><%= f.getAtivo()%></td>
                        <td><%= f.getDeletado()%></td>
                        </td>
                        <td> <a href="ExcluirFilial?id=<%=f.getCodigo()%>">Excluir</a></td>
                        <td> <a href="AlterarFilial?id=<%=f.getCodigo()%>&nome=<%=f.getNome()%>
                                &endereco=<%= f.getEndereco()%>&bairro=<%= f.getBairro()%>
                                &cidade=<%= f.getCidade()%>&estado=<%= f.getEstado()%>
                                &cep=<%= f.getCep()%>&telefone=<%= f.getTelefone()%>
                                &email=<%= f.getEmail()%>&ativo=<%= f.getAtivo()%>">                               
                                Alterar</a></td>
                    </tr>              
                    <%}%>
                </table>                 
            </div>
        </aside> 
    </body>
</html>
