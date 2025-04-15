package Exercicio;

import java.util.Scanner;
import java.util.ArrayList;

public class Vetores {
    public static void executar(Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n=== VETORES ===");
            System.out.println("1. Exibir números na ordem inversa");
            System.out.println("2. Contar números pares");
            System.out.println("3. Encontrar maior nota");
            System.out.println("4. Filtrar nomes com A");
            System.out.println("5. Contar números > 50");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    exibirOrdemInversa(scanner);
                    break;
                case 2:
                    contarNumerosPares(scanner);
                    break;
                case 3:
                    encontrarMaiorNota(scanner);
                    break;
                case 4:
                    filtrarNomesComA(scanner);
                    break;
                case 5:
                    contarMaioresQue50(scanner);
                    break;
            }
        } while(opcao != 0);
    }

    private static void exibirOrdemInversa(Scanner scanner) {
        int[] numeros = new int[5];
        for(int i = 0; i < 5; i++) {
            System.out.print("Digite o " + (i+1) + "º número: ");
            numeros[i] = scanner.nextInt();
        }

        System.out.println("Ordem inversa:");
        for(int i = 4; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
    }

    private static void contarNumerosPares(Scanner scanner) {
        int[] numeros = new int[10];
        int pares = 0;

        for(int i = 0; i < 10; i++) {
            System.out.print("Digite o " + (i+1) + "º número: ");
            numeros[i] = scanner.nextInt();
            if(numeros[i] % 2 == 0) {
                pares++;
            }
        }

        System.out.println("Quantidade de pares: " + pares);
    }

    private static void encontrarMaiorNota(Scanner scanner) {
        double[] notas = new double[10];
        double maior = 0;

        for(int i = 0; i < 10; i++) {
            System.out.print("Digite a " + (i+1) + "ª nota: ");
            notas[i] = scanner.nextDouble();
            if(i == 0 || notas[i] > maior) {
                maior = notas[i];
            }
        }

        System.out.println("Maior nota: " + maior);
    }

    private static void filtrarNomesComA(Scanner scanner) {
        ArrayList<String> nomes = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            System.out.print("Digite o " + (i+1) + "º nome: ");
            String nome = scanner.nextLine();
            if(nome.toUpperCase().startsWith("A")) {
                nomes.add(nome);
            }
        }

        System.out.println("Nomes que começam com A:");
        for(String nome : nomes) {
            System.out.println(nome);
        }
    }

    private static void contarMaioresQue50(Scanner scanner) {
        int[] numeros = new int[10];
        int contador = 0;

        for(int i = 0; i < 10; i++) {
            System.out.print("Digite o " + (i+1) + "º número: ");
            numeros[i] = scanner.nextInt();
            if(numeros[i] > 50) {
                contador++;
            }
        }

        System.out.println("Quantidade > 50: " + contador);
    }
}