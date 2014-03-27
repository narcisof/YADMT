/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.uteis;

import java.io.Serializable;

/**
 *
 * @author MateusFelipe
 */
public class ArquivoFormigas implements Serializable {

    int sigma;
    int sigmaMaximo;
    int sigmaMinimo;
    int sigmaControle;
    double alfa;
    double alfaMaximo;
    double alfaMinimo;
    double alfaControle;
    double fase;

    public ArquivoFormigas(int sigma, int sigmaMaximo, int sigmaMinimo, int sigmaControle, double alfa, double alfaMaximo, double alfaMinimo, double alfaControle, double fase) {
        this.sigma = sigma;
        this.sigmaMaximo = sigmaMaximo;
        this.sigmaMinimo = sigmaMinimo;
        this.sigmaControle = sigmaControle;
        this.alfa = alfa;
        this.alfaMaximo = alfaMaximo;
        this.alfaMinimo = alfaMinimo;
        this.alfaControle = alfaControle;
        this.fase = fase;
    }

    public int getSigma() {
        return sigma;
    }

    public int getSigmaMaximo() {
        return sigmaMaximo;
    }

    public int getSigmaMinimo() {
        return sigmaMinimo;
    }

    public int getSigmaControle() {
        return sigmaControle;
    }

    public double getAlfa() {
        return alfa;
    }

    public double getAlfaMaximo() {
        return alfaMaximo;
    }

    public double getAlfaMinimo() {
        return alfaMinimo;
    }

    public double getAlfaControle() {
        return alfaControle;
    }

    public double getFase() {
        return fase;
    }

    
}
