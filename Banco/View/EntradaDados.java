package POO.Wilker.View;
import java.util.Scanner;
import POO.Wilker.Models.Cliente;

public class EntradaDados {
    public static Cliente criarCliente(Scanner scanner) {
        System.out.println("\nDigite o nome do cliente: ");
            String nome = scanner.nextLine();
        System.out.println("\nDigite o saldo inicial da conta: ");
            double saldo = scanner.nextDouble();
            scanner.nextLine();
            return new Cliente(nome, saldo);
    }
}