package br.sp.senac.programeros.model;

/**
 * @author willian.carvalho
 */

public class Convenio {
    private int codigo;
    private String nome;
    private String telefone;
    private String responsavel;
    private String email;
    private String ativo;
    private String delatado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getDelatado() {
        return delatado;
    }

    public void setDelatado(String delatado) {
        this.delatado = delatado;
    }
}
