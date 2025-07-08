package carros;

public class Motorista {
    private Carro carro;

    public void estacionar(){
        if (carro instanceof CarroAutomatico){
            ((CarroAutomatico) carro).park();
        }else{
            carro.freiar();
            System.out.println("Parando carro");
        }
    }
    public Motorista(Carro carro){
        this.carro=carro;
    }
    public void acelerar(){
        this.carro.acelerar();
    }
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    public void qualCarro(){
        System.out.println("Estou dirigindo o carro abaixo");
        this.carro.descricao();
    }
}
