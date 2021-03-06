package br.com.letscode.service;

import br.com.letscode.Dao.UsuarioDAO;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.exceptions.PrecondicaoException;

import javax.inject.Inject;
import java.io.IOException;

public class UsuarioServiceImpl implements UsuarioService {


    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario create(Usuario usuario) throws PrecondicaoException, IOException {
        if (usuario.getIdade() > 18) {
            return usuarioDAO.create(usuario);
        }
        throw new PrecondicaoException("Usuario com precondições não satisfeitas");
    }
}
