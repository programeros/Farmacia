package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Venda;
import br.sp.senac.programeros.model.VendaItem;
import java.util.List;

/**
 *
 * @author willian.carvalho
 */

public interface VendaInterface {
    public void inserirCabecalho(Venda venda);
    public void inserirItens(int pedido);
    public Venda Remove(int pedido);
    public List<Venda> listarPedidos();
}
