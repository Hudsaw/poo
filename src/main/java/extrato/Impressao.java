package extrato;

import java.time.LocalDateTime;

import static extrato.Utilidade.Direcao.CENTRO;
import static extrato.Utilidade.Direcao.DIREITA;
import static extrato.Utilidade.Direcao.ESQUERDA;
import static extrato.Utilidade.formataInteiro;

class Impressao {

    private Empresa empresa;
    private Cliente Cliente;
    private Solicitacao solicitacao;

    public void imprimir() {
        StringBuilder sb = new StringBuilder();
        Utilidade util = new Utilidade();
        LocalDateTime dataAtual = LocalDateTime.now();

        // Cabeçalho
        sb.append(util.linha(60)).append(System.lineSeparator());

        sb.append(util.alinha("Extrato Bancário", 60, CENTRO)).append(System.lineSeparator());

        sb.append(util.alinha(getEmpresa().getNomeFantasia(), 60, CENTRO)).append(System.lineSeparator());

        String endereco1 = String.format("%s, %s",
                getEmpresa().getEndereco().getLogradouro(),
                getEmpresa().getEndereco().getNumero());
        sb.append(util.alinha(endereco1, 45, ESQUERDA));
        sb.append(util.alinha(Utilidade.formatarData(java.sql.Timestamp.valueOf(dataAtual)), 15, DIREITA)).append(System.lineSeparator());

        String endereco2 = String.format("%s - %s/%s",
                getEmpresa().getEndereco().getBairro(),
                getEmpresa().getEndereco().getCidade(),
                getEmpresa().getEndereco().getUf());
        sb.append(util.alinha(endereco2, 45, ESQUERDA));
        sb.append(util.alinha(Utilidade.formatarHora(dataAtual), 15, DIREITA)).append(System.lineSeparator());

        sb.append(util.alinha("CNPJ: " + getEmpresa().getCnpj(), 45, ESQUERDA));
        sb.append(util.alinha(getEmpresa().getTelefone(), 15, DIREITA)).append(System.lineSeparator());

        sb.append(System.lineSeparator());

        sb.append(util.alinha("EXTRATO DA CONTA " + getCliente().getTipoConta() + ": ", 40, ESQUERDA));
        sb.append(util.alinha(formataInteiro(getCliente().getConta(), 10), 20, ESQUERDA)).append(System.lineSeparator());

        sb.append(util.alinha("NOME: " + getCliente().getNome(), 60, ESQUERDA)).append(System.lineSeparator());

        sb.append(System.lineSeparator());

        sb.append(util.alinha("DATA\t\tHISTORICO\t\t\tVALOR", 60, ESQUERDA)).append(System.lineSeparator());

        sb.append(util.linha(60)).append(System.lineSeparator());

        //Tabela
        double saldoAtual = getCliente().getSaldo();

        for (Tabela tabela : getSolicitacao().getTabelas()) {
            sb.append(util.alinha(Utilidade.formatarMiniData(tabela.getTipoTransacao().getDataTransacao()), 10, ESQUERDA));
            sb.append(util.alinha(tabela.getTipoTransacao().getDescricao(), 30, ESQUERDA));
            double valor = tabela.getTipoTransacao().getValor();
            if (tabela.getTipoTransacao().getTipo() == TipoTransacao.Tipo.DESPESA) {
                saldoAtual -= valor;
            } else {
                saldoAtual += valor;
            }
        sb.append(util.alinha(String.format("%.2f", valor), 20, DIREITA)).append(System.lineSeparator());
        }

        sb.append(util.linha(60)).append(System.lineSeparator());
        sb.append(System.lineSeparator());

        sb.append(util.alinha("", 10, ESQUERDA));
        sb.append(util.alinha("SALDO ATUAL: ", 20, ESQUERDA));
        sb.append(util.alinha("R$ " + String.format("%.2f", saldoAtual), 20, DIREITA));
        sb.append(util.alinha("", 10, ESQUERDA)).append(System.lineSeparator());
        
        // Disponível
        Double disponivel = getCliente().getEspecial();
        if(saldoAtual>0){
            disponivel = getCliente().getEspecial() + saldoAtual;
        } else {
            disponivel = getCliente().getEspecial() - saldoAtual;
        }

        sb.append(util.alinha("", 10, ESQUERDA));
        sb.append(util.alinha("ESPECIAL: ", 20, ESQUERDA));
        sb.append(util.alinha(String.format("R$ %.2f", getCliente().getEspecial()), 20, DIREITA));
        sb.append(util.alinha("", 10, ESQUERDA)).append(System.lineSeparator());

        sb.append(util.alinha("", 10, ESQUERDA));
        sb.append(util.alinha("DISPONÍVEL: ", 20, ESQUERDA));
        sb.append(util.alinha(String.format("R$ %.2f", disponivel), 20, DIREITA));
        sb.append(util.alinha("", 10, ESQUERDA)).append(System.lineSeparator());

        sb.append(System.lineSeparator());
                
        sb.append(util.linha(60)).append(System.lineSeparator());


        sb.append(util.alinha(getEmpresa().getUrl(), 30, ESQUERDA));
        sb.append(util.alinha(getSolicitacao().getMaquina(), 30, DIREITA)).append(System.lineSeparator());
        
        sb.append(util.alinha("Guarde esse papelinho ô arrombado, se quex otro te vira...", 60, ESQUERDA)).append(System.lineSeparator());
        
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }
}
