package extrato;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    public static String formataDecimal(double valor, int colunas){
        String valorFormatado = String.format("%.2f",valor);
        return alinha(valorFormatado,colunas,Direcao.DIREITA);
    }

    public static String formataInteiro(Integer valor, int colunas){
        return String.format("%0" + colunas + "d", valor);
    }

    public static String formatarData(Date data) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    public static String formatarMiniData(Date data) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM");
        return sdf.format(data);
    }

    public static String formatarHora(LocalDateTime data) {
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        return data.format(formatterHora);
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

    public static void atualizarSaldos(List<Tabela> extratos, Double saldoInicial) {
        double saldoAtual = saldoInicial;
        for (Tabela extrato : extratos) {
            TipoTransacao transacao = extrato.getTipoTransacao();
            if (transacao.getTipo() == TipoTransacao.Tipo.RECEITA) {
                saldoAtual += transacao.getValor();
            } else if (transacao.getTipo() == TipoTransacao.Tipo.DESPESA) {
                saldoAtual -= transacao.getValor();
            }
            extrato.setSaldo(saldoAtual);
        }
    }
}
