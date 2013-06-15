/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kohonen;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Thiago
 */
public class ClusteringSOM {

    private RedeKohonen rede;
    ArrayList<Neuronio> neuronios = new ArrayList<>();

    public ClusteringSOM(RedeKohonen r) {
        rede = r;
        for (int i = 0; i < rede.getGridX(); i++) {
            for (int j = 0; j < rede.getGridY(); j++) {
                if (!rede.getNeuronio(i, j).getPadroes().isEmpty()) {
                    neuronios.add(rede.getNeuronio(i, j));
                }
            }
        }
    }

    public void clusteringDensidade(double e) {
        OpMath math = new OpMath();
        double erro = e;

//        for (int i = 0; i < neuronios.size(); i++) {
//            System.out.println(neuronios.get(i).getNomeNeuronio() + " " + neuronios.get(i).getPadroes().size());
//        }
        SelectionSort();
        Collections.reverse(neuronios);
        //System.out.println("=======================================");
        for (int i = 0; i < neuronios.size(); i++) {
            System.out.println(neuronios.get(i).getNomeNeuronio() + " " + neuronios.get(i).getPadroes().size());
        }


        System.out.println("======================================");
        ArrayList<Cluster> clusters = new ArrayList<>();
 
        //OU FAZER UM WHILE REMOVENDO OS NEURONIOS, ATE Q A LISTA SEJA VAZIA
        
        int size = neuronios.size();
        for (int i = 0; i < size - 2; i++) {
            Cluster cl = new Cluster();
            cl.addNeuronio(neuronios.get(i));
            for (int j = i+1; j < size - 1; j++) {
                if (math.euclidiana(neuronios.get(i).getPesos(), neuronios.get(j).getPesos()) < erro) {
                    cl.addNeuronio(neuronios.get(j));
                    // neuronios.set(j, null);
                    neuronios.remove(j);
                    size = neuronios.size();
                }
            }
            clusters.add(cl);
        }


        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("Cluster " + i);
            for (int j = 0; j < clusters.get(i).getNeuronios().size(); j++) {
                System.out.println(clusters.get(i).getNeuronios().get(j).getNomeNeuronio() + "");
            }
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
    }
}
