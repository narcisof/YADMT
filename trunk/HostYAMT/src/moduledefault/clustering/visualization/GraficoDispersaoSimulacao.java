
package moduledefault.clustering.visualization;

import java.awt.Color;
import java.awt.Graphics;
import moduledefault.clustering.view.jpanel.PanelFormigas;

/**
 *
 * @author Mateus
 */
public class GraficoDispersaoSimulacao extends javax.swing.JPanel {

    private static int[][] matrizPadroes;
    public GraficoDispersaoSimulacao() {
        initComponents();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = PanelFormigas.getFundoSimulacao().getWidth();
        int height = PanelFormigas.getFundoSimulacao().getHeight();

        float w = width / 2;
        float h = height / 2;

        int x0 = width - (width - 50);
        int y0 = height - (height - 50);
        int x2 = width - 50;
        int y2 = height - 50;

        g.setColor(Color.black);
        g.drawString("1", x0, y0);
        g.drawString("2", x2, y0);
        g.drawString("3", x0, y2);
        g.drawString("4", x2, y2);

        g.drawLine(x0, y0, x2, y0);
        g.drawLine(x0, y0, x0, y2);
        g.drawLine(x2, y0, x2, y2);
        g.drawLine(x0, y2, x2, y2);

        for (int i = 0; i < PanelFormigas.getDados().getDimensão_matriz(); i++) {
            for (int j = 0; j < PanelFormigas.getDados().getDimensão_matriz(); j++) {
                if (matrizPadroes[i][j] != 0) {
                    int x = x0 + j * ((((width - 100) / PanelFormigas.getDados().getDimensão_matriz())));
                    int y = y0 + i * ((((height - 100) / PanelFormigas.getDados().getDimensão_matriz())));
                    switch (PanelFormigas.getDados().getGrupos()[(matrizPadroes[i][j] - 1)]) {
                        case "Iris-setosa":
                            g.setColor(Color.red);
                            break;
                        case "Iris-versicolor":
                            g.setColor(Color.blue);
                            break;
                        default:
                            g.setColor(Color.green);
                            break;
                    }
                    g.fillOval(x, y, 10, 10);
                }
            }
        }
        g.setColor(Color.black);
    }

    public void setACO(int[][] a) {
        matrizPadroes = a;
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
