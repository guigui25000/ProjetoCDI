package br.com.letscode.service;

import br.com.letscode.Dao.ContaDao;
import br.com.letscode.TipoConta;
import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.exceptions.NoUserException;

import javax.inject.Inject;
import java.math.BigDecimal;

@TipoConta(value = ContaEnum.POUPANCA)
public class ContaPoupancaServiceImpl implements ContaService {

    @Inject
    private ContaDao contaDao;

    @Override
    public Conta criarConta(Conta conta) {
        System.out.println("criando conta normal");
        if (null == conta.getUsuario()) {
            throw new NoUserException("Usuário inexistente");
        }
        conta.setSaldo(new BigDecimal(100));
        contaDao.create(conta);
        return conta;
    }

    @Override
    public Conta sacar(Conta conta, BigDecimal valor) {
        BigDecimal juros = conta.getSaldo().multiply(new BigDecimal("0.007"));
        System.out.println(juros.toString());
        juros = conta.getSaldo().subtract(juros);
        conta.setSaldo(juros);
        System.out.println(conta.getSaldo().toString());
        valor = valor.multiply(new BigDecimal(-1));
        BigDecimal comparador = valor.add(conta.getSaldo());
        if(comparador.intValue() > 0){
            conta.setSaldo(conta.getSaldo().add(valor));
            return conta;
        }else{
            System.out.println("Valor nao permitido");
            return conta;
        }
    }

    @Override
    public Conta depositar(Conta conta, BigDecimal valor) {
        BigDecimal juros = conta.getSaldo().subtract(conta.getSaldo().multiply(new BigDecimal(0.007)));
        conta.setSaldo(juros);
        BigDecimal saldo = valor.add(conta.getSaldo());
        conta.setSaldo(saldo);
        return conta;
    }

    @Override
    public Conta verSaldo(Conta conta) {
        System.out.println("Seu saldo é:\n"+conta.getSaldo().toString());
        return conta;
    }
}
