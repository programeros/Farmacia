package br.sp.senac.programeros.model;

/**
 *
 * @author willian.carvalho
 */

public class Produto{

    private Integer codbar;
    private String codigo;
    private String descricao;
    private Float preco;
    private String marca;
    private String ativo;
    private String deletado;
    private int categoria;
    private int fornecedor;

    public Produto() {
    }

    public Produto(Integer codbar) {
        this.codbar = codbar;
    }

    public Integer getCodbar() {
        return codbar;
    }

    public void setCodbar(Integer codbar) {
        this.codbar = codbar;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }
}
