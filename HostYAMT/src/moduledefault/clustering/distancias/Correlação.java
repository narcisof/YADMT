 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import java.util.ArrayList;
import moduledefault.clustering.kmeans.Centroide;
import moduledefault.clustering.uteis.MatrizDados;

/**
 *
 * @author Mateus
 */
public class Correlação extends DistanciaPrincipal {

    public Correlação(MatrizDados teste) {
        setMatrizDistancias(teste.getLinhas());
    }

    public void distancia(MatrizDados teste) {
        double somador1 = 0;
        double somador2 = 0;
        double media1 = 0;
        double media2 = 0;
        double somatorio1 = 0;
        double somatorio2 = 0;
        double somatorio3 = 0;
        double raiz;
        double correlacao = 0;

        System.out.println("lingas " + teste.getLinhas());
        System.out.println("colu " + teste.getColunas());

        for (int y = 0; y < teste.getLinhas(); y++) {
            for (int w = 0; w < teste.getLinhas(); w++) {
                for (int i = 1; i < teste.getColunas(); i++) {
                    somador1 += teste.getMatriz_dados()[y][i];
                }
                media1 = somador1 / (teste.getColunas() - 1);
                for (int i = 1; i < teste.getColunas(); i++) {
                    somador2 += teste.getMatriz_dados()[w][i];
                }
                media2 = somador2 / (teste.getColunas() - 1);
                for (int i = 1; i < teste.getColunas(); i++) {
                    somatorio1 += (teste.getMatriz_dados()[y][i] - media1) * (teste.getMatriz_dados()[w][i] - media2);
                }
                for (int i = 1; i < teste.getColunas(); i++) {
                    somatorio2 += Math.pow((teste.getMatriz_dados()[y][i] - media1), 2);
                }
                for (int i = 1; i < teste.getColunas(); i++) {
                    somatorio3 += Math.pow((teste.getMatriz_dados()[w][i] - media2), 2);
                }
                raiz = Math.sqrt((somatorio2 * somatorio3));
                correlacao = somatorio1 / raiz;
                matrizDistancias[y][w] = 1 - correlacao;
                somador1 = 0;
                somador2 = 0;
                somatorio1 = 0;
                somatorio2 = 0;
                somatorio3 = 0;
                media1 = 0;
                media2 = 0;
                raiz = 0;
                correlacao = 0;
            }

        }
        padronizacaDistancias(matrizDistancias);
//        System.out.println("Matriz Correlacao");
//        for (int i = 0; i < matrizDistancias.length; i++) {
//            for (int j = 0; j < matrizDistancias.length; j++) {
//                System.out.print(matrizDistancias[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static float[][] distanciaKmeans(int linhas, int k, float[][] matriz, ArrayList<Centroide> centroide) {
        double somador1 = 0;
        double somador2 = 0;
        double media1 = 0;
        double media2 = 0;
        double somatorio1 = 0;
        double somatorio2 = 0;
        double somatorio3 = 0;
        double raiz;
        double correlacao;
        float[][] resultado = new float[linhas][k];
        for (int y = 0;
                y < linhas;
                y++) {
            for (int w = 0; w < k; w++) {
                for (int i = 0; i < k; i++) {
                    somador1 += matriz[y][i];
                }
                media1 = somador1 / (k);
                for (int i = 0; i < k; i++) {
                    somador2 += centroide.get(w).getAtributos().get(i);
                }
                media2 = somador2 / (k);
                for (int i = 0; i < k; i++) {
                    somatorio1 += (matriz[y][i] - media1) * (centroide.get(w).getAtributos().get(i) - media2);
                }
                for (int i = 0; i < k; i++) {
                    somatorio2 += Math.pow((matriz[y][i] - media1), 2);
                }
                for (int i = 0; i < k; i++) {
                    somatorio3 += Math.pow((centroide.get(w).getAtributos().get(i) - media2), 2);
                }
                raiz = Math.sqrt((somatorio2 * somatorio3));
                correlacao = somatorio1 / raiz;
                resultado[y][w] = (float) correlacao;
                somador1 = 0;
                somador2 = 0;
                somatorio1 = 0;
                somatorio2 = 0;
                somatorio3 = 0;
                media1 = 0;
                media2 = 0;
                raiz = 0;
                correlacao = 0;
            }

        }
        return resultado;
//        System.out.println("Matriz Correlacao");
//        for (int i = 0; i < matrizDistancias.length; i++) {
//            for (int j = 0; j < matrizDistancias.length; j++) {
//                System.out.print(matrizDistancias[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public void distanciaGrupos(MatrizDados teste) {
        double somador1 = 0;
        double somador2 = 0;
        double media1 = 0;
        double media2 = 0;
        double somatorio1 = 0;
        double somatorio2 = 0;
        double somatorio3 = 0;
        double raiz;
        double correlacao = 0;

        System.out.println("lingas " + teste.getLinhas());
        System.out.println("colu " + teste.getColunas());

        for (int y = 0; y < teste.getLinhas(); y++) {
            for (int w = 0; w < teste.getLinhas(); w++) {
                for (int i = 1; i < teste.getColunas(); i++) {
                    somador1 += teste.getMatriz_dados()[y][i];
                }
                media1 = somador1 / (teste.getColunas() - 1);
                for (int i = 1; i < teste.getColunas(); i++) {
                    somador2 += teste.getMatriz_dados()[w][i];
                }
                media2 = somador2 / (teste.getColunas() - 1);
                for (int i = 1; i < teste.getColunas(); i++) {
                    somatorio1 += (teste.getMatriz_dados()[y][i] - media1) * (teste.getMatriz_dados()[w][i] - media2);
                }
                for (int i = 1; i < teste.getColunas(); i++) {
                    somatorio2 += Math.pow((teste.getMatriz_dados()[y][i] - media1), 2);
                }
                for (int i = 1; i < teste.getColunas(); i++) {
                    somatorio3 += Math.pow((teste.getMatriz_dados()[w][i] - media2), 2);
                }
                raiz = Math.sqrt((somatorio2 * somatorio3));
                correlacao = somatorio1 / raiz;
                matrizDistancias[y][w] = correlacao;
                somador1 = 0;
                somador2 = 0;
                somatorio1 = 0;
                somatorio2 = 0;
                somatorio3 = 0;
                media1 = 0;
                media2 = 0;
                raiz = 0;
                correlacao = 0;
            }

        }
//        padronizacaDistancias(matrizDistancias);
        System.out.println("Matriz Correlacao");
        for (int i = 0; i < matrizDistancias.length; i++) {
            for (int j = 0; j < matrizDistancias.length; j++) {
                System.out.print(matrizDistancias[i][j] + " ");
            }
            System.out.println();
        }
    }
}
