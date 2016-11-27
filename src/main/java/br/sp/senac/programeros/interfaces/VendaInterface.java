package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Venda;
import java.util.List;

//Interface Venda
public interface VendaInterface {
    public void inserirVenda(Venda venda);
    public void inserirItens(int pedido);
    public Venda RemoverVenda(int pedido);
    public List<Venda> listarPedidos();
}
