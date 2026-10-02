package ProjetosJava.implementacao;

import ProjetosJava.contratos.Conta;
import ProjetosJava.contratos.OperacaoBancaria;

public class OperacaoDeposito implements OperacaoBancaria {

    @Override
    public void executar(Conta conta, double valor) {
        conta.creditar(valor);
    }
}
