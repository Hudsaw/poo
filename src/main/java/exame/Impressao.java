package exame;

import java.time.LocalDate;

import static exame.Utilidade.Direcao.CENTRO;
import static exame.Utilidade.Direcao.ESQUERDA;

class Impressao {

    private Empresa empresa;
    private Paciente paciente;
    private Solicitacao solicitacao;

    public void imprimir(String usuario, String senha) {
        StringBuilder sb = new StringBuilder();
        Utilidade util = new Utilidade();

        // Cabeçalho
        sb.append(util.alinha("", 20, ESQUERDA));
        sb.append(util.alinha(getEmpresa().getNomeFantasia(), 70, ESQUERDA));
        sb.append(Utilidade.alinha("Sistema de Apoio", 30, ESQUERDA)).append(System.lineSeparator());

        String endereco1 = String.format("%s, %s - %s",
                getEmpresa().getEndereco().getLogradouro(),
                getEmpresa().getEndereco().getNumero(),
                getEmpresa().getEndereco().getBairro());
        sb.append(util.alinha("", 20, ESQUERDA));
        sb.append(util.alinha(endereco1, 70, ESQUERDA));
        sb.append(util.alinha("Protocolo de Coleta", 30, ESQUERDA)).append(System.lineSeparator());

        String endereco2 = String.format("%s/%s - CEP: %s - Fone: %s",
                getEmpresa().getEndereco().getCidade(),
                getEmpresa().getEndereco().getUf(),
                getEmpresa().getEndereco().getCep(),
                getEmpresa().getTelefone());
        sb.append(util.alinha("", 20, ESQUERDA));
        sb.append(util.alinha(endereco2, 70, ESQUERDA));
        sb.append(Utilidade.alinha(Utilidade.formatarDataHora(getSolicitacao().getDatasolicitacao()), 30, ESQUERDA)).append(System.lineSeparator());
        
        sb.append(util.linha(120)).append(System.lineSeparator());
        sb.append(util.alinha("Protocolo de Coleta", 120, CENTRO));
        sb.append(util.linha(120)).append(System.lineSeparator());

        // Informações
        sb.append(util.alinha("", 20, ESQUERDA));
        sb.append(Utilidade.alinha("Solicitação: " + String.valueOf(getSolicitacao().getId()), 60, ESQUERDA));
        sb.append(Utilidade.alinha("Data Solicitação: " + Utilidade.formatarDataHora(getSolicitacao().getDatasolicitacao()), 40, ESQUERDA)).append(System.lineSeparator());

        sb.append(Utilidade.alinha("Paciente: " + getPaciente().getNome(), 80, ESQUERDA));
        sb.append(util.alinha("Matrícula: " + String.valueOf(getPaciente().getId()), 40, ESQUERDA)).append(System.lineSeparator());

        sb.append(util.alinha("Sexo: " + getPaciente().getSexo(), 80, ESQUERDA));
        sb.append(util.alinha("Prontuário: ", 40, ESQUERDA)).append(System.lineSeparator());
        
        sb.append(util.alinha("Data de Nascimento: " + Utilidade.formatarData(getPaciente().getDataNascimento()), 80, ESQUERDA));
        sb.append(Utilidade.alinha(util.idade(getPaciente().getDataNascimento()), 40, ESQUERDA)).append(System.lineSeparator());

        sb.append(util.alinha("Responsável: " + getSolicitacao().getResponsavel(), 120, ESQUERDA)).append(System.lineSeparator());
        sb.append(util.alinha("Solicitante: " + getSolicitacao().getSolicitante(), 120, ESQUERDA)).append(System.lineSeparator());

        sb.append(util.linha(120)).append(System.lineSeparator());
        sb.append(util.alinha("Exame", 70, ESQUERDA)); 
        sb.append(util.alinha("Data da coleta", 25, ESQUERDA));
        sb.append(util.alinha("Previsão de Resultado", 25, ESQUERDA)).append(System.lineSeparator());
        sb.append(util.linha(120)).append(System.lineSeparator());

        // Tabela
        for (Exame exame : getSolicitacao().getExames()) {
            sb.append(util.alinha(exame.getTipoExame().getCodigo()+" - "+exame.getTipoExame().getDescricao()+" - "+exame.getTipoExame().getColeta(), 70, ESQUERDA)); 
            sb.append(util.alinha(Utilidade.formatarData(exame.getDataColeta()), 25, ESQUERDA));
            java.time.LocalDate previsaoLocalDate = calculaPrevisaoResultado(exame.getTipoExame().getPrazo(), LocalDate.now());
            java.util.Date previsaoDate = java.sql.Date.valueOf(previsaoLocalDate);
            sb.append(Utilidade.alinha(Utilidade.formatarData(previsaoDate), 25, ESQUERDA)).append(System.lineSeparator());
        }
        
        sb.append(util.linha(120)).append(System.lineSeparator());

        
        sb.append(util.alinha("Acesse: "+ getEmpresa().getEndereco().getUrl() + " para consultar o resultado do exame com seu usuário " + usuario+ " e a senha "+ senha, 120, CENTRO)).append(System.lineSeparator());

        System.out.println(sb.toString());

        // Salvar em arquivo texto
        String nomeArquivo = "protocolo_" + getSolicitacao().getId() + ".txt";
        try (java.io.FileWriter writer = new java.io.FileWriter(nomeArquivo)) {
            writer.write(sb.toString());
            System.out.println("Protocolo salvo como: " + nomeArquivo);
        } catch (Exception e) {
            System.err.println("Erro ao salvar o protocolo: " + e.getMessage());
        }
    }

public LocalDate calculaPrevisaoResultado(int prazo, LocalDate dataColeta) {
        return dataColeta.plusDays(prazo);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }
}
