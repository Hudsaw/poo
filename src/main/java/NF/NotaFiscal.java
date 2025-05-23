package NF;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import static NF.FormatadorUtil.*;
import static NF.FormatadorUtil.Direcao.*;
public class NotaFiscal {
    public enum Tipo{CONTINGENCIA, NORMAL}
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

    public void imprimir(){

        StringBuilder sb = new StringBuilder();
        sb.append(alinha(empresa.getNomeFantasia(),60, CENTRO));
        sb.append(System.lineSeparator());
        String cnpj = String.format("CNPJ: %s %s",empresa.getCnpj(),empresa.getRazaoSocial());
        sb.append(alinha(cnpj,60, CENTRO));
        sb.append(System.lineSeparator());
        String endereco = String.format("%s %s %s %s-%s",
                empresa.getEndereco().getLogradouro(),
                empresa.getEndereco().getNumero(),
                empresa.getEndereco().getBairro(),
                empresa.getEndereco().getCidade(),
                empresa.getEndereco().getEstado());
        sb.append(alinha(endereco,60, CENTRO));
        sb.append(System.lineSeparator());
        sb.append(alinha("Tel: " + empresa.getTelefone(),60,
                CENTRO));
        sb.append(System.lineSeparator());
        sb.append(alinha("Documento Auxiliar da Nota Fiscal de Consumidor Eletrônica",
                60,
                CENTRO));
        sb.append(System.lineSeparator());
        sb.append(linha(60));
        sb.append(System.lineSeparator());
        sb.append(alinha("EMITIDA EM CONTINGÊNCIA",60,CENTRO));
        sb.append(System.lineSeparator());
        sb.append(alinha("Pendente de Autorização", 60,CENTRO));
        sb.append(System.lineSeparator());
        sb.append(FormatadorUtil.linha(60));
        sb.append(System.lineSeparator());
        String cabecalho = String.format("# %s %s %s %s %s %s",
                alinha("Código",8,DIREITA),
                alinha("Descrição",11,DIREITA),
                alinha("Qtde",6,DIREITA),
                alinha("Un",4,DIREITA),
                alinha("Valor unit.",12,DIREITA),
                alinha("Valor total",12,DIREITA));
        sb.append(cabecalho);
        sb.append(System.lineSeparator());
        sb.append(linha(60));
        sb.append(System.lineSeparator());
        int i=1;
        for(ItemVenda item: venda.getItens()){
            String itemVenda = String.format("%s %s %s %s UN X %s %s\n",
                    formataInteiro(i,3),
                    formataInteiro(item.getProduto().getCodigo(),6),
                    alinha(item.getProduto().getDescricao(),26,ESQUERDA),
                    formataDecimal(item.getQuantidade(),5),
                    formataDecimal(item.getProduto().getValorUnitario(),5),
                    formataDecimal(item.getValor(),5)
                    );
            sb.append(itemVenda);
            i++;
        }
        sb.append(linha(60));
        sb.append(System.lineSeparator());
        String qtdTotalItens = String.format("%s %s\n",
                alinha("Qtde Total de Itens",56,ESQUERDA),
                formataInteiro(venda.getItens().size(),3)
                );
        sb.append(qtdTotalItens);
        String valorTotal = String.format("%s%s\n",
                alinha("Valor Total R$",50,ESQUERDA),
                formataDecimal(venda.getTotal(),10)
        );
        sb.append(valorTotal);
        String cabecalhoPagamento = String.format("%s%s",
                alinha("FORMA DE PAGAMENTO",50,ESQUERDA),
                "Valor Pago");
        sb.append(cabecalhoPagamento);
        sb.append(System.lineSeparator());
        for(Pagamento pagamento: venda.getPagamentos()){
            String pag = String.format("%s%s",
                    alinha(pagamento.getTipo().toString(),50,ESQUERDA),
                    formataDecimal(pagamento.getValor(),10));
            sb.append(pag);
            sb.append(System.lineSeparator());
        }
        String troco = String.format("%s%s",
                alinha("Troco R$",50,ESQUERDA),
                formataDecimal(venda.getTroco(),10));
        sb.append(troco);
        sb.append(System.lineSeparator());
        sb.append(linha(60));
        System.out.println(sb.toString());
        String nomeArquivo = String.format("nota_fiscal_%s.txt",new Date().getTime());
        try {
            FileWriter fw = new FileWriter(new File(nomeArquivo));
            fw.append(sb.toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        empresa.setNomeFantasia("TEM SUPERMERCADO");
        empresa.setCnpj("31.584.005/0001-32");
        empresa.setRazaoSocial("PRA VOCE SUPERMERCADO LTDA");
        empresa.getEndereco().setLogradouro("Av Manoel Gonçalves da Luz");
        empresa.getEndereco().setNumero("469");
        empresa.getEndereco().setBairro("BONGI");
        empresa.getEndereco().setCidade("RECIFE");
        empresa.getEndereco().setEstado("PE");
        empresa.setTelefone("(81)3097-0863");
        NotaFiscal nota = new NotaFiscal();
        nota.setEmpresa(empresa);
        Venda venda = new Venda();
        ItemVenda arroz = new ItemVenda();
        arroz.setProduto(ProdutoDB.buscaPorCodigo(1001));
        arroz.setQuantidade(2d);
        ItemVenda feijao = new ItemVenda();
        feijao.setProduto(ProdutoDB.buscaPorCodigo(1002));
        feijao.setQuantidade(4d);
        venda.adicionaItem(arroz);
        venda.adicionaItem(arroz);
        venda.adicionaItem(feijao);
        venda.adicionaItem(feijao);
        nota.setVenda(venda);
        Pagamento pagamento = new Pagamento();
        pagamento.setTipo(Pagamento.Tipo.DINHEIRO);
        pagamento.setValor(100d);
        Pagamento cartao = new Pagamento();
        cartao.setTipo(Pagamento.Tipo.CREDITO);
        cartao.setValor(70d);

        venda.adicionarPagamento(pagamento);
        venda.adicionarPagamento(cartao);
        nota.imprimir();

    }

}
