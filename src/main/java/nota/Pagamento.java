package nota;

public class  Pagamento {
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public enum Tipo {
        DINHEIRO, PIX, CHEQUE, CREDITO,
        DEBITO
    }
    private Tipo tipo;
    private Double valor;
}
