/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class AvaliacaoAgrupamento {

    public AvaliacaoAgrupamento() {
    }

    public float centroide(Cluster cluster) {
        float centroide = 0;

        for (int i = 0; i < cluster.getGrupo().size(); i++) {
            centroide += cluster.getGrupo().get(i).getNumero(); //soma dos padroes
        }
        centroide = centroide / cluster.getGrupo().size(); //calcula centroide/media

        return centroide;
    }

    public float variancia(ArrayList<Cluster> clusters) {
        float variancia;
        float centro = 0, qdesvio = 0, sqdesvio = 0, somaqdesvio = 0;
        int qpadrao = 0, somapadrao = 0;

        for (int i = 0; i < clusters.size(); i++) {
            qpadrao = clusters.get(i).getGrupo().size(); //numero de padroes no grupo
            somapadrao += qpadrao; //todos os padroes da base
            centro = centroide(clusters.get(i));

            for (int j = 0; j < qpadrao; j++) {
                qdesvio = clusters.get(i).getGrupo().get(j).getNumero() - centro;
                qdesvio = (float) Math.pow(qdesvio, 2);
                sqdesvio += qdesvio;
            }

            somaqdesvio += sqdesvio;//somatorios dos quadrados dos desvios entre todos os padroes de todos os grupos

            centro = 0;
            sqdesvio = 0;
            ////////////Fazer a variancia para todos os grupos
        }
        variancia = somaqdesvio / somapadrao;//variancia total, de todos os grupos da matriz

        return variancia;
    }

    public int[][] matrizConfusao(ArrayList<Cluster> clusters, List<String> classes) {
        int gruposDesejados = classes.size();

        int[][] mconfusao = new int[gruposDesejados][gruposDesejados];

        SelectionSort(clusters);

        for (int j = 0; j < gruposDesejados; j++) { //Coluna = formados
            for (int i = 0; i < gruposDesejados; i++) {
                mconfusao[i][j] = clusters.get(j).getNumClasse(classes.get(i));
            }
        }
        
        //Ajusta as posições da matriz confusao
        for (int i = 0; i < gruposDesejados; i++) {
            int aux = 0;
            int grupo = -1;
            for (int j = i; j < gruposDesejados; j++) {
                if (mconfusao[i][j] > aux) {
                    boolean maior = true;
                    for (int k = i+1; k < gruposDesejados; k++) {
                        if (mconfusao[i][j] < mconfusao[k][j]) {
                            maior = false;
                        }
                    }
                    if (maior) {
                        aux = mconfusao[i][j];
                        grupo = j;
                    }
                }
            }
            if (grupo != i && grupo != -1) {
                for (int k = 0; k < gruposDesejados; k++) {
                    int swap = mconfusao[k][grupo];
                    mconfusao[k][grupo] = mconfusao[k][i];
                    mconfusao[k][i] = swap;
                }
            }
        }
        return mconfusao;
    }

    public void SelectionSort(ArrayList<Cluster> clusters) { //ORDENA EM ORDEM CRESCENTE POR PADRÕES CARREGADOS
        int index_min;
        Cluster aux;

        for (int i = 0; i < clusters.size(); i++) {
            index_min = i;
            for (int j = i + 1; j < clusters.size(); j++) {
                if (clusters.get(j).numPadroes() < clusters.get(index_min).numPadroes()) {
                    index_min = j;
                }
            }
            if (index_min != i) {
                aux = clusters.get(index_min);
                clusters.set(index_min, clusters.get(i));
                clusters.set(i, aux);
            }
        }
        Collections.reverse(clusters);
    }
}
