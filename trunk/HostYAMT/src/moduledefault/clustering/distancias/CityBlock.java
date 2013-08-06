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
public class CityBlock extends DistanciaPrincipal {
    
    
    public CityBlock(MatrizDados teste) {
        setMatrizDistancias(teste.getLinhas());
    }



    public void distancia(MatrizDados teste) {
        double acumulador = 0;
        for (int i = 0; i < teste.getLinhas(); i++) {
            for (int j = 0; j < teste.getLinhas(); j++) {
                if (i != j) {
                    for (int w = 1; w < teste.getColunas(); w++) {
                        acumulador += Math.abs(teste.getMatriz_dados()[i][w] - teste.getMatriz_dados()[j][w]);
                    }
                    matrizDistancias[i][j] = acumulador;
                    acumulador = 0;
                }
            }
        }
        padronizacaDistancias(matrizDistancias);
    }
    public static float [][] distanciaKmeans(int linhas, int k, float[][]matriz, ArrayList<Centroide> centroide) {
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
