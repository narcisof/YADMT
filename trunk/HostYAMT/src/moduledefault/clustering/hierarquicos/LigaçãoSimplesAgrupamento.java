/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.hierarquicos;

import moduledefault.clustering.distancias.Chebyshev;
import moduledefault.clustering.distancias.CityBlock;
import moduledefault.clustering.distancias.Correlação;
import moduledefault.clustering.distancias.Cosseno;
import moduledefault.clustering.distancias.DistanciaEuclidiana;
import moduledefault.clustering.distancias.Mahalanobis;
import moduledefault.clustering.uteis.Base;

/**
 *
 * @author Mateus
 */
public class LigaçãoSimplesAgrupamento {

    int[][] m;// = new int[matriz.length][matriz.length];
    int linhas;
    Base mdados;
    int numpad, numgrupo = 1;
    int[][] mpos;
    int[][] mpos2;
    double[][] matrizDistancia;
    int mdend[][];

    public LigaçãoSimplesAgrupamento(int[][] matriz, Base matrizdados, int opcaoDistancia) {
        linhas = matriz.length;
        m = new int[matriz.length][matriz.length];
        m = matriz;
        mdados = matrizdados;
        numpad = mdados.getDataSet().size();
        mpos = new int[2][numpad];
        mpos2 = new int[2][numpad];
        setMatrizDistancia(opcaoDistancia, matrizdados);
    }

    public void inicio() {
        liga_simples(m);
            }

    int[][] get_mpos() {
        return mpos2;
    }

    void liga_simples(int[][] m) {


        char ch;
        int z = 0;
        //VERIFICA NUMERO DE GRUPOS
        
        numgrupo = mdados.getClasses().size();
        mdend = new int[numpad][1000];

//        double[][] distancia = new double[numpad][numpad];

        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < numpad; j++) {
                mdend[i][j] = 0;
            }
        }
        for (int i = 0; i < numpad; i++) {
            mdend[0][i] = i + 1;
        }

        for (int x = 0; x < numpad; x++) {
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < linhas; j++) {
                    if (m[i][j] == x + 1) {
                        mpos[0][x] = i;
                        mpos[1][x] = j;
                    }
                }
            }
        }
        //matriz das distancias
//        for (int i = 0; i < numpad; i++) {
//            for (int j = 0; j < numpad; j++) {
//                distancia[i][j] = (double) Math.sqrt(Math.pow((mpos[0][i] - mpos[0][j]), 2) + Math.pow((mpos[1][i] - mpos[1][j]), 2));
//            }
//        }

        double min = 1000000, d = 0;
        int pad1 = 0, pad2 = 0, q = 1;
        int[] parada = new int[numpad];
        int cont = 0, para = 0;
        /////////////////
        while (para != 1) {
            for (int i = 0; i < numpad; i++) {
                parada[i] = 0;
            }
            cont = 0;
            min = 1000000;
            d = 0;
            pad1 = 0;
            pad2 = 0;
            for (int i = 0; i < numpad; i++) {
                for (int j = i + 1; j < numpad; j++) {
                    if ((mdend[q - 1][i] == mdend[q - 1][j])) {
                        matrizDistancia[i][j] = 0;
                        matrizDistancia[j][i] = 0;
                    }
                }
            }
            //maior distancia entre um padrão e os padrões de um mesmo grupo
            for (int i = 0; i < numpad; i++) {
                for (int j = i + 1; j < numpad; j++) {
                    if ((mdend[q - 1][i] == mdend[q - 1][j])) {
                        for (int k = 0; k < numpad; k++) {
                            if ((k != i) && (k != j)) {
                                if (matrizDistancia[k][j] < matrizDistancia[k][i]) {
                                    d = matrizDistancia[k][j];
                                } else {
                                    d = matrizDistancia[k][i];
                                }
                                matrizDistancia[i][k] = d;
                                matrizDistancia[k][i] = d;
                                matrizDistancia[j][k] = d;
                                matrizDistancia[k][j] = d;
                            }
                        }
                    }
                }
            }
            //menor distancia
            for (int i = 0; i < numpad; i++) {
                for (int j = 0; j < numpad; j++) {
                    if ((matrizDistancia[i][j] < min) && (matrizDistancia[i][j] > 0)) {
                        min = matrizDistancia[i][j];
                        pad1 = i + 1;
                        pad2 = j + 1;

                    }
                }
            }
            for (int i = 0; i < numpad; i++) {
                if ((mdend[q - 1][i] == pad1) || (mdend[q - 1][i] == pad2)) {
                    mdend[q][i] = mdend[q - 1][pad1 - 1];
                } else {
                    mdend[q][i] = mdend[q - 1][i];
                }
            }
            //////
            int aux = 0, aux2 = 0;
            for (int i = 0; i < numpad; i++) {
                aux = mdend[q][i];
                for (int j = 0; j < numpad; j++) {
                    if (aux == parada[j]) {
                        aux2 = 1;
                    }
                }
                if (aux2 == 0) {
                    parada[cont] = aux;
                    ++cont;
                }
                aux2 = 0;
            }
            if (cont == numgrupo) {
                para = 1;
            } else {
                para = 0;
            }
            ++q;
        }


        int count = 1;
        for (int j = 0; j < numpad; j++) {
            mpos2[0][j] = count;
            mpos2[1][j] = mdend[q - 1][j];
            count++;
        }


        count = 1;
        int[] pertence = new int[numgrupo];
        boolean teste = false;
        pertence[0] = mpos2[1][0];
        for (int i = 1; i < numpad; i++) {
            for (int j = 0; j < count; j++) {
                if (mpos2[1][i] == pertence[j]) {
                    teste = false;
                    break;
                } else {
                    teste = true;

                }
            }
            if (teste) {
                pertence[count] = mpos2[1][i];
                count++;
            }
            teste = false;

        }

        cont = 0;
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < numgrupo; j++) {
                if (mpos2[1][i] == pertence[j]) {
                    mpos2[1][i] = j + 1;
                    break;
                }
            }
        }

    }
  private void setMatrizDistancia(int opcaoDistancia, Base teste) {
        if (opcaoDistancia == 5) {
            DistanciaEuclidiana distância = new DistanciaEuclidiana(teste);
            distância.distancia(teste);
            matrizDistancia = distância.getMatrizDistancias();
        } else {
            if (opcaoDistancia == 4) {
                Cosseno distância = new Cosseno(teste);
                distância.distancia(teste);
                matrizDistancia = distância.getMatrizDistancias();
            } else {
                if (opcaoDistancia == 3) {
                    Correlação distância = new Correlação(teste);
                    distância.distancia(teste);
                    matrizDistancia = distância.getMatrizDistancias();
                } else {
                    if (opcaoDistancia == 6) {
                        Mahalanobis distância = new Mahalanobis(teste);
                        distância.distancia(teste);
                        matrizDistancia = distância.getMatrizDistancias();
                    } else {
                        if (opcaoDistancia == 2) {
                            CityBlock distancia = new CityBlock(teste);
                            distancia.distancia(teste);
                            matrizDistancia = distancia.getMatrizDistancias();
                        } else if (opcaoDistancia == 1) {
                            Chebyshev ch = new Chebyshev(teste);
                            ch.distancia(teste);
                            matrizDistancia = ch.getMatrizDistancias();
                        }
                    }
                }

            }
        }
    }

    public int[][] getMdend() {
        return mdend;
    }

    public void setMdend(int[][] mdend) {
        this.mdend = mdend;
    }
}
