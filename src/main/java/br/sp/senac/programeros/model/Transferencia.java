package br.sp.senac.programeros.model;

import java.util.Date;

public class Transferencia{
    //Atributos
    private Integer chave;
    private Date data;
    private Float quantidade;
    private int produto;
    private int origem;
    private int destino;
    private int usuario;        
    //Construtor
    public Transferencia() {
    }
    //Construtor
    public Transferencia(Integer chave) {
        this.chave = chave;
    }
    //Metodo - gET
    public Integer getChave() {
        return chave;
    }
    //Metodo - SET
    public void setChave(Integer chave) {
        this.chave = chave;
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
    public Float getQuantidade() {
        return quantidade;
    }
    //Metodo - SET
    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
    //Metodo - GET
    public int getProduto() {
        return produto;
    }
    //Metodo - SET
    public void setProduto(int produto) {
        this.produto = produto;
    }
    //Metodo - SET    
    public void setOrigem(int origem) {
        this.origem = origem;
    }
    //Metodo - SET
    public void setDestino(int destino) {
        this.destino = destino;
    }
    //Metodo - SET
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    //Metodo - GET
    public int getOrigem() {
        return origem;
    }
    //Metodo - GET
    public int getDestino() {
        return destino;
    }
    //Metodo - GET
    public int getUsuario() {
        return usuario;
    }
}
