/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som.visualization;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import moduledefault.clustering.uteis.Cluster;
import moduledefault.clustering.visualization.Classes.Poligono;

/**
 *
 * @author Thiago
 */
public final class Clustering extends javax.swing.JPanel {

    private int NUM_HEX_CORNERS = 6;
    private int[] mCornersX = new int[NUM_HEX_CORNERS];
    private int[] mCornersY = new int[NUM_HEX_CORNERS];
    private HexGrid mCellMetrics;
    private int gridMUX;
    private int gridMUY;
    double intervalo;
    ArrayList<Color> colors;

    /**
     * Creates new form Draw2D
     */
    public Clustering() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!FrameSomVisualization.getInstance().getClusters().isEmpty()) {
            colors = new ArrayList<>();
            gridMUX = FrameSomVisualization.getGridX();
            gridMUY = FrameSomVisualization.getGridY();

            mCellMetrics = new HexGrid(FrameSomVisualization.getValueClustering());

            ArrayList<Cluster> clusters = FrameSomVisualization.getInstance().getClusters();
            int cor = 50;
            for (int i = 0; i < clusters.size(); i++) {
                for (int j = 0; j < clusters.get(i).getNeuronios().size(); j++) {
                    mCellMetrics.setCellIndex(clusters.get(i).getNeuronios().get(j).getI(),
                            clusters.get(i).getNeuronios().get(j).getJ());
                    mCellMetrics.computeCorners(mCornersX, mCornersY);
                    g.setColor(new Color(cor));
                    g.fillPolygon(mCornersX, mCornersY, NUM_HEX_CORNERS);
                }
                colors.add(new Color(cor));
                cor = cor * 50;
            }
            g.setColor(Color.BLACK);
            for (int i = 0; i < gridMUX; i++) {
                for (int j = 0; j < gridMUY; j++) {
                    mCellMetrics.setCellIndex(i, j);
                    mCellMetrics.computeCorners(mCornersX, mCornersY);
                    g.drawPolygon(mCornersX, mCornersY, NUM_HEX_CORNERS);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
