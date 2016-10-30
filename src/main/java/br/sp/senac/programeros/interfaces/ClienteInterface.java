package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Cliente;
import java.util.List;

/**
 * @author willian.carvalho
 */

public interface ClienteInterface {
    public void inserir(Cliente cliente);
    public void alterar(Cliente cliente);
    public List<Cliente> listarUsuarios();
    public Cliente selecionar(int id);
    public Cliente Remove(int id);
}
