package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.CondicaoPagamento;
import java.util.List;

//Interface CondicaoPagamento
public interface CondicaoPagamentoInterface {
    public void inserir(CondicaoPagamento condicaoPagamento);
    public void alterar(CondicaoPagamento condicaoPagamento);
    public List<CondicaoPagamento> listarCondicaoPagametos();
    public CondicaoPagamento selecionar(int id);
    public CondicaoPagamento Remove(int id);
}
