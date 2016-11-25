package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Cliente;
import java.util.List;

//Interface Cliente
public interface ClienteInterface {
    public void inserir(Cliente cliente);
    public void alterar(Cliente cliente);
    public List<Cliente> listarClientes();
    public Cliente selecionar(int codigo);
    public Cliente Remove(int codigo);
}
