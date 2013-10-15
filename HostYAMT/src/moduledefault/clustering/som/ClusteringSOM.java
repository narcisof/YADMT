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
import moduledefault.clustering.hierarquicos.Ward;
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

    public ArrayList<Cluster> faino() {
        ArrayList<Cluster> clusters = new ArrayList<>();
        Watershed water = new Watershed();

        int[][] matriz = new int[rede.getGridX()][rede.getGridY()];
        for (int i = 0; i < rede.getGridX(); i++) {
            for (int j = 0; j < rede.getGridY(); j++) {
                if (!rede.getNeuronio(i, j).getPadroes().isEmpty()) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        ArrayList<ArrayList<Elemento>> result = water.componentesList(matriz);

        for (int i = 0; i < result.size(); i++) {
            Cluster cl = new Cluster();
            ArrayList<Neuronio> ne = new ArrayList<>();
            for (int j = 0; j < result.get(i).size(); j++) {
                int x = result.get(i).get(j).getI();
                int y = result.get(i).get(j).getJ();
                ne.add(rede.getNeuronio(x, y));
            }
            for (int j = 0; j < ne.size(); j++) {
                addPadroes(ne.get(j), cl);
            }
            cl.setNeuronios(ne);
            clusters.add(cl);
        }
        return clusters;
    }

    public ArrayList<Cluster> clusterungSLSOM(double[][] matrizU, int[][] marcadores) {
        ArrayList<Cluster> clusters = new ArrayList<>();
        Watershed water = new Watershed();
        ArrayList<ArrayList<Elemento>> result = water.watershed(matrizU, marcadores);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                for (int k = 0; k < result.get(i).size(); k++) {
                    if ((j != k) && (k > j)) {
                        if (result.get(i).get(j).getI() == result.get(i).get(k).getI()
                                && result.get(i).get(j).getJ() == result.get(i).get(k).getJ()) {
                            result.get(i).remove(k);
                        }
                    }
                }

            }
        }
        //Rotular Os Neuronios
        for (int i = 0; i < result.size(); i++) {
            Cluster cl = new Cluster();
            ArrayList<Neuronio> ne = new ArrayList<>();
            for (int j = 0; j < result.get(i).size(); j++) {
                int x = result.get(i).get(j).getI();
                int y = result.get(i).get(j).getJ();
                if (x % 2 != 0) {
                    x -= 1;
                }
                x /= 2;
                if (y % 2 != 0) {
                    y -= 1;
                }
                y /= 2;
                if (!ne.contains(rede.getNeuronio(x, y))) {
                    ne.add(rede.getNeuronio(x, y));
                }
            }
            for (int j = 0; j < ne.size(); j++) {
                addPadroes(ne.get(j), cl);
            }
            boolean teste = false;
            for (int j = 0; j < ne.size(); j++) {
                if (!ne.get(j).getPadroes().isEmpty()) {
                    teste = true;
                    break;
                }
            }
            if (teste) {
                cl.setNeuronios(ne);
                clusters.add(cl);
            }
        }

        return clusters;
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
                Ward ward = new Ward(pad);
                ward.ward();
                ward.clustering(grupos);
                aux = ward.getClusters();
                break;
        }

        ArrayList<Cluster> clusters = new ArrayList<>();
        for (int i = 0; i < aux.size(); i++) {
            Cluster c = new Cluster();
            for (int j = 0; j < aux.get(i).getGrupo().size(); j++) {
                int size = neuronios.get(aux.get(i).getGrupo().get(j).getNumero()).getPadroes().size();

                for (int k = 0; k < size; k++) {
                    c.addPadrao(neuronios.get(aux.get(i).getGrupo().get(j).getNumero()).getPadroes().get(k));
                    c.addNeuronio(neuronios.get(aux.get(i).getGrupo().get(j).getNumero()));
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
            cl.addNeuronio(neuronios.get(i));
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
                cl.addNeuronio(neuronios.get(i));
                for (int j = i + 1; j < neuronios.size(); j++) {
                    if (neuronios.get(j) != null) {
                        if (math.euclidiana(neuronios.get(i).getPesos(), neuronios.get(j).getPesos()) < erro) {
                            addPadroes(neuronios.get(j), cl);
                            cl.addNeuronio(neuronios.get(j));
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
