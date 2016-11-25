package br.sp.senac.programeros.model;

public class Usuario {
    //Construtor
    private int codigo;
    private String login;
    private String nome;
    private String senha;
    private String ativo;
    private String deletado;
    //Construtor
    public Usuario() {
    }
    //Construtor
    public Usuario(String login, String nome, String senha, String ativo) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
    }
    //Construtor
    public Usuario(int codigo, String login, String nome, String senha, String ativo) {
        this.codigo = codigo;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
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
    public String getLogin() {
        return login;
    }
    //Metodo - SET
    public void setLogin(String login) {
        this.login = login;
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
    public String getSenha() {
        return senha;
    }
    //Metodo - SET
    public void setSenha(String senha) {
        this.senha = senha;
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