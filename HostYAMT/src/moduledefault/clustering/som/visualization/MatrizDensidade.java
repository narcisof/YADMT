/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som.visualization;

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
    private static Color cNeuronio = new Color(79, 79, 79);
    private static Color sNeuronio = Color.WHITE;
    private static boolean exibePadroes = true;

    /**
     * Creates new form Draw2D
     */
    public MatrizDensidade() {
        initComponents();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (FrameSomVisualization.getInstance().getRede() != null) {

            gridX = FrameSomVisualization.getGridX();
            gridY = FrameSomVisualization.getGridY();

            mCellMetrics = new HexGrid(FrameSomVisualization.getValueDensidade()); //tamanho hex

            Polygon poligonos[][] = new Polygon[gridX][gridY];

            for (int i = 0; i < gridX; i++) {
                for (int j = 0; j < gridY; j++) {
                    mCellMetrics.setCellIndex(i, j);
                    mCellMetrics.computeCorners(mCornersX, mCornersY);
                    if (!FrameSomVisualization.getRede().getNeuronio(i, j).getPadroes().isEmpty()) {
                        g.setColor(cNeuronio);
                        g.fillPolygon(mCornersY, mCornersX, NUM_HEX_CORNERS);
                        if (exibePadroes) {
                            g.setColor(Color.WHITE);
                            g.drawString(FrameSomVisualization.getRede().getNeuronio(i, j).getPadroes().size() + "", enumera(mCornersY, mCornersX).x, enumera(mCornersY, mCornersX).y);
                        }
                    } else {
                        g.setColor(sNeuronio);
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
                    if (FrameSomVisualization.isClick()) {
                        if ((FrameSomVisualization.getNeuronioX() == i) && (FrameSomVisualization.getNeuronioY() == j)) {
                            mCellMetrics.setCellIndex(i, j);
                            mCellMetrics.computeCorners(mCornersX, mCornersY);
                            Polygon p = new Polygon(mCornersY, mCornersX, NUM_HEX_CORNERS);
                            g.setColor(Color.red);
                            g.fillPolygon(p);
                            g.setColor(Color.WHITE);
                            g.drawPolygon(p);
                            g.setColor(Color.YELLOW);
                            g.drawString(FrameSomVisualization.getRede().getNeuronio(i, j).getPadroes().size() + "", enumera(mCornersY, mCornersX).x, enumera(mCornersY, mCornersX).y);
                        }
                    }
                }

            }
        }
    }

    public static void setcNeuronio(Color cNeuronio) {
        MatrizDensidade.cNeuronio = cNeuronio;
    }

    public static void setsNeuronio(Color sNeuronio) {
        MatrizDensidade.sNeuronio = sNeuronio;
    }

    public static void setExibePadroes(boolean exibePadroes) {
        MatrizDensidade.exibePadroes = exibePadroes;
    }

    public Color getcNeuronio() {
        return cNeuronio;
    }

    public Color getsNeuronio() {
        return sNeuronio;
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