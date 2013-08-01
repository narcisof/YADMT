/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som.visualization;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Thiago Faino
 */
public final class MatrizU3D extends javax.swing.JPanel {

    private FrameSomVisualization gui;
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

        if (FrameSomVisualization.getInstance().getMatrizU() != null) {
            //DESENHA OS EIXOS
//            for (int i = 1; i < FrameVisualization.getEixos().size(); i++) {
//                g.drawLine(FrameVisualization.getEixos().get(0).x, FrameVisualization.getEixos().get(0).y, FrameVisualization.getEixos().get(i).x, FrameVisualization.getEixos().get(i).y);
//
//            }
//
//            if (FrameVisualization.getEixos().size() == 4) {
//                g.drawString("0", FrameVisualization.getEixos().get(0).x, FrameVisualization.getEixos().get(0).y);
//                g.drawString("X", FrameVisualization.getEixos().get(1).x, FrameVisualization.getEixos().get(1).y);
//                g.drawString("Y", FrameVisualization.getEixos().get(2).x, FrameVisualization.getEixos().get(2).y);
//                g.drawString("Z", FrameVisualization.getEixos().get(3).x, FrameVisualization.getEixos().get(3).y);
//            }
            ///////////////////
            gridMUX = FrameSomVisualization.getGridMUX();
            gridMUY = FrameSomVisualization.getGridMUY();
            calcIntervalo();
            //////////////////////////////CANTO 1
            if (FrameSomVisualization.getCanto1() == 1 && FrameSomVisualization.getCanto2() == 2) {
                for (int i = 0; i < (gridMUX) - 1; i++) {
                    for (int j = 0; j < (gridMUY) - 1; j++) {
                        int xx[] = {FrameSomVisualization.getPontosDraw(i, j).x, FrameSomVisualization.getPontosDraw(i, j + 1).x,
                            FrameSomVisualization.getPontosDraw(i + 1, j + 1).x, FrameSomVisualization.getPontosDraw(i + 1, j).x};
                        int yy[] = {FrameSomVisualization.getPontosDraw(i, j).y, FrameSomVisualization.getPontosDraw(i, j + 1).y,
                            FrameSomVisualization.getPontosDraw(i + 1, j + 1).y, FrameSomVisualization.getPontosDraw(i + 1, j).y};
                        g.setColor(getColor(i, i + 1, j, j + 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameSomVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            if (FrameSomVisualization.getCanto1() == 1 && FrameSomVisualization.getCanto2() == 3) {
                for (int j = 0; j < (gridMUY) - 1; j++) {
                    for (int i = 0; i < (gridMUX) - 1; i++) {
                        int xx[] = {FrameSomVisualization.getPontosDraw(i, j).x, FrameSomVisualization.getPontosDraw(i, j + 1).x,
                            FrameSomVisualization.getPontosDraw(i + 1, j + 1).x, FrameSomVisualization.getPontosDraw(i + 1, j).x};
                        int yy[] = {FrameSomVisualization.getPontosDraw(i, j).y, FrameSomVisualization.getPontosDraw(i, j + 1).y,
                            FrameSomVisualization.getPontosDraw(i + 1, j + 1).y, FrameSomVisualization.getPontosDraw(i + 1, j).y};
                        g.setColor(getColor(i, i + 1, j, j + 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameSomVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            ///////////////////////////////// CANTO 2
            if (FrameSomVisualization.getCanto1() == 2 && FrameSomVisualization.getCanto2() == 1) {
                for (int i = 0; i < (gridMUX) - 1; i++) {
                    for (int j = (gridMUY) - 1; j > 0; j--) {
                        int xx[] = {FrameSomVisualization.getPontosDraw(i, j).x, FrameSomVisualization.getPontosDraw(i, j - 1).x,
                            FrameSomVisualization.getPontosDraw(i + 1, j - 1).x, FrameSomVisualization.getPontosDraw(i + 1, j).x};
                        int yy[] = {FrameSomVisualization.getPontosDraw(i, j).y, FrameSomVisualization.getPontosDraw(i, j - 1).y,
                            FrameSomVisualization.getPontosDraw(i + 1, j - 1).y, FrameSomVisualization.getPontosDraw(i + 1, j).y};
                        g.setColor(getColor(i, i + 1, j, j - 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameSomVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            if (FrameSomVisualization.getCanto1() == 2 && FrameSomVisualization.getCanto2() == 4) {
                for (int j = (gridMUY) - 1; j > 0; j--) {
                    for (int i = 0; i < (gridMUX) - 1; i++) {
                        int xx[] = {FrameSomVisualization.getPontosDraw(i, j).x, FrameSomVisualization.getPontosDraw(i, j - 1).x,
                            FrameSomVisualization.getPontosDraw(i + 1, j - 1).x, FrameSomVisualization.getPontosDraw(i + 1, j).x};
                        int yy[] = {FrameSomVisualization.getPontosDraw(i, j).y, FrameSomVisualization.getPontosDraw(i, j - 1).y,
                            FrameSomVisualization.getPontosDraw(i + 1, j - 1).y, FrameSomVisualization.getPontosDraw(i + 1, j).y};
                        g.setColor(getColor(i, i + 1, j, j - 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameSomVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            //////////////////////////////CANTO 3
            if (FrameSomVisualization.getCanto1() == 3 && FrameSomVisualization.getCanto2() == 1) { // 
                for (int j = 0; j < (gridMUY) - 1; j++) {
                    for (int i = (gridMUX) - 1; i > 0; i--) {
                        int xx[] = {FrameSomVisualization.getPontosDraw(i, j).x, FrameSomVisualization.getPontosDraw(i, j + 1).x,
                            FrameSomVisualization.getPontosDraw(i - 1, j + 1).x, FrameSomVisualization.getPontosDraw(i - 1, j).x};
                        int yy[] = {FrameSomVisualization.getPontosDraw(i, j).y, FrameSomVisualization.getPontosDraw(i, j + 1).y,
                            FrameSomVisualization.getPontosDraw(i - 1, j + 1).y, FrameSomVisualization.getPontosDraw(i - 1, j).y};
                        g.setColor(getColor(i, i - 1, j, j + 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameSomVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            if (FrameSomVisualization.getCanto1() == 3 && FrameSomVisualization.getCanto2() == 4) {
                for (int i = (gridMUX) - 1; i > 0; i--) {
                    for (int j = 0; j < (gridMUY) - 1; j++) {
                        int xx[] = {FrameSomVisualization.getPontosDraw(i, j).x, FrameSomVisualization.getPontosDraw(i, j + 1).x,
                            FrameSomVisualization.getPontosDraw(i - 1, j + 1).x, FrameSomVisualization.getPontosDraw(i - 1, j).x};
                        int yy[] = {FrameSomVisualization.getPontosDraw(i, j).y, FrameSomVisualization.getPontosDraw(i, j + 1).y,
                            FrameSomVisualization.getPontosDraw(i - 1, j + 1).y, FrameSomVisualization.getPontosDraw(i - 1, j).y};
                        g.setColor(getColor(i, i - 1, j, j + 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameSomVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            ///////////////////////////////// CANTO 4
            if (FrameSomVisualization.getCanto1() == 4 && FrameSomVisualization.getCanto2() == 2) {
                for (int j = (gridMUY) - 1; j > 0; j--) {
                    for (int i = (gridMUX) - 1; i > 0; i--) {
                        int xx[] = {FrameSomVisualization.getPontosDraw(i, j).x, FrameSomVisualization.getPontosDraw(i, j - 1).x,
                            FrameSomVisualization.getPontosDraw(i - 1, j - 1).x, FrameSomVisualization.getPontosDraw(i - 1, j).x};
                        int yy[] = {FrameSomVisualization.getPontosDraw(i, j).y, FrameSomVisualization.getPontosDraw(i, j - 1).y,
                            FrameSomVisualization.getPontosDraw(i - 1, j - 1).y, FrameSomVisualization.getPontosDraw(i - 1, j).y};
                        g.setColor(getColor(i, i - 1, j, j - 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameSomVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            if (FrameSomVisualization.getCanto1() == 4 && FrameSomVisualization.getCanto2() == 3) {
                for (int i = (gridMUX) - 1; i > 0; i--) {
                    for (int j = (gridMUY) - 1; j > 0; j--) {
                        int xx[] = {FrameSomVisualization.getPontosDraw(i, j).x, FrameSomVisualization.getPontosDraw(i, j - 1).x,
                            FrameSomVisualization.getPontosDraw(i - 1, j - 1).x, FrameSomVisualization.getPontosDraw(i - 1, j).x};
                        int yy[] = {FrameSomVisualization.getPontosDraw(i, j).y, FrameSomVisualization.getPontosDraw(i, j - 1).y,
                            FrameSomVisualization.getPontosDraw(i - 1, j - 1).y, FrameSomVisualization.getPontosDraw(i - 1, j).y};
                        g.setColor(getColor(i, i - 1, j, j - 1));
                        g.fillPolygon(xx, yy, 4);
                        g.setColor(FrameSomVisualization.getCor_linha());
                        g.drawPolygon(xx, yy, 4);
                    }
                }
            }
            ////////////////////////////////////////////////////////
        }

    }

    public void calcIntervalo() {
        double max = -Double.MAX_VALUE;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < gridMUX; i++) {
            for (int j = 0; j < gridMUY; j++) {
                if (FrameSomVisualization.getMatrizU()[i][j] > max) {
                    max = FrameSomVisualization.getMatrizU()[i][j];
                }
                if (FrameSomVisualization.getMatrizU()[i][j] < min) {
                    min = FrameSomVisualization.getMatrizU()[i][j];
                }
            }
        }
        intervalo = (max - min) / 10;
    }

    public Color getColor(int i1, int i2, int j1, int j2) {
        Color cor = null;
        ArrayList<Double> list = new ArrayList<>();
        list.add(FrameSomVisualization.getMatrizU()[i1][j1]);
        list.add(FrameSomVisualization.getMatrizU()[i1][j2]);
        list.add(FrameSomVisualization.getMatrizU()[i2][j1]);
        list.add(FrameSomVisualization.getMatrizU()[i2][j2]);

        Collections.sort(list);

        double media = (list.get(2) + list.get(3)) / 2;

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
