package pousarfeliz;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class PousarFeliz {
        public static List<Quarto> quartos = new ArrayList<>();
        public static Scanner scanner = new Scanner(System.in);
        public static double caixa = 500.0;

        public static void main(String[] args) {
            quartos.add(new Quarto(101, "Simples", 100));
            quartos.add(new Quarto(201, "Duplo", 200));

            while (true) {
                System.out.println("\n=== SIMULAÇÃO DE POUSADA ===");
                System.out.println("Caixa atual: R$" + caixa);
                System.out.println("1. Passar para o próximo dia");
                System.out.println("2. Ver quartos disponíveis");
                System.out.println("3. Comprar novo quarto");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        passarDia();
                        break;
                    case 2:
                        verQuartos();
                        break;
                    case 3:
                        comprarQuarto();
                        break;
                    case 4:
                        System.out.println("Encerrando...");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }

    private static void passarDia() {
        Random rand = new Random();

        // Limpa todos os quartos do dia anterior
        for (Quarto q : quartos) {
            q.liberar();
        }

        // Reserva automática
        int qtdeReservada = 0;
        for (Quarto q : quartos) {
            if (rand.nextDouble() < 0.7) { 
                q.ocupar();
                caixa += q.getValorDiaria();
                qtdeReservada++;
            }
        }

        System.out.println(qtdeReservada + " quartos foram reservados hoje. Ganho total: R$" + (qtdeReservada * 100));

        // Despesas com limpeza
        double limpeza = quartos.size() * 30;
        caixa -= limpeza;
        System.out.println("Gasto com limpeza dos quartos: R$" + limpeza);

        // Evento aleatório com peso dos quartos
        caixa = Evento.ocorrerEvento(caixa, quartos); 

        // Verifica se o caixa está negativo
        if (caixa < 0) {
            System.out.println("\n Você gastou mais do que arrecadou!");
            System.out.println("Seu caixa está negativo: R$" + caixa);
            System.out.println("Você perdeu! A pousada foi fechada por dívidas.");
            System.exit(0);
        }
    }

        private static void verQuartos() {
            System.out.println("Quartos disponíveis:");
            List<Quarto> listaOrdenada = new ArrayList<>(quartos);
            listaOrdenada.sort(Comparator.comparingInt(Quarto::getNumero));
            for (Quarto q : listaOrdenada) {
                System.out.println(q);
            }
        }

    private static void comprarQuarto() {
        System.out.println("\n=== TIPOS DE QUARTO ===");
        System.out.println("1. Quarto Simples - R$500");
        System.out.println("2. Quarto Duplo   - R$800");
        System.out.println("3. Suíte         - R$1200");
        System.out.print("Escolha o tipo de quarto: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        String tipo = "";
        double valorDiaria = 0;
        double custoCompra = 0;
        int bloco = 0;

        switch (opcao) {
            case 1:
                tipo = "Simples";
                valorDiaria = 100;
                custoCompra = 500;
                bloco = 1;
                break;
            case 2:
                tipo = "Duplo";
                valorDiaria = 200;
                custoCompra = 900;
                bloco = 2;
                break;
            case 3:
                tipo = "Suíte";
                valorDiaria = 300;
                custoCompra = 1300;
                bloco = 3;
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        if (caixa >= custoCompra) {
            // Conta quantos quartos já existem nesse bloco
            int qtdeNoBloco = 0;
            for (Quarto q : quartos) {
                if (q.getNumero() >= bloco * 100 && q.getNumero() < (bloco + 1) * 100) {
                    qtdeNoBloco++;
                }
            }

            int novoNumero = bloco * 100 + qtdeNoBloco + 1;

            quartos.add(new Quarto(novoNumero, tipo, valorDiaria));
            caixa -= custoCompra;
            System.out.println("Quarto " + novoNumero + " (" + tipo + ") comprado. Caixa atual: R$" + caixa);
        } else {
            System.out.println("Saldo insuficiente para comprar este quarto.");
        }
    }
    }