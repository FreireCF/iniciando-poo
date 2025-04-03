package POO.Wilker.Models;

public class Cliente {
    private String nome = "nome";
    private double saldoTotal = 0;

    public Cliente(String nome, double saldoInicial){
        this.nome = nome;
        this.saldoTotal = saldoInicial;
    }

    public String getNome(){
        return nome;
    }

    public double getSaldoTotal(){
        return saldoTotal;
    }

    public void depositar(double valorDeposito){
        if (valorDeposito>0){
            saldoTotal += valorDeposito;
            System.out.println("Depósito de R$ "+valorDeposito+" efetuado com sucesso");
        } else {
            System.out.println("\nValor inválido para depósito");
        }
    }

    public void sacar(double valorSaque){
        if (valorSaque > 0 && valorSaque<=saldoTotal){
            saldoTotal -= valorSaque;
            System.out.println("\nSaque de R% "+valorSaque+" realizado com sucesso");
        } else {
            System.out.println("\nSaldo insuficiente ou valor inválido");
        }
    }

    public void tranferir(Cliente clienteDestino, double valorTranferencia){
        if (valorTranferencia > 0 && saldoTotal >= valorTranferencia){
            saldoTotal -= valorTranferencia;
            clienteDestino.depositar(valorTranferencia);
            System.out.println("\nTranferência de R$ "+valorTranferencia+" para "+clienteDestino.getNome()+"realizada com sucesso");
        } else {
            System.out.println("\nTranferência não realizada, Verifique o saldo");
        }
    }

    public void mostarSaldo(){
        System.out.println("Cliente "+nome);
        System.out.println("\nSaldo atual de R$ "+saldoTotal);
    }
}