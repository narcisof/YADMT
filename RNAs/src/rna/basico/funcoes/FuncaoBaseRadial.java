/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rna.basico.funcoes;

/**
 *
 * @author MASTERUSER
 */
public interface FuncaoBaseRadial {
    public static final String FUNCAO_GAUSSIANA = "Função Guassiana";
    public static final String LARGURA_MetadeMenorDistancia = "Metade Menor Distância";

    public double[] getCentro();
    public void setCentro(double[] centro);
    public double getLargura();
    public void setLargura(double largura);
    public double calcular(double[] valor);

}
