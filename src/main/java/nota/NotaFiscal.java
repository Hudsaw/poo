package nota;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import static nota.Utilidade.Direcao.CENTRO;
import static nota.Utilidade.Direcao.DIREITA;
import static nota.Utilidade.Direcao.ESQUERDA;
import static nota.Utilidade.alinha;
import static nota.Utilidade.formataDecimal;
import static nota.Utilidade.formataInteiro;
import static nota.Utilidade.linha;

public class NotaFiscal {

    public enum Tipo {
        CONTINGENCIA, NORMAL
    }
    private Empresa empresa;
    private Venda venda;
    private Tipo tipo;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public void imprimir() {

        StringBuilder sb = new StringBuilder();
        sb.append(alinha(empresa.getNomeFantasia(), 60, CENTRO));
        sb.append(System.lineSeparator());
        String cnpj = String.format("CNPJ: %s %s", empresa.getCnpj(), empresa.getRazaoSocial());
        sb.append(alinha(cnpj, 60, CENTRO));
        sb.append(System.lineSeparator());
        String endereco = String.format("%s %s %s %s-%s",
                empresa.getEndereco().getLogradouro(),
                empresa.getEndereco().getNumero(),
                empresa.getEndereco().getBairro(),
                empresa.getEndereco().getCidade(),
                empresa.getEndereco().getEstado());
        sb.append(alinha(endereco, 60, CENTRO));
        sb.append(System.lineSeparator());
        sb.append(alinha("Tel: " + empresa.getTelefone(), 60,
                CENTRO));
        sb.append(System.lineSeparator());
        sb.append(alinha("Documento Auxiliar da Nota Fiscal de Consumidor Eletrônica",
                60,
                CENTRO));
        sb.append(System.lineSeparator());
        sb.append(linha(60));
        sb.append(System.lineSeparator());
        sb.append(alinha("EMITIDA EM CONTINGÊNCIA", 60, CENTRO));
        sb.append(System.lineSeparator());
        sb.append(alinha("Pendente de Autorização", 60, CENTRO));
        sb.append(System.lineSeparator());
        sb.append(linha(60));
        sb.append(System.lineSeparator());
        String cabecalho = String.format("%s %s %s %s %s %s %s",
                alinha("#", 3, DIREITA),
                alinha("Código", 6, DIREITA),
                alinha("Descrição", 18, CENTRO),
                alinha("Qtde", 5, DIREITA),
                alinha("Un", 2, DIREITA),
                alinha("Valor und", 9, DIREITA),
                alinha("Valor total", 11, DIREITA));
        sb.append(cabecalho);
        sb.append(System.lineSeparator());
        sb.append(linha(60));
        sb.append(System.lineSeparator());
        int i = 1;
        for (ItemVenda item : venda.getItens()) {
            System.out.println("Imprimindo item " + i + ": " + item.getProduto().getDescricao());

            String itemVenda = String.format("%s %s %s %s %s %s %s\n",
                    alinha(String.valueOf(i), 3, DIREITA),
                    alinha(String.valueOf(item.getProduto().getCodigo()), 6, DIREITA),
                    alinha(item.getProduto().getDescricao(), 18, DIREITA),
                    alinha(String.format("%.2f", item.getQuantidade()), 5, DIREITA),
                    alinha("Un", 2, DIREITA),
                    alinha(String.format("%.2f", item.getProduto().getValorUnitario()), 9, DIREITA),
                    alinha(String.format("%.2f", item.getValor()), 11, DIREITA)
            );
            sb.append(itemVenda);
            i++;
        }
        sb.append(linha(60));
        sb.append(System.lineSeparator());
        String qtdTotalItens = String.format("%s %s\n",
                alinha("Qtde Total de Itens", 56, ESQUERDA),
                formataInteiro(venda.getItens().size(), 3)
        );
        sb.append(qtdTotalItens);
        String valorTotal = String.format("%s%s\n",
                alinha("Valor Total R$", 50, ESQUERDA),
                formataDecimal(venda.getTotal(), 10)
        );
        sb.append(valorTotal);
        String cabecalhoPagamento = String.format("%s%s",
                alinha("FORMA DE PAGAMENTO", 50, ESQUERDA),
                "Valor Pago");
        sb.append(cabecalhoPagamento);
        sb.append(System.lineSeparator());
        for (Pagamento pagamento : venda.getPagamentos()) {
            String pag = String.format("%s%s",
                    alinha(pagamento.getTipo().toString(), 50, ESQUERDA),
                    formataDecimal(pagamento.getValor(), 10));
            sb.append(pag);
            sb.append(System.lineSeparator());
        }
        String troco = String.format("%s%s",
                alinha("Troco R$", 50, ESQUERDA),
                formataDecimal(venda.getTroco(), 10));
        sb.append(troco);
        sb.append(System.lineSeparator());
        sb.append(linha(60));

        System.out.println(sb.toString());

        // Impressao em arquivo
        String nomeArquivo = String.format("nota_fiscal_%s.txt", new Date().getTime());
        try {
            FileWriter fw = new FileWriter(new File(nomeArquivo));
            fw.append(sb.toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
