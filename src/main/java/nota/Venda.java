package nota;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private int numero;
    private Date data;
    private Empresa empresa;
    private List<ItemVenda> itens;
    private List<Pagamento> pagamentos;
    
    public Venda(int numero, Empresa empresa) {
        this.numero = numero;
        this.data = new Date();
        this.empresa = empresa;
        this.itens = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
    }
    
    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }
    
    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }
    
    public int getNumero() { return numero; }
    public Date getData() { return data; }
    public Empresa getEmpresa() { return empresa; }
    public List<ItemVenda> getItens() { return itens; }
    public List<Pagamento> getPagamentos() { return pagamentos; }
    public double getValorTotal() {
        return itens.stream().mapToDouble(ItemVenda::getValorTotal).sum();
    }
}