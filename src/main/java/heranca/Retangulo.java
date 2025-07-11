package heranca;

public class Retangulo extends Quadrilatero {
    public Retangulo(double base, double altura) {
        super(base, altura, base, altura);
    }

    @Override
    public double getArea() {
        return lado1 * lado2;
    }

    @Override
    public String toString() {
        return "Retângulo [base=" + lado1 + ", altura=" + lado2 + "]";
    }
}