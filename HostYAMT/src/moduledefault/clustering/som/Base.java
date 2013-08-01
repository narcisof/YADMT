/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago Magalhães Faino
 */
public class Base {

    String Nome;
    List<Padrao> dataSet = new ArrayList<>();
    List<String> atributos = new ArrayList<>();
    List<String> classes = new ArrayList<>();
     
    public Base() {
       this.Nome = null;
       this.dataSet.clear();
       this.atributos.clear();
       this.classes.clear();
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public List<Padrao> getDataSet() {
        return dataSet;
    }

    public void setDataSet(List<Padrao> dataSet) {
        this.dataSet = dataSet;
    }

    public void addDataSet(Padrao pad) {
        this.dataSet.add(pad);
    }

    public List<String> getAtributos() {
        return atributos;
    }
    
    public void addAtributos(String att){
        atributos.add(att);
    }
    
    public String getAtributo(int i){
        return atributos.get(i);
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> grupos) {
        this.classes = grupos;
    }
    
}
