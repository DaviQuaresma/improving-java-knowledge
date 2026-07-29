package BankAccount_exercise_1;

public class Main {
    public static void main(String[] args) {

        Conta conta1 = new Conta("Davi", 100, TipoConta.CORRENTE, StatusConta.ATIVO);
        Conta conta2 = new Conta("Joyce", 250,  TipoConta.SALARIO, StatusConta.ATIVO);

        conta1.transferir(100, conta2);
        conta1.saldo();
        conta2.saldo();

    }
}


//1. Sistema de contas bancárias
//Crie contas com depósito, saque e transferência.
//Use: classes, encapsulamento, enums, exceptions.