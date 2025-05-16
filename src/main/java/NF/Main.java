package NF;

import org.apache.commons.lang3.StringUtils;

import java.sql.SQLOutput;

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
        Integer idade=23;
        Boolean possuiFilhos=false;
        Float salario = 10f;
        String nomeSupermercado = "TEM SUPERMERCADO";
        System.out.println(nomeSupermercado);
        System.out.println(StringUtils.center(nomeSupermercado,60));
        System.out.println(StringUtils.center(nomeSupermercado,30));
        System.out.println(StringUtils.center(nomeSupermercado,50));
        System.out.println(StringUtils.center(nomeSupermercado,60));
        System.out.println(StringUtils.rightPad(nomeSupermercado,60));
        System.out.println(StringUtils.leftPad(nomeSupermercado,60));
        System.out.println(StringUtils.leftPad("123",10,"0"));
        Double total = 10.123;
        System.out.println(String.format("%.2f",total));
        String val = String.format("%.2f",total);
        System.out.println(StringUtils.leftPad(val,8));
        System.out.println(StringUtils.leftPad(
                String.format("%.2f",1999.90),8));
        String valorProduto = StringUtils.leftPad(String.format("%.2f",1999.90),8);
        String nomeProduto="Nescafe 500g - Selecao Especial";
        System.out.println(nomeProduto.length());
        System.out.println(StringUtils.abbreviate(nomeProduto,30));
        nomeProduto="Leite Ninho 420g";
        System.out.println(StringUtils.abbreviate(nomeProduto,30));
        String res=StringUtils.abbreviate(nomeProduto,30);
        System.out.println(StringUtils.rightPad(res,30));
        System.out.printf("%s%s\n",nomeProduto,valorProduto);
        System.out.printf("%s%s\n",StringUtils.rightPad(res,30),valorProduto);

        Produto feijao = new Produto();
        feijao.setCodigo(123);
        feijao.setDescricao("Feijao 1kg");
        feijao.setValorUnitario(6.5);
        Produto cafe = new Produto();
        cafe.setCodigo(124333);
        cafe.setDescricao("Café 3coracoes - selecao especial recanto mineiro");
        cafe.setValorUnitario(29.59);
        System.out.printf("%s %s %s\n",feijao.getCodigo(),
                feijao.getDescricao(),feijao.getValorUnitario());
        System.out.printf("%s %s %s\n",cafe.getCodigo(),
                cafe.getDescricao(),cafe.getValorUnitario());
        int numero = 42;
        String formatado = String.format("%010d %s %.2f", numero, feijao.getDescricao(), feijao.getValorUnitario());
        System.out.println(formatado);

        System.out.println(StringUtils.center("Produtos",60,"-"));
        System.out.println(getLinha(1,feijao.getCodigo().toString(),feijao.getDescricao(),2,feijao.getValorUnitario()));
        System.out.println(getLinha(2,cafe.getCodigo().toString(),cafe.getDescricao(),3,cafe.getValorUnitario()));

        System.out.println("\n\n\n\n\n");








    }
}
