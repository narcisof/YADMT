package rna;

import rna.basico.funcoes.FuncaoBaseRadial;
import rna.redes.RBF;

public class UtilizandoRBF {

    public static void main(String[] args) {
        double[][] entrada = {
            {0.0, 0.0},
            {1.0, 0.0},
            {0.0, 1.0},
            {1.0, 1.0}
            
        };
        double[][] saida = {
            {-1.0},
            {1.0},
            {1.0},
            {-1.0}
            
        };
        RBF rbf = new RBF(2, 1, 1,FuncaoBaseRadial.FUNCAO_GAUSSIANA );
        //rbf.treinar(entrada,saida,400);
    }
}
