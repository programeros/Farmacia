/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Almoxarifado;
import java.util.List;

/**
 *
 * @author Michael Facul
 */
public interface AlmoxarifadoInterface {
    public void inserir(Almoxarifado almoxarifado);
    public void alterar(Almoxarifado almoxarifado);
    public List<Almoxarifado> listarAlmoxarifados();
    public Almoxarifado selecionar(int id);
    public Almoxarifado Remove(int id);
}
