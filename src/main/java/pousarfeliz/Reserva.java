package pousarfeliz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private static int contador = 1;
    private int codigo;
    private String dataEntrada;
    private String dataSaida;
    private ArrayList<Hospede> hospedes;
    private List<Servico> servicos = new ArrayList<>();
    private Quarto quarto;
    private boolean checkInRealizado = false;
    private boolean checkOutRealizado = false;

    public Reserva(String dataEntrada, String dataSaida, Quarto quarto) {
        this.codigo = contador++;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.hospedes = new ArrayList<>();
        this.quarto = quarto;
        quarto.ocupar();
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public void adicionarHospede(Hospede h) {
        hospedes.add(h);
    }

    public void realizarCheckIn() {
        if (checkInRealizado) {
            System.out.println("Check-in já foi realizado.");
            return;
        }

        LocalDate hoje = LocalDate.now();
        LocalDate entrada = LocalDate.parse(dataEntrada + "/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (hoje.isBefore(entrada)) {
            System.out.println("Não é possível fazer check-in antes da data de entrada.");
            return;
        }

        checkInRealizado = true;
        System.out.println("Check-in realizado com sucesso!");
    }

    public void realizarCheckOut() {
        if (checkOutRealizado) {
            System.out.println("Check-out já foi realizado.");
            return;
        }

        if (!checkInRealizado) {
            System.out.println("Não é possível fazer check-out sem check-in.");
            return;
        }

        LocalDate hoje = LocalDate.now();
        LocalDate saida = LocalDate.parse(dataSaida + "/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (hoje.isBefore(saida)) {
            System.out.println("Está fazendo check-out antes da data de saída. O pagamento será integral!");
        }

        checkOutRealizado = true;
        quarto.liberar();
        System.out.println("Check-out realizado com sucesso! Quarto liberado.");
    }

    public double calcularTotal() {
        LocalDate inicio = LocalDate.parse(dataEntrada + "/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fim = LocalDate.parse(dataSaida + "/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        long dias = ChronoUnit.DAYS.between(inicio, fim);

        double totalQuarto = quarto.getValorDiaria() * dias;

        double totalServicos = servicos.stream()
                .mapToDouble(Servico::getPreco)
                .sum();

        return totalQuarto + totalServicos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reserva #").append(codigo)
                .append(" | Data de Entrada: ").append(dataEntrada)
                .append(" | Data de Saída: ").append(dataSaida)
                .append(" | Quarto: ").append(quarto.getNumero())
                .append(" (").append(quarto.getTipo()).append(")")
                .append(" | Hóspede: ");

        if (hospedes.isEmpty()) {
            sb.append("Nenhum hóspede adicionado.");
        } else {
            for (Hospede h : hospedes) {
                sb.append("\n - ").append(h.getNome()).append(" (CPF: ").append(h.getCpf()).append(")");
            }
        }

        sb.append("\n | Check-in: ").append(checkInRealizado ? "Realizado" : "Pendente");
        sb.append(" | Check-out: ").append(checkOutRealizado ? "Realizado" : "Pendente");

        sb.append("\n | Serviços:");
        if (servicos.isEmpty()) {
            sb.append(" Nenhum serviço adicionado.");
        } else {
            for (Servico s : servicos) {
                sb.append("\n - ").append(s.getNome()).append(" (R$ ").append(s.getPreco()).append(")");
            }
        }

        sb.append("\n | Total estimado: R$ ").append(calcularTotal());
        sb.append("\n");

        return sb.toString();
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }
}
