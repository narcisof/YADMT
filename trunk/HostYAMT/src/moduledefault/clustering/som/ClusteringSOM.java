/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

import moduledefault.clustering.uteis.Cluster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import moduledefault.clustering.hierarquicos.LigacaoCompleta;
import moduledefault.clustering.hierarquicos.LigacaoMedia;
import moduledefault.clustering.hierarquicos.LigacaoSimples;
import moduledefault.clustering.uteis.Padrao;

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

    public ArrayList<Cluster> hierarquicos(String op, int grupos) {
        ArrayList<Cluster> aux = null;

        List<Padrao> pad = new ArrayList<>();
        for (int i = 0; i < neuronios.size(); i++) {
            Padrao p = new Padrao();
            p.setAtributos(neuronios.get(i).getPesos());
            p.setNumero(i);
            pad.add(p);
        }

        switch (op) {
            case "simples":
                LigacaoSimples simples = new LigacaoSimples(pad, 5);
                simples.ligacaoSimples();
                simples.clustering(grupos);
                aux = simples.getClusters();
                break;
            case "media":
                LigacaoMedia media = new LigacaoMedia(pad, 5);
                media.ligacaoMedia();
                media.clustering(grupos);
                aux = media.getClusters();
                break;
            case "completa":
                LigacaoCompleta completa = new LigacaoCompleta(pad, 5);
                completa.ligacaoCompleta();
                completa.clustering(grupos);
                aux = completa.getClusters();
                break;
            case "ward":
//                Ward ward = new Ward(pad, 5);
//                ward.ward();
//                ward.clustering(grupos);
//                aux = ward.getClusters();
                break;
        }

        ArrayList<Cluster> clusters = new ArrayList<>();
        for (int i = 0; i < aux.size(); i++) {
            Cluster c = new Cluster();
            for (int j = 0; j < aux.get(i).getGrupo().size(); j++) {
                int size = neuronios.get(aux.get(i).getGrupo().get(j).getNumero()).getPadroes().size();

                for (int k = 0; k < size; k++) {
                    c.addPadrao(neuronios.get(aux.get(i).getGrupo().get(j).getNumero()).getPadroes().get(k));
                }

            }
            clusters.add(c);
        }
        return clusters;
    }

    public ArrayList<Cluster> clustering1DSOM() {
        ArrayList<Cluster> clusters = new ArrayList<>();
        for (int i = 0; i < neuronios.size(); i++) {
            Cluster cl = new Cluster();
            addPadroes(neuronios.get(i), cl);
            clusters.add(cl);
        }
        return clusters;
    }

    public ArrayList<Cluster> clusteringDensidade(double e) {
        OpMath math = new OpMath();
        double erro = e;

        SelectionSort();

        ArrayList<Cluster> clusters = new ArrayList<>();

        for (int i = 0; i < neuronios.size(); i++) {
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

    public void addPadroes(Neuronio n, Cluster c) {
        for (int i = 0; i < n.getPadroes().size(); i++) {
            c.addPadrao(n.getPadroes().get(i));
        }
    }

    //TROCAR POR MERGE SORT
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
