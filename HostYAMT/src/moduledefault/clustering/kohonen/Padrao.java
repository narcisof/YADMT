/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kohonen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class Padrao {
    String grupo;
    int numero;
    List<Double> atributos = new ArrayList<Double>();

    public Padrao() {
        grupo = "";
        atributos.clear();
    }

    public List<Double> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Double> atributos) {
        this.atributos = atributos;
    }

    public void addAtributos(Double add) {
        this.atributos.add(add);
    }
    
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
}
