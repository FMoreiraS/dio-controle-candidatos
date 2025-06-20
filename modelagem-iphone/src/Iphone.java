import funcionalidades.ReprodutorMusical;
import funcionalidades.AparelhoTelefonico;
import funcionalidades.NavegadorInternet;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {
    @Override
    public void tocar() {
        System.out.println("Reproduzindo música.");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando música.");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("Selecionando a música " + musica + ".");
    }
    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para o número " + numero);
    }

    @Override
    public void atender() {
        System.out.println("Alguém está ligando. Atendendo ligação...");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando o correio de voz.");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo a página no endereço " + url + ".");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Nova aba adicionada.");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Página atualizada.");
    }
}
