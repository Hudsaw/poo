package NF;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import static NF.FormatadorUtil.Direcao.DIREITA;

public class FormatadorUtil {
    enum Direcao {ESQUERDA, DIREITA, CENTRO}
    public static String linha(int colunas){
        return StringUtils.center("",colunas,"-");
    }
    public static String formataDecimal(double valor, int colunas){
        String valorFormatado = String.format("%.2f",valor);
        return alinha(valorFormatado,colunas,Direcao.DIREITA);
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
        System.out.println(date.toString());
        System.out.println(formataDataPadrao(date));
        System.out.println(formata("d/M/y",date));
        System.out.println(formata("DD yyyy",date));
        System.out.println(formata("M yyyy",date));
        System.out.println(formata("MM yyyy",date));
        System.out.println(formata("MMM yyyy",date));
        System.out.println(formata("MMMM yyyy",date));
        System.out.println(formata("dd/MM/yyyy HH:mm:ss:SS",date));
        //Thread.sleep(10000);
        date = new Date();
        System.out.println(formata("dd/MM/yyyy HH:mm:ss:SS",date));
        //Usado pra incrementar horas, dias, meses, anos, minutos
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println(cal.getTime());
        System.out.println("Ano: " + cal.get(Calendar.YEAR));
        System.out.println("Dias do ano: " + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("Dia na semana: " + cal.get(Calendar.DAY_OF_WEEK));
        for(int i=0;i<10;i++) {
            System.out.printf("%s é ano bissexto? %s\n",
                    cal.get(Calendar.YEAR),
                    Year.isLeap(cal.get(Calendar.YEAR)));
            cal.add(Calendar.YEAR, 1);
        }

        if(cal.get(Calendar.DAY_OF_WEEK) == 6){
            System.out.println("SEXTOU!!!");
        }
        System.out.println("Financiamento iniciou em: "
                + formataDataPadrao(cal.getTime()));
        cal.add(Calendar.MONTH, 36);
        System.out.println("Financiamento iniciou em: "
                + formataDataPadrao(cal.getTime()));
        LocalDateTime entrada =
                LocalDateTime.of(2025,5,8,10,25);
        LocalDateTime saida = LocalDateTime.now();
        //Usado para calcular tempo (horas, minutos, segundos)
        Duration duracao = Duration.between(entrada, saida);
        System.out.println("Entrada: " + entrada);
        System.out.println("Saida: " + saida);
        System.out.println("Horas estacionado:"+duracao.toHours());
        System.out.println("Minutos estacionado:"+duracao.toMinutes());
        //Calculo de idade, anos... meses
        LocalDate nascimento = LocalDate.of(1983,1,22);
        LocalDate agora = LocalDate.now();
        agora = agora.plusYears(10);
        Period total = Period.between(nascimento,agora);
        System.out.printf("Idade %s anos daqui a 10 anos\n", total.getYears());

        LocalDate hoje = LocalDate.now();
        LocalDate prova = hoje.plusWeeks(2);
        System.out.println("Data da prova: " + prova);
        System.out.println("Aula dia 16/05");
        System.out.println(alinha("TEM SUPERMERCADO", 60, Direcao.CENTRO));
        System.out.println(alinha("TEM SUPERMERCADO", 60, Direcao.DIREITA));
        System.out.println(alinha("TEM SUPERMERCADO", 60, Direcao.ESQUERDA));
        System.out.println(formataDecimal(12.32,10));
        System.out.println(formataInteiro(19,10));
        System.out.println(StringUtils.center("",60,"-"));
        System.out.println(linha(100));
        System.out.println(linha(20));
        System.out.println("\n\n\n\n");

        String cabecalho = String.format("# %s %s %s %s %s %s",
                alinha("Código",8,DIREITA),
                alinha("Descrição",11,DIREITA),
                alinha("Qtde",6,DIREITA),
                alinha("Un",4,DIREITA),
                alinha("Valor unit.",12,DIREITA),
                alinha("Valor total",12,DIREITA));
        System.out.println(FormatadorUtil.linha(60));
        System.out.println(cabecalho);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
