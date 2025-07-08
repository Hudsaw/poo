package carros;

import java.io.Serializable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Carro uno = new Uno();
        uno.ligar();
        uno.subirMarchar();
        uno.acelerar();
        uno.acelerar();
        uno.freiar();
        uno.subirMarchar();
        uno.subirMarchar();
        uno.acelerar();
        Utilitario utilitario = (Utilitario) uno;
       // uno.escada();
        ((Uno)uno).descerMarcha(2);

        Uno uno1 = new Uno();
        Byd byd = new Byd();

        Motorista motorista1 = new Motorista(uno);
        motorista1.qualCarro();
        motorista1.setCarro(byd);
        motorista1.qualCarro();

        motorista1.estacionar();
        motorista1.setCarro(uno);
        motorista1.estacionar();




    }
}