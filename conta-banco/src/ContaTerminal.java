import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Bem-vindo(a) ao Banco Terminal!\nDigite o nome de usuário e confirme.");
        String name = input.nextLine();

        System.out.println("Digite o número da agência e confirme.");
        String agency = input.nextLine();

        System.out.println("Digite o número da conta e confirme.");
        int account = input.nextInt();

        System.out.println("Digite um valor para abrir a conta, usando . para valores não inteiros e 0 (zero) se não desejar depositar agora.");
        double balance = input.nextDouble();

        /* Mensagem sugerida:
         * Olá [Nome Cliente], obrigado por criar uma conta em nosso banco, sua agência é [Agencia],
         * conta [Numero] e seu saldo [Saldo] já está disponível para saque". 
        */
        // Para exercitar, preferi dividir a mensagem e usar alguns concats.
        String msgName = "Olá, ".concat(name) + ", obrigado por criar uma conta em nosso banco,";
        String msgAccountInfo = " sua agência é ".concat(agency) + ", conta " + account;
        String msgBalance = " e seu saldo " + balance + " já está disponível para saque.";
        System.out.println(msgName + msgAccountInfo + msgBalance);
    }
}