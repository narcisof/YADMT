/*
 * MapaGrafico.java
 *
 * Created on 19 de Mar�o de 2007, 09:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package moduledefault.classify.c45.rafael.view.jpanel.graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Cassiano
 */
public class MapaGrafico implements Serializable {

    /**lista de estados*/
    private Vector listaVertices;
    /**lista de transi��es*/
    private Vector listaArestas;
    private Propriedades propriedades;
    /**identifica se houve altera��o ap�s ser salvo por exemplo*/
    private boolean isAlterado;
    private Dimension d;

    /**construtor de inicializa��o*/
    public MapaGrafico() {
        listaVertices = new Vector();
        listaArestas = new Vector();
        isAlterado = false;
        propriedades = new Propriedades();
    }

    public void setDimensao(Dimension dim) {
        d = dim;
        isAlterado = true;
    }

    /**desenhar grafo na tela
     * @param g2D componente gr�fico*/
    public void paint(Graphics2D g2D) {
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice aux = (Vertice) listaVertices.get(i);
            aux.plota(g2D);
        }
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta aux = (Aresta) listaArestas.get(i);
            aux.plota(g2D);
        }
    }

    /**fazer transla��o nos componenetes gr�ficos do grafo
     * @param x delta x
     * @param y delta y*/
    public void translacao(int x, int y) {
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice aux = (Vertice) listaVertices.get(i);
            aux.translacao(x, y);
        }

        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta aux = (Aresta) listaArestas.get(i);
            aux.translacao(x, y);
        }
        isAlterado = true;
    }

    /**inserir vertice
     * @param estado vertice a ser inserido*/
    public void inserirVertice(Vertice vertice) {
        if (listaVertices == null) {
            listaVertices = new Vector();
        }
        if (!isVertice(vertice.getIdentificador())) {
            listaVertices.add(vertice);
        } else {
            System.out.println("Erro: inserir um estado que j� existe");
        }
        isAlterado = true;
    }

    /**inserir aresta
     * @param trans aresta a ser inserido*/
    public void inserirAresta(Aresta aresta) {
        listaArestas.add(aresta);
        isAlterado = true;
    }

    /**verifica se uma aresta entre um vertice origem e um destino existem
     * @param idO vertice origem
     * @param idD vertice destino
     * @return true se j� existe uma transi��o entre os estados especificados*/
    public boolean isAresta(int idO, int idD) {
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta aux = (Aresta) listaArestas.get(i);
            if (aux.getIdOrigem() == idO && aux.getIdDestino() == idD) {
                return true;
            }
        }
        return false;
    }

    /**retorna um objeto selecionado dado um certo ponto
     * @param p ponto
     * @return o objeto selecionado se existir*/
    public ObjetoGrafico getObjetoSelecionado(Point p) {
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice aux = (Vertice) listaVertices.get(i);
            if (aux.isInterno(p)) {
                return aux;
            }
        }
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta aux = (Aresta) listaArestas.get(i);
            if (aux.isSobreCurva(p)) {
                return aux;
            }
        }
        return null;
    }

    /**retorna menor estado ainda n�o utilizado
     * @return um inteiro com o id do menor estado n�o utilizado*/
    public int getProximoEstadoMenorDesocupado() {
        for (int i = 0; i < listaVertices.size(); i++) {
            if (!isVertice(i)) {
                return i;
            }
        }
        return listaVertices.size();
    }

    /**verifica se j� existe um vertice com um dado id
     * @param id identificador
     * @return true se j� existe*/
    public boolean isVertice(int id) {
        if (listaVertices != null && listaVertices.size() > 0) {
            Vertice aux;
            for (int i = 0; i < listaVertices.size(); i++) {
                aux = (Vertice) listaVertices.get(i);
                if (id == aux.getIdentificador()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**retorna um vertice dado um certo id
     * @param id identificador
     * @return O vertice com o respectivo id*/
    public Vertice getVertice(int id) {
        Vertice e = null;
        if (listaVertices != null && listaVertices.size() > 0) {
            Vertice aux;
            for (int i = 0; i < listaVertices.size(); i++) {
                aux = (Vertice) listaVertices.get(i);
                if (id == aux.getIdentificador()) {
                    return aux;
                }
            }
        }
        return e;
    }

    /**verifica se existe sobreposi��o de vertice com um ponto + um raio
     * @param p ponto
     * @param raio raio
     * @return true se existe sobreposi��o*/
    public boolean isSobrepoeVertice(Point p, double raio) {
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice aux = (Vertice) listaVertices.get(i);
            if (aux.isSobrepoe(p, raio)) {
                return true;
            }
        }
        return false;
    }

    /**verifica se ponto sobrep�e um objeto
     * @param p ponto
     * @return true se sobrep�e*/
    public boolean isSobreObjeto(Point p) {
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice aux = (Vertice) listaVertices.get(i);
            if (aux.isInterno(p)) {
                return true;
            }
        }
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta aux = (Aresta) listaArestas.get(i);
            if (aux.isSobreCurva(p)) {
                return true;
            }
        }
        return false;
    }

    /**retorna  o ret�ngulo envolvente objetos
     * @return retangulo envolvente objetos*/
    public Rectangle getRetanguloEnvolveObjetos() {
        Rectangle rect = null;
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice aux = (Vertice) listaVertices.get(i);
            if (i == 0) {
                rect = aux.getRetanguloEnvolveObjeto();
            } else {
                rect = RetanguloEnvolvente.getRetanguloEnvolvente(rect, aux.getRetanguloEnvolveObjeto());
            }
        }
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta t = (Aresta) listaArestas.get(i);
            rect = RetanguloEnvolvente.getRetanguloEnvolvente(rect, t.getRetanguloEnvolveObjeto());
        }



        return rect;
    }

    /**remover objeto
     * @param objeto a ser removido*/
    public void removerObjeto(ObjetoGrafico objeto) {
        if (objeto instanceof Vertice) {
            Vertice auxE = (Vertice) objeto;
            removerVertice(auxE.getIdentificador());
        } else {
            if (objeto instanceof Aresta) {
                Aresta auxT = (Aresta) objeto;
                removerAresta(auxT.getIdOrigem(), auxT.getIdDestino());
            }
        }
        isAlterado = true;
    }

    /**remove vertice
     * @param id identificador do vertice*/
    private void removerVertice(int id) {
        //remover estado
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice aux = (Vertice) listaVertices.get(i);
            if (aux.getIdentificador() == id) {
                listaVertices.removeElementAt(i);
                break;
            }
        }

        //remover transi��o que faz referencia ao estado j� removido
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta aux = (Aresta) listaArestas.get(i);
            if (aux.getIdOrigem() == id || aux.getIdDestino() == id) {
                listaArestas.removeElementAt(i);
                i--;
            }
        }
        isAlterado = true;
    }

    /**remove aresta
     * @param idOrigem identificador de origem
     * @param idDestino identificador de origem*/
    private void removerAresta(int idOrigem, int idDestino) {
        //remover transi��o que faz referencia ao estado j� removido
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta aux = (Aresta) listaArestas.get(i);
            if (aux.getIdOrigem() == idOrigem && aux.getIdDestino() == idDestino) {
                listaArestas.removeElementAt(i);
                break;
            }
        }
        isAlterado = true;
    }

    /**mover vertice
     * @param id identificador do vertice
     * @param point novo ponto*/
    public void moveVertice(int id, Point point) {
        //estado estado
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice aux = (Vertice) listaVertices.get(i);
            if (aux.getIdentificador() == id) {
                aux.setPonto(point);
                aux.atualizarGrafico();
                break;
            }
        }

        //move transi��o que faz referencia ao estado movido
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta aux = (Aresta) listaArestas.get(i);
            if (aux.getIdOrigem() == id && aux.getIdDestino() == id) {
                aux.setPOrigem(new Point((int) point.getX() + 20, (int) point.getY()));
                aux.setPDestino(point);
                aux.atualizarGrafico();
            } else {
                if (aux.getIdOrigem() == id) {
                    aux.setPOrigem(point);
                    aux.atualizarGrafico();
                }
                if (aux.getIdDestino() == id) {
                    aux.setPDestino(point);
                    aux.atualizarGrafico();
                }
            }
        }
        isAlterado = true;
    }

    /**verifica se automato foi alterado ap�s uma opera��o de salvar ou novo
     * @return true se houve altera��o*/
    public boolean isAlterado() {
        return isAlterado;
    }

    /**seta condi��o de alterado
     * @param bool nova condi��o*/
    public void setAlterado(boolean bool) {
        isAlterado = bool;
    }

    /**m�todo utilizado para efetuar a atualiza��o dos compomentes gr�ficos
     * deve ser utilizado ap�s a deserializa��o do objeto\br*/
    public void atualizar() {
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice aux = (Vertice) listaVertices.get(i);
            aux.atualizarGrafico();
        }
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta t = (Aresta) listaArestas.get(i);
            t.atualizarGrafico();
        }
    }

    /**constru��o do buffer de imagem para exportar imagem
     * @param buffer objeto buffer de imagem
     * @param w largula da imagem
     * @param h altura da imagem*/
    private BufferedImage atualizarBuffer(BufferedImage buffer, int w, int h) {
        buffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2D;
        Color c = Color.WHITE;
        int cor = c.getRGB(); // pega a cor como inteiro
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                buffer.setRGB(i, j, cor);
            }
        }
        g2D = (Graphics2D) buffer.getGraphics();

        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2D.setBackground(Color.white);
        g2D.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2D.setPaint(Color.DARK_GRAY);
        g2D.setFont(new java.awt.Font("Monospaced", 1, 20));
        g2D.drawString("By C@$$i@n# <cccasagrande_info@yahoo.com.br>", 10, 25);
        int ori = 0;
        int des = 0;
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice est = (Vertice) listaVertices.get(i);
            est.plota(g2D);
        }
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta a = (Aresta) listaArestas.get(i);
            a.plota(g2D);
        }
        if (buffer == null) {
            System.out.println("+++++++++++++==");
        } else {
            System.out.println("-------------------");
        }
        return buffer;
    }

    /**alterar identificador do vertice
    @param id identificador atual
    @param novoID novo identificador*/
    public void alteraID(int id, int novoID) {
        if (!isVertice(novoID)) {
            for (int i = 0; i < listaVertices.size(); i++) {
                Vertice e = (Vertice) listaVertices.get(i);
                if (e.getIdentificador() == id) {
                    e.setIdentificador(novoID);
                    e.setRotulo(novoID + "");
                    break;
                }
            }
            for (int i = 0; i < listaArestas.size(); i++) {
                Aresta t = (Aresta) listaArestas.get(i);
                if (t.getIdOrigem() == id) {
                    t.setIdOrigem(novoID);
                }
                if (t.getIdDestino() == id) {
                    t.setIdDestino(novoID);
                }
            }
        }
    }

    public int[] getVertices() {
        int vertices[] = null;
        if (listaVertices.size() > 0) {
            vertices = new int[listaVertices.size()];
            for (int i = 0; i < listaVertices.size(); i++) {
                Vertice aux = (Vertice) listaVertices.get(i);
                vertices[i] = aux.getIdentificador();
            }
        }
        return vertices;
    }

    public void setColorVertice(int id, int cor) {
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice v = (Vertice) listaVertices.get(i);
            if (v.getIdentificador() == id) {
                v.setTipoVertice(cor);
            }
        }
    }

    public void setPropriedades(Propriedades p) {
        propriedades = p;
        //atualizar propriedades nos objetos
        isAlterado = true;
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice v = (Vertice) listaVertices.get(i);
            v.setPropriedades(p);
        }
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta a = (Aresta) listaArestas.get(i);
            a.setPropriedades(p);
        }
    }

    public Propriedades getPropriedades() {
        return propriedades;
    }

    public void atualizarPropriedades() {
        //atualizar propriedades nos objetos
        isAlterado = true;
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice v = (Vertice) listaVertices.get(i);
            v.setPropriedades(propriedades);
        }
        for (int i = 0; i < listaArestas.size(); i++) {
            Aresta a = (Aresta) listaArestas.get(i);
            a.setPropriedades(propriedades);
        }
    }
}
