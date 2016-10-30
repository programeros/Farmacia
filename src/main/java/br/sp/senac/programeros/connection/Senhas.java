package br.sp.senac.programeros.connection;

/**
 * @author willian.carvalho
 */
public class Senhas {
    public static String Criptografar(String senha){
        //Criptografa
        int contador, tamanho,codigoASCII;
        String senhaCriptografada = "";
        tamanho = senha.length();
        contador = 0;
        while(contador <tamanho){
                codigoASCII = senha.charAt(contador)+130;
                senhaCriptografada = senhaCriptografada +(char) codigoASCII;
                contador++;
        }
        return senhaCriptografada;
    }
    
    public static String Descriptografar(String senha){
        //Descriptografa
        int contador, tamanho,codigoASCII;
        String senhaCriptografada = "";
        tamanho = senha.length();
        contador = 0;
        while(contador <tamanho){
                codigoASCII = senha.charAt(contador)-130;
                senhaCriptografada = senhaCriptografada +(char) codigoASCII;
                contador++;
        }
        return senhaCriptografada;
    }    
}
