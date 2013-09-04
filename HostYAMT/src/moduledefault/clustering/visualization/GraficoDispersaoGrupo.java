/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import moduledefault.clustering.som.visualization.FrameSomVisualization;
import moduledefault.clustering.uteis.Base;
import moduledefault.clustering.uteis.Operações_Mat;

/**
 *
 * @author Mateus
 */
public class GraficoDispersaoGrupo extends javax.swing.JPanel {

    /**
     * Creates new form GraficoDispersaoGrupo
     */
    private static int[][] grupos;
    private static Color[] coresAux = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.BLACK};
    private static Color[] cores;

    public GraficoDispersaoGrupo() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = TecnicasDispersao.getFundoDispersaoGrupos().getWidth();
        int height = TecnicasDispersao.getFundoDispersaoGrupos().getHeight();
        float w = width / 2;
        float h = height / 2;
        float m = width / TecnicasDispersao.getMatrizDados().getDataSet().size() + 2;
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
        iniciaVetorCores();
        //escala para y
        int aux = 0;
        int escala = (int) (y0 - y2) / 10;
        int soma = y2;
        String[] valores1 = {"1", "0.9", "0.8", "0.7", "0.6", "0.5", "0.4", "0.3", "0.2", "0.1", "0"};
        while (soma <= y0) {
            if (valores1[aux] != "0") {
                g.drawLine(x0 - 5, soma, x0 + 5, soma);
            }
            g.drawString(valores1[aux], x0 - 25, soma + 5);
            aux++;
            soma += escala;
        }
        //escala para x
        aux = 0;
        escala = (int) (x1 - x0) / 10;
        soma = x0;
        String[] valores2 = {"0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1"};
        while (soma <= x1) {
            g.drawLine(soma, y0 - 5, soma, y0 + 5);
            g.drawString(valores2[aux], soma - 7, y0 + 20);
            aux++;
            soma += escala;
        }
        int atributo1 = TecnicasDispersao.getComboBoxEixoXGrupos().getSelectedIndex();
        int atributo2 = TecnicasDispersao.getComboBoxEixoYGrupos().getSelectedIndex();
        int atributo3 = TecnicasDispersao.getComboBoxEixoZGrupos().getSelectedIndex();
        if (TecnicasDispersao.getClusters() != null) {
            for (int j = 0; j < TecnicasDispersao.getVetorGrupos().length; j++) {
                String grupo = "Grupo " + TecnicasDispersao.getVetorGrupos()[j];
                for (int l = 0; l < TecnicasDispersao.getClusters().size(); l++) {
                    if (TecnicasDispersao.getClusters().get(l).getNomeGrupo().equals(grupo)) {
                        for (int i = 0; i < TecnicasDispersao.getClusters().get(l).getGrupo().size(); i++) {
                            int padrao = TecnicasDispersao.getClusters().get(l).getGrupo().get(i).getNumero();
                            int x = 50 + (int) (TecnicasDispersao.getMatrizDados().getDataSet().get(padrao).getAtributos().get((atributo1 - 1)) * (width - 120));
                            int y = (height - 70) - (int) (TecnicasDispersao.getMatrizDados().getDataSet().get(padrao).getAtributos().get((atributo2 - 1)) * (height - 120));
                            for (int k = 0; k < TecnicasDispersao.getMatrizDados().getClasses().size(); k++) {
                                String classePadrao = TecnicasDispersao.getMatrizDados().getDataSet().get(padrao).getClasse();
                                String classeMomento = TecnicasDispersao.getMatrizDados().getClasses().get(k);
                                if (classeMomento.equals(classePadrao)) {
                                    g.setColor(cores[k]);
                                }
                            }

                            g.fillOval(x, y, tamPixel, tamPixel);

                        }
                    }

                }

            }
        }

    }

    private void iniciaVetorCores() {
        cores = new Color[TecnicasDispersao.getMatrizDados().getClasses().size()];
        for (int i = 0; i < cores.length; i++) {
            cores[i] = coresAux[i];
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
        setBorder(javax.swing.BorderFactory.createTitledBorder("Visualização"));

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
