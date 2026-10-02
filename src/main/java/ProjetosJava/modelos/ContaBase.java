package ProjetosJava.modelos;

import ProjetosJava.contratos.Conta;

public class ContaBase implements Conta {
    private final String numeroConta;
    private final String agencia;
    private final Titular titular;
    private double saldoAtual;
    private boolean ativa;

    public ContaBase(String numeroConta, String agencia, double saldoInicial, Titular titular) {
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
        this.ativa = true;
    }

    @Override
    public void creditar(double valor) {
        validarOperacao(valor);
        this.saldoAtual += valor;
    }

    @Override
    public void debitar(double valor) {
        validarOperacao(valor);
        if (valor > this.saldoAtual) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        this.saldoAtual -= valor;
    }

    @Override
    public void bloquear() {
        this.ativa = false;
    }

    @Override
    public boolean estaAtiva() {
        return this.ativa;
    }

    private void validarOperacao(double valor) {
        if (!estaAtiva()) {
            throw new IllegalStateException("Conta bloqueada.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
    }

    @Override
    public String getNumeroConta() {
        return numeroConta;
    }

    @Override
    public String getAgencia() {
        return agencia;
    }

    @Override
    public double getSaldoAtual() {
        return saldoAtual;
    }

    @Override
    public Titular getTitular() {
        return titular;
    }
}
