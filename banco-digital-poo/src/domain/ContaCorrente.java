package domain;

public final class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}


	public void imprimirExtrato() {
		System.out.println("=== Extrato: dominio.Conta Corrente ===");
		super.imprimirInfosComuns();
		System.out.println("\n");
	}
	
}
