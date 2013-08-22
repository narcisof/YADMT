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
public class CityBlock extends DistanciaPrincipal {
    
    
    public CityBlock(Base teste) {
        setMatrizDistancias(teste.getDataSet().size());
    }



    public void distancia(Base teste) {
        double acumulador = 0;
        for (int i = 0; i < teste.getDataSet().size(); i++) {
            for (int j = 0; j < teste.getDataSet().size(); j++) {
                if (i != j) {
                    for (int w = 0; w < teste.getAtributos().size()-1; w++) {
                        acumulador += Math.abs(teste.getDataSet().get(i).getAtributos().get(w) - teste.getDataSet().get(j).getAtributos().get(w));
                    }
                    matrizDistancias[i][j] = acumulador;
                    acumulador = 0;
                }
            }
        }
        padronizacaDistancias(matrizDistancias);
    }
    public static float [][] distanciaKmeans(int linhas, int k, double[][]matriz, ArrayList<Centroide> centroide) {
        double acumulador = 0;
        float [][] resultado = new float[linhas][k];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    for (int w = 0; w < k; w++) {
                        acumulador += Math.abs(matriz[i][w] - centroide.get(j).getAtributos().get(w));
                    }
                    resultado[i][j] = (float)acumulador;
                    acumulador = 0;
                }
            }
        }
        return resultado;
    }
    
}
