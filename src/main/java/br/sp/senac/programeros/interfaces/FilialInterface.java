package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Filiais;
import java.util.List;

//Interface Filial
public interface FilialInterface {
    public void inserir(Filiais filial);
    public void alterar(Filiais filial);
    public List<Filiais> listarFiliais();
    public Filiais selecionar(int id);
    public Filiais Remove(int id);
}
