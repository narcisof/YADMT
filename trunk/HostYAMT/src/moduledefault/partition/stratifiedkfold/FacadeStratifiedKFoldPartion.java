/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package moduledefault.partition.stratifiedkfold;

import moduledefault.evaluationmetric.accuracy.*;
import javax.swing.JDialog;

/**
 *
 * @author evaristowb
 */
public class FacadeStratifiedKFoldPartion {
    private static StratifiedKFoldPartionModule stratifiedKFoldPartionModule;

    public FacadeStratifiedKFoldPartion() {
    }

    /**
     * returns the StratifiedKFold partion module
     * @return
     */
    public static StratifiedKFoldPartionModule getHoudoutPartionModule() {
        return stratifiedKFoldPartionModule;
    }

    /**
     * sets the Houdout partion module
     * @param stratifiedKFoldPartionModule
     */
    public static void setHoudoutPartionModule(StratifiedKFoldPartionModule stratifiedKFoldPartionModule) {
        FacadeStratifiedKFoldPartion.stratifiedKFoldPartionModule = stratifiedKFoldPartionModule;
    }

    /**
     * returns the stratifiedKFold painel configuration
     * @return
     */
    public static JDialog getJDialogConfig(){
        return stratifiedKFoldPartionModule.getJDialogConfig();
    }

    /**
     * returns the k
     * @return
     */
    public static int getK(){
        return stratifiedKFoldPartionModule.getK();
    }

    /**
     * sets the k
     * @param k
     */
    public static void setK(int k){
        stratifiedKFoldPartionModule.setK(k);
    }
}
