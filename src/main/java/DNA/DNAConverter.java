package DNA;

import java.util.HashMap;

public class DNAConverter {

    public static String converter(String dna) {
        HashMap<String, String> mapa = new HashMap<>();

        mapa.put("UUU", "F"); // Fenilalanina
        mapa.put("UUC", "F"); // Fenilalanina
        mapa.put("UUA", "L"); // Leucina
        mapa.put("UUG", "L"); // Leucina
        mapa.put("CUU", "L"); // Leucina
        mapa.put("CUC", "L"); // Leucina
        mapa.put("CUA", "L"); // Leucina
        mapa.put("CUG", "L"); // Leucina
        mapa.put("AUU", "I"); // Isoleucina
        mapa.put("AUC", "I"); // Isoleucina
        mapa.put("AUA", "I"); // Isoleucina
        mapa.put("AUG", "M"); // Metionina (start codon)
        mapa.put("GUU", "V"); // Valina
        mapa.put("GUC", "V"); // Valina
        mapa.put("GUA", "V"); // Valina
        mapa.put("GUG", "V"); // Valina
        mapa.put("UCU", "S"); // Serina
        mapa.put("UCC", "S"); // Serina
        mapa.put("UCA", "S"); // Serina
        mapa.put("UCG", "S"); // Serina
        mapa.put("CCU", "P"); // Prolina
        mapa.put("CCC", "P"); // Prolina
        mapa.put("CCA", "P"); // Prolina
        mapa.put("CCG", "P"); // Prolina
        mapa.put("ACU", "T"); // Treonina
        mapa.put("ACC", "T"); // Treonina
        mapa.put("ACA", "T"); // Treonina
        mapa.put("ACG", "T"); // Treonina
        mapa.put("GCU", "A"); // Alanina
        mapa.put("GCC", "A"); // Alanina
        mapa.put("GCA", "A"); // Alanina
        mapa.put("GCG", "A"); // Alanina
        mapa.put("UAU", "Y"); // Tirosina
        mapa.put("UAC", "Y"); // Tirosina
        mapa.put("UAA", "*"); // Códon de parada
        mapa.put("UAG", "*"); // Códon de parada
        mapa.put("CAU", "H"); // Histidina
        mapa.put("CAC", "H"); // Histidina
        mapa.put("CAA", "Q"); // Glutamina
        mapa.put("CAG", "Q"); // Glutamina
        mapa.put("AAU", "N"); // Asparagina
        mapa.put("AAC", "N"); // Asparagina
        mapa.put("AAA", "K"); // Lisina
        mapa.put("AAG", "K"); // Lisina
        mapa.put("GAU", "D"); // Ácido aspártico
        mapa.put("GAC", "D"); // Ácido aspártico
        mapa.put("GAA", "E"); // Ácido glutâmico
        mapa.put("GAG", "E"); // Ácido glutâmico
        mapa.put("UGU", "C"); // Cisteína
        mapa.put("UGC", "C"); // Cisteína
        mapa.put("UGA", "*"); // Códon de parada
        mapa.put("UGG", "W"); // Triptofano
        mapa.put("CGU", "R"); // Arginina
        mapa.put("CGC", "R"); // Arginina
        mapa.put("CGA", "R"); // Arginina
        mapa.put("CGG", "R"); // Arginina
        mapa.put("AGU", "S"); // Serina
        mapa.put("AGC", "S"); // Serina
        mapa.put("AGA", "R"); // Arginina
        mapa.put("AGG", "R"); // Arginina
        mapa.put("GGU", "G"); // Glicina
        mapa.put("GGC", "G"); // Glicina
        mapa.put("GGA", "G"); // Glicina
        mapa.put("GGG", "G"); // Glicina

        String sequenciaRna = dna.replace('T', 'U');
        System.out.println(sequenciaRna);
        System.out.println(sequenciaRna.length());

        StringBuilder sequenciaProteina = new StringBuilder();
        for (int i = 0; i < sequenciaRna.length(); i += 3) {
            String trinca = sequenciaRna.substring(i, i + 3);

            if (mapa.containsKey(trinca)) {
                String aminoacido = mapa.get(trinca);
                if (aminoacido.equals("*")) {
                    sequenciaProteina.append(aminoacido);
                    break;
                }
                sequenciaProteina.append(aminoacido);
            }
        }
        return sequenciaProteina.toString();
    }
}
