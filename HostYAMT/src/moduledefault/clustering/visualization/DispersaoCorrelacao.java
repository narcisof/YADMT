/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mateus
 */
public class DispersaoCorrelacao extends javax.swing.JPanel {

    /**
     * Creates new form DispersaoCorrelacao
     */
    public DispersaoCorrelacao() {
        initComponents();
    }

    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = TecnicasDispersao.getFundoDispersaoCorrelacao().getWidth();
        int height = TecnicasDispersao.getFundoDispersaoCorrelacao().getHeight();
        float w = width / 2;
        float h = height / 2;
        float m = width / TecnicasDispersao.getMatrizDados().getLinhas() + 2;
        int tamPixel = (int) m;
        int x0 = 50 + (int) 0 * (width - 120);
        int y0 = (height - 70) - (int) 0 * (height - 120) + tamPixel;
        int x1 = 50 + (int) 1 * (width - 120) + tamPixel;
        int y1 = (height - 70) - (int) 0 * (height - 120) + tamPixel;
        int x2 = 50 + (int) 0 * (width - 120);
        int y2 = (height - 70) - (int) 1 * (height - 120) - tamPixel;
        g.setColor(Color.black);
        g.drawLine(x0, y0, x1, y1);//x
        g.drawLine(x0, y0, x2, y2);//y

        //escala para y
        int aux = 0;
        int escala = (int) (y0 - y2) / 10;
        int soma = y2;
        String[] coco = {"1", "0.9", "0.8", "0.7", "0.6", "0.5", "0.4", "0.3", "0.2", "0.1", "0"};
        while (soma <= y0) {
            g.drawLine(x0 - 5, soma, x0 + 5, soma);
            g.drawString(coco[aux], x0 - 25, soma + 5);
            aux++;
            soma += escala;
        }
        //escala para x
        aux = 0;
        escala = (int) (x1 - x0) / 10;
        soma = x0;
        String[] coco2 = {"0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1"};
        while (soma <= x1) {
            g.drawLine(soma, y0 - 5, soma, y0 + 5);
            g.drawString(coco2[aux], soma - 7, y0 + 20);
            aux++;
            soma += escala;
        }
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int xMa = 0;
        int yMa;
        int xMe = 0;
        int yMe = 0;
        int atributo1 = TecnicasDispersao.getComboBoxEixoXCorrelacao().getSelectedIndex();
        int atributo2 = TecnicasDispersao.getComboBoxEixoYCorrelacao().getSelectedIndex();
        int atributo3 = TecnicasDispersao.getComboBoxEixoZCorrelacao().getSelectedIndex();
        int grupoEscolhido = TecnicasDispersao.getComboBoxGruposCorrelacao().getSelectedIndex();
        System.out.println("grupoEscolhido = " + grupoEscolhido);
        if (TecnicasDispersao.getMatrizGrupos() != null) {
            for (int i = 0; i < TecnicasDispersao.getMatrizDados().getLinhas(); i++) {
                if (TecnicasDispersao.getMatrizGrupos()[1][i] == grupoEscolhido) {
                    int x = 50 + (int) (TecnicasDispersao.getMatrizDados().getMatriz_dados()[TecnicasDispersao.getMatrizGrupos()[0][i] - 1][atributo1] * (width - 120));
                    int y = (height - 70) - (int) (TecnicasDispersao.getMatrizDados().getMatriz_dados()[TecnicasDispersao.getMatrizGrupos()[0][i] - 1][atributo2] * (height - 120));
                    if (x > maior) {
                        xMa = x;
                        yMa = y;
                        maior = x;
                    }
                    if (x < menor) {
                        xMe = x;
                        yMe = y;
                        menor = x;
                    }
                    switch (TecnicasDispersao.getMatrizDados().getGrupos()[TecnicasDispersao.getMatrizGrupos()[0][i] - 1]) {
                        case "Iris-setosa":
                            g.setColor(Color.red);
                            break;
                        case "Iris-versicolor":
                            g.setColor(Color.blue);
                            //  System.out.println("Atributo = "+(ClusteringFrameVisualization.getMatrizGrupos()[0][i]-1+" AZUULLLLL"));
                            break;
                        default:
                            g.setColor(Color.green);
                            break;
                    }
                    g.fillOval(x, y, tamPixel, tamPixel);
                }
            }


            g.drawRect(xMe, yMe, xMa, yMe);
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