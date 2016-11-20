package br.sp.senac.programeros.model;

/**
 *
 * @author willian.carvalho
 */

public class VendaItem {

    private Integer chave;
    private Integer item;
    private Float quantidade;
    private Float quantidadeEntregue;
    private Float preco;
    private Float desconto;
    private Float valor;

    public VendaItem() {
    }

    public VendaItem(Integer chave) {
        this.chave = chave;
    }

    public Integer getChave() {
        return chave;
    }

    public void setChave(Integer chave) {
        this.chave = chave;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public Float getQuantidadeEntregue() {
        return quantidadeEntregue;
    }

    public void setQuantidadeEntregue(Float quantidadeEntregue) {
        this.quantidadeEntregue = quantidadeEntregue;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }    
}
