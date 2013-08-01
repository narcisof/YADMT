/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.uteis;

import java.io.IOException;
import java.util.Scanner;
import moduledefault.clustering.aco.ACOClustering;

/**
 *
 * @author Mateus
 */
public class Índices {

    int op = 1;
    int pos = 0;
    int busca = 0;
    int contgrupo = 0;
    int sizepos;
    Scanner in = new Scanner(System.in);
    int[][] m;// = new int[matriz.length][matriz.length];
    int[][] maux;// = new int[matriz.length][matriz.length];
    int linhas;
    int[][] mpos;
    MatrizDados mpadrao1;
    ACOClustering x;
    int numpad = 0;
    int[][] mconfusao;
    float vtotal = 0, idunn = 999999999, ffinal = 0;
    float r = 0;
    float porcentagem = 0;
    StringBuffer string3;

    public Índices(int[][] matriz, MatrizDados mpadrao, int[][] mpos_par, int contgrupo_par, int pos_par, ACOClustering x_) {
        x = x_;
        string3 = new StringBuffer();
        mpadrao1 = mpadrao;
        linhas = matriz.length;
        m = new int[matriz.length][matriz.length];
        maux = new int[matriz.length][matriz.length];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < linhas; j++) {
                m[i][j] = matriz[i][j];
            }
        }
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < linhas; j++) {
                maux[i][j] = m[i][j];
            }
        }

        sizepos = (linhas * linhas) * 2;

        mpos = new int[2][sizepos];
        mpos = mpos_par;
        pos = pos_par;
        contgrupo = contgrupo_par;


    }

    public void inicio() throws IOException {

        variancia(mpos);
        dunn(mpos);
        medidaf(mpos);
    }

    void variancia(int[][] mpos) {
        float centro = 0, qdesvio = 0, sqdesvio = 0, v = 0, somaqdesvio = 0;
        int qpadrao = 0, somapadrao = 0;

//        x.string.append("\nINDICES:\n");
//        x.string2.append("\nINDICES:\n");
//        string3.append("\nINDICES:\n");
//        x.string.append("\nVARIANCIA:\n");
//        x.string2.append("\nVARIANCIA:\n");
//        string3.append("\nVARIANCIA:\n");

        for (int i = 1; i <= contgrupo; i++) {
//            x.string.append("\nGRUPO ").append(i);

            //            x.string2.append("\nGRUPO ").append(i);
//            string3.append("\nGRUPO ").append(i);

            for (int j = 0; j < pos; j++) {
                if (mpos[1][j] == i) {
                    ++qpadrao;//conta quantos padroes existem no grupo
                    ++somapadrao;//somatorio de todos os padroes da matriz 
                    centro += mpos[0][j];//faz a soma dos padroes 
                }
            }
            centro = centro / qpadrao;//calcula o centroide/média
//            x.string.append("\nQuantidade de Padroes = ").append(qpadrao);
//            x.string.append("\nCentroide = ").append(centro);
//            x.string2.append("\nQuantidade de Padroes = ").append(qpadrao);
//            x.string2.append("\nCentroide = ").append(centro);
//            string3.append("\nQuantidade de Padroes = ").append(qpadrao);
//            string3.append("\nCentroide = ").append(centro);

            for (int j = 0; j < pos; j++) {
                if (mpos[1][j] == i) {
                    qdesvio = mpos[0][j] - centro;
                    qdesvio = (float) Math.pow(qdesvio, 2);
                    sqdesvio += qdesvio;
                    qdesvio = 0;
                }
            }
            somaqdesvio += sqdesvio;//somatorios dos quadrados dos desvios entre todos os padroes de todos os grupos
            v = sqdesvio / centro;
//            x.string.append("\nVariancia = ").append(v).append("\n");
//            x.string2.append("\nVariancia = ").append(v).append("\n");
//            string3.append("\nVariancia = ").append(v).append("\n");


            qpadrao = 0;
            centro = 0;
            qdesvio = 0;
            sqdesvio = 0;
            v = 0;
            //system("pause");
        }
        ////////////Fazer a variancia para todos os grupos
        vtotal = somaqdesvio / somapadrao;//variancia total, de todos os grupos da matriz 
//        x.string.append("\nVARIANCIA TOTAL = ").append(vtotal);
//        x.string2.append("\nVARIANCIA TOTAL = ").append(vtotal);
//        string3.append("\nVARIANCIA TOTAL = ").append(vtotal);

        //system("pause");
    }

    void dunn(int[][] mpos) {

        float centro1 = 0, qdesvio1 = 0, diam1 = 0;
        float centro2 = 0, qdesvio2 = 0, diam2 = 0;
        float mdistancia = 0, fdistancia = 0, diamfinal = 0;
        int qpadrao1 = 0, qpadrao2 = 0;
//        x.string.append("\n-----------------------------------------------------------");
//        x.string2.append("\n-----------------------------------------------------------");
//        string3.append("\n-----------------------------------------------------------");
//
//        x.string.append("\nINDICE DUNN\n");
//        x.string2.append("\nINDICE DUNN\n");
//        string3.append("\nINDICE DUNN\n");

        for (int i = 1; i < contgrupo; i++) {
            ///////////Primeiro grupo
            for (int j = 0; j < pos; j++) {
                if (mpos[1][j] == i) {
                    ++qpadrao1;//conta quantos padroes existem no grupo
                    centro1 += mpos[0][j];//faz a soma dos padroes 
                }
            }
            centro1 = centro1 / qpadrao1;//calcula o centroide/média
            for (int j = 0; j < pos; j++) {
                if (mpos[1][j] == i) {
                    qdesvio1 = mpos[0][j] - centro1;
                    qdesvio1 = (float) Math.pow(qdesvio1, 2);
                    if (qdesvio1 > diam1) {
                        diam1 = qdesvio1;
                    }
                    qdesvio1 = 0;

                }
            }
            ///////////Segundo grupo
            for (int x = i + 1; x <= contgrupo; x++) {
                for (int j = 0; j < pos; j++) {
                    if (mpos[1][j] == x) {
                        ++qpadrao2;//conta quantos padroes existem no grupo
                        centro2 += mpos[0][j];//faz a soma dos padroes 
                    }
                }
                centro2 = centro2 / qpadrao2;//calcula o centroide/média
                for (int j = 0; j < pos; j++) {
                    if (mpos[1][j] == x) {
                        qdesvio2 = mpos[0][j] - centro2;
                        qdesvio2 = (float) Math.pow(qdesvio2, 2);
                        if (qdesvio2 > diam2) {
                            diam2 = qdesvio2;
                        }
                        qdesvio2 = 0;
                    }
                }
                ////Distancia entre as médias
                mdistancia = (float) Math.sqrt((Math.pow(centro1, 2)) - (Math.pow(centro2, 2)));
                if (diam1 >= diam2) {
                    diamfinal = diam1;
                } else {
                    diamfinal = diam2;
                }
                fdistancia = mdistancia / (diamfinal);///arrumar pegar o maior diam entre todos os grupos
                if (fdistancia < idunn) {
                    idunn = fdistancia;
                }
                ////Zera as variaveis para prox iteração
                centro2 = 0;
                qdesvio2 = 0;
                diam2 = 0;
                qpadrao2 = 0;
                mdistancia = 0;
                fdistancia = 0;
            }
            ////Zera as variaveis para prox iteração
            centro1 = 0;
            qdesvio1 = 0;
            diam1 = 0;
            qpadrao1 = 0;
        }
//        x.string.append("\nIndice = ").append(idunn);
//        x.string2.append("\nIndice = ").append(idunn);
//        string3.append("\nIndice = ").append(idunn);

    }

    void medidaf(int[][] mpos) throws IOException {



        int[] classepad = new int[mpadrao1.linhas];
        int z = 0;
        for (int i = 0; i < mpadrao1.linhas; i++) {
            classepad[i] = 0;
        }
        int col2 = 0, col1 = 0;

        col1 = mpadrao1.colunas;

        for (int i = 0; i < mpadrao1.linhas; i++) {
            for (int j = 0; j < col1; j++) {
                if (j == 0) {
                    classepad[i] = (int) mpadrao1.matriz_dados[i][j];
                }
            }
        }
        //FIM LEITURA ARQUIVO
        for (int i = 0; i < mpadrao1.linhas; i++) {
            if (classepad[i] > numpad) {
                numpad = classepad[i];
            }
        }
        //declara matriz confusão
        mconfusao = new int[numpad][contgrupo];
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < contgrupo; j++) {
                mconfusao[i][j] = 0;
            }
        }
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < contgrupo; j++) {
                for (int a = 0; a < mpadrao1.linhas; a++) {
                    if (classepad[a] == i + 1) {
                        for (int b = 0; b < pos; b++) {
                            if ((mpos[0][b] == a + 1) && (mpos[1][b] == j + 1)) {
                                ++mconfusao[i][j];
                            }
                        }
                    }
                }
            }
        }
        //////////////AJUSTA NOME DOS GRUPOS
        int posi = 0, posj = 0, padmaior = 0, conta = 0, q = 0;
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < contgrupo; j++) {
                if (i != 0) {
                    q = 1;
                } else {
                    q = 0;
                }
                if ((mconfusao[i][j] > padmaior) && (mconfusao[i][j] >= mconfusao[i - q][j])) {
                    padmaior = mconfusao[i][j];
                    posi = i + 1;
                    posj = j + 1;
                }
                if (posi > contgrupo) {
                    posi = contgrupo;
                }
            }
            for (int d = 0; d < pos; d++) {
                if (mpos[1][d] == posi) {
                    mpos[1][d] = posj;
                } else if (mpos[1][d] == posj) {
                    mpos[1][d] = posi;
                }
            }
            for (int e = 0; e < numpad; e++) {
                for (int f = 0; f < contgrupo; f++) {
                    mconfusao[e][f] = 0;
                }
            }
            for (int e = 0; e < numpad; e++) {
                for (int f = 0; f < contgrupo; f++) {
                    for (int a = 0; a < mpadrao1.linhas; a++) {
                        if (classepad[a] == e + 1) {
                            for (int b = 0; b < pos; b++) {
                                if ((mpos[0][b] == a + 1) && (mpos[1][b] == f + 1)) {
                                    ++mconfusao[e][f];
                                }
                            }
                        }
                    }
                }
            }
            ++conta;
            padmaior = 0;
        }
