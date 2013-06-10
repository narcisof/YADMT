package rna.basico;

public class NeuronioDeKohonen {
    private double[] pesos;
    private int classe;
   

    public NeuronioDeKohonen(int nroPesos, int classe) {
        this.classe = classe;
        pesos = new double[nroPesos];
    }

    public double[] getPesos() {
        return pesos;
    }

    public void setPesos(double[] pesos) {
        this.pesos = pesos;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public void atualizarPesos(double[] delta){
        for (int i= 0; i < delta.length; i++) {
            pesos[i]+=delta[i];
            if(pesos[i]>1.0){
                pesos[i]=1.0;
            }
            if(pesos[i]<0.0){
                pesos[i]=0.0;
            }            
        }
    }
}
