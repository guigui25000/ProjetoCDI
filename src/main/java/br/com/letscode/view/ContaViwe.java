package br.com.letscode.view;

import br.com.letscode.dominio.Conta;

import java.math.BigDecimal;
import java.util.Scanner;

public interface ContaViwe {
    Conta createConta(Scanner sc);
    Conta depositar(Scanner sc);
    Conta sacar(Scanner sc);
    Conta verSaldo(Scanner sc);
}
