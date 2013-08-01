/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Thiago
 */
public class ClusteringSOM {

    private RedeSOM rede;
    ArrayList<Neuronio> neuronios = new ArrayList<>();

    public ClusteringSOM(RedeSOM r) {
        rede = r;
        for (int i = 0; i < rede.getGridX(); i++) {
            for (int j = 0; j < rede.getGridY(); j++) {
                if (!rede.getNeuronio(i, j).getPadroes().isEmpty()) {
                    neuronios.add(rede.getNeuronio(i, j));
                }
            }
        }
    }

    public ArrayList<Cluster> clusteringDensidade(double e) {
        OpMath math = new OpMath();
        double erro = e;

        SelectionSort();

        ArrayList<Cluster> clusters = new ArrayList<>();

        for (int i = 0; i < neuronios.size() - 1; i++) {
            if (neuronios.get(i) != null) {
                Cluster cl = new Cluster();
                addPadroes(neuronios.get(i), cl);
                for (int j = i + 1; j < neuronios.size(); j++) {
                    if (neuronios.get(j) != null) {
                        if (math.euclidiana(neuronios.get(i).getPesos(), neuronios.get(j).getPesos()) < erro) {
                            addPadroes(neuronios.get(j), cl);
                            neuronios.set(j, null);
                        }
                    }
                }
                neuronios.set(i, null);
                clusters.add(cl);
            }
        }

        return clusters;
    }
    
    public void addPadroes(Neuronio n, Cluster c){
        
        for (int i = 0; i < n.getPadroes().size(); i++) {
            c.addPadrao(n.getPadroes().get(i));
        }
    }

    public void SelectionSort() { //ORDENA EM ORDEM CRESCENTE POR PADRÕES CARREGADOS
        int index_min;
        Neuronio aux;

        for (int i = 0; i < neuronios.size(); i++) {
            index_min = i;
            for (int j = i + 1; j < neuronios.size(); j++) {
                if (neuronios.get(j).getPadroes().size() < neuronios.get(index_min).getPadroes().size()) {
                    index_min = j;
                }
            }
            if (index_min != i) {
                aux = neuronios.get(index_min);
                neuronios.set(index_min, neuronios.get(i));
                neuronios.set(i, aux);
            }
        }
        Collections.reverse(neuronios);
    }
    
    
}
