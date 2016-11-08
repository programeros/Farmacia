package br.sp.senac.programeros.model;

/**
 * @author willian.carvalho
 */
public class Categoria {
    
    //Atributos
    private int codigo;
    private String descricao;
    private char ativo;
    private char deletado;

    //GET - SET Codigo    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    //GET - SET Descricao   
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    //GET - SET Ativo   
    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }
    
    //GET - SET Deletado   
    public char getDeletado() {
        return deletado;
    }

    public void setDeletado(char deletado) {
        this.deletado = deletado;
    }
}
