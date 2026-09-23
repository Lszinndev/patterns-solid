package ProjetosJava.modelos;

public class Conta {
    private final String numeroConta;
    private final String agencia;
    private final Titular titular;
    private double saldoAtual;
    private StatusConta statusConta;

    public Conta(String numeroConta, String agencia, double saldoInicial, Titular titular) {
        if (titular == null) {
            throw new IllegalArgumentException("A conta precisa de um titular.");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("O saldo inicial nao pode ser negativo.");
        }
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldoAtual = saldoInicial;
        this.titular = titular;
        this.statusConta = StatusConta.ATIVO;
    }

    public void creditar(double valor) {
        validarOperacao(valor);
        this.saldoAtual += valor;
    }

    public void debitar(double valor) {
        validarOperacao(valor);
        if (valor > this.saldoAtual) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        this.saldoAtual -= valor;
    }

    public boolean possuiSaldo(double valor) {
        return valor <= this.saldoAtual;
    }

    public void bloquear() {
        this.statusConta = StatusConta.BLOQUEADO;
    }

    public void desbloquear() {
        this.statusConta = StatusConta.ATIVO;
    }

    public boolean estaAtiva() {
        return this.statusConta == StatusConta.ATIVO;
    }

    private void validarOperacao(double valor) {
        if (!estaAtiva()) {
            throw new IllegalStateException("Conta bloqueada.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
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

    public StatusConta getStatusConta() {
        return statusConta;
    }

    public Titular getTitular() {
        return titular;
    }
}
