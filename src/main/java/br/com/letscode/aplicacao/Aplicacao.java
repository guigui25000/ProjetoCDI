package br.com.letscode.aplicacao;

import br.com.letscode.Dao.UsuarioDAO;
import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.service.ContaFactory;
import br.com.letscode.service.ContaService;
import br.com.letscode.view.ContaViwe;
import br.com.letscode.view.UsuarioView;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

    @Inject
    private UsuarioView usuarioView;

    @Inject
    private ContaViwe contaViwe;

    @PostConstruct
    public void iniciar() {
        System.out.println("iniciando a aplicacao");
    }

    public void createUsuario(Scanner sc) {
        usuarioView.create(sc);
    }

    public Conta createConta(Scanner sc) {
        return contaViwe.createConta(sc);
    }

    public Conta depositar(Scanner sc){
        return contaViwe.depositar(sc);
    }

    public Conta verSaldo(Scanner sc) {return contaViwe.verSaldo(sc);}

    public void buscar(String nome){
        System.out.println(usuarioView.visu(nome));
    }

    public Conta sacar(Scanner sc){return contaViwe.sacar(sc);}
}
