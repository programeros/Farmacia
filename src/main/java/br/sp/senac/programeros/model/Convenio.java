package br.sp.senac.programeros.model;

/**
 * @author willian.carvalho
 */

public class Convenio {
    
    //Atributos
    private int codigo;
    private String nome;
    private String telefone;
    private String responsavel;
    private String email;
    private char ativo;
    private char delatado;
    
    //GET - SET Codigo    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    //GET - SET Nome    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //GET - SET Telefone    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //GET - SET Responsavel    
    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    //GET - SET Email    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //GET - SET Ativo    
    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

    //GET - SET Deletado
    public char getDelatado() {
        return delatado;
    }

    public void setDelatado(char delatado) {
        this.delatado = delatado;
    }
}
