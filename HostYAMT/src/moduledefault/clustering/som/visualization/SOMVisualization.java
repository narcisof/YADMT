/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som.visualization;

import java.awt.Color;
import java.awt.Graphics;
import moduledefault.clustering.som.RedeSOM;

/**
 *
 * @author Thiago
 */
public class SOMVisualization extends javax.swing.JPanel {

    private RedeSOM rede = null;

    public SOMVisualization(RedeSOM r) {
        initComponents();
        rede = r;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int atributo1 = FrameSomVisualization.getjComboBoxEixoX().getSelectedIndex();
        int atributo2 = FrameSomVisualization.getjComboBoxEixoY().getSelectedIndex();
        int atributo3 = FrameSomVisualization.getjComboBoxEixoZ().getSelectedIndex();

        if (atributo3 == 0) {
            int width = FrameSomVisualization.getPanelSOM().getWidth();
            int height = FrameSomVisualization.getPanelSOM().getHeight();
            float w = width / 2;
            float h = height / 2;

            int centroWidth = (int) w;
            int centroHeight = (int) h;

            if (width > height) { //ARRUMAR ESSAS VARIAVEIS GAMBI
                width = height;
            } else {
                height = width;
            }

            int x0 = width - (width - 50);
            int y0 = height - (height - 50);
            int x2 = width - 20;
            int y2 = height - 20;

            g.setColor(Color.black);
            g.drawString("Y", x0 - 10, y0 - 10);
            // g.drawString("2", x2, y0);
            // g.drawString("3", x0, y2);
            g.drawString("X", x2 + 10, y2 + 10);

            //g.drawLine(x0, y0, x2, y0);//1-2
            g.drawLine(x0, y0, x0, y2);//1-3
            //g.drawLine(x2, y0, x2, y2);//2-4
            g.drawLine(x0, y2, x2, y2);//3-4

            int escala = (int) height / 10;
            int soma = escala;
            while (soma <= height) {
                //   g.drawLine(x0 - 5, soma, x0 +5, soma);
                soma += escala;
            }

            float m = width / 100;
            int tamPixel = 7;//(int) m;

            if (FrameSomVisualization.getDados() != null) {
                for (int i = 0; i < FrameSomVisualization.getDados().getDataSet().size(); i++) {
                    int x = 50 + (int) (FrameSomVisualization.getDados().getDataSet().get(i).getAtributos().get(atributo1) * (width - 120));
                    int y = (height - 70) - (int) (FrameSomVisualization.getDados().getDataSet().get(i).getAtributos().get(atributo2) * (height - 120));
                    g.setColor(Color.green);
                    g.fillOval(x, y, tamPixel, tamPixel);
                }
                g.setColor(Color.black);
            }
            if (rede != null) {

                for (int i = 0; i < rede.getGridX(); i++) {
                    for (int j = 0; j < rede.getGridY(); j++) {
                        int x = 50 + (int) (rede.getNeuronio(i, j).getPesos().get(atributo1) * (width - 120));
                        int y = (height - 70) - (int) (rede.getNeuronio(i, j).getPesos().get(atributo2) * (height - 120));
                        g.fillOval(x, y, tamPixel, tamPixel);
                    }
                }
                for (int i = 0; i < rede.getGridX(); i++) {
                    for (int j = 0; j < rede.getGridY() - 1; j++) {
                        int x = 50 + (int) (rede.getNeuronio(i, j).getPesos().get(atributo1) * (width - 120));
                        int y = (height - 70) - (int) (rede.getNeuronio(i, j).getPesos().get(atributo2) * (height - 120));
                        int x1 = 50 + (int) (rede.getNeuronio(i, j + 1).getPesos().get(atributo1) * (width - 120));
                        int y1 = (height - 70) - (int) (rede.getNeuronio(i, j + 1).getPesos().get(atributo2) * (height - 120));
                        g.drawLine(x, y, x1, y1);
                    }
                }

                for (int i = 0; i < rede.getGridX() - 1; i++) {
                    for (int j = 0; j < rede.getGridY(); j++) {
                        int x = 50 + (int) (rede.getNeuronio(i, j).getPesos().get(atributo1) * (width - 120));
                        int y = (height - 70) - (int) (rede.getNeuronio(i, j).getPesos().get(atributo2) * (height - 120));
                        int x1 = 50 + (int) (rede.getNeuronio(i + 1, j).getPesos().get(atributo1) * (width - 120));
                        int y1 = (height - 70) - (int) (rede.getNeuronio(i + 1, j).getPesos().get(atributo2) * (height - 120));
                        g.drawLine(x, y, x1, y1);
                    }
                }
            }
        } else {
            g.setColor(Color.green);
            for (int i = 0; i < FrameSomVisualization.getPontos2DBase().size(); i++) {
                g.fillOval(FrameSomVisualization.getPontos2DBase().get(i).x, FrameSomVisualization.getPontos2DBase().get(i).y, 5, 5);
            }
            g.setColor(Color.BLACK);
            for (int i = 0; i < FrameSomVisualization.getPontos2DRede().size(); i++) {
                g.fillOval(FrameSomVisualization.getPontos2DRede().get(i).x, FrameSomVisualization.getPontos2DRede().get(i).y, 5, 5);
            }
            
            for (int j = 0; j < FrameSomVisualization.getRede().getRede().length - 1; j++) {
                    for (int i = 0; i < FrameSomVisualization.getRede().getRede()[0].length - 1; i++) {
                        int xx[] = {FrameSomVisualization.getPontosDrawRede(i, j).x, FrameSomVisualization.getPontosDrawRede(i, j + 1).x,
                            FrameSomVisualization.getPontosDrawRede(i + 1, j + 1).x, FrameSomVisualization.getPontosDrawRede(i + 1, j).x};
                        int yy[] = {FrameSomVisualization.getPontosDrawRede(i, j).y, FrameSomVisualization.getPontosDrawRede(i, j + 1).y,
                            FrameSomVisualization.getPontosDrawRede(i + 1, j + 1).y, FrameSomVisualization.getPontosDrawRede(i + 1, j).y};
                        g.drawPolygon(xx, yy, 4);
                    }
                }
        }
    }

    public void setRede(RedeSOM r) {
        rede = r;
        repaint();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

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

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
