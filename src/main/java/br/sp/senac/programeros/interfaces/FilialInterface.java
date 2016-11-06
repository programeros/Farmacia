/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Filial;
import java.util.List;

/**
 *
 * @author Michael Facul
 */
public interface FilialInterface {
    public void inserir(Filial filial);
    public void alterar(Filial filial);
    public List<Filial> listarFiliais();
    public Filial selecionar(int id);
    public Filial Remove(int id);
}
