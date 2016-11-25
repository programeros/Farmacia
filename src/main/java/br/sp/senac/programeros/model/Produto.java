package br.sp.senac.programeros.model;

public class Produto {

    //Atributos
    private int codbar;
    private String codigo;
    private String descricao;
    private float preco;
    private String marca;
    private String ativo;
    private String deletado;
    private int categoria;
    private int fornecedor;

    //Construtor
    public Produto() {
    }

    //Construtor
    public Produto(int codbar, String codigo, String descricao, float preco,
            String marca, String ativo, int categoria, int fornecedor) {
        this.codbar = codbar;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.marca = marca;
        this.ativo = ativo;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }
    //Construtor
    public Produto(int codbar, String codigo, String descricao, float preco,
            String marca, String ativo, String deletado, int categoria,
            int fornecedor) {

        this.codbar = codbar;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.marca = marca;
        this.ativo = ativo;
        this.deletado = deletado;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }
    //Constutor
    public Produto(int codbar) {
        this.codbar = codbar;
    }
    //Metodo - GET
    public int getCodbar() {
        return codbar;
    }
    //Metodo - SET
    public void setCodbar(Integer codbar) {
        this.codbar = codbar;
    }
    //Metodo - GET
    public String getCodigo() {
        return codigo;
    }
    //Metodo - SET    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    //Metodo - GET
    public String getDescricao() {
        return descricao;
    }
    //Metodo - SET
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    public String getMarca() {
        return marca;
    }
    //Metodo - SET
    public void setMarca(String marca) {
        this.marca = marca;
    }
    //Metodo - GET
    public String getAtivo() {
        return ativo;
    }
    //Metodo - SET
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    //Metodo - GET
    public String getDeletado() {
        return deletado;
    }
    //Metodo - SET
    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }
    //Metodo - GET
    public int getCategoria() {
        return categoria;
    }
    //Metodo - SET
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    //Metodo - GET
    public int getFornecedor() {
        return fornecedor;
    }
    //Metodo - SET
    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }
}
