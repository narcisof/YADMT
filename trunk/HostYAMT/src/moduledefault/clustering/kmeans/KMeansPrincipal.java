/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kmeans;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import moduledefault.clustering.uteis.MatrizDados;
import moduledefault.clustering.uteis.Operações_Mat;

/**
 *
 * @author Mateus
 */
public class KMeansPrincipal {

    MatrizDados Arquivo;
    float[][] matrizAtributos;
    ArrayList<Float> minimoAtributo;
    ArrayList<Float> maximoAtributo;
    int numK;
    ArrayList<Centroide> centroides;
    float[][] matrizDistancia;
    int[] padroesClusters;
    private boolean lock = true;
    private ArrayList<Historico> historico;

    public KMeansPrincipal(MatrizDados teste, int numK) {
        this.Arquivo = teste;
        Operações_Mat m = new Operações_Mat();
        m.Padronização(teste);
        this.numK = numK;
        setMatrizAtributos();
        setMinMax();
        setCentroidesInicialAleatorios();
        setMatrizDistancia();
        historico = new ArrayList<Historico>();
        this.padroesClusters = new int[this.Arquivo.getLinhas()];
        for (int i = 0; i < this.padroesClusters.length; i++) {
            this.padroesClusters[i] = -1;
        }
    }

    public void start(){

        do {
            calculaMatrizDistancia();
            int[] auxMatrizCluster = new int[this.padroesClusters.length];
            for (int i = 0; i < auxMatrizCluster.length; i++) {
                auxMatrizCluster[i] = this.padroesClusters[i];
            }
            atribuiCentroides();
            Historico hist = new Historico(this.centroides, this.padroesClusters);
            this.historico.add(hist);
            avaliaMudanca(auxMatrizCluster);
            this.centroides = calcularNewCentroides();
        } while (this.lock);
        mConfusao();
        imprimiHistorico();

     // this.Arquivo.escreve_arquivo();

    }

    private void setMatrizAtributos() {
        this.matrizAtributos = new float[this.Arquivo.getLinhas()][(this.Arquivo.getColunas() - 1)];
        for (int i = 0; i < this.Arquivo.getLinhas(); i++) {
            for (int j = 1; j < this.Arquivo.getColunas(); j++) {
                this.matrizAtributos[i][j - 1] =  (float) this.Arquivo.getMatriz_dados()[i][j];
            }
        }
    }

    private void setMinMax() {
        this.minimoAtributo = new ArrayList<Float>();
        this.maximoAtributo = new ArrayList<Float>();

        for (int i = 0; i < this.Arquivo.getColunas() - 1; i++) {
            float minimo = Float.MAX_VALUE;
            float maximo = Float.MIN_VALUE;
            for (int j = 0; j < this.Arquivo.getLinhas(); j++) {
                if (this.matrizAtributos[j][i] > maximo) {
                    maximo = this.matrizAtributos[j][i];
                }
                if (this.matrizAtributos[j][i] < minimo) {
                    minimo = this.matrizAtributos[j][i];
                }
            }
            minimoAtributo.add(minimo);
            maximoAtributo.add(maximo);
        }
    }

    private void setCentroidesInicialMinMax() {
        this.centroides = new ArrayList<Centroide>();
        for (int i = 0; i < this.numK; i++) {
            Centroide newCentroide = new Centroide(this.Arquivo.getColunas() - 1);
            for (int j = 0; j < newCentroide.getNumAtributos(); j++) {
                newCentroide.setAtributos(j, sorteia(minimoAtributo.get(j), maximoAtributo.get(j)));
            }
            this.centroides.add(newCentroide);
        }
    }

    private void setCentroidesInicialAleatorios() {
        this.centroides = new ArrayList<Centroide>();
        int porcentagem = (int) (this.Arquivo.getLinhas() * 0.10);
        Random r = new Random();
        for (int i = 0; i < this.numK; i++) {
            Centroide newCentroide = new Centroide(this.Arquivo.getColunas() - 1);
            double[] medias = new double[this.Arquivo.getColunas() - 1];
            for (int w = 0; w < porcentagem; w++) {
                int padraoSorteado = r.nextInt(150);
                for (int e = 0; e < this.Arquivo.getColunas() - 1; e++) {
                    medias[e] += this.Arquivo.getMatriz_dados()[padraoSorteado][e + 1];
                }
            }
            for (int e = 0; e < this.Arquivo.getColunas() - 1; e++) {
                medias[e] /= porcentagem;
            }
            for (int j = 0; j < newCentroide.getNumAtributos(); j++) {
                newCentroide.setAtributos(j, medias[j]);
            }
            this.centroides.add(newCentroide);
        }
    }

    public double sorteia(float minimo, float maximo) {

        Random r = new Random();
        final float H = maximo; // sorteia entre 1 e 60
        final float L = minimo;
        return (r.nextDouble() * (H - L)) + L;
    }

