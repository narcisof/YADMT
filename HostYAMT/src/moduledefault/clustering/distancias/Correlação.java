 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import java.util.ArrayList;
import moduledefault.clustering.kmeans.Centroide;
import moduledefault.clustering.uteis.Base;
import moduledefault.clustering.uteis.Padrao;

/**
 *
 * @author Mateus
 */
public class Correlação extends DistanciaPrincipal {

    public Correlação(Base teste) {
        setMatrizDistancias(teste.getDataSet().size());
    }

    public Correlação() {
    }

    public void distancia(Base teste) {
        double somador1 = 0;
        double somador2 = 0;
        double media1 = 0;
        double media2 = 0;
        double somatorio1 = 0;
        double somatorio2 = 0;
        double somatorio3 = 0;
        double raiz;
        double correlacao = 0;

        for (int y = 0; y < teste.getDataSet().size(); y++) {
            for (int w = 0; w < teste.getDataSet().size(); w++) {
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somador1 += teste.getDataSet().get(y).getAtributos().get(i);
                }
                media1 = somador1 / (teste.getDataSet().get(0).getAtributos().size() - 1);
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somador2 += teste.getDataSet().get(w).getAtributos().get(i);
                }
                media2 = somador2 / (teste.getDataSet().get(0).getAtributos().size() - 1);
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio1 += (teste.getDataSet().get(y).getAtributos().get(i) - media1) * (teste.getDataSet().get(w).getAtributos().get(i) - media2);
                }
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio2 += Math.pow((teste.getDataSet().get(y).getAtributos().get(i) - media1), 2);
                }
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio3 += Math.pow((teste.getDataSet().get(w).getAtributos().get(i) - media2), 2);
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
    }

    public static float[][] distanciaKmeans(int linhas, int k, double[][] matriz, ArrayList<Centroide> centroide) {
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
    }

    public void distanciaGrupos(Base teste) {
        double somador1 = 0;
        double somador2 = 0;
        double media1 = 0;
        double media2 = 0;
        double somatorio1 = 0;
        double somatorio2 = 0;
        double somatorio3 = 0;
        double raiz;
        double correlacao = 0;


        for (int y = 0; y < teste.getDataSet().size(); y++) {
            for (int w = 0; w < teste.getDataSet().size(); w++) {
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somador1 += teste.getDataSet().get(y).getAtributos().get(i);
                }
                media1 = somador1 / (teste.getDataSet().get(0).getAtributos().size() - 1);
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somador2 += teste.getDataSet().get(w).getAtributos().get(i);
                }
                media2 = somador2 / (teste.getDataSet().get(0).getAtributos().size() - 1);
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio1 += (teste.getDataSet().get(y).getAtributos().get(i) - media1) * (teste.getDataSet().get(w).getAtributos().get(i) - media2);
                }
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio2 += Math.pow((teste.getDataSet().get(y).getAtributos().get(i) - media1), 2);
                }
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio3 += Math.pow((teste.getDataSet().get(w).getAtributos().get(i) - media2), 2);
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

//        for (int i = 0; i < teste.getDataSet().size(); i++) {
//            for (int j = 0; j < teste.getDataSet().size(); j++) {
//                System.out.print(matrizDistancias[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public void trasnpoe(Base base) {
        if (base != null) {
            double[][] resultado = new double[base.getDataSet().get(0).getAtributos().size()][base.getDataSet().size()];
            double[][] matriz = new double[base.getDataSet().size()][base.getDataSet().get(0).getAtributos().size()];

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = base.getDataSet().get(i).getAtributos().get(j);
                }
            }
            for (int i = 0; i < resultado.length; i++) {
                for (int j = 0; j < resultado[0].length; j++) {
                    resultado[i][j] = matriz[j][i];
                }
            }
            Base auxBase = base.copy();
            auxBase.setDataSet();
            int grupo = 0;
            for (int i = 0; i < resultado.length; i++) {
                Padrao p = new Padrao();
                p.setNumero(grupo);
                ++grupo;
                for (int j = 0; j < resultado[0].length; j++) {
                    p.addAtributos(resultado[i][j]);

                }
//            p.setClasse(Base.getOutput()[i].toString());
                auxBase.addDataSet(p);
            }
            setMatrizDistancias(auxBase.getDataSet().size());
            distanciaGrupos(auxBase);
        }
    }
}
