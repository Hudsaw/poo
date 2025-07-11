package heranca;

public class ContaEspecial extends ContaCorrente {
    public ContaEspecial(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        double taxa = valor * 0.001; 
        saldo -= (valor + taxa);
    }
}
