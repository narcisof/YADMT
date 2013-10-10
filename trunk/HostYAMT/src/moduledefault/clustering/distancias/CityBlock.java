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
public class CityBlock {

    Base base;
    double[][] matrizDistancias;

    public CityBlock(Base teste) {
//        System.out.println("city");
        base = teste.copy();
        setMatrizDistancias(teste.getDataSet().size());
    }

    public CityBlock() {
    }

   
    public double distancia(List<Double> vet1, List<Double> vet2) {
        double acumulador = 0;
        for (int w = 0; w < vet2.size(); w++) {
            acumulador += Math.abs(vet1.get(w) - vet2.get(w));
        }
        return acumulador;
    }

    public void distancia() {
        double acumulador = 0;
        for (int i = 0; i < base.getDataSet().size(); i++) {
            for (int j = 0; j < base.getDataSet().size(); j++) {
                if (i != j) {
                    for (int w = 0; w < base.getAtributos().size() - 1; w++) {
                        acumulador += Math.abs(base.getDataSet().get(i).getAtributos().get(w) - base.getDataSet().get(j).getAtributos().get(w));
                    }
                    matrizDistancias[i][j] = acumulador;
                    acumulador = 0;
                }
            }
        }
        padronizacaDistancias(matrizDistancias);
    }

    public static double[][] distanciaKmeans(int linhas, int k, double[][] matriz, ArrayList<Centroide> centroide) {
        double acumulador = 0;
        double[][] resultado = new double[linhas][k];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    for (int w = 0; w < k; w++) {
                        acumulador += Math.abs(matriz[i][w] - centroide.get(j).getAtributos().get(w));
                    }
                    resultado[i][j] = (float) acumulador;
                    acumulador = 0;
                }
            }
        }
        return resultado;
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
