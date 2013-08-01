/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class Cluster {

    private ArrayList<Padrao> grupo;
    private String nomeGrupo;

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
            if(aux > num){
                num = aux;
                nome = classes.get(i);
            }
        }
        nomeGrupo = nome;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }
        
    public int getNumClasse(String classe){
        int aux = 0;
        for (int i = 0; i < grupo.size(); i++) {
            if (grupo.get(i).getClasse().equals(classe)) {
                ++aux;
            }
        }
        return aux;
    }
    
    public int numPadroes(){
        return grupo.size();
    }

}
