package br.sp.senac.programeros.dao;

import br.sp.senac.programeros.connection.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.sp.senac.programeros.model.Filiais;

public class FilialDAO implements br.sp.senac.programeros.interfaces.FilialInterface {
    //Conexao do banco
    Connection conexao;
    //Construtor
    public FilialDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir
    @Override
    public void inserir(Filiais filial) {
        //Comando do banco
        String sql = "insert into filiais "
                + "(nome,endereco,bairro,cidade,estado,cep,telefone,responsavel,"
                + "email,ativo) values (?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement p;
        try {
            //Setando Valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, filial.getNome());
            p.setString(2, filial.getEndereco());
            p.setString(3, filial.getBairro());
            p.setString(4, filial.getCidade());
            p.setString(5, filial.getEstado());
            p.setString(6, filial.getCep());            
            p.setString(7, filial.getTelefone());
            p.setString(8, filial.getResponsavel());            
            p.setString(9, filial.getEmail());                        
            p.setString(10, "1");          

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Alterar
    @Override
    public void alterar(Filiais filial) {
        //Comando do banco
        try {
            String sql = "UPDATE filiais "
                    + " SET nome = ?, endereco = ?, bairro = ?, cidade = ?, "
                    + " estado = ?, cep = ?, telefone = ?, responsavel = ?, email = ?, ativo = ? "                    
                    + " WHERE codigo = ?";
            //Setando valores
            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, filial.getNome());
            p.setString(2, filial.getEndereco());
            p.setString(3, filial.getBairro());
            p.setString(4, filial.getCidade());
            p.setString(5, filial.getEstado());
            p.setString(6, filial.getCep());            
            p.setString(7, filial.getTelefone());
            p.setString(8, filial.getResponsavel()); 
            p.setString(9, filial.getEmail());            
            p.setString(10, String.valueOf(filial.getAtivo()));           
            p.setInt(11, filial.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Listar
    @Override
    public List<Filiais> listarFiliais() {
        //Lista
        List<Filiais> filiais = new ArrayList<Filiais>();
        
        try {
            //Comando do banco
            String sql = "SELECT * FROM filiais WHERE isnull(deletado)";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Filiais filial = new Filiais();
                //Setando valores
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String cep = rs.getString("cep");                
                String telefone = rs.getString("telefone");
                String responsavel = rs.getString("responsavel");
                String email = rs.getString("email");                
                String ativo = rs.getString("ativo");                

                filial.setCodigo(codigo);
                filial.setNome(nome);
                filial.setEndereco(endereco);
                filial.setBairro(bairro);
                filial.setCidade(cidade);
                filial.setEstado(estado);
                filial.setCep(cep);  
                filial.setTelefone(telefone);
                filial.setResponsavel(responsavel);
                filial.setEmail(email);                
                filial.setAtivo(ativo);             

                filiais.add(filial);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filiais;
    }
    //Selecionar
    @Override
    public Filiais selecionar(int codigo) {
        //Criando o objeto Filial
        Filiais filial = new Filiais();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM filiais WHERE isnull(deletado) "
                + "AND codigo= " + codigo;

        try {
            //Setando valores
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            filial.setCodigo(codigo);
            filial.setNome(rs.getString("nome"));
            filial.setEndereco(rs.getString("endereco"));
            filial.setBairro(rs.getString("bairro"));
            filial.setCidade(rs.getString("cidade"));
            filial.setEstado(rs.getString("estado"));
            filial.setCep(rs.getString("cep"));           
            filial.setTelefone(rs.getString("telefone"));
            filial.setResponsavel(rs.getString("responsavel"));
            filial.setEmail(rs.getString("email"));           
            filial.setAtivo(rs.getString("ativo"));           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filial;

    }
    //Remover
    @Override
    public Filiais Remove(int codigo) {
        //Comando do banco
        String sql = "UPDATE filiais set isnull(deletado) WHERE codigo=?";

        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, codigo);

            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    //Inserir
//    @Override
//    public void inserir(Filiais filial) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }   
}
