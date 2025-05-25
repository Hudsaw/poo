package extrato;

import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Empresa
        Empresa banco = new Empresa();
        banco.setNomeFantasia("Banco Universitário do IFSC");
        banco.getEndereco().setLogradouro("Av Manoel Gonçalves da Luz");
        banco.getEndereco().setNumero("469");
        banco.getEndereco().setBairro("Bela Vista");
        banco.getEndereco().setCidade("Gaspar");
        banco.getEndereco().setEstado("SC");
        banco.getEndereco().setCep("89150-000");
        banco.setCnpj("12.345.678/0001-90");
        banco.setUrl("http://www.ifsc.edu.br/banco");
        banco.setTelefone("(47)3097-0863");

        // Cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Angenor de Oliveira");
        cliente.setConta(123456);
        cliente.setAgencia("001");
        cliente.setBanco("Banco do Brasil");
        cliente.setTipoConta("CORRENTE");
        cliente.setSaldo(100.00);
        cliente.setEspecial(3000.00);
        cliente.setCpf("123.456.789-00");

        // Solicitação
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(1001);
        solicitacao.setDatasolicitacao(new Date());
        solicitacao.setMaquina("PC-01");

        // Entrada de dados
        TipoTransacao tipo1 = new TipoTransacao();
        tipo1.setTipo(TipoTransacao.Tipo.RECEITA);
        tipo1.setDataTransacao(new Date(2025, 5, 5));
        tipo1.setCodigo(12345);
        tipo1.setDescricao("PROVENTO SALARIAL");
        tipo1.setValor(1500.00);

        TipoTransacao tipo2 = new TipoTransacao();
        tipo2.setTipo(TipoTransacao.Tipo.DESPESA);
        tipo2.setDataTransacao(new Date(2025, 5, 15));
        tipo2.setCodigo(67890);
        tipo2.setDescricao("BOLETO CONCESSIONARIA");
        tipo2.setValor(325.00);

        Tabela item1 = new Tabela();
        item1.setTipoTransacao(tipo1);

        Tabela item2 = new Tabela();
        item2.setTipoTransacao(tipo2);

        solicitacao.setTabelas(Arrays.asList(item1, item2));
        Utilidade.atualizarSaldos(solicitacao.getTabelas(), cliente.getSaldo());

        // Imprimir protocolo
        Impressao tabela = new Impressao();
        tabela.setEmpresa(banco);
        tabela.setCliente(cliente);
        tabela.setSolicitacao(solicitacao);
        tabela.imprimir();
    }
}
