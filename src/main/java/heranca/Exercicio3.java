package heranca;

import java.util.Scanner;

public class Exercicio3 {
    public static void executar(Scanner scanner) {
        System.out.println("\n--- Formas Geométricas e Interface ---");
        System.out.print("Quantas formas geométricas deseja criar? ");
        int n = scanner.nextInt();
        FormaGeometrica[] formas = new FormaGeometrica[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Forma " + (i + 1) + ":");
            System.out.println("Escolha o tipo (1-Retângulo, 2-Quadrado, 3-Círculo): ");
            int tipo = scanner.nextInt();

            switch (tipo) {
                case 1:
                    System.out.print("Digite base e altura: ");
                    double base = scanner.nextDouble();
                    double altura = scanner.nextDouble();
                    formas[i] = new Retangulo(base, altura);
                    break;
                case 2:
                    System.out.print("Digite o lado do quadrado: ");
                    double lado = scanner.nextDouble();
                    formas[i] = new Quadrado(lado);
                    break;
                case 3:
                    System.out.print("Digite o raio do círculo: ");
                    double raio = scanner.nextDouble();
                    formas[i] = new Circulo(raio);
                    break;
                default:
                    System.out.println("Tipo inválido.");
                    i--;
            }
        }

        System.out.println("\n=== Dados das formas ===");
        for (FormaGeometrica f : formas) {
            if (f instanceof Retangulo) {
                System.out.println(((Retangulo) f).toString());
            } else if (f instanceof Quadrado) {
                System.out.println(((Quadrado) f).toString());
            } else if (f instanceof Circulo) {
                System.out.println(((Circulo) f).toString());
            }
            System.out.println("Perímetro: " + f.getPerimetro());
            System.out.println("Área: " + f.getArea());
            System.out.println("--------------------------");
        }
    }
}