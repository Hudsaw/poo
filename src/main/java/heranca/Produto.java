package heranca;

import java.util.Objects;

public abstract class Produto implements Comparable<Produto> {
    protected String nome;
    protected double preco;
    protected String codigoBarras;

    public Produto(String nome, double preco, String codigoBarras) {
        this.nome = nome;
        this.preco = preco;
        this.codigoBarras = codigoBarras;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Produto)) return false;
        Produto outro = (Produto) obj;
        return Objects.equals(this.codigoBarras, outro.codigoBarras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoBarras);
    }

    @Override
    public int compareTo(Produto p) {
        return this.nome.compareTo(p.nome);
    }
}