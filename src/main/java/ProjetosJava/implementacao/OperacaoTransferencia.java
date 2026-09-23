package ProjetosJava.implementacao;

import ProjetosJava.contratos.OperacaoBancaria;
import ProjetosJava.modelos.Conta;

public class OperacaoTransferencia implements OperacaoBancaria {
    private final Conta contaDestino;

    public OperacaoTransferencia(Conta contaDestino) {
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta de destino invalida.");
        }
        this.contaDestino = contaDestino;
    }

    @Override
    public void executar(Conta contaOrigem, double valor) {
        if (contaOrigem == contaDestino) {
            throw new IllegalArgumentException("A conta de destino deve ser diferente da conta de origem.");
        }
        if (!contaDestino.estaAtiva()) {
            throw new IllegalStateException("Conta de destino bloqueada.");
        }
        contaOrigem.debitar(valor);
        contaDestino.creditar(valor);
    }

    public Conta getContaDestino() {
        return contaDestino;
    }
}
