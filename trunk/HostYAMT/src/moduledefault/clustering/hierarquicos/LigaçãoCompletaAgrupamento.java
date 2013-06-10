/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.hierarquicos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import moduledefault.clustering.aco.ACOClustering;
import moduledefault.clustering.distancias.CityBlock;
import moduledefault.clustering.distancias.Correlação;
import moduledefault.clustering.distancias.Cosseno;
import moduledefault.clustering.distancias.DistanciaEuclidiana;
import moduledefault.clustering.distancias.Mahalanobis;
import moduledefault.clustering.uteis.MatrizDados;
import view.jpanel.JPanelClustering;

/**
 *
 * @author Mateus
 */
public class LigaçãoCompletaAgrupamento {

    int[][] m;// = new int[matriz.length][matriz.length];
    int linhas;
    MatrizDados mdados;
    int numpad, numgrupo = 1;
    int[][] mpos;
    int[][] mpos2;
    int q = 1;
    ACOClustering x;
    StringBuffer string3;
    double[][] matrizDistancia;
    String nomeArquivoEntrada;
    MatrizDados teste;
    int[][] mdend;

    public LigaçãoCompletaAgrupamento(int[][] matriz, MatrizDados matrizdados, ACOClustering x_, int opcaoDistancia) throws IOException {
        x = x_;
        string3 = new StringBuffer();
        linhas = matriz.length;
        m = new int[matriz.length][matriz.length];
        m = matriz;
        mdados = matrizdados;
        numpad = mdados.getLinhas();
        mpos = new int[2][numpad];
        mpos2 = new int[2][numpad];
        setMatrizDistancia(opcaoDistancia, matrizdados);
    }

    public LigaçãoCompletaAgrupamento(int[][] matriz, MatrizDados matrizdados, int opcaoDistancia) throws IOException {

        string3 = new StringBuffer();
        linhas = matriz.length;
        m = new int[matriz.length][matriz.length];
        m = matriz;
        mdados = matrizdados;
        numpad = mdados.getLinhas();
        mpos = new int[2][numpad];
        mpos2 = new int[2][numpad];
        setMatrizDistancia(opcaoDistancia, matrizdados);
    }

    public LigaçãoCompletaAgrupamento(int opcaoDistancia, String nomeArquivo) throws IOException {
        this.nomeArquivoEntrada = nomeArquivo;
        string3 = new StringBuffer();
        teste = new MatrizDados();
        teste.setDimensão_matriz();
        m = new int[teste.getDimensão_matriz()][teste.getDimensão_matriz()];
        pmat();
        linhas = teste.getDimensão_matriz();
        mdados = teste;
        numpad = mdados.getLinhas();
        mpos = new int[2][numpad];
        mpos2 = new int[2][numpad];
        setMatrizDistancia(opcaoDistancia, teste);
    }

    void pmat() {
        int i = 0, j = 0, x = 0, y;
        Random random = new Random();
        for (i = 0; i < teste.getDimensão_matriz(); i++) {
            for (j = 0; j < teste.getDimensão_matriz(); j++) {
                m[i][j] = 0;
            }
        }
        for (y = 1; y <= teste.getLinhas(); y++) {//coloca os padroes sem repetir na grade
            do {
                i = random.nextInt(teste.getDimensão_matriz());
                j = random.nextInt(teste.getDimensão_matriz());
            } while (m[i][j] != 0);
            x++;
            if (m[i][j] == 0) {
                m[i][j] = x;
            }
        }
    }

    public void inicio() throws IOException {
        System.out.println("Chamou");
        liga_completa(m);
        System.out.println("Terminou");

    }

    public StringBuffer getString() {
        return string3;
    }

    int get_contgrupos() {
        return numgrupo;
    }

    int[][] get_mpos() {
        return mpos2;

    }

    void liga_completa(int[][] m) throws IOException {


        char ch;
        int z = 0, grupo = 0;
        //VERIFICA NUMERO DE GRUPOS
        z = (int) mdados.getMatriz_dados()[0][0];
        for (int i = 1; i < mdados.getLinhas(); i++) {
            if (mdados.getMatriz_dados()[i][0] != z) {
                numgrupo++;
            }
            z = (int) mdados.getMatriz_dados()[i][0];
        }
        // System.out.println("NUMERO DE GRUPOS = "+numgrupo);
        mdend = new int[numpad][numpad];

//        double[][] distancia = new double[numpad][numpad];
        //faço inicialização mdend
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
        int pad1 = 0, pad2 = 0;
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
                                if (matrizDistancia[k][j] > matrizDistancia[k][i]) {
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
//                                            System.out.println("Pad1 = "+pad1);
//                                            System.out.println("Pad2 = "+pad2);
//                        System.out.println("Iteração q = "+q);


                    }
                }
            }
            for (int i = 0; i < numpad; i++) {
                if ((mdend[q - 1][i] == pad1) || (mdend[q - 1][i] == pad2)) {
                    mdend[q][i] = mdend[q - 1][pad1 - 1];
//                    System.out.println("Q = "+q);
//                                            System.out.println("Pad1 = "+pad1);
//                        System.out.println("Pad2 = "+pad2);
//                    System.out.println("1  "+mdend[q][i]);
//                                    System.in.read();

                } else {
                    mdend[q][i] = mdend[q - 1][i];
//                    System.out.println("Q = "+q);
//                                            System.out.println("Pad1 = "+pad1);
//                        System.out.println("Pad2 = "+pad2);

//                    System.out.println("2 "+mdend[q][i]);

                }
            }
//                 System.out.println("Pad1 = "+pad1);
//                        System.out.println("Pad2 = "+pad2);
//                                                System.in.read();

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
//        x.getString().append("\nLIGACAO COMPLETA\n");
//        x.getString2().append("\nLIGACAO COMPLETA\n");
//        string3.append("\nLIGACAO COMPLETA\n");
//        x.getString().append("\nPADRAO = GRUPO\n");
//        x.getString2().append("\nPADRAO = GRUPO\n");
//        string3.append("\nPADRAO = GRUPO\n");
//        for (int j = 0; j < numpad; j++) {
//            x.getString().append(j + 1).append(" = ").append(mpos2[1][j]).append("\n");
//            x.getString2().append(j + 1).append(" = ").append(mpos2[1][j]).append("\n");
//            string3.append(j + 1).append(" = ").append(mpos2[1][j]).append("\n");
//        }

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


        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < numpad; j++) {
                System.out.print(mdend[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int[][] getMdend() {
        return mdend;
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

    public int getNumpad() {
        return numpad;
    }

    public int getNumgrupo() {
        return numgrupo;
    }
}
