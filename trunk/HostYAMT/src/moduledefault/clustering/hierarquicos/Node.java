/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.hierarquicos;

/**
 *
 * @author Thiago M. Faino
 */
public class Node {
    
    private int x;
    private int y;
    private int padrao;
    private Node pai;
    private Node left;
    private Node right;

    public Node(int p, int x, int y) {
        this.padrao = p;
        this.x = x;
        this.y = y;
        this.pai = null;
        this.left = null;
        this.right = null;
    }
    
    public void setCoordenates(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPadrao() {
        return padrao;
    }

    public void setPadrao(int padrao) {
        this.padrao = padrao;
    }

    public Node getPai() {
        return pai;
    }

    public void setPai(Node pai) {
        this.pai = pai;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