//        x.string.append("\n-----------------------------------------------------------");
//        x.string2.append("\n-----------------------------------------------------------");
//        string3.append("\n-----------------------------------------------------------");
//        x.string.append("\nMATRIZ CONFUSAO\n\n");
//        x.string2.append("\nMATRIZ CONFUSAO\n\n");
//        string3.append("\nMATRIZ CONFUSAO\n\n");


//        for (int i = 0; i < numpad; i++) {
//            for (int j = 0; j < contgrupo; j++) {
//                x.string.append(mconfusao[i][j]).append(" ");
//                x.string2.append(mconfusao[i][j]).append("; ");
//                string3.append(mconfusao[i][j]).append("; ");
//
//            }
//            x.string.append("\n");
//            x.string2.append("\n");
//            string3.append("\n");
//
//        }
        int somaacertos = 0;
        porcentagem = 0;
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < contgrupo; j++) {
                if (i == j) {
                    somaacertos += mconfusao[i][j];
                }
            }
        }

        porcentagem = (somaacertos * 100) / x.getArquivo().getLinhas();


        //
//        x.string.append("\nPorcentagem de Acerto; ").append(porcentagem).append("\n\n");
//        x.string2.append("\nPorcentagem de Acerto; ").append(porcentagem).append("\n\n");
//        string3.append("\nPorcentagem de Acerto; ").append(porcentagem).append("\n\n");


