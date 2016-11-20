package br.sp.senac.programeros.model;

/**
 *
 * @author willian.carvalho
 */

public class Categoria{

    private Integer codigo;
    private String descricao;
    private String ativo;
    private String deletado;

    public Categoria() {
    }
    
    public Categoria(String descricao,String ativo) {
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Categoria(int codigo,String descricao,String ativo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.ativo = ativo;
    }        

    public Categoria(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}
