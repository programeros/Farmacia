package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Convenio;
import java.util.List;

public interface ConvenioInterface {
    public void inserir(Convenio convenio);
    public void alterar(Convenio convenio);
    public List<Convenio> listarConvenios();
    public Convenio selecionar(int id);
    public Convenio Remove(int id);
}
