/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.partition.stratifiedholdout;

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
import moduledefault.partition.stratifiedholdout.view.JPanelStratifiedHoldoutConfig;

@ModuleAnnotation(name = "Stratified Holdout")
@PartitionModuleAnnotation
public class StratifiedHoldoutPartionModule extends Observable implements PartitionModuleInterface {

    private HostInterface host = null;
    private JDialog jDialogConfig = null;
    private double split = 0.666;

    public StratifiedHoldoutPartionModule() {
        FacadeStratifiedHoldoutPartion.setHoudoutPartionModule(this);
    }

    /**
     * returns the painel configuration
     * @return
     */
    public JPanel getPainelConfig() {
        return new JPanelStratifiedHoldoutConfig();
    }

    /**
     * sets the host
     * @param hi
     */
    public void setHost(HostInterface hi) {
        host = hi;
    }

    /**
     *sets the painel configuration
     * @param jd
     */
    public void setJDialogConfig(JDialog jd) {
        jDialogConfig = jd;
    }

    /**
     * returns the painel configuration
     * @return
     */
    public JDialog getJDialogConfig() {
        return jDialogConfig;
    }

    /**
     * returns the split
     * @return
     */
    public double getSplit() {
        return split;
    }

    /**
     * sets the split
     * @param split
     */
    public void setSplit(double split) {
        this.split = split;
    }

    /**
     * partitioning base
     * @param base - base to be partitioned
     * @return partitioned base
     */
    public BaseClassify[] partition(Base base) {
        //calcula a frequencia de cada classe
        ArrayList classes = (ArrayList) base.getClasses();
        double[] frequencia = new double[classes.size()];
        int[] quantidade = new int[classes.size()];

        for (int i = 0; i < base.getOutput().length; i++) {
            quantidade[classes.indexOf(base.getOutput()[i])]++;
        }
//        System.out.println("Frequencia");
        for (int i = 0; i < frequencia.length; i++) {
            frequencia[i] = quantidade[i] / (double) base.getOutput().length;
//            System.out.println(base.getClasses().toArray()[i] + " : " + frequencia[i]);
        }

        //calcula a quantidade de registros de cada classe para treinamento
//        System.out.println("Quantidade");
        for (int i = 0; i < quantidade.length; i++) {
            quantidade[i] = (int) (split * base.getOutput().length * frequencia[i]);
//            System.out.println(base.getClasses().toArray()[i] + " : " + quantidade[i]);
        }

//        System.out.println("Classes Treinamento");
        //Arruma os dados para treinamento
        ArrayList<Object[]> arrayListInputTrain = new ArrayList<Object[]>();
        ArrayList<Object> arrayListOutputTrain = new ArrayList<Object>();
        boolean[] indiceEscolhido = new boolean[base.getOutput().length];
        for (int i = 0; i < base.getOutput().length; i++) {
            if (quantidade[classes.indexOf(base.getOutput()[i])] > 0) {
                arrayListInputTrain.add(base.getInput()[i]);
                arrayListOutputTrain.add(base.getOutput()[i]);
                quantidade[classes.indexOf(base.getOutput()[i])]--;
                indiceEscolhido[i] = true;
//                System.out.println(base.getOutput()[i]);
            }
        }

//        System.out.println("Classes Teste");
        //Arruma os dados para teste
        ArrayList<Object[]> arrayListInputTest = new ArrayList<Object[]>();
        ArrayList<Object> arrayListOutputTest = new ArrayList<Object>();
        for (int i = 0; i < base.getOutput().length; i++) {
            if (!indiceEscolhido[i]) {
                arrayListInputTest.add(base.getInput()[i]);
                arrayListOutputTest.add(base.getOutput()[i]);
//                System.out.println(base.getOutput()[i]);
            }
        }

        Base baseTrain = new Base();
        baseTrain.setAtributes(base.getAtributes());
        baseTrain.setInput((Object[][]) arrayListInputTrain.toArray(new Object[0][0]));
        baseTrain.setOutput(arrayListOutputTrain.toArray());

        Base baseTest = new Base();
        baseTest.setAtributes(base.getAtributes());
        baseTest.setInput((Object[][]) arrayListInputTest.toArray(new Object[0][0]));
        baseTest.setOutput(arrayListOutputTest.toArray());

        BaseClassify baseClassify[] = new BaseClassify[1];
        baseClassify[0] = new BaseClassify();
        baseClassify[0].setTest(baseTest);
        baseClassify[0].setTrain(baseTrain);


//        System.out.println("Quantidade de registros: " + base.getOutput().length);
//        System.out.println("Split: " + split);
//        System.out.println("Tamanho Treinamento: " + baseTrain.getOutput().length);
//        System.out.println("Tamanho Teste: " + baseTest.getOutput().length);

        return baseClassify;
    }
}
