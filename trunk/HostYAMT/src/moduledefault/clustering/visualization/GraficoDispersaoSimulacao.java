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
    private static Color[] coresAux = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.BLACK};
    private static Color[] cores;

    public GraficoDispersaoSimulacao() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = PanelFormigas.getFundoSimulacao().getWidth();
        int height = PanelFormigas.getFundoSimulacao().getHeight();

        int x0 = width - (width - 50);
        int y0 = height - (height - 50);
        int x2 = width - 50;
        int y2 = height - 50;
        g.setColor(Color.black);
        iniciaVetorCores();
        float m = (x2 - x0) / PanelFormigas.getDados().getLinhas() ;
        int tamPixelX = (int) m+4;
        int tamPixelY = (int) ((y2 - y0) / PanelFormigas.getDados().getLinhas())+4;
        for (int i = 0; i < PanelFormigas.getDados().getDimensão_matriz(); i++) {
            for (int j = 0; j < PanelFormigas.getDados().getDimensão_matriz(); j++) {
                if (matrizPadroes[i][j] != 0) {
                    int x = x0 + j * ((((width - 100) / PanelFormigas.getDados().getDimensão_matriz())));
                    int y = y0 + i * ((((height - 100) / PanelFormigas.getDados().getDimensão_matriz())));
                    for (int k = 0; k < cores.length; k++) {
                        if (PanelFormigas.getDados().getGrupos()[(matrizPadroes[i][j] - 1)].equals(PanelFormigas.getDados().getRealClasses().get(k))) {
                            g.setColor(cores[k]);
                        }
                    }
                    g.fillOval(x, y, tamPixelX, tamPixelY);
                }
            }
        }
        g.setColor(Color.black);
    }

    public void setACO(int[][] a) {
        matrizPadroes = a;
        repaint();
    }

    private void iniciaVetorCores() {
        cores = new Color[TecnicasDispersao.getMatrizDados().getRealClasses().size()];
        for (int i = 0; i < cores.length; i++) {
            cores[i] = coresAux[i];
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder("Simulação"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
