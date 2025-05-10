package NF;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Venda {
    private final Date dataHora = new Date();
    private ArrayList<ItemVenda> itens = new ArrayList<>();
    private ArrayList<Pagamento> pagamentos = new ArrayList<>();

    public void adicionarPagamento(Pagamento pag){
        pagamentos.add(pag);
    }
    private void adicionaItem(ItemVenda item){
        itens.add(item);
    }
    private void removeItem(int indice){
        itens.remove(indice);
    }
    public boolean liberarVenda(){
        return getTotalPagamento() >= getTotal();
    }
    public Double getTroco(){
        return getTotal() - getTotalPagamento();
    }

    private Double getTotalPagamento(){
        double total = 0;
        for (Pagamento pagamento:pagamentos){
            total += pagamento.getValor();
        }
        return total;
    }
    private Double getTotal(){
        double total = 0;
        for (ItemVenda item:itens){
            total += item.getValor();
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
        System.out.println(new SimpleDateFormat("DD/MMMM/yyyy hh:mm").format(new Date()));
    }
}
