package nota;

public class  ItemVenda {
    private Produto produto;
    private Double quantidade;

    public Produto getProduto() {
        return produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor(){
        return produto.getValorUnitario()*quantidade;
    }
}
