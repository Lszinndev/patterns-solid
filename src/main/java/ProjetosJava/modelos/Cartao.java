package ProjetosJava.modelos;

public class Cartao {
    private static final int MAX_TENTATIVAS = 3;

    private final String numeroCartao;
    private final int codigoHash;
    private final Conta conta;
    private StatusCartao statusCartao;
    private int numeroTentativas;

    public Cartao(String numeroCartao, String senha, Conta conta) {
        if (conta == null) {
            throw new IllegalArgumentException("O cartao precisa estar vinculado a uma conta.");
        }
        if (senha == null || !senha.matches("\\d{4,6}")) {
            throw new IllegalArgumentException("A senha deve conter de 4 a 6 digitos numericos.");
        }

        this.numeroCartao = numeroCartao;
        this.conta = conta;
        this.statusCartao = StatusCartao.ATIVO;
        this.numeroTentativas = 0;
        this.codigoHash = gerarHash(senha);
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

    private int gerarHash(String senha) {
        return senha.hashCode();
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

    public Conta getConta() {
        return conta;
    }

    public StatusCartao getStatusCartao() {
        return statusCartao;
    }
}
