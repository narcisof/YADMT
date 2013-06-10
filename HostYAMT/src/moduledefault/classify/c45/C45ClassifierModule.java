/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package moduledefault.classify.c45;

import annotations.ClassifierModuleAnnotation;
import annotations.ModuleAnnotation;
import interfaces.HostInterface;
import interfaces.mining.classify.ClassifierModuleInterface;
import java.util.Collection;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import moduledefault.classify.c45.rafael.AD;
import moduledefault.classify.c45.rafael.view.jpanel.JPConfiguraAD;
import moduledefault.classify.c45.rafael.view.jpanel.JPResultadoADGrafico;

/**
 *
 * @author evaristowb
 */
@ModuleAnnotation(name = "C4.5")
@ClassifierModuleAnnotation
public class C45ClassifierModule implements ClassifierModuleInterface {
    private double entropy          = 0.1;
    private double score            = 0.0;
    private AD ad                   = null;
    private HostInterface hi        = null;
    private JDialog jDialogConfig   = null;
    private JTextArea jTextArea     = null;

    public C45ClassifierModule(){
        FacadeC45ClassifierModule.setC45ClassifyModule(this);
    }

    public JPanel getPainelConfig() {
        return new JPConfiguraAD();
    }

    public void setJDialogConfig(JDialog jDialogConfig) {
        this.jDialogConfig = jDialogConfig;
    }

    public void setTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public JPanel getCreatedModel() {
        JPResultadoADGrafico jPResultadoADGrafico = new JPResultadoADGrafico();
        jPResultadoADGrafico.inicializaInterface(ad);
        return jPResultadoADGrafico;
    }
/*
    public void train(Object[][] input, Object[] output) {
        //ad = new AD(facadeSwing.getPrevia().getRafaelJTable1().getColumnIdentifiers(), entropy, score, jRHoldOut.isSelected());

        //Incluido POR EVARISTO somente para adequação
        double mi[][] = new double[input.length][input[0].length];
        for(int i =0;i<input.length;i++)
            for(int j=0;j<input[0].length;j++)
                mi[i][j] = Double.parseDouble(input[i][j].toString());

        double mo[][] = new double[output.length][1];
        for(int i =0;i<output.length;i++)
            mo[i][0] = Double.parseDouble(output[i].toString());

//        long tempoinicial = System.currentTimeMillis();

        ad.treinar(mi, mo);
        //ad.treinar(facadeSwing.getInput(), facadeSwing.getOutput());
        //FIM alteração

//        long tempofinal = System.currentTimeMillis();
//        long tempo = tempofinal - tempoinicial;
//        //System.out.println(util.Util.getHoraMinSegMiliSeg(tempo));

//        facadeSwing.inicializaInterface();
//        facadeSwing.setEnabledAtJPAbas(JPanelTabbed.jPTeste, true);
//        facadeSwing.setEnabledAtJPAbas(JPanelTabbed.jPEstatisticas, true);
//        facadeSwing.setEnabledAtJPAbas(JPanelTabbed.jPResultadoAlgoritmo, true);
//        facadeSwing.setEnabledAtJPAbas(JPanelTabbed.jPTeste, true);
//        facadeSwing.setSelectedIndex(JPanelTabbed.jPResultadoAlgoritmo);
//        facadeSwing.getJPEstatisticas().setTempo(util.Util.getHoraMinSegMiliSeg(tempo));

        jTextArea.append(ad.getArvoreString());
    }
 */
        public void train(Object[][] input, Object[] output) {
        //ad = new AD(facadeSwing.getPrevia().getRafaelJTable1().getColumnIdentifiers(), entropy, score, jRHoldOut.isSelected());

//        //Incluido POR EVARISTO somente para adequação
//        double mi[][] = new double[input.length][input[0].length];
//        for(int i =0;i<input.length;i++)
//            for(int j=0;j<input[0].length;j++)
//                mi[i][j] = Double.parseDouble(input[i][j].toString());
//
//        double mo[][] = new double[output.length][1];
//        for(int i =0;i<output.length;i++)
//            mo[i][0] = Double.parseDouble(output[i].toString());
//
////        long tempoinicial = System.currentTimeMillis();

//        ad.treinar(mi, mo);
        ad.treinar(input, output);
        //ad.treinar(facadeSwing.getInput(), facadeSwing.getOutput());
        //FIM alteração

//        long tempofinal = System.currentTimeMillis();
//        long tempo = tempofinal - tempoinicial;
//        //System.out.println(util.Util.getHoraMinSegMiliSeg(tempo));

//        facadeSwing.inicializaInterface();
//        facadeSwing.setEnabledAtJPAbas(JPanelTabbed.jPTeste, true);
//        facadeSwing.setEnabledAtJPAbas(JPanelTabbed.jPEstatisticas, true);
//        facadeSwing.setEnabledAtJPAbas(JPanelTabbed.jPResultadoAlgoritmo, true);
//        facadeSwing.setEnabledAtJPAbas(JPanelTabbed.jPTeste, true);
//        facadeSwing.setSelectedIndex(JPanelTabbed.jPResultadoAlgoritmo);
//        facadeSwing.getJPEstatisticas().setTempo(util.Util.getHoraMinSegMiliSeg(tempo));

        jTextArea.append(ad.getArvoreString());
    }
/*
    public Object test(Object[] inputTest) {
        double o[] = new double[inputTest.length];
        for(int i =0;i<inputTest.length;i++)
            o[i] = Double.parseDouble(inputTest[i].toString());
        return (int)ad.testar(o)[0];
    }
 */
/*
    public Object test(Object[] inputTest) {
        double o[] = new double[inputTest.length];
        for(int i =0;i<inputTest.length;i++)
            o[i] = Double.parseDouble(inputTest[i].toString());
        return ad.testar(o);
    }
 */

    public Object test(Object[] inputTest) {
//        double o[] = new double[inputTest.length];
//        for(int i =0;i<inputTest.length;i++)
//            o[i] = Double.parseDouble(inputTest[i].toString());
        return ad.testar(inputTest);
    }

    public ClassifierModuleInterface clone(){
        try {
            return (ClassifierModuleInterface) super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    public void setHost(HostInterface hostInterface) {
        hi = hostInterface;
    }

    public double getEntropy() {
        return entropy;
    }

    public void setEntropy(double entropy) {
        this.entropy = entropy;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public JDialog getJDialogConfig(){
        return jDialogConfig;
    }

    public void createInstanceClissify(String[] attributes, Collection classes) {
        jTextArea.append("C4.5");

        Vector vector = new Vector();
        for(String str : attributes)
            vector.add(str);
        ad = new AD(vector, entropy, score/*, false*/);
    }

    public JTextArea getJTextArea() {
        return jTextArea;
    }

}
