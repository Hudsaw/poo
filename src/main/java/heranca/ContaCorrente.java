package heranca;

public class ContaCorrente {
    protected double saldo;

    public ContaCorrente(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        double taxa = valor * 0.005;
        saldo -= (valor + taxa);
    }

    public double getSaldo() {
        return saldo;
    }
}


