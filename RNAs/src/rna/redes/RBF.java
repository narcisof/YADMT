package rna.redes;

import java.util.ArrayList;
import rna.basico.Neuronio;
import rna.basico.NeuronioGuassiano;
import rna.basico.funcoes.FuncaoBaseRadial;

public class RBF {

    private int tamanhoEntrada;
    private ArrayList camadaOculta;
    private ArrayList<Neuronio> camadaSaida;

    public RBF(int nroEntradas, int neuroniosCamadaOculta,
            int neuroniosCamadaSaida, String funcaoAtivacao) {
        tamanhoEntrada = nroEntradas;

        if (funcaoAtivacao.compareTo(FuncaoBaseRadial.FUNCAO_GAUSSIANA) == 0) {
            camadaOculta = new ArrayList<NeuronioGuassiano>();

            //tem que ser menor que o numero de dados para treinamento, caso contrário nao converge http://www.deti.ufc.br/~guilherme/TI016/slides_RBF.pdf
            for (int i = 0; i < neuroniosCamadaOculta; i++) {
                camadaOculta.add(new NeuronioGuassiano());
            }
        }

        int nroPesos = camadaOculta.size();
        camadaSaida = new ArrayList<Neuronio>();
        for (int i = 0; i < neuroniosCamadaSaida; i++) {
            camadaSaida.add(new Neuronio(nroPesos));
        }

    }

    public double[] calcSaida(double[] entrada) {
        if (entrada.length == tamanhoEntrada) {
            double[] saida = new double[camadaSaida.size()];
            double[] aux = new double[camadaOculta.size()];
            for (int i = 0; i < camadaOculta.size(); i++) {
                aux[i] = ((NeuronioGuassiano) camadaOculta.get(i)).calcOutput(entrada);
                //System.out.print(aux[i] + " ");
            }
            //System.out.println("");
            for (int i = 0; i < saida.length; i++) {
                saida[i] = camadaSaida.get(i).combinacaoLinear(aux);
            }
            return saida;
        } else {
            return null;
        }
    }

    private double[] calcSaidaCamadaOculta(double[] entrada) {
        if (entrada.length == tamanhoEntrada) {
            double oculta[] = new double[camadaOculta.size()];
            for (int i = 0; i < camadaOculta.size(); i++) {
                oculta[i] = ((NeuronioGuassiano) camadaOculta.get(i)).calcOutput(entrada);
            }
            return oculta;
        } else {
            return null;
        }
    }

    public void treinarCamadaOculta(double[][] entrada, String larguraAtivacao) {
        //determinar os centros pelo algoritmo k-means
        int[] grupo = new int[entrada.length];

        //Associar os primeiros K vetores de entrada aos K centros
        for (int i = 0; i < camadaOculta.size(); i++) {
            if (i >= entrada.length) {
                ((NeuronioGuassiano) camadaOculta.get(i)).setCentro(entrada[i % entrada.length]);
            } else {
                ((NeuronioGuassiano) camadaOculta.get(i)).setCentro(entrada[i]);
            }

        }
        //imprimirCentros();

        //Para cada novo vetor de entrada faça
        //   Associá-lo ao grupo mais próximo
        for (int i = 0; i < grupo.length; i++) {
            //grupo[i] = centroMaisProximo(entrada[i]);
            grupo[i] = i % camadaOculta.size();
        }
        for (int i = 0; i < camadaOculta.size(); i++) {
            ((NeuronioGuassiano) camadaOculta.get(i)).setCentro(mediaGrupoK(i, entrada, grupo));
        }
        //imprimirCentros();

        //Calcular as novas posições dos centros
        boolean houveMudancaDePontos = true;
        int iteracao = 0;
        while (houveMudancaDePontos) {
            houveMudancaDePontos = false;
            for (int i = 0; i < entrada.length; i++) {
                int kAntigo = grupo[i];
                int kNovo = centroMaisProximo(entrada[i]);
                if (kAntigo != kNovo) {
                    houveMudancaDePontos = true;
                    grupo[i] = kNovo;
                    ((NeuronioGuassiano) camadaOculta.get(kAntigo)).setCentro(mediaGrupoK(kAntigo, entrada, grupo));
                    ((NeuronioGuassiano) camadaOculta.get(kNovo)).setCentro(mediaGrupoK(kNovo, entrada, grupo));
                }
            }
        }

        //determina as larguras, sendo a metade da distancia
        //entre o neuronio e o neuronio mais proximo
        if (larguraAtivacao.compareTo(FuncaoBaseRadial.LARGURA_MetadeMenorDistancia)==0) {
            if (camadaOculta.size() == 1) {
                // se camada oculta tiver apenas um neurônio
                //atribui largura padra de 0.5
                ((NeuronioGuassiano) camadaOculta.get(0)).setLargura(0.5);
            } else {
                for (int i = 0; i < camadaOculta.size(); i++) {
                    double distancia = distanciaEuclidiana(((NeuronioGuassiano) camadaOculta.get(i)).getCentro(),
                            ((NeuronioGuassiano) camadaOculta.get(centroMaisProximo(i))).getCentro());
                    ((NeuronioGuassiano) camadaOculta.get(i)).setLargura(distancia / 2);
                }
            }
        }else{
            //Qdo tiver tempo implementar as outras larguras de funcao de ativacao
            System.out.println("Tipo de largura não encontrado");
        }

    }

