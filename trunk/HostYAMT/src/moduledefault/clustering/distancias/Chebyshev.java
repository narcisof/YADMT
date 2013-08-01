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
public class Chebyshev extends DistanciaPrincipal {

    public Chebyshev(MatrizDados teste) {
        System.out.println("Chebyshev");
        setMatrizDistancias(teste.getLinhas());
    }

    public void distancia(MatrizDados teste) throws IOException {
        for (int i = 0; i < teste.getLinhas(); i++) {
            for (int j = 0; j < teste.getLinhas(); j++) {
                if (i != j) {
                    double acumulador[] = new double[teste.getColunas() - 1];
                    for (int w = 1; w < teste.getColunas(); w++) {
                        acumulador[w - 1] = Math.abs(teste.getMatriz_dados()[i][w] - teste.getMatriz_dados()[j][w]);
                    }
                    matrizDistancias[i][j] = maximo(acumulador);
                }
            }
        }
        padronizacaDistancias(matrizDistancias);
    }

    public static float[][] distanciaKmeans(int linhas, int k, float[][] matriz, ArrayList<Centroide> centroide) {
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
