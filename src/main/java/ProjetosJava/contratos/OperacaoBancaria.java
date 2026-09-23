package ProjetosJava.contratos;
import ProjetosJava.modelos.Conta;

public interface OperacaoBancaria {
    public void executar(Conta conta, double valor);
    //public String getNomeOperacao();
}
