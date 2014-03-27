/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.classify.committee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import moduledefault.classify.committee.view.jpanel.ClassifierModuleConfig;

/**
 *
 * @author tiago.sippert
 */
public class Committee {
    
    private static final String VOTING_STRUCTURE = "Votação";
    private static final String BAGGING_STRUCTURE = "Média do Conjunto (Bagging)";
    private static final String BOOSTING_STRUCTURE = "Impulso (Boosting)";
    public static final String[] STRUCTURE_FUNCTION = {VOTING_STRUCTURE,BAGGING_STRUCTURE, BOOSTING_STRUCTURE};
    
    public static String default_structure_function = VOTING_STRUCTURE;
    
    public static List<ClassifierModuleConfig> classifiers;
    
    private List input;
    private List output;

    public Committee() {
        input = new ArrayList();
        output = new ArrayList();
    }

    public void train(Object[][] input, Object[] output) {
        for (ClassifierModuleConfig classifierModuleConfig : classifiers) {
            classifierModuleConfig.classifierModule.train(input, output);
        }
    }

    public Object test(Object[] input) {
        
        HashMap<Object,Integer> votos = new HashMap<Object, Integer>();
        for (ClassifierModuleConfig classifierModuleConfig : classifiers) {
            Object classe = classifierModuleConfig.classifierModule.test(input);
            votos.put(classe, votos.get(classe)!=null ? votos.get(classe)+1 : 1);
        }
        
        Object maisVotado = null;
        Integer maisVotadoCount = 0;
        
        for (Object object : votos.keySet()) {
            if(votos.get(object) > maisVotadoCount){
                maisVotadoCount= votos.get(object);
                maisVotado = object;
            }
        }
        
        return maisVotado;
    }

    private Object vooting(Object[] classes, Object[] choises, Object[] weights) {
        //iterar e descobrir qual é o choise que foi mais escolhido, contando os pesos de cada classe
        return new Object();
    }
    
    public String getStructureFunction(){
        return default_structure_function;
    }
    
    public void setStructureFunction(String structureFunction){
        default_structure_function = structureFunction;
    }

    public List<ClassifierModuleConfig> getClassifiers() {
        return classifiers;
    }

    public void setClassifiers(List<ClassifierModuleConfig> classifiers) {
        Committee.classifiers = classifiers;
    }

}
