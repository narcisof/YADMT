/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modulomlp;

import javax.swing.JDialog;

/**
 *
 * @author Fernando
 */
public class FacadeRnaMLP {
    private static ModuloMLP moduloMLP;

    public static ModuloMLP getModuloMLP() {
        return moduloMLP;
    }

    public static void setModuloMLP(ModuloMLP moduloMLP) {
        FacadeRnaMLP.moduloMLP = moduloMLP;
    }

    public static double getMomento(){
        return moduloMLP.getMomento();
    }
    
    public static double getTxAprendizado(){
        return moduloMLP.getTaxaAprendizado();
    }
    
    public static int getEpocas(){
        return moduloMLP.getEpocas();
    }
    
    public static void  setMomento(double momento){
        moduloMLP.setMomento(momento);
    }

    public static void setTxAprendizado(double aprendizado){
        moduloMLP.setTaxaAprendizado(aprendizado);
    }
    
    public static void setEpocas(int epocas){
        moduloMLP.setEpocas(epocas);
    }


    public  static JDialog getJDialogConfig(){
        return moduloMLP.getJDialogConfig();
    }

    public static double getErroMinimo() {
        return moduloMLP.getErroMinimo();
    }

    public static void setErroMinimo(double erroM) {
        moduloMLP.setErroMinimo(erroM);
    }

    public static String getNeuroniosCamada() {
        return moduloMLP.getNeuroniosCamada();
    }
    
    public static void setNeuroniosCamada(String neuroniosC) {
        moduloMLP.setNeuroniosCamada(neuroniosC);
    }

    public static String[] getFuncoesAtivacao(){
        return moduloMLP.getFuncoesAtivacao();
    }

    public static void setFuncaoAtivacao(String string) {
        moduloMLP.setFuncaoAtivacao(string);
    }
}
