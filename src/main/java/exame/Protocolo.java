package exame;

import NF.*;
import NF.FormatadorUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import static exame.FormatadorUtil.*;
import static exame.FormatadorUtil.Direcao.*;
import static exame.FormatadorUtil.Direcao.ESQUERDA;
import static exame.FormatadorUtil.linha;
import static exame.FormatadorUtil.idade;


public class Protocolo {

    private Empresa empresa;
    private Paciente paciente;
    private Exame exame;
    private Solicitacao solicitacao;

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

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public void imprimir() {
        StringBuilder sb = new StringBuilder();

        // Cabeçalho da Empresa
        sb.append(alinha(empresa.getNomeFantasia(), 120, DIREITA)).append(System.lineSeparator());
        String endereco = String.format("%s %s %s %s %s-%s",
                empresa.getEndereco().getLogradouro(),
                empresa.getEndereco().getNumero(),
                empresa.getEndereco().getBairro(),
                empresa.getEndereco().getCidade(),
                empresa.getEndereco().getCep(),
                empresa.getEndereco().getEstado());
        sb.append(alinha(endereco, 120, CENTRO)).append(System.lineSeparator());
        sb.append(alinha("Tel: " + empresa.getTelefone(), 60, CENTRO)).append(System.lineSeparator());
        sb.append(linha(120)).append(System.lineSeparator());

        // Informações do Paciente
        sb.append("PACIENTE: ").append(paciente.getNome()).append(System.lineSeparator());
        sb.append("DATA DE NASCIMENTO: ").append(formatarData(paciente.getDataNascimento())).append(System.lineSeparator());
        sb.append("DATA DA COLETA: ").append(formatarData(solicitacao.getDataColeta())).append(System.lineSeparator());
        sb.append("PREVISÃO DO RESULTADO: ").append(formatarData(solicitacao.getPrevisaoResultado())).append(System.lineSeparator());
        sb.append(linha(60)).append(System.lineSeparator());

        // Tabela de Exames
        sb.append("EXAMES SOLICITADOS").append(System.lineSeparator());
        sb.append(String.format("%-30s %-15s", "Descrição", "Dias p/ Resultado")).append(System.lineSeparator());
        for (Exame exame : solicitacao.getExames()) {
            sb.append(String.format("%-30s %-15d", exame.getDescricao(), exame.getDiasParaResultado())).append(System.lineSeparator());
        }
        sb.append(linha(120)).append(System.lineSeparator());

        System.out.println(sb.toString());

        // Salvar em arquivo
        String nomeArquivo = "protocolo_" + paciente.getNome().replaceAll("\\s+", "_") + ".txt";
        try (FileWriter fw = new FileWriter(nomeArquivo)) {
            fw.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar protocolo.", e);
        }
    }
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        empresa.setNomeFantasia("Hospital Universitário do IFSC");
        empresa.getEndereco().setLogradouro("Av Manoel Gonçalves da Luz");
        empresa.getEndereco().setNumero("469");
        empresa.getEndereco().setBairro("Bela Vista");
        empresa.getEndereco().setCidade("GASPAR");
        empresa.getEndereco().setEstado("SC");
        empresa.setTelefone("(47)3097-0863");

        Protocolo protocolo = new Protocolo();
        TipoExame tipo1 = new TipoExame();
        tipo1.setCodigo(150220);
        tipo1.setDescricao("CULTURA AERÓBIA");
        tipo1.setColeta("FEZES");
        tipo1.setPrazo(5);


        protocolo.adicionaItem(tipo1);

        Pagamento pagamento = new Pagamento();
        pagamento.setTipo(Pagamento.Tipo.DINHEIRO);
        pagamento.setValor(100d);
        Pagamento cartao = new Pagamento();
        cartao.setTipo(Pagamento.Tipo.CREDITO);
        cartao.setValor(70d);


        protocolo.imprimir();

    }

}