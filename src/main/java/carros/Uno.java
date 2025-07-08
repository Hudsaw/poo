package carros;

public class Uno implements Carro, Utilitario{
    private boolean ligado=false;
    private int velocidade=0;
    private int marcha=0;

    @Override
    public void descricao() {
        System.out.println("Sou UNO");
    }

    @Override
    public void ligar() {
        ligado=true;
        System.out.println("Ligou o Uno");
    }
    @Override
    public void desligar() {
        ligado=false;
        System.out.println("Desligou o Uno");
    }

    @Override
    public void acelerar() {
        velocidade+=10;
        System.out.println("Velocidade atual: " + velocidade);
    }

    @Override
    public void freiar() {
        velocidade-=10;
        System.out.println("Velocidade atual: " + velocidade);
    }

    @Override
    public void subirMarchar() {
        marcha++;
        System.out.println("Marcha atual: " + marcha);
    }

    @Override
    public void descerMarcha() {
        marcha--;
        System.out.println("Marcha atual: " + marcha);
    }

    public void descerMarcha(int marcha){
        this.marcha = marcha;
        System.out.println("Marcha atual: " + marcha);
    }

    @Override
    public void marchaRe() {
        marcha=-1;
        System.out.println("Marcha atual: Ré" );
    }

    @Override
    public void neutro() {
        marcha=0;
        System.out.println("Marcha atual: N");
    }

    @Override
    public void escada() {
        velocidade=velocidade*2;
        System.out.println("Velocidade atual: " +velocidade);
        System.out.println("Sai da frente!");
    }
}
