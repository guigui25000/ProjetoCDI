package br.com.letscode.view;

import br.com.letscode.Dao.ContaDao;
import br.com.letscode.Dao.UsuarioDAO;
import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.service.ContaEspecialServiceImpl;
import br.com.letscode.service.ContaFactory;
import br.com.letscode.service.ContaNormalServiceImpl;
import br.com.letscode.service.ContaPoupancaServiceImpl;
import br.com.letscode.service.ContaService;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Scanner;



public class ContaViewImpl implements ContaViwe {
    @Inject
    private ContaFactory contaFactory;
    @Inject
    private UsuarioDAO usuarioDAO;
    @Inject
    private ContaDao contaDao;

    @Override
    public Conta createConta(Scanner sc) {
        Usuario usuario = usuarioDAO.buscar(sc.next());
        if(usuario != null){
            Conta conta = new Conta();
            System.out.println("Tipo da conta \n\t 1 - Conta Poupança \n\t 2 - Conta Especial \n\t 3 - Conta Normal");
            int opcaoConta = sc.nextInt();
            ContaEnum contaEnum = null;
            switch (opcaoConta) {
                case 1:
                    contaEnum = ContaEnum.POUPANCA;
                    conta.setTipoConta(String.valueOf(ContaEnum.POUPANCA));
                    break;
                case 2:
                    contaEnum = ContaEnum.ESPECIAL;
                    conta.setTipoConta(String.valueOf(ContaEnum.ESPECIAL));
                    break;
                case 3:
                    contaEnum = ContaEnum.NORMAL;
                    conta.setTipoConta(String.valueOf(ContaEnum.NORMAL));
            }
            System.out.println("Numero da conta:");
            conta.setNumeroConta(sc.next());
            System.out.println("Senha da conta:");
            conta.setSenha(sc.next());
            conta.setUsuario(usuario);
            ContaService contaFactoryConta = contaFactory.createConta(contaEnum);
            return contaFactoryConta.criarConta(conta);
        }
        System.out.println("Usuario nao encontrado");
        return null;
    }

    @Override
    public Conta depositar(Scanner sc) {
        String tipoConta = "",senha,numeroConta;
        System.out.println("Tipo da conta \n\t 1 - Conta Poupança \n\t 2 - Conta Especial \n\t 3 - Conta Normal");
        int opcaoConta = sc.nextInt();
        ContaEnum contaEnum = null;
        switch (opcaoConta) {
            case 1:
                contaEnum = ContaEnum.POUPANCA;
                tipoConta = String.valueOf(ContaEnum.POUPANCA);
                break;
            case 2:
                contaEnum = ContaEnum.ESPECIAL;
                tipoConta = String.valueOf(ContaEnum.ESPECIAL);
                break;
            case 3:
                contaEnum = ContaEnum.NORMAL;
                tipoConta = String.valueOf(ContaEnum.NORMAL);
        }
        System.out.println("Numero da conta:");
        numeroConta = sc.next();
        System.out.println("Senha:");
        senha = sc.next();
        System.out.println("Quanto dejesa depositar: ");
        BigDecimal valor = sc.nextBigDecimal();
        Conta conta = contaDao.buscar(tipoConta,numeroConta,senha);
        if(conta != null){
            ContaService contaFactoryConta = contaFactory.createConta(contaEnum);
            return contaDao.create(contaFactoryConta.depositar(conta,valor));
        }
        return null;
    }

    @Override
    public Conta sacar(Scanner sc) {
        String tipoConta = "",senha,numeroConta;
        System.out.println("Tipo da conta \n\t 1 - Conta Poupança \n\t 2 - Conta Especial \n\t 3 - Conta Normal");
        int opcaoConta = sc.nextInt();
        ContaEnum contaEnum = null;
        switch (opcaoConta) {
            case 1:
                contaEnum = ContaEnum.POUPANCA;
                tipoConta = String.valueOf(ContaEnum.POUPANCA);
                break;
            case 2:
                contaEnum = ContaEnum.ESPECIAL;
                tipoConta = String.valueOf(ContaEnum.ESPECIAL);
                break;
            case 3:
                contaEnum = ContaEnum.NORMAL;
                tipoConta = String.valueOf(ContaEnum.NORMAL);
        }
        System.out.println("Numero da conta:");
        numeroConta = sc.next();
        System.out.println("Senha:");
        senha = sc.next();
        System.out.println("Quanto dejesa sacar: (Use apenas numeros positivos ex: 200)\n");
        BigDecimal valor = sc.nextBigDecimal();
        Conta conta = contaDao.buscar(tipoConta,numeroConta,senha);
        if(conta != null){
            ContaService contaFactoryConta = contaFactory.createConta(contaEnum);
            return contaDao.create(contaFactoryConta.sacar(conta,valor));
        }
        return null;
    }


    @Override
    public Conta verSaldo(Scanner sc) {
        String tipoConta = "",senha,numeroConta;
        System.out.println("Tipo da conta \n\t 1 - Conta Poupança \n\t 2 - Conta Especial \n\t 3 - Conta Normal");
        int opcaoConta = sc.nextInt();
        ContaEnum contaEnum = null;
        switch (opcaoConta) {
            case 1:
                contaEnum = ContaEnum.POUPANCA;
                tipoConta = String.valueOf(ContaEnum.POUPANCA);
                break;
            case 2:
                contaEnum = ContaEnum.ESPECIAL;
                tipoConta = String.valueOf(ContaEnum.ESPECIAL);
                break;
            case 3:
                contaEnum = ContaEnum.NORMAL;
                tipoConta = String.valueOf(ContaEnum.NORMAL);
        }
        System.out.println("Numero da conta:");
        numeroConta = sc.next();
        System.out.println("Senha:");
        senha = sc.next();
        Conta conta = contaDao.buscar(tipoConta,numeroConta,senha);
        if(conta != null){
            ContaService contaFactoryConta = contaFactory.createConta(contaEnum);
            return contaDao.create(contaFactoryConta.verSaldo(conta));
        }
        return null;
    }
}
