package br.com.letscode.Dao;

import br.com.letscode.dominio.Usuario;

import java.io.IOException;

public interface UsuarioDAO {
    public Usuario create(Usuario usuario) throws IOException;
    public Usuario buscar(String nome);
}
