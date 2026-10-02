package ProjetosJava.contratos;

import ProjetosJava.modelos.Titular;

public interface Conta {
    void creditar(double valor);
    void debitar(double valor);
    void bloquear();
    boolean estaAtiva();
    double getSaldoAtual();
    String getNumeroConta();
    String getAgencia();
    Titular getTitular();
}
