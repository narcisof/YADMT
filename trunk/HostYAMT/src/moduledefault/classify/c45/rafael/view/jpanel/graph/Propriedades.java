/*
 * Propriedades.java
 *
 * Created on 21 de Maio de 2007, 11:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package moduledefault.classify.c45.rafael.view.jpanel.graph;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author cccasagrande
 */
public class Propriedades implements Serializable {
    //vertice
    private int raio;
    private int espessuraVertice;
    private Color corVertices[];
    //aresta
    private Color corAresta;
    private int deslocamentoOrigem;
    private int espessuraAresta;
    private Color corSelecao;
    private int ladoQuadrado;
    private int arcoCurvatura;
    //fonte
    private Color corFonte;
    private int tamanhoFonte;
    private String tipoFonte;
    private int estiloFonte;

    /** Creates a new instance of Propriedades */
    public Propriedades() {
        raio = 20;
        espessuraVertice = 4;
        corVertices = new Color[13];
        corVertices[0] = Color.LIGHT_GRAY;
        corVertices[1] = new Color(0, 117, 0);
        corVertices[2] = new Color(27, 44, 210);
        corVertices[3] = new Color(10, 107, 20);
        corVertices[4] = new Color(238, 139, 22);
        corVertices[5] = new Color(204, 204, 0);

        corVertices[6] = new Color(0, 204, 204);
        corVertices[7] = new Color(101, 196, 101);
        corVertices[8] = new Color(163, 119, 43);
        corVertices[9] = new Color(251, 210, 138); //
        corVertices[10] = new Color(189, 189, 249);
        corVertices[11] = new Color(198, 238, 35);
        corVertices[12] = new Color(242, 21, 139);

        corAresta = new Color(255, 186, 28);
        deslocamentoOrigem = 30;
        espessuraAresta = 2;
        corSelecao = new Color(69, 138, 34);
        ladoQuadrado = 16;
        arcoCurvatura = 10;

        corFonte = Color.darkGray;
        tipoFonte = "Courier New";
        tamanhoFonte = 12;
        estiloFonte = 0;

    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public int getEspessuraVertice() {
        return espessuraVertice;
    }

    public void setEspessuraVertice(int espessuraVertice) {
        this.espessuraVertice = espessuraVertice;
    }

    public Color[] getCorVertices() {
        return corVertices;
    }

    public void setCorVertices(Color[] corVertices) {
        this.corVertices = corVertices;
    }

    public Color getCorAresta() {
        return corAresta;
    }

    public void setCorAresta(Color corAresta) {
        this.corAresta = corAresta;
    }

    public int getDeslocamentoOrigem() {
        return deslocamentoOrigem;
    }

    public void setDeslocamentoOrigem(int deslocamentoOrigem) {
        this.deslocamentoOrigem = deslocamentoOrigem;
    }

    public int getEspessuraAresta() {
        return espessuraAresta;
    }

    public void setEspessuraAresta(int espessuraAresta) {
        this.espessuraAresta = espessuraAresta;
    }

    public Color getCorSelecao() {
        return corSelecao;
    }

    public void setCorSelecao(Color corSelecao) {
        this.corSelecao = corSelecao;
    }

    public int getLadoQuadrado() {
        return ladoQuadrado;
    }

    public void setLadoQuadrado(int ladoQuadrado) {
        this.ladoQuadrado = ladoQuadrado;
    }

    public Color getCorFonte() {
        return corFonte;
    }

    public void setCorFonte(Color corFonte) {
        this.corFonte = corFonte;
    }

    public int getTamanhoFonte() {
        return tamanhoFonte;
    }

    public void setTamanhoFonte(int tamanhoFonte) {
        this.tamanhoFonte = tamanhoFonte;
    }

    public String getTipoFonte() {
        return tipoFonte;
    }

    public void setTipoFonte(String tipoFonte) {
        this.tipoFonte = tipoFonte;
    }

    public int getEstiloFonte() {
        return estiloFonte;
    }

    public void setEstiloFonte(int estiloFonte) {
        this.estiloFonte = estiloFonte;
    }

    public int getArcoCurvatura() {
        return arcoCurvatura;
    }

    public void setArcoCurvatura(int arcoCurvatura) {
        this.arcoCurvatura = arcoCurvatura;
    }
}
