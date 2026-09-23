package ProjetosJava.modelos;

import java.time.LocalDateTime;

public class Transacao {
    private final int idTransacao;
    private final TipoTransacao tipoTransacao;
    private final double valorTransacao;
    private final StatusTransacao statusTransacao;
    private final Conta conta;
    private final LocalDateTime dataHora;

    public Transacao(int idTransacao, TipoTransacao tipoTransacao, double valorTransacao,
                     StatusTransacao statusTransacao, Conta conta) {
        if (tipoTransacao == null || statusTransacao == null || conta == null) {
            throw new IllegalArgumentException("Tipo, status e conta da transacao sao obrigatorios.");
        }
        this.idTransacao = idTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.statusTransacao = statusTransacao;
        this.conta = conta;
        this.dataHora = LocalDateTime.now();
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String obterResumoFormatado() {
        return String.format("%s - R$ %.2f",
                this.tipoTransacao,
                this.valorTransacao);
    }
}
