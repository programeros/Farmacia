package br.sp.senac.programeros.model;

import java.util.Date;

public class Notassaida{
    //Atributos
    private Integer chave;
    private String serie;
    private String numero;
    private int pedido;
    private Float valor;
    private Date data;
    private Date vencimento;
    private Integer parcelas;
    private int usuario;
    //Construtor
    public Notassaida() {
    }
    //Construtor
    public Notassaida(Integer chave) {
        this.chave = chave;
    }
    //Metodo - GET
    public Integer getChave() {
        return chave;
    }
    //Metodo - SET
    public void setChave(Integer chave) {
        this.chave = chave;
    }
    //Metodo - GET
    public String getSerie() {
        return serie;
    }
    //Metodo - SET
    public void setSerie(String serie) {
        this.serie = serie;
    }
    //Metodo - GET
    public String getNumero() {
        return numero;
    }
    //Metodo - SET
    public void setNumero(String numero) {
        this.numero = numero;
    }
    //Metodo - GET
    public Float getValor() {
        return valor;
    }
    //Metodo - SET
    public void setValor(Float valor) {
        this.valor = valor;
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
    public Date getVencimento() {
        return vencimento;
    }
    //Metodo - SET
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
    //Metodo - GET
    public Integer getParcelas() {
        return parcelas;
    }
    //Metodo - SET
    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }        
    //Metodo - GET    
    public void setPedido(int pedido) {
        this.pedido = pedido;
    }
    //Metodo - SET
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    //Metodo - GET
    public int getPedido() {
        return pedido;
    }
    //Metodo - GET
    public int getUsuario() {
        return usuario;
    }
}
