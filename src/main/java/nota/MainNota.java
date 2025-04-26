package nota;

import java.text.SimpleDateFormat;

public class MainNota {
    public enum Tipo {PENDENTE, NORMAL};
    
    public enum FormaPagamento {
        DINHEIRO,
        CARTAO_CREDITO,
        CARTAO_DEBITO,
        PIX
    }
    
    public static void main(String[] args) {
        // Definindo o tipo de nota
        Tipo tipo = Tipo.PENDENTE;
        
        // Criando produtos
        Produto produto1 = new Produto("000014", "FARINHA FEIRA NOVA", 3.50);
        Produto produto2 = new Produto("000011", "MACAR VITARELLA 500G", 6.20);
        Produto produto3 = new Produto("000147", "AÇUCAR CRISTAL DA RO", 2.98);
        Produto produto4 = new Produto("006703", "NESCAFE REFIL 50G", 5.10);
        Produto produto5 = new Produto("000504", "FLOCAO NUTRIVITA500G", 2.98);
        Produto produto6 = new Produto("002278", "FOSFORO OLHO C 10UN", 2.99);
        Produto produto7 = new Produto("002152", "MACARRAO INST VITA85", 0.75);
        Produto produto8 = new Produto("000038", "ESPUMA SCOTH BRITE C", 3.35);
        Produto produto9 = new Produto("002152", "MACARRAO INST VITA85", 0.75);
        
        // Criando endereço
        Endereco enderecoEmpresa = new Endereco("AV. MANOEL GONCALVES DA LUZ", "469", "BONG", 
                                               "RECIFE", "PE");
        
        // Criando empresa
        Empresa empresa = new Empresa("TEM SUPERMERCADO", "31.584.005/0001-32", 
                                    "PARA VOCE SUPERMERCADO LTDA", enderecoEmpresa, 
                                    "(81) 3097-0863");
        
        // Criando venda
        Venda venda = new Venda(12345, empresa);
        
        // Adicionando itens à venda
        venda.adicionarItem(new ItemVenda(produto1, 2));
        venda.adicionarItem(new ItemVenda(produto2, 4));
        venda.adicionarItem(new ItemVenda(produto3, 2));
        venda.adicionarItem(new ItemVenda(produto4, 2));
        venda.adicionarItem(new ItemVenda(produto5, 2));
        venda.adicionarItem(new ItemVenda(produto6, 1));
        venda.adicionarItem(new ItemVenda(produto7, 1));
        venda.adicionarItem(new ItemVenda(produto8, 1));
        venda.adicionarItem(new ItemVenda(produto9, 1));
        
        // Adicionando pagamento
        venda.adicionarPagamento(new Pagamento(FormaPagamento.CARTAO_CREDITO, venda.getValorTotal()));
        
        // Emitindo nota fiscal
        emitirNotaFiscal(venda, tipo);
    }
    
    public static void emitirNotaFiscal(Venda venda, Tipo tipo) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String linha = "============================================================";
        
        // Cabeçalho - todos os dados vêm do objeto Empresa
        centralizarTexto(venda.getEmpresa().getNome(), linha.length());
        centralizarTexto("CNPJ: " + venda.getEmpresa().getCnpj() + " " + venda.getEmpresa().getRazaoSocial(), linha.length());
        centralizarTexto("Endereço: " + venda.getEmpresa().getEndereco(), linha.length());
        centralizarTexto("Tel: " + venda.getEmpresa().getTelefone(), linha.length());
        System.out.println(linha);
        centralizarTexto("EMITIDA EM CONTINGENCIA", linha.length());
        System.out.println("Tipo: " + tipo.name());
        System.out.println("Data: " + sdf.format(venda.getData()));
        System.out.println(linha);
        
        // Itens - todos os dados vêm dos objetos ItemVenda e Produto
        System.out.println("ITENS:");
        System.out.println("#  Código  Descrição\t\t  Qtd   Vl. Unit   Vl. Total");
        int contador = 1;
        for (ItemVenda item : venda.getItens()) {
            System.out.printf("%-2d %-6s %-20s %4d UN %9.2f %11.2f%n",
                contador++,
                item.getProduto().getCodigo(),
                item.getProduto().getNome(),
                item.getQuantidade(),
                item.getValorUnitario(),
                item.getValorTotal());
        }
        System.out.println(linha);
        
        // Total e pagamento - dados calculados dinamicamente
        System.out.printf("%-48s R$ %8.2f%n", "VALOR TOTAL:", venda.getValorTotal());
        System.out.printf("\n%-48s %8s%n", "FORMA DE PAGAMENTO:", "VALOR PAGO");
        for (Pagamento pagamento : venda.getPagamentos()) {
            System.out.printf("%-48s R$ %8.2f%n", 
                            pagamento.getFormaPagamento().name(),
                            pagamento.getValor());
        }
        
        // Rodapé - mensagens genéricas que podem ser parametrizadas
        System.out.println(linha);
        centralizarTexto("NOTA EMITIDA EM CONTINGENCIA", linha.length());
        centralizarTexto("Esta nota será regularizada quando o sistema", linha.length());
        centralizarTexto("da SEFAZ estiver disponível", linha.length());
    }
    
    private static void centralizarTexto(String texto, int tamanhoLinha) {
        int espacos = (tamanhoLinha - texto.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < espacos; i++) {
            sb.append(" ");
        }
        sb.append(texto);
        System.out.println(sb.toString());
    }
}