<%-- 
    Document   : fornecedor
    Created on : 06/11/2016, 00:50:25
    Author     : Michael Facul
--%>
<%@page import="br.sp.senac.programeros.model.Fornecedor"%>
<%@page import="br.sp.senac.programeros.dao.FornecedorDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Fornecedores Cadastrados</title>    
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a onclick= "window.location.href = 'cadastroFornecedor.jsp'">Adicionar</a></li>
                <li><a onclick= "window.location.href = 'menu.jsp'">Voltar</a></li>                
                <li><a onclick= "window.location.href = 'index.html'">Sair</a></li>                
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>               
                <h1>Lista de Fornecedores</h1>                
                <hr />
                
                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();

                    FornecedorDAO dao = new FornecedorDAO(conexao);

                    List<Fornecedor> fornecedor = dao.listarFornecedores();

                    conn.fecharConexao();

                %>
                <table id="tblFornecedores" border="1" cellPadding ="5">         
                    <tr>
                        <th>Codigo</th>
                        <th>Nome</th>
                        <th>Endereço</th>
                        <th>Bairro</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>CEP</th>                        
                        <th>Telefone</th>
                        <th>Celular</th>
                        <th>Dta Cadastro</th>                        
                        <th>Ativo</th>
                        <th>Deletado</th>
                    </tr>

                    <% for (Fornecedor f : fornecedor) {
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
                        <td><%= f.getCelular()%></td>
                        <td><%= f.getCadastro()%></td>                                                
                        <td><%= f.getAtivo()%></td>                        
                        </td>
                        <td> <a href="ExcluirUsuario?id=<%=f.getCodigo()%>">Excluir</a></td>
                        <td> <a href="AlterarUsuario?id=<%=f.getCodigo()%>&nome=<%=f.getNome()%>
                                &endereco=<%= f.getEndereco()%>&bairro=<%= f.getBairro()%>
                                &cidade=<%= f.getCidade()%>&estado=<%= f.getEstado()%>
                                &cep=<%= f.getCep()%>&telefone=<%= f.getTelefone()%>&celular=<%= f.getCelular()%>
                                &ativo=<%= f.getAtivo()%>">                               
                                Alterar</a></td>
                    </tr>              
                    <%}%>
                </table>                 
            </div>
        </aside> 
    </body>
</html>
