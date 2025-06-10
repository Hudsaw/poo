package pousarfeliz;

public class Recepcionista extends Funcionario {

    public Recepcionista(String nome, String cpf, double salario) {
        super(nome, cpf, "Recepcionista", salario);
    }

    @Override
    public void realizarAtividade() {
        System.out.println("Realizando check-in de hóspede.");
    }
}
