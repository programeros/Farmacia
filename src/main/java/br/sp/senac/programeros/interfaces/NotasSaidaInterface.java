package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Notassaida;
import java.util.List;

public interface NotasSaidaInterface {
    public void inserir(Notassaida notas);
    public void alterar(Notassaida notas);
    public List<Notassaida> listarNotassaida();
    public Notassaida selecionar(int codigo);
    public Notassaida Remove(int codigo);
}
