/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package moduledefault.classify.naivebayes;

import annotations.ClassifierModuleAnnotation;
import annotations.ModuleAnnotation;
import interfaces.HostInterface;
import interfaces.mining.classify.ClassifierModuleInterface;
import java.util.Collection;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author evaristowb
 */
@ModuleAnnotation(name = "Naive Bayes")
@ClassifierModuleAnnotation
public class NaiveBayesClassifierModule implements ClassifierModuleInterface {

    private JTextArea jTextArea;
    private HostInterface hostInterface;

    NaiveBayes naiveBayes;

    public JPanel getPainelConfig() {
        return null;
    }

    public void setJDialogConfig(JDialog jDialogConfig) {
    }

    public void setTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public JPanel getCreatedModel() {
        return null;
    }

    public void train(Object[][] input, Object[] output) {
//        for(int i=0;i<input.length;i++)
//            naiveBayes.addExamples(input[i], output[i]);
        naiveBayes.train(input, output);
    }

    public Object test(Object[] inputTest) {
//        return naiveBayes.prob(inputTest);
        return naiveBayes.test(inputTest);
    }

    public ClassifierModuleInterface clone() {
        try {
            return (ClassifierModuleInterface) super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    public void createInstanceClissify(String[] attributes, Collection classes) {
        jTextArea.append("Naive Bayes");
        naiveBayes = new NaiveBayes();
//        naiveBayes.setClasses(classes);
//        naiveBayes.setAtributes(attributes);
//        naiveBayes.inicialize();
        naiveBayes.inicialize(classes, attributes);
    }

    public void setHost(HostInterface hostInterface) {
        this.hostInterface = hostInterface;
    }

    public JTextArea getJTextArea() {
        return jTextArea;
    }

}
