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
public class Cosseno extends DistanciaPrincipal{


    public Cosseno(MatrizDados teste) {
        System.out.println("cosseno");
        setMatrizDistancias(teste.getLinhas());
    }



    public void distancia(MatrizDados teste) throws IOException {
        double vetorial = 0;
        double compvetor1 = 0;
        double compvetor2 = 0;
        double compvetor11 = 0;
        double compvetor21 = 0;
        double resultado = 0;
        //d1 * d2
        for (int i = 0; i < teste.getLinhas(); i++) {
            for (int j = 1; j < teste.getLinhas(); j++) {
                for (int w = 1; w < teste.getColunas(); w++) {
                    vetorial += teste.getMatriz_dados()[i][w] * teste.getMatriz_dados()[j][w];
                }
                for (int y = 1; y < teste.getColunas(); y++) {
                    compvetor1 += Math.pow(teste.getMatriz_dados()[i][y], 2);
                    compvetor2 += Math.pow(teste.getMatriz_dados()[j][y], 2);
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


}
