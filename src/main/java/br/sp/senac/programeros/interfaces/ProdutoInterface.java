/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Produto;
import java.util.List;

/**
 *
 * @author Michael Facul
 */
public interface ProdutoInterface {
    public void inserir(Produto produto);
    public void alterar(Produto produto);
    public List<Produto> listarUsuarios();
    public Produto selecionar(String id);
    public Produto Remove(String id);
}
