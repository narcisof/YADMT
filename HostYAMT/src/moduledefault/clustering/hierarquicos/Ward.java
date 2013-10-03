package moduledefault.clustering.hierarquicos;

import java.util.ArrayList;
import java.util.List;
import moduledefault.clustering.distancias.Chebyshev;
import moduledefault.clustering.distancias.CityBlock;
import moduledefault.clustering.distancias.CorrelacaoPearson;
import moduledefault.clustering.distancias.Cosseno;
import moduledefault.clustering.distancias.DistanciaEuclidiana;
import moduledefault.clustering.distancias.Mahalanobis;
import moduledefault.clustering.uteis.Cluster;
import moduledefault.clustering.uteis.Padrao;

public class Ward {

    private List<Padrao> padroes;
    private int numeroPadroes;
    private int opcaoDistancia;
    private int[][] matrizDendograma;
    private double[][] matrizDistancia;
    private ArrayList<Cluster> clusters;

    public Ward(List<Padrao> padroes, int opcaoDistancia) {
        this.padroes = padroes;
        this.numeroPadroes = padroes.size();
        this.opcaoDistancia = opcaoDistancia;
    }

    public void ward(int[][] m) { //Arrumar essa matriz M
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


        float min = 1000000, d = 0;
        int pad1 = 0, pad2 = 0, q = 0, cont = 0, para = 0;
        /////////////////

        float[][] matrizSQE = new float[numeroPadroes][numeroPadroes];  //CAlcula a matriz SQE 

        for (int i = 0; i < numeroPadroes; i++) {
            for (int j = 0; j < numeroPadroes; j++) {
                matrizSQE[i][j] = 0;
            }
        }
        for (int i = 0; i < numeroPadroes; i++) {
            matrizDendograma[q][i] = i + 1;
        }

        for (int i = 0; i < numeroPadroes; i++) { // Calcula todos os SQE
            for (int j = i + 1; j < numeroPadroes; j++) {
                int n = 0;
                if (i != j) { //Faz o calculo do SQE de 1 grupo para os demais
                    for (int x = 0; x < numeroPadroes; x++) {
                        if ((matrizDendograma[q][x] == i + 1) || (matrizDendograma[q][x] == j + 1)) //conta os padroes do grupo 1
                        {
                            ++n;
                        }
                    }
                    int[][] grupo = new int[n][2];
                    float[] mediagrupo = new float[2];//media para grupo 1 + grupo 2
                    int cnt = 0;
                    float SQE = 0;

                    for (int x = 0; x < 2; x++) {
                        mediagrupo[x] = 0;
                    }

                    for (int x = 0; x < numeroPadroes; x++) {//salva no vetor os padroes do grupo 1
                        if ((matrizDendograma[q][x] == i + 1) || (matrizDendograma[q][x] == j + 1)) {
                            for (int k = 0; k < numeroPadroes; k++) {
                                for (int y = 0; y < numeroPadroes; y++) {
                                    if (m[k][y] == x + 1) {
                                        grupo[cnt][0] = k;
                                        grupo[cnt][1] = y;
                                        ++cnt;
                                    }
                                }
                            }
                        }
                    }

                    for (int x = 0; x < n; x++) {
                        mediagrupo[0] += grupo[x][0];
                        mediagrupo[1] += grupo[x][1];
                    }

                    mediagrupo[0] = mediagrupo[0] / n;
                    mediagrupo[1] = mediagrupo[1] / n;

                    SQE = 0;
                    for (int x = 0; x < n; x++) {
                        SQE += Math.pow((grupo[x][0] - mediagrupo[0]), 2);
                        SQE += Math.pow((grupo[x][1] - mediagrupo[1]), 2);
                    }

                    matrizSQE[i][j] = SQE;
                } else {
                    for (int x = 0; x < numeroPadroes; x++) {
                        if (matrizDendograma[q][x] == i + 1) //conta os padroes do grupo 
                        {
                            ++n;
                        }
                    }
                    int[][] grupo = new int[n][2];
                    float[] mediagrupo = new float[2];//media para grupo 1 + grupo 2
                    int cnt = 0;
                    float SQE = 0;

                    for (int x = 0; x < 2; x++) {
                        mediagrupo[x] = 0;
                    }

                    for (int x = 0; x < numeroPadroes; x++) {//salva no vetor os padroes do grupo 1
                        if (matrizDendograma[q][x] == i + 1) {
                            for (int k = 0; k < numeroPadroes; k++) {
                                for (int y = 0; y < numeroPadroes; y++) {
                                    if (m[k][y] == x + 1) {
                                        grupo[cnt][0] = k;
                                        grupo[cnt][1] = y;
                                        ++cnt;
                                    }
                                }
                            }
                        }
                    }

                    for (int x = 0; x < n; x++) {
                        mediagrupo[0] += grupo[x][0];
                        mediagrupo[1] += grupo[x][1];
                    }

                    mediagrupo[0] = mediagrupo[0] / n;
                    mediagrupo[1] = mediagrupo[1] / n;

                    SQE = 0;
                    for (int x = 0; x < n; x++) {
                        SQE += Math.pow((grupo[x][0] - mediagrupo[0]), 2);
                        SQE += Math.pow((grupo[x][1] - mediagrupo[1]), 2);
                    }
                    matrizSQE[i][j] = SQE;
                }//else
            }// for SQE
        }// for SQE 
        float SQETotal = 0;

        for (int i = 0; i < numeroPadroes; i++) { // 
            SQETotal += matrizSQE[i][i];
        }

       for (int y = 0; y < numeroPadroes - 1; y++){
            cont = 0;
            min = 1000000;
            d = 0;
            pad1 = 0;
            pad2 = 0;

            float SQEMin = 1000000;
            int g1 = 0, g2 = 0;


            float auxSQE = 0;

            for (int i = 0; i < numeroPadroes; i++) { //
                for (int j = i + 1; j < numeroPadroes; j++) {
                    if (matrizSQE[i][j] != 0) {
                        auxSQE = SQETotal;
                        auxSQE -= matrizSQE[i][i];
                        auxSQE -= matrizSQE[j][j];
                        auxSQE += matrizSQE[i][j];
                        if (auxSQE < SQEMin) {
                            SQEMin = auxSQE;
                            g1 = i + 1;
                            g2 = j + 1;
                        }
                    }
                }
            }
            for (int i = 0; i < numeroPadroes; i++) { //Junta os grupos com menor SQe
                if ((matrizDendograma[q][i] == g2)) {
                    matrizDendograma[q + 1][i] = g1;
                } else {
                    matrizDendograma[q + 1][i] = matrizDendograma[q][i];
                }
            }

            ++q;

            ///atualizar matriz SQE
            matrizSQE[g1 - 1][g1 - 1] = SQEMin;

            for (int i = 0; i < numeroPadroes; i++) {
                matrizSQE[g2 - 1][i] = 0;
                matrizSQE[i][g2 - 1] = 0;
            }

            ///////////////////////////////
            for (int i = 0; i < numeroPadroes; i++) {
                int n = 0;
                if ((i + 1 != g1) && (i + 1 != g2)) {
                    for (int x = 0; x < numeroPadroes; x++) {
                        if ((matrizDendograma[q][x] == g1) || (matrizDendograma[q][x] == i + 1))//conta os padroes do grupo 
                        {
                            ++n;
                        }
                    }

                    int[][] grupo = new int[n][2];
                    float[] mediagrupo = new float[2];//media para grupo 1 + grupo 2
                    int cnt = 0;
                    float SQE = 0;

                    for (int x = 0; x < 2; x++) {
                        mediagrupo[x] = 0;
                    }

                    for (int x = 0; x < numeroPadroes; x++) {//salva no vetor os padroes do grupo 1
                        if ((matrizDendograma[q][x] == g1) || (matrizDendograma[q][x] == i + 1)) {
                            for (int k = 0; k < numeroPadroes; k++) {
                                for (int s = 0; s < numeroPadroes; s++) {
                                    if (m[k][y] == x + 1) {
                                        grupo[cnt][0] = k;
                                        grupo[cnt][1] = s;
                                        ++cnt;
                                    }
                                }
                            }
                        }
                    }

                    for (int x = 0; x < n; x++) {
                        mediagrupo[0] += grupo[x][0];
                        mediagrupo[1] += grupo[x][1];
                    }

                    mediagrupo[0] = mediagrupo[0] / n;
                    mediagrupo[1] = mediagrupo[1] / n;

                    SQE = 0;
                    for (int x = 0; x < n; x++) {
                        SQE += Math.pow((grupo[x][0] - mediagrupo[0]), 2);
                        SQE += Math.pow((grupo[x][1] - mediagrupo[1]), 2);
                    }
                    if (matrizSQE[g1 - 1][i] != 0) {
                        matrizSQE[g1 - 1][i] = SQE;
                    }
                }//if
            }//fim for

            /////////////////////////////////
        }//while parada
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
            c.setNomeGrupo("" + (i + 1));
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
            case 3:
                CorrelacaoPearson pea = new CorrelacaoPearson();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = pea.distancia(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
            case 4:
                Cosseno cos = new Cosseno();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = cos.distancia(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
            case 5:
                DistanciaEuclidiana eu = new DistanciaEuclidiana();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = eu.distancia(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
                    }
                }
                break;
            case 6:
                Mahalanobis ma = new Mahalanobis();
                matrizDistancia = new double[padroes.size()][padroes.size()];
                for (int i = 0; i < padroes.size(); i++) {
                    for (int j = 0; j < padroes.size(); j++) {
                        matrizDistancia[i][j] = ma.distancia(padroes.get(i).getAtributos(), padroes.get(j).getAtributos());
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
