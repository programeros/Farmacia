package br.sp.senac.programeros.model;

import java.sql.Date;

public class Compra{
    //Atributos
    private int codigo;
    private int numero;
    private int fornecedor;
    private int condicao;
    private int usuario;
    private Date data;
    private float valor;
    //Construtor
    public Compra() {
    }
    //Metodo - GET
    public int getCodigo() {
        return codigo;
    }   
    //Metodo - SET
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    //Metodo - GET
    public int getFornecedor() {
        return fornecedor;
    }
    //Metodo - SET
    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }
    //Metodo - GET
    public int getCondicao() {
        return condicao;
    }
    //Metodo - SET
    public void setCondicao(int condicao) {
        this.condicao = condicao;
    }
    //Metodo - GET
    public int getUsuario() {
        return usuario;
    }
    //Metodo - SET
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    //Metodo - GET
    public int getNumero() {
        return numero;
    }
    //Metodo - GET
    public Date getData() {
        return data;
    }
    //Metodo - GET
    public float getValor() {
        return valor;
    }
    //Metodo - SET
    public void setNumero(int numero) {
        this.numero = numero;
    }
    //Metodo - SET
    public void setData(Date data) {
        this.data = data;
    }
    //Metodo - SET
    public void setValor(float valor) {
        this.valor = valor;
    }

    
}
