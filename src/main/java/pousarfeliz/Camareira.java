package pousarfeliz;

public class Camareira extends Funcionario {

    public Camareira(String nome, String cpf, double salario) {
        super(nome, cpf, "Camareira", salario);
    }

    @Override
    public void realizarAtividade() {
        System.out.println("Limpando quarto número 102.");
    }
}
