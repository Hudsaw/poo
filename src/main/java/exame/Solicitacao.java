package exame;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Solicitacao {
    private Integer id;
    private Date datasolicitacao;
    private String responsavel;
    private String solicitante;
    private List<Exame> exames = new ArrayList<>();

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Date getDatasolicitacao() { return datasolicitacao; }
    public void setDatasolicitacao(Date datasolicitacao) { this.datasolicitacao = datasolicitacao; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    public String getSolicitante() { return solicitante; }
    public void setSolicitante(String solicitante) { this.solicitante = solicitante; }

    public List<Exame> getExames() { return exames; }
    public void setExames(List<Exame> exames) { this.exames = exames; }
}

class Cliente {
    private String nome;
    private Integer id;
    private String sexo;
    private Date dataNascimento;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public Date getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }
}


