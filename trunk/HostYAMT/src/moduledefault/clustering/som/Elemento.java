/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

/**
 *
 * @author Thiago M. Faino
 */
public class Elemento {

    private int i;
    private int j;

    public Elemento(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Elemento() {
        this.i = 0;
        this.j = 0;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
