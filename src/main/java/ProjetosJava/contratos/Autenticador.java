package ProjetosJava.contratos;

import ProjetosJava.modelos.Cartao;

public interface Autenticador {
    boolean autenticar(Cartao cartao, String credencial);
}
