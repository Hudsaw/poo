package nota;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class FormatadorUtil {

    public enum Direcao {ESQUERDA, DIREITA, CENTRO}

    public static String linha (int colunas){
        return StringUtils.center("", colunas, "-");
    }

    public static String formatarDecimal(double valor, int colunas){
        String valorFormatado = String.format(".2f",valor);
        return alinha(valorFormatado, 7, Direcao.DIREITA);
    }

    public static String formataInteiro(Integer valor, int colunas){
        return StringUtils.center(valor.toString(), colunas, "0");
    }

    public static String alinha(String conteudo, int colunas, Direcao direcao) {
        switch (direcao) {
            case ESQUERDA:
                return StringUtils.leftPad(conteudo, colunas);
            case DIREITA:
                return StringUtils.rightPad(conteudo, colunas);
            case CENTRO:
            default:
                return StringUtils.center(conteudo, colunas);
        }
    }

    public static String formataDataHoraPadrao(Date date){
        SimpleDateFormat formatData = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
        return formatData.format(date);
    }
    public static String formataDataPadrao(Date date){
        SimpleDateFormat formatData = new SimpleDateFormat ("dd/MM/yyyy");
        return formatData.format(date);
    }
    public static String formataHoraPadrao(Date date){
        SimpleDateFormat formatData = new SimpleDateFormat ("HH:mm");
        return formatData.format(date);
    }

    public static void main(String[]args) throws Exception {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println(cal.getTime());
        System.out.println("Ano: " + cal.get(Calendar.YEAR));


        LocalDate nascimento = LocalDate.of(1978, 8, 2);
        LocalDate agora = LocalDate.now();
        Period total = Period.between(nascimento, agora);
        System.out.printf("Idade %s anos\n", total.getYears());
    }
}