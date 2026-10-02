package ProjetosJava.contratos;

import ProjetosJava.modelos.Titular;

public interface Conta {
    void creditar(double valor);
    void debitar(double valor);
    boolean estaAtiva();
    double getSaldoAtual();
    Titular getTitular();
}
