/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mateus
 */
public class MatrizCorrelacao extends javax.swing.JPanel {

    private double grupos[][];
    private static boolean repinta;

    /**
     * Creates new form MatrizCorrelacao
     */
    public MatrizCorrelacao() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = TecnicasDispersao.getFundoMatrizCorrelacao().getWidth();
        int height = TecnicasDispersao.getFundoMatrizCorrelacao().getHeight();

        int x0 = 20;
        int y0 = 20;
        int x1 = width - 100;
        int y1 = height - 10;
        int meioX = (x1 - x0) / 2;
        int meioY = (y1 - y0) / 2;
        int inicioX = 0;
        int inicioY = 0;
        this.add(this.jLabel1);
        if (grupos != null) {
            if (!repinta) {
                if (TecnicasDispersao.getGrupoEscolhidoMatriz() != 0) {
                    int tamPixelY = (y1 - y0) / grupos.length;
                    int tamPixelX = (x1 - x0) / grupos.length;

//                    System.out.println("tamX = " + tamPixelX);
//                    System.out.println("tamY = " + tamPixelY);
                    if (tamPixelX == 0) {
                        tamPixelX++;
                    }
                    if (tamPixelY == 0) {
                        tamPixelY++;
                    }
                    if (tamPixelX == 1) {
                        tamPixelX++;
                    }
                    if (tamPixelY == 1) {
                        tamPixelY++;
                    }
                    int pontoInicialX = grupos.length / 2;
                    int pontoInicialY = grupos.length / 2;
                    inicioX = meioX - pontoInicialX * tamPixelX + 20;
                    inicioY = meioY - pontoInicialY * tamPixelY + 20;
                    if (this.grupos != null) {
                        for (int i = 0; i < grupos.length; i++) {
                            inicioX = meioX - pontoInicialX * tamPixelX + 20;
                            for (int j = 0; j < grupos.length; j++) {
                                int x = inicioX;
                                int y = inicioY;
                                if (i == j) {
                                    g.setColor(Color.black);
                                } else {
                                    if (grupos[i][j] >= -1 && grupos[i][j] < -0.90) {
                                        g.setColor(new Color(0, 0, 128));
                                    } else if (grupos[i][j] >= -0.90 && grupos[i][j] < -0.8) {
                                        g.setColor(new Color(0, 0, 205));
                                    } else if (grupos[i][j] >= -0.8 && grupos[i][j] < -0.70) {
                                        g.setColor(new Color(0, 0, 255));
                                    } else if (grupos[i][j] >= -0.70 && grupos[i][j] < -0.6) {
                                        g.setColor(new Color(65, 105, 255));
                                    } else if (grupos[i][j] >= -0.6 && grupos[i][j] < -0.5) {
                                        g.setColor(new Color(100, 149, 237));
                                    } else if (grupos[i][j] >= -0.5 && grupos[i][j] < -0.4) {
                                        g.setColor(new Color(30, 144, 255));
                                    } else if (grupos[i][j] >= -0.4 && grupos[i][j] < -0.3) {
                                        g.setColor(new Color(0, 191, 255));
                                    } else if (grupos[i][j] >= -0.3 && grupos[i][j] < -0.2) {
                                        g.setColor(new Color(135, 206, 250));
                                    } else if (grupos[i][j] >= -0.2 && grupos[i][j] < -0.1) {
                                        g.setColor(new Color(176, 224, 230));
                                    } else if (grupos[i][j] >= -0.1 && grupos[i][j] < 0) {
                                        g.setColor(new Color(224, 255, 255));
                                    } else if (grupos[i][j] >= 0 && grupos[i][j] < 0.1) {
                                        g.setColor(new Color(255, 255, 255));
                                    } else if (grupos[i][j] >= 0.1 && grupos[i][j] < 0.2) {
                                        g.setColor(new Color(255, 160, 122));
                                    } else if (grupos[i][j] >= 0.2 && grupos[i][j] < 0.3) {
                                        g.setColor(new Color(233, 150, 122));
                                    } else if (grupos[i][j] >= 0.3 && grupos[i][j] < 0.4) {
                                        g.setColor(new Color(255, 127, 80));
                                    } else if (grupos[i][j] >= 0.4 && grupos[i][j] < 0.5) {
                                        g.setColor(new Color(255, 99, 71));
                                    } else if (grupos[i][j] >= 0.5 && grupos[i][j] < 0.6) {
                                        g.setColor(new Color(255, 80, 70));
                                    } else if (grupos[i][j] >= 0.6 && grupos[i][j] < 0.7) {
                                        g.setColor(new Color(255, 165, 0));
                                    } else if (grupos[i][j] >= 0.7 && grupos[i][j] < 0.8) {
                                        g.setColor(new Color(255, 140, 0));
                                    } else if (grupos[i][j] >= 0.8 && grupos[i][j] < 0.9) {
                                        g.setColor(new Color(255, 69, 0));
                                    } else if (grupos[i][j] >= 0.9 && grupos[i][j] <= 1) {
                                        g.setColor(new Color(255, 0, 0));
                                    }
                                }
                                g.fillOval(x, y, tamPixelY, tamPixelY);
                                g.setColor(Color.black);
                                g.drawOval(x, y, tamPixelY, tamPixelY);
                                inicioX += tamPixelX;
                            }
                            inicioY += tamPixelY;
                        }
                    }
                }
            } else {
                g.setColor(this.getBackground());
                g.drawRect(0, 0, this.getWidth(), this.getHeight());
            }
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

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder("Visualização"));
        setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mateus\\Dropbox\\TCC - Mateus\\Imagens\\escalarCerta.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 299, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    void setMatrizGrupos(double[][] grupos) {
        this.grupos = grupos;
    }

    public static boolean isRepinta() {
        return repinta;
    }

    public static void setRepinta(boolean repinta) {
        MatrizCorrelacao.repinta = repinta;
    }
}
