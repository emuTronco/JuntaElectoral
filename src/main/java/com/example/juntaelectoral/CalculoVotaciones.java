package com.example.juntaelectoral;

import java.util.ArrayList;
import java.util.List;
public class CalculoVotaciones {
    enum Prov {
        Coruña, Lugo, Ourense, Pontevedra
    };
    enum Partidos {
        PP, BNG, PSdG
    }
    public static void main(String[] args) {
//Elecciones autonómicas 2020 - Galicia
        int escaños[] = { 25, 14, 14, 22 }; // Escaños en cada provincia
        int[][] votos = new int[4][3];
        votos[Prov.Coruña.ordinal()][Partidos.PP.ordinal()] = 263293;
        votos[Prov.Coruña.ordinal()][Partidos.BNG.ordinal()] = 133144;
        votos[Prov.Coruña.ordinal()][Partidos.PSdG.ordinal()] = 89767;
        votos[Prov.Lugo.ordinal()][Partidos.PP.ordinal()] = 89266;
        votos[Prov.Lugo.ordinal()][Partidos.BNG.ordinal()] = 35178;
        votos[Prov.Lugo.ordinal()][Partidos.PSdG.ordinal()] = 28465;
        votos[Prov.Ourense.ordinal()][Partidos.PP.ordinal()] = 83016;
        votos[Prov.Ourense.ordinal()][Partidos.BNG.ordinal()] = 31117;
        votos[Prov.Ourense.ordinal()][Partidos.PSdG.ordinal()] = 30784;
        votos[Prov.Pontevedra.ordinal()][Partidos.PP.ordinal()] = 192187;
        votos[Prov.Pontevedra.ordinal()][Partidos.BNG.ordinal()] = 111901;
        votos[Prov.Pontevedra.ordinal()][Partidos.PSdG.ordinal()] = 104734;
        for (Prov prov : Prov.values()) {
            List<Integer> resultado = dHondt(escaños[prov.ordinal()], votos[prov.ordinal()]);
            System.out.println("\nProv " + prov.name());
            System.out.println(" ");
            for (Partidos part : Partidos.values()) {
                System.out.println(part.name() + " " + resultado.get(part.ordinal()));
            }
        }
    }
    public static List<Integer> dHondt(int escaños, int[] votos) {
        int partidos = votos.length;
        List<Integer> resultados = new ArrayList<>();
        for (int i = 0; i < partidos; i++) {
            resultados.add(0);
        }
        for (int i = 0; i < escaños; i++) {
            int maxIndex = 0;
            for (int j = 0; j < partidos; j++) {
                if (votos[j] / (resultados.get(j) + 1) > votos[maxIndex] / (resultados.get(maxIndex) + 1)) {
                    maxIndex = j;
                }
            }
            resultados.set(maxIndex, resultados.get(maxIndex) + 1);
        }
        return resultados;
    }
}