package POO.Banco;
import java.util.Scanner;
import POO.Wilker.Models.Cliente;
import POO.Wilker.View.EntradaDados;

public class App {
    public static void main(String[] args) {
        byte opcao;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCriando o primeiro cliente");
        Cliente primeiroCliente = EntradaDados.criarCliente(scanner);

        System.out.println("\nCriando o segundo cliente");
        Cliente segundoCliente = EntradaDados.criarCliente(scanner);

        System.out.println("\nCriando o terceiro cliente");
        Cliente terceiroCliente = EntradaDados.criarCliente(scanner);


        do {
            System.out.println("\n===========MENU===========");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Ver o saldo");
            System.out.println("0 - Sair");
            opcao = scanner.nextByte();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\nDepositar para o primeiro, segundo ou terceiro cliente? ");
                    byte clienteDeposito = scanner.nextByte();
                    System.out.println("\nValor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    if (clienteDeposito == 1) {
                        primeiroCliente.depositar(valorDeposito);
                    } else if (clienteDeposito == 2) {
                        segundoCliente.depositar(valorDeposito);
                    } else if(clienteDeposito == 3){
                        segundoCliente.depositar(valorDeposito);
                    } else {
                        System.out.println("\nCliente inexistente");
                    }
                    break;
                case 2:
                    System.out.println("\nDepositar para o primeiro, segundo ou terceiro cliente? ");
                    byte clienteSaque = scanner.nextByte();
                    System.out.println("\nValor para depositar: ");
                    double valorSaque = scanner.nextDouble();
                    if (clienteSaque == 1) {
                        primeiroCliente.sacar(valorSaque);
                    } else if (clienteSaque == 2) {
                        segundoCliente.sacar(valorSaque);
                    } else if (clienteSaque == 3) {
                        terceiroCliente.sacar(valorSaque);
                    } else {
                        System.out.println("\nCliente inexistente");
                    }
                    break;
                case 3:
                    System.out.println("\nTranferir do cliente 1, 2 ou 3?");
                    byte deCliente = scanner.nextByte();
                    System.out.println("\nPara o cliente 1, 2 ou 3?");
                    byte paraCliente = scanner.nextByte();

                    System.out.println("\nQual valor da transferência?");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine();

                    //melhorar essa validaçõa futuramente
                    if (deCliente == 1 && paraCliente == 2) {
                        primeiroCliente.tranferir(segundoCliente, valorTransferencia);
                    } else if (deCliente == 1 && paraCliente == 3) {
                        primeiroCliente.tranferir(terceiroCliente, valorTransferencia);
                    } else if (deCliente == 2 && paraCliente == 1) {
                        segundoCliente.tranferir(primeiroCliente, valorTransferencia);
                    }  else if (deCliente == 2 && paraCliente == 3) {
                        segundoCliente.tranferir(terceiroCliente, valorTransferencia);
                    }  else if (deCliente == 3 && paraCliente == 1) {
                        terceiroCliente.tranferir(primeiroCliente, valorTransferencia);
                    } else if (deCliente == 3 && paraCliente == 2) {
                        terceiroCliente.tranferir(segundoCliente, valorTransferencia);
                    } else {
                        System.out.println("\nTranferência inválida");
                    }
                    break;
                case 4:
                    primeiroCliente.mostarSaldo();
                    segundoCliente.mostarSaldo();
                    terceiroCliente.mostarSaldo();
                    break;
                case 0:
                    System.out.println("\nRelatório de saldo das contas após as operações: ");
                    primeiroCliente.mostarSaldo();
                    segundoCliente.mostarSaldo();
                    terceiroCliente.mostarSaldo();
                    System.out.println("\nEncerrando do sistema...");
                    break;
                default:
                    System.out.println("\nOpção inválida");
                    break;
            }
        } while (opcao != 0);
    }
}