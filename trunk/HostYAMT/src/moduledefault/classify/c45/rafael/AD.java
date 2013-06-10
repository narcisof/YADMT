/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.classify.c45.rafael;

import util.Util;
import moduledefault.elicitedbases.postgresrafael.model.beans.Coluna;
//import c_Modelo.Classificacao.Classificacao;
import moduledefault.classify.c45.rafael.jadti.AttributeValue;
import moduledefault.classify.c45.rafael.jadti.DecisionTree;
import moduledefault.classify.c45.rafael.jadti.Item;
import moduledefault.classify.c45.rafael.jadti.KnownNumericalValue;
import moduledefault.classify.c45.rafael.jadti.KnownSymbolicValue;
import moduledefault.classify.c45.rafael.jadti.Node;
import moduledefault.classify.c45.rafael.jadti.facade.FacadeJaDti;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author rafael
 */
public class AD /* implements Classificacao */ {

//    public static final String nome = "Árvore de Decisão (C4.5)";
    //
    private FacadeJaDti facadeJaDti;
    private Vector atributos;
    private double entropia;
    private double score;
    private int maiorNivel = 0;
    private Vector classes;
//    private boolean holdOut;

    public AD(Vector atributos, double entropia, double score /*, boolean holdOut */) {
        facadeJaDti = new FacadeJaDti();
        this.atributos = new Vector();
//        for (int i = 0; i < atributos.size(); i++) {
//            Coluna c = (Coluna) atributos.elementAt(i);
//            this.atributos.add(c.getNome());
//        }
        this.atributos = atributos;
        this.entropia = entropia;
        this.score = score;
//        this.holdOut = holdOut;
        this.classes = null;
    }
/*
    public double treinar(double[][] input, double[][] output) {
        //Vector classes = Util.nClasses(output);

        Vector classes = new Vector();
        for (int i = 0; i < output.length; i++) {
            if (!classes.contains(output[i])) {
                classes.add(output[i][0]);
            }
        }

//        if (holdOut) {
//            int[] treinamento = new int[classes.size()];
//            int[] teste = new int[classes.size()];
//            double[][] conjuntoEn = new double[input.length * 7 / 10][input[0].length];
//            double[][] conjuntoSa = new double[input.length * 7 / 10][output[0].length];
//
//            int j = 0;
//            for (int i = 0; i < output.length; i++) {
//                int classe = (int) output[i][0];
//                if (treinamento[classe] * 0.7 >= i - teste[classe] * 0.3) {
//                    teste[classe]++;
//                } else {
//                    treinamento[classe]++;
//                    conjuntoEn[j] = input[i];
//                    conjuntoSa[j] = output[i];
//                    j++;
//                    if (j >= conjuntoSa.length) {
//                        break;
//                    }
//                }
//            }
//            for (int i = 0; j < conjuntoSa.length; j++, i++) {
//                conjuntoEn[j] = input[i];
//                conjuntoSa[j] = output[i];
//            }
//            facadeJaDti.treinar(atributos, conjuntoEn, conjuntoSa, classes.size(), entropia, score);
//        } else {
            facadeJaDti.treinar(atributos, input, output, classes.size(), entropia, score);
//        }

        //facadeJaDti.imprimirarvore();
        return 0;
    }
 */

