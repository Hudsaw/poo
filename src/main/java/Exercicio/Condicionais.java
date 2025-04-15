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

    private static void identificarMaiorDeDois(Scanner scanner) {
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.println("Maior: " + Math.max(num1, num2));
    }

    // ... (implementar os outros métodos seguindo o mesmo padrão)
}
