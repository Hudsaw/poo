package NF;

import static NF.FormatadorUtil.*;
import static NF.FormatadorUtil.Direcao.*;

public class  NotaFiscal {
    public enum Tipo{CONTINGENCIA, NORMAL}
    private Empresa empresa;
    private Venda venda;
    private Tipo tipo;

    public void imprimir(){
        StringBuilder sb = new StringBuilder();
        sb.append(alinha(Empresa.getNomeFantasia(), 60, CENTRO));
        sb.append(System.lineSeparator());
        String cnpj = String.format("CNPJ: %s %s", empresa.getCnpj(), empresa.getRazaoSocial());
        sb.append(alinha(cnpj, 60, CENTRO));
        sb.append(System.lineSeparator());
        String endereco = String.format("Endereço: %s %s %s %s-%s",
                empresa.getEndereco().getLogradouro(),
                empresa.getEndereco().getNumero(),
                empresa.getEndereco().getBairro(),
                empresa.getEndereco().getCidade(),
                empresa.getEndereco().getCidade(),
                empresa.getEndereco().getEstado());
        sb.append(alinha(endereco, 60, CENTRO));
        sb.append(System.lineSeparator());
        String telefone = String.format("Tel: %s ", empresa.getTelefone());
        sb.append(alinha(telefone, 60, CENTRO));
        sb.append(System.lineSeparator());
        sb.append(alinha("Documento Auxiliar da Nota Fiscal de Consumidor Eletrônica", 60, CENTRO);
        sb.append(System.lineSeparator());
        sb.append(linha(60));
        sb.append(System.lineSeparator());
        sb.append(alinha("EMITIDA EM CONTIGÊNCIA", 60, CENTRO);
        sb.append(System.lineSeparator());
        sb.append(alinha("Pendente de autorização", 60, CENTRO);
        sb.append(System.lineSeparator());
        sb.append(FormatadorUtil.linha(60));
        sb.append(System.lineSeparator());
        String cabecalho = String.format("# %s %s %s %s %s %s",
                alinha("Código", 8, CENTRO),
                alinha("Descrição", 11, CENTRO),
                alinha("Qtde", 6, CENTRO),
                alinha("Un", 4, CENTRO),
                alinha("Valor unit.", 12, CENTRO),
                alinha("Valor total", 12, CENTRO),
                alinha("Código", 12, CENTRO),
                alinha("Descrição", 12, CENTRO);
        sb.append(cabecalho);



    }

}
