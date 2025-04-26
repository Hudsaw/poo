package nota;

public class Pagamento {
    private MainNota.FormaPagamento formaPagamento;
    private double valor;
    
    public Pagamento(MainNota.FormaPagamento formaPagamento, double valor) {
        this.formaPagamento = formaPagamento;
        this.valor = valor;
    }
    
    public MainNota.FormaPagamento getFormaPagamento() { return formaPagamento; }
    public double getValor() { return valor; }
}