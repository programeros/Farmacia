/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Compra;
import java.util.List;

/**
 *
 * @author Michael Facul
 */
public interface CompraInterface {
    public void inserir(Compra compra);
    public void alterar(Compra compra);
    public List<Compra> listarCompras();
    public Compra selecionar(int id);
    public Compra Remove(int id);
}
