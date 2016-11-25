package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.ContasPagar;
import java.util.List;

//Interface CondicaoPagamento
public interface ContasPagarInterface {
    public void inserir(ContasPagar contasPagar);
    public void alterar(ContasPagar contasPagar);
    public List<ContasPagar> listarContasPagar();
    public ContasPagar selecionar(int id);
    public ContasPagar Remove(int id);
}