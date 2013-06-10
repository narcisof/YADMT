package rna.basico;

import rna.basico.funcoes.FuncaoGuassiana;

public class NeuronioGuassiano {    
    FuncaoGuassiana funcaoGaussiana;
    public NeuronioGuassiano() {
        funcaoGaussiana = new FuncaoGuassiana(0, null);
    }

    public NeuronioGuassiano(FuncaoGuassiana funcaoGaussiana) {
        this.funcaoGaussiana = funcaoGaussiana;
    }

    public double calcOutput(double[] entrada) {
       // System.out.println(funcaoGaussiana.calcular(entrada));
        return funcaoGaussiana.calcular(entrada);
    }

    public double getLargura(){
        return funcaoGaussiana.getLargura();
    }
    
    public double[] getCentro(){
        return funcaoGaussiana.getCentro();
    }
    
    public void setLargura(double largura){
        funcaoGaussiana.setLargura(largura);
    }
    
    public void setCentro(double[] centro){
        funcaoGaussiana.setCentro(centro);
    }    
}
