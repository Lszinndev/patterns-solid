package ProjetosJava.modelos;

public class Conta {
    private String numeroConta;
    private String agencia;
    private double saldoAtual;
    private statusConta statusConta;
    private Titular titular;

    public Conta(String numeroConta, String agencia, double saldoAtual, Titular titular) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldoAtual = saldoAtual;
        this.statusConta = statusConta.ATIVO;
        this.titular = titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public statusConta getStatusConta() {
        return statusConta;
    }

    public Titular getTitular() {
        return titular;
    }

    public void depositar(double saldo, double valorDeposito) {
        saldo += valorDeposito;
    }

    public void sacar(double saldo, double valorSaque) {
        if(valorSaque > saldo) {
            throw new ArithmeticException("O valor de saque nao pode ser maior que o saldo.");
        }
        saldo -= valorSaque;
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, double valorTransferido) {
        if (contaDestino == null ) {
            throw new IllegalArgumentException("Conta invalida!");
        }
        if(valorTransferido > saldoAtual) {
            throw new ArithmeticException("O valor de transferencia nao pode ser maior que o saldo atual.");
        }
        contaOrigem.saldoAtual -= valorTransferido;
        contaDestino.saldoAtual += valorTransferido;
    }
}
