package br.sp.senac.programeros.model;

import java.sql.Date;


/**
 * @author willian.carvalho
 */
public class Compra {
    private int codigo;
    private Date data;
    private int fornecedor;
    private String produto;
    private int almoxarifado;
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

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

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
