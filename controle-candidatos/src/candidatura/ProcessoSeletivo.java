package candidatura;

import java.util.InputMismatchException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.Scanner;

public class ProcessoSeletivo {
    public static double salarioBase = 2000D;
    public static String[] selecionados = new String[5];
    public static String[] candidatos = {"Alfonso", "Carlos", "Luzia", "Margarida", "Francisco", "Isabel", "Pedro", "Teresa", "Joana", "Marcos"};

    public static void main(String[] args) {
        selecionarCandidatos();
        listarSelecionados();
        ligarParaSelecionados();
        analisarCandidato();
    }

    static void selecionarCandidatos() {
        int candidatoAtual = 0;
        int candidatosSelecionados = 0;

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = definirPretensao();
            System.out.println(candidato + " pretende receber salário de " + salarioPretendido);
            if(salarioPretendido <= salarioBase) {
                System.out.println(candidato + " corresponde com a vaga.");
                selecionados[candidatosSelecionados] = candidato;
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    public static double definirPretensao() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void analisarCandidato() throws InputMismatchException {
        double salarioPretendido;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Deseja testar a análise de candidato com valor aleatório?(s/n)");
        String resposta = scanner.next();
        try {
            if (resposta.equalsIgnoreCase("s")) {
                salarioPretendido = definirPretensao();
            } else if (resposta.equalsIgnoreCase("n")) {
                System.out.println("Digite o valor de salário pretendido, usando . para valores decimais se necessário:");
                salarioPretendido = scanner.nextDouble();
            } else {
                System.out.println("Resposta inválida");
                return;
            }
            System.out.printf("Pretensão salarial: %.2f ", salarioPretendido);
            if(salarioPretendido < salarioBase) {
                System.out.println("Ligar para o candidato.");
            } else if(salarioPretendido == salarioBase) {
                System.out.println("Ligar para o candidato com contra-proposta.");
            } else {
                System.out.println("Aguardar o resultado dos demais candidatos.");
            }
        } catch(InputMismatchException exception) {
            System.err.println("A resposta deve ser um número, com '.' para valores decimais.");
        }
        scanner.close();
    }

    public static void listarSelecionados() {
        System.out.println("Lista de candidatos selecionados:");
        for(int i = 0; i < selecionados.length; i++) {
            if(selecionados[i] == null) selecionados[i] = "Não selecionado";
            System.out.println("Candidato no. " + (i+1) + ": " + selecionados[i]);
        }
    }

    public static void ligarParaSelecionado(String candidato) {
        if (candidato.equals("Não selecionado")) return;
        int tentativasRealizadas = 1;
        boolean continuarTentando;
        do {
            continuarTentando = !atender();
            if (continuarTentando) {
                tentativasRealizadas++;
                if (tentativasRealizadas == 3) {
                    System.out.println("Não conseguimos contato com " + candidato);
                }
            } else {
                System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + "ª tentativa.");
            }
        } while (continuarTentando && tentativasRealizadas < 3);
    }
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    public static void ligarParaSelecionados() {
        for(int i = 0; i < selecionados.length; i++) {
            ligarParaSelecionado(selecionados[i]);
        }
    }
}
