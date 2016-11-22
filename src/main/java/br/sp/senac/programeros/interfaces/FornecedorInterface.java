package br.sp.senac.programeros.interfaces;
import br.sp.senac.programeros.model.Fornecedores;
import java.util.List;
/**
 *
 * @author Michael Facul
 */
public interface FornecedorInterface {
    public void inserir(Fornecedores fornecedor);
    public void alterar(Fornecedores fornecedor);
    public List<Fornecedores> listarFornecedores();
    public Fornecedores selecionar(int id);
    public Fornecedores Remove(int id);
}
