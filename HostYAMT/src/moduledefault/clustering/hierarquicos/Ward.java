package moduledefault.clustering.hierarquicos;

import java.util.ArrayList;
import java.util.List;
import moduledefault.clustering.uteis.Cluster;
import moduledefault.clustering.uteis.Padrao;

public class Ward {

    private List<Padrao> padroes;
    private int numeroPadroes;
    private int[][] matrizDendograma;
    private ArrayList<Cluster> clusters;

    public Ward(List<Padrao> padroes) {
        this.padroes = padroes;
        this.numeroPadroes = padroes.size();
    }

    public void ward() {
        matrizDendograma = new int[numeroPadroes][numeroPadroes];

        for (int i = 0; i < numeroPadroes; i++) {
            for (int j = 0; j < numeroPadroes; j++) {
                matrizDendograma[i][j] = 0;
            }
        }
        for (int i = 0; i < numeroPadroes; i++) {
            matrizDendograma[0][i] = i + 1;
        }

        int q = 0;
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
                float SQE = 0;

                ArrayList<Padrao> grupo1 = new ArrayList<>();
                for (int x = 0; x < numeroPadroes; x++) {//salva no vetor os padroes do grupo 1
                    if ((matrizDendograma[q][x] == i + 1) || (matrizDendograma[q][x] == j + 1)) {
                        for (int k = 0; k < numeroPadroes; k++) {
                            if (padroes.get(k).getNumero() == x) {
                                grupo1.add(padroes.get(k));
                            }
                        }
                    }
                }
                ArrayList<Double> mediag = new ArrayList<>();
                for (int l = 0; l < grupo1.get(0).getAtributos().size(); l++) {
                    Double aux = 0.0;
                    for (int k = 0; k < grupo1.size(); k++) {
                        aux += grupo1.get(k).getAtributos().get(l);
                    }
                    aux = aux / grupo1.size();
                    mediag.add(aux);
                }

                SQE = 0;

                for (int k = 0; k < grupo1.size(); k++) {
                    for (int l = 0; l < mediag.size(); l++) {
                        SQE += Math.pow((grupo1.get(k).getAtributos().get(l) - mediag.get(l)), 2);
                    }
                }

                matrizSQE[i][j] = SQE;

            }// for SQE
        }// for SQE 
        float SQETotal = 0;

        for (int i = 0; i < numeroPadroes; i++) { // 
            SQETotal += matrizSQE[i][i];
        }

        for (int y = 0; y < numeroPadroes - 1; y++) { ///////Inicio Ward
            float SQEMin = Float.MAX_VALUE;
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
            if(g1 == 0){
                break;
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
                if ((i + 1 != g1) && (i + 1 != g2)) {
                    float SQE = 0;

                    ArrayList<Padrao> grupo1 = new ArrayList<>();
                    for (int x = 0; x < numeroPadroes; x++) {//salva no vetor os padroes do grupo 1
                        if ((matrizDendograma[q][x] == g1) || (matrizDendograma[q][x] == i + 1)) {
                            for (int k = 0; k < numeroPadroes; k++) {
                                if (padroes.get(k).getNumero() == x) {
                                    grupo1.add(padroes.get(k));
                                }
                            }
                        }
                    }

                    ArrayList<Double> mediag = new ArrayList<>();
                    for (int l = 0; l < grupo1.get(0).getAtributos().size(); l++) {
                        Double aux = 0.0;
                        for (int k = 0; k < grupo1.size(); k++) {
                            aux += grupo1.get(k).getAtributos().get(l);
                        }
                        aux = aux / grupo1.size();
                        mediag.add(aux);
                    }

                    SQE = 0;

                    for (int k = 0; k < grupo1.size(); k++) {
                        for (int l = 0; l < mediag.size(); l++) {
                            SQE += Math.pow((grupo1.get(k).getAtributos().get(l) - mediag.get(l)), 2);
                        }
                    }

                    if (matrizSQE[g1 - 1][i] != 0) {
                        matrizSQE[g1 - 1][i] = SQE;
                    }
                }
            }
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
            c.setNomeGrupo("" + (i + 1));
            for (int j = 0; j < numeroPadroes; j++) {
                if (matrizDendograma[lineCluster][j] == g.get(i)) {
                    c.addPadrao(padroes.get(j));
                }
            }
            clusters.add(c);
        }

    }

    public int[][] getMatrizDendograma() {
        return matrizDendograma;
    }

    public ArrayList<Cluster> getClusters() {
        return clusters;
    }
}
