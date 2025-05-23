package nota;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static String getLinha(Integer seq,
            String codigo,String produto,Integer qtd,Double valUni
                                  ){
        String sb = StringUtils.leftPad(seq.toString(),3,"0");
        sb+=" " + StringUtils.leftPad(codigo,10,"0");
        sb+=" " + StringUtils.rightPad(StringUtils.abbreviate(produto,22),22);
        sb+=" " + StringUtils.leftPad(qtd.toString(),3,"0") +" UN X";
        sb+=" " + StringUtils.leftPad(String.format("%.2f",valUni),6);
        sb+=" " + StringUtils.leftPad(String.format("%.2f",valUni*qtd),6);

        return sb;
    }
    //Classes Wrappers Java
    public static void print(double d){
        System.out.println(d);
    }
    public static void main(String[] args) {
        Double valor = 10d;
        //System.out.println(valor);
        valor+=20;
       // System.out.println(valor);
        print(valor);
        String nomeSupermercado = "TEM SUPERMERCADO";
        System.out.println(StringUtils.center(nomeSupermercado,60));
        
        Produto feijao = new Produto();
        feijao.setCodigo(123);
        feijao.setDescricao("Feijao 1kg");
        feijao.setValorUnitario(6.5);
        Produto cafe = new Produto();
        cafe.setCodigo(124333);
        cafe.setDescricao("Café 3coracoes - selecao especial recanto mineiro");
        cafe.setValorUnitario(29.59);
       
        System.out.println(StringUtils.center("Produtos",60,"-"));
        System.out.println(getLinha(1,feijao.getCodigo().toString(),feijao.getDescricao(),2,feijao.getValorUnitario()));
        System.out.println(getLinha(2,cafe.getCodigo().toString(),cafe.getDescricao(),3,cafe.getValorUnitario()));

        System.out.println("\n\n\n\n\n");








    }
}
