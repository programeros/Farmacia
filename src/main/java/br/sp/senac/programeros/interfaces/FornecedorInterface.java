package br.sp.senac.programeros.interfaces;
import br.sp.senac.programeros.model.Fornecedor;
import java.util.List;
/**
 *
 * @author Michael Facul
 */
public interface FornecedorInterface {
    public void inserir(Fornecedor fornecedor);
    public void alterar(Fornecedor fornecedor);
    public List<Fornecedor> listarUsuarios();
    public Fornecedor selecionar(int id);
    public Fornecedor Remove(int id);
}
