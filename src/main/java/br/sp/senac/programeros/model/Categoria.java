package br.sp.senac.programeros.model;

public class Categoria{
    //Atributos
    private Integer codigo;
    private String descricao;
    private String ativo;
    private String deletado;
    //Construtor
    public Categoria() {
    }
    //Construtor
    public Categoria(String descricao,String ativo) {
        this.descricao = descricao;
        this.ativo = ativo;
    }
    //Construtor 
    public Categoria(int codigo,String descricao,String ativo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.ativo = ativo;
    }        
    //Construtor
    public Categoria(Integer codigo) {
        this.codigo = codigo;
    }
    //Metodo - GET
    public Integer getCodigo() {
        return codigo;
    }
    //Metodo - SET
    public void setCodigo(Integer codigo) {
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
}
