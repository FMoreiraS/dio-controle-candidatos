import domain.*;

import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Banco banco = new Banco("Neo");

		int option = 0;
		while(true) {
			System.out.printf("\n====== BANCO %s ======\n", banco.getNome());
			System.out.println("==== MENU PRINCIPAL ====");
			System.out.println("1. Listar Contas");
			System.out.println("2. Criar conta");
			System.out.println("3. Consultar extrato");
			System.out.println("4. Depositar");
			System.out.println("5. Sacar");
			System.out.println("6. Transferir");
			System.out.println("7. Sair");

			option = input.nextInt();
			Set<Conta> contas = banco.getContas();
			int numConta;
			double valor;
			Conta contaUsuario = null;
			switch (option) {
				case 1:
					banco.listarContas();
					option = 0;
					break;
				case 2:
					banco.addConta();
					option = 0;
					break;
				case 3:
						System.out.println("Digite o número da conta que deseja consultar.");
						numConta = input.nextInt();
						contaUsuario = banco.buscarConta(numConta);
						contaUsuario.imprimirExtrato();
					break;
				case 4:
						System.out.println("Digite o número da conta que receberá o depósito.");
						numConta = input.nextInt();
						System.out.println("Digite o valor do depósito.");
						valor = input.nextInt();
						contaUsuario = banco.buscarConta(numConta);
						contaUsuario.depositar(valor);
					option = 0;
					break;
				case 5:
					System.out.println("Digite o número da sua conta");
					numConta = input.nextInt();
					contaUsuario = banco.buscarConta(numConta);
					System.out.println("Digite o valor que deseja sacar.");
					contaUsuario.sacar(input.nextDouble());
					option = 0;
					break;
				case 6:
					System.out.println("Digite o número da conta que transferirá.");
					numConta = input.nextInt();
					System.out.println("Digite o número da conta que receberá a transferência.");
					int numContaDestino = input.nextInt();
					System.out.println("Digite o valor da transferência.");
					valor = input.nextDouble();
					if (numConta != numContaDestino) {
						contaUsuario = banco.buscarConta(numConta);
						Conta contaDestino = banco.buscarConta(numContaDestino);
						contaUsuario.transferir(valor, contaDestino);
					} else {
						System.out.println("A transferência deve ocorrer entre contas distintas.");
					}
					option = 0;
					break;
				case 7:
					System.out.println("Encerrando o aplicativo.");
					input.close();
					return;
				default:
					System.out.println("Selecione uma opção de 1 a 6.");
					option = 0;
			}
		}
	}
}