    public void treinarCamadaSaida(double[] entrada, double[] saidaDesejada, double taxaAprendizado) {
        double[] saida = calcSaida(entrada);
        double[] deltas = new double[saida.length];
        double[] saidasCamadaOculta = calcSaidaCamadaOculta(entrada);


        //calcula o delta de cada neuronio (tx de aprendizado x  erro)
        for (int i = 0; i < saida.length; i++) {
            deltas[i] = (saidaDesejada[i] - saida[i]) * taxaAprendizado;
        }

        //corrige todos os pesos de cada neuronio
        for (int i = 0; i < camadaSaida.size(); i++) {
            //percorre todos os pesos do neuronio i
            for (int j = 0; j < camadaSaida.get(i).nroPesos(); j++) {
                camadaSaida.get(i).setPeso(j, camadaSaida.get(i).getPeso(j) + deltas[i] * saidasCamadaOculta[j]);

            }
        }
    }

    private double[] mediaGrupoK(int k, double[][] entrada, int[] grupos) {
        double[] media = new double[((NeuronioGuassiano) camadaOculta.get(k)).getCentro().length];
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

    private int centroMaisProximo(double[] d) {
        double menor = distanciaEuclidiana(d, ((NeuronioGuassiano) camadaOculta.get(0)).getCentro());
        int indice = 0;
        for (int i = 1; i < camadaOculta.size(); i++) {
            if (distanciaEuclidiana(d, ((NeuronioGuassiano) camadaOculta.get(i)).getCentro()) < menor) {
                indice = i;
                menor = distanciaEuclidiana(d, ((NeuronioGuassiano) camadaOculta.get(i)).getCentro());
            }
        }
        return indice;
    }

    private int centroMaisProximo(int d) {
        //unico caso em que o centro mais proximo é ele mesmo,
        //quando apenas um neurônio na camada oculta
        if (camadaOculta.size() == 1) {
            return 0;
        }

        double menor = Double.MAX_VALUE;
        int indice = -1;

        for (int i = 0; i < camadaOculta.size(); i++) {
            if (i != d) {
                if (menor > distanciaEuclidiana(((NeuronioGuassiano) camadaOculta.get(d)).getCentro(),
                        ((NeuronioGuassiano) camadaOculta.get(i)).getCentro())) {
                    menor = distanciaEuclidiana(((NeuronioGuassiano) camadaOculta.get(d)).getCentro(),
                            ((NeuronioGuassiano) camadaOculta.get(i)).getCentro());
                    indice = i;
                }
            }
        }
        return indice;
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

    private void imprimirCentros() {
        for (int i = 0; i < camadaOculta.size(); i++) {
            System.out.print("neuronio " + i + ": ");
            for (int j = 0; j < ((NeuronioGuassiano) camadaOculta.get(i)).getCentro().length; j++) {
                System.out.print(((NeuronioGuassiano) camadaOculta.get(i)).getCentro()[j] + " | ");
            }
            System.out.println("");
        }
    }
}
