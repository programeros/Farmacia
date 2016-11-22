package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Categoria;
import java.util.List;

public interface CategoriaInterface {
    public void inserir(Categoria categoria);
    public void alterar(Categoria categoria);
    public List<Categoria> listarCategorias();
    public Categoria selecionar(int id);
    public Categoria Remove(int id);
}