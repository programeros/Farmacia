/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Venda;
import java.util.List;

/**
 *
 * @author Michael Facul
 */
public interface VendaInterface {
    public void inserir(Venda venda);
    public void alterar(Venda venda);
    public List<Venda> listarVendas();
    public Venda selecionar(int id);
    public Venda Remove(int id);
}
