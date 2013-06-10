/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;


import java.io.IOException;
import moduledefault.clustering.uteis.MatrizDados;

/**
 *
 * @author Mateus
 */
public class DistanciaEuclidiana extends DistanciaPrincipal{

    public DistanciaEuclidiana(MatrizDados teste) {
        System.out.println("euclidiana");
        setMatrizDistancias(teste.getLinhas());
    }



    public void distancia(MatrizDados teste) throws IOException {
        double acumulador = 0;
        for (int i = 0; i < teste.getLinhas(); i++) {
            for (int j = 0; j < teste.getLinhas(); j++) {
                if (i != j) {
                    for (int w = 1; w < teste.getColunas(); w++) {
                        acumulador += Math.pow(teste.getMatriz_dados()[i][w] - teste.getMatriz_dados()[j][w], 2);
                    }
                    matrizDistancias[i][j] = Math.sqrt(acumulador);
                    acumulador = 0;
                }
            }
        }
        padronizacaDistancias(matrizDistancias);
    }


}
