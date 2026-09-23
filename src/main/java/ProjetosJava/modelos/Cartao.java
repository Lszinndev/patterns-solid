package ProjetosJava.modelos;

public class Cartao {
    private final String numeroCartao;
    private final int codigoHash;
    private statusCartao statusCartao;
    private int numeroTentativas;

    public Cartao(String numeroCartao, int codigoHash) {
        this.numeroCartao = numeroCartao;
        this.codigoHash = codigoHash;
        this.statusCartao = ProjetosJava.modelos.statusCartao.ATIVO;
    }

    private void registrarTentativaFalha() {
        int MAX_TENTATIVAS = 3;
        this.numeroTentativas++;
        if (this.numeroTentativas >= MAX_TENTATIVAS) {
            this.statusCartao = ProjetosJava.modelos.statusCartao.BLOQUEADO;
        }
    }

    public boolean validarSenha(int hashSenhaInformada) {
        if (this.statusCartao == ProjetosJava.modelos.statusCartao.BLOQUEADO) {
            return false;
        }

        if (this.codigoHash == hashSenhaInformada) {
            this.numeroTentativas = 0;
            return true;
        } else {
            registrarTentativaFalha();
            return false;
        }
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public int getCodigoHash() {
        return codigoHash;
    }
}
