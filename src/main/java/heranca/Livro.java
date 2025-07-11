package heranca;

public class Livro extends Produto {
    private String autor;

    public Livro(String nome, double preco, String codigoBarras, String autor) {
        super(nome, preco, codigoBarras);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Livro [nome=" + nome + ", preco=" + preco + ", código=" + codigoBarras + ", autor=" + autor + "]";
    }
}