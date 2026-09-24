package ProjetosJava.modelos;

public class Transacao {
    private int idTransacao = 0;
    private final TipoTransacao tipoTransacao;
    private final double valorTransacao;
    private final StatusTransacao statusTransacao;
    private final Conta conta;

    public Transacao(TipoTransacao tipoTransacao, double valorTransacao,
                     StatusTransacao statusTransacao, Conta conta) {
        if (tipoTransacao == null || statusTransacao == null || conta == null) {
            throw new IllegalArgumentException("Tipo, status e conta da transacao sao obrigatorios.");
        }
        idTransacao++;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.statusTransacao = statusTransacao;
        this.conta = conta;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }

    public StatusTransacao getStatusTransacao() {
        return statusTransacao;
    }

    public Conta getConta() {
        return conta;
    }

    public String obterResumoFormatado() {
        return String.format("%s - R$ %.2f",
                this.tipoTransacao,
                this.valorTransacao);
    }
}
