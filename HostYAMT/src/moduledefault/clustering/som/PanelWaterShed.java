/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Thiago M. Faino
 */
public class PanelWaterShed extends javax.swing.JPanel {

    static int[][] water = null;
    static ArrayList<ArrayList<Elemento>> result = null;
    
    public PanelWaterShed(int[][] i, ArrayList<ArrayList<Elemento>> r) {
        initComponents();
        result = r;
        water = i;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(result != null && water != null){
            int cor = 50;
            for (int i = 0; i < result.size(); i++) {
                g.setColor(new Color(cor));
                for (int j = 0; j < result.get(i).size(); j++) {
                    g.drawRect(result.get(i).get(j).getI(),result.get(i).get(j).getJ() , 1, 1);
                }
                cor = cor*50;
            }
//            for (int i = 0; i < water.length; i++) {
//                for (int j = 0; j < water[0].length; j++) {
//                    if (water[i][j] == 1) {
//                        g.setColor(new Color(getRGB(255, 255, 255)));
//                        g.drawRect(i, j, 1, 1);
//                    }
//                }
//            }
        }
    }
    
    public int getRGB(int r, int g, int b) {
        return 65536 * r + 256 * g + b;
    }
    
    public void setPrint(int[][] i){
       water = i;
       repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
