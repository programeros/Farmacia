package br.sp.senac.programeros.interfaces;

import java.util.List;
import br.sp.senac.programeros.model.Produto;

//Interface Produto
public interface ProdutoInterface {
    public void inserir(Produto produto);
    public void alterar(Produto produto);
    public List<Produto> listarProdutos();
    public Produto selecionar(int produto);
    public void remove(int codigo);
}