    private void calculaMatrizDistancia() {

        for (int i = 0; i < this.Arquivo.getLinhas(); i++) {
            for (int w = 0; w < this.numK; w++) {
                double acumulador = 0;
                for (int j = 0; j < this.centroides.get(w).getAtributos().size(); j++) {
                    acumulador += Math.pow(this.matrizAtributos[i][j] - this.centroides.get(w).getAtributos().get(j), 2);
                }
                this.matrizDistancia[i][w] = ((float) Math.sqrt((acumulador)));
            }
        }
    }

    private void setMatrizDistancia() {
        this.matrizDistancia = new float[this.Arquivo.getLinhas()][this.numK];
    }

    private void atribuiCentroides() {
        for (int i = 0; i < this.Arquivo.getLinhas(); i++) {
            int indexCentroide = -1;
            float menor = Float.MAX_VALUE;
            for (int j = 0; j < this.numK; j++) {
                if (this.matrizDistancia[i][j] < menor) {
                    menor = this.matrizDistancia[i][j];
                    indexCentroide = j;
                }
            }
            this.padroesClusters[i] = indexCentroide;
        }
    }

    private ArrayList<Centroide> calcularNewCentroides(){
        double[][] vetorMedias = new double[this.numK][this.Arquivo.getColunas() - 1];
        int[] vetorSomatoria = new int[this.numK];

        for (int i = 0; i < this.padroesClusters.length; i++) {
            Centroide aux = this.centroides.get(this.padroesClusters[i]);
            for (int j = 0; j < aux.getAtributos().size(); j++) {
                vetorMedias[this.padroesClusters[i]][j] += this.Arquivo.getMatriz_dados()[i][j + 1];
            }
            vetorSomatoria[this.padroesClusters[i]]++;
        }
        ArrayList<Centroide> auxArray = new ArrayList<Centroide>();
        for (int i = 0; i < this.numK; i++) {
            Centroide aux = new Centroide((this.Arquivo.getColunas() - 1));
            for (int j = 0; j < aux.getAtributos().size(); j++) {
                aux.getAtributos().set(j, (vetorMedias[i][j] / vetorSomatoria[i]));
            }
            auxArray.add(aux);
        }
        return auxArray;

    }

    private void avaliaMudanca(int[] auxMatrizCluster){
        for (int i = 0; i < this.padroesClusters.length; i++) {
            if (auxMatrizCluster[i] != this.padroesClusters[i]) {
                return;
            }
        }
        this.lock = false;
    }

    private void imprimiHistorico() {
        for (int i = 0; i < historico.size(); i++) {
            System.out.println("Iteração: " + i + "\n");
            System.out.println("Centroídes: \n");
            for (int j = 0; j < historico.get(i).historicoCentroide.size(); j++) {
                System.out.println("\nCentroide: " + j);
                System.out.println("\nAtributos: ");
                for (int w = 0; w < historico.get(i).historicoCentroide.get(j).getAtributos().size(); w++) {
                    System.out.print(historico.get(i).historicoCentroide.get(j).getAtributos().get(w) + " ");
                }
            }
            System.out.println("\n\nPadroes: ");
            for (int j = 0; j < historico.get(i).historicoPadroes.length; j++) {
                System.out.println("Padrao: " + j + " grupo: " + historico.get(i).historicoPadroes[j]);
            }

            int[] vetorGruposFinal = new int[this.numK];
            for (int w = 0; w < this.padroesClusters.length; w++) {
                for (int j = 0; j < this.numK; j++) {
                    if (this.historico.get(i).historicoPadroes[w] == j) {
                        vetorGruposFinal[j]++;
                    }
                }
            }
            System.out.println("\n\nFormação Final da Iteração: ");
            for (int w = 0; w < this.numK; w++) {
                System.out.println("Grupo " + w + " -> " + vetorGruposFinal[w]);
            }
        }
        int[] vetorGruposFinal = new int[this.numK];
        for (int i = 0; i < this.padroesClusters.length; i++) {
            for (int j = 0; j < this.numK; j++) {
                if (this.padroesClusters[i] == j) {
                    vetorGruposFinal[j]++;
                }
            }
        }
        System.out.println("\n\nFormação Final: ");
        for (int i = 0; i < this.numK; i++) {
            System.out.println("Grupo " + i + " -> " + vetorGruposFinal[i]);
        }
    }

    void mConfusao() {
        int[][] mConfusao = new int[this.numK][this.numK];

        for (int i = 0; i < this.numK; i++) {
            for (int j = 0; j < this.numK; j++) {
                for (int w = 0; w < this.Arquivo.getLinhas(); w++) {
                    if ((this.Arquivo.getMatriz_dados()[w][0] == i + 1) && (this.padroesClusters[w] == j)) {
                        mConfusao[i][j]++;
                    }
                }
            }
        }
        System.out.println("M = ");
        for (int i = 0; i < this.numK; i++) {
            for (int j = 0; j < this.numK; j++) {
                System.out.print(mConfusao[i][j] + " ");
            }
            System.out.println();
        }

    }
}
