package br.sp.senac.programeros.model;

import java.sql.Date;

/**
 *
 * @author willian.carvalho
 */

public class Compra{
    
    private int codigo;
    private int numero;
    private int fornecedor;
    private int condicao;
    private int usuario;
    private Date data;
    private float valor;

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

    public int getNumero() {
        return numero;
    }

    public Date getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    
}
