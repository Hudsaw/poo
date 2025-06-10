package pousarfeliz;

public class CafeDaManha implements ServicoExtra {
    @Override
    public String getDescricao() {
        return "Café da manhã incluso";
    }

    @Override
    public double getValor() {
        return 20.0;
    }
}
