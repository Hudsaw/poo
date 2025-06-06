package simulador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilidade {
    public static String formatarHora(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return data.format(formatter);
    }
}