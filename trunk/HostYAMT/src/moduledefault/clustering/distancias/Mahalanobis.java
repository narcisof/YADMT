/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import Jama.Matrix;

import java.io.IOException;
import moduledefault.clustering.uteis.MatrizDados;

/**
 *
 * @author Mateus
 */
public class Mahalanobis extends DistanciaPrincipal {

    public Mahalanobis(MatrizDados teste) {
        System.out.println("mahalanobis");
        setMatrizDistancias(teste.getLinhas());
    }

    public void distancia(MatrizDados teste) throws IOException {
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
}
