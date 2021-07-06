package br.com.letscode.service;

import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.Usuario;

import java.math.BigDecimal;

public interface ContaService {
    Conta criarConta(Conta conta);
    Conta sacar(Conta conta, BigDecimal valor);
    Conta depositar(Conta conta, BigDecimal valor);
    Conta verSaldo(Conta conta);
}
