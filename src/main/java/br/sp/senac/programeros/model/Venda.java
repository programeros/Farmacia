package br.sp.senac.programeros.model;

import java.sql.Date;


/**
 * @author willian.carvalho
 */
public class Venda {
    private int codigo;
    private Date data;
    private int cliente;
    private int vendedor;
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

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
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
