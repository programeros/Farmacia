package br.sp.senac.programeros.model;

import java.util.Date;

/**
 *
 * @author willian.carvalho
 */

public class Transferencia{
    
    private Integer chave;
    private Date data;
    private Float quantidade;
    private int produto;

    public Transferencia() {
    }

    public Transferencia(Integer chave) {
        this.chave = chave;
    }

    public Integer getChave() {
        return chave;
    }

    public void setChave(Integer chave) {
        this.chave = chave;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }
}
