package exame;

import org.apache.commons.lang3.StringUtils;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

import static exame.FormatadorUtil.Direcao.DIREITA;

public class FormatadorUtil {
    enum Direcao {ESQUERDA, DIREITA, CENTRO}
    public static String linha(int colunas){
        return StringUtils.center("",colunas,"-");
    }
    public static String formataDecimal(double valor, int colunas){
        String valorFormatado = String.format("%.2f",valor);
        return alinha(valorFormatado,colunas, Direcao.DIREITA);
    }
    public static String formataInteiro(Integer valor, int colunas){
        return StringUtils.leftPad(valor.toString(),colunas,"0");
    }
    public static String alinha(String conteudo, int colunas, Direcao direcao){
        if(direcao == Direcao.DIREITA){
            return StringUtils.leftPad(conteudo,colunas);
        }else if(direcao == Direcao.ESQUERDA){
            return StringUtils.rightPad(conteudo,colunas);
        }else if (direcao == Direcao.CENTRO){
            return StringUtils.center(conteudo,colunas);
        }
        return conteudo;
    }

    public static String formataDataPadrao(Date date){
        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        return formatData.format(date);
    }
    public static String formataDataHoraPadrao(Date date){
        SimpleDateFormat formatData =
                new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formatData.format(date);
    }
    public static String formata(String formato, Date date){
        SimpleDateFormat formatData =
                new SimpleDateFormat(formato);
        return formatData.format(date);
    }

    public static void main(String[] args) throws Exception{
        Date date = new Date();
        System.out.println(formata("dd/MM/yyyy HH:mm:ss",date));

        date = new Date();
        System.out.println(formata("dd/MM/yyyy yy:MM:dd'",date));

        public static String idade (LocalDate dataNascimento){
            LocalDate agora = LocalDate.now();
            Period periodo = Period.between(dataNascimento, agora);

            return String.format("02da%02dm%02dd", periodo.getYears(),periodo.getMonths(), periodo.getDays());
        }
}
