/* jaDTi package - v0.6.1 */
package moduledefault.classify.c45.rafael.jadti.facade;

import moduledefault.classify.c45.rafael.jadti.AttributeSet;
import moduledefault.classify.c45.rafael.jadti.DecisionTree;
import moduledefault.classify.c45.rafael.jadti.DecisionTreeBuilder;
import moduledefault.classify.c45.rafael.jadti.Item;
import moduledefault.classify.c45.rafael.jadti.ItemSet;
import moduledefault.classify.c45.rafael.jadti.SimpleDecisionTreeBuilder;
import moduledefault.classify.c45.rafael.jadti.SymbolicAttribute;
import moduledefault.classify.c45.rafael.jadti.io.DecisionTreeToDot;
import moduledefault.classify.c45.rafael.jadti.io.ItemSetReader;
import moduledefault.classify.c45.rafael.jadti.LeafNode;
import moduledefault.classify.c45.rafael.jadti.Node;
import moduledefault.classify.c45.rafael.jadti.ScoreTestNode;
import java.util.Vector;
import moduledefault.classify.c45.rafael.jadti.IdSymbolicAttribute;
import moduledefault.classify.c45.rafael.jadti.KnownSymbolicValue;
import moduledefault.classify.c45.rafael.jadti.SymbolicValue;
import moduledefault.classify.c45.rafael.jadti.Test;


/*
 * A short example program of the jaDTi library.
 */
public class FacadeJaDti {

    private ItemSet learningSet;
//    static private ItemSet testSet;

    DecisionTree tree;


    public void treinar(Vector atributos, Object[][] input, Object[] output, int nClasses,
            double entropyThreshold, double scoreThreshold) {
        
        learningSet = ItemSetReader.read(atributos, input, output);
//        ItemSet testSet = ItemSetReader.read(new FileReader(args[1]),
//                    learningSet.attributeSet());

//        Vector attributes = readAttributesLine(atributos, nClasses);
//        Vector items = readLine(attributes, input, output);
//        ItemSet learningSet = ItemSetReader.buildItemSet(attributes, items);

        AttributeSet attributeSet = learningSet.attributeSet();
        Vector testAttributesVector = new Vector();
        for (int i = 0; i < atributos.size() - 1; i++) {
            testAttributesVector.add(attributeSet.findByName((String) atributos.get(i)));
        }
        AttributeSet testAttributes = new AttributeSet(testAttributesVector);
        SymbolicAttribute goalAttribute = (SymbolicAttribute) learningSet.attributeSet().findByName(
                (String) atributos.get(atributos.size() - 1));
        tree = buildTree(learningSet, testAttributes, goalAttribute,
                entropyThreshold, scoreThreshold);
    }

    public void imprimirarvore() {
        printDot(tree);
    }

    public Object pergunta(Item item) {
        KnownSymbolicValue guessedGoalAttributeValue =
                tree.guessGoalAttribute(item);
//        printGuess(item);
        double[] retorno = {guessedGoalAttributeValue.intValue};
        return retorno;
    }

    public String pergunta(Vector atributos, Object[] input) {
        Item item = ItemSetReader.read(atributos, input, 0, learningSet.attributeSet());

//        AttributeSet itemAttributes = tree.getAttributeSet();
        SymbolicAttribute goalAttribute = tree.getGoalAttribute();

//        KnownSymbolicValue goalAttributeValue =
//                (KnownSymbolicValue) item.valueOf(itemAttributes, goalAttribute);
        KnownSymbolicValue guessedGoalAttributeValue = tree.guessGoalAttribute(item);

        IdSymbolicAttribute attribute = (IdSymbolicAttribute) tree.getGoalAttribute();
        SymbolicValue testValue = new KnownSymbolicValue(guessedGoalAttributeValue.intValue);

        return attribute.valueToString(testValue);
    }

    public DecisionTree getArvore() {
        return tree;
    }

//    /*
//     * Prints an item's guessed goal attribute value.
//     */
//    private void printGuess(Item item) {
//        AttributeSet itemAttributes = tree.getAttributeSet();
//        SymbolicAttribute goalAttribute = tree.getGoalAttribute();
//
//        KnownSymbolicValue goalAttributeValue =
//                (KnownSymbolicValue) item.valueOf(itemAttributes, goalAttribute);
//        KnownSymbolicValue guessedGoalAttributeValue =
//                tree.guessGoalAttribute(item);
//
//        String s = "Item goal attribute value is " +
//                goalAttribute.valueToString(goalAttributeValue) + "\n";
//
//        s += "The value guessed by the tree is " +
//                tree.getGoalAttribute().valueToString(guessedGoalAttributeValue);
//
//        //System.out.println(s);
//    }

    public String getArvoreString(int inc) {
        String s = new String();
        Node node = tree.root();
        s = recursivo(node, 0, inc);
        //System.out.println(s);
        return s;
    }

