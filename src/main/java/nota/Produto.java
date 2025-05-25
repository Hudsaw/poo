package nota;

public class Produto {
    private Integer codigo;
    private String descricao;
    private Double valorUnitario;

    public String getDescricao() {
        return descricao;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
