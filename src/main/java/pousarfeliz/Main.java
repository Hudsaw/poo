package pousarfeliz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            System.out.println("3. Realizar Check-in");
            System.out.println("4. Adicionar Serviço na Reserva");
            System.out.println("5. Ver Reservas");
            System.out.println("6. Realizar Check-out");
            System.out.println("7. Ver Quartos Disponíveis");
            System.out.println("8. Gerar Relatório Financeiro");
            System.out.println("9. Sair");
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
                    realizarCheckIn();
                    break;
                case 4:
                    adicionarServicoNaReserva();
                    break;
                case 5:
                    verReservas();
                    break;
                case 6:
                    realizarCheckOut();
                    break;
                case 7:
                    verQuartosDisponiveis();
                    break;
                case 8:
                    gerarRelatorioFinanceiro();
                    break;
                case 9:
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

    private static void realizarCheckIn() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }

        System.out.println("Selecione uma reserva para realizar o check-in:");
        for (int i = 0; i < reservas.size(); i++) {
            System.out.println((i + 1) + " - " + reservas.get(i));
        }

        System.out.print("Número da reserva: ");
        int numReserva = Integer.parseInt(scanner.nextLine());

        if (numReserva < 1 || numReserva > reservas.size()) {
            System.out.println("Reserva inválida.");
            return;
        }

        Reserva r = reservas.get(numReserva - 1);
        r.realizarCheckIn();
    }

    private static void adicionarServicoNaReserva() {
        if (reservas.isEmpty()) {
            System.out.println("Não há reservas cadastradas.");
            return;
        }

        System.out.println("Selecione a reserva para adicionar serviço:");
        for (int i = 0; i < reservas.size(); i++) {
            System.out.println((i + 1) + " - " + reservas.get(i));
        }

        System.out.print("Número da reserva: ");
        int numReserva = Integer.parseInt(scanner.nextLine());

        if (numReserva < 1 || numReserva > reservas.size()) {
            System.out.println("Reserva inválida.");
            return;
        }

        Reserva r = reservas.get(numReserva - 1);

        System.out.println("Escolha um serviço para adicionar:");
        System.out.println("1 - Café da Manhã (R$20)");
        System.out.println("2 - Lavanderia (R$30)");
        System.out.println("3 - Passeio Guiado (R$50)");

        System.out.print("Opção: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        switch (opcao) {
            case 1:
                r.adicionarServico(new CafeDaManha());
                break;
            case 2:
                r.adicionarServico(new Lavanderia());
                break;
            case 3:
                r.adicionarServico(new PasseioGuiado());
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.println("Serviço adicionado com sucesso!");
    }

    private static void verReservas() {
        System.out.println("Reservas atuais:");
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    private static void realizarCheckOut() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }

        System.out.println("Selecione uma reserva para realizar o check-out:");
        for (int i = 0; i < reservas.size(); i++) {
            System.out.println((i + 1) + " - " + reservas.get(i));
        }

        System.out.print("Número da reserva: ");
        int numReserva = Integer.parseInt(scanner.nextLine());

        if (numReserva < 1 || numReserva > reservas.size()) {
            System.out.println("Reserva inválida.");
            return;
        }

        Reserva r = reservas.get(numReserva - 1);
        r.realizarCheckOut();
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

    private static void gerarRelatorioFinanceiro() {
        try {
            System.out.print("Digite a data para o relatório (dd/MM): ");
            String dataRelatorio = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataRef = LocalDate.parse(dataRelatorio + "/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            int totalReservasCheckout = 0;
            double totalFaturado = 0;
            int quartosOcupados = 0;
            int quartosDisponiveis = 0;

            for (Quarto q : quartos) {
                if (q.verificarDisponibilidade()) {
                    quartosDisponiveis++;
                } else {
                    quartosOcupados++;
                }
            }

            for (Reserva r : reservas) {
                LocalDate dataSaidaReserva = LocalDate.parse(r.getDataSaida() + "/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                if (dataSaidaReserva.isEqual(dataRef)) {
                    totalReservasCheckout++;
                    totalFaturado += r.calcularTotal();
                }
            }

            System.out.println("\n=== RELATÓRIO FINANCEIRO DO DIA ===");
            System.out.println("Data: " + dataRelatorio);
            System.out.println("Total de Reservas finalizadas (checkout) no dia: " + totalReservasCheckout);
            System.out.println("Total Faturado Estimado: R$ " + String.format("%.2f", totalFaturado));
            System.out.println("Quartos Ocupados: " + quartosOcupados);
            System.out.println("Quartos Disponíveis: " + quartosDisponiveis);
            System.out.println("==============================\n");

        } catch (Exception e) {
            System.out.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }

    
}
