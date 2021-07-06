package br.com.letscode.Dao;

import br.com.letscode.dominio.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UsuarioFileDaoImpl implements UsuarioDAO {

    @Override
    public Usuario create(Usuario usuario){
        //TODO salvar em um arquivo e resgatar o caminho do arquivo.
        String filename = usuario.getNome();
        try{
            File arquivo = new File( "D:\\ProjetosIDEIA\\ProjetoCDI\\src\\main\\java\\br\\com\\letscode\\Dao\\Aqruivos\\"+filename );
            arquivo.createNewFile();
            FileWriter fw = new FileWriter( arquivo );
            BufferedWriter bw = new BufferedWriter( fw );
            bw.write(usuario.getNome());
            bw.newLine();
            bw.write(usuario.getIdade().toString());
            bw.newLine();
            bw.write("D:\\ProjetosIDEIA\\ProjetoCDI\\src\\main\\java\\br\\com\\letscode\\Dao\\Aqruivos\\"+filename);
            bw.newLine();
            usuario.setCaminhoArquivo("D:\\ProjetosIDEIA\\ProjetoCDI\\src\\main\\java\\br\\com\\letscode\\Dao\\Aqruivos\\"+filename);
            bw.close();
            fw.close();
            return usuario;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

    }

    public Usuario buscar(String nome){
        String filename = "D:\\ProjetosIDEIA\\ProjetoCDI\\src\\main\\java\\br\\com\\letscode\\Dao\\Aqruivos\\"+ nome;
        File arquivo = new File(filename);
        int cont = 0;
        if(arquivo.exists()){
            Usuario usuario = new Usuario();
            try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
                String linha;
                while((linha = br.readLine()) != null){
                    if(cont == 0){
                        usuario.setNome(linha);
                        cont++;
                    }else if(cont == 1){
                        usuario.setIdade(Integer.parseInt(linha));
                        cont++;
                    }else if(cont == 2){
                        usuario.setCaminhoArquivo(linha);
                    }
                }
                return usuario;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Usuario nao encontrado");
        }
        return null;
    }
}