//	///////////////////////// calculos
        float[][] p = new float[numpad][contgrupo];
        float[][] r = new float[numpad][contgrupo];
        float[][] f = new float[numpad][contgrupo];
        float[] gerado = new float[contgrupo];
        float[] desejados = new float[numpad];
        float b = 1, somapad = 0;

        for (int j = 0; j < contgrupo; j++) {
            gerado[j] = 0;
        }
        for (int i = 0; i < numpad; i++) {
            desejados[i] = 0;
        }
        for (int j = 0; j < contgrupo; j++) {
            for (int i = 0; i < numpad; i++) {
                gerado[j] = gerado[j] + mconfusao[i][j];
            }
        }
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < contgrupo; j++) {
                desejados[i] = desejados[i] + mconfusao[i][j];
            }
        }
        for (int i = 0; i < numpad; i++) {
            somapad = somapad + desejados[i];
        }
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < contgrupo; j++) {
                p[i][j] = 0;
                r[i][j] = 0;
                f[i][j] = 0;
            }
        }
        ///CALCULO P
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < contgrupo; j++) {
                p[i][j] = mconfusao[i][j] / gerado[j];
            }
        }
        ///CALCULO R
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < contgrupo; j++) {
                r[i][j] = mconfusao[i][j] / desejados[i];
            }
        }
        ///CALCULO F
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < contgrupo; j++) {
                f[i][j] = (((b * b) + 1) * p[i][j] * r[i][j]) / ((b * b) * p[i][j] + r[i][j]);
            }
        }

        float maxj = 0;
        for (int i = 0; i < numpad; i++) {
            for (int j = 0; j < contgrupo; j++) {
                if (f[i][j] > maxj) {
                    maxj = f[i][j];
                }
            }
            ffinal = ffinal + ((desejados[i] / somapad) * maxj);
            maxj = 0;
        }
