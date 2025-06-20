public class Main {
    public static void main(String[] args) {
        var iphone = new Iphone();

        iphone.tocar();
        iphone.pausar();
        iphone.selecionarMusica("Sonata K 1");

        iphone.ligar("40028922");
        iphone.atender();
        iphone.iniciarCorreioVoz();

        iphone.exibirPagina("https://www.dio.me");
        iphone.atualizarPagina();
        iphone.atualizarPagina();
    }
}
