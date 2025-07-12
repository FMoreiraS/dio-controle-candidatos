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
			System.out.printf("===== Contas do dominio.Banco %s =====\n", this.getNome());
			contasPorNumero.addAll(contas);

			Consumer<Conta> ordenarPorNumero = conta -> {
				System.out.println("-------------------------------");
				conta.imprimirInfosComuns();
			};

			contasPorNumero.forEach(ordenarPorNumero);
		} else {
			System.out.println("O banco " + getNome() + " não possui contas.");
		}
	}

	public void fazerTransacao() {
		Set<Conta> contasOrdenadas = new TreeSet<>(new CompararPorNumero());
		//Consumer<String>
		//TODO: usar um consumer para realizar a transação de acordo com o tipo indicado pelo menu da Main.
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
		System.out.println("dominio.Conta criada com sucesso.");
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