    private String recursivo(Node node, int tab, int inc) {
        String s = new String();
        for (int i = 0; i < tab * inc; i++) {
            s += (" ");
        }
        if (node.isLeaf()) {
            LeafNode leaf = (LeafNode) node;
            KnownSymbolicValue d = leaf.goalValue();
            s += ("Classe = " + d.intValue) + "\n";
        } else {
            ScoreTestNode test = (ScoreTestNode) node;
            Test t = test.test();
            s += ("Se (" + t.toString() + ") então") + "\n";
            s += recursivo(test.son(1), tab + 1, inc);

            for (int i = 0; i < tab * inc; i++) {
                s += (" ");
            }
            s += ("Senão") + "\n";
            s += recursivo(test.son(0), tab + 1, inc);

        }
        return s;
    }

//
//    static public void main(String[] args) {
//        if (!readArgs(args)) {
//            System.exit(-1);
//        }
//        double entropyThreshold = 0.;
//        double scoreThreshold = 0.;
//        AttributeSet attributes = learningSet.attributeSet();
//        SymbolicAttribute goalAttribute =
//                (SymbolicAttribute) attributes.attribute(0);
//
////      removeKnown(attributes.indexOf(attributes.findByName("CellId_1")),
////  		    learningSet);
////  	removeKnown(attributes.indexOf(attributes.findByName("CTT_3")),
////  		    testSet);
//
//        System.out.println("Learning set size:" + learningSet.size());
//        System.out.println("Test set size:" + testSet.size());
//
//        Vector testAttributesVector = new Vector();
//        testAttributesVector.add(attributes.findByName("CTT_1"));
//        testAttributesVector.add(attributes.findByName("CTT_3"));
//        testAttributesVector.add(attributes.findByName("CellId_1"));
//        AttributeSet testAttributes = new AttributeSet(testAttributesVector);
//
//        System.out.println("Building tree");
//        DecisionTree tree =
//                buildTree(learningSet, testAttributes, goalAttribute, entropyThreshold,
//                scoreThreshold);
//
//        printDot(tree);
//
//        System.out.println("Testing");
//        System.out.println("Correct classification ratio: " +
//                test(tree, testSet));
//    }

    /*
     * Build the decision tree.
     */
    private DecisionTree buildTree(ItemSet learningSet, AttributeSet testAttributes,
            SymbolicAttribute goalAttribute, double entropyThreshold, double scoreThreshold) {
        SimpleDecisionTreeBuilder builder =
                new DecisionTreeBuilder(learningSet, testAttributes, goalAttribute, entropyThreshold, scoreThreshold);
        //builder.setTestScoreThreshold(0.0001 * learningSet.size());

        return builder.build().decisionTree();
    }

//    /*
//     * Remove items with a known value for the specified attribute.
//     **/
//    static private void removeKnown(int attributeIndex, ItemSet set) {
//        for (int i = 0; i < set.size(); i++) {
//            if (!set.item(i).valueOf(attributeIndex).isUnknown()) {
//                set.remove(i--);
//            }
//        }
//    }
//
//    /*
//     * Remove items with an unknown value for the specified attribute.
//     **/
//    static private void removeUnknown(int attributeIndex, ItemSet set) {
//        for (int i = 0; i < set.size(); i++) {
//            if (set.item(i).valueOf(attributeIndex).isUnknown()) {
//                set.remove(i--);
//            }
//        }
//    }

    /*
     * Prints a dot file content depicting a tree.
     */
    static private void printDot(DecisionTree tree) {
        System.out.println((new DecisionTreeToDot(tree)).produce());
    }

//    /*
//     * Test the tree using a test set.
//     */
//    static private double test(DecisionTree tree, ItemSet testSet) {
//        double ratio = 0.;
//        int attributeIndex = 1, nbTests = 0;
//
//        for (int i = 0; i < testSet.size(); i++) {
//            Item testItem = testSet.item(i);
//
//            if (tree.guessGoalAttribute(testItem).
//                    equals(testItem.valueOf(0))) {
//                ratio++;
//            }
//            nbTests++;
//        }
//
//        return ratio / (double) nbTests;
//    }
//
//    /*
//     * Reads command-line arguments.
//     **/
//    static private boolean readArgs(String[] args) {
//        if (args.length != 2) {
//            System.err.println("Usage: Classify <learningDB> <testDB>");
//            return false;
//        }
//
//        try {
//            learningSet = ItemSetReader.read(new FileReader(args[0]));
//            testSet = ItemSetReader.read(new FileReader(args[1]),
//                    learningSet.attributeSet());
//        } catch (FileNotFoundException e) {
//            System.err.println("File not found.");
//            return false;
//        } catch (IOException e) {
//            System.err.println("IO error");
//            return false;
//        }
//
//        return true;
//    }
}
