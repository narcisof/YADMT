/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import java.io.IOException;
import java.util.ArrayList;
import moduledefault.clustering.kmeans.Centroide;
import moduledefault.clustering.uteis.Base;

/**
 *
 * @author Mateus
 */
public class DistanciaEuclidiana extends DistanciaPrincipal {

    public DistanciaEuclidiana(Base teste) {
        setMatrizDistancias(teste.getDataSet().size());
    }



    public void distancia(Base teste) {
        double acumulador = 0;
        for (int i = 0; i < teste.getDataSet().size(); i++) {
            for (int j = 0; j < teste.getDataSet().size(); j++) {
                if (i != j) {
                    for (int w = 0; w < teste.getAtributos().size()-1; w++) {
                        acumulador += Math.pow(teste.getDataSet().get(i).getAtributos().get(w) - teste.getDataSet().get(j).getAtributos().get(w), 2);
                    }
                    matrizDistancias[i][j] = Math.sqrt(acumulador);
                    acumulador = 0;
                }
            }
        }
        padronizacaDistancias(matrizDistancias);
    }

    public static float[][] distanciaKmeans(ArrayList<Centroide> centroides, int numK, double[][] matrizAtributos, int linhas) {
        float[][] resultado = new float[linhas][numK];
        for (int i = 0; i < linhas; i++) {
            for (int w = 0; w < numK; w++) {
                double acumulador = 0;
                for (int j = 0; j < centroides.get(w).getAtributos().size()-1; j++) {
                    acumulador += Math.pow(matrizAtributos[i][j] - centroides.get(w).getAtributos().get(j), 2);
                }
                resultado[i][w] = ((float) Math.sqrt((acumulador)));
            }
        }
        return resultado;
    }
}
