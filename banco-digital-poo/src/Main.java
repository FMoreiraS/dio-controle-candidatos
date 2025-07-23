import domain.*;

import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

//		Cliente venilton = new Cliente("Venilton");
//
//		ContaCorrente cc = new ContaCorrente(venilton);
//		ContaPoupanca poupanca = new ContaPoupanca(venilton);
//
//		cc.depositar(100);
//		cc.transferir(100, poupanca);
//
//		cc.imprimirExtrato();
//		poupanca.imprimirExtrato();

		Banco banco = new Banco("Neo");
//		banco.listarContas();

//		banco.addConta(cc);
//		banco.addConta(poupanca);

//		banco.listarContas();

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
//					if (!contas.isEmpty()) {
						System.out.println("Digite o número da conta que deseja consultar.");
						numConta = input.nextInt();
						contaUsuario = banco.buscarConta(numConta);
						contaUsuario.imprimirExtrato();
//						for (Conta c : contas) {
//							if (c.getNumero() == numConta) {
//								c.imprimirExtrato();
//							}
//						}
//					} else {
//						System.out.println("O banco " + banco.getNome() + " não possui contas.");
//					}
					break;
				case 4:
//					if (!contas.isEmpty()) {
						System.out.println("Digite o número da conta que receberá o depósito.");
						numConta = input.nextInt();
						System.out.println("Digite o valor do depósito.");
						valor = input.nextInt();
						contaUsuario = banco.buscarConta(numConta);
						contaUsuario.depositar(valor);
//						for (Conta c : contas) {
//							if (c.getNumero() == numConta) c.depositar(valor);
//							break;
//						}
//					} else {
//						System.out.println("O banco " + banco.getNome() + " não possui contas.");
//					}
					option = 0;
					break;
				case 5:
					System.out.println("Digite o número da sua conta");
					numConta = input.nextInt();
					contaUsuario = banco.buscarConta(numConta);
					System.out.println("Digite o valor que deseja sacar.");
					contaUsuario.sacar(input.nextDouble());
//					for (Conta c : contas) {
//						if (c.getNumero() == numConta) {
//							System.out.println("Digite o valor que deseja sacar.");
//							c.sacar(input.nextDouble());
//						}
//					}
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
//						for (Conta c1 : contas) {
//							for (Conta c2 : contas) {
//								if (c1.getNumero() == numConta && c2.getNumero() == contaDestino) {
//									c1.transferir(valor, c2);
//									break;
//								}
//							}
//						}
					} else {
						System.out.println("A transferência deve ocorrer entre contas distintas.");
					}
					option = 0;
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
