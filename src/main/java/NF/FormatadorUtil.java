package NF;

import org.w3c.dom.ls.LSOutput;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class FormatadorUtil {

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