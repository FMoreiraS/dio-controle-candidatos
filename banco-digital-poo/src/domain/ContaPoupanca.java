package domain;

public final class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	public void imprimirExtrato() {
		System.out.println("=== Extrato: dominio.Conta Poupança ===");
		super.imprimirInfosComuns();
		System.out.println("\n");
	}
}
