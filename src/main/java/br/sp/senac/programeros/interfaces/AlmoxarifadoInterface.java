package br.sp.senac.programeros.interfaces;

import br.sp.senac.programeros.model.Almoxarifado;
import java.util.List;

//Interface Almoxarifado
public interface AlmoxarifadoInterface {
    public void inserir(Almoxarifado almoxarifado);
    public void alterar(Almoxarifado almoxarifado);
    public List<Almoxarifado> listarAlmoxarifados();
    public Almoxarifado selecionar(int id);
    public Almoxarifado Remove(int id);
}
