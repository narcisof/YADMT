/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rna;

import rna.redes.LVQ;

/**
 *
 * @author Fernando
 */
public class UtilizandoLVQ {
   public static void main(String[] args){
        double[][] entrada = {
            {0.0, 0.0},
            {1.0, 0.0},
            {0.0, 1.0},
            {1.0, 1.0}

        };
        double[][] saida = {
            {1.0,0.0},
            {0.0,1.0},
            {0.0,1.0},
            {1.0,0.0}

        };
        LVQ lvq = new LVQ(entrada[0].length,
                20, saida[0].length);
        lvq.treinar(entrada,saida,200,0.8,0.01);
   }

}
