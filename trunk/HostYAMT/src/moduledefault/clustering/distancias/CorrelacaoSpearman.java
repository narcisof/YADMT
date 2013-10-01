/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import moduledefault.clustering.uteis.Base;

/**
 *
 * @author Mateus
 */
public class CorrelacaoSpearman {

    Base base;
    double[][] matrizDistancias;

    public CorrelacaoSpearman(Base b) {
        base = b.copy();
        setMatrizDistancias(b.getDataSet().size());
    }

    public void distancia() {
        for (int i = 0; i < base.getDataSet().size(); i++) {
            for (int j = 0; j < base.getDataSet().size(); j++) {
                matrizDistancias[i][j] = this.spearman(base.getDataSet().get(i).getAtributos(), base.getDataSet().get(j).getAtributos());
            }
        }
    }

    public static double spearman(List<Double> x, List<Double> y) {

        int x_n = x.size();
        int y_n = y.size();
        List<Double> x_rank = new ArrayList<>();
        List<Double> y_rank = new ArrayList<>();
        for (int i = 0; i < x_n; i++) {
            double aux = 0;
            x_rank.add(aux);
            y_rank.add(aux);
        }
        TreeMap<Double, HashSet<Integer>> sorted = new TreeMap<Double, HashSet<Integer>>();
        for (int i = 0; i < x_n; i++) {
            double v = x.get(i);
            if (sorted.containsKey(v) == false) {
                sorted.put(v, new HashSet<Integer>());
            }
            sorted.get(v).add(i);
        }

        int c = 1;
        for (double v : sorted.descendingKeySet()) {
            double r = 0;
            for (int i : sorted.get(v)) {
                r += c;
                c++;
            }

            r /= sorted.get(v).size();

            for (int i : sorted.get(v)) {
                x_rank.set(i, r);
            }
        }

        sorted.clear();
        for (int i = 0; i < y_n; i++) {
            double v = y.get(i);
            if (sorted.containsKey(v) == false) {
                sorted.put(v, new HashSet<Integer>());
            }
            sorted.get(v).add(i);
        }

        c = 1;
        for (double v : sorted.descendingKeySet()) {
            double r = 0;
            for (int i : sorted.get(v)) {
                r += c;
                c++;
            }

            r /= sorted.get(v).size();

            for (int i : sorted.get(v)) {
                y_rank.set(i, r);
            }
        }
        CorrelacaoPearson cP = new CorrelacaoPearson();
   
        return cP.distancia(x_rank, y_rank);
    }

    public void padronizacaDistancias(double[][] matriz) {
        double menor = 0;
        double maior = 0;
        int cont = 0;

        maior = Double.MIN_VALUE;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][cont] > maior) {
                    maior = matriz[i][j];
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] /= maior;
            }
        }
    }

    public double[][] getMatrizDistancias() {
        return matrizDistancias;
    }

    public void setMatrizDistancias(int linhas) {
        this.matrizDistancias = new double[linhas][linhas];
    }
}
