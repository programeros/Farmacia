package br.sp.senac.programeros.model;

/**
 *
 * @author willian.carvalho
 */

public class Compra{
    
    private int codigo;
    private int fornecedor;
    private int condicao;
    private int usuario;    

    public Compra() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getCondicao() {
        return condicao;
    }

    public void setCondicao(int condicao) {
        this.condicao = condicao;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

}
