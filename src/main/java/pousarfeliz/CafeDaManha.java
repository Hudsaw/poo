package pousarfeliz;

public class CafeDaManha implements Servico {
    @Override
    public String getNome() {
        return "Café da Manhã";
    }

    @Override
    public double getPreco() {
        return 20.0;
    }
}
