package br.sp.senac.programeros.model;

/**
 *
 * @author willian.carvalho
 */

public class CompraItem {

    private Integer chave;
    private Integer item;
    private Float quantidade;
    private Float quantidadeEntregue;
    private Float preco;
    private Float valor;
    private Compra compra;
    private Produto produto;

    public CompraItem() {
    }

    public CompraItem(Integer chave) {
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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
