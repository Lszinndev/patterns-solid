package ProjetosJava.modelos;

public class Titular {
    private final String cpf;
    private final String nome;
    private final String email;
    private final String telefone;

    public Titular(String cpf, String nome, String email, String telefone) {
        this.cpf = normalizarCpf(cpf);
        this.nome = validarNome(nome);
        this.email = email;
        this.telefone = telefone;
    }

    private String normalizarCpf(String cpf) {
        String digitos = cpf == null ? "" : cpf.replaceAll("[.\\-\\s]", "");
        if (!cpfValido(digitos)) {
            throw new IllegalArgumentException("CPF invalido.");
        }
        return digitos;
    }

    private boolean cpfValido(String digitos) {
        if (!digitos.matches("\\d{11}")) {
            return false;
        }
        return true;
    }

    private String validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do titular e obrigatorio.");
        }
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
