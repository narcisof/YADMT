/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kohonen;

import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class Cluster {
    
    ArrayList<Neuronio> neuronios;
    
    public Cluster(){
        neuronios = new ArrayList<>();
    }
    
    public void addNeuronio(Neuronio n){
        neuronios.add(n);
    }

    public ArrayList<Neuronio> getNeuronios() {
        return neuronios;
    }

    public void setNeuronios(ArrayList<Neuronio> neuronios) {
        this.neuronios = neuronios;
    }
    
}
