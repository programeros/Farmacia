package br.sp.senac.programeros.model;

public class CompraItem {
    //Atributos
    private Integer chave;
    private Integer item;
    private Float quantidade;
    private Float quantidadeEntregue;
    private Float preco;
    private Float valor;
    private Compra compra;
    private Produto produto;
    //Construtor
    public CompraItem() {
    }
    //Construtor
    public CompraItem(Integer chave) {
        this.chave = chave;
    }
    //Metodo - GET
    public Integer getChave() {
        return chave;
    }
    //Metodo - SET
    public void setChave(Integer chave) {
        this.chave = chave;
    }
    //Metodo - GET
    public Integer getItem() {
        return item;
    }
    //Metodo - SET
    public void setItem(Integer item) {
        this.item = item;
    }
    //Metodo - GET
    public Float getQuantidade() {
        return quantidade;
    }
    //Metodo - SET
    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
    //Metodo - GET
    public Float getQuantidadeEntregue() {
        return quantidadeEntregue;
    }
    //Metodo - SET
    public void setQuantidadeEntregue(Float quantidadeEntregue) {
        this.quantidadeEntregue = quantidadeEntregue;
    }
    //Metodo - GET
    public Float getPreco() {
        return preco;
    }   
    //Metodo - SET
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    //Metodo - GET
    public Float getValor() {
        return valor;
    }
    //Metodo - SET
    public void setValor(Float valor) {
        this.valor = valor;
    }
    //Metodo - GET
    public Compra getCompra() {
        return compra;
    }
    //Metodo - SET
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    //Metodo - GET
    public Produto getProduto() {
        return produto;
    }
    //Metodo - SET
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
