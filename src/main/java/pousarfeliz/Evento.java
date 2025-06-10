package pousarfeliz;

import java.util.Random;
import java.util.List;

public class Evento {
    private static final Random rand = new Random();

    public static double ocorrerEvento(double caixa, List<Quarto> quartos) {
        int evento = rand.nextInt(7); // 0 a 6

        int pesoTotal = 0;
        for (Quarto q : quartos) {
            if (q.getTipo().equals("Simples")) {
                pesoTotal += 1;
            } else if (q.getTipo().equals("Duplo")) {
                pesoTotal += 2;
            } else if (q.getTipo().equals("Suíte")) {
                pesoTotal += 3;
            }
        }

        switch (evento) {
            case 0:
                System.out.println("[EVENTO] Um influencer postou sobre sua pousada! Ganhando R$100!");
                caixa += 100;
                break;
            case 1:
                double reparo = 50 * pesoTotal;
                System.out.println("[EVENTO] Choveu muito e alguns quartos tiveram vazamento. Gastando R$" + reparo + " em reparos.");
                caixa -= reparo;
                break;
            case 2:
                System.out.println("[EVENTO] Temporada alta! Todos os quartos com 20% a mais no valor hoje.");
                break;
            case 3:
                double cancelamento = 80 * pesoTotal;
                System.out.println("[EVENTO] Cancelamentos inesperados. Perda de R$" + cancelamento + ".");
                caixa -= cancelamento;
                break;
            case 4:
                double eletricista = 60 * pesoTotal;
                System.out.println("[EVENTO] Apareceu um problema elétrico. Precisou chamar eletricista. R$" + eletricista + " gastos.");
                caixa -= eletricista;
                break;
            case 5:
                double multa = 100 * pesoTotal;
                System.out.println("[EVENTO] Multa de trânsito urbano por falta de vaga acessível. R$" + multa + " perdidos.");
                caixa -= multa;
                break;
            case 6:
                System.out.println("[EVENTO] Nenhum evento hoje.");
                break;
        }

        return caixa; // Retorna o valor atualizado do caixa
    }
}


