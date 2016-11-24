package br.sp.senac.programeros.model;

import java.util.Date;

/**
 *
 * @author willian.carvalho
 */

public class Notasentrada{

    private Integer chave;
    private String serie;
    private String numero;
    private int pedido;
    private Float valor;
    private Date data;
    private Date vencimento;
    private Integer parcelas;
    private int usuario;    

    public Notasentrada() {
    }

    public Notasentrada(Integer chave) {
        this.chave = chave;
    }

    public Integer getChave() {
        return chave;
    }

    public void setChave(Integer chave) {
        this.chave = chave;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }
    
    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getPedido() {
        return pedido;
    }

    public int getUsuario() {
        return usuario;
    }
}
