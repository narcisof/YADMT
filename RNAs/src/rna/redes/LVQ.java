/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rna.redes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import rna.basico.NeuronioDeKohonen;

/**
 *
 * @author Fernando
 */
public class LVQ {
    
    public static final String INICIALIZACAO_KMeans = "Algoritmo k-means";
    
    private int tamanhoEntrada;
    private ArrayList<NeuronioDeKohonen> camadaOculta;
    private int tamanhoSaida;
    

    public LVQ(int nroNeuroniosEntradas, int nroNeuroniosOcultos,
            int nroNeuroniosCamadaSaida) {
        tamanhoEntrada = nroNeuroniosEntradas;
        camadaOculta = new ArrayList<NeuronioDeKohonen>();
        for (int i = 0; i < nroNeuroniosOcultos; i++) {
            camadaOculta.add(new NeuronioDeKohonen(nroNeuroniosEntradas, i % nroNeuroniosCamadaSaida));
        }
        tamanhoSaida = nroNeuroniosCamadaSaida;        
    }

    public double[] calcSaida(double[] entrada) {
        double[] saida = new double[tamanhoSaida];
        saida[camadaOculta.get(vencedorParaEntrada(entrada)).getClasse()] = 1.0;
        return saida;
    }

    public void treinar(double[][] entrada, double[][] saida, int epocas,double taxaAprendizado,double txDecaimento ) {
        double taxaAprendizadoAntigo = taxaAprendizado;
        //double txDecaimento = taxaAprendizado * (1.0 / (double) epocas);
        for (int k = 0; (k < epocas) && (taxaAprendizado > 0.0); k++) {            
            for (int i = 0; i < entrada.length; i++) {
                double[] out = calcSaida(entrada[i]);

                int vencedor = vencedorParaEntrada(entrada[i]);
                double[] delta = new double[entrada[i].length];

                for (int j = 0; j < delta.length; j++) {
                    delta[j] = (entrada[i][j] - camadaOculta.get(vencedor).getPesos()[j])
                            * taxaAprendizado;
                }
                
                //se classificao for errada afasta o centro do neuronio da entrada
                if (!Arrays.equals(out, saida[i])) {
                    for (int j = 0; j < delta.length; j++) {
                        delta[j] *= -1.0;
                    }
                }
                camadaOculta.get(vencedor).atualizarPesos(delta);
            }
            taxaAprendizado -= txDecaimento;            
        }
        taxaAprendizado = taxaAprendizadoAntigo;
    }

    public void inicializarKMeans(double[][] entrada) {
        //determinar os centros pelo algoritmo k-means
        //Associar os primeiros K vetores de entrada aos K centros
        for (int i = 0; i < camadaOculta.size(); i++) {
            if (i >= entrada.length) {
                camadaOculta.get(i).setPesos(entrada[i % entrada.length]);
            } else {
                camadaOculta.get(i).setPesos(entrada[i]);
            }
        }


        //Para cada novo vetor de entrada faça
        //   Associá-lo ao grupo mais próximo
        int[] grupo = new int[entrada.length];
        for (int i = 0; i < grupo.length; i++) {            
            grupo[i] = i % camadaOculta.size();
        }

        for (int i = 0; i < camadaOculta.size(); i++) {
            camadaOculta.get(i).setPesos(mediaGrupoK(i, entrada, grupo));
        }

        //Calcular as novas posições dos centros
        boolean houveMudancaDePontos = true;
        int iteracao = 0;
        while (houveMudancaDePontos) {
            houveMudancaDePontos = false;
            for (int i = 0; i < entrada.length; i++) {
                int kAntigo = grupo[i];
                int kNovo = vencedorParaEntrada(entrada[i]);
                if (kAntigo != kNovo) {
                    houveMudancaDePontos = true;
                    grupo[i] = kNovo;
                    camadaOculta.get(kAntigo).setPesos(mediaGrupoK(kAntigo, entrada, grupo));
                    camadaOculta.get(kNovo).setPesos(mediaGrupoK(kNovo, entrada, grupo));
                }
            }
        }
    }

    private int vencedorParaEntrada(double[] d) {
        double menor = distanciaEuclidiana(d, camadaOculta.get(0).getPesos());
        int indice = 0;
        for (int i = 1; i < camadaOculta.size(); i++) {
            if (distanciaEuclidiana(d, camadaOculta.get(i).getPesos()) < menor) {
                indice = i;
                menor = distanciaEuclidiana(d, camadaOculta.get(i).getPesos());
            }
        }
        return indice;
    }

    private double[] mediaGrupoK(int k, double[][] entrada, int[] grupos) {
        double[] media = new double[camadaOculta.get(k).getPesos().length];
        int qtdade = 0;
        for (int i = 0; i < entrada.length; i++) {
            if (grupos[i] == k) {
                qtdade++;
                for (int j = 0; j < media.length; j++) {
                    media[j] += entrada[i][j];
                }
            }
        }
        for (int i = 0; i < media.length; i++) {
            if (qtdade > 0) {
                media[i] /= (double) qtdade;
            }
        }
        return media;
    }

    private double distanciaEuclidiana(double[] p, double[] q) {
        double distancia = 0.0;
        double aux = 0.0;
        if (p.length == q.length) {
            for (int i = 0; i < p.length; i++) {
                aux = p[i] - q[i];
                distancia += aux * aux;
            }
        }
        return Math.sqrt(distancia);
    }

    private void imprimirVetor(double[] valores) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(10);
        df.setMinimumFractionDigits(10);
        for (int i = 0; i < valores.length; i++) {
            if (i > 0) {
                System.out.print(" | ");
            }
            System.out.print(df.format(valores[i]));
        }
    }
}
