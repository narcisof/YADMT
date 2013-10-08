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
public class GraficoDispersaoGeral extends javax.swing.JPanel {

    /**
     * Creates new form GraficoDispersaoGeral
     */
    private static Color[] coresAux = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.BLACK};
    private static Color[] cores;

    public GraficoDispersaoGeral() {
        initComponents();
        cubo = new Poligono();
        cubo.GerarPrisma(4, (TecnicasDispersao.getFundoDispersaoGeral().getWidth() - 100) / 2, TecnicasDispersao.getFundoDispersaoGeral().getHeight() - 100);

        vrpX = 100;
        vrpY = 100;
        vrpZ = 100;
        pontoX = 0;
        pontoY = 0;
        pontoZ = 0;
        distancia = 10;
        svrpX.setValue(vrpX);
        svrpY.setValue(vrpY);
        svrpZ.setValue(vrpZ);
        spontoX.setValue(pontoX);
        spontoY.setValue(pontoY);
        spontoZ.setValue(pontoZ);
        sdistancia.setValue(distancia);
    }
    Poligono cubo;
    Camera c;
    double vrpX;
    double vrpY;
    double vrpZ;
    double pontoX;
    double pontoY;
    double pontoZ;
    double distancia;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = TecnicasDispersao.getFundoDispersaoGeral().getWidth();
        int height = TecnicasDispersao.getFundoDispersaoGeral().getHeight();
        float w = width / 2;
        float h = height / 2;
        int x0 = 50 + (int) 0 * (width - 120);
        int y0 = (height - 70) - (int) 0 * (height - 120) + 3;
        int x1 = 50 + (int) 1 * (width - 120) + 3;
        int y1 = (height - 70) - (int) 0 * (height - 120) + 3;
        int x2 = 50 + (int) 0 * (width - 120);
        int y2 = (height - 70) - (int) 1 * (height - 120) - 3;
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

                        g.fillOval(x, y, 3, 3);

                    }
                    g.setColor(Color.black);
                }
            }
        } else {
            System.out.println("vrpX = " + vrpX);
            System.out.println("vrpY= " + vrpY);
            c = new Camera(vrpX, vrpY, vrpZ, pontoX, pontoY, pontoZ, distancia);
            c.GerarIntermediarios();
//            Ponto p1 = new Ponto("1", x0, y0, 0, Color.black);
//            Ponto p2 = new Ponto("2", x1, y0, 0, Color.black);
//            Ponto p3 = new Ponto("3", x1, y2, 0, Color.black);
//            Ponto p4 = new Ponto("4", x0, y2, 0, Color.black);
//            Ponto p5 = new Ponto("5", x0, y0, -z0, Color.black);
//            Ponto p6 = new Ponto("6", x1, y0, -z0, Color.black);
//            Ponto p7 = new Ponto("7", x1, y2, -z0, Color.black);
//            Ponto p8 = new Ponto("8", x0, y2, -z0, Color.black);
//            System.out.println("largura = "+width);
//            System.out.println("altura = "+height);
//            ArrayList<Ponto> pts = new ArrayList<>();
//            pts.add(p1);
//            pts.add(p3);
//            pts.add(p4);
//            pts.add(p5);
//            pts.add(p6);
//            pts.add(p7);
//            pts.add(p2);
//            pts.add(p8);

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
                    poli.Transladar((long) cubo.getCentro().getX(), (long) cubo.getCentro().getY(), (long) cubo.getCentro().getZ());
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        svrpX = new javax.swing.JSpinner();
        svrpZ = new javax.swing.JSpinner();
        svrpY = new javax.swing.JSpinner();
        spontoX = new javax.swing.JSpinner();
        spontoY = new javax.swing.JSpinner();
        spontoZ = new javax.swing.JSpinner();
        sdistancia = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder("Visualização"));

        jButton1.setText("girar x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("girar y");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("girar z");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("vrpX");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("vrpY");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("vrpZ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        svrpX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                svrpXStateChanged(evt);
            }
        });

        svrpZ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                svrpZStateChanged(evt);
            }
        });

        svrpY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                svrpYStateChanged(evt);
            }
        });

        spontoX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spontoXStateChanged(evt);
            }
        });

        spontoY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spontoYStateChanged(evt);
            }
        });

        spontoZ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spontoZStateChanged(evt);
            }
        });

        sdistancia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sdistanciaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(svrpZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spontoZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(svrpY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spontoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jButton2)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(svrpX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spontoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sdistancia))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(4, 4, 4)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(1, 1, 1)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(svrpX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spontoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(svrpY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spontoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(svrpZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spontoZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sdistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        cubo.RotacionarX(30);
        cubo.Transformar();
        System.out.println("aqui");
        repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        cubo.Transformar();
        cubo.RotacionarY(30);
        repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cubo.Transformar();
        cubo.RotacionarZ(30);
        repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Matriz m = new Matriz(1, 4);
        m.set(0, 0, vrpX);
        m.set(0, 1, vrpY);
        m.set(0, 2, vrpZ);
        m.set(0, 3, 1);
        Matriz r = Matriz.gerarRotacaoX(30);
        Matriz resultado = Matriz.multiplicacao(m, r);
        vrpX = resultado.get(0, 0);
        vrpY = resultado.get(0, 1);
        vrpZ = resultado.get(0, 2);
        System.out.println("vrpX = " + vrpX);
        repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Matriz m = new Matriz(1, 4);
        m.set(0, 0, vrpX);
        m.set(0, 1, vrpY);
        m.set(0, 2, vrpZ);
        m.set(0, 3, 1);
        Matriz r = Matriz.gerarRotacaoY(30);
        Matriz resultado = Matriz.multiplicacao(m, r);
        vrpX = resultado.get(0, 0);
        vrpY = resultado.get(0, 1);
        vrpZ = resultado.get(0, 2);
        repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Matriz m = new Matriz(1, 4);
        m.set(0, 0, vrpX);
        m.set(0, 1, vrpY);
        m.set(0, 2, vrpZ);
        m.set(0, 3, 1);
        Matriz r = Matriz.gerarRotacaoZ(30);

        Matriz resultado = Matriz.multiplicacao(m, r);
        vrpX = resultado.get(0, 0);
        vrpY = resultado.get(0, 1);
        vrpZ = resultado.get(0, 2);
        repaint();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void svrpXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_svrpXStateChanged
        vrpX = Double.valueOf(svrpX.getValue().toString());
        repaint();
    }//GEN-LAST:event_svrpXStateChanged

    private void svrpYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_svrpYStateChanged
        vrpY = Double.valueOf(svrpY.getValue().toString());
        repaint();
    }//GEN-LAST:event_svrpYStateChanged

    private void svrpZStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_svrpZStateChanged
        vrpZ = Double.valueOf(svrpZ.getValue().toString());
        repaint();
    }//GEN-LAST:event_svrpZStateChanged

    private void spontoXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spontoXStateChanged
        pontoX = Double.valueOf(spontoX.getValue().toString());
        repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_spontoXStateChanged

    private void spontoYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spontoYStateChanged
        pontoY = Double.valueOf(spontoY.getValue().toString());
        repaint();
    }//GEN-LAST:event_spontoYStateChanged

    private void spontoZStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spontoZStateChanged
        pontoZ = Double.valueOf(spontoZ.getValue().toString());
        repaint();
    }//GEN-LAST:event_spontoZStateChanged

    private void sdistanciaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sdistanciaStateChanged
        distancia = Double.valueOf(sdistancia.getValue().toString());
        repaint();
    }//GEN-LAST:event_sdistanciaStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JSpinner sdistancia;
    private javax.swing.JSpinner spontoX;
    private javax.swing.JSpinner spontoY;
    private javax.swing.JSpinner spontoZ;
    private javax.swing.JSpinner svrpX;
    private javax.swing.JSpinner svrpY;
    private javax.swing.JSpinner svrpZ;
    // End of variables declaration//GEN-END:variables
}
