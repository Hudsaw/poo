package pousarfeliz;

public class Hospede extends Pessoa {
    private String telefone;
    private String email;

    public Hospede(String nome, String cpf, String telefone, String email) {
        super(nome, cpf);
        this.telefone = telefone;
        this.email = email;
    }

    public String toString() {
        return "Hóspede: " + getNome() + " | CPF: " + getCpf();
    }
}
