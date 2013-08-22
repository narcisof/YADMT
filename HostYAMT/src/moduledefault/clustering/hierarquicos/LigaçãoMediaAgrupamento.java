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
import moduledefault.clustering.uteis.Base;

/**
 *
 * @author Mateus
 */
public class LigaçãoMediaAgrupamento {

    int[][] m;// = new int[matriz.length][matriz.length];
    int linhas;
    Base mdados;
    int numpad, numgrupo = 1;
    int[][] mpos;
    int[][] mpos2;
    int q = 1;
    double[][] matrizDistancia;
    int[][] mdend;

    public LigaçãoMediaAgrupamento(int[][] matriz, Base matrizdados, int opcaoDistancia) {
        linhas = matriz.length;
        m = new int[matriz.length][matriz.length];
        m = matriz;
        mdados = matrizdados;
        numpad = mdados.getAtributos().size()-1;
        mpos = new int[2][numpad];
        mpos2 = new int[2][numpad];
        setMatrizDistancia(opcaoDistancia, matrizdados);
    }

    public void inicio() {
        liga_media(m);
    }

    int[][] get_mpos() {
        return mpos2;

    }

    void liga_media(int[][] m) {


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
        double min = 1000000, d = 0;
        int pad1 = 0, pad2 = 0;
        int[] parada = new int[numpad];
        int cont = 0, para = 0;
        q = 1;

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

            int n1 = 0, n2 = 0;

            //distancia média entre um padrão e os padrões de um mesmo grupo
            int grupo = 1;
            int grupoaux = 0;
            double dmin = 1000000;
            boolean controle1 = false, controle2 = false;
            int g1 = 0, g2 = 0;

            if (q > 1) {

                while (grupo <= numpad) {
                    for (int i = 0; i < numpad; i++) {
                        if (mdend[q - 1][i] == grupo) {
                            controle1 = true;
                        }
                    }
                    if (controle1 == true) {
                        grupoaux = grupo + 1;
                        while (grupoaux <= numpad) {
                            d = 0;
                            for (int i = 0; i < numpad; i++) {
                                if (mdend[q - 1][i] == grupoaux) {
                                    controle2 = true;
                                }
                            }
                            if (controle2 == true) {
                                for (int i = 0; i < numpad; i++) {
                                    if (mdend[q - 1][i] == grupo) //conta os padroes do grupo 1
                                    {
                                        n1++;
                                    }
                                    if (mdend[q - 1][i] == grupoaux) //conta os padroes do grupo 2
                                    {
                                        n2++;
                                    }
                                }
                                int[] grupo1 = new int[n1];
                                int[] grupo2 = new int[n2];
                                int cnt = 0;
                                for (int i = 0; i < numpad; i++) {//salva no vetor os padroes do grupo 1
                                    if (mdend[q - 1][i] == grupo) {
                                        grupo1[cnt] = mdend[q - 2][i];
                                        ++cnt;
                                    }
                                }
                                cnt = 0;
                                for (int i = 0; i < numpad; i++) {//salva no vetor os padroes do grupo 2
                                    if (mdend[q - 1][i] == grupoaux) {
                                        grupo2[cnt] = mdend[q - 2][i];
                                        ++cnt;
                                    }
                                }
                                for (int i = 0; i < n1; i++) { //faz a soma das distancias de todos do grupo 1 para grupo 2
                                    for (int j = 0; j < n2; j++) {
                                        int auxgrupo1 = grupo1[i] - 1;
                                        int auxgrupo2 = grupo2[j] - 1;
                                        d += matrizDistancia[auxgrupo1][auxgrupo2];
                                    }
                                }
                                d = d / (n1 * n2);//calcula a media 

                                if ((d < dmin) && (d > 0)) {// a menor distancia salva os grupos para agrupar
                                    g1 = grupo;
                                    g2 = grupoaux;
                                    dmin = d;
                                }
                                n1 = 0;
                                n2 = 0;

                            }
                            ++grupoaux;
                            controle2 = false;
                        }
                    }
                    controle1 = false;
                    ++grupo;
                }
            }

            ///////////////
            for (int i = 0; i < numpad; i++) {
                if ((mdend[q - 1][i] == g2)) {
                    mdend[q][i] = g1;

                } else {
                    mdend[q][i] = mdend[q - 1][i];
                }
            }
            ////////////////////
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
            //
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
                    } else {
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

    public int[][] getMdend() {
        return mdend;
    }

    public void setMdend(int[][] mdend) {
        this.mdend = mdend;
    }
}
