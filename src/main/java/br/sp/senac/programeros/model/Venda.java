package br.sp.senac.programeros.model;

/**
 *
 * @author willian.carvalho
 */

public class Venda {
    private int codigo;
    private int cliente;
    private int vendedor;
    private int condicao;
    private float desconto;
    private int usuario;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public int getCondicao() {
        return condicao;
    }

    public void setCondicao(int condicao) {
        this.condicao = condicao;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}
