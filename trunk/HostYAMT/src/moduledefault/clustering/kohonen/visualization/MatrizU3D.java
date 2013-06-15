/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kohonen.visualization;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Thiago Faino
 */
public final class MatrizU3D extends javax.swing.JPanel {

    private FrameVisualization gui;
    private int gridMUX;
    private int gridMUY;
    double matrizU[][];
    double intervalo;

    public MatrizU3D() {
        initComponents();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (FrameVisualization.getInstance().getMatrizU() != null) {

            gridMUX = FrameVisualization.getGridMUX();
            gridMUY = FrameVisualization.getGridMUY();
            calcIntervalo();
            //////////////////////////////CANTO 1
            if (FrameVisualization.getCanto1() == 1 && FrameVisualization.getCanto2() == 2) {
                for (int i = 0; i < (gridMUX) - 1; i++) {
                    for (int j = 0; j < (gridMUY) - 1; j++) {
                        int xx[] = {FrameVisualization.getPontosDraw(i, j).x, FrameVisualization.getPontosDraw(i, j + 1).x,
                            FrameVisualization.getPontosDraw(i + 1, j + 1).x, FrameVisualization.getPontosDraw(i + 1, j).x};
                        int yy[] = {FrameVisualization.getPontosDraw(i, j).y, FrameVisualization.getPontosDraw(i, j + 1).y,
                            FrameVisualization.getPontosDraw(i + 1, j + 1).y, FrameVisualization.getPontosDraw(i + 1, j).y};
                        g.setColor(getColor(i, i + 1, j, j + 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            if (FrameVisualization.getCanto1() == 1 && FrameVisualization.getCanto2() == 3) {
                for (int j = 0; j < (gridMUY) - 1; j++) {
                    for (int i = 0; i < (gridMUX) - 1; i++) {
                        int xx[] = {FrameVisualization.getPontosDraw(i, j).x, FrameVisualization.getPontosDraw(i, j + 1).x,
                            FrameVisualization.getPontosDraw(i + 1, j + 1).x, FrameVisualization.getPontosDraw(i + 1, j).x};
                        int yy[] = {FrameVisualization.getPontosDraw(i, j).y, FrameVisualization.getPontosDraw(i, j + 1).y,
                            FrameVisualization.getPontosDraw(i + 1, j + 1).y, FrameVisualization.getPontosDraw(i + 1, j).y};
                        g.setColor(getColor(i, i + 1, j, j + 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            ///////////////////////////////// CANTO 2
            if (FrameVisualization.getCanto1() == 2 && FrameVisualization.getCanto2() == 1) {
                for (int i = 0; i < (gridMUX) - 1; i++) {
                    for (int j = (gridMUY) - 1; j > 0; j--) {
                        int xx[] = {FrameVisualization.getPontosDraw(i, j).x, FrameVisualization.getPontosDraw(i, j - 1).x,
                            FrameVisualization.getPontosDraw(i + 1, j - 1).x, FrameVisualization.getPontosDraw(i + 1, j).x};
                        int yy[] = {FrameVisualization.getPontosDraw(i, j).y, FrameVisualization.getPontosDraw(i, j - 1).y,
                            FrameVisualization.getPontosDraw(i + 1, j - 1).y, FrameVisualization.getPontosDraw(i + 1, j).y};
                        g.setColor(getColor(i, i + 1, j, j - 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            if (FrameVisualization.getCanto1() == 2 && FrameVisualization.getCanto2() == 4) {
                for (int j = (gridMUY) - 1; j > 0; j--) {
                    for (int i = 0; i < (gridMUX) - 1; i++) {
                        int xx[] = {FrameVisualization.getPontosDraw(i, j).x, FrameVisualization.getPontosDraw(i, j - 1).x,
                            FrameVisualization.getPontosDraw(i + 1, j - 1).x, FrameVisualization.getPontosDraw(i + 1, j).x};
                        int yy[] = {FrameVisualization.getPontosDraw(i, j).y, FrameVisualization.getPontosDraw(i, j - 1).y,
                            FrameVisualization.getPontosDraw(i + 1, j - 1).y, FrameVisualization.getPontosDraw(i + 1, j).y};
                        g.setColor(getColor(i, i + 1, j, j - 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            //////////////////////////////CANTO 3
            if (FrameVisualization.getCanto1() == 3 && FrameVisualization.getCanto2() == 1) { // 
                for (int j = 0; j < (gridMUY) - 1; j++) {
                    for (int i = (gridMUX) - 1; i > 0; i--) {
                        int xx[] = {FrameVisualization.getPontosDraw(i, j).x, FrameVisualization.getPontosDraw(i, j + 1).x,
                            FrameVisualization.getPontosDraw(i - 1, j + 1).x, FrameVisualization.getPontosDraw(i - 1, j).x};
                        int yy[] = {FrameVisualization.getPontosDraw(i, j).y, FrameVisualization.getPontosDraw(i, j + 1).y,
                            FrameVisualization.getPontosDraw(i - 1, j + 1).y, FrameVisualization.getPontosDraw(i - 1, j).y};
                        g.setColor(getColor(i, i - 1, j, j + 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            if (FrameVisualization.getCanto1() == 3 && FrameVisualization.getCanto2() == 4) {
                for (int i = (gridMUX) - 1; i > 0; i--) {
                    for (int j = 0; j < (gridMUY) - 1; j++) {
                        int xx[] = {FrameVisualization.getPontosDraw(i, j).x, FrameVisualization.getPontosDraw(i, j + 1).x,
                            FrameVisualization.getPontosDraw(i - 1, j + 1).x, FrameVisualization.getPontosDraw(i - 1, j).x};
                        int yy[] = {FrameVisualization.getPontosDraw(i, j).y, FrameVisualization.getPontosDraw(i, j + 1).y,
                            FrameVisualization.getPontosDraw(i - 1, j + 1).y, FrameVisualization.getPontosDraw(i - 1, j).y};
                        g.setColor(getColor(i, i - 1, j, j + 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            ///////////////////////////////// CANTO 4
            if (FrameVisualization.getCanto1() == 4 && FrameVisualization.getCanto2() == 2) {
                for (int j = (gridMUY) - 1; j > 0; j--) {
                    for (int i = (gridMUX) - 1; i > 0; i--) {
                        int xx[] = {FrameVisualization.getPontosDraw(i, j).x, FrameVisualization.getPontosDraw(i, j - 1).x,
                            FrameVisualization.getPontosDraw(i - 1, j - 1).x, FrameVisualization.getPontosDraw(i - 1, j).x};
                        int yy[] = {FrameVisualization.getPontosDraw(i, j).y, FrameVisualization.getPontosDraw(i, j - 1).y,
                            FrameVisualization.getPontosDraw(i - 1, j - 1).y, FrameVisualization.getPontosDraw(i - 1, j).y};
                        g.setColor(getColor(i, i - 1, j, j - 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            if (FrameVisualization.getCanto1() == 4 && FrameVisualization.getCanto2() == 3) {
                for (int i = (gridMUX) - 1; i > 0; i--) {
                    for (int j = (gridMUY) - 1; j > 0; j--) {
                        int xx[] = {FrameVisualization.getPontosDraw(i, j).x, FrameVisualization.getPontosDraw(i, j - 1).x,
                            FrameVisualization.getPontosDraw(i - 1, j - 1).x, FrameVisualization.getPontosDraw(i - 1, j).x};
                        int yy[] = {FrameVisualization.getPontosDraw(i, j).y, FrameVisualization.getPontosDraw(i, j - 1).y,
                            FrameVisualization.getPontosDraw(i - 1, j - 1).y, FrameVisualization.getPontosDraw(i - 1, j).y};
                        g.setColor(getColor(i, i - 1, j, j - 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            ////////////////////////////////////////////////////////


//
//        g.setColor(gui.getCor_eixo());
//        for (int i = 1; i < gui.getEixos().size(); i++) {
//            g.drawLine(gui.getEixos().get(0).x, gui.getEixos().get(0).y, gui.getEixos().get(i).x, gui.getEixos().get(i).y);
//
//        }
//        
//        if (gui.getEixos().size() == 4) {
//            g.drawString("0", gui.getEixos().get(0).x, gui.getEixos().get(0).y);
//            g.drawString("X", gui.getEixos().get(1).x, gui.getEixos().get(1).y);
//            g.drawString("Y", gui.getEixos().get(2).x, gui.getEixos().get(2).y);
//            g.drawString("Z", gui.getEixos().get(3).x, gui.getEixos().get(3).y);
//        }


        }

    }

    public void calcIntervalo() {
        double max = -Double.MAX_VALUE;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < gridMUX; i++) {
            for (int j = 0; j < gridMUY; j++) {
                if (FrameVisualization.getMatrizU()[i][j] > max) {
                    max = FrameVisualization.getMatrizU()[i][j];
                }
                if (FrameVisualization.getMatrizU()[i][j] < min) {
                    min = FrameVisualization.getMatrizU()[i][j];
                }
            }
        }

        intervalo = (max - min) / 10;
    }

    public Color getColor(int i1, int i2, int j1, int j2) {
        Color cor = null;
        double media = (FrameVisualization.getMatrizU()[i1][j1] + FrameVisualization.getMatrizU()[i1][j2]
                + FrameVisualization.getMatrizU()[i2][j1] + FrameVisualization.getMatrizU()[i2][j2]) / 4;
        if ((media > 0) && (media <= intervalo)) { //Cor 1
            cor = new Color(25, 25, 112);
        } else if ((media > intervalo) && (media <= intervalo * 2)) { //Cor 2
            cor = new Color(0, 0, 205);
        } else if ((media > intervalo * 2) && (media <= intervalo * 3)) { //Cor 3
            cor = new Color(0, 191, 255);
        } else if ((media > intervalo * 3) && (media <= intervalo * 4)) { //Cor 4
            cor = new Color(64, 224, 208);
        } else if ((media > intervalo * 4) && (media <= intervalo * 5)) { //Cor 5
            cor = new Color(0, 255, 127);
        } else if ((media > intervalo * 5) && (media <= intervalo * 6)) { //Cor 6
            cor = new Color(154, 205, 50);
        } else if ((media > intervalo * 6) && (media <= intervalo * 7)) { //Cor 7
            cor = new Color(255, 255, 0);
        } else if ((media > intervalo * 7) && (media <= intervalo * 8)) { //Cor 8
            cor = new Color(255, 165, 0);
        } else if ((media > intervalo * 8) && (media <= intervalo * 9)) { //Cor 9
            cor = new Color(255, 127, 0);
        } else if ((media > intervalo * 9) && (media <= intervalo * 10)) { //Cor 10
            cor = new Color(255, 0, 0);
        }
        return cor;
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
