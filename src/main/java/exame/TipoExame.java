package exame;

import javax.xml.crypto.Data;

public class TipoExame {
    private Integer codigo;
    private String descricao;
    private String coleta;
    private Integer prazo;

    public String getDescricao() {
        return descricao;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getColeta() {return coleta;}

    public void setColeta(String coleta) {this.coleta = coleta;}

    public Integer getPrazo() {
        return prazo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

}
