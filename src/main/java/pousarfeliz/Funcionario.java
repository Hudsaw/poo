package pousarfeliz;

public abstract class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cpf, String cargo, double salario) {
        super(nome, cpf);
        this.cargo = cargo;
        this.salario = salario;
    }

    public abstract void realizarAtividade();

    public String toString() {
        return "Funcionário: " + getNome() + " | Cargo: " + cargo;
    }
}
