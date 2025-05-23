package NF;

public class Pagamento {
    public enum Tipo {
        DINHEIRO, PIX, CHEQUE, CREDITO,
        DEBITO
    }

    private Tipo tipo;
    private Double valor;

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }
}
