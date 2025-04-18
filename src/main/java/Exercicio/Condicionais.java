package Exercicio;

import java.util.Scanner;

public class Condicionais {
    public static void executar(Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n=== MENU CONDICIONAIS ===");
            System.out.println("1. Verificar positivo/negativo/zero");
            System.out.println("2. Identificar maior de dois números");
            System.out.println("3. Verificar par/ímpar");
            System.out.println("4. Identificar maior de três números");
            System.out.println("5. Verificar status do aluno");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    verificarPositivoNegativoZero(scanner);
                    break;
                case 2:
                    identificarMaiorDeDois(scanner);
                    break;
                case 3:
                    verificarParImpar(scanner);
                    break;
                case 4:
                    identificarMaiorDeTres(scanner);
                    break;
                case 5:
                    verificarStatusAluno(scanner);
                    break;
            }
        } while(opcao != 0);
    }
    // Leia um número e informe se ele é positivo, negativo ou zero.
    private static void verificarPositivoNegativoZero(Scanner scanner) {
        System.out.print("Digite um número: ");
        double numero = scanner.nextDouble();

        if(numero > 0) {
            System.out.println("Positivo");
        } else if(numero < 0) {
            System.out.println("Negativo");
        } else {
            System.out.println("Zero");
        }
    }
    // Leia dois números e informe o maior.
    private static void identificarMaiorDeDois(Scanner scanner) {
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.println("Maior: " + Math.max(num1, num2));
    }
    // Leia um número e informe se ele é par ou ímpar.
    private static void verificarParImpar(Scanner scanner) {
        System.out.print("Digite o número: ");
        int num1 = scanner.nextInt();
        if(num1%2 == 0){
            System.out.println("O número " + num1 + " é par.");
        }
        else{
            System.out.println("O número " + num1 + " é impar.");
        }
    }
    // Leia três números e exiba o maior deles.
    private static void identificarMaiorDeTres(Scanner scanner) {
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        System.out.print("Digite o terceiro número: ");
        double num3 = scanner.nextDouble();
        if(num1 > num2){
            if(num2 > num3){
                System.out.print("O primeiro número é o maior!");
            }
            else if(num1 < num3){
                System.out.print("O terceiro número é o maior!");
            }
        }
        else if(num2 > num3){
            System.out.print("O segundo número é o maior!");
        }
        else {
            System.out.print("O terceiro número é o maior!");
        }
    }
    // Leia a nota de um aluno e diga se ele foi aprovado (nota ? 6), em recuperação (4 ? nota < 6) ou reprovado (nota < 4).   
    private static void verificarStatusAluno(Scanner scanner) {
        System.out.print("Digite a nota do aluno: ");
        double nota = scanner.nextDouble();
        if(nota > 6){
            System.out.print("O aluno está aprovado!");
        }
        else if (nota > 4) {
            System.out.print("O aluno está de recuperação!");
        }
        else{
            System.out.print("O aluno está reprovado!");
        }
    }

}
