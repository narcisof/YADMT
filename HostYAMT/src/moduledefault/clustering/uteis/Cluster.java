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
    private String nomeGrupo;
    private int pai;
    private int posicaoDend;
    private ArrayList<Neuronio> neuronios;

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
}
