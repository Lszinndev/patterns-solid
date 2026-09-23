package ProjetosJava.modelos;

public class Transacao {
    private int idTransacao;
    private String tipoTransacao;
    private double valorTransacao;
    private statusTransacao statusTransacao;

    public Transacao(int idTransacao, String tipoTransacao, double valorTransacao, statusTransacao statusTransacao) {
        this.idTransacao = idTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;;
        this.statusTransacao = statusTransacao;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public statusTransacao getStatusTransacao() {
        return statusTransacao;
    }

    public String obterResumoFormatado() {
        return String.format("%s - R$ %.2f",
                this.tipoTransacao,
                this.valorTransacao);
    }
}
