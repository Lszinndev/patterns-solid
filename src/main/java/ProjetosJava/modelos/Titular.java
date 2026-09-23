package ProjetosJava.modelos;

public class Titular {
    private final String cpf;
    private String nome;
    private String email;
    private String telefone;

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
        if (!digitos.matches("\\d{11}") || digitos.chars().distinct().count() == 1) {
            return false;
        }
        return digitoVerificador(digitos, 9) == digitos.charAt(9) - '0'
                && digitoVerificador(digitos, 10) == digitos.charAt(10) - '0';
    }

    private int digitoVerificador(String digitos, int posicao) {
        int soma = 0;
        for (int i = 0; i < posicao; i++) {
            soma += (digitos.charAt(i) - '0') * (posicao + 1 - i);
        }
        int resto = (soma * 10) % 11;
        return resto == 10 ? 0 : resto;
    }

    public String getCpf() {
        return cpf;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
