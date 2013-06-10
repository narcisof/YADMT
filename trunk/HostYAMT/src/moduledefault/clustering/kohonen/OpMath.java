/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kohonen;

import java.util.List;

/**
 *
 * @author Thiago
 */
public class OpMath {

    public OpMath() {
    }

    public double euclidiana(List<Double> vet1, List<Double> vet2) {
        double result = 0;
        int num = vet1.size();

        for (int i = 0; i < num; i++) {
            result = result + Math.pow(vet2.get(i) - vet1.get(i), 2);
        }
        return Math.sqrt(result);
    }

    public double euclidiana(int i1, int j1, int i2, int j2) {
        return Math.sqrt(Math.pow(i1 - i2, 2) + Math.pow(j1 - j2, 2));
    }

    public double[][] matrizU(int X, int Y, RedeKohonen rede) {

        //Calculo matriz-U segundo Costa, J.A.F, 1999 - Tese Unicamp
        OpMath math = new OpMath();

        double MatrizU[][] = new double[X * 2 - 1][Y * 2 - 1];

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                int x = 1;
                int y = 1;
                if(i == X-1){
                    x = 0;
                }
                if(j == Y-1){
                    y = 0;
                }
                double dx = math.euclidiana(rede.getNeuronio(i, j).getPesos(), rede.getNeuronio(i + x, j).getPesos());
                double dy = math.euclidiana(rede.getNeuronio(i, j).getPesos(), rede.getNeuronio(i, j + y).getPesos());;
                double dxy = (1 / (2 * Math.sqrt(2)))
                        * (math.euclidiana(rede.getNeuronio(i, j).getPesos(), rede.getNeuronio(i + x, j + y).getPesos())
                        + math.euclidiana(rede.getNeuronio(i, j + y).getPesos(), rede.getNeuronio(i + x, j).getPesos()));
                double du = (dx + dy + dxy) / 3;
              
                MatrizU[2 * i + x][2 * j] = dy;
                MatrizU[2 * i][2 * j + y] = dx;
                MatrizU[2 * i + x][2 * j + y] = dxy;
                MatrizU[2 * i][2 * j] = du;

               
            }
        }

 
        return MatrizU;
    }
}
