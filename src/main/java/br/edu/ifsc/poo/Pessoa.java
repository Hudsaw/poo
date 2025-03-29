package br.edu.ifsc.poo;

import java.util.Date;

public class Pessoa {
    public String nome;
    public Date dataNasc;
    public String genero;
    public Endereco endereco;
    public String cpf;
    public Pessoa[] responsaveis;
    public Pessoa conje;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa[] getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(Pessoa[] responsaveis) {
        this.responsaveis = responsaveis;
    }

    public Pessoa getConje() {
        return conje;
    }

    public void setConje(Pessoa conje) {
        this.conje = conje;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Endereco=" + endereco +
                '}';
    }
}