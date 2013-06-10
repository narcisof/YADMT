/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kohonen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago Magalhães Faino
 */
public class Base {

    String Nome;
    List<Padrao> dataSet = new ArrayList<Padrao>();
   // int numPadroes, numAtributos;
    
    public Base() {
       this.Nome = null;
       this.dataSet.clear();
     //  this.numAtributos = 0;
     //  this.numPadroes = 0;
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
    
//    public int getNumAtributos() {
//        return numAtributos;
//    }
//
//    public void setNumAtributos(int numAtributos) {
//        this.numAtributos = numAtributos;
//    }
//
//    public int getNumPadroes() {
//        return numPadroes;
//    }
//
//    public void setNumPadroes(int numPadroes) {
//        this.numPadroes = numPadroes;
//    }
    
//    public StringBuffer toStringData() {
//        StringBuffer saida = new StringBuffer();
//        
//        for (int i = 0; i < this.numPadroes; i++) {
//            StringBuffer append = saida.append(String.valueOf(this.getDataSet().get(i).getGrupo())).append(" | ");
//            for (int j = 0; j < this.numAtributos; j++) {
//                append = saida.append(String.valueOf(this.getDataSet().get(i).getAtributos().get(j))).append(" ");
//            }
//            saida.append("\n");
//        }
//        
//        return saida;
//    }

//    @Override
//    public String toString() {
//        return "Data{" + "Nome=" + Nome + ", dataSet=" + dataSet + ", numPadroes=" + numPadroes + ", numAtributos=" + numAtributos + '}';
//    }

    
}
