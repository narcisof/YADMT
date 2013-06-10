package moduledefault.classify.c45.rafael.view.jpanel.graph;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.Serializable;
import java.util.Vector;
/*
 * Aresta.java
 *
 * Created on 8 de Novembro de 2006, 22:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**Classe que implementa um aresta com componentes gr�ficos de visualiza��o
 * @author Cassiano Cesar Casagrande*/
public class Aresta implements  ObjetoGrafico,Serializable{
    /**objeto utilizado para fazer a curva*/
    private transient QuadCurve2D curva;
    /**objeto utilizado para fazer a seta*/
    // private transient GeneralPath seta;
    
    /**objeto gr�fico ret�ngulo*/
    private transient RoundRectangle2D retangulo;
    /**dimens�o ret�ngulo*/
    private int dimensaoRet;
    
    /**valor que define o altura e largura do arco para o tratamento de bordas
     * no ret�ngulo*/
    private int valorArcCurvatura;
    
    /**ponto de origem, sendo o centro de um estado*/
    private Point pOrigem;
    /**ponto de destino, sendo o centro de um estado*/
    private Point pDestino;
    /**ponto de controle*/
    private Point pControle;
    /**ponto intermedi�rio, utilizado no momento da constru��o da transi��o*/
    private Point pTem;
    
    /**ponto em que a curva efetivamente come�a*/
    private Point pOrigemCurva;
    /**ponto em que a curva efetivamente termina*/
    private Point pDestinoCurva;
    
    /**ponto da seta*/
    //private Point pSeta1;
    /**ponto da seta*/
    //private Point pSeta2;
    /**ponto para impress�o de texto com o valor da transi��o*/
    //private Point pImpressao;
    
    /**cor da seta*/
    //private Color corSeta;
    /**cor da curva*/
    private Color corCurva;
    /**cor do retangulo*/
    private Color corRet;
    
    /**afastamento da origem*/
    private double afastamentoOrigem;
    /**afastamento do destino*/
    private double afastamentoDestino;
    /**tamanho da seta*/
    //private double tamSeta;
    /**vari�vel boolean, indica se o objeto est� selecionado*/
    private boolean isSelecionado;
    /**se a transi��o j� foi totalmente constru�da, com ponto de origem e destino*/
    private boolean isConstruida;
    /**valor de afastamento para a impressao, em rela��o ao destino*/
    //private double afastamentoImpressao;
    /**identificador do estado origem*/
    private int idOrigem;
    /**identificador do estado destino*/
    private int idDestino;
    
    private String rotulo;
    private Point pRotulo;
    
    
    /**espessura curva*/
    private int espCurva;
    /**espessura seta*/
    //private int espSeta;
    
    /**valor associado a transi��o*/
    //private String texto;
    
    /**cor do conteudo da trans*/
    //private Color corTexto;
    
    /**
     * construtor de inicializa��o
     * @param afastOrigem dist�ncia que a transi��o se afasta do ponto de origem
     * @param afastDestino dist�ncia que a transi��o se afasta do ponto de destino
     */
    public Aresta(double afastOrigem,double afastDestino) {
        curva=new QuadCurve2D.Double();
        
        dimensaoRet=16;
        valorArcCurvatura=10;
        isConstruida=false;
        isSelecionado=false;
        afastamentoOrigem=afastOrigem;
        afastamentoDestino=afastDestino;
        
        //corCurva=Color.LIGHT_GRAY;
        corCurva=new Color(255,186,28);
        
        
        
        corRet=new Color(69,138,34);
        espCurva=2;
    }
    
    public Aresta(Propriedades p, String rotulo) {
        curva=new QuadCurve2D.Double();

        isConstruida=false;
        isSelecionado=false;
        
        afastamentoDestino=afastamentoOrigem=p.getDeslocamentoOrigem();
        corCurva=p.getCorAresta();
        corRet=p.getCorSelecao();
        dimensaoRet=p.getLadoQuadrado();
        espCurva=p.getEspessuraAresta();
        valorArcCurvatura=p.getArcoCurvatura();
this.rotulo = rotulo;
    }
    
    /**seta o ponto tempor�rio, usado quando o ponto destino ainda n�o foi definido
     * @param p ponto tempor�rio*/
    public void setPTemp(Point p){
        pTem=new Point(p);
        if(pOrigem!=null){//ja existe um ponto origem
            //achar o ponto controle
            pControle=pontoDaReta(pOrigem,pTem,distancia(pOrigem,pTem)/2);
            //achar ponto origem curva
            pOrigemCurva=pontoDaReta(pOrigem,pTem,afastamentoOrigem);
            //achar ponto destino curva
            pDestinoCurva=new Point(pTem);
            
            curva=new QuadCurve2D.Double(pOrigemCurva.getX(),pOrigemCurva.getY(),pControle.getX(),
                    pControle.getY(),pDestinoCurva.getX(),pDestinoCurva.getY());
            
            double aux=distancia(pControle,pDestinoCurva);
            
            
        }
        
        
        
    }
    /**utilizado para atualizar grafico apos deserializacao*/
    public void atualizarGrafico(){
        pOrigemCurva=pontoDaReta(pOrigem,pControle,afastamentoOrigem);
        
        pDestinoCurva=pontoDaReta(pDestino,pControle,afastamentoDestino);
        curva=new QuadCurve2D.Double(pOrigemCurva.getX(),pOrigemCurva.getY(),pControle.getX(),
                pControle.getY(),pDestinoCurva.getX(),pDestinoCurva.getY());
        
        
        double aux=distancia(pControle,pDestinoCurva);
    }
    
    
    
    
    
    
    
    
    /**declarac�o do id de origem(vertice origem)
     * @param id inteiro com o id do vertice origem*/
    public void setIdOrigem(int id){
        idOrigem=id;
    }
    /**declarac�o do id de destino(vertice destino)
     * @param id inteiro com o id do vertice origem*/
    public void setIdDestino(int id){
        idDestino=id;
    }
    /**retorna o ponto id de origem
     * @return inteiro com o id*/
    
    public int getIdOrigem(){
        return idOrigem;
    }
    /**retorna o ponto id de destino
     * @return inteiro com o id*/
    public int getIdDestino(){
        return idDestino;
    }
    /**setar ponto de origem da aresta
     * @param p ponto de origem*/
    public void setPOrigem(Point p){
        pOrigem=new Point(p);
        if(isConstruida){
            pOrigemCurva=pontoDaReta(pOrigem,pControle,afastamentoOrigem);
            curva=new QuadCurve2D.Double(pOrigemCurva.getX(),pOrigemCurva.getY(),pControle.getX(),
                    pControle.getY(),pDestinoCurva.getX(),pDestinoCurva.getY());
        }
    }
    /**setar ponto de destino da aresta
     * @param p ponto de destino*/
    public void setPDestino(Point p){
        if(isConstruida){
            pDestino=new Point(p);
            pDestinoCurva=pontoDaReta(pDestino,pControle,afastamentoDestino);
            curva=new QuadCurve2D.Double(pOrigemCurva.getX(),pOrigemCurva.getY(),pControle.getX(),
                    pControle.getY(),pDestinoCurva.getX(),pDestinoCurva.getY());
            
            
            double aux=distancia(pControle,pDestinoCurva);
            
        }else{
            pDestino=new Point(p);
            isConstruida=true;
            pControle=pontoDaReta(pOrigem,pDestino,distancia(pOrigem,pDestino)/2);
            
            pOrigemCurva=pontoDaReta(pOrigem,pControle,afastamentoOrigem);
            pDestinoCurva=pontoDaReta(pDestino,pControle,afastamentoDestino);
            curva=new QuadCurve2D.Double(pOrigemCurva.getX(),pOrigemCurva.getY(),pControle.getX(),
                    pControle.getY(),pDestinoCurva.getX(),pDestinoCurva.getY());
            
            
            double aux=distancia(pControle,pDestinoCurva);
            
            
        }
    }
    /**setar ponto de contrale da aresta(a aresta � uma curva que possui tr�s pontos , o inicial, final e de controle)
     * @param p ponto de controle*/
    public void setPControle(Point p){
        pControle=p;
        pOrigemCurva=pontoDaReta(pOrigem,pControle,afastamentoOrigem);
        pDestinoCurva=pontoDaReta(pDestino,pControle,afastamentoDestino);
        curva=new QuadCurve2D.Double(pOrigemCurva.getX(),pOrigemCurva.getY(),pControle.getX(),
                pControle.getY(),pDestinoCurva.getX(),pDestinoCurva.getY());
        if(retangulo!=null){
            retangulo=new RoundRectangle2D.Double(pControle.getX()-dimensaoRet/2,pControle.getY()-dimensaoRet/2,dimensaoRet,dimensaoRet,valorArcCurvatura,valorArcCurvatura);
        }
        
        double aux=distancia(pControle,pDestinoCurva);        
    }
    
    
    
    /**m�todo para plotar componente na tela
     * @param g2 contexto gr�fico*/
    public void plota(Graphics2D g2){
        g2.setStroke(new BasicStroke(espCurva,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setPaint(corCurva);
        g2.draw(curva);
        pRotulo = pontoDaReta(pDestino,pControle,afastamentoDestino*2);
        g2.setColor(Color.BLACK);
        g2.drawString(rotulo, pRotulo.x, pRotulo.y);
        
        
        g2.setPaint(corRet);
        if(retangulo!=null){
            g2.fill(retangulo);
        }
    }
    
    /**dada um reta com dois pontos, retorna um ponto que pertence a reta dada por uma dist�ncia do primeiro ponto
     * @param p1 primeiro ponto da reta
     * @param p2 segundo ponto da reta
     * @param d distancia do primeiro ponto
     * @return ponto que pertence a reta*/
    private Point pontoDaReta(Point p1,Point p2, double d){
        Point aux=new Point();
        double disReta =distancia(p1,p2);
        double x=(p1.getX()-p2.getX())*d/disReta;
        double y=(p1.getY()-p2.getY())*d/disReta;
        
        
        aux.setLocation(p1.getX()-x,p1.getY()-y);
        
        return aux;
    }
    /**calcula a transi��o sobre um ponto
     * @param p1 ponto que sobrer� translacao
     * @param dx delta x
     * @param dy delta y
     * @return ponto transladado*/
    private Point translacao(Point p1,double dx, double dy){
        Point aux=new Point();
        aux.setLocation(p1.getX()+dx,p1.getY()+dy);
        return aux;
    }
    
    /**calcula a rotacao sobre um ponto
     * @param p1 ponto que sobrer� a rotacao
     * @param ang �ngulo da rotacao
     * @return ponto rotacionado*/
    private Point rotacao(Point p1,double ang){
        double rad=Math.toRadians(ang);
        Point aux=new Point();
        double x=0;
        double y=0;
        x=p1.getX()*Math.cos(rad)-p1.getY()*Math.sin(rad);
        y=p1.getX()*Math.sin(rad)+p1.getY()*Math.cos(rad);
        aux.setLocation(x,y);
        return aux;
    }
    
    /**calcula a distancia euclidiana entre dois pontos
     * @param p1 ponto 1
     * @param p2 ponto 2
     * @return a distancia euclidiana*/
    private double distancia(Point p1,Point p2){
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2));
    }
    
    /**verifica se um ponto est� sobre a curva da aresta
     * @param p ponto de compara��o
     * @return true se o referido ponto est� sobre a curva*/
    public boolean isSobreCurva(Point p){
        
        if(retangulo!=null)
            return curva.intersects(p.getX(),p.getY(),5,5)||retangulo.intersects(p.getX(),p.getY(),2,2);
        else
            return curva.intersects(p.getX(),p.getY(),5,5);
    }
    
    
    
    /**verifica se um ponto est� sobre o ponto de controle da aresta
     * @param p ponto de compara��o
     * @return true se o referido ponto est� sobre o ponto de controle*/
    public boolean isSobreControle(Point p){
        
        if(retangulo!=null)
            return retangulo.intersects(p.getX(),p.getY(),2,2);
        else
            return false;
    }
    
    /**m�todo que altera o estado da transi��o para transi��o selecionada*/
    public void selecionarCurva(){
        isSelecionado=true;
        retangulo=new RoundRectangle2D.Double(pControle.getX()-dimensaoRet/2,pControle.getY()-dimensaoRet/2,dimensaoRet,dimensaoRet,valorArcCurvatura,valorArcCurvatura);
    }
    /**m�todo que altera o estado da transi��o para transi��o n�o selecionada*/
    public void desfazerSelecao(){
        isSelecionado=false;
        retangulo=null;
    }
    /**efetua translacao sobre a aresta como um todo
     * @param x delta x
     * @param y delta y*/
    public void translacao(int x, int y) {
        pControle=new Point((int)(pControle.getX()+x),(int)(pControle.getY()+y));
        pDestino=new Point((int)(pDestino.getX()+x),(int)(pDestino.getY()+y));
        pDestinoCurva=new Point((int)(pDestinoCurva.getX()+x),(int)(pDestinoCurva.getY()+y));
        
        pOrigemCurva=new Point((int)(pOrigemCurva.getX()+x),(int)(pOrigemCurva.getY()+y));
        pOrigem=new Point((int)(pOrigem.getX()+x),(int)(pOrigem.getY()+y));
        if(pTem!=null)
            pTem=new Point((int)(pTem.getX()+x),(int)(pTem.getY()+y));
        
        atualizarGrafico();
        
    }
    
    
    /**quebra um String a cada \n que existir
     * @return um Vector que contem em cada indice uma linha da String original*/
    private Vector quebraTexto(String s){
        Vector vet=new Vector();
        
        
        String linha=new String();
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='\n'){
                vet.add(linha);
                linha="";
            }else{
                linha+=s.charAt(i);
                if(i==s.length()-1){
                    vet.add(linha);
                    linha="";
                }
            }
        }
        
        
        
        return vet;
    }
    /**calcula o ret�ngulo que envolve a aresta (a curva e o ponto de controle)
     * @return o  retangulo que envolve a transi��o*/
    public Rectangle getRetanguloEnvolveObjeto() {
        Rectangle r=null;
        
        r=RetanguloEnvolvente.getRetanguloEnvolvente(pOrigem,pDestino);
        r=RetanguloEnvolvente.getRetanguloEnvolvente(r,pControle);
        
        
        return r;
    }
    public void setPropriedades(Propriedades p){
        afastamentoDestino=afastamentoOrigem=p.getDeslocamentoOrigem();
        corCurva=p.getCorAresta();
        corRet=p.getCorSelecao();
        dimensaoRet=p.getLadoQuadrado();
        espCurva=p.getEspessuraAresta();
        valorArcCurvatura=p.getArcoCurvatura();
        atualizarGrafico();
    }
    
    
    /**constantes*/
    
    
    
    
    public final static Color  COR_CURVA=Color.lightGray;
}
