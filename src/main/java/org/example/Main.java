package org.example;

import br.edu.ifsc.poo.Endereco;
import br.edu.ifsc.poo.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa b1 = new Pessoa();
        Pessoa b2 = new Pessoa();
        Endereco end = new Endereco();
        end.setLogradouro("Martha Muller");
        end.setNumero("60");
        b1.setNome("Hudsaw");
        b1.setCpf("012");
        b1.setEndereco(end);
        b2.setNome("Giane");
        b2.setCpf("210");
        b2.setEndereco(end);
        end.setNumero("1060");
        System.out.println(b1);
        System.out.println(b2);




        System.out.println("Nihao he Huānyíng, "+b1.nome+"!");

        for (int i = 0; i < 5; i++) {

            System.out.println("i = " + (i+1));
        }
    }
}