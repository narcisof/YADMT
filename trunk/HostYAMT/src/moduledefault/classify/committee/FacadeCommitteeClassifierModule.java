package moduledefault.classify.committee;

import java.util.List;
import javax.swing.JDialog;
import moduledefault.classify.committee.view.jpanel.ClassifierModuleConfig;

/**
 *
 * @author tiago.sippert
 */
public class FacadeCommitteeClassifierModule {
    private static CommitteeClassifierModule committeeClassifierModule;

    private FacadeCommitteeClassifierModule() {
    }

    public static CommitteeClassifierModule getCommitteeClassifierModule() {
        return committeeClassifierModule;
    }

    public static void setCommitteeClassifierModule(CommitteeClassifierModule committeeClassifierModule) {
        FacadeCommitteeClassifierModule.committeeClassifierModule = committeeClassifierModule;
    }

    public static JDialog getJDialogConfig(){
        return committeeClassifierModule.getJDialogConfig();
    }

    public static String getStructureFunction() {
        return committeeClassifierModule.getStructureFunction();
    }

    public static void setStructureFunction(String structureFunction) {
        committeeClassifierModule.setStructureFunction(structureFunction);
    }
    
    public static void setClassifiers(List<ClassifierModuleConfig> classifiers){//TODO passar o classificador inteiro (modulo aqui)
        committeeClassifierModule.setClassifiers(classifiers);
    }
    
    public static List<ClassifierModuleConfig> getClassifiers(){
        return committeeClassifierModule.getClassifiers();
    }    
    
}
