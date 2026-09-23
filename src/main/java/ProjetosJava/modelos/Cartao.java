package ProjetosJava.modelos;

public class Cartao {
    private static final int MAX_TENTATIVAS = 3;

    private final String numeroCartao;
    private final int codigoHash;
    private final Conta conta;
    private StatusCartao statusCartao;
    private int numeroTentativas;

    public Cartao(String numeroCartao, int codigoHash, Conta conta) {
        if (conta == null) {
            throw new IllegalArgumentException("O cartao precisa estar vinculado a uma conta.");
        }
        this.numeroCartao = numeroCartao;
        this.codigoHash = codigoHash;
        this.conta = conta;
        this.statusCartao = StatusCartao.ATIVO;
    }

    public boolean validarSenha(int hashSenhaInformada) {
        if (estaBloqueado()) {
            return false;
        }

        if (this.codigoHash == hashSenhaInformada) {
            this.numeroTentativas = 0;
            return true;
        }

        registrarTentativaFalha();
        return false;
    }

    private void registrarTentativaFalha() {
        this.numeroTentativas++;
        if (this.numeroTentativas >= MAX_TENTATIVAS) {
            this.statusCartao = StatusCartao.BLOQUEADO;
        }
    }

    public boolean estaBloqueado() {
        return this.statusCartao == StatusCartao.BLOQUEADO;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public Conta getConta() {
        return conta;
    }

    public StatusCartao getStatusCartao() {
        return statusCartao;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }
}
