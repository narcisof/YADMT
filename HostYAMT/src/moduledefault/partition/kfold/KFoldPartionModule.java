/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.partition.kfold;

import annotations.ModuleAnnotation;
import annotations.PartitionModuleAnnotation;
import interfaces.Base;
import interfaces.HostInterface;
import interfaces.mining.classify.BaseClassify;
import interfaces.mining.classify.PartitionModuleInterface;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JDialog;
import javax.swing.JPanel;
import moduledefault.partition.holdout.view.JPanelHoldoutConfig;
import moduledefault.partition.kfold.view.JPanelKFoldConfig;

@ModuleAnnotation(name = "K-Fold")
@PartitionModuleAnnotation
public class KFoldPartionModule extends Observable implements PartitionModuleInterface {

    private HostInterface host = null;
    private JDialog jDialogConfig = null;
    private int k = 10;

    public KFoldPartionModule() {
        FacadeKFoldPartion.setHoudoutPartionModule(this);
    }

    /**
     * returns the KFold painel configuration
     * @return
     */
    public JPanel getPainelConfig() {
        return new JPanelKFoldConfig();
    }

    /**
     * sets the host
     * @param hi
     */
    public void setHost(HostInterface hi) {
        host = hi;
    }

    /**
     * sets the painel configuration
     * @param jd
     */
    public void setJDialogConfig(JDialog jd) {
        jDialogConfig = jd;
    }

    /**
     * retuns the painel configuration
     * @return
     */
    public JDialog getJDialogConfig() {
        return jDialogConfig;
    }

    /**
     * returns the k
     * @return
     */
    public int getK() {
        return k;
    }

    /**
     * sets the k
     * @param k
     */
    public void setK(int k) {
        this.k = k;
    }

    /**
     * base to be partitioned
     * @param base
     * @return partitioned base
     */
    public BaseClassify[] partition(Base base) {
        int tamanhoParticao = base.getInput().length / k;
        BaseClassify[] baseClassifiers = new BaseClassify[k];
        for (int i = 0; i < k; i++) {
            ArrayList<Object[]> arrayListInputTrain = new ArrayList<Object[]>();
            ArrayList<Object> arrayListOutputTrain = new ArrayList<Object>();

            ArrayList<Object[]> arrayListInputTest = new ArrayList<Object[]>();
            ArrayList<Object> arrayListOutputTest = new ArrayList<Object>();

            for (int j = 0; j < base.getInput().length; j++) {
                //vai para particao de teste
                //System.out.println("mult: " + tamanhoParticao * i);
                if (j >= (tamanhoParticao * i) && (j < tamanhoParticao * (i + 1))) {
                    arrayListInputTest.add(base.getInput()[j]);
                    arrayListOutputTest.add(base.getOutput()[j]);
                } else {//vai para particao de treinamento
                    //System.out.println("foi para treinamento ------------------------");
                    arrayListInputTrain.add(base.getInput()[j]);
                    arrayListOutputTrain.add(base.getOutput()[j]);
                }
            }
            Base baseTrain = new Base();
            baseTrain.setAtributes(base.getAtributes());
            baseTrain.setInput((Object[][]) arrayListInputTrain.toArray(new Object[0][0]));
            baseTrain.setOutput(arrayListOutputTrain.toArray());
            //System.out.println("Tamanho treino: " + baseTrain.getInput().length);
            Base baseTest = new Base();
            baseTest.setAtributes(base.getAtributes());
            baseTest.setInput((Object[][]) arrayListInputTest.toArray(new Object[0][0]));
            baseTest.setOutput(arrayListOutputTest.toArray());
            //System.out.println("Tamanho teste: " + baseTest.getInput().length);

            baseClassifiers[i] = new BaseClassify();
            baseClassifiers[i].setTest(baseTest);
            baseClassifiers[i].setTrain(baseTrain);
        }
        return baseClassifiers;
    }
}
