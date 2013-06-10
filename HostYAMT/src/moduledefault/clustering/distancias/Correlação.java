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
public class Correlação extends DistanciaPrincipal{

    

    public Correlação(MatrizDados teste) {
        setMatrizDistancias(teste.getLinhas());
    }



    public void distancia(MatrizDados teste) throws IOException {
        double[] d3 = new double[teste.getColunas()];
        double[] d4 = new double[teste.getColunas()];
        double somador = 0;
        double media1 = 0;
        double media2 = 0;
        double somatoriodesv1 = 0;
        double somatoriodesvquad1 = 0;
        double somatoriodesv2 = 0;
        double somatoriodesvquad2 = 0;
        double variancia1 = 0;
        double variancia2 = 0;
        double desvpad1 = 0;
        double desvpad2 = 0;
        double correlacao = 0;

        for (int y = 0; y < teste.getLinhas(); y++) {
            for (int w = 0; w < teste.getLinhas(); w++) {
                for (int i = 1; i < teste.getColunas(); i++) {
                    somador += teste.getMatriz_dados()[y][i];
                    somatoriodesvquad1 += Math.pow(teste.getMatriz_dados()[y][i], 2);
                }
                media1 = somador / (teste.getColunas() - 1);
                somatoriodesv1 = Math.pow(somador, 2);
                somador = 0;
                for (int i = 1; i < teste.getColunas(); i++) {
                    somador += teste.getMatriz_dados()[w][i];
                    somatoriodesvquad2 += Math.pow(teste.getMatriz_dados()[w][i], 2);
                }
                media2 = somador / (teste.getColunas() - 1);
                somatoriodesv2 = Math.pow(somador, 2);
                variancia1 = (somatoriodesvquad1 - (somatoriodesv1 / (teste.getColunas() - 1))) / ((teste.getColunas() - 1) - 1);
                variancia2 = (somatoriodesvquad2 - (somatoriodesv2 / (teste.getColunas() - 1))) / ((teste.getColunas() - 1) - 1);
                desvpad1 = Math.sqrt(variancia1);
                desvpad2 = Math.sqrt(variancia2);
                for (int i = 1; i < teste.getColunas(); i++) {
                    d3[i - 1] = (teste.getMatriz_dados()[y][i] - media1) / desvpad1;
                    d4[i - 1] = (teste.getMatriz_dados()[w][i] - media2) / desvpad2;
                }
                for (int i = 0; i < teste.getColunas() - 1; i++) {
                    correlacao += d3[i] * d4[i];
                }
                matrizDistancias[y][w] = (1 - correlacao);
                somador = 0;
                media1 = 0;
                media2 = 0;
                somatoriodesv1 = 0;
                somatoriodesvquad1 = 0;
                somatoriodesv2 = 0;
                somatoriodesvquad2 = 0;
                variancia1 = 0;
                variancia2 = 0;
                desvpad1 = 0;
                desvpad2 = 0;
                correlacao = 0;
            }

        }
    }

  
}
