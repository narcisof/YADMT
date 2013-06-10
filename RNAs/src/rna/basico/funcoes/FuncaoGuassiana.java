package rna.basico.funcoes;

public class FuncaoGuassiana implements FuncaoBaseRadial{
    private double largura;
    private double[] centro;

    public FuncaoGuassiana(double largura, double[] centro) {        
        this.largura = largura;
        this.centro = centro;
    }

    public double[] getCentro() {
        return centro;
    }

    public void setCentro(double[] centro) {
        this.centro = centro;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double calcular(double[] valor) {
        //calcula o valor da funcao gaussiana
        // f(x) = altura*e^-(||entrada - centro||^2/2*largura^2)

        double distanciaEuclidiana = 0;
        for(int i=0; i< valor.length; i++){
            distanciaEuclidiana+= (valor[i]-centro[i])*(valor[i]-centro[i]);
        }
        distanciaEuclidiana = Math.sqrt(distanciaEuclidiana);
        double denominador = 2.0*largura*largura;
        //System.out.println("euclidiana: "+ distanciaEuclidiana);
        //System.out.println("denominador: "+ denominador);

        return Math.exp(-((distanciaEuclidiana*distanciaEuclidiana)/denominador));
        
    }

}
