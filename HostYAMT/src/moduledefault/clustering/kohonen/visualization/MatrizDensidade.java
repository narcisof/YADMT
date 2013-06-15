/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kohonen.visualization;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Thiago
 */
public class MatrizDensidade extends javax.swing.JPanel {

    private int NUM_HEX_CORNERS = 6;
    private int[] mCornersX = new int[NUM_HEX_CORNERS];
    private int[] mCornersY = new int[NUM_HEX_CORNERS];
    private HexGrid mCellMetrics;
    private int gridX;
    private int gridY;

    /**
     * Creates new form Draw2D
     */
    public MatrizDensidade() {
        initComponents();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (FrameVisualization.getInstance().getRede() != null) {
            gridX = FrameVisualization.getGridX();
            gridY = FrameVisualization.getGridY();

            mCellMetrics = new HexGrid(FrameVisualization.getValueDensidade()); //tamanho hex

            Polygon poligonos[][] = new Polygon[gridX][gridY];

            for (int i = 0; i < gridX; i++) {
                for (int j = 0; j < gridY; j++) {
                    mCellMetrics.setCellIndex(i, j);
                    mCellMetrics.computeCorners(mCornersX, mCornersY);
                    if (!FrameVisualization.getRede().getNeuronio(i, j).getPadroes().isEmpty()) {
                        g.setColor(new Color(79, 79, 79));
                        g.fillPolygon(mCornersY, mCornersX, NUM_HEX_CORNERS);
                        g.setColor(Color.WHITE);
                        g.drawString(FrameVisualization.getRede().getNeuronio(i, j).getPadroes().size() + "", enumera(mCornersY, mCornersX).x, enumera(mCornersY, mCornersX).y);
                    } else {
                        g.setColor(Color.WHITE);
                        g.fillPolygon(mCornersY, mCornersX, NUM_HEX_CORNERS);
                    }
                    g.setColor(Color.BLACK);
                    g.drawPolygon(mCornersY, mCornersX, NUM_HEX_CORNERS);
                    Polygon p = new Polygon(mCornersY, mCornersX, NUM_HEX_CORNERS);
                    poligonos[i][j] = p;
                }
            }

            for (int i = 0; i < gridX; i++) {
                for (int j = 0; j < gridY; j++) {
                    if (FrameVisualization.isClick()) {
                        if ((FrameVisualization.getNeuronioX() == i) && (FrameVisualization.getNeuronioY() == j)) {
                            mCellMetrics.setCellIndex(i, j);
                            mCellMetrics.computeCorners(mCornersX, mCornersY);
                            Polygon p = new Polygon(mCornersY, mCornersX, NUM_HEX_CORNERS);
                            g.setColor(Color.red);
                            g.fillPolygon(p);
                            g.setColor(Color.WHITE);
                            g.drawPolygon(p);
                            g.setColor(Color.YELLOW);
                            g.drawString(FrameVisualization.getRede().getNeuronio(i, j).getPadroes().size() + "", enumera(mCornersY, mCornersX).x, enumera(mCornersY, mCornersX).y);
                        }
                    }
                }

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

    private Point enumera(int[] mX, int[] mY) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < mX.length; i++) {
            x += mX[i];
            y += mY[i];
        }
        x = (int) x / mX.length;
        y = (int) y / mX.length;

        return new Point(x, y);

    }
}
