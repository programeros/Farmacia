package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Compra;
import java.util.List;

//Interface Compra
public interface CompraInterface {
    public void inserir(Compra compra);
    public void alterar(Compra compra);
    public List<Compra> listarCompras();
    public Compra selecionar(int id);
    public Compra Remove(int id);
}
