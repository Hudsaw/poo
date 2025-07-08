package pousarfeliz;

public class PasseioGuiado implements Servico {
    @Override
    public String getNome() {
        return "Passeio Guiado";
    }

    @Override
    public double getPreco() {
        return 50.0;
    }
}