package moduledefault.classify.c45.rafael.view.jpanel.graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
/*
 * Vertice.java
 *
 * Created on 8 de Novembro de 2006, 22:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Cassiano
 */
public class Vertice implements ObjetoGrafico, Serializable {

    /**constante que define o tipo do objeto*/
    public final static int TIPO_COR_0 = 0;
    /**constante que define o tipo do objeto*/
    public final static int TIPO_COR_1 = 1;
    /**constante que define o tipo do objeto*/
    public final static int TIPO_COR_2 = 2;
    /**constante que define o tipo do objeto*/
    public final static int TIPO_COR_3 = 3;
    /**constante que define o tipo do objeto*/
    public final static int TIPO_COR_4 = 4;
    //
    /**objeto gr�fico que representa o circulo do vertice*/
    private transient Ellipse2D vertice;
    /**raio do circulo*/
    private double raio;
    /**r�tulo do estado (pode ser um apelido para o vertice)\br
     * � o valor que ser� mostrado visualmente no estado*/
    private String rotulo;
    /**identificador do vertice*/
    private int id;
    /**ponto do centro do vertice*/
    private Point po;
    /**tipo do vertice*/
    private int tipoCorVertice;
    /**espessura do vertice*/
    private int espessura;
    /**array de cores a ser atribuido ao vertice*/
    private Color[] cores;
    private Color corFonte;
    private int tamFonte;
    private int estiloFonte;
    private String tipoFonte;

    /**construtor de inicializa��o
     * @param id identificador do vertice
     * @param p ponto do vertice
     * @param prop propriedades
     * @param tipoVertice tipo do vertice ou tipo de cor atribuida a ele; se for null, o construtor inicializara com cores default*/
    public Vertice(int id, Point p, int tipoVertice, Propriedades prop) {
        this.id = id;

        raio = prop.getRaio();
        cores = prop.getCorVertices();
        espessura = prop.getEspessuraVertice();
        corFonte = prop.getCorFonte();
        estiloFonte = prop.getEstiloFonte();
        tipoFonte = prop.getTipoFonte();
        tamFonte = prop.getTamanhoFonte();

        po = new Point(p);
        vertice = new Ellipse2D.Double(po.getX() - raio, po.getY() - raio, raio * 2, raio * 2);
        tipoCorVertice = tipoVertice;
        rotulo = new String();
    }

    /**retorna o identificador do estado
     * @return identificador do estado*/
    public int getIdentificador() {
        return id;
    }

    /**seta o identificador do estado
     * @param id novo identificador*/
    public void setIdentificador(int id) {
        this.id = id;
    }

    /**retorna o tipo do estado
     * @return inteiro com o tipo do estado*/
    public int getTipoVertice() {
        return tipoCorVertice;
    }

    /**setar o rotulo
     * @param msg com o novo rotulo*/
    public void setRotulo(String msg) {
        rotulo = msg;
    }

    /**retorna o rotulo
     * @return o rotulo*/
    public String getRotulo() {
        return rotulo;
    }

    /**
     * seta o ponto central do estado
     * @param p novo ponto
     */
    public void setPonto(Point p) {
        po = new Point(p);
        vertice = new Ellipse2D.Double(po.getX() - raio, po.getY() - raio, raio * 2, raio * 2);
    }

    /**seta o tipo do estado
     * @param tipo do estado definido por constantes*/
    public void setTipoVertice(int tipo) {
        tipoCorVertice = tipo;
    }

    /**
     * m�todo para plotar componente na tela
     * @param g2 contexto gr�fico
     */
    public void plota(Graphics2D g2D) {
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2D.setStroke(new BasicStroke(espessura, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2D.setPaint(cores[tipoCorVertice]);
        g2D.draw(vertice);

        //texto
        Font f = new Font(tipoFonte, estiloFonte, tamFonte);

        g2D.setFont(f);

        FontRenderContext context = g2D.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(rotulo, context);

        g2D.setPaint(corFonte);
        g2D.drawString(rotulo, (int) (po.getX() - bounds.getWidth() / 2), (int) (po.getY() + bounds.getHeight() / 2));

    }

    /**utilizado para atualizar componenetes graficos apos deserializacao*/
    public void atualizarGrafico() {
        vertice = new Ellipse2D.Double(po.getX() - raio, po.getY() - raio, raio * 2, raio * 2);
    }

    /**retorna o ponto central do vertice
     * @return o ponto do vertice*/
    public Point getPo() {
        return new Point(po);
    }

    /**
     * calcula a distancia euclidiana entre dois pontos
     * @param p1 ponto 1
     * @param p2 ponto 2
     */
    private double distancia(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    /**
     * verifica se um vertice se sobrep�e a outro
     * @param v vertice a se comparar
     * @return true se existe a sobreposi��o
     */
    public boolean isSobrepoe(Vertice v) {
        double disTotal = this.raio + v.raio;
        double d = distancia(this.po, v.po);
        if (d <= disTotal) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * verifica se uma ponto tal com uma certo raio se sobrep�e a um vertice
     * @param p ponto
     * @param raio raio
     * @return true se existe sobreposi��o
     */
    public boolean isSobrepoe(Point p, double raio) {
        double disTotal = this.raio + raio;
        double d = distancia(this.po, p);
        if (d <= disTotal) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * verifica se um ponto � interno a o vertice
     * @param p ponto
     * @return true se o ponto � interno
     */
    public boolean isInterno(Point p) {
        double d = distancia(this.po, p);
        if (this.raio >= d) {
            return true;
        } else {
            return false;
        }
    }

    /**calcula o ret�ngulo que envolve a vertice (a curva e o ponto de controle)
     * @return o  retangulo que envolve a vertice*/
    public Rectangle getRetanguloEnvolveObjeto() {

        //canto superior esquerdo
        Point p1 = new Point((int) (po.getX() - (raio + espessura)), (int) (po.getY() - (raio + espessura)));
        //canto inferior direito
        Point p2 = new Point((int) (po.getX() + (raio + espessura)), (int) (po.getY() + (raio + espessura)));

        Rectangle r = null;
        r = new Rectangle((int) p1.getX(), (int) p1.getY(), (int) (p2.getX() - p1.getX()), (int) (p2.getY() - p1.getY()));

        return r;
    }

    /**efetua translacao sobre o vertice
     * @param x delta x
     * @param y delta y*/
    public void translacao(int x, int y) {
        po = new Point((int) po.getX() + x, (int) po.getY() + y);
        atualizarGrafico();
    }

    /**dada um reta com dois pontos, retorna um ponto que pertence a reta dada por uma dist�ncia do primeiro ponto
     * @param p1 primeiro ponto da reta
     * @param p2 segundo ponto da reta
     * @param d distancia do primeiro ponto
     * @return ponto que pertence a reta*/
    private Point pontoDaReta(Point p1, Point p2, double d) {
        Point aux = new Point();
        double disReta = distancia(p1, p2);
        double x = (p1.getX() - p2.getX()) * d / disReta;
        double y = (p1.getY() - p2.getY()) * d / disReta;

        aux.setLocation(p1.getX() - x, p1.getY() - y);

        return aux;
    }

    /**calcula a translacao sobre um ponto
     * @param p1 ponto que sobrer� translacao
     * @param dx delta x
     * @param dy delta y
     * @return ponto transladado*/
    private Point translacao(Point p1, double dx, double dy) {
        Point aux = new Point();
        aux.setLocation(p1.getX() + dx, p1.getY() + dy);
        return aux;
    }

    /**calcula a rotacao sobre um ponto
     * @param p1 ponto que sobrer� a rotacao
     * @param ang �ngulo da rotacao
     * @return ponto rotacionado*/
    private Point rotacao(Point p1, double ang) {
        double rad = Math.toRadians(ang);
        Point aux = new Point();
        double x = 0;
        double y = 0;
        x = p1.getX() * Math.cos(rad) - p1.getY() * Math.sin(rad);
        y = p1.getX() * Math.sin(rad) + p1.getY() * Math.cos(rad);
        aux.setLocation(x, y);
        return aux;
    }

    public void setPropriedades(Propriedades p) {
        cores = p.getCorVertices();
        espessura = p.getEspessuraVertice();
        raio = p.getRaio();
        corFonte = p.getCorFonte();
        estiloFonte = p.getEstiloFonte();
        tipoFonte = p.getTipoFonte();
        tamFonte = p.getTamanhoFonte();
        atualizarGrafico();
    }
}
