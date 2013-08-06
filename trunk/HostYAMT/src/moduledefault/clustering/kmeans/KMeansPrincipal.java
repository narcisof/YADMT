/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kmeans;

import java.util.ArrayList;
import java.util.Random;
import moduledefault.clustering.distancias.Chebyshev;
import moduledefault.clustering.distancias.CityBlock;
import moduledefault.clustering.distancias.Correlação;
import moduledefault.clustering.distancias.Cosseno;
import moduledefault.clustering.distancias.DistanciaEuclidiana;
import moduledefault.clustering.distancias.Mahalanobis;
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
    private float perct;
    int[][] m;

    public KMeansPrincipal(MatrizDados teste, int numK, boolean paradaAutomatica, boolean seedAleatorios, int seeds, int maxIteracoes, int iteracoesParada, int distancia) {
        this.Arquivo = teste;
        Operações_Mat m = new Operações_Mat();
        m.Padronização(teste);
        this.numK = numK;
        this.distancia = distancia;
        setMatrizAtributos();
        setMinMax();
        if (seedAleatorios) {
            setCentroidesInicialAleatorio();
        } else {
            perct = seeds / 100;
            setCentroidesInicialPorcentagem();
        }
        this.paradaAutomatica = paradaAutomatica;
        maxI = maxIteracoes;
        it = iteracoesParada;
        historico = new ArrayList<Historico>();
        this.padroesClusters = new int[this.Arquivo.getLinhas()];
        for (int i = 0; i < this.padroesClusters.length; i++) {
            this.padroesClusters[i] = -1;
        }
    }
    boolean paradaAutomatica;
    int maxI;
    int it;
    int distancia;

    public void start() {
        int cont = 0;
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
            if ((!this.paradaAutomatica) && (cont > it)) {
                break;
            }
            if (cont >= maxI) {
                break;
            }

            if (((!this.lock) && (this.paradaAutomatica))) {
                break;
            }
            cont++;
        } while ((true));
