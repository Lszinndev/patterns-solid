package ProjetosJava.implementacao;

import ProjetosJava.contratos.Autenticador;
import ProjetosJava.modelos.Cartao;

public class AutenticadorSenhaNumerica implements Autenticador {
    private static final String FORMATO_SENHA = "\\d{4,6}";

    @Override
    public boolean autenticar(Cartao cartao, String credencial) {
        if (cartao == null) {
            throw new IllegalArgumentException("Cartao nao informado.");
        }
        if (credencial == null || !credencial.matches(FORMATO_SENHA)) {
            return false;
        }
        return cartao.validarSenha(gerarHash(credencial));
    }

    public int gerarHash(String senha) {
        return senha.hashCode();
    }
}
