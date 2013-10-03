/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import moduledefault.clustering.kmeans.Centroide;
import moduledefault.clustering.uteis.Base;

/**
 *
 * @author Mateus
 */
public class Chebyshev {

    Base base;
    double[][] matrizDistancias;

    public Chebyshev(Base teste) {
        base = teste.copy();
        setMatrizDistancias(teste.getDataSet().size());
    }

    public Chebyshev() {
        
    }

    public double distancia(List<Double> vet1, List<Double> vet2) {
        double acumulador[] = new double[vet1.size()];
        for (int w = 0; w < vet1.size(); w++) {
            acumulador[w] = Math.abs(vet1.get(w) - vet2.get(w));
        }
        return maximo(acumulador);
    }

    public void distancia() {
        for (int i = 0; i < base.getDataSet().size(); i++) {
            for (int j = 0; j < base.getDataSet().size(); j++) {
                if (i != j) {
                    double acumulador[] = new double[base.getAtributos().size() - 1];
                    for (int w = 0; w < base.getAtributos().size() - 1; w++) {
                        acumulador[w] = Math.abs(base.getDataSet().get(i).getAtributos().get(w) - base.getDataSet().get(j).getAtributos().get(w));
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
                        acumulador[w] = Math.abs(matriz[i][w] - centroide.get(w).getAtributos().get(j));
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

    public double[][] getMatrizDistancias() {
        return matrizDistancias;
    }

    public void setMatrizDistancias(int linhas) {
        this.matrizDistancias = new double[linhas][linhas];
    }
    public void padronizacaDistancias(double[][] matriz) {
        double menor = 0;
        double maior = 0;
        int cont = 0;

        maior = Double.MIN_VALUE;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][cont] > maior) {
                    maior = matriz[i][j];
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] /= maior;
            }
        }
    }
}
