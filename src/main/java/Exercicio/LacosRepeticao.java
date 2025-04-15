package Exercicio;

import java.util.Scanner;

public class LacosRepeticao {
    public static void executar(Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n=== LAÇOS DE REPETIÇÃO ===");
            System.out.println("1. Calcular média de 10 números");
            System.out.println("2. Somar números até digitar 0");
            System.out.println("3. Exibir pares de 100 a 0");
            System.out.println("4. Exibir tabuada completa");
            System.out.println("5. Verificar número primo");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    calcularMediaDezNumeros(scanner);
                    break;
                case 2:
                    somarAteZero(scanner);
                    break;
                case 3:
                    exibirPares100a0();
                    break;
                case 4:
                    exibirTabuadaCompleta(scanner);
                    break;
                case 5:
                    verificarNumeroPrimo(scanner);
                    break;
            }
        } while(opcao != 0);
    }

    private static void calcularMediaDezNumeros(Scanner scanner) {
        double soma = 0;
        for(int i = 1; i <= 10; i++) {
            System.out.print("Digite o " + i + "º número: ");
            soma += scanner.nextDouble();
        }
        System.out.printf("Média: %.2f\n", soma/10);
    }

    private static void somarAteZero(Scanner scanner) {
        double soma = 0;
        double numero;
        do {
            System.out.print("Digite um número (0 para sair): ");
            numero = scanner.nextDouble();
            soma += numero;
        } while(numero != 0);
        System.out.println("Soma total: " + soma);
    }

    private static void exibirPares100a0() {
        for(int i = 100; i >= 0; i -= 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void exibirTabuadaCompleta(Scanner scanner) {
        System.out.print("Digite um número para a tabuada: ");
        int numero = scanner.nextInt();

        System.out.println("\nTabuada de " + numero + ":");
        for(int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", numero, i, numero*i);
        }
    }

    private static void verificarNumeroPrimo(Scanner scanner) {
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();
        boolean primo = true;

        if(numero <= 1) {
            primo = false;
        } else {
            for(int i = 2; i <= Math.sqrt(numero); i++) {
                if(numero % i == 0) {
                    primo = false;
                    break;
                }
            }
        }

        System.out.println(numero + (primo ? " é primo" : " não é primo"));
    }
}