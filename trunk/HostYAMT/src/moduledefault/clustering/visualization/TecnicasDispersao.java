/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import javax.swing.JPanel;
import moduledefault.clustering.aco.ACOClustering;
import moduledefault.clustering.distancias.Correlação;
import moduledefault.clustering.uteis.MatrizDados;
import moduledefault.clustering.view.jpanel.PanelFormigas;

/**
 *
 * @author Mateus
 */
public final class TecnicasDispersao extends javax.swing.JFrame {

    /**
     * Creates new form ClusteringFrameVisualization
     */
    private static GraficoDispersaoGrupo GDGr;
    private static GraficoDispersaoGeral GDG;
    private static DispersaoCorrelacao DC;
    private static MatrizCorrelacao MC;
    private static TecnicasDispersao INSTANCE;
    private static MatrizDados matrizDados;
    private static int[][] matrizGrupos;
    private static int grupoEscolhido = 1;
    private static int eixoX = 1;
    private static int eixoY = 2;

    public TecnicasDispersao() {
        initComponents();
        repaint();
    }

    public static synchronized TecnicasDispersao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TecnicasDispersao();
        }
        INSTANCE.repaint();
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        fundoDispersaoGeral = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboEixoX = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        comboEixoY = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        visualizarDispersaoGeral = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        fundoDispersaoGrupos = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboGrupos1 = new javax.swing.JComboBox();
        comboGrupos2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboEixoXgrupos = new javax.swing.JComboBox();
        comboEixoYGrupos = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        fundoMatrizCorrelacao = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        fundoDispersaoCorrelacao = new javax.swing.JPanel();

        jTabbedPane2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTabbedPane2ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout fundoDispersaoGeralLayout = new javax.swing.GroupLayout(fundoDispersaoGeral);
        fundoDispersaoGeral.setLayout(fundoDispersaoGeralLayout);
        fundoDispersaoGeralLayout.setHorizontalGroup(
            fundoDispersaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fundoDispersaoGeralLayout.setVerticalGroup(
            fundoDispersaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        jLabel1.setText("Eixo X:");

        comboEixoX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Eixo Y:");

        comboEixoY.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboEixoY, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(comboEixoX, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEixoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEixoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        visualizarDispersaoGeral.setText("Visualizar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(visualizarDispersaoGeral)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(visualizarDispersaoGeral)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fundoDispersaoGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 484, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(fundoDispersaoGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Gráfico Dispersão Geral", jPanel3);

        javax.swing.GroupLayout fundoDispersaoGruposLayout = new javax.swing.GroupLayout(fundoDispersaoGrupos);
        fundoDispersaoGrupos.setLayout(fundoDispersaoGruposLayout);
        fundoDispersaoGruposLayout.setHorizontalGroup(
            fundoDispersaoGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fundoDispersaoGruposLayout.setVerticalGroup(
            fundoDispersaoGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        jLabel3.setText("Grupos:");

        comboGrupos1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboGrupos2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Eixo X:");

        comboEixoXgrupos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboEixoYGrupos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Eixo Y:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboGrupos1, 0, 156, Short.MAX_VALUE)
                            .addComponent(comboGrupos2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboEixoXgrupos, 0, 161, Short.MAX_VALUE)
                            .addComponent(comboEixoYGrupos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboGrupos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEixoXgrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboGrupos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEixoYGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fundoDispersaoGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 482, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fundoDispersaoGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Gráfico Dispersão Grupos", jPanel4);

        javax.swing.GroupLayout fundoMatrizCorrelacaoLayout = new javax.swing.GroupLayout(fundoMatrizCorrelacao);
        fundoMatrizCorrelacao.setLayout(fundoMatrizCorrelacaoLayout);
        fundoMatrizCorrelacaoLayout.setHorizontalGroup(
            fundoMatrizCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
        );
        fundoMatrizCorrelacaoLayout.setVerticalGroup(
            fundoMatrizCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fundoMatrizCorrelacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(fundoMatrizCorrelacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Matriz de Correlação", jPanel5);

        javax.swing.GroupLayout fundoDispersaoCorrelacaoLayout = new javax.swing.GroupLayout(fundoDispersaoCorrelacao);
        fundoDispersaoCorrelacao.setLayout(fundoDispersaoCorrelacaoLayout);
        fundoDispersaoCorrelacaoLayout.setHorizontalGroup(
            fundoDispersaoCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
        );
        fundoDispersaoCorrelacaoLayout.setVerticalGroup(
            fundoDispersaoCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fundoDispersaoCorrelacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(fundoDispersaoCorrelacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Dispersão de Correlação", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane2ComponentResized
        dispersaoGeral();
        dispersaoCorrelacao();
        dispersaoGrupos();
        matrizCorrelacao();
        setMatrizGruposCorrelacao(getMatrizDadosCorrelacao());

    }//GEN-LAST:event_jTabbedPane2ComponentResized
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox comboEixoX;
    private javax.swing.JComboBox comboEixoXgrupos;
    private javax.swing.JComboBox comboEixoY;
    private javax.swing.JComboBox comboEixoYGrupos;
    private javax.swing.JComboBox comboGrupos1;
    private javax.swing.JComboBox comboGrupos2;
    private static javax.swing.JPanel fundoDispersaoCorrelacao;
    private static javax.swing.JPanel fundoDispersaoGeral;
    private static javax.swing.JPanel fundoDispersaoGrupos;
    private static javax.swing.JPanel fundoMatrizCorrelacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private static javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton visualizarDispersaoGeral;
    // End of variables declaration//GEN-END:variables

    private static void dispersaoGrupos() {
        if (GDGr == null) {
            GDGr = new GraficoDispersaoGrupo();
        }
        GDGr.setSize(fundoDispersaoGrupos.getWidth(), fundoDispersaoGrupos.getHeight());
        fundoDispersaoGrupos.add(GDGr);
    }

    private static void dispersaoCorrelacao() {
        if (DC == null) {
            DC = new DispersaoCorrelacao();
        }
        DC.setSize(fundoDispersaoCorrelacao.getWidth(), fundoDispersaoCorrelacao.getHeight());
        fundoDispersaoCorrelacao.add(DC);

    }

    public static MatrizDados getMatrizDados() {
        return matrizDados;
    }

    public static void setMatrizDados(MatrizDados m) {
        matrizDados = m;
    }

    public static int[][] getMatrizGrupos() {
        return matrizGrupos;
    }

    public static void setMatrizGrupos(int[][] matrizGrupos) {
        TecnicasDispersao.matrizGrupos = matrizGrupos;
    }

    public static int getGrupoEscolhido() {
        return grupoEscolhido;
    }

    public static void setGrupoEscolhido(int grupoEscolhido) {
        TecnicasDispersao.grupoEscolhido = grupoEscolhido;
    }

    public static int getEixoX() {
        return eixoX;
    }

    public static void setEixoX(int eixoX) {
        TecnicasDispersao.eixoX = eixoX;
    }

    public static int getEixoY() {
        return eixoY;
    }

    public static void setEixoY(int eixoY) {
        TecnicasDispersao.eixoY = eixoY;
    }

    private void dispersaoGeral() {
        if (GDG == null) {
            GDG = new GraficoDispersaoGeral();
        }
        GDG.setSize(fundoDispersaoGeral.getWidth(), fundoDispersaoGeral.getHeight());
        fundoDispersaoGeral.add(GDG);

    }

    private void matrizCorrelacao() {
        if (MC == null) {
            MC = new MatrizCorrelacao();
        }
        MC.setSize(fundoMatrizCorrelacao.getWidth(), fundoMatrizCorrelacao.getHeight());
        fundoMatrizCorrelacao.add(MC);

    }

    private void setMatrizGruposCorrelacao(MatrizDados grupos) {
        if (MC == null) {
            MC = new MatrizCorrelacao();
        } else {
            Correlação cor = new Correlação(grupos);
            cor.distanciaGrupos(grupos);
            MC.setMatrizGrupos(cor.getMatrizDistancias());
        }
    }

    private MatrizDados getMatrizDadosCorrelacao() {
        int grupo = grupoEscolhido;
        int numElemento = 0;
        System.out.println("Matriz dos grupos");
        for (int i = 0; i < getMatrizGrupos().length; i++) {
            for (int j = 0; j < getMatrizGrupos()[0].length; j++) {
                System.out.print(getMatrizGrupos()[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < getMatrizGrupos()[0].length; i++) {
            if (getMatrizGrupos()[1][i] == grupo) {
                numElemento++;
            }
        }
        System.out.println("Elmentos = " + numElemento);
        MatrizDados aux = new MatrizDados();
        aux.setLinhas(numElemento);
        aux.setColunas(getMatrizDados().getColunas());
        double[][] resultado = new double[numElemento][getMatrizDados().getColunas()];
        int contadorResultado = 0;
        for (int j = 0; j < getMatrizDados().getLinhas(); j++) {
            if (getMatrizGrupos()[1][j] == grupo) {
                for (int k = 0; k < getMatrizDados().getColunas(); k++) {
                    resultado[contadorResultado][k] = getMatrizDados().getMatriz_dados()[getMatrizGrupos()[0][j] - 1][k];
                }
                contadorResultado++;
            }
        }
        System.out.println("resultado");
        aux.setMatriz_dados(resultado);
        for (int i = 0; i < numElemento; i++) {
            for (int j = 0; j < getMatrizDados().getColunas(); j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
        return aux;
    }

    public static JPanel getFundoDispersaoCorrelacao() {
        return fundoDispersaoCorrelacao;
    }

    public static void setFundoDispersaoCorrelacao(JPanel fundoDispersaoCorrelacao) {
        TecnicasDispersao.fundoDispersaoCorrelacao = fundoDispersaoCorrelacao;
    }

    public static JPanel getFundoDispersaoGeral() {
        return fundoDispersaoGeral;
    }

    public static void setFundoDispersaoGeral(JPanel fundoDispersaoGeral) {
        TecnicasDispersao.fundoDispersaoGeral = fundoDispersaoGeral;
    }

    public static JPanel getFundoDispersaoGrupos() {
        return fundoDispersaoGrupos;
    }

    public static void setFundoDispersaoGrupos(JPanel fundoDispersaoGrupos) {
        TecnicasDispersao.fundoDispersaoGrupos = fundoDispersaoGrupos;
    }

    public static JPanel getFundoMatrizCorrelacao() {
        return fundoMatrizCorrelacao;
    }

    public static void setFundoMatrizCorrelacao(JPanel fundoMatrizCorrelacao) {
        TecnicasDispersao.fundoMatrizCorrelacao = fundoMatrizCorrelacao;
    }
}
