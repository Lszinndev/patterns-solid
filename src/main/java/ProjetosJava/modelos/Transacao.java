package ProjetosJava.modelos;

public class Transacao {
    private final TipoTransacao tipoTransacao;
    private final double valorTransacao;
    private final StatusTransacao statusTransacao;

    public Transacao(TipoTransacao tipoTransacao, double valorTransacao, StatusTransacao statusTransacao) {
        if (tipoTransacao == null || statusTransacao == null) {
            throw new IllegalArgumentException("Tipo e status da transacao sao obrigatorios.");
        }
        if (valorTransacao <= 0) {
            throw new IllegalArgumentException("O valor da transacao deve ser maior que zero.");
        }
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.statusTransacao = statusTransacao;
    }

    public String obterResumoFormatado() {
        return String.format("%s - R$ %.2f",
                this.tipoTransacao,
                this.valorTransacao);
    }
}
