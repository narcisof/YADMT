/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.uteis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import moduledefault.clustering.som.Neuronio;

/**
 *
 * @author Thiago
 */
public class Cluster {

    private ArrayList<Padrao> grupo;
    private ArrayList<Double> centroides;
    private String nomeGrupo;
    private int pai;
    private int posicaoDend;
    private ArrayList<Neuronio> neuronios;
    private String nomeClasse;

    public Cluster() {
        grupo = new ArrayList<>();
        nomeGrupo = null;
    }

    public void addPadrao(Padrao n) {
        grupo.add(n);
    }

    public ArrayList<Padrao> getGrupo() {
        return grupo;
    }

    public void setGrupo(ArrayList<Padrao> grupo) {
        this.grupo = grupo;
    }

    public void centroids() {
        centroides = new ArrayList<>();


        for (int i = 0; i < grupo.get(0).getAtributos().size(); i++) {
            centroides.add(0.0);
        }

        for (int i = 0; i < grupo.size(); i++) {
            for (int j = 0; j < grupo.get(i).getAtributos().size(); j++) {
                Double aux = centroides.get(j) + grupo.get(i).getAtributos().get(j);
                centroides.set(j, aux);
            }
        }

        for (int i = 0; i < centroides.size(); i++) {
            Double aux = centroides.get(i) / grupo.size();
            centroides.set(i, aux);
        }
    }

    public ArrayList<Double> getCentroides() {
        return centroides;
    }

    public void setCentroides(ArrayList<Double> centroides) {
        this.centroides = centroides;
    }

    public ArrayList<Integer> getSortGrupo() {
        ArrayList<Integer> aux = new ArrayList<>();
        for (int j = 0; j < grupo.size(); j++) {
            aux.add(grupo.get(j).getNumero());
        }
        Collections.sort(aux);
        return aux;
    }

    public void setNomeGrupo(List<String> classes) {
        int num = 0;
        String nome = null;

        for (int i = 0; i < classes.size(); i++) {
            int aux = 0;
            for (int j = 0; j < grupo.size(); j++) {
                if (grupo.get(j).getClasse().equals(classes.get(i))) {
                    ++aux;
                }
            }
            if (aux > num) {
                num = aux;
                nome = classes.get(i);
            }
        }
        nomeGrupo = nome;
    }

    public void setNomeGrupo(String nome) {
        nomeGrupo = nome;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public int getNumClasse(String classe) {
        int aux = 0;
        for (int i = 0; i < grupo.size(); i++) {
            if (grupo.get(i).getClasse().equals(classe)) {
                ++aux;
            }
        }
        return aux;
    }

    public int numPadroes() {
        return grupo.size();
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public int getPosicaoDend() {
        return posicaoDend;
    }

    public void setPosicaoDend(int posicaoDend) {
        this.posicaoDend = posicaoDend;
    }

    public ArrayList<Neuronio> getNeuronios() {
        return neuronios;
    }

    public void setNeuronios(ArrayList<Neuronio> neuronios) {
        this.neuronios = neuronios;
    }

    public void addNeuronio(Neuronio neuronio) {
        if (this.neuronios == null) {
            this.neuronios = new ArrayList<>();
        }
        this.neuronios.add(neuronio);
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }
}
