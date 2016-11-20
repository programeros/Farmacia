package br.sp.senac.programeros.model;

import java.sql.Date;

/**
 *
 * @author willian.carvalho
 */

public class Cliente{

    private Integer codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String sexo;
    private String telefone;
    private String celular;
    private Date cadastro;
    private String ativo;
    private String deletado;

    public Cliente() {
    }
    
    public Cliente(String nome, String endereco,String bairro,String cidade,
            String estado,String cep,String sexo,String telefone,String celular,
            Date Cadastro,String ativo) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.cadastro = cadastro;
        this.ativo = ativo;
    }

     public Cliente(int codigo, String nome,String endereco,String bairro,
            String cidade,String estado,String cep,String sexo, String telefone,
            String celular,Date Cadastro,String ativo){
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.cadastro = cadastro;
        this.ativo = ativo;
    }        

    public Cliente(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }
}
