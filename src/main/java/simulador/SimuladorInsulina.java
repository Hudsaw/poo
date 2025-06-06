package simulador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimuladorInsulina {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<RegistroGlicemia> historico = new ArrayList<>();
        int glicemiaAtual = 100;

        System.out.println("Bem-vindo ao Simulador de Controle de Insulina");
        System.out.println("Glicemia inicial estimada: " + glicemiaAtual + " mg/dL");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Registrar insulina aplicada (unidades)");
            System.out.println("2. Registrar atividade física (minutos)");
            System.out.println("3. Registrar consumo de carboidratos (g)");
            System.out.println("4. Visualizar histórico");
            System.out.println("5. Exportar histórico para arquivo TXT");
            System.out.println("6. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 6) break;

            switch (opcao) {
                case 1:
                    System.out.print("Quantas unidades de insulina foram aplicadas? ");
                    int unidades = scanner.nextInt();
                    int glicemiaAntes = glicemiaAtual;
                    glicemiaAtual -= unidades * 4; 
                    String indicacao = calcularIndicacao(glicemiaAtual);
                    historico.add(new RegistroGlicemia(LocalDateTime.now(), "INSULINA", unidades, glicemiaAntes, glicemiaAtual, indicacao));
                    mostrarStatus(glicemiaAtual, indicacao);
                    break;
                case 2:
                    System.out.print("Quantos minutos de atividade física? ");
                    int minutos = scanner.nextInt();
                    glicemiaAntes = glicemiaAtual;
                    glicemiaAtual -= minutos * 0.8;
                    indicacao = calcularIndicacao(glicemiaAtual);
                    historico.add(new RegistroGlicemia(LocalDateTime.now(), "ATIVIDADE", minutos, glicemiaAntes, glicemiaAtual, indicacao));
                    mostrarStatus(glicemiaAtual, indicacao);
                    break;
                case 3:
                    System.out.print("Quantos gramas de carboidratos consumidos? ");
                    int carbs = scanner.nextInt();
                    glicemiaAntes = glicemiaAtual;
                    glicemiaAtual += carbs * 0.4; 
                    indicacao = calcularIndicacao(glicemiaAtual);
                    historico.add(new RegistroGlicemia(LocalDateTime.now(), "CARBOIDRATO", carbs, glicemiaAntes, glicemiaAtual, indicacao));
                    mostrarStatus(glicemiaAtual, indicacao);
                    break;
                case 4:
                    exibirHistorico(historico);
                    break;
                case 5:
                    exportarHistorico(historico);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        System.out.println("Vê se segue as indicações pra não ficar escangalhado!");
        scanner.close();
    }

    private static void mostrarStatus(int glicemia, String indicacao) {
        System.out.printf("Glicemia atual estimada: %d mg/dL%n", glicemia);
        System.out.println("Indicação: " + indicacao);
    }

    private static String calcularIndicacao(int glicemia) {
        if (glicemia < 70) return "Hipoglicemia! Ingira carboidratos.";
        else if (glicemia > 180) return "Glicemia elevada. Ajuste de insulina.";
        else return "Glicemia OK.";
    }

    private static void exibirHistorico(List<RegistroGlicemia> historico) {
        System.out.println("\n--- HISTÓRICO DE REGISTROS ---");
        System.out.printf("%-16s | %-11s | %-5s | %-14s | %-14s | %s%n",
                "Data/Hora", "Tipo", "Quant", "Glicemia Antes", "Glicemia Depois", "Indicação");
        System.out.println("-".repeat(100));

        for (RegistroGlicemia r : historico) {
            System.out.printf("%-16s | %-11s | %-5d | %-14d | %-15d | %s%n",
                    Utilidade.formatarHora(r.getData()),
                    r.getTipo(),
                    r.getQuantidade(),
                    r.getGlicemiaAntes(),
                    r.getGlicemiaDepois(),
                    r.getIndicacao());
        }
        System.out.println("-".repeat(100));
    }

    private static void exportarHistorico(List<RegistroGlicemia> historico) {
        String nomeArquivo = "historico_glicemia_" + System.currentTimeMillis() + ".txt";
        try (java.io.FileWriter writer = new java.io.FileWriter(nomeArquivo)) {
            writer.write("=== HISTÓRICO DE CONTROLE DE GLICEMIA ===\n\n");
            writer.write(String.format("%-16s | %-11s | %-5s | %-14s | %-14s | %s%n",
                    "Data/Hora", "Tipo", "Quant", "Glicemia Antes", "Glicemia Depois", "Indicação"));
            writer.write("-".repeat(100) + "\n");

            for (RegistroGlicemia r : historico) {
                writer.write(String.format("%-16s | %-11s | %-5d | %-14d | %-15d | %s%n",
                        Utilidade.formatarHora(r.getData()),
                        r.getTipo(),
                        r.getQuantidade(),
                        r.getGlicemiaAntes(),
                        r.getGlicemiaDepois(),
                        r.getIndicacao()));
            }

            System.out.println("Histórico salvo como: " + nomeArquivo);
        } catch (Exception e) {
            System.err.println("Erro ao salvar o histórico: " + e.getMessage());
        }
    }
}