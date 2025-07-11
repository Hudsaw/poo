package heranca;

public class CD extends Produto {
    private int numeroFaixas;

    public CD(String nome, double preco, String codigoBarras, int numeroFaixas) {
        super(nome, preco, codigoBarras);
        this.numeroFaixas = numeroFaixas;
    }

    public int getNumeroFaixas() {
        return numeroFaixas;
    }

    @Override
    public String toString() {
        return "CD [nome=" + nome + ", preco=" + preco + ", código=" + codigoBarras + ", faixas=" + numeroFaixas + "]";
    }
}