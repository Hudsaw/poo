package pousarfeliz;

import java.util.ArrayList;

import java.util.ArrayList;

public class Reserva {
    private static int contador = 1;
    private int codigo;
    private String dataEntrada;
    private String dataSaida;
    private ArrayList<Hospede> hospedes;
    private Quarto quarto;

    public Reserva(String dataEntrada, String dataSaida, Quarto quarto) {
        this.codigo = contador++;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.hospedes = new ArrayList<>();
        this.quarto = quarto;
        quarto.ocupar();
    }

    public void adicionarHospede(Hospede h) {
        hospedes.add(h);
    }

    public double calcularTotal(int dias) {
        return quarto.getValorDiaria() * dias;
    }

    public String toString() {
        return "Reserva #" + codigo + " | Quarto: " + quarto.getNumero();
    }
}