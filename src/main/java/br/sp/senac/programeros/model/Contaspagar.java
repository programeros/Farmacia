package br.sp.senac.programeros.model;

import java.util.Date;

/**
 *
 * @author willian.carvalho
 */

public class Contaspagar{

    private Integer chave;
    private String serie;
    private String titulo;
    private String parcela;
    private Date dataEmissao;
    private Float valor;
    private Float valorBaixado;
    private Date dataBaixa;
    private Compra compra;
    private int fornecedor;

    public Contaspagar() {
    }

    public Contaspagar(Integer chave) {
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Float getValorBaixado() {
        return valorBaixado;
    }

    public void setValorBaixado(Float valorBaixado) {
        this.valorBaixado = valorBaixado;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }
}
