/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.hierarquicos;

import java.util.ArrayList;
import java.util.List;
import moduledefault.clustering.distancias.Chebyshev;
import moduledefault.clustering.distancias.CityBlock;
import moduledefault.clustering.distancias.CorrelacaoKendallTau;
import moduledefault.clustering.distancias.CorrelacaoPearson;
import moduledefault.clustering.distancias.CorrelacaoSpearman;
import moduledefault.clustering.distancias.Cosseno;
import moduledefault.clustering.distancias.DistanciaEuclidiana;
import moduledefault.clustering.distancias.Mahalanobis;
import moduledefault.clustering.uteis.Cluster;
import moduledefault.clustering.uteis.Padrao;

/**
 *
 * @author Mateus
 */
public class LigacaoMedia {

    private List<Padrao> padroes;
    private int numeroPadroes;
    private int opcaoDistancia;
    private int[][] matrizDendograma;
    private double[][] matrizDistancia;
    private ArrayList<Cluster> clusters;

    public LigacaoMedia(List<Padrao> padroes, int opcaoDistancia) {
        this.padroes = padroes;
        this.numeroPadroes = padroes.size();
        this.opcaoDistancia = opcaoDistancia;
    }

    public void ligacaoMedia() {
        calcMatrizDistancia();
        matrizDendograma = new int[numeroPadroes][numeroPadroes];

        for (int i = 0; i < numeroPadroes; i++) {
            for (int j = 0; j < numeroPadroes; j++) {
                matrizDendograma[i][j] = 0;
            }
        }
        for (int i = 0; i < numeroPadroes; i++) {
            matrizDendograma[0][i] = i + 1;
        }
        /////////////////
        int q = 1;
        for (int y = 0; y < numeroPadroes - 1; y++) {
            double min = Double.MAX_VALUE;
            int n1 = 0, n2 = 0;
            int grupo = 1;
            int grupoaux = 0;
            double dmin = 1000000;
            boolean controle1 = false, controle2 = false;
            int g1 = 0, g2 = 0;
            double d;
            if (q > 1) { //distancia média entre um padrão e os padrões de um mesmo grupo
                while (grupo <= numeroPadroes) {
                    for (int i = 0; i < numeroPadroes; i++) {
                        if (matrizDendograma[q - 1][i] == grupo) {
                            controle1 = true;
                        }
                    }
                    if (controle1 == true) {
                        grupoaux = grupo + 1;
                        while (grupoaux <= numeroPadroes) {
                            d = 0;
                            for (int i = 0; i < numeroPadroes; i++) {
                                if (matrizDendograma[q - 1][i] == grupoaux) {
                                    controle2 = true;
                                }
                            }
                            if (controle2 == true) {
                                for (int i = 0; i < numeroPadroes; i++) {
                                    if (matrizDendograma[q - 1][i] == grupo) //conta os padroes do grupo 1
                                    {
                                        n1++;
                                    }
                                    if (matrizDendograma[q - 1][i] == grupoaux) //conta os padroes do grupo 2
                                    {
                                        n2++;
                                    }
                                }
                                int[] grupo1 = new int[n1];
                                int[] grupo2 = new int[n2];
                                int cnt = 0;
                                for (int i = 0; i < numeroPadroes; i++) {//salva no vetor os padroes do grupo 1
                                    if (matrizDendograma[q - 1][i] == grupo) {
                                        grupo1[cnt] = matrizDendograma[q - 2][i];
                                        ++cnt;
                                    }
                                }
                                cnt = 0;
                                for (int i = 0; i < numeroPadroes; i++) {//salva no vetor os padroes do grupo 2
                                    if (matrizDendograma[q - 1][i] == grupoaux) {
                                        grupo2[cnt] = matrizDendograma[q - 2][i];
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
            for (int i = 0; i < numeroPadroes; i++) {
                if ((matrizDendograma[q - 1][i] == g2)) {
                    matrizDendograma[q][i] = g1;
                } else {
                    matrizDendograma[q][i] = matrizDendograma[q - 1][i];
                }
            }
            ////////////////////
            ++q;
        }

    }

    public void clustering(int grupos) {
        int lineCluster = numeroPadroes - grupos;
        ArrayList<Integer> g = new ArrayList<>();
        for (int i = 0; i < numeroPadroes; i++) {
            if (!g.contains(matrizDendograma[lineCluster][i])) {
                g.add(matrizDendograma[lineCluster][i]);
            }
        }

        clusters = new ArrayList<>();

        for (int i = 0; i < g.size(); i++) {
            Cluster c = new Cluster();

            c.setNomeGrupo("Cluster_" + (i + 1));
            for (int j = 0; j < numeroPadroes; j++) {
                if (matrizDendograma[lineCluster][j] == g.get(i)) {
                    c.addPadrao(padroes.get(j));
                }
            }
            clusters.add(c);
        }
    }

    public void calcMatrizDistancia() {
        switch (opcaoDistancia) {
            case 1:
                Chebyshev ch = new Chebyshev();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = ch.distancia(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
            case 2:
                CityBlock ci = new CityBlock();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = ci.distancia(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
            case 4:
                CorrelacaoPearson pea = new CorrelacaoPearson();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = pea.distancia(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
            case 6:
                Cosseno cos = new Cosseno();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = cos.distancia(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
            case 7:
                DistanciaEuclidiana eu = new DistanciaEuclidiana();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = eu.distancia(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
            case 8:
                Mahalanobis ma = new Mahalanobis();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = ma.distancia(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
            case 3:
                CorrelacaoKendallTau kt = new CorrelacaoKendallTau();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = kt.kendallTauBeta(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
            case 5:
                CorrelacaoSpearman sp = new CorrelacaoSpearman();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = sp.spearman(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
        }
    }

    public int[][] getMatrizDendograma() {
        return matrizDendograma;
    }

    public ArrayList<Cluster> getClusters() {
        return clusters;
    }
}