package ProjetosJava.implementacao;

import ProjetosJava.contratos.Notificador;
import ProjetosJava.modelos.Titular;

public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Titular titular, String mensagem) {
        String email = titular.getEmail();
        if (email == null || email.isBlank()) {
            System.err.println("[EMAIL] Titular " + titular.getNome() + " nao possui e-mail cadastrado.");
            return;
        }
        System.out.println("[EMAIL] Para: " + email + " | " + mensagem);
    }
}
