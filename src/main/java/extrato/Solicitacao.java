package extrato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Solicitacao {
    private Integer id;
    private Date datasolicitacao;
    private String maquina;
    private List<Tabela> tabelas = new ArrayList<>();

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Date getDatasolicitacao() { return datasolicitacao; }
    public void setDatasolicitacao(Date datasolicitacao) { this.datasolicitacao = datasolicitacao; }

    public String getMaquina() { return maquina; }
    public void setMaquina(String maquina) { this.maquina = maquina; }

    public List<Tabela> getTabelas() { return tabelas; }
    public void setTabelas(List<Tabela> tabelas) { this.tabelas = tabelas; }
}

class Cliente {
    private String nome;
    private Integer conta;
    private String agencia;
    private String banco;
    private String tipoConta;
    private Double saldo;
    private Double especial;
    private String cpf;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getConta() { return conta; }
    public void setConta(Integer conta) { this.conta = conta; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getBanco() { return banco; }
    public void setBanco(String banco) { this.banco = banco; }
    
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf;}

    public String getTipoConta() {return tipoConta;}
    public void setTipoConta(String tipoConta) {this.tipoConta = tipoConta;}

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }

    public Double getEspecial() { return especial; }
    public void setEspecial(Double especial) { this.especial = especial;}
}


