package ProjetosJava.implementacao;

import ProjetosJava.contratos.Notificador;
import ProjetosJava.modelos.Titular;

public class NotificadorSMS implements Notificador {

    @Override
    public void notificar(Titular titular, String mensagem) {
        String telefone = titular.getTelefone();
        if (telefone == null || telefone.isBlank()) {
            System.err.println("[SMS] Titular " + titular.getNome() + " nao possui telefone cadastrado.");
            return;
        }
        System.out.println("[SMS] Para: " + telefone + " | " + mensagem);
    }
}
