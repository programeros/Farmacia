package br.sp.senac.programeros.dao;


import br.sp.senac.programeros.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements br.sp.senac.programeros.interfaces.ClienteInterface{
Connection conexao;
    
    public ClienteDAO(Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public void inserir(Cliente cliente) {
        String sql = "insert into clientes "
            + "(nome, endereco, bairro, cidade, estado, cep, sexo, telefone, "
            + " celular, cadastro, ativo) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement p;
             
        
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setString(3, cliente.getBairro());            
            p.setString(4, cliente.getCidade());
            p.setString(5, cliente.getEstado());
            p.setString(6, cliente.getCep());
            p.setString(7, cliente.getSexo());
            p.setString(8, cliente.getTelefone());
            p.setString(9, cliente.getCelular());
            p.setDate(10, cliente.getCadastro());
            p.setString(11, cliente.getAtivo());
            
            p.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    @Override
    public void alterar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listarClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente selecionar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente Remove(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
