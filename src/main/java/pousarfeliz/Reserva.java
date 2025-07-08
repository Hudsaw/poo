package pousarfeliz;

import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private static int contador = 1;
    private int codigo;
    private String dataEntrada;
    private String dataSaida;
    private int diarias;
    private ArrayList<Hospede> hospedes;
    private List<Servico> servicos = new ArrayList<>();
    private Quarto quarto;

    public Reserva(String dataEntrada, String dataSaida, Integer diarias, Quarto quarto) {
        this.codigo = contador++;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.hospedes = new ArrayList<>();
        this.diarias = diarias;
        this.quarto = quarto;
        quarto.ocupar();
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public void adicionarHospede(Hospede h) {
        hospedes.add(h);
    }

    public double calcularTotal() {
        double totalQuarto = quarto.getValorDiaria() * diarias;
        double totalServicos = 0;

        for (Servico s : servicos) {
            totalServicos += s.getPreco();
        }

        return totalQuarto + totalServicos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reserva #").append(codigo)
                .append(" | Data de Entrada: ").append(dataEntrada)
                .append(" | Data de Saída: ").append(dataSaida)
                .append(" | Duração: ").append(diarias).append(" diárias")
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
}
