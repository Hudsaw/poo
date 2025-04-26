package nota;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double valorUnitario;
    
    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = produto.getPreco();
    }
    
    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public double getValorUnitario() { return valorUnitario; }
    public double getValorTotal() { return quantidade * valorUnitario; }
}