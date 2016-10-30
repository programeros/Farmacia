package br.sp.senac.programeros.model;

/**
 * @author willian.carvalho
 */

public class Saldos {
    private String produto;
    private int almoxarifado;
    private float quantidade;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(int almoxarifado) {
        this.almoxarifado = almoxarifado;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
}
