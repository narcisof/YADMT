/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.hierarquicos;


import java.io.IOException;
import moduledefault.clustering.aco.ACOClustering;
import moduledefault.clustering.distancias.CityBlock;
import moduledefault.clustering.distancias.Correlação;
import moduledefault.clustering.distancias.Cosseno;
import moduledefault.clustering.distancias.DistanciaEuclidiana;
import moduledefault.clustering.distancias.Mahalanobis;
import moduledefault.clustering.uteis.MatrizDados;

/**
 *
 * @author Mateus
 */
public class LigaçãoSimplesAgrupamento {

    int[][] m;// = new int[matriz.length][matriz.length];
    int linhas;
    MatrizDados mdados;
    int numpad, numgrupo = 1;
    int[][] mpos;
    int[][] mpos2;
    ACOClustering x;
    StringBuffer string3;
    double [][] matrizDistancia;
    LigaçãoSimplesAgrupamento(int[][] matriz, MatrizDados matrizdados, ACOClustering x_,int opcaoDistancia) throws IOException {
        string3 = new StringBuffer();
        x = x_;
        linhas = matriz.length;
        m = new int[matriz.length][matriz.length];
        m = matriz;
        mdados = matrizdados;
        numpad = mdados.getLinhas();
        mpos = new int[2][numpad];
        mpos2 = new int[2][numpad];
                setMatrizDistancia(opcaoDistancia, matrizdados);

    }

    void inicio() {
        liga_simples(m);
    }

    int get_contgrupos() {
        return numgrupo;
    }

    int[][] get_mpos() {
        return mpos2;
    }

    void liga_simples(int[][] m) {


        char ch;
        int z = 0;
        //VERIFICA NUMERO DE GRUPOS
        z = (int) mdados.getMatriz_dados()[0][0];
        for (int i = 1; i < mdados.getLinhas(); i++) {
            if (mdados.getMatriz_dados()[i][0] != z) {
                numgrupo++;
            }
            z = (int) mdados.getMatriz_dados()[i][0];
        }
        int[][] mdend = new int[numpad][1000];

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
                                //printf("\n%f - %f\n",distancia[k][j],distancia[k][i]);
                                if (matrizDistancia[k][j] < matrizDistancia[k][i]) {
                                    d = matrizDistancia[k][j];
                                } else {
                                    d = matrizDistancia[k][i];
                                }
                                //printf("\n%f\n",d);
                                //system("pause");
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
    private void setMatrizDistancia(int opcaoDistancia, MatrizDados teste) throws IOException {
        if (opcaoDistancia == 1) {
            DistanciaEuclidiana distância = new DistanciaEuclidiana(teste);
            distância.distancia(teste);
            matrizDistancia = distância.getMatrizDistancias();
        } else {
            if (opcaoDistancia == 2) {
                Cosseno distância = new Cosseno(teste);
                distância.distancia(teste);
                matrizDistancia = distância.getMatrizDistancias();
            } else {
                if (opcaoDistancia == 3) {
                    Correlação distância = new Correlação(teste);
                    distância.distancia(teste);
                    matrizDistancia = distância.getMatrizDistancias();
                } else {
                    if (opcaoDistancia == 4) {
                        Mahalanobis distância = new Mahalanobis(teste);
                        distância.distancia(teste);
                        matrizDistancia = distância.getMatrizDistancias();
                    }
                     else {
                        if (opcaoDistancia == 5) {
                            CityBlock distancia = new CityBlock(teste);
                            distancia.distancia(teste);
                            matrizDistancia = distancia.getMatrizDistancias();
                        }
                    }
                }

            }
        }
    }
}
