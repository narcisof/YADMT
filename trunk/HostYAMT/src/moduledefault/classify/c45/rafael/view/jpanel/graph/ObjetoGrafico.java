/*
 * ObjetoGrafico.java
 *
 * Created on 19 de Mar�o de 2007, 10:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package moduledefault.classify.c45.rafael.view.jpanel.graph;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

/**Classe Interface que define m�todos basicos para as classes Vertice e Aresta
 @author Cassiano Cesar Casagrande*/
public interface ObjetoGrafico{
    /**m�todo para plotar componente na tela
     @param g2 contexto gr�fico*/
    public void plota(Graphics2D g2D);
    /**efetua transla��o sobre o objeto
     @param x delta x
     @param y delta y*/
    public void translacao(int x,int y);
    /**utilizado para atualizar componenetes graficos apos deserializacao*/
    public void atualizarGrafico();
    /**calcula o ret�ngulo que envolve ao objeto (a curva e o ponto de controle)
     @return o  retangulo que envolve o objeto*/
    public Rectangle getRetanguloEnvolveObjeto();
    public void setPropriedades(Propriedades p);
}
