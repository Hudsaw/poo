package extrato;

import java.util.Date;

class Tabela {
    private TipoTransacao tipoTransacao;
    private Double saldo;

    public TipoTransacao getTipoTransacao() { return tipoTransacao; }
    public void setTipoTransacao(TipoTransacao tipoTransacao) { this.tipoTransacao = tipoTransacao; }

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }
}

class TipoTransacao {
    public static enum Tipo { RECEITA, DESPESA, TRANSFERENCIA, INVESTIMENTO }
    private Tipo tipo;
    private Integer codigo;
    private String descricao;
    private Double valor;
    private Date dataTransacao;
    
    public Date getDataTransacao() { return dataTransacao; }
    public void setDataTransacao(Date dataTransacao) { this.dataTransacao = dataTransacao; }

    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
}

