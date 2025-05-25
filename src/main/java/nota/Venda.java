package nota;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
    private final Date dataHora = new Date();
    private ArrayList<ItemVenda> itens = new ArrayList<>();
    private ArrayList<Pagamento> pagamentos = new ArrayList<>();
    
    public void adicionarPagamento(Pagamento pag){
        pagamentos.add(pag);
    }
    public void adicionaItem(ItemVenda item){
        itens.add(item);
    }
    public void removeItem(int indice){
        itens.remove(indice);
    }
    public boolean liberarVenda(){
        return getTotalPagamentos() >= getTotal(    );
    }
    public Double getTroco(){
        return getTotalPagamentos() - getTotal();
    }
    public Double getTotalPagamentos(){
        double total = 0;
        for(Pagamento pagamento: pagamentos){
            total += pagamento.getValor();
        }
        return total;
    }
    public Double getTotal(){
        double total = 0;
        for(ItemVenda item: itens){
            total += item.getValor();
        }
        return total;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }
}
