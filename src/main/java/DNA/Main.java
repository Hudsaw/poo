package DNA;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        System.out.println("Escreva o DNA para a conversão:");
        Scanner leitor = new Scanner(System.in);
        String sequenciaDna = leitor.nextLine().toUpperCase();
        System.out.println("A proteína resultante é: " + DNAConverter.converter(sequenciaDna));
    }
}
