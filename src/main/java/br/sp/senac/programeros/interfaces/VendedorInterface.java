package br.sp.senac.programeros.interfaces;


import br.sp.senac.programeros.model.Vendedor;
import java.util.List;

/**
 *
 * @author Michael Facul
 */
public interface VendedorInterface {
    public void inserir(Vendedor vendedor);
    public void alterar(Vendedor vendedor);
    public List<Vendedor> listarUsuarios();
    public Vendedor selecionar(int id);
    public Vendedor Remove(int id);
}
