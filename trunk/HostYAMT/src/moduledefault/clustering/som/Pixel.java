/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

/**
 *
 * @author Thiago M. Faino
 */
public class Pixel {
    
    int x;
    int y;
    int rgb;

    public Pixel(int x, int y, int rgb) {
        this.x = x;
        this.y = y;
        this.rgb = rgb;
    }
    
    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
        this.rgb = 0;
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

    public int getRgb() {
        return rgb;
    }

    public void setRgb(int rgb) {
        this.rgb = rgb;
    }
    
    
}
