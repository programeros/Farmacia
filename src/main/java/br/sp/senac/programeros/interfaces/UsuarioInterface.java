
package br.sp.senac.programeros.interfaces;

import java.util.List;
import br.sp.senac.programeros.model.Usuario;

public interface UsuarioInterface {
    public void inserir(Usuario usuario);
    public void alterar(Usuario usuario);
    public void alterarSenha(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public Usuario selecionar(int id);
    public Usuario Remove(int id);
}
