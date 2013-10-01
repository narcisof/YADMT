/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import Jama.Matrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import moduledefault.clustering.kmeans.Centroide;
import moduledefault.clustering.uteis.Base;

/**
 *
 * @author Mateus
 */
public class Mahalanobis {

    Base base;
    double[][] matrizDistancias;

    public Mahalanobis(Base teste) {
        base = teste.copy();
        setMatrizDistancias(teste.getDataSet().size());
    }

    public double distancia(List<Double> vet1, List<Double> vet2) {
        double[] medias = new double[vet1.size()];
        double somador = 0;
        for (int i = 0; i < vet1.size(); i++) {
            medias[i] = (vet1.get(i) + vet2.get(i)) / vet1.size();
            somador = 0;
        }
        somador = 0;
        double[][] cov = new double[vet1.size()][vet1.size()];
        for (int j = 0; j < vet1.size(); j++) {
            for (int k = 0; k < vet2.size(); k++) {
                for (int i = 0; i < vet1.size(); i++) {
                    somador += (vet1.get(j) - medias[j]) * (vet2.get(k) - medias[k]);
                }
                cov[j][k] = somador / ((vet1.size()));
                somador = 0;
            }
        }

        Matrix matrix = new Matrix(cov);
        Matrix inversa_matrix;
        inversa_matrix = matrix.inverse();
        double[][] inversa;
        inversa = inversa_matrix.getArrayCopy();
        double[] vetor1 = new double[vet1.size()];
        double[] vetor2 = new double[vet1.size()];
        double[][] menos = new double[1][vet1.size()];
        double[][] transposta = new double[vet1.size()][1];
        Matrix minus1;
        Matrix minus2;
        Matrix multiplicação_matrix;
        double[][] multiplicação;
        for (int w = 0; w < vet1.size(); w++) {
            vetor1[w] = vet1.get(w);
            vetor2[w] = vet2.get(w);
        }
        minus1 = new Matrix(vetor1, (vet1.size()));
        minus2 = new Matrix(vetor2, (vet2.size()));
        minus1.minusEquals(minus2);
        menos[0] = minus1.getRowPackedCopy();
        for (int y = 0; y < vet1.size(); y++) {
            transposta[y][0] = menos[0][y];
        }
        multiplicação_matrix = new Matrix(menos);
        inversa_matrix.arrayTimesEquals(matrix);
        multiplicação = multiplicação_matrix.getArrayCopy();
        double somador2 = 0;
        for (int g = 0; g < vet1.size(); g++) {
            somador2 += multiplicação[0][g] * transposta[g][0];
        }
        return somador2;

    }

    public void distancia() {
        double[] medias = new double[base.getAtributos().size() - 1];
        double somador = 0;
        for (int i = 0; i < base.getAtributos().size() - 1; i++) {
            for (int j = 0; j < base.getDataSet().size(); j++) {
                somador += base.getDataSet().get(j).getAtributos().get(i);
            }
            medias[i] = somador / base.getDataSet().size();
            somador = 0;
        }
        somador = 0;
        double[][] cov = new double[base.getAtributos().size() - 1][base.getAtributos().size() - 1];
        for (int j = 0; j < base.getAtributos().size() - 1; j++) {
            for (int k = 0; k < base.getAtributos().size() - 1; k++) {
                for (int i = 0; i < base.getAtributos().size() - 1; i++) {
                    somador += (base.getDataSet().get(i).getAtributos().get(j) - medias[j]) * (base.getDataSet().get(i).getAtributos().get(k) - medias[k]);
                }
                cov[j][k] = somador / ((base.getAtributos().size()) - 1);
                somador = 0;
            }
        }

        Matrix matrix = new Matrix(cov);
        Matrix inversa_matrix;
        inversa_matrix = matrix.inverse();
        double[][] inversa;
        inversa = inversa_matrix.getArrayCopy();
        double[] vetor1 = new double[base.getAtributos().size() - 1];
        double[] vetor2 = new double[base.getAtributos().size() - 1];
        double[][] menos = new double[1][base.getAtributos().size() - 1];
        double[][] transposta = new double[base.getAtributos().size() - 1][1];
        Matrix minus1;
        Matrix minus2;
        Matrix multiplicação_matrix;
        double[][] multiplicação;
        for (int i = 0; i < base.getDataSet().size(); i++) {
            for (int j = 0; j < base.getDataSet().size(); j++) {
                for (int w = 0; w < base.getAtributos().size() - 1; w++) {
                    vetor1[w] = base.getDataSet().get(i).getAtributos().get(w);
                    vetor2[w] = base.getDataSet().get(j).getAtributos().get(w);
                }
                minus1 = new Matrix(vetor1, (base.getAtributos().size() - 1));
                minus2 = new Matrix(vetor2, (base.getAtributos().size() - 1));
                minus1.minusEquals(minus2);
                menos[0] = minus1.getRowPackedCopy();
                for (int y = 0; y < base.getAtributos().size() - 1; y++) {
                    transposta[y][0] = menos[0][y];
                }
                multiplicação_matrix = new Matrix(menos);
                inversa_matrix.arrayTimesEquals(matrix);
                multiplicação = multiplicação_matrix.getArrayCopy();
                double somador2 = 0;
                for (int g = 0; g < base.getAtributos().size() - 1; g++) {
                    somador2 += multiplicação[0][g] * transposta[g][0];
                }
                matrizDistancias[i][j] = somador2;
            }
        }
    }

    public static float[][] distanciaKmeans(int linhas, int k, double[][] matriz, ArrayList<Centroide> centroide) {
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

    public double[][] getMatrizDistancias() {
        return matrizDistancias;
    }

    public void setMatrizDistancias(int linhas) {
        this.matrizDistancias = new double[linhas][linhas];
    }
}
