package exame;

import java.util.Date;

class Exame {
    private TipoItem tipoItem;
    private Date dataColeta;

    public TipoItem getTipoItem() { return tipoItem; }
    public void setTipoItem(TipoItem tipoItem) { this.tipoItem = tipoItem; }

    public Date getDataColeta() { return dataColeta; }
    public void setDataColeta(Date dataColeta) { this.dataColeta = dataColeta; }
}

class TipoItem {
    private Integer codigo;
    private String descricao;
    private String coleta;
    private Integer prazo;

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getColeta() { return coleta; }
    public void setColeta(String coleta) { this.coleta = coleta; }

    public Integer getPrazo() { return prazo; }
    public void setPrazo(Integer prazo) { this.prazo = prazo; }
}

