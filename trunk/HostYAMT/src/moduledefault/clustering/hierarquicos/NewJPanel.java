/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.hierarquicos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import moduledefault.clustering.som.visualization.FrameSomVisualization;
import moduledefault.clustering.som.visualization.HexGrid;

/**
 *
 * @author Thiago M. Faino
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    private static BinTree dendograma = null;
    
    public NewJPanel(BinTree a) {
        initComponents();
        this.dendograma = a;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        System.out.println("print");
        g.setColor(Color.red);
        
        if(dendograma != null){
            g.drawOval(460, 794, 20, 20);
            for (int i = 0; i < dendograma.getBase().size(); i++) {
                g.drawOval(dendograma.getBase().get(i).getX(), dendograma.getBase().get(i).getY(), 10, 10);
//                System.out.println(dendograma.getBase().get(i).getX()+" "+dendograma.getBase().get(i).getY());
            }
        }

    }

    public static void setDendograma(BinTree dendograma) {
        NewJPanel.dendograma = dendograma;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
