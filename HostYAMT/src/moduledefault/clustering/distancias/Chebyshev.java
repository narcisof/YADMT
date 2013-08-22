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
public class Chebyshev extends DistanciaPrincipal {

    public Chebyshev(Base teste) {
        setMatrizDistancias(teste.getDataSet().size());
    }

    public void distancia(Base teste)  {
        for (int i = 0; i < teste.getDataSet().size(); i++) {
            for (int j = 0; j < teste.getDataSet().size(); j++) {
                if (i != j) {
                    double acumulador[] = new double[teste.getAtributos().size()-1];
                    for (int w = 0; w < teste.getAtributos().size()-1; w++) {
                        acumulador[w] = Math.abs(teste.getDataSet().get(i).getAtributos().get(w) - teste.getDataSet().get(j).getAtributos().get(w));
                    }
                    matrizDistancias[i][j] = maximo(acumulador);
                }
            }
        }
        padronizacaDistancias(matrizDistancias);
    }

    public static float[][] distanciaKmeans(int linhas, int k, double[][] matriz, ArrayList<Centroide> centroide) {
        float[][] resultado = new float[linhas][k];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    double acumulador[] = new double[k];
                    for (int w = 0; w < k; w++) {
                        acumulador[w] = Math.abs(matriz[i][w] -centroide.get(w).getAtributos().get(j));
                    }
                    resultado[i][j] = (float) maximo(acumulador);
                }
            }
        }
        return resultado;
    }

    private static double maximo(double[] acumulador) {
        double maior = Double.MIN_VALUE;
        for (int i = 0; i < acumulador.length - 1; i++) {
            double aux = Math.max(acumulador[i], acumulador[i + 1]);
            if (aux > maior) {
                maior = aux;
            }
        }
        return maior;
    }
}
