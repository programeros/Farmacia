package br.sp.senac.programeros.model;

import java.sql.Date;

/**
 * @author willian.carvalho
 */

public class Movimento {
    private int codigo;
    private Date data;
    private String produto;
    private int almoxarifadoOrigem;
    private int almoxarifadoDestino;
    private float quantidade;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getAlmoxarifadoOrigem() {
        return almoxarifadoOrigem;
    }

    public void setAlmoxarifadoOrigem(int almoxarifadoOrigem) {
        this.almoxarifadoOrigem = almoxarifadoOrigem;
    }

    public int getAlmoxarifadoDestino() {
        return almoxarifadoDestino;
    }

    public void setAlmoxarifadoDestino(int almoxarifadoDestino) {
        this.almoxarifadoDestino = almoxarifadoDestino;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
    
}
