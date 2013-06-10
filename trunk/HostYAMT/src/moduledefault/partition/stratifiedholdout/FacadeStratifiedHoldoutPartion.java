/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package moduledefault.partition.stratifiedholdout;

import javax.swing.JDialog;

/**
 *
 * @author evaristowb
 */
public class FacadeStratifiedHoldoutPartion {
    private static StratifiedHoldoutPartionModule stratifiedHoldoutPartionModule;

    public FacadeStratifiedHoldoutPartion() {
    }

    public static StratifiedHoldoutPartionModule getHoudoutPartionModule() {
        return stratifiedHoldoutPartionModule;
    }

    public static void setHoudoutPartionModule(StratifiedHoldoutPartionModule holdoutPartionModule) {
        FacadeStratifiedHoldoutPartion.stratifiedHoldoutPartionModule = holdoutPartionModule;
    }

    /**
     * returns the frame configuration
     * @return
     */
    public static JDialog getJDialogConfig(){
        return stratifiedHoldoutPartionModule.getJDialogConfig();
    }

    /**
     * returns the split
     * @return
     */
    public static double getSplit(){
        return stratifiedHoldoutPartionModule.getSplit();
    }

    /**
     * sets the split
     * @param split
     */
    public static void setSplit(double split){
        stratifiedHoldoutPartionModule.setSplit(split);
    }
}
