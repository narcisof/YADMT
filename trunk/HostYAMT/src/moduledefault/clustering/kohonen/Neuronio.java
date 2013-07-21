/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kohonen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Thiago
 */
public final class Neuronio {

    private int i;
    private int j;
    private int numPesos;
    private List<Double> pesos = new ArrayList<>();
    private List<Padrao> padroes = new ArrayList<>();

    public Neuronio(int numeroPesos, int lin, int col) {
        pesos.clear();
        padroes.clear();
        numPesos = numeroPesos;
        i = lin;
        j = col;
        startNeuronio();
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getNumPesos() {
        return numPesos;
    }

    public void setNumPesos(int numPesos) {
        this.numPesos = numPesos;
    }

    public List<Padrao> getPadroes() {
        return padroes;
    }

    public void setPadroes(List<Padrao> padroes) {
        this.padroes = padroes;
    }

    public void addPadrao(Padrao add) {
        this.padroes.add(add);
    }

    public void removePadrao(int index) {
        this.padroes.remove(index);
    }

    public List<Double> getPesos() {
        return pesos;
    }

    public void setPesos(List<Double> atributos) {
        this.pesos = atributos;
    }

    public void addPeso(Double add) {
        this.pesos.add(add);
    }

    public void removePeso(int index) {
        this.pesos.remove(index);
    }

    public void startNeuronio() {
        Random rand = new Random();
        for (int i = 0; i < numPesos; i++) {
            pesos.add(rand.nextDouble());
        }
    }
    
    public String toStringPesos(){
        String text = "";
        for (int i = 0; i < this.getNumPesos(); i++) {
            text = text + "["+this.pesos.get(i)+"] ";
        }
        return text;
    }
}
