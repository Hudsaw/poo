package heranca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Conta Corrente e Herança");
            System.out.println("2 - Hierarquia de Produtos e Interface Comparable");
            System.out.println("3 - Formas Geométricas e Interface");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Exercicio1.executar(scanner);
                    break;
                case 2:
                    Exercicio2.executar(scanner);
                    break;
                case 3:
                    Exercicio3.executar(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}