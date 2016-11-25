package br.sp.senac.programeros.model;

/**
 * @author willian.carvalho
 */

public class Almoxarifado {
    private int codigo;
    private String descricao;
    private int filial;
    private String ativo;
    private String deletado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

    public String getAtivo() {
        return ativo;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }
    
    
}
