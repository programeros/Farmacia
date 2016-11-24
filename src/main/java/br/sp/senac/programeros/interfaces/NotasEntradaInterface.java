package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Notasentrada;
import java.util.List;

public interface NotasEntradaInterface {
    public void inserir(Notasentrada notae);
    public void alterar(Notasentrada notae);
    public List<Notasentrada> listarNotasentrada();
    public Notasentrada selecionar(int codigo);
    public Notasentrada Remove(int codigo);
}
