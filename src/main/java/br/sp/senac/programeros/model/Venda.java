package br.sp.senac.programeros.model;

import java.util.Date;

public class Venda {

    //Atributos
    private int codigo;
    private int numero;
    private int cliente;
    private String nome;
    private int vendedor;
    private int condicao;
    private Date data;
    private float desconto;
    private float valor;
    private int usuario;

    //Construtor
    public Venda(int numero, int cliente, int vendedor, int condicao, String nome,
            float desconto, Date data, float valor, int usuario) {
        this.numero = numero;
        this.cliente = cliente;
        this.nome = nome;
        this.vendedor = vendedor;
        this.condicao = condicao;
        this.data = data;
        this.desconto = desconto;
        this.valor = valor;
        this.usuario = usuario;
    }
    //Construtor
    public Venda(int codigo, int numero, int cliente, int vendedor, String nome,
            int condicao, float desconto, Date data, float valor, int usuario) {
        this.codigo = codigo;
        this.numero = numero;
        this.cliente = cliente;
        this.nome = nome;
        this.vendedor = vendedor;
        this.condicao = condicao;
        this.desconto = desconto;
        this.data = data;
        this.valor = valor;
        this.usuario = usuario;
    }
    //Costrutor
    public Venda() {

    }
    //Metodo - GET
    public int getCodigo() {
        return codigo;
    }
    //Metodo - sET
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    //Metodo - GET
    public int getCliente() {
        return cliente;
    }
    //Metodo - SET
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    //Metodo - GET
    public int getVendedor() {
        return vendedor;
    }
    //Metodo - SET
    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
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
    public float getDesconto() {
        return desconto;
    }
    //Metodo - SET
    public void setDesconto(float desconto) {
        this.desconto = desconto;
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
    //Metodo - SET
    public void setNumero(int numero) {
        this.numero = numero;
    }
    //Metodo - GET
    public Date getData() {
        return data;
    }
    //Metodo - SET
    public void setData(Date data) {
        this.data = data;
    }
    //Metodo - GET
    public float getValor() {
        return valor;
    }
    //Metodo - SET
    public void setValor(float valor) {
        this.valor = valor;
    }
    //Metodo - GET
    public String getNome() {
        return nome;
    }
    //Metodo - SET
    public void setNome(String nome) {
        this.nome = nome;
    }
}
