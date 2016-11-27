package br.sp.senac.programeros.model;

public class Filiais {
    //Atributos
    private Integer codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone;
    private String responsavel;
    private String email;
    private String ativo;
    private String deletado;
    
    //Construtor
    public Filiais() {
    }
    
    //Construtor
    public Filiais(String nome, String endereco, String bairro, String cidade,
            String estado, String cep, String telefone, String responsavel,
            String email, String ativo) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.responsavel = responsavel;
        this.email = email;
        this.ativo = ativo;
    }    

    
    //Construtor
    public Filiais(int codigo, String nome, String endereco, String bairro, String cidade,
            String estado, String cep, String telefone, String responsavel,
            String email, String ativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.responsavel = responsavel;
        this.email = email;
        this.ativo = ativo;
    }      
    
    //Construtor
    public Filiais(Integer codigo) {
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
    public String getResponsavel() {
        return responsavel;
    }
    //Metodo - SET
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    //Metodo - GET
    public String getEmail() {
        return email;
    }
    //Metodo - SET
    public void setEmail(String email) {
        this.email = email;
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
