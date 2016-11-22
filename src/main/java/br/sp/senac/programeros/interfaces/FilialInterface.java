/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Filiais;
import java.util.List;

/**
 *
 * @author Michael Facul
 */
public interface FilialInterface {
    public void inserir(Filiais filial);
    public void alterar(Filiais filial);
    public List<Filiais> listarFiliais();
    public Filiais selecionar(int id);
    public Filiais Remove(int id);
}
