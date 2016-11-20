package br.sp.senac.programeros.model;

import java.util.Date;
/**
 *
 * @author willian.carvalho
 */

public class Venda {
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

    public Venda(int numero, int cliente, int vendedor, int condicao, String nome,
            float desconto, Date data, float valor,int usuario) {
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

       public Venda(int codigo, int numero, int cliente, int vendedor, String nome,
            int condicao,float desconto,Date data,float valor, int usuario) {
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

    public Venda() {
        
    }
    
    
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
