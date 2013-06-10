/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.model.beans;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Cassiano
 */
public class ConfiguracaoRede implements Serializable {

    public static final int MIN_N_NEURO_SAIDA = 2;
    public static final int MAX_N_CAMADA_HIDDEN = 3;
    public static final int MIN_N_CAMADA_NHIDDEN = 1;
    //
    private int nCamadaHidden;
    private int nNeuroCamadaEntrada;
    private int nNeuroCamadaSaida;
    private int nNeuroCamadaHidden1;
    private int nNeuroCamadaHidden2;
    private int nNeuroCamadaHidden3;
    //
    private int learningMode;//{0,1,2}
    private double learningRate;
    private double momentum;
    private double erro;
    private int epochs;
    private int epochsView;

    public int getEpochs() {
        return epochs;
    }

    public void setEpochs(int epochs) {
        this.epochs = epochs;
    }

    public int getEpochsView() {
        return epochsView;
    }

    public void setEpochsView(int epochsView) {
        this.epochsView = epochsView;
    }

    public double getErro() {
        return erro;
    }

    public void setErro(double erro) {
        this.erro = erro;
    }

    public int getLearningMode() {
        return learningMode;
    }

    public void setLearningMode(int learningMode) {
        this.learningMode = learningMode;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public double getMomentum() {
        return momentum;
    }

    public void setMomentum(double momentum) {
        this.momentum = momentum;
    }
    /**armazena os caracteres e seus codigos (inteiro e binario);
    cada posição deste vetor possui um outro vector com três posições (caracter(String), inteiro(String) e binario(String))*/
    private Vector caracterCodigo;

    public void ConfiguracaoRede() {
        nNeuroCamadaEntrada = 100;
        nNeuroCamadaSaida = 8;
        nCamadaHidden = 1;
        nNeuroCamadaHidden1 = 20;
        nNeuroCamadaHidden2 = 0;
        nNeuroCamadaHidden3 = 0;
        caracterCodigo = new Vector();
    }

    public int getNNeuroCamadaEntrada() {
        return nNeuroCamadaEntrada;
    }

    public void setNNeuroCamadaEntrada(int nNeuroCamadaEntrada) {
        this.nNeuroCamadaEntrada = nNeuroCamadaEntrada;
    }

    public int getNNeuroCamadaSaida() {
        return nNeuroCamadaSaida;
    }

    public void setNNeuroCamadaSaida(int nNeuroCamadaSaida) {
        this.nNeuroCamadaSaida = nNeuroCamadaSaida;
    }

    public int getNCamadaHidden() {
        return nCamadaHidden;
    }

    public void setNCamadaHidden(int nCamadaHidden) {
        this.nCamadaHidden = nCamadaHidden;
    }

    public int getNNeuroCamadaHidden1() {
        return nNeuroCamadaHidden1;
    }

    public void setNNeuroCamadaHidden1(int nNeuroCamadaHidden1) {
        this.nNeuroCamadaHidden1 = nNeuroCamadaHidden1;
    }

    public int getNNeuroCamadaHidden2() {
        return nNeuroCamadaHidden2;
    }

    public void setNNeuroCamadaHidden2(int nNeuroCamadaHidden2) {
        this.nNeuroCamadaHidden2 = nNeuroCamadaHidden2;
    }

    public int getNNeuroCamadaHidden3() {
        return nNeuroCamadaHidden3;
    }

    public void setNNeuroCamadaHidden3(int nNeuroCamadaHidden3) {
        this.nNeuroCamadaHidden3 = nNeuroCamadaHidden3;
    }

    public Vector getCaracterCodigo() {
        return caracterCodigo;
    }

    public void setCaracterCodigo(Vector caracterCodigo) {
        this.caracterCodigo = caracterCodigo;
    }
}
