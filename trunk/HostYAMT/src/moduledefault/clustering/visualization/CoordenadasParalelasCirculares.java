/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Mateus
 */
public class CoordenadasParalelasCirculares extends javax.swing.JPanel {

    /**
     * Creates new form CoordenadasParalelasCirculares
     */
    private static Color[] coresAux = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.BLACK};
    private static Color[] cores;
    int[] xs;
    int[] ys;

    public CoordenadasParalelasCirculares() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = TecnicasDispersao.getFundoCirculares().getWidth();
        int height = TecnicasDispersao.getFundoCirculares().getHeight();
        int inicioX = 50;
        int fimX = width - 50;
        int inicioY = 50;
        int fimY = height - 50;
        int centroX = (fimX - inicioX) / 2;
        int centroY = (fimY - inicioY) / 2;
        int raio = (centroY - inicioY);
        calculaPontos(centroX, centroY, raio, 360);
        iniciaVetorCores();
        for (int i = 0; i < 360; i++) {
            g.drawRect(xs[i], ys[i], 1, 1);
        }
        ArrayList<Ponto> pontosCirculares = new ArrayList<>();
//        g.drawArc((int)(centroX + raio * Math.cos(Math.toRadians(135))), (int)(centroY + raio * Math.sin(Math.toRadians(135))), raio*2, raio*2, 0, 360);
//        g.fillRect((int)(centroX + raio * Math.cos(Math.toRadians(135))), (int)(centroY + raio * Math.sin(Math.toRadians(135))), 4, 4);
        int numEixos = TecnicasDispersao.getMatrizDados().getDataSet().get(0).getAtributos().size();
        int[] eixosX = new int[numEixos];
        int[] eixosY = new int[numEixos];
        double aux = 360 / numEixos;
        double divisoes = aux;
        for (int i = 0; i < numEixos; i++) {
            eixosX[i] = (int) (centroX + raio * Math.cos(Math.toRadians(divisoes)));
            eixosY[i] = (int) (centroY + raio * Math.sin(Math.toRadians(divisoes)));
            divisoes += aux;
        }

        for (int i = 0; i < numEixos; i++) {
            g.drawLine(centroX, centroY, eixosX[i], eixosY[i]);
            if (eixosY[i] > height / 2) {
                g.drawString(TecnicasDispersao.getMatrizDados().getAtributos().get(i), eixosX[i], eixosY[i] + 5);
            } else {
                g.drawString(TecnicasDispersao.getMatrizDados().getAtributos().get(i), eixosX[i], eixosY[i] - 5);
            }
        }


        for (int i = 0; i < TecnicasDispersao.getMatrizDados().getDataSet().size(); i++) {
            int coordX[] = new int[TecnicasDispersao.getMatrizDados().getDataSet().get(i).getAtributos().size()];
            int coordY[] = new int[TecnicasDispersao.getMatrizDados().getDataSet().get(i).getAtributos().size()];
            for (int j = 0; j < TecnicasDispersao.getMatrizDados().getDataSet().get(i).getAtributos().size(); j++) {
                double[][] auxM = this.equacaoParametrica(centroX, TecnicasDispersao.getMatrizDados().getDataSet().get(i).getAtributos().get(j), eixosX[j], centroY, eixosY[j]);
                coordX[j] = (int) auxM[0][0];
                coordY[j] = (int) auxM[1][0];
            }
            for (int l = 0; l < TecnicasDispersao.getMatrizDados().getClasses().size(); l++) {
                String classePadrao = TecnicasDispersao.getMatrizDados().getDataSet().get(i).getClasse();
                String classeMomento = TecnicasDispersao.getMatrizDados().getClasses().get(l);
                if (classeMomento.equals(classePadrao)) {
                    g.setColor(cores[l]);
                }
            }
            Ponto p = new Ponto(TecnicasDispersao.getMatrizDados().getDataSet().get(i).getNumero() + "", coordX, coordY, Color.black);
            pontosCirculares.add(p);
            int expessuraLinha = TecnicasDispersao.getExpessuraLinhaCircular();
            for (int k = 0; k < expessuraLinha; k++) {
                for (int j = 0; j < coordY.length - 1; j++) {
                    g.drawLine(coordX[j] + k, coordY[j], coordX[j + 1] + k, coordY[j + 1]);
                    Color auxC = g.getColor();
                    if (TecnicasDispersao.isDesenharPontosCirculares()) {
                        g.setColor(Color.black);
                        g.fillRect(coordX[j] - 2, coordY[j] - 2, 4, 4);
                        g.fillRect(coordX[j + 1] - 2, coordY[j + 1] - 2, 4, 4);
                    }
                    g.setColor(auxC);
                }

            }
        }
        TecnicasDispersao.setPontosCoordParalelasCirculares(pontosCirculares);

        if (TecnicasDispersao.isPintarPontoParalelaCircular()) {
            int expessura = TecnicasDispersao.getExpessuraLinhaCircular() + 2;
            for (int i = 0; i < expessura; i++) {
                for (int j = 0; j < TecnicasDispersao.getPontosPintarParalelaCircular().size(); j++) {
                    for (int k = 0; k < TecnicasDispersao.getPontosPintarParalelaCircular().get(j).getXs().length - 1; k++) {
                        g.setColor(Color.black);
                        g.drawLine(TecnicasDispersao.getPontosPintarParalelaCircular().get(j).getXs()[k], TecnicasDispersao.getPontosPintarParalelaCircular().get(j).getYs()[k], TecnicasDispersao.getPontosPintarParalelaCircular().get(j).getXs()[k + 1] + i, TecnicasDispersao.getPontosPintarParalelaCircular().get(j).getYs()[k + 1] + i);
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
        setBorder(javax.swing.BorderFactory.createTitledBorder("Paralelas Circulares"));

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

    private void calculaPontos(int centroX, int centroY, int raio, int grau) {
        xs = new int[grau];
        ys = new int[grau];
        for (int i = 0; i < grau; i++) {
            xs[i] = (int) (centroX + raio * Math.cos(Math.toRadians(i)));
            ys[i] = (int) (centroY + raio * Math.sin(Math.toRadians(i)));
        }
    }

    private double[][] equacaoParametrica(double x1, double u, double x2, double y1, double y2) {
        double xy[][] = new double[2][1];
        xy[0][0] = x1 + u * (x2 - x1);
        xy[1][0] = y1 + u * (y2 - y1);

        return xy;
    }
}
