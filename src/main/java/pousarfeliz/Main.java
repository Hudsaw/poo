package pousarfeliz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Quarto> quartos = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private static List<Hospede> hospedes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDados();
        menuPrincipal();
    }

    private static void inicializarDados() {
        quartos.add(new Quarto(101, "Simples", 150));
        quartos.add(new Quarto(102, "Duplo", 200));
        quartos.add(new Quarto(103, "Suíte", 300));
    }

    private static void menuPrincipal() {
        while (true) {
            System.out.println("\n=== Sistema de Pousada ===");
            System.out.println("1. Cadastrar Hóspede");
            System.out.println("2. Registrar Reserva");
            System.out.println("3. Ver Quartos Disponíveis");
            System.out.println("4. Ver Reservas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarHospede();
                    break;
                case 2:
                    registrarReserva();
                    break;
                case 3:
                    verQuartosDisponiveis();
                    break;
                case 4:
                    verReservas();
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarHospede() {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Telefone: ");
            String tel = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            Hospede h = new Hospede(nome, cpf, tel, email);
            hospedes.add(h);

            System.out.println("Hóspede cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar hóspede.");
        }
    }

    private static void registrarReserva() {
        try {
            System.out.print("Data de entrada (dd/MM): ");
            String dataEntrada = scanner.nextLine();
            System.out.print("Data de saída (dd/MM): ");
            String dataSaida = scanner.nextLine();

            if (hospedes.isEmpty()) {
                System.out.println("Nenhum hóspede cadastrado. Cadastre um hóspede primeiro.");
                return;
            }

            System.out.println("Hóspedes Cadastrados:");
            for (int i = 0; i < hospedes.size(); i++) {
                System.out.println((i + 1) + " - " + hospedes.get(i));
            }

            System.out.print("Código do Hóspede desejado (número da lista): ");
            int numHospede = Integer.parseInt(scanner.nextLine());

            if (numHospede < 1 || numHospede > hospedes.size()) {
                System.out.println("Número de hóspede inválido.");
                return;
            }

            Hospede hospedeSelecionado = hospedes.get(numHospede - 1);

            System.out.println("Quartos disponíveis:");
            for (Quarto q : quartos) {
                if (q.verificarDisponibilidade()) {
                    System.out.println("Número: " + q.getNumero() + " | Tipo: " + q.getTipo() + " | Diária: R$" + q.getValorDiaria());
                }
            }

            System.out.print("Número do quarto desejado: ");
            int numQuarto = Integer.parseInt(scanner.nextLine());

            Quarto qSelecionado = null;
            for (Quarto q : quartos) {
                if (q.getNumero() == numQuarto && q.verificarDisponibilidade()) {
                    qSelecionado = q;
                    break;
                }
            }

            if (qSelecionado == null) {
                System.out.println("Quarto não disponível ou inválido.");
                return;
            }

            Reserva r = new Reserva(dataEntrada, dataSaida, qSelecionado);
            r.adicionarHospede(hospedeSelecionado);
            reservas.add(r);

            System.out.println("Reserva realizada com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido.");
        } catch (Exception e) {
            System.out.println("Erro ao registrar reserva.");
        }
    }

    private static void verQuartosDisponiveis() {
        System.out.println("Quartos disponíveis:");
        List<Quarto> listaOrdenada = new ArrayList<>(quartos);
        listaOrdenada.sort(Comparator.comparingInt(Quarto::getNumero));
        for (Quarto q : listaOrdenada) {
            if (q.verificarDisponibilidade()) {
                System.out.println(q);
            }
        }
    }

    private static void verReservas() {
        System.out.println("Reservas atuais:");
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }
}
