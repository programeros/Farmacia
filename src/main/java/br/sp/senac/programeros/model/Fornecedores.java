package br.sp.senac.programeros.model;

import java.util.Date;

public class Fornecedores{
    //Atribitos
    private Integer codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone;
    private String celular;
    private Date cadastro;
    private String ativo;
    private String deletado;
    //Construtor
    public Fornecedores() {
    }
    //Construtor
    public Fornecedores(Integer codigo) {
        this.codigo = codigo;
    }
    //Metodo - GET
    public Integer getCodigo() {
        return codigo;
    }
    //Metodo - SET
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    //Metodo - GET
    public String getNome() {
        return nome;
    }
    //Metodo - SET
    public void setNome(String nome) {
        this.nome = nome;
    }
    //Metodo - GET
    public String getEndereco() {
        return endereco;
    }
    //Metodo - SET
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    //Metodo - GET
    public String getBairro() {
        return bairro;
    }
    //Metodo - SET
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    //Metodo - GET
    public String getCidade() {
        return cidade;
    }
    //Metodo - SET
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    //Metodo - GET
    public String getEstado() {
        return estado;
    }
    //Metodo - SET
    public void setEstado(String estado) {
        this.estado = estado;
    }
    //Metodo - GET
    public String getCep() {
        return cep;
    }
    //Metodo - SET
    public void setCep(String cep) {
        this.cep = cep;
    }
    //Metodo - GET
    public String getTelefone() {
        return telefone;
    }
    //Metodo - SET
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }   
    //Metodo - GET
    public String getCelular() {
        return celular;
    }
    //Metodo - SET
    public void setCelular(String celular) {
        this.celular = celular;
    }
    //Metodo - GET
    public Date getCadastro() {
        return cadastro;
    }
    //Metodo - SET
    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }
    //Metodo - GET
    public String getAtivo() {
        return ativo;
    }   
    //Metodo - SET
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    //Metodo - GET
    public String getDeletado() {
        return deletado;
    }
    //Metodo - SET
    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }
}
