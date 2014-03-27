package moduledefault.classify.committee;

import annotations.ClassifierModuleAnnotation;
import annotations.ModuleAnnotation;
import interfaces.HostInterface;
import interfaces.mining.classify.ClassifierModuleInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import moduledefault.classify.committee.view.jpanel.ClassifierModuleConfig;
import moduledefault.classify.committee.view.jpanel.JPanelCommittee;

/**
 *
 * @author tiago.sippert
 */
@ModuleAnnotation(name = "Máquina de Comitê")
@ClassifierModuleAnnotation
public class CommitteeClassifierModule implements ClassifierModuleInterface {
    
    private String structureFunction = Committee.default_structure_function;
    private List<ClassifierModuleConfig> classifiers = new ArrayList<ClassifierModuleConfig>();

    private HostInterface hi        = null;
    private JDialog jDialogConfig   = null;
    private JTextArea jTextArea     = null;

    private Committee committee = null;

    public CommitteeClassifierModule() {
        FacadeCommitteeClassifierModule.setCommitteeClassifierModule(this);
    }

    public JPanel getPainelConfig() {
        return new JPanelCommittee();
    }

    public void setJDialogConfig(JDialog jDialogConfig) {
        this.jDialogConfig = jDialogConfig;
    }

    public void setTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public JPanel getCreatedModel() {
        return null;
    }

    public void train(Object[][] input, Object[] output) {
        committee.train(input, output);
    }

    public Object test(Object[] inputTest) {
        return committee.test(inputTest);
    }

    public ClassifierModuleInterface clone() {
        try {
            return (ClassifierModuleInterface) super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    public void createInstanceClissify(String[] attributes, Collection classes) {
        jTextArea.append("Máquina de Comitê");
        committee = new Committee();
        committee.setStructureFunction(structureFunction);
        jTextArea.append(" ( ");
        for (ClassifierModuleConfig classifierModuleConfig : classifiers) {
            classifierModuleConfig.classifierModule.setTextArea(jTextArea);
            classifierModuleConfig.classifierModule.createInstanceClissify(attributes, classes);
        }
        jTextArea.append(" ) ");
        committee.setClassifiers(classifiers);
    }

    public void setHost(HostInterface hostInterface) {
        hi = hostInterface;
    }

    public JDialog getJDialogConfig() {
        return jDialogConfig;
    }

    public List<ClassifierModuleConfig> getClassifiers() {
        return classifiers;
    }

    public void setClassifiers(List<ClassifierModuleConfig> classifiers) {
        this.classifiers = classifiers;
    }

    public String getStructureFunction() {
        return structureFunction;
    }

    public void setStructureFunction(String structureFunction) {
        this.structureFunction = structureFunction;
    }

    public JTextArea getJTextArea() {
        return jTextArea;
    }


}
