package br.sp.senac.programeros.model;

import java.util.Date;

public class ContasReceber {
    //Atributos
    private Integer chave;
    private String serie;
    private String titulo;
    private String parcela;
    private Date dataEmissao;
    private Float valor;
    private Float valorBaixado;
    private Date dataBaixa;
    private int cliente;
    private int pedido;
    private int notasSaida;
    private int usuario; 
    //Construtor
    public ContasReceber() {
    }
    //Construtor
    public ContasReceber(Integer chave) {
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
    public String getTitulo() {
        return titulo;
    }
    //Metodo - SET
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //Metodo - GET
    public String getParcela() {
        return parcela;
    }
    //Metodo - SET
    public void setParcela(String parcela) {
        this.parcela = parcela;
    }
    //Metodo - GET
    public Date getDataEmissao() {
        return dataEmissao;
    }
    //Metodo - SET
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
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
    public Float getValorBaixado() {
        return valorBaixado;
    }
    //Metodo - SET
    public void setValorBaixado(Float valorBaixado) {
        this.valorBaixado = valorBaixado;
    }
    //Metodo - GET
    public Date getDataBaixa() {
        return dataBaixa;
    }
    //Metodo - SET
    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }
    //Metodo - GET
    public int getCliente() {
        return cliente;
    }
    //Metodo - SET
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getPedido() {
        return pedido;
    }

    public int getNotasSaida() {
        return notasSaida;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public void setNotasSaida(int notasSaida) {
        this.notasSaida = notasSaida;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    

}
