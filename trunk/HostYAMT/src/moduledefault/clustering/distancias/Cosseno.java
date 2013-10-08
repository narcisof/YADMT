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
public class Cosseno{
    Base base;
    double[][] matrizDistancias;
    
    public Cosseno(Base teste) {
        System.out.println("cosseno");
        base = teste.copy();
        setMatrizDistancias(teste.getDataSet().size());
    }

    public Cosseno() {
    }
    

 
    public double distancia(List<Double> vet1, List<Double> vet2) {
        double vetorial = 0;
        double compvetor1 = 0;
        double compvetor2 = 0;
        double compvetor11 = 0;
        double compvetor21 = 0;
        double resultado = 0;
        //d1 * d2
        for (int w = 0; w < vet1.size(); w++) {
            vetorial += vet1.get(w) * vet2.get(w);
        }
        for (int y = 0; y < vet1.size(); y++) {
            compvetor1 += Math.pow(vet1.get(y), 2);
            compvetor2 += Math.pow(vet2.get(y), 2);
            compvetor11 = Math.sqrt(compvetor1);
            compvetor21 = Math.sqrt(compvetor2);
        }
        resultado = vetorial / (compvetor11 * compvetor21);

        return (1 - resultado);

    }

    public void distancia() {
        double vetorial = 0;
        double compvetor1 = 0;
        double compvetor2 = 0;
        double compvetor11 = 0;
        double compvetor21 = 0;
        double resultado = 0;
        //d1 * d2
        for (int i = 0; i < base.getDataSet().size(); i++) {
            for (int j = 1; j < base.getDataSet().size(); j++) {
                for (int w = 0; w < base.getAtributos().size() - 1; w++) {
                    vetorial += base.getDataSet().get(i).getAtributos().get(w) * base.getDataSet().get(j).getAtributos().get(w);
                }
                for (int y = 0; y < base.getAtributos().size() - 1; y++) {
                    compvetor1 += Math.pow(base.getDataSet().get(i).getAtributos().get(y), 2);
                    compvetor2 += Math.pow(base.getDataSet().get(j).getAtributos().get(y), 2);
                    compvetor11 = Math.sqrt(compvetor1);
                    compvetor21 = Math.sqrt(compvetor2);
                }
                resultado = vetorial / (compvetor11 * compvetor21);
                matrizDistancias[i][j] = (1 - resultado);
                compvetor1 = 0;
                compvetor2 = 0;
                vetorial = 0;
            }
        }
        padronizacaDistancias(matrizDistancias);
    }

    public static double[][] distanciaKmeans(int linhas, int k, double[][] matriz, ArrayList<Centroide> centroide) {
        double vetorial = 0;
        double compvetor1 = 0;
        double compvetor2 = 0;
        double compvetor11 = 0;
        double compvetor21 = 0;
        double resultado = 0;
        //d1 * d2
        double[][] re = new double[linhas][k];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < k; j++) {
                for (int w = 0; w < k; w++) {
                    vetorial += matriz[i][w] * centroide.get(j).getAtributos().get(w);
                }
                for (int y = 0; y < k; y++) {
                    compvetor1 += Math.pow(matriz[i][y], 2);
                    compvetor2 += Math.pow(centroide.get(j).getAtributos().get(y), 2);
                    compvetor11 = Math.sqrt(compvetor1);
                    compvetor21 = Math.sqrt(compvetor2);
                }
                resultado = vetorial / (compvetor11 * compvetor21);
                re[i][j] = (float) (1 - resultado);
                compvetor1 = 0;
                compvetor2 = 0;
                vetorial = 0;
            }
        }
        return re;
    }
       public void padronizacaDistancias(double[][] matriz) {
        double menor = 0;
        double maior = 0;
        int cont = 0;

        maior = Double.MIN_VALUE;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > maior) {
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

