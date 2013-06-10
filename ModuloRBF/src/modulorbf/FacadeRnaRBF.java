/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modulorbf;

import javax.swing.JDialog;

/**
 *
 * @author Fernando
 */
public class FacadeRnaRBF {
    private static ModuloRBF moduloRBF;

    public static ModuloRBF getModuloRBF() {
        return moduloRBF;
    }

    public static void setModuloRBF(ModuloRBF moduloRBF) {
        FacadeRnaRBF.moduloRBF = moduloRBF;
    }

    
    
    public static double getTxAprendizado(){
        return moduloRBF.getTaxaAprendizado();
    }
    
    public static int getEpocas(){
        return moduloRBF.getEpocas();
    }    

    public static void setTxAprendizado(double aprendizado){
        moduloRBF.setTaxaAprendizado(aprendizado);
    }
    
    public static void setEpocas(int epocas){
        moduloRBF.setEpocas(epocas);
    }


    public  static JDialog getJDialogConfig(){
        return moduloRBF.getJDialogConfig();
    }

    public static double getErroMinimo() {
        return moduloRBF.getErroMinimo();
    }

    public static void setErroMinimo(double erroM) {
        moduloRBF.setErroMinimo(erroM);
    }

    public static int getNeuroniosCamadaOculta() {
        return moduloRBF.getTamanhoOculta();
    }
    
    public static void setNeuroniosCamadaOculta(int n) {
        moduloRBF.setTamanhoOculta(n);
    }

    public static String[] getFuncoesAtivacao(){
        return moduloRBF.getFuncoesAtivacao();
    }

    public static String[] getLargurasAtivacao(){
        return moduloRBF.getLargurasAtivacao();
    }

    public static void setFuncaoAtivacao(String string) {
        moduloRBF.setFuncaoAtivacao(string);
    }

    public static void setLarguraAtivacao(String string) {
        moduloRBF.setLarguraAtivacao(string);
    }
}
