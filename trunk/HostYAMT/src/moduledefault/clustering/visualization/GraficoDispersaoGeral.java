/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateus
 */
public class GraficoDispersaoGeral extends javax.swing.JPanel {

    /**
     * Creates new form GraficoDispersaoGeral
     */
    private static Color[] coresAux = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.BLACK};
    private static Color[] cores;

    public GraficoDispersaoGeral() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = TecnicasDispersao.getFundoDispersaoGeral().getWidth();
        int height = TecnicasDispersao.getFundoDispersaoGeral().getHeight();
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
        int z0 = 100;
        iniciaVetorCores();

        int atributo1 = TecnicasDispersao.getComboBoxEixoX().getSelectedIndex();
        int atributo2 = TecnicasDispersao.getComboBoxEixoY().getSelectedIndex();
        int atributo3 = TecnicasDispersao.getComboBoxEixoZ().getSelectedIndex();
        if (atributo3 == 0) {
            if (atributo1 != 0 && atributo2 != 0) {
                g.setColor(Color.black);
                g.drawLine(x0, y0, x1, y1);//x
                g.drawLine(x0, y0, x2, y2);//y
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
                if (TecnicasDispersao.getClusters() != null) {
                    for (int i = 0; i < TecnicasDispersao.getMatrizDados().getDataSet().size(); i++) {
                        int x = 50 + (int) (TecnicasDispersao.getMatrizDados().getDataSet().get(i).getAtributos().get((atributo1 - 1)) * (width - 120));
                        int y = (height - 70) - (int) (TecnicasDispersao.getMatrizDados().getDataSet().get(i).getAtributos().get((atributo2 - 1)) * (height - 120));
                        for (int l = 0; l < TecnicasDispersao.getMatrizDados().getClasses().size(); l++) {
                            String classePadrao = TecnicasDispersao.getMatrizDados().getDataSet().get(i).getClasse();
                            String classeMomento = TecnicasDispersao.getMatrizDados().getClasses().get(l);
                            if (classeMomento.equals(classePadrao)) {
                                g.setColor(cores[l]);
                            }
                        }

                        g.fillOval(x, y, tamPixel, tamPixel);

                    }
                    g.setColor(Color.black);
                }
            }
        } else {
            double vrpX = TecnicasDispersao.getDvrpX();
            double vrpY = TecnicasDispersao.getDvrpY();
            double vrpZ = TecnicasDispersao.getDvrpZ();
            double pontoX = TecnicasDispersao.getDpontoX();
            double pontoY = TecnicasDispersao.getDpontoY();
            double pontoZ = TecnicasDispersao.getDpontoZ();
            double distancia = TecnicasDispersao.getDdistancia();
            Camera c = new Camera(vrpX, vrpY, vrpZ, pontoX, pontoY, pontoZ, distancia);
            c.GerarIntermediarios();
            Ponto p1 = new Ponto("1", x0, y0, 0, Color.black);
            Ponto p2 = new Ponto("2", x1, y0, 0, Color.black);
            Ponto p3 = new Ponto("3", x1, y2, 0, Color.black);
            Ponto p4 = new Ponto("4", x0, y2, 0, Color.black);
            Ponto p5 = new Ponto("5", x0, y0, -z0, Color.black);
            Ponto p6 = new Ponto("6", x1, y0, -z0, Color.black);
            Ponto p7 = new Ponto("7", x1, y2, -z0, Color.black);
            Ponto p8 = new Ponto("8", x0, y2, -z0, Color.black);

            ArrayList<Ponto> pts = new ArrayList<>();
            pts.add(p1);
            pts.add(p3);
            pts.add(p4);
            pts.add(p5);
            pts.add(p6);
            pts.add(p7);
            pts.add(p2);
            pts.add(p8);
            Poligono cubo = new Poligono();
            cubo.GerarPrisma(4, (width - 100) / 2, height - 100);
            Poligono cubo2 = c.GerarPerspectiva(width, height, cubo);
            for (Aresta a : cubo2.getArestas()) {
                g.drawLine((int) a.getPonto_1().getX(), (int) a.getPonto_1().getY(), (int) a.getPonto_2().getX(), (int) a.getPonto_2().getY());
                g.drawString(a.getPonto_1().getNome(), (int) a.getPonto_1().getX() - 3, (int) a.getPonto_1().getY() - 3);
            }
            if (atributo1 != 0 && atributo2 != 0 && atributo3 != 0) {
                if (TecnicasDispersao.getClusters() != null) {
                    ArrayList<Ponto> pontos = new ArrayList<>();
                    for (int i = 0; i < TecnicasDispersao.getMatrizDados().getDataSet().size(); i++) {
                        double x = (TecnicasDispersao.getMatrizDados().getDataSet().get(i).getAtributos().get((atributo1 - 1)) * 100);
                        double y = (TecnicasDispersao.getMatrizDados().getDataSet().get(i).getAtributos().get((atributo2 - 1)) * 100);
                        double z = (TecnicasDispersao.getMatrizDados().getDataSet().get(i).getAtributos().get((atributo3 - 1)) * -100);
                        Color cor = null;
                        for (int l = 0; l < TecnicasDispersao.getMatrizDados().getClasses().size(); l++) {
                            String classePadrao = TecnicasDispersao.getMatrizDados().getDataSet().get(i).getClasse();
                            String classeMomento = TecnicasDispersao.getMatrizDados().getClasses().get(l);
                            if (classeMomento.equals(classePadrao)) {
                                cor = cores[l];
                            }
                        }

                        Ponto pAux = new Ponto(String.valueOf(TecnicasDispersao.getMatrizDados().getDataSet().get(i).getNumero()), x, y, z, cor);

                        pontos.add(pAux);
                    }

                    Poligono poli = new Poligono();
                    poli.GerarPrisma(4, (width - 100) / 2, height - 100, pontos);
                    Poligono pAux = c.GerarPerspectiva(TecnicasDispersao.getFundoDispersaoGeral().getWidth(), TecnicasDispersao.getFundoDispersaoGeral().getHeight(), poli);
                    for (Ponto pT : pAux.getPontos()) {
                        g.setColor(pT.getCor());
                        g.fillOval((int) pT.getX(), (int) pT.getY(), 5, 5);
                    }
                }
            }

        }
    }

    public void paintPointNumbers(Poligono p, Graphics g2D) {
        for (Ponto pT : p.getPontos()) {
            g2D.setColor(pT.getCor());
//            g2D.setColor(Color.black);
            g2D.fillOval((int) pT.getX(), (int) pT.getY(), 10, 10);
            pT.print("Ponto = \n");
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
