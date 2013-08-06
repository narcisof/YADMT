/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import Jama.Matrix;

import java.io.IOException;
import java.util.ArrayList;
import moduledefault.clustering.kmeans.Centroide;
import moduledefault.clustering.uteis.MatrizDados;

/**
 *
 * @author Mateus
 */
public class Mahalanobis extends DistanciaPrincipal {

    public Mahalanobis(MatrizDados teste) {
        setMatrizDistancias(teste.getLinhas());
    }

    public void distancia(MatrizDados teste)  {
        double[] medias = new double[teste.getColunas() - 1];
        double somador = 0;
        for (int i = 1; i < teste.getColunas(); i++) {
            for (int j = 0; j < teste.getLinhas(); j++) {
                somador += teste.getMatriz_dados()[j][i];
            }
            medias[i - 1] = somador / teste.getLinhas();
            somador = 0;
        }
        somador = 0;
        double[][] cov = new double[teste.getColunas() - 1][teste.getColunas() - 1];
        for (int j = 0; j < teste.getColunas() - 1; j++) {
            for (int k = 0; k < teste.getColunas() - 1; k++) {
                for (int i = 1; i < teste.getColunas(); i++) {
                    somador += (teste.getMatriz_dados()[i][j] - medias[j]) * (teste.getMatriz_dados()[i][k] - medias[k]);
                }
                cov[j][k] = somador / ((teste.getColunas() - 1) - 1);
                somador = 0;
            }
        }

        Matrix matrix = new Matrix(cov);
        Matrix inversa_matrix;
        inversa_matrix = matrix.inverse();
        double[][] inversa;
        inversa = inversa_matrix.getArrayCopy();
        double[] vetor1 = new double[teste.getColunas() - 1];
        double[] vetor2 = new double[teste.getColunas() - 1];
        double[][] menos = new double[1][teste.getColunas() - 1];
        double[][] transposta = new double[teste.getColunas() - 1][1];
        Matrix minus1;
        Matrix minus2;
        Matrix multiplicação_matrix;
        double[][] multiplicação;
        for (int i = 0; i < teste.getLinhas(); i++) {
            for (int j = 0; j < teste.getLinhas(); j++) {
                for (int w = 1; w < teste.getColunas(); w++) {
                    vetor1[w - 1] = teste.getMatriz_dados()[i][w];
                    vetor2[w - 1] = teste.getMatriz_dados()[j][w];
                }
                minus1 = new Matrix(vetor1, (teste.getColunas() - 1));
                minus2 = new Matrix(vetor2, (teste.getColunas() - 1));
                minus1.minusEquals(minus2);
                menos[0] = minus1.getRowPackedCopy();
                for (int y = 0; y < teste.getColunas() - 1; y++) {
                    transposta[y][0] = menos[0][y];
                }
                multiplicação_matrix = new Matrix(menos);
                inversa_matrix.arrayTimesEquals(matrix);
                multiplicação = multiplicação_matrix.getArrayCopy();
                double somador2 = 0;
                for (int g = 0; g < teste.getColunas() - 1; g++) {
                    somador2 += multiplicação[0][g] * transposta[g][0];
                }
                matrizDistancias[i][j] = somador2;
            }
        }
    }

    public static float[][] distanciaKmeans(int linhas, int k, float[][] matriz, ArrayList<Centroide> centroide) {
        float[][] r = new float[linhas][k];
        double[] medias = new double[k];
        double somador = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < linhas; j++) {
                somador += matriz[j][i];
            }
            medias[i] = somador / linhas;
            somador = 0;
        }
        somador = 0;
        double[][] cov = new double[k][k];
        for (int j = 0; j < k; j++) {
            for (int w = 0; w < k; w++) {
                for (int i = 0; i < k; i++) {
                    somador += (matriz[i][j] - medias[j]) * (centroide.get(i).getAtributos().get(w) - medias[w]);
                }
                cov[j][w] = somador / ((k));
                somador = 0;
            }
        }

        Matrix matrix = new Matrix(cov);
        Matrix inversa_matrix;
        inversa_matrix = matrix.inverse();
        double[][] inversa;
        inversa = inversa_matrix.getArrayCopy();
        double[] vetor1 = new double[k];
        double[] vetor2 = new double[k];
        double[][] menos = new double[1][k];
        double[][] transposta = new double[k][1];
        Matrix minus1;
        Matrix minus2;
        Matrix multiplicação_matrix;
        double[][] multiplicação;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < k; j++) {
                for (int w = 0; w < k; w++) {
                    vetor1[w] = matriz[i][w];
                    vetor2[w] = centroide.get(j).getAtributos().get(w);
                }
                minus1 = new Matrix(vetor1, (k));
                minus2 = new Matrix(vetor2, (k));
                minus1.minusEquals(minus2);
                menos[0] = minus1.getRowPackedCopy();
                for (int y = 0; y < k; y++) {
                    transposta[y][0] = menos[0][y];
                }
                multiplicação_matrix = new Matrix(menos);
                inversa_matrix.arrayTimesEquals(matrix);
                multiplicação = multiplicação_matrix.getArrayCopy();
                double somador2 = 0;
                for (int g = 0; g < k; g++) {
                    somador2 += multiplicação[0][g] * transposta[g][0];
                }
                r[i][j] = (float) somador2;
            }
        }
        return r;
    }
}
