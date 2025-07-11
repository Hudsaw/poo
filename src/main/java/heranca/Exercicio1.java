package heranca;

import java.util.Scanner;

public class Exercicio1 {
    public static void executar(Scanner scanner) {
        System.out.println("\n--- Conta Corrente e Herança ---");

        ContaCorrente ccNormal = new ContaCorrente(1000.0);
        ContaEspecial ccEspecial = new ContaEspecial(1000.0);

        int opcao;
        do {
            System.out.println("\nEscolha uma conta:");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Especial");
            System.out.println("3 - Voltar ao menu principal");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1 || opcao == 2) {
                boolean voltar = false;
                while (!voltar) {
                    System.out.println("\nOperações disponíveis:");
                    System.out.println("1 - Depositar");
                    System.out.println("2 - Sacar");
                    System.out.println("3 - Ver Saldo");
                    System.out.println("4 - Voltar");
                    System.out.print("Opção: ");
                    int operacao = scanner.nextInt();

                    switch (operacao) {
                        case 1:
                            System.out.print("Digite o valor para depósito: ");
                            double valorDeposito = scanner.nextDouble();
                            if (opcao == 1) {
                                ccNormal.depositar(valorDeposito);
                                System.out.println("Depósito realizado. Saldo atual: " + ccNormal.getSaldo());
                            } else {
                                ccEspecial.depositar(valorDeposito);
                                System.out.println("Depósito realizado. Saldo atual: " + ccEspecial.getSaldo());
                            }
                            break;
                        case 2:
                            System.out.print("Digite o valor para saque: ");
                            double valorSaque = scanner.nextDouble();
                            if (opcao == 1) {
                                if(valorSaque > ccNormal.getSaldo()) {
                                    System.out.println("Saldo insuficiente para saque.");
                                    break;
                                }
                                ccNormal.sacar(valorSaque);
                                System.out.println("Saque realizado. Saldo atual: " + ccNormal.getSaldo());
                            } else {
                                ccEspecial.sacar(valorSaque);
                                System.out.println("Saque realizado. Saldo atual: " + ccEspecial.getSaldo());
                            }
                            break;
                        case 3:
                            if (opcao == 1) {
                                System.out.println("Saldo Conta Corrente: " + ccNormal.getSaldo());
                            } else {
                                System.out.println("Saldo Conta Especial: " + ccEspecial.getSaldo());
                            }
                            break;
                        case 4:
                            voltar = true;
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                }
            } else if (opcao != 3) {
                System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }
}