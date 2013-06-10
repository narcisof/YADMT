/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modulosvm;

import javax.swing.JDialog;

/**
 *
 * @author Adriano
 */
public class FacadeSVM {
    private static ModuloSVM moduloSVM;

    public static ModuloSVM getModuloMLP() {
        return moduloSVM;
    }

    public static void setModuloSVM(ModuloSVM moduloSVM) {
        FacadeSVM.moduloSVM = moduloSVM;
    }

    public static double getC(){
        return moduloSVM.getC();
    }
    
    public static void  setC(double c){
        moduloSVM.setC(c);
    }

    public static double getEps(){
        return moduloSVM.getEps();
    }

    public static void  setEps(double eps){
        moduloSVM.setEps(eps);
    }

    public static double getTolerance(){
        return moduloSVM.getTolerance();
    }

    public static void  setTolerance(double tolerance){
        moduloSVM.setTolerance(tolerance);
    }

    public static double getSigma(){
        return moduloSVM.getTwo_sigma_squared();
    }

    public static void  setSigma(double sigma){
        moduloSVM.setTwo_sigma_squared(sigma);
    }

    public static boolean getIs_binary(){
        return moduloSVM.getIs_binary();
    }

    public static void  setIsBinary(boolean is_binary){
        moduloSVM.setIs_binary(is_binary);
    }

    public static boolean getIsLinearKernel(){
        return moduloSVM.getIs_linear_kernel();
    }

    public static void setIsLinearKernel(boolean is_linear_kernel){
        moduloSVM.setIs_linear_kernel(is_linear_kernel);
    }

    public static boolean getIsEsparceData(){
        return moduloSVM.getIs_sparse_data();
    }

    public static void setIsEsparceData(boolean is_esparse_data){
        moduloSVM.setIs_sparse_data(is_esparse_data);
    }

    public  static JDialog getJDialogConfig(){
        return moduloSVM.getJDialogConfig();
    }
}
