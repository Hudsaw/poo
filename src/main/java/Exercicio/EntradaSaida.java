package Exercicio;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EntradaSaida {
    public static void executar(Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n=== MENU ENTRADA/SAÍDA ===");
            System.out.println("1. Formatar número real (2 dígitos)");
            System.out.println("2. Somar dois números inteiros");
            System.out.println("3. Exibir nome e idade");
            System.out.println("4. Calcular dobro de número real");
            System.out.println("5. Calcular quadrado de número inteiro");
            System.out.println("0. Voltar");
            System.out.print("Escolha a operação: ");

            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    formatarNumeroReal(scanner);
                    break;
                case 2:
                    somarDoisNumeros(scanner);
                    break;
                case 3:
                    exibirNomeIdade(scanner);
                    break;
                case 4:
                    calcularDobro(scanner);
                    break;
                case 5:
                    calcularQuadrado(scanner);
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
    }
    // Leia um número real e escreva-o na tela com 2 dígitos apenas.
    private static void formatarNumeroReal(Scanner scanner) {
        System.out.print("\nDigite um número real: ");
        double numero = scanner.nextDouble();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Número formatado: " + df.format(numero).replace(".", ","));
    }
    // Leia dois números inteiros e mostre a soma entre eles.
    private static void somarDoisNumeros(Scanner scanner) {
        System.out.print("\nDigite o primeiro número: ");
        int num1 = scanner.nextInt();
        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();
        System.out.println("Soma: " + (num1 + num2));
    }
    // Leia um nome e a idade de uma pessoa e imprima uma frase com essas informações.
    private static void exibirNomeIdade(Scanner scanner) {
        scanner.nextLine();
        System.out.print("\nDigite seu nome: ");
        java.lang.String nome = scanner.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        System.out.println(nome + " tem " + idade + " anos.");
    }
    // Leia um número real e exiba o seu dobro, mostrando apenas 2 casas decimais.
    private static void calcularDobro(Scanner scanner) {
        System.out.print("\nDigite um número real: ");
        double numero = scanner.nextDouble();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Dobro: " + df.format(numero * 2).replace(".", ","));
    }
    // Leia um número inteiro e exiba o seu quadrado.
    private static void calcularQuadrado(Scanner scanner) {
        System.out.print("\nDigite um número inteiro: ");
        int numero = scanner.nextInt();
        System.out.println("Quadrado: " + (numero * numero));
    }


}