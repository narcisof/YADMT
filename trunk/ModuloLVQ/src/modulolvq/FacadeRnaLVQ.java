/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modulolvq;

import javax.swing.JDialog;
import rna.redes.LVQ;

/**
 *
 * @author Fernando
 */
public class FacadeRnaLVQ {
    private static ModuloLVQ moduloLVQ;

    public static ModuloLVQ getModuloLVQ() {
        return moduloLVQ;
    }

    public static void setModuloLVQ(ModuloLVQ moduloLVQ) {
        FacadeRnaLVQ.moduloLVQ = moduloLVQ;
    }
    
    public static double getTxAprendizado(){
        return moduloLVQ.getTaxaAprendizado();
    }
    
    public static int getEpocas(){
        return moduloLVQ.getEpocas();
    }    

    public static void setTxAprendizado(double aprendizado){
        moduloLVQ.setTaxaAprendizado(aprendizado);
    }
    
    public static void setEpocas(int epocas){
        moduloLVQ.setEpocas(epocas);
    }


    public  static JDialog getJDialogConfig(){
        return moduloLVQ.getJDialogConfig();
    }

    public static int getTamanhoCamadaOculta() {
        return moduloLVQ.getTamanhoCamadaOculta();
    }
    
    public static void setTamanhoCamadaOculta(int n) {
        moduloLVQ.setTamanhoCamadaOculta(n);
    }

    public static double getTxReducao() {
        return moduloLVQ.getTaxaReducao();
    }

    public static void setTxReducao(double tx) {
        moduloLVQ.setTaxaReducao(tx);
    }

    public static String[] getInicializacoesPeso(){
        String[] aux={LVQ.INICIALIZACAO_KMeans};
        return aux;
    }

    static void setInicializacaoPeso(String string) {
        moduloLVQ.setInicializacaoPeso(string);
    }
}
