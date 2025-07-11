package heranca;

public class DVD extends Produto {
    private int duracao;

    public DVD(String nome, double preco, String codigoBarras, int duracao) {
        super(nome, preco, codigoBarras);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "DVD [nome=" + nome + ", preco=" + preco + ", código=" + codigoBarras + ", duração=" + duracao + "]";
    }
}
