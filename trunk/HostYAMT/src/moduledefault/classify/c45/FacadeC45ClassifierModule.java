/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package moduledefault.classify.c45;

import javax.swing.JDialog;

/**
 *
 * @author evaristowb
 */
public class FacadeC45ClassifierModule {
    private static C45ClassifierModule c45ClassifyModule = null;

    private FacadeC45ClassifierModule(){
    }

    public static C45ClassifierModule getC45ClassifyModule() {
        return c45ClassifyModule;
    }

    public static void setC45ClassifyModule(C45ClassifierModule c45ClassifyModule) {
        FacadeC45ClassifierModule.c45ClassifyModule = c45ClassifyModule;
    }

    public static void setEntropy(double entropy){
        c45ClassifyModule.setEntropy(entropy);
    }

    public static double getEntropy(){
        return c45ClassifyModule.getEntropy();
    }

    public static void setScore(double score){
        c45ClassifyModule.setScore(score);
    }

    public static double getScore(){
        return c45ClassifyModule.getScore();
    }

    public static JDialog getJDialogConfig(){
        return c45ClassifyModule.getJDialogConfig();
    }
    
}
