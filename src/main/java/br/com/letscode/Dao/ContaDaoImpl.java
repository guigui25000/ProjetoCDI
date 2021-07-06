package br.com.letscode.Dao;

import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class ContaDaoImpl implements ContaDao {
    @Override
    public Conta create(Conta conta) {
        String filename = conta.getTipoConta()+conta.getNumeroConta()+conta.getSenha();
        try{
            File arquivo = new File( "D:\\ProjetosIDEIA\\ProjetoCDI\\src\\main\\java\\br\\com\\letscode\\Dao\\ContasDao\\"+filename );
            arquivo.createNewFile();
            FileWriter fw = new FileWriter( arquivo );
            BufferedWriter bw = new BufferedWriter( fw );
            bw.write(conta.getTipoConta());
            bw.newLine();
            bw.write(conta.getNumeroConta());
            bw.newLine();
            bw.write(conta.getSenha());
            bw.newLine();
            bw.write(conta.getUsuario().toString());
            bw.newLine();
            bw.write("D:\\ProjetosIDEIA\\ProjetoCDI\\src\\main\\java\\br\\com\\letscode\\Dao\\ContasDao\\"+filename);
            bw.newLine();
            conta.setCaminhoArquivo("D:\\ProjetosIDEIA\\ProjetoCDI\\src\\main\\java\\br\\com\\letscode\\Dao\\ContasDao\\"+filename);
            bw.write(conta.getSaldo().toString());
            bw.close();
            fw.close();
            return conta;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Conta buscar(String tipoConta, String numeroConta,String senha) {
        {
            String nome = ""+tipoConta+""+numeroConta+""+senha;
            String filename = "D:\\ProjetosIDEIA\\ProjetoCDI\\src\\main\\java\\br\\com\\letscode\\Dao\\ContasDao\\"+ nome;
            File arquivo = new File(filename);
            int cont = 0;
            Conta conta = new Conta();
            Usuario usuario = new Usuario();
                try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
                    String linha;
                    while((linha = br.readLine()) != null){
                        if(cont == 0){
                            conta.setTipoConta(linha);
                        }else if(cont == 1){
                            conta.setNumeroConta((linha));
                        }else if(cont == 2){
                            conta.setSenha(linha);
                        }else if(cont == 3){
                            usuario.setNome(linha);
                        }else if(cont == 4){
                            usuario.setIdade(Integer.parseInt(linha));
                        }else if(cont == 5){
                            usuario.setCaminhoArquivo(linha);
                        } else if(cont == 6){
                            conta.setCaminhoArquivo(linha);
                        }else if(cont == 7){
                            conta.setSaldo(new BigDecimal(linha));
                        }
                        cont++;
                    }
                    conta.setUsuario(usuario);
                    return conta;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            System.out.println("Conta nao encontrado");
            return null;
        }
    }
}
