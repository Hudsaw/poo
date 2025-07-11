package heranca;

public class Quadrado extends Quadrilatero {
    public Quadrado(double lado) {
        super(lado, lado, lado, lado);
    }

    @Override
    public double getArea() {
        return lado1 * lado1;
    }

    @Override
    public String toString() {
        return "Quadrado [lado=" + lado1 + "]";
    }
}