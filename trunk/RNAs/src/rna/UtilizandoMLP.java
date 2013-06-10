package rna;

import java.text.DecimalFormat;
import rna.basico.funcoes.FuncaoAtivacao;
import rna.treinamento.BackPropagationMLP;
import rna.redes.MLP;


public class UtilizandoMLP {

    public static void main(String[] args) {
        double[][] entrada = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        double[][] saidaDesejada = {{0}, {1}, {1}, {0}};

        int epocas = 20000;
        double taxaAprendizagem = 0.8;
        double momento = 0.5;


        MLP mlp;
        BackPropagationMLP bc;
        String[] estruturas = {"5"};


        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(10);
        df.setMinimumFractionDigits(10);


        for (int p = 0; p < estruturas.length; p++) {
            mlp = new MLP(entrada[0].length, estruturas[p],1,FuncaoAtivacao.FUNCAO_LOGISTICA); ///com tilt
            bc = new BackPropagationMLP(mlp, taxaAprendizagem, momento);
            for (int i = 0; i < epocas; i++) {
                for (int j = 0; j < entrada.length; j++) {
                    bc.treinar(entrada[j], saidaDesejada[j]);
                    double[] saida = mlp.calcular(entrada[j]);
                    for (int k = 0; k < saida.length; k++) {
                         System.out.print(df.format(saidaDesejada[j][k]) + " : "+ df.format(saida[k]) + " | ");
                    }
                }
                System.out.println("estrutura '" + estruturas[p] + "' epoca:" + i);
            }
        }
    }
}
