package br.com.letscode.aplicacao;

import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.view.AplicacaoView;
import br.com.letscode.view.AplicacaoViewImpl;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

    public static void main(String[] args) {
        final WeldContainer container = new Weld().initialize();
        final Aplicacao aplicacao = container.select(Aplicacao.class).get();
        init(aplicacao);
    }

    private static void init(Aplicacao aplicacao) {
        AplicacaoView aplicacaoView = new AplicacaoViewImpl();
        aplicacaoView.mostrarAplicacao(aplicacao);
    }
}
