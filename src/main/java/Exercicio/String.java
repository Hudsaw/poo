package Exercicio;

import java.util.Scanner;

public class String {

        public static void executar(Scanner scanner) {
            int opcao;

            do {
                System.out.println("\n=== STRINGS ===");
                System.out.println("1. Contar vogais em frase");
                System.out.println("2. Extrair primeiro nome");
                System.out.println("3. Verificar palíndromo");
                System.out.println("4. Substituir 'a' por '@'");
                System.out.println("5. Comparar strings");
                System.out.println("0. Voltar");
                System.out.print("Escolha: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch(opcao) {
                    case 1:
                        contarVogais(scanner);
                        break;
                    case 2:
                        extrairPrimeiroNome(scanner);
                        break;
                    case 3:
                        verificarPalindromo(scanner);
                        break;
                    case 4:
                        substituirAPorArroba(scanner);
                        break;
                    case 5:
                        compararStrings(scanner);
                        break;
                }
            } while(opcao != 0);
        }

        private static void contarVogais(Scanner scanner) {
            System.out.print("Digite uma frase: ");
            String frase = scanner.nextLine().toLowerCase();
            int vogais = 0;

            for(char c : frase.toCharArray()) {
                if("aeiouáéíóúãõâêîôû".indexOf(c) != -1) {
                    vogais++;
                }
            }
            System.out.println("Total de vogais: " + vogais);
        }

        private static void extrairPrimeiroNome(Scanner scanner) {
            System.out.print("Digite o nome completo: ");
            String nomeCompleto = scanner.nextLine();
            String primeiroNome = nomeCompleto.split(" ")[0];
            System.out.println("Primeiro nome: " + primeiroNome);
        }

        private static void verificarPalindromo(Scanner scanner) {
            System.out.print("Digite uma palavra: ");
            String palavra = scanner.nextLine().replaceAll("\\s+", "").toLowerCase();
            String invertida = new StringBuilder(palavra).reverse().toString();

            System.out.println(palavra.equals(invertida) ? "É palíndromo" : "Não é palíndromo");
        }

        private static void substituirAPorArroba(Scanner scanner) {
            System.out.print("Digite uma frase: ");
            String frase = scanner.nextLine();
            String modificada = frase.replace('a', '@').replace('A', '@');
            System.out.println("Frase modificada: " + modificada);
        }

        private static void compararStrings(Scanner scanner) {
            System.out.print("Digite a primeira string: ");
            String str1 = scanner.nextLine();
            System.out.print("Digite a segunda string: ");
            String str2 = scanner.nextLine();

            System.out.println(str1.equals(str2) ? "Strings iguais" : "Strings diferentes");
        }
    }