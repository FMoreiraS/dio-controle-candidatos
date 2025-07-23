package domain;

import java.util.Comparator;

public abstract class Conta /*implements Comparable<dominio.Conta>*/ {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected final Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public void imprimirExtrato() {}

	public void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
		} else {
			System.out.printf("O saldo de R$ %.2f é insuficiente para saque.\n", saldo);
		}
	}

	public void depositar(double valor) {
		saldo += valor;
		System.out.println("Depósito realizado com sucesso.");
	}

	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		System.out.println("Transferência realizada com sucesso.");
	}

	protected void imprimirInfosComuns() {
		System.out.printf("Titular: %s%n", this.cliente.getNome());
		System.out.printf("Agencia: %d%n", this.agencia);
		System.out.printf("Numero: %d%n", this.numero);
		System.out.printf("Saldo: %.2f%n", this.saldo);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Conta conta = (Conta) o;
		return numero == conta.numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "{dominio.Conta nº " + numero +
				" - agencia " + agencia +
				"\n" + "cliente: " + cliente.getNome() +
				"\nsaldo:" + saldo + '}';
	}
}
class CompararPorNumero implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		return Integer.compare(c1.getNumero(), c2.getNumero());
	}
}