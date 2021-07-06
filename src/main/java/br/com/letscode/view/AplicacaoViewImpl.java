package br.com.letscode.view;

import br.com.letscode.Dao.UsuarioDAO;
import br.com.letscode.aplicacao.Aplicacao;
import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;

import javax.inject.Inject;
import java.util.Scanner;

public class AplicacaoViewImpl implements AplicacaoView{

    @Inject
    private ContaViwe contaViwe;
    @Inject
    private UsuarioDAO usuarioDAO;


    @Override
    public void mostrarAplicacao(Aplicacao aplicacao) {
        int opcao = 0;
        System.out.println("Bem vindo");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("O que gostaria de fazer? \n 1 - Cadastrar usuário \n 2 - Criar conta \n 3 - Visualizar usuario " +
                    "\n 4 - Visualizar saldo \n 5 - Sacar \n 6 - Depositar  \n 0 - Sair \n ");
            opcao = sc.nextInt();
            definirOpcao(sc, opcao, aplicacao);
        } while (opcao > 0);
    }

    private void definirOpcao(Scanner sc, int opcao, Aplicacao aplicacao) {
        switch (opcao) {
            case 1:
                aplicacao.createUsuario(sc);
                break;
            case 2:
                System.out.println("Informe o usuario da conta:");
                aplicacao.createConta(sc);
                break;
            case 3:
                System.out.println("Nome que dejesa buscar:");
                aplicacao.buscar(sc.next());
                break;
            case 4:
                aplicacao.verSaldo(sc);
                break;
            case 5:
                aplicacao.sacar(sc);
                break;
            case 6:
                aplicacao.depositar(sc);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("digite um valor válido");
        }
    }
}
