package domain;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Banco {

	private String nome;
	private Set<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		contas = new HashSet<>();
	}

	public void listarContas() {
		if (!contas.isEmpty()) {
			Set<Conta> contasPorNumero = new TreeSet<>(new CompararPorNumero());
			System.out.printf("===== Contas do Banco %s =====\n", this.getNome());
			contasPorNumero.addAll(contas);

			Consumer<Conta> exibirConta = conta -> {
				System.out.println("-------------------------------");
				conta.imprimirInfosComuns();
			};

			contasPorNumero.forEach(exibirConta);
		} else {
			System.out.println("O banco " + getNome() + " não possui contas.");
		}
	}

	public void addConta(String nomeCliente, String tipoConta) {
		if (tipoConta.equalsIgnoreCase("corrente")){
			contas.add(new ContaCorrente(new Cliente(nomeCliente)));
		} else if (tipoConta.equalsIgnoreCase("poupança")) {
			contas.add(new ContaPoupanca(new Cliente(nomeCliente)));
		} else {
			System.out.println("Falha ao adicionar a conta.");
		}
	}

	public void addConta(Conta conta) {
		if (this.contas.contains(conta)){
			System.out.println("Falha ao adicionar a conta.");
			return;
		}
		contas.add(conta);
	}

	public void addConta() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do titular: ");
		String nomeCliente = scanner.nextLine().trim();
		System.out.println("Digite o tipo de conta: ");
		String tipoConta = scanner.nextLine().trim();

		if (tipoConta.equalsIgnoreCase("corrente")){
			contas.add(new ContaCorrente(new Cliente(nomeCliente)));
		} else if (tipoConta.equalsIgnoreCase("poupança")) {
			contas.add(new ContaPoupanca(new Cliente(nomeCliente)));
		} else {
			System.out.println("Falha ao adicionar a conta.");
			return;
		}
		System.out.println("Conta criada com sucesso.");
	}

	public Conta buscarConta(int numero) {
		Conta conta = null;
		if (!contas.isEmpty()) {
			for (Conta c : contas) {
				if (c.getNumero() == numero) {
					conta = c;
				}
			}
			if (conta == null) throw new RuntimeException("A conta não existe neste banco.");
			return conta;
		} else {
			throw new RuntimeException("O banco não possui contas.");
		}
	}

	public void fecharConta(int numero) {
		Conta contaParaRemover = buscarConta(numero);
		contas.remove(contaParaRemover);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conta> getContas() {
		return contas;
	}

	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}
}
