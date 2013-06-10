package modulolvq;

import annotations.ClassifierModuleAnnotation;
import annotations.ModuleAnnotation;
import interfaces.HostInterface;
import interfaces.mining.classify.ClassifierModuleInterface;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import rna.redes.LVQ;



@ModuleAnnotation(name = "RNA Learning Vector Quantization - LVQ")
@ClassifierModuleAnnotation
public class ModuloLVQ implements Serializable, ClassifierModuleInterface {

    private int tamanhoOculta = 5;
    private double taxaAprendizado = 0.8;
    private int epocas = 500;
    private double txReducao = 0.01;
    
    private String inicilizacaoPesos = LVQ.INICIALIZACAO_KMeans;
    
    
    private JTextArea jTextArea = null;
    private transient JDialog jDialogConfig = null;
    private transient HostInterface hostInterface;
    private LVQ lvq;
    private ArrayList classes;


    public ModuloLVQ() {
        FacadeRnaLVQ.setModuloLVQ(this);
    }

    public JPanel getPainelConfig() {
        return new JPanelRnaLVQ();
    }

    public void setJDialogConfig(JDialog jDialogConfig) {
        this.jDialogConfig = jDialogConfig;
    }

    public JDialog getJDialogConfig() {
        return jDialogConfig;
    }

    public void setTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public JPanel getCreatedModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setHost(HostInterface hostInterface) {
        this.hostInterface = hostInterface;
    }

    public int getEpocas() {
        return epocas;
    }

    public void setEpocas(int epocas) {
        this.epocas = epocas;
    }    
    
    public double getTaxaAprendizado() {
        return taxaAprendizado;
    }

    public void setTaxaAprendizado(double taxaAprendizado) {
        this.taxaAprendizado = taxaAprendizado;
    }

    public void train(Object[][] input, Object[] output) {
        //passa os dados de entrada para double
        double[][] mappedInput = new double[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                mappedInput[i][j] = Double.parseDouble(input[i][j].toString());
            }
        }

        //passa os dados de saida para double
        double[][] mappedOutput = new double[output.length][classes.size()];
        for (int i = 0; i < output.length; i++) {
            mappedOutput[i][classes.indexOf(output[i])] = 1;
        }

        if(inicilizacaoPesos.compareTo(LVQ.INICIALIZACAO_KMeans)==0){
            lvq.inicializarKMeans(mappedInput);
        }
        //treina a rede
        innerTrain(mappedInput, mappedOutput);
    }

    private void innerTrain(double[][] input, double[][] output) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(10);
        df.setMinimumFractionDigits(10);

        lvq.treinar(input, output, epocas, taxaAprendizado, txReducao);        
    }

    public Object test(Object[] inputTest) {        
        //faz o mapeamento para double
        double[] entrada = new double[inputTest.length];
        for (int k = 0; k < entrada.length; k++) {
            //System.out.println("entrada teste"+ inputTest[k].toString());
            entrada[k] = Double.parseDouble(inputTest[k].toString());
        }
        double[] saida = lvq.calcSaida(entrada);

        double aux[][] = new double[classes.size()][classes.size()];
        for (int i = 0; i < classes.size(); i++) {
            aux[i][i] = 1.0;
        }

        double menorDistancia = Double.MAX_VALUE;
        int ind = -1;
        for (int i= 0; i < classes.size(); i++) {
            if(Util.distanciaEuclidiana(saida, aux[i])<menorDistancia){
                ind = i;
                menorDistancia = Util.distanciaEuclidiana(saida, aux[i]);
            }
        }
        return classes.get(ind);
    }

    @Override
    public ClassifierModuleInterface clone() {
        try {
            return (ClassifierModuleInterface) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ModuloLVQ.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void createInstanceClissify(String[] attributes, Collection classes) {
        jTextArea.append(" LVQ - Learning Vector Quantization (" + ""+(attributes.length - 1)+", " + tamanhoOculta + ", " + classes.size() + ")");
        lvq = new LVQ(attributes.length - 1, tamanhoOculta, classes.size());
        this.classes = (ArrayList) classes;
    }

    public JTextArea getJTextArea() {
        return jTextArea;
    }

    

    public int getTamanhoCamadaOculta() {
        return tamanhoOculta;
    }

    public void setTamanhoCamadaOculta(int n) {
        tamanhoOculta = n;
    }
    
    public double getTaxaReducao() {
        return txReducao;
    }

    void setTaxaReducao(double tx) {
        txReducao = tx;
    }

    void setInicializacaoPeso(String string) {
        inicilizacaoPesos = string;
    }
}