    public double treinar(Object[][] input, Object[] output) {
        //Vector classes = Util.nClasses(output);

        classes = new Vector();
        for (int i = 0; i < output.length; i++) {
            if (!classes.contains(output[i])) {
                classes.add(output[i]);
            }
        }

//        if (holdOut) {
//            int[] treinamento = new int[classes.size()];
//            int[] teste = new int[classes.size()];
//            double[][] conjuntoEn = new double[input.length * 7 / 10][input[0].length];
//            double[][] conjuntoSa = new double[input.length * 7 / 10][output[0].length];
//
//            int j = 0;
//            for (int i = 0; i < output.length; i++) {
//                int classe = (int) output[i][0];
//                if (treinamento[classe] * 0.7 >= i - teste[classe] * 0.3) {
//                    teste[classe]++;
//                } else {
//                    treinamento[classe]++;
//                    conjuntoEn[j] = input[i];
//                    conjuntoSa[j] = output[i];
//                    j++;
//                    if (j >= conjuntoSa.length) {
//                        break;
//                    }
//                }
//            }
//            for (int i = 0; j < conjuntoSa.length; j++, i++) {
//                conjuntoEn[j] = input[i];
//                conjuntoSa[j] = output[i];
//            }
//            facadeJaDti.treinar(atributos, conjuntoEn, conjuntoSa, classes.size(), entropia, score);
//        } else {
            facadeJaDti.treinar(atributos, input, output, classes.size(), entropia, score);
//        }

        //facadeJaDti.imprimirarvore();
        return 0;
    }
/*
    public double[] testar(double[] input) {
        AttributeValue[] av = new AttributeValue[input.length + 1];
        for (int i = 0; i < input.length; i++) {
            av[i] = new KnownNumericalValue(input[i]);
        }
        av[input.length] = new KnownSymbolicValue(0);
        Item item = new Item(av);
        return facadeJaDti.pergunta(item);
    }
 */
    public Object testar(Object[] input) {
//        AttributeValue[] av = new AttributeValue[input.length + 1];
//        for (int i = 0; i < input.length; i++) {
//            av[i] = new KnownNumericalValue(input[i]);
//        }
//        av[input.length] = new KnownSymbolicValue(0);
//        Item item = new Item(av);
        String value = facadeJaDti.pergunta(atributos, input);
        for(Object o : classes.toArray()){
            if(o.toString().equals(value))
                return o;
        }
        return null;
    }

//    public void setParametros(HashMap hm) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void addListner(Object listener) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    public String getArvoreString() {
        return facadeJaDti.getArvoreString(3);
    }

    public DecisionTree getArvore() {
        return facadeJaDti.getArvore();
    }

    public int nNodes() {
        maiorNivel = 0;
        recursiva(facadeJaDti.getArvore().root(), 1);
        return maiorNivel;
    }

    private void recursiva(Node n, int nivel) {
        if (nivel > maiorNivel) {
            maiorNivel = nivel;
        }
        for (int i = 0; i < n.nbSons(); i++) {
            recursiva(n.son(i), nivel + 1);
        }
    }

    public FacadeJaDti getFacadeJaDti() {
        return facadeJaDti;
    }

//    public void setFacadeJaDti(FacadeJaDti facadeJaDti) {
//        this.facadeJaDti = facadeJaDti;
//    }

    public Vector getAtributos() {
        return atributos;
    }

    public void setAtributos(Vector atributos) {
        this.atributos = atributos;
    }

    public double getEntropia() {
        return entropia;
    }

    public void setEntropia(double entropia) {
        this.entropia = entropia;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /*    public int nNodes() {
    Vector pilha = new Vector();
    Vector primeiros = new Vector();
    boolean entrou = true;
    DecisionTree tree = facadeJaDti.getArvore();
    pilha.add(tree.root());
    primeiros.add(tree.root().son(tree.root().nbSons() - 1));
    int maiorCont = 0, cont = 0;
    while (!pilha.isEmpty()) {
    Node n = (Node) pilha.remove(0);
    for (int i = n.nbSons() - 1; i >= 0; i--) {
    pilha.add(n.son(i));
    }
    if (!primeiros.isEmpty() && n == primeiros.get(0)) {
    System.out.println("aki " + maiorCont + " " + cont);
    entrou=false;
    primeiros.remove(0);
    if (maiorCont < cont) {
    maiorCont = cont;
    cont=1;
    }
    } else {
    cont++;
    }
    if (!entrou) {
    for (int i = n.nbSons() - 1; !entrou && i >= 0; i--) {
    if (n.son(i) != null) {
    primeiros.add(n.son(i));
    entrou = true;
    }
    }
    }
    }
    System.out.println("maiorCont: " + maiorCont);
    return maiorCont;
    }*/
}
