package ProjetosJava.implementacao;

import ProjetosJava.contratos.OperacaoBancaria;
import ProjetosJava.modelos.Conta;

public class OperacaoDeposito implements OperacaoBancaria {

    @Override
    public void executar(Conta conta, double valor) {
        conta.creditar(valor);
    }
}
