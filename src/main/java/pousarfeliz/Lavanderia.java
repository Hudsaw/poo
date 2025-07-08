package pousarfeliz;

public class Lavanderia implements Servico {
    @Override
    public String getNome() {
        return "Lavanderia";
    }

    @Override
    public double getPreco() {
        return 30.0;
    }
}