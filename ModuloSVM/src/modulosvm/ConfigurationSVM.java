/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modulosvm;

import java.util.Vector;

/**
 *
 * @author Adriano
 */
public class ConfigurationSVM {

    private int d;
    private boolean is_sparse_data;
    private boolean is_binary;
    private boolean is_linear_kernel;
    private boolean is_libsvm_file;
    private float b;
    private float c;
    private float tolerance;
    private float eps;
    private float two_sigma_squared;
    public Vector w = new Vector();
    public Vector alph = new Vector();

    /**
     * @return the d
     */
    public int getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(int d) {
        this.d = d;
    }

    /**
     * @return the is_sparse_data
     */
    public boolean isIs_sparse_data() {
        return is_sparse_data;
    }

    /**
     * @param is_sparse_data the is_sparse_data to set
     */
    public void setIs_sparse_data(boolean is_sparse_data) {
        this.is_sparse_data = is_sparse_data;
    }

    /**
     * @return the is_binary
     */
    public boolean isIs_binary() {
        return is_binary;
    }

    /**
     * @param is_binary the is_binary to set
     */
    public void setIs_binary(boolean is_binary) {
        this.is_binary = is_binary;
    }

    /**
     * @return the is_linear_kernel
     */
    public boolean isIs_linear_kernel() {
        return is_linear_kernel;
    }

    /**
     * @param is_linear_kernel the is_linear_kernel to set
     */
    public void setIs_linear_kernel(boolean is_linear_kernel) {
        this.is_linear_kernel = is_linear_kernel;
    }

    /**
     * @return the is_libsvm_file
     */
    public boolean isIs_libsvm_file() {
        return is_libsvm_file;
    }

    /**
     * @param is_libsvm_file the is_libsvm_file to set
     */
    public void setIs_libsvm_file(boolean is_libsvm_file) {
        this.is_libsvm_file = is_libsvm_file;
    }

    /**
     * @return the b
     */
    public float getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(float b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public float getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(float c) {
        this.c = c;
    }

    /**
     * @return the tolerance
     */
    public float getTolerance() {
        return tolerance;
    }

    /**
     * @param tolerance the tolerance to set
     */
    public void setTolerance(float tolerance) {
        this.tolerance = tolerance;
    }

    /**
     * @return the eps
     */
    public float getEps() {
        return eps;
    }

    /**
     * @param eps the eps to set
     */
    public void setEps(float eps) {
        this.eps = eps;
    }

    /**
     * @return the two_sigma_squared
     */
    public float getTwo_sigma_squared() {
        return two_sigma_squared;
    }

    /**
     * @param two_sigma_squared the two_sigma_squared to set
     */
    public void setTwo_sigma_squared(float two_sigma_squared) {
        this.two_sigma_squared = two_sigma_squared;
    }

    /**
     * @return the w
     */
    public Vector getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setW(Vector w) {
        this.w = w;
    }

    /**
     * @return the alph
     */
    public Vector getAlph() {
        return alph;
    }

    /**
     * @param alph the alph to set
     */
    public void setAlph(Vector alph) {
        this.alph = alph;
    }
}
