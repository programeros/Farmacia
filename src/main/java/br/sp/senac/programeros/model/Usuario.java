package br.sp.senac.programeros.model;

public class Usuario {

    private int codigo;
    private String login;
    private String nome;
    private String senha;
    private String ativo;
    private String deletado;

    public Usuario() {
    }

    public Usuario(String login, String nome, String senha, String ativo) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Usuario(int codigo, String login, String nome, String senha, String ativo) {
        this.codigo = codigo;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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