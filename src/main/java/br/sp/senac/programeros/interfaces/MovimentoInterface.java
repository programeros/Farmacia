package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Movimento;
import java.util.List;

/**
 * @author Michael Facul
 */
public interface MovimentoInterface {
    public void inserir(Movimento movimento);
    public void alterar(Movimento movimento);
    public List<Movimento> listarMovimentos();
    public Movimento selecionar(int id);
    public Movimento Remove(int id);
}
