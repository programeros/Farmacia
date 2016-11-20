package br.sp.senac.programeros.model;

import java.util.Date;

/**
 *
 * @author willian.carvalho
 */

public class VendaItem {

    private int chave;
    private int pedido;
    private int item; 
    private int produto;
    private int almoxarifado;
    private float quantidade;
    private float quantidade_entregue;
    private float preco;
    private float desconto;
    private float valor;

    public VendaItem() {
    }
    
    public VendaItem(int pedido,int item,int produto, int almoxarifado,
            float quantidade,float quantidade_entregue,float preco, 
            float desconto,float valor) {
        
        this.pedido = pedido;
        this.item = item;
        this.produto = produto;
        this.almoxarifado = almoxarifado;
        this.quantidade = quantidade;
        this.quantidade_entregue = quantidade_entregue;
        this.preco = preco;
        this.desconto = desconto;
        this.valor = valor;
    }    

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getQuantidade_entregue() {
        return quantidade_entregue;
    }

    public void setQuantidade_entregue(float quantidade_entregue) {
        this.quantidade_entregue = quantidade_entregue;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(int almoxarifado) {
        this.almoxarifado = almoxarifado;
    }

  
}
