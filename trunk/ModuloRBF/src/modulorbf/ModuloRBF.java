package modulorbf;

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
import rna.basico.funcoes.FuncaoAtivacao;
import rna.basico.funcoes.FuncaoBaseRadial;
import rna.basico.funcoes.FuncaoGuassiana;
import rna.redes.RBF;


@ModuleAnnotation(name = "RNA Radial Basis Function - RBF")
@ClassifierModuleAnnotation
public class ModuloRBF implements Serializable, ClassifierModuleInterface {

    private int tamanhoOculta = 5;
    private double taxaAprendizado = 0.8;
    private int epocas = 500;
    private double erroMinimo = 0.01;
    
    private String funcaoAtivacao = FuncaoGuassiana.FUNCAO_GAUSSIANA;
    private String larguraAtivacao = FuncaoGuassiana.LARGURA_MetadeMenorDistancia;
    
    private JTextArea jTextArea = null;
    private transient JDialog jDialogConfig = null;
    private transient HostInterface hostInterface;
    private RBF rbf;
    private ArrayList classes;


    public ModuloRBF() {
        FacadeRnaRBF.setModuloRBF(this);
    }

    public JPanel getPainelConfig() {
        return new JPanelRnaRBF();
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

        //treina a rede
        innerTrain(mappedInput, mappedOutput);
    }

    private void innerTrain(double[][] input, double[][] output) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(10);
        df.setMinimumFractionDigits(10);

        rbf.treinarCamadaOculta(input,larguraAtivacao);

        double mse = 0.0;
        for (int i = 0; i < epocas; i++) {
            jTextArea.append("Epoca: " + i + "\n");
            for (int j = 0; j < input.length; j++) {//
                //bc.treinar(input[j], output[j]);
                rbf.treinarCamadaSaida(input[j], output[j], taxaAprendizado);
                //double[] saida = rbf.calcular(input[j]);
                double[] saida = rbf.calcSaida(input[j]);
                mse += Util.erroQuadratico(saida, output[j]);
            }
            mse = mse / input.length;
            jTextArea.append("Erro (mse): " + df.format(mse) + "\n");
            if(mse<erroMinimo) break;
        }
    }

    public Object test(Object[] inputTest) {        
        //faz o mapeamento para double
        double[] entrada = new double[inputTest.length];
        for (int k = 0; k < entrada.length; k++) {
            //System.out.println("entrada teste"+ inputTest[k].toString());
            entrada[k] = Double.parseDouble(inputTest[k].toString());
        }
        double[] saida = rbf.calcSaida(entrada);

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
            Logger.getLogger(ModuloRBF.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void createInstanceClissify(String[] attributes, Collection classes) {
        jTextArea.append(" RBF - Radial Basis Function (" + ""+(attributes.length - 1)+", " + tamanhoOculta + ", " + classes.size() + ")");
        rbf = new RBF(attributes.length - 1, tamanhoOculta, classes.size(), funcaoAtivacao);
        this.classes = (ArrayList) classes;
    }

    public JTextArea getJTextArea() {
        return jTextArea;
    }

    public double getErroMinimo() {
        return erroMinimo;
    }

    public void setErroMinimo(double erroM) {
        erroMinimo = erroM;
    }

    public int getTamanhoOculta() {
        return tamanhoOculta;
    }

    public void setTamanhoOculta(int n) {        
        tamanhoOculta = n;
    }

    public String[] getFuncoesAtivacao() {
        String[] funcoes = {FuncaoBaseRadial.FUNCAO_GAUSSIANA};
        return funcoes;
    }

    public String[] getLargurasAtivacao() {
        String[] funcoes = {FuncaoGuassiana.LARGURA_MetadeMenorDistancia};
        return funcoes;
    }

    void setFuncaoAtivacao(String string) {
        funcaoAtivacao = string;
    }

    void setLarguraAtivacao(String string) {
        larguraAtivacao = string;
    }
}
