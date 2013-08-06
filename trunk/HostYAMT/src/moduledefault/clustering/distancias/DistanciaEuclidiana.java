/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import java.io.IOException;
import java.util.ArrayList;
import moduledefault.clustering.kmeans.Centroide;
import moduledefault.clustering.uteis.MatrizDados;

/**
 *
 * @author Mateus
 */
public class DistanciaEuclidiana extends DistanciaPrincipal {

    public DistanciaEuclidiana(MatrizDados teste) {
        setMatrizDistancias(teste.getLinhas());
    }



    public void distancia(MatrizDados teste) {
        double acumulador = 0;
        for (int i = 0; i < teste.getLinhas(); i++) {
            for (int j = 0; j < teste.getLinhas(); j++) {
                if (i != j) {
                    for (int w = 1; w < teste.getColunas(); w++) {
                        acumulador += Math.pow(teste.getMatriz_dados()[i][w] - teste.getMatriz_dados()[j][w], 2);
                    }
                    matrizDistancias[i][j] = Math.sqrt(acumulador);
                    acumulador = 0;
                }
            }
        }
        padronizacaDistancias(matrizDistancias);
    }

    public static float[][] distanciaKmeans(ArrayList<Centroide> centroides, int numK, float[][] matrizAtributos, int linhas) {
        float[][] resultado = new float[linhas][numK];
        for (int i = 0; i < linhas; i++) {
            for (int w = 0; w < numK; w++) {
                double acumulador = 0;
                for (int j = 0; j < centroides.get(w).getAtributos().size(); j++) {
                    acumulador += Math.pow(matrizAtributos[i][j] - centroides.get(w).getAtributos().get(j), 2);
                }
                resultado[i][w] = ((float) Math.sqrt((acumulador)));
            }
        }
        return resultado;
    }
}
