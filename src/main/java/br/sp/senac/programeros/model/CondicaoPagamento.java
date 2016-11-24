package br.sp.senac.programeros.model;

/**
 *
 * @author willian.carvalho
 */

public class CondicaoPagamento{
    //Atributos
    private Integer codigo;
    private String descricao;
    private String condicao;
    private String ativo;
    private String deletado;
    //Construtor
    public CondicaoPagamento() {
    }
    //Construtor
    public CondicaoPagamento(Integer codigo) {
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
    public String getCondicao() {
        return condicao;
    }
    //Metodo - SET
    public void setCondicao(String condicao) {
        this.condicao = condicao;
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
