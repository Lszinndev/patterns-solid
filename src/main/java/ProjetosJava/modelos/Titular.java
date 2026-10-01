package ProjetosJava.modelos;

public class Titular {
    private final String cpf;
    private String nome;
    private final String email;
    private final String telefone;

    public Titular(String cpf, String nome, String email, String telefone) {
        this.cpf = normalizarCpf(cpf);
        setNome(nome);
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do titular e obrigatorio.");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
