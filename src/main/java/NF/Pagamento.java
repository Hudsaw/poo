package NF;

public class  Pagamento {
    public enum Tipo {
        DINHEIRO, PIX, CHEQUE, CREDITO,
        DEBITO
    }
    private Tipo tipo;
    private Double valor;
}
