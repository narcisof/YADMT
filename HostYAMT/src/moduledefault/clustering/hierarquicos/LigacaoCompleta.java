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
public class LigacaoCompleta {

    private List<Padrao> padroes;
    private int numeroPadroes;
    private int opcaoDistancia;
    private int[][] matrizDendograma;
    private double[][] matrizDistancia;
    private ArrayList<Cluster> clusters;

    public LigacaoCompleta(List<Padrao> padroes, int _opcaoDistancia) {
        this.padroes = padroes;
        this.numeroPadroes = padroes.size();
        this.opcaoDistancia = _opcaoDistancia;
        System.out.println("completa");
    }

    public void ligacaoCompleta() {
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
            for (int i = 0; i < numeroPadroes; i++) {
                for (int j = i + 1; j < numeroPadroes; j++) {
                    if ((matrizDendograma[q - 1][i] == matrizDendograma[q - 1][j])) {
                        matrizDistancia[i][j] = 0;
                        matrizDistancia[j][i] = 0;
                    }
                }
            }
            //maior distancia entre um padrão e os padrões de um mesmo grupo
            double d;
            for (int i = 0; i < numeroPadroes; i++) {
                for (int j = i + 1; j < numeroPadroes; j++) {
                    if ((matrizDendograma[q - 1][i] == matrizDendograma[q - 1][j])) {
                        for (int k = 0; k < numeroPadroes; k++) {
                            if ((k != i) && (k != j)) {
                                if (matrizDistancia[k][j] > matrizDistancia[k][i]) {
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
            int pad1 = 0;
            int pad2 = 0;
            for (int i = 0; i < numeroPadroes; i++) {
                for (int j = 0; j < numeroPadroes; j++) {
                    if ((matrizDistancia[i][j] < min) && (matrizDistancia[i][j] > 0)) {
                        min = matrizDistancia[i][j];
                        pad1 = i + 1;
                        pad2 = j + 1;

                    }
                }
            }
            for (int i = 0; i < numeroPadroes; i++) {
                if ((matrizDendograma[q - 1][i] == pad1) || (matrizDendograma[q - 1][i] == pad2)) {
                    matrizDendograma[q][i] = matrizDendograma[q - 1][pad1 - 1];

                } else {
                    matrizDendograma[q][i] = matrizDendograma[q - 1][i];
                }
            }
            ++q;
        }
//        System.out.println("Matriz Dendograma:");
//        for (int i = 0; i < matrizDendograma.length; i++) {
//            for (int j = 0; j < matrizDendograma[0].length; j++) {
//                System.out.print(" " + matrizDendograma[i][j]);
//            }
//            System.out.println("");
//        }
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
        System.out.println("opcao = "+opcaoDistancia);
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