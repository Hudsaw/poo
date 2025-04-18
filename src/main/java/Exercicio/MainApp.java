package Exercicio;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            
            do {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Entrada e Saída Simples");
                System.out.println("2. Condicionais");
                System.out.println("3. Laços de Repetição");
                System.out.println("4. Vetores");
                System.out.println("5. Strings");
                System.out.println("0. Sair");
                System.out.print("Escolha uma categoria: ");
                
                opcao = scanner.nextInt();
                
                switch(opcao) {
                    case 1:
                        EntradaSaida.executar(scanner);
                        break;
                    case 2:
                        Condicionais.executar(scanner);
                        break;
                    case 3:
                        LacosRepeticao.executar(scanner);
                        break;
                    case 4:
                        Vetores.executar(scanner);
                        break;
                    case 5:
                        Estring.executar(scanner);
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while(opcao != 0);
        }
    }
}