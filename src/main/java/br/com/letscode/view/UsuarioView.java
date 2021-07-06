package br.com.letscode.view;

import br.com.letscode.dominio.Usuario;

import java.util.Scanner;

public interface UsuarioView {
    public Usuario create(Scanner sc);
    public Usuario visu(String nome);
}
