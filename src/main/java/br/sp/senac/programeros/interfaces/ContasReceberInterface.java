package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.ContasReceber;
import java.util.List;


//Interface CondicaoPagamento
public interface ContasReceberInterface {
    public void inserir(ContasReceber contasReceber);
    public void alterar(ContasReceber contasPagar);
    public List<ContasReceber> listarContasReceber();
    public ContasReceber selecionar(int id);
    public ContasReceber Remove(int id);
}