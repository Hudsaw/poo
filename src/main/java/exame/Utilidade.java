package exame;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

class Utilidade {
    enum Direcao { ESQUERDA, DIREITA, CENTRO }

    public static String linha(int colunas) {
        return "-".repeat(colunas);
    }

    public static String alinha(String texto, int colunas, Direcao direcao) {
        if (texto == null) texto = "";
        int espacos = Math.max(0, colunas - texto.length());
        switch (direcao) {
            case ESQUERDA:
                return texto + " ".repeat(espacos);
            case DIREITA:
                return " ".repeat(espacos) + texto;
            case CENTRO:
                int esquerda = espacos / 2;
                int direita = espacos - esquerda;
                return " ".repeat(esquerda) + texto + " ".repeat(direita);
            default:
                return texto;
        }
    }

    public static String formatarData(Date data) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    public static String formatarDataHora(Date data) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(data);
    }

    public static String idade(Date dataNascimento) {
        Calendar hoje = Calendar.getInstance();
        Calendar nasc = Calendar.getInstance();
        nasc.setTime(dataNascimento);

        int anos = hoje.get(Calendar.YEAR) - nasc.get(Calendar.YEAR);
        int meses = hoje.get(Calendar.MONTH) - nasc.get(Calendar.MONTH);
        int dias = hoje.get(Calendar.DAY_OF_MONTH) - nasc.get(Calendar.DAY_OF_MONTH);

        String dataHoje = formatarData(hoje.getTime());
        
        return "Idade em " + dataHoje + ": " + anos + "a" + meses + "m" + dias + "d";
    }

    public LocalDate calculaPrevisaoResultado(int diasResultado, LocalDate dataColeta) {
        return dataColeta.plusDays(diasResultado);
    }
}
