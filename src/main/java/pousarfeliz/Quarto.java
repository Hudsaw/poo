package pousarfeliz;

public class Quarto {
    private int numero;
    private String tipo; // "Simples", "Duplo", "Suíte"
    private double valorDiaria;
    private boolean disponivel;

    public Quarto(int numero, String tipo, double valorDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    public boolean verificarDisponibilidade() {
        return disponivel;
    }

    public void ocupar() {
        disponivel = false;
    }

    public void liberar() {
        disponivel = true;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String toString() {
        return "Quarto " + numero + " (" + tipo + ") - R$" + valorDiaria + " | Disponível: " + disponivel;
    }
}