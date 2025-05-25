package nota;

public class Main {

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

        Pagamento pagamento = new Pagamento();
        pagamento.setTipo(Pagamento.Tipo.DINHEIRO);
        pagamento.setValor(150d);

        Pagamento cartao = new Pagamento();
        cartao.setTipo(Pagamento.Tipo.CREDITO);
        cartao.setValor(500d);

        Venda venda = new Venda();
        venda.adicionarPagamento(cartao);
        venda.adicionarPagamento(pagamento);
        for (int i = 101; i <= 120; i++) {
        ItemVenda item = new ItemVenda();
        Produto p = ProdutoDB.buscaPorCodigo(i);
        if (p != null) {
            item.setProduto(p);
            item.setQuantidade(1d);
            venda.adicionaItem(item);
        }
    }

        NotaFiscal nota = new NotaFiscal();
        nota.setEmpresa(empresa);
        nota.setVenda(venda);

        nota.imprimir();

    }
}