//        mConfusao();
//        imprimiHistorico();

    }

    private void setMatrizAtributos() {
        this.matrizAtributos = new float[this.Arquivo.getLinhas()][(this.Arquivo.getColunas() - 1)];
        for (int i = 0; i < this.Arquivo.getLinhas(); i++) {
            for (int j = 1; j < this.Arquivo.getColunas(); j++) {
                this.matrizAtributos[i][j - 1] = (float) this.Arquivo.getMatriz_dados()[i][j];
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

    private void setCentroidesInicialAleatorio() {
        this.centroides = new ArrayList<Centroide>();
        for (int i = 0; i < this.numK; i++) {
            Centroide newCentroide = new Centroide(this.Arquivo.getColunas() - 1);
            for (int j = 0; j < newCentroide.getNumAtributos(); j++) {
                newCentroide.setAtributos(j, sorteia(minimoAtributo.get(j), maximoAtributo.get(j)));
            }
            this.centroides.add(newCentroide);
        }
    }

    private void setCentroidesInicialPorcentagem() {
        this.centroides = new ArrayList<Centroide>();
        int porcentagem = (int) (this.Arquivo.getLinhas() * perct);
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

        switch (distancia) {
            case 1:
                setMatrizDistancia(Chebyshev.distanciaKmeans(Arquivo.getLinhas(), numK, matrizAtributos, centroides));
                break;
            case 2:
                setMatrizDistancia(CityBlock.distanciaKmeans(Arquivo.getLinhas(), numK, matrizAtributos, centroides));
                break;
            case 3:
                setMatrizDistancia(Correlação.distanciaKmeans(Arquivo.getLinhas(), numK, matrizAtributos, centroides));
                break;
            case 4:
                setMatrizDistancia(Cosseno.distanciaKmeans(Arquivo.getLinhas(), numK, matrizAtributos, centroides));
                break;
            case 5:
                setMatrizDistancia(DistanciaEuclidiana.distanciaKmeans(centroides, numK, matrizAtributos, Arquivo.getLinhas()));
                break;
            case 6:
                setMatrizDistancia(Mahalanobis.distanciaKmeans(Arquivo.getLinhas(), numK, matrizAtributos, centroides));
                break;
        }

    }

    private void setMatrizDistancia(float[][] resultado) {
        this.matrizDistancia = resultado;
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

    private ArrayList<Centroide> calcularNewCentroides() {
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

    private void avaliaMudanca(int[] auxMatrizCluster) {
        for (int i = 0; i < this.padroesClusters.length; i++) {
            if (auxMatrizCluster[i] != this.padroesClusters[i]) {
                return;
            }
        }
        this.lock = false;
    }

    public StringBuffer imprimiHistorico() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n\n===========================Resultados==================================");
        for (int i = 0; i < historico.size(); i++) {
            buffer.append("\n\nIteração: " + (i + 1) + "\n");
            buffer.append("\nCentroídes: \n");
            for (int j = 0; j < historico.get(i).historicoCentroide.size(); j++) {
                buffer.append("\nCentroide: " + j);
                buffer.append("\n\nAtributos: ");
                for (int w = 0; w < historico.get(i).historicoCentroide.get(j).getAtributos().size(); w++) {
                    buffer.append(historico.get(i).historicoCentroide.get(j).getAtributos().get(w) + " ");
                }
            }
            int[][] m = new int[2][historico.get(i).historicoPadroes.length];
            buffer.append("\n\nGrupos Formados:\n");
            for (int j = 0; j < historico.get(i).historicoPadroes.length; j++) {
                m[0][j] = j;
            }
            for (int j = 0; j < historico.get(i).historicoPadroes.length; j++) {
                m[1][j] = historico.get(i).historicoPadroes[j];
            }

            for (int j = m[0].length - 1; j >= 1; j--) {
                for (int y = 0; y < j; y++) {
                    if (m[0][y] > m[0][y + 1]) {
                        int auxLinha = m[0][y];
                        int auxColuna = m[1][y];
                        m[0][y] = m[0][y + 1];
                        m[1][y] = m[1][y + 1];
                        m[0][y + 1] = auxLinha;
                        m[1][y + 1] = auxColuna;
                    }
                }
            }

            String padrao;
            for (int k = 0; k < numK; k++) {
                int cont = 1;
                buffer.append("Grupo: " + (k + 1) + "\n\n");
                for (int j = 0; j < m[0].length; j++) {
                    if (m[1][j] == (k)) {

                        padrao = m[0][j] + "";
                        switch (padrao.length()) {
                            case 1:
                                padrao += "   ";
                                break;
                            case 2:
                                padrao += "  ";
                                break;
                            case 3:
                                padrao += " ";
                                break;
                        }

                        buffer.append(padrao);
                        if (cont % 10 == 0) {
                            buffer.append("\n");
                            cont = 0;
                        }
                        cont++;
                    }
                }
                buffer.append("\n\n-------------------------------------------------------\n\n");
            }

            int[] vetorGruposFinal = new int[this.numK];
            for (int w = 0; w < this.padroesClusters.length; w++) {
                for (int j = 0; j < this.numK; j++) {
                    if (this.historico.get(i).historicoPadroes[w] == j) {
                        vetorGruposFinal[j]++;
                    }
                }
            }
            buffer.append("\n\nFormação Final da Iteração:\n\n ");
            for (int w = 0; w < this.numK; w++) {
                buffer.append("Grupo " + (w + 1) + " -> " + vetorGruposFinal[w]);
                buffer.append("\n");
            }
            buffer.append(("============================================================="));
        }
//        int[] vetorGruposFinal = new int[this.numK];
//        for (int i = 0; i < this.padroesClusters.length; i++) {
//            for (int j = 0; j < this.numK; j++) {
//                if (this.padroesClusters[i] == j) {
//                    vetorGruposFinal[j]++;
//                }
//            }
//        }
//        System.out.println("\n\nFormação Final: ");
//        for (int i = 0; i < this.numK; i++) {
//            System.out.println("Grupo " + i + " -> " + vetorGruposFinal[i]);
//        }
        return buffer;
    }

    public StringBuffer imprimi() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n\n===================Resultados======================");
        buffer.append("\n\nCentroídes: \n");
        for (int j = 0; j < historico.get(historico.size() - 1).historicoCentroide.size(); j++) {
            buffer.append("\n\nCentroide: " + j);
            buffer.append("\nAtributos: ");
            for (int w = 0; w < historico.get(historico.size() - 1).historicoCentroide.get(j).getAtributos().size(); w++) {
                buffer.append(historico.get(historico.size() - 1).historicoCentroide.get(j).getAtributos().get(w) + " ");
            }
        }
        m = new int[2][historico.get(historico.size() - 1).historicoPadroes.length];
        buffer.append("\n\nGrupos Formados:\n\n");
        for (int j = 0; j < historico.get(historico.size() - 1).historicoPadroes.length; j++) {
            m[0][j] = j;
        }
        for (int j = 0; j < historico.get(historico.size() - 1).historicoPadroes.length; j++) {
            m[1][j] = historico.get(historico.size() - 1).historicoPadroes[j];
        }

        for (int j = m[0].length - 1; j >= 1; j--) {
            for (int y = 0; y < j; y++) {
                if (m[0][y] > m[0][y + 1]) {
                    int auxLinha = m[0][y];
                    int auxColuna = m[1][y];
                    m[0][y] = m[0][y + 1];
                    m[1][y] = m[1][y + 1];
                    m[0][y + 1] = auxLinha;
                    m[1][y + 1] = auxColuna;
                }
            }
        }

        String padrao;
        for (int k = 0; k < numK; k++) {
            int cont = 1;
            buffer.append("Grupo: " + (k + 1) + "\n\n");
            for (int j = 0; j < m[0].length; j++) {
                if (m[1][j] == (k)) {

                    padrao = m[0][j] + "";
                    switch (padrao.length()) {
                        case 1:
                            padrao += "   ";
                            break;
                        case 2:
                            padrao += "  ";
                            break;
                        case 3:
                            padrao += " ";
                            break;
                    }

                    buffer.append(padrao);
                    if (cont % 10 == 0) {
                        buffer.append("\n");
                        cont = 0;
                    }
                    cont++;
                }
            }
            buffer.append("\n\n-------------------------------------------------------\n\n");
        }

        int[] vetorGruposFinal = new int[this.numK];
        for (int w = 0; w < this.padroesClusters.length; w++) {
            for (int j = 0; j < this.numK; j++) {
                if (this.historico.get(historico.size() - 1).historicoPadroes[w] == j) {
                    vetorGruposFinal[j]++;
                }
            }
        }
        buffer.append("\nFormação Final: \n");
        for (int w = 0; w < this.numK; w++) {
            buffer.append("Grupo " + (w + 1) + " -> " + vetorGruposFinal[w]);
            buffer.append("\n");
        }

//        int[] vetorGruposFinal = new int[this.numK];
//        for (int i = 0; i < this.padroesClusters.length; i++) {
//            for (int j = 0; j < this.numK; j++) {
//                if (this.padroesClusters[i] == j) {
//                    vetorGruposFinal[j]++;
//                }
//            }
//        }
//        System.out.println("\n\nFormação Final: ");
//        for (int i = 0; i < this.numK; i++) {
//            System.out.println("Grupo " + i + " -> " + vetorGruposFinal[i]);
//        }
        return buffer;
    }

    public int[][] mConfusao() {
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
        //Ajusta as posições da matriz confusao
        for (int i = 0; i < this.numK; i++) {
            int aux = 0;
            int grupo = -1;
            for (int j = i; j < this.numK; j++) {
                if (mConfusao[i][j] > aux) {
                    boolean maior = true;
                    for (int k = i + 1; k < this.numK; k++) {
                        if (mConfusao[i][j] < mConfusao[k][j]) {
                            maior = false;
                        }
                    }
                    if (maior) {
                        aux = mConfusao[i][j];
                        grupo = j;
                    }
                }
            }
            if (grupo != i && grupo != -1) {
                for (int k = 0; k < this.numK; k++) {
                    int swap = mConfusao[k][grupo];
                    mConfusao[k][grupo] = mConfusao[k][i];
                    mConfusao[k][i] = swap;
                }
            }
        }
        return mConfusao;

    }

    public int getNumK() {
        return numK;
    }

    public void setNumK(int numK) {
        this.numK = numK;
    }

    public int[] getPadroesClusters() {
        return padroesClusters;
    }

    public void setPadroesClusters(int[] padroesClusters) {
        this.padroesClusters = padroesClusters;
    }

    public int[][] getM() {
        for (int j = 0; j < historico.get(historico.size() - 1).historicoPadroes.length; j++) {
            m[0][j] = j + 1;
        }
        for (int j = 0; j < historico.get(historico.size() - 1).historicoPadroes.length; j++) {
            m[1][j] = historico.get(historico.size() - 1).historicoPadroes[j] + 1;
        }

        return m;
    }

    public void setM(int[][] m) {
        this.m = m;
    }
}
