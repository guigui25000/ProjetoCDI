package br.com.letscode.service;

import br.com.letscode.Dao.ContaDao;
import br.com.letscode.Dao.UsuarioDAO;
import br.com.letscode.TipoConta;
import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.exceptions.NoUserException;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.BigInteger;


@TipoConta(value = ContaEnum.ESPECIAL)


public class ContaEspecialServiceImpl implements ContaService {

    @Inject
    private ContaDao contaDao;

    @Override
    public Conta criarConta(Conta conta) {
        System.out.println("criando conta especial");
        if (null == conta.getUsuario()) {
            throw new NoUserException("Usuário inexistente");
        }
        conta.setSaldo(new BigDecimal(400));
        contaDao.create(conta);
        return conta;
    }

    @Override
    public Conta sacar(Conta conta, BigDecimal valor) {
        BigDecimal numero = conta.getSaldo().add(new BigDecimal(200));
        int i = numero.intValue();
        if(valor.intValue() < i){
            valor = valor.multiply(new BigDecimal(-1));
            conta.setSaldo(conta.getSaldo().add(valor));
            return conta;
        }else{
            System.out.println("Valor nao permitido");
            return conta;
        }
    }

    @Override
    public Conta depositar(Conta conta, BigDecimal valor) {
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
