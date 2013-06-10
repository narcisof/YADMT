
/* jaDTi package - v0.6.1 */
package moduledefault.classify.c45.rafael.jadti.test;

import moduledefault.classify.c45.rafael.jadti.AttributeSet;
import moduledefault.classify.c45.rafael.jadti.AttributeValue;
import moduledefault.classify.c45.rafael.jadti.DecisionTree;
import moduledefault.classify.c45.rafael.jadti.DecisionTreeBuilder;
import moduledefault.classify.c45.rafael.jadti.Item;
import moduledefault.classify.c45.rafael.jadti.ItemSet;
import moduledefault.classify.c45.rafael.jadti.KnownNumericalValue;
import moduledefault.classify.c45.rafael.jadti.KnownSymbolicValue;
import moduledefault.classify.c45.rafael.jadti.NumericalAttribute;
import moduledefault.classify.c45.rafael.jadti.SymbolicAttribute;
import moduledefault.classify.c45.rafael.jadti.facade.FacadeJaDti;
import moduledefault.classify.c45.rafael.jadti.io.DecisionTreeToDot;
import java.io.*;
import java.util.*;


/*
 * A short example program of the jaDTi library.
 */
public class ZooTest {

    final static String dbFileName = "resources/zoo.db";
    final static String jadtiURL = "http://www.run.montefiore.ulg.ac.be/" +
            "~francois/software/jaDTi/";

    static public void main(String[] args)
            throws IOException {

        Vector atributos = new Vector();
        atributos.add("hum");
        atributos.add("dois");
        atributos.add("tres");
        double[][] input = {{1, 0}, {0, 1}, {0, 0}, {1, 1}};
        double[][] output = {{0}, {0}, {0}, {1}};

        FacadeJaDti f = new FacadeJaDti();
//        f.treinar(atributos, input, output, 2, 0., 0.);
        f.imprimirarvore();
        f.getArvoreString(3);
    }

    /*
     * Build the decision tree.
     */
    static private DecisionTree buildTree(ItemSet learningSet,
            AttributeSet testAttributes,
            SymbolicAttribute goalAttribute, double entropyThreshold,
            double scoreThreshold) {
        DecisionTreeBuilder builder =
                new DecisionTreeBuilder(learningSet, testAttributes,
                goalAttribute, entropyThreshold, scoreThreshold);

        return builder.build().decisionTree();
    }


    /*
     * Prints a dot file content depicting a tree.
     */
    static private void printDot(DecisionTree tree) {
        System.out.println((new DecisionTreeToDot(tree)).produce());
    }


    /*
     * Prints an item's guessed goal attribute value.
     */
    static private void printGuess(Item item, DecisionTree tree) {
        AttributeSet itemAttributes = tree.getAttributeSet();
        SymbolicAttribute goalAttribute = tree.getGoalAttribute();

        KnownSymbolicValue goalAttributeValue =
                (KnownSymbolicValue) item.valueOf(itemAttributes, goalAttribute);
        KnownSymbolicValue guessedGoalAttributeValue =
                tree.guessGoalAttribute(item);

        String s = "Item goal attribute value is " +
                goalAttribute.valueToString(goalAttributeValue) + "\n";

        s += "The value guessed by the tree is " +
                tree.getGoalAttribute().valueToString(guessedGoalAttributeValue);

        System.out.println(s);
    }

    /**
     * 
     * 
     * 
     * 
     */
    static public Vector readAttributesLine(Vector atributos, int nbValues) {
        Vector attributes = new Vector();
        for (int i = 0; i < atributos.size() - 1; i++) {
            String s = (String) atributos.get(i);
            attributes.add(new NumericalAttribute(s));
        }

        String s = (String) atributos.get(atributos.size() - 1);
        attributes.add(new SymbolicAttribute(s, nbValues));
        return attributes;
    }

    static public Vector readLine(Vector attributes, double[][] input, double[][] output) {
        Vector items = new Vector();
        for (int i = 0; i < input.length; i++) {
            AttributeValue[] values = new AttributeValue[attributes.size()];
            for (int j = 0; j < input[0].length; j++) {
                values[j] = new KnownNumericalValue(input[i][j]);
            }
            values[attributes.size() - 1] = new KnownSymbolicValue((int) output[i][0]);
            items.add(values);
        }
        return items;
    }
}
