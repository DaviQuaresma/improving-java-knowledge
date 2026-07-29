package BankAccount_exercise_1;

public class Conta {

    private float value;
    private final String name;
    private TipoConta tipoConta;
    private StatusConta statusConta;

    public Conta(String name, float saldo,  TipoConta tipoConta, StatusConta statusConta) {
        this.value = saldo;
        this.name = name;
        this.tipoConta = tipoConta;
        this.statusConta = statusConta;
    }

    public void deposito(float ValorDepositado){
        this.value =  this.value + ValorDepositado;
    }

    public void saque(float ValorSaque){
        if(this.value < ValorSaque){
            throw new SaldoInsuficiente("Saldo negativo");
        }else{
            this.value = this.value - ValorSaque;
        }
    }

    public void saldo(){
        System.out.println("Saldo atual: " + this.value);
    }

    public void info(){
        System.out.println("Status da conta: " + this.statusConta.toString());
        System.out.println("Tipo da conta: " + this.tipoConta.toString());
    }

    public void transferir(float ValorTransferencia, Conta contaDestino){
        System.out.println("Conta remetente " + this.name + ", com saldo atual de " + this.value);
        System.out.println("Conta destinataria " + contaDestino.name + ", com saldo atual de " + contaDestino.value);

        if(this.value < ValorTransferencia){
            throw new SaldoInsuficiente("Saldo negativo");
        }else{
            this.saque(ValorTransferencia);
            contaDestino.deposito(ValorTransferencia);
        }
    }
}
