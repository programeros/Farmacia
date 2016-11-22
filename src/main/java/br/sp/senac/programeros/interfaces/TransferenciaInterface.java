package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Transferencia;
import java.util.List;

/**
 * @author Michael Facul
 */
public interface TransferenciaInterface {
    public void inserir(Transferencia movimento);
    public void alterar(Transferencia movimento);
    public List<Transferencia> listarMovimentos();
    public Transferencia selecionar(int id);
    public Transferencia Remove(int id);
}
