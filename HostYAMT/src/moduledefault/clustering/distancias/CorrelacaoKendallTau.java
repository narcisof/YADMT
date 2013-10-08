/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import moduledefault.clustering.kmeans.Centroide;
import moduledefault.clustering.uteis.Base;

/**
 *
 * @author Mateus
 */
public class CorrelacaoKendallTau {

    public static double[][] distanciaKmeans(int size, int numK, double[][] matrizAtributos, ArrayList<Centroide> centroides) {
        double[][] resultado = new double[size][numK];
        for (int i = 0; i < size; i++) {
            List<Double> l1 = new ArrayList<>();
            List<Double> l2 = new ArrayList<>();
            for (int j = 0; j < numK; j++) {
                for (int k = 0; k < matrizAtributos[0].length; k++) {
                    l1.add(matrizAtributos[i][k]);
                }
                for (int k = 0; k < numK; k++) {
                    l2.add(centroides.get(j).getAtributos().get(k));
                }
                resultado[i][j] = rankKendallTauBeta(l1,l2);
            }
        }
        return resultado;
    }

    Base base;
    double[][] matrizDistancias;

    public CorrelacaoKendallTau(Base teste) {
        System.out.println("kendall");
        base = teste.copy();
        setMatrizDistancias(teste.getDataSet().size());
    }
        public void distancia() {
        for (int i = 0; i < base.getDataSet().size(); i++) {
            for (int j = 0; j < base.getDataSet().size(); j++) {
                matrizDistancias[i][j] = rankKendallTauBeta(base.getDataSet().get(i).getAtributos(), base.getDataSet().get(j).getAtributos());
            }
        }
    }
    public static double rankKendallTauBeta(List<Double> x, List<Double> y) {
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

        return kendallTauBeta(x_rank, y_rank);
    }

    public static double kendallTauBeta(List<Double> x, List<Double> y) {


        int c = 0;
        int d = 0;
        HashMap<Double, HashSet<Integer>> xTies = new HashMap<Double, HashSet<Integer>>();
        HashMap<Double, HashSet<Integer>> yTies = new HashMap<Double, HashSet<Integer>>();

        for (int i = 0; i < x.size() - 1; i++) {
            for (int j = i + 1; j < x.size(); j++) {
                if (x.get(i) > x.get(j) && y.get(i) > y.get(j)) {
                    c++;
                } else if (x.get(i) < x.get(j) && y.get(i) < y.get(j)) {
                    c++;
                } else if (x.get(i) > x.get(j) && y.get(i) < y.get(j)) {
                    d++;
                } else if (x.get(i) < x.get(j) && y.get(i) > y.get(j)) {
                    d++;
                } else {
                    if (x.get(i) == x.get(j)) {
                        if (xTies.containsKey(x.get(i)) == false) {
                            xTies.put(x.get(i), new HashSet<Integer>());
                        }
                        xTies.get(x.get(i)).add(i);
                        xTies.get(x.get(i)).add(j);
                    }

                    if (y.get(i) == y.get(j)) {
                        if (yTies.containsKey(y.get(i)) == false) {
                            yTies.put(y.get(i), new HashSet<Integer>());
                        }
                        yTies.get(y.get(i)).add(i);
                        yTies.get(y.get(j)).add(j);
                    }
                }
            }
        }

        int diff = c - d;
        double denom = 0;

        double n0 = (x.size() * (x.size() - 1)) / 2.0;
        double n1 = 0;
        double n2 = 0;

        for (double t : xTies.keySet()) {
            double s = xTies.get(t).size();
            n1 += (s * (s - 1)) / 2;
        }

        for (double t : yTies.keySet()) {
            double s = yTies.get(t).size();
            n2 += (s * (s - 1)) / 2;
        }

        denom = Math.sqrt((n0 - n1) * (n0 - n2));

        double t = diff / denom;

        assert t >= -1 && t <= 1 : t;

        return t;
    }

    public void padronizacaDistancias(double[][] matriz) {
        double menor = 0;
        double maior = 0;
        int cont = 0;

        maior = Double.MIN_VALUE;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > maior) {
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
