package br.sp.senac.programeros.model;

import java.util.Date;

public class VendaItem {
    //Atributos
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
    //Construtor
    public VendaItem() {
    }
    //Construtor    
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
    //Metodo - GET
    public int getChave() {
        return chave;
    }
    //Metodo - sET
    public void setChave(int chave) {
        this.chave = chave;
    }
    //Metodo - GET
    public int getPedido() {
        return pedido;
    }
    //Metodo - SET
    public void setPedido(int pedido) {
        this.pedido = pedido;
    }
    //Metodo - GET
    public int getItem() {
        return item;
    }
    //Metodo - SET
    public void setItem(int item) {
        this.item = item;
    }
    //Metodo - GET
    public float getQuantidade() {
        return quantidade;
    }
    //Metodo - SET
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
    //Metodo - GET
    public float getQuantidade_entregue() {
        return quantidade_entregue;
    }
    //Metodo - SET
    public void setQuantidade_entregue(float quantidade_entregue) {
        this.quantidade_entregue = quantidade_entregue;
    }
    //Metodo - GET
    public float getPreco() {
        return preco;
    }
    //Metodo - SET
    public void setPreco(float preco) {
        this.preco = preco;
    }
    //Metodo - GET
    public float getDesconto() {
        return desconto;
    }
    //Metodo - SET
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
    //Metodo - GET
    public float getValor() {
        return valor;
    }
    //Metodo - SET
    public void setValor(float valor) {
        this.valor = valor;
    }
    //Metodo - GET
    public int getProduto() {
        return produto;
    }
    //Metodo - SET
    public void setProduto(int produto) {
        this.produto = produto;
    }
    //Metodo - GET
    public int getAlmoxarifado() {
        return almoxarifado;
    }
    //Metodo - SET
    public void setAlmoxarifado(int almoxarifado) {
        this.almoxarifado = almoxarifado;
    }

  
}
