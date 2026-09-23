package ProjetosJava.implementacao;

import ProjetosJava.contratos.OperacaoBancaria;
import ProjetosJava.modelos.Conta;

public class OperacaoSaque implements OperacaoBancaria {

    @Override
    public void executar(Conta conta, double valor) {
        conta.debitar(valor);
    }
}
