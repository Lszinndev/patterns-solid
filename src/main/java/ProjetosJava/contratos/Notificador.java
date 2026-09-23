package ProjetosJava.contratos;
import ProjetosJava.modelos.Titular;

public interface Notificador {
    public void notificar(Titular titular, String mensagem);
}
