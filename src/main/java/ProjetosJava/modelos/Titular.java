package ProjetosJava.modelos;

public class Titular {
    private String CPF;
    private String nome;
    private String email;
    private String telefone;

    public Titular(String CPF, String nome, String email, String telefone) {
        validarCPF(CPF);
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    private void validarCPF(String CPF) {
        if (CPF == null || !CPF.replaceAll("[.\\-\\s]", "").matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido: deve conter exatamente 11 dígitos.");
        }
    }

    public void setCPF(String CPF) {
        validarCPF(CPF);
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
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
