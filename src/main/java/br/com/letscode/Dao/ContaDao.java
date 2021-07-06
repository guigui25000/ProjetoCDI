package br.com.letscode.Dao;

import br.com.letscode.dominio.Conta;

public interface ContaDao {
    public Conta create(Conta conta);
    public Conta buscar(String senha, String numeroConta, String tipoConta);

}
