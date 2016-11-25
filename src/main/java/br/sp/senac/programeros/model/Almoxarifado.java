package br.sp.senac.programeros.model;

public class Almoxarifado {
    //Atributos
    private int codigo;
    private String descricao;
    private int filial;
    private String ativo;
    private String deletado;
    //Metodo - GET
    public int getCodigo() {
        return codigo;
    }
    //Metodo - SET
    public void setCodigo(int codigo) {
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
    public int getFilial() {
        return filial;
    }
    //Metodo - SET
    public void setFilial(int filial) {
        this.filial = filial;
    }
    //Metodo - GET
    public String getAtivo() {
        return ativo;
    }
    //Metodo - GET
    public String getDeletado() {
        return deletado;
    }
    //Metodo - SET
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    //Metodo - SET
    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }
    
    
}