//        x.string.append("\n-----------------------------------------------------------");
//        x.string.append("\nMEDIDA F \n");
//        x.string.append("\nF = ").append(ffinal);
//        x.string2.append("\n-----------------------------------------------------------");
//        x.string2.append("\nMEDIDA F \n");
//        x.string2.append("\nF = ").append(ffinal);
//        string3.append("\n-----------------------------------------------------------");
//        string3.append("\nMEDIDA F \n");
//        string3.append("\nF = ").append(ffinal);

        indice_aleatorio(mpos, classepad);
    }

    void indice_aleatorio(int[][] mpos, int[] classepad) {
        int[][] newvet = new int[2][mpadrao1.linhas]; //
        float a = 0, b = 0, c = 0, d = 0;


        for (int i = 0; i < mpadrao1.linhas; i++) {
            for (int j = 0; j < pos; j++) {
                if (mpos[0][j] == (i + 1)) {
                    newvet[0][i] = mpos[0][j];
                    newvet[1][i] = mpos[1][j];
                }
            }
        }

        for (int i = 0; i < mpadrao1.linhas; i++) {
            for (int j = 0; j < mpadrao1.linhas; j++) {
                if ((i != j) && (j > i)) {
                    if ((classepad[i] == classepad[j]) && (newvet[1][i] == newvet[1][j])) {
                        ++a;
                    }
                    if ((classepad[i] == classepad[j]) && (newvet[1][i] != newvet[1][j])) {
                        ++b;
                    }
                    if ((classepad[i] != classepad[j]) && (newvet[1][i] == newvet[1][j])) {
                        ++c;
                    }
                    if ((classepad[i] != classepad[j]) && (newvet[1][i] != newvet[1][j])) {
                        ++d;
                    }
                }
            }
        }
        r = (a + d) / (a + b + c + d);
//        x.string.append("\n-----------------------------------------------------------");
//        x.string.append("\nINDICE ALEATORIO\n");
//        x.string.append("\nR = ").append(r);
//        x.string2.append("\n-----------------------------------------------------------");
//        x.string2.append("\nINDICE ALEATORIO\n");
//        x.string2.append("\nR = ").append(r).append("\n");
//        string3.append("\n-----------------------------------------------------------");
//        string3.append("\nINDICE ALEATORIO\n");
//        string3.append("\nR = ").append(r).append("\n");

    }

    public float getFfinal() {
        return ffinal;
    }

    public float getIdunn() {
        return idunn;
    }

    public float getR() {
        return r;
    }

    public float getVtotal() {
        return vtotal;
    }

    public int getContgrupo() {
        return contgrupo;
    }

    public float getPorcentagem() {
        return porcentagem;
    }

    public int getNumpad() {
        return numpad;
    }

    public int[][] getMconfusao() {
        return mconfusao;
    }
}