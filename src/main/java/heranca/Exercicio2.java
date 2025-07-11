package heranca;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio2 {

    public static void executar(Scanner scanner) {
        System.out.println("\n--- Hierarquia de Produtos e Comparable ---");

        Produto[] produtos = new Produto[5];
        produtos[0] = new Livro("Java Básico", 59.90, "123456789", "Carlos Silva");
        produtos[1] = new CD("Rock Nacional", 30.0, "987654321", 12);
        produtos[2] = new DVD("Filme Legal", 45.0, "112233445", 120);
        produtos[3] = new Livro("POO Avançada", 79.90, "556677889", "Ana Souza");
        produtos[4] = new DVD("Viagem ao Brasil", 39.90, "998877665", 90);

        int opcao;
        do {
            System.out.println("\n===== MENU EXERCÍCIO 2 =====");
            System.out.println("1 - Listar Produtos por nome");
            System.out.println("2 - Listar Produtos por preço");
            System.out.println("3 - Buscar Produto por Nome");
            System.out.println("4 - Buscar Produto por Preço");
            System.out.println("5 - Comparar Produtos (equals)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    ordenarPorNome(produtos);
                    break;
                case 2:
                    ordenarPorPreco(produtos);
                    break;
                case 3:
                    buscarPorNome(produtos, scanner);
                    break;
                case 4:
                    buscarPorPreco(produtos, scanner);
                    break;
                case 5:
                    compararProdutos(produtos, scanner);
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

    private static void listarProdutos(Produto[] produtos) {
        System.out.println("\n--- Lista de Produtos ---");
        for (int i = 0; i < produtos.length; i++) {
            System.out.println(i + " - " + produtos[i]);
        }
    }

    private static void ordenarPorNome(Produto[] produtos) {
        Arrays.sort(produtos);
        System.out.println("\n--- Produtos ordenados por nome ---");
        listarProdutos(produtos);
    }

    private static void ordenarPorPreco(Produto[] produtos) {
        Arrays.sort(produtos, (p1, p2) -> Double.compare(p1.preco, p2.preco));
        System.out.println("\n--- Produtos ordenados por preço ---");
        listarProdutos(produtos);
    }

    private static void buscarPorNome(Produto[] produtos, Scanner scanner) {
        System.out.print("Digite o nome do produto a ser buscado: ");
        String nomeBusca = scanner.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Produto p : produtos) {
            if (p.nome.toLowerCase().contains(nomeBusca)) {
                System.out.println("Produto encontrado: " + p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum produto encontrado com esse nome.");
        }
    }

    private static void buscarPorPreco(Produto[] produtos, Scanner scanner) {
        System.out.print("Digite o preço máximo para busca: ");
        double precoMax = scanner.nextDouble();

        boolean encontrado = false;
        for (Produto p : produtos) {
            if (p.preco <= precoMax) {
                System.out.println("Produto encontrado: " + p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum produto encontrado com esse preço.");
        }
    }

    private static void compararProdutos(Produto[] produtos, Scanner scanner) {
        listarProdutos(produtos);
        System.out.print("Escolha o índice do produto original (0 a 4): ");
        int idx = scanner.nextInt();
        System.out.print("Escolha o índice do produto para comparar (0 a 4): ");
        int idc = scanner.nextInt();

        if (idx < 0 || idc < 0 || idc >= produtos.length || idx >= produtos.length) {
            System.out.println("Índice inválido.");
            return;
        }

        Produto produtoOriginal = produtos[idx];
        Produto produtoComparado = produtos[idc];

        System.out.println("\nProduto Original: " + produtoOriginal);
        System.out.println("Produto Comparado: " + produtoComparado);

        if (produtoOriginal.equals(produtoComparado)) {
            System.out.println("Os produtos são iguais (mesmo código de barras).");
        } else {
            System.out.println("Os produtos são diferentes (códigos de barras distintos).");
        }
    }
}
