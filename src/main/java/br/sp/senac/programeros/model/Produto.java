package br.sp.senac.programeros.model;

/**
 *
 * @author willian.carvalho
 */

public class Produto{

    private int codbar;
    private String codigo;
    private String descricao;
    private float preco;
    private String marca;
    private String ativo;
    private String deletado;
    private int categoria;
    private int fornecedor;

    public Produto() {
    }
    
    public Produto(int codbar, String codigo, String descricao, float preco, 
            String marca, String ativo, int categoria, int fornecedor){
        this.codbar = codbar;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.marca = marca;        
        this.ativo = ativo;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    } 
    
        public Produto(int codbar, String codigo, String descricao, float preco, 
            String marca, String ativo, String deletado, int categoria, 
            int fornecedor){
            
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


    public Produto(int codbar) {
        this.codbar = codbar;
    }

    public int getCodbar() {
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
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
