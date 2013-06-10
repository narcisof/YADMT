/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.partition.stratifiedkfold;

import annotations.ModuleAnnotation;
import annotations.PartitionModuleAnnotation;
import interfaces.Base;
import interfaces.HostInterface;
import interfaces.mining.classify.BaseClassify;
import interfaces.mining.classify.PartitionModuleInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import javax.swing.JDialog;
import javax.swing.JPanel;
import moduledefault.partition.stratifiedkfold.view.JPanelStratifiedKFoldConfig;

@ModuleAnnotation(name = "Stratified K-Fold")
@PartitionModuleAnnotation
public class StratifiedKFoldPartionModule extends Observable implements PartitionModuleInterface {

    private HostInterface host = null;
    private JDialog jDialogConfig = null;
    private int k = 10;

    public StratifiedKFoldPartionModule() {
        FacadeStratifiedKFoldPartion.setHoudoutPartionModule(this);
    }

    /**
     * returns the StratifiedKFold painel configuration
     * @return
     */
    public JPanel getPainelConfig() {
        return new JPanelStratifiedKFoldConfig();
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

//        System.out.println("Base Total");
//        for (int i = 0; i < base.getOutput().length; i++) {
//            System.out.println(base.getOutput()[i]);
//        }

        ArrayList classes = (ArrayList) base.getClasses();
        ArrayList<Object[]>[] subGroupsIn = new ArrayList[k];
        ArrayList<Object>[] subGroupsOut = new ArrayList[k];
        int[] classIndexes = new int[classes.size()];
        for (int i = 0; i < classIndexes.length; i++) {
            classIndexes[i] = k - 1;
        }
        for (int i = 0; i < subGroupsIn.length; i++) {
            subGroupsIn[i] = new ArrayList();
            subGroupsOut[i] = new ArrayList();
        }        
        for (int i = 0; i < base.getOutput().length; i++) {
            int index = classes.indexOf(base.getOutput()[i]);
            subGroupsIn[classIndexes[index]].add(base.getInput()[i]);
            subGroupsOut[classIndexes[index]--].add(base.getOutput()[i]);
            if (classIndexes[index] < 0) {
                classIndexes[index] = k - 1;
            }
        }
        BaseClassify[] baseClassifiers = new BaseClassify[k];
        for (int i = 0; i < k; i++) {//base de teste
            baseClassifiers[i] = new BaseClassify();            
            Base test = new Base();
            ArrayList<Object[]> arrayListInputTrain = new ArrayList<Object[]>();
            ArrayList<Object> arrayListOutputTrain = new ArrayList<Object>();
            for (int j = 0; j < k; j++) {//grupo k para teste
                if (i == j) {//vai para teste                    
                    test.setInput((Object[][]) subGroupsIn[j].toArray(new Object[0][0]));
                    test.setOutput(subGroupsOut[j].toArray());
//                    System.out.println("Grupo " + i);
                    //imprimeSaidas(subGroupsOut[j].toArray());
                } else {//vai para treinamento
                    arrayListInputTrain.addAll(Arrays.asList((Object[][])subGroupsIn[j].toArray(new Object[0][0])));
                    arrayListOutputTrain.addAll(Arrays.asList(subGroupsOut[j].toArray()));
                }
            }
            Base train = new Base();
            train.setInput((Object[][]) arrayListInputTrain.toArray(new Object[0][0]));
            train.setOutput(arrayListOutputTrain.toArray());

            baseClassifiers[i].setTrain(train);
            baseClassifiers[i].setTest(test);
            
            
        }

//        for (int i= 0; i < baseClassifiers.length; i++) {
//            System.out.println("Base " + i);
//            System.out.println("Treinamento");
//            imprimeSaidas(baseClassifiers[i].getTrain().getOutput());
//            System.out.println("Teste");
//            imprimeSaidas(baseClassifiers[i].getTest().getOutput());
//        }
        

        return baseClassifiers;
    }

    private void imprimeSaidas(Object []saidas){
        for (int i= 0; i < saidas.length; i++) {
            System.out.println(saidas[i]);
        }
    }
}
