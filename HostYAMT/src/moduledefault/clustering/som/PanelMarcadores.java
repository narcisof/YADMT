/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

import moduledefault.clustering.som.visualization.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public final class PanelMarcadores extends javax.swing.JPanel {

    private int NUM_HEX_CORNERS = 6;
    private int[] mCornersX = new int[NUM_HEX_CORNERS];
    private int[] mCornersY = new int[NUM_HEX_CORNERS];
    private HexGrid mCellMetrics;
    private int gridMUX;
    private int gridMUY;
    double intervalo;
    private static boolean grayScale = false;
    public static ArrayList<Polygon> p = new ArrayList<>();

    /**
     * Creates new form Draw2D
     */
    public PanelMarcadores() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (FrameSomVisualization.getInstance().getMatrizU() != null) {
            gridMUX = FrameSomVisualization.getGridMUX();
            gridMUY = FrameSomVisualization.getGridMUY();
            calcIntervalo();

            mCellMetrics = new HexGrid(FrameSomVisualization.getValueU2D());
            for (int i = 0; i < gridMUX; i++) {
                for (int j = 0; j < gridMUY; j++) {
                    mCellMetrics.setCellIndex(i, j);
                    mCellMetrics.computeCorners(mCornersX, mCornersY);
                    g.setColor(getColor(i, j));
                    g.drawPolygon(mCornersX, mCornersY, NUM_HEX_CORNERS);
                    g.fillPolygon(mCornersX, mCornersY, NUM_HEX_CORNERS);
                }
            }
            
            if (!p.isEmpty()) {
                g.setColor(Color.BLACK);
                for (int i = 0; i < p.size(); i++) {
                    g.fillPolygon(p.get(i));
                    g.drawPolygon(p.get(i));
                }
            }
        }
    }

    public static void addP(Polygon p) {
        PanelMarcadores.p.add(p);
    }

    public static ArrayList<Polygon> getP() {
        return p;
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

    public void calcIntervalo() {
        double max = -99999999;
        for (int i = 0; i < gridMUX; i++) {
            for (int j = 0; j < gridMUY; j++) {
                if (FrameSomVisualization.getMatrizU()[i][j] > max) {
                    max = FrameSomVisualization.getMatrizU()[i][j];
                }
            }
        }
        double min = 99999999;
        for (int i = 0; i < gridMUX; i++) {
            for (int j = 0; j < gridMUY; j++) {
                if (FrameSomVisualization.getMatrizU()[i][j] < min) {
                    min = FrameSomVisualization.getMatrizU()[i][j];
                }
            }
        }
        intervalo = (max - min) / 10;
    }

    public Color getColor(int i, int j) {
        Color cor = null;
        int rgb;
        if ((FrameSomVisualization.getMatrizU()[i][j] > 0) && (FrameSomVisualization.getMatrizU()[i][j] <= intervalo)) { //Cor 1
            if (grayScale) {
                rgb = (int) ((25 * 0.299) + (25 * 0.587) + (112 * 0.114));
                rgb = getRGB(rgb, rgb, rgb);
                cor = new Color(rgb);
            } else {
                cor = new Color(25, 25, 112);
            }
        } else if ((FrameSomVisualization.getMatrizU()[i][j] > intervalo) && (FrameSomVisualization.getMatrizU()[i][j] <= intervalo * 2)) { //Cor 2
            if (grayScale) {
                rgb = (int) ((0 * 0.299) + (0 * 0.587) + (205 * 0.114));
                rgb = getRGB(rgb, rgb, rgb);
                cor = new Color(rgb);
            } else {
                cor = new Color(0, 0, 205);
            }
        } else if ((FrameSomVisualization.getMatrizU()[i][j] > intervalo * 2) && (FrameSomVisualization.getMatrizU()[i][j] <= intervalo * 3)) { //Cor 3

            if (grayScale) {
                rgb = (int) ((0 * 0.299) + (191 * 0.587) + (255 * 0.114));
                rgb = getRGB(rgb, rgb, rgb);
                cor = new Color(rgb);
            } else {
                cor = new Color(0, 191, 255);
            }
        } else if ((FrameSomVisualization.getMatrizU()[i][j] > intervalo * 3) && (FrameSomVisualization.getMatrizU()[i][j] <= intervalo * 4)) { //Cor 4

            if (grayScale) {
                rgb = (int) ((64 * 0.299) + (224 * 0.587) + (208 * 0.114));
                rgb = getRGB(rgb, rgb, rgb);
                cor = new Color(rgb);
            } else {
                cor = new Color(64, 224, 208);
            }
        } else if ((FrameSomVisualization.getMatrizU()[i][j] > intervalo * 4) && (FrameSomVisualization.getMatrizU()[i][j] <= intervalo * 5)) { //Cor 5

            if (grayScale) {
                rgb = (int) ((0 * 0.299) + (255 * 0.587) + (127 * 0.114));
                rgb = getRGB(rgb, rgb, rgb);
                cor = new Color(rgb);
            } else {
                cor = new Color(0, 255, 127);
            }
        } else if ((FrameSomVisualization.getMatrizU()[i][j] > intervalo * 5) && (FrameSomVisualization.getMatrizU()[i][j] <= intervalo * 6)) { //Cor 6

            if (grayScale) {
                rgb = (int) ((154 * 0.299) + (205 * 0.587) + (50 * 0.114));
                rgb = getRGB(rgb, rgb, rgb);
                cor = new Color(rgb);
            } else {
                cor = new Color(154, 205, 50);
            }
        } else if ((FrameSomVisualization.getMatrizU()[i][j] > intervalo * 6) && (FrameSomVisualization.getMatrizU()[i][j] <= intervalo * 7)) { //Cor 7

            if (grayScale) {
                rgb = (int) ((255 * 0.299) + (255 * 0.587) + (0 * 0.114));
                rgb = getRGB(rgb, rgb, rgb);
                cor = new Color(rgb);
            } else {
                cor = new Color(255, 255, 0);
            }
        } else if ((FrameSomVisualization.getMatrizU()[i][j] > intervalo * 7) && (FrameSomVisualization.getMatrizU()[i][j] <= intervalo * 8)) { //Cor 8

            if (grayScale) {
                rgb = (int) ((255 * 0.299) + (165 * 0.587) + (0 * 0.114));
                rgb = getRGB(rgb, rgb, rgb);
                cor = new Color(rgb);
            } else {
                cor = new Color(255, 165, 0);
            }
        } else if ((FrameSomVisualization.getMatrizU()[i][j] > intervalo * 8) && (FrameSomVisualization.getMatrizU()[i][j] <= intervalo * 9)) { //Cor 9

            if (grayScale) {
                rgb = (int) ((255 * 0.299) + (127 * 0.587) + (0 * 0.114));
                rgb = getRGB(rgb, rgb, rgb);
                cor = new Color(rgb);
            } else {
                cor = new Color(255, 127, 0);
            }
        } else if ((FrameSomVisualization.getMatrizU()[i][j] > intervalo * 9) && (FrameSomVisualization.getMatrizU()[i][j] <= intervalo * 10)) { //Cor 10
            if (grayScale) {
                rgb = (int) ((255 * 0.299) + (0 * 0.587) + (0 * 0.114));
                rgb = getRGB(rgb, rgb, rgb);
                cor = new Color(rgb);
            } else {
                cor = new Color(255, 0, 0);
            }
        }
        return cor;
    }

    public static int getRGB(int r, int g, int b) {
        return 65536 * r + 256 * g + b;
    }
}
