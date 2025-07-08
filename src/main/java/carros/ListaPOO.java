package carros;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListaPOO  {
    public static void print(List lista){
        System.out.println("Imprimindo a lista");
        System.out.println("Tamanho: " + lista.size());
        System.out.println("Elementos:");
        for(Object o: lista){
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        Vector v1 = new Vector<>();
        v1.add("Joao1");
        v1.add("Joao2");
        ArrayList a1 = new ArrayList();
        a1.add("Maria1");
        a1.add("Maria2");
        LinkedList l1 = new LinkedList();
        l1.add("Jose1");
        l1.add("Jose2");
        print(a1);
        print(l1);
        print(v1);

    }
}
