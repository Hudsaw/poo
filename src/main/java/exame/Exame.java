package exame;

import javax.xml.crypto.Data;

public class Exame {
    private Integer codigo;
    private String descricao;
    private Enum Coleta{ FEZES, URINA, SANGUE}
    private Data prazo;

    private tipoExame.Coleta coleta;

    public String getDescricao() {
        return descricao;
    }

    public void setPrazo(Data prazo) {
        this.prazo = prazo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Data getPrazo() {
        return prazo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public tipoExame.Coleta getColeta() {return coleta;}

    public void setColeta(tipoExame.Coleta coleta) {this.coleta = coleta;}
}
