package exame;

import java.util.Date;

public class Solicitacao {
    private Integer id;
    private Date datasolicitacao;
    private String responsavel;
    private String solicitante;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatasolicitacao() {
        return datasolicitacao;
    }

    public void setDatasolicitacao(Date datasolicitacao) {
        this.datasolicitacao = datasolicitacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
}
