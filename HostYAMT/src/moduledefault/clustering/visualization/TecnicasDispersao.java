/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
    private static int qntGrupos;
    private static int[] vetorGrupos;
    private static int grupoEscolhidoMatriz = 0;

    public static int getQntGrupos() {
        return qntGrupos;
    }

    public static void setQntGrupos(int qntGrupos) {
        TecnicasDispersao.qntGrupos = qntGrupos;
        vetorGrupos = new int[TecnicasDispersao.qntGrupos];
    }

    public TecnicasDispersao() {
        initComponents();
//        this.setResizable(false);
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
        jPanel6 = new javax.swing.JPanel();
        fundoDispersaoCorrelacao = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxEixoXCorrelacao = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        comboBoxEixoYCorrelacao = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        comboBoxEixoZCorrelacao = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        comboBoxGruposCorrelacao = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        fundoDispersaoGeral = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxEixoX = new javax.swing.JComboBox();
        comboBoxEixoY = new javax.swing.JComboBox();
        comboBoxEixoZ = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        fundoDispersaoGrupos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxEixoXGrupos = new javax.swing.JComboBox();
        comboBoxEixoYGrupos = new javax.swing.JComboBox();
        comboBoxEixoZGrupos = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        comboBoxGrupos = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fundoMatrizCorrelacao = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        comboBoxGruposMatriz = new javax.swing.JComboBox();

        jTabbedPane2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTabbedPane2ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout fundoDispersaoCorrelacaoLayout = new javax.swing.GroupLayout(fundoDispersaoCorrelacao);
        fundoDispersaoCorrelacao.setLayout(fundoDispersaoCorrelacaoLayout);
        fundoDispersaoCorrelacaoLayout.setHorizontalGroup(
            fundoDispersaoCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        fundoDispersaoCorrelacaoLayout.setVerticalGroup(
            fundoDispersaoCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        jLabel8.setText("Eixo X:");

        comboBoxEixoXCorrelacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEixoXCorrelacaoActionPerformed(evt);
            }
        });

        jLabel9.setText("Eixo Y:");

        comboBoxEixoYCorrelacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEixoYCorrelacaoActionPerformed(evt);
            }
        });

        jLabel10.setText("Eixo Z:");

        comboBoxEixoZCorrelacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEixoZCorrelacaoActionPerformed(evt);
            }
        });

        jLabel12.setText("Grupo:");

        comboBoxGruposCorrelacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGruposCorrelacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxEixoXCorrelacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxEixoYCorrelacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxEixoZCorrelacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxGruposCorrelacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(comboBoxEixoXCorrelacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEixoYCorrelacao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEixoZCorrelacao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(comboBoxGruposCorrelacao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundoDispersaoCorrelacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(fundoDispersaoCorrelacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );

        jTabbedPane2.addTab("Dispersão de Correlação", jPanel6);

        javax.swing.GroupLayout fundoDispersaoGeralLayout = new javax.swing.GroupLayout(fundoDispersaoGeral);
        fundoDispersaoGeral.setLayout(fundoDispersaoGeralLayout);
        fundoDispersaoGeralLayout.setHorizontalGroup(
            fundoDispersaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fundoDispersaoGeralLayout.setVerticalGroup(
            fundoDispersaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jLabel1.setText("Eixo X:");

        jLabel2.setText("Eixo Y:");

        jLabel3.setText("Eixo Z:");

        comboBoxEixoX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEixoXActionPerformed(evt);
            }
        });

        comboBoxEixoY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEixoYActionPerformed(evt);
            }
        });

        comboBoxEixoZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEixoZActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxEixoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxEixoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxEixoZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(503, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxEixoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEixoY, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEixoZ, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundoDispersaoGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(fundoDispersaoGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(170, 170, 170))
        );

        jTabbedPane2.addTab("Gráfico Dispersão Geral", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        fundoDispersaoGrupos.setBackground(new java.awt.Color(255, 255, 255));
        fundoDispersaoGrupos.setPreferredSize(new java.awt.Dimension(550, 550));

        javax.swing.GroupLayout fundoDispersaoGruposLayout = new javax.swing.GroupLayout(fundoDispersaoGrupos);
        fundoDispersaoGrupos.setLayout(fundoDispersaoGruposLayout);
        fundoDispersaoGruposLayout.setHorizontalGroup(
            fundoDispersaoGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fundoDispersaoGruposLayout.setVerticalGroup(
            fundoDispersaoGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Eixo X:");

        jLabel5.setText("Eixo Y:");

        jLabel6.setText("Eixo Z:");

        comboBoxEixoXGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEixoXGruposActionPerformed(evt);
            }
        });

        comboBoxEixoYGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEixoYGruposActionPerformed(evt);
            }
        });

        comboBoxEixoZGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEixoZGruposActionPerformed(evt);
            }
        });

        jLabel7.setText("Grupos:");

        comboBoxGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGruposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxEixoXGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxEixoYGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxEixoZGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(417, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxEixoXGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEixoYGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEixoZGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(comboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fundoDispersaoGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(fundoDispersaoGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Gráfico Dispersão Grupos", jPanel4);

        fundoMatrizCorrelacao.setBackground(new java.awt.Color(200, 200, 200));

        javax.swing.GroupLayout fundoMatrizCorrelacaoLayout = new javax.swing.GroupLayout(fundoMatrizCorrelacao);
        fundoMatrizCorrelacao.setLayout(fundoMatrizCorrelacaoLayout);
        fundoMatrizCorrelacaoLayout.setHorizontalGroup(
            fundoMatrizCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );
        fundoMatrizCorrelacaoLayout.setVerticalGroup(
            fundoMatrizCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(fundoMatrizCorrelacao);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Grupo:");

        comboBoxGruposMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGruposMatrizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxGruposMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(659, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboBoxGruposMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jTabbedPane2.addTab("Matriz de Correlação", jPanel5);

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
    }//GEN-LAST:event_jTabbedPane2ComponentResized

    private void comboBoxEixoXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoXActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoXActionPerformed

    private void comboBoxEixoYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoYActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoYActionPerformed

    private void comboBoxEixoZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoZActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoZActionPerformed

    private void comboBoxEixoXGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoXGruposActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoXGruposActionPerformed

    private void comboBoxEixoYGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoYGruposActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoYGruposActionPerformed

    private void comboBoxEixoZGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoZGruposActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoZGruposActionPerformed

    private void comboBoxGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGruposActionPerformed
        setVetorGrupos();
        repaint();
    }//GEN-LAST:event_comboBoxGruposActionPerformed

    private void comboBoxGruposMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGruposMatrizActionPerformed
        matrizCorrelacao();
        grupoEscolhidoMatriz = comboBoxGruposMatriz.getSelectedIndex();
        if (grupoEscolhidoMatriz != 0) {
            MatrizDados aux = getMatrizDadosCorrelacao();
            if (aux != null) {
                setMatrizGruposCorrelacao(aux);
            }
        }
        repaint();
    }//GEN-LAST:event_comboBoxGruposMatrizActionPerformed

    private void comboBoxEixoXCorrelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoXCorrelacaoActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoXCorrelacaoActionPerformed

    private void comboBoxEixoYCorrelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoYCorrelacaoActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoYCorrelacaoActionPerformed

    private void comboBoxEixoZCorrelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoZCorrelacaoActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoZCorrelacaoActionPerformed

    private void comboBoxGruposCorrelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGruposCorrelacaoActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxGruposCorrelacaoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private static javax.swing.JComboBox comboBoxEixoX;
    private static javax.swing.JComboBox comboBoxEixoXCorrelacao;
    private static javax.swing.JComboBox comboBoxEixoXGrupos;
    private static javax.swing.JComboBox comboBoxEixoY;
    private static javax.swing.JComboBox comboBoxEixoYCorrelacao;
    private static javax.swing.JComboBox comboBoxEixoYGrupos;
    private static javax.swing.JComboBox comboBoxEixoZ;
    private static javax.swing.JComboBox comboBoxEixoZCorrelacao;
    private static javax.swing.JComboBox comboBoxEixoZGrupos;
    private static javax.swing.JComboBox comboBoxGrupos;
    private static javax.swing.JComboBox comboBoxGruposCorrelacao;
    private static javax.swing.JComboBox comboBoxGruposMatriz;
    private static javax.swing.JPanel fundoDispersaoCorrelacao;
    private static javax.swing.JPanel fundoDispersaoGeral;
    private static javax.swing.JPanel fundoDispersaoGrupos;
    private static javax.swing.JPanel fundoMatrizCorrelacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTabbedPane jTabbedPane2;
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
            if (grupoEscolhidoMatriz != 0) {
                Correlação cor = new Correlação(grupos);
                cor.distanciaGrupos(grupos);
                MC.setMatrizGrupos(cor.getMatrizDistancias());
//                for (int i = 0; i < cor.getMatrizDistancias().length; i++) {
//                    for (int j = 0; j < cor.getMatrizDistancias().length; j++) {
//                        System.out.print(cor.getMatrizDistancias()[i][j] + " ");
//                    }
//                    System.out.println();
//                }
            }
        }
    }

    private MatrizDados getMatrizDadosCorrelacao() {
        int grupo = grupoEscolhidoMatriz;
        int numElemento = 0;
        System.out.println("Matriz dos grupos");
//        for (int i = 0; i < getMatrizGrupos().length; i++) {
//            for (int j = 0; j < getMatrizGrupos()[0].length; j++) {
//                System.out.print(getMatrizGrupos()[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < getMatrizGrupos()[0].length; i++) {
            if (getMatrizGrupos()[1][i] == grupo) {
                numElemento++;
            }
        }
        if (numElemento < 10) {
            JOptionPane.showMessageDialog(null, "Poucos Padrões para este Grupo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return null;
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
//        System.out.println("resultado");
        aux.setMatriz_dados(resultado);
//        for (int i = 0; i < numElemento; i++) {
//            for (int j = 0; j < getMatrizDados().getColunas(); j++) {
//                System.out.print(resultado[i][j] + " ");
//            }
//            System.out.println();
//        }
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

    public static void setCombos() {
        //dispersao correlacao
        comboBoxEixoXCorrelacao.removeAllItems();
        comboBoxEixoYCorrelacao.removeAllItems();
        comboBoxEixoZCorrelacao.removeAllItems();
        comboBoxGruposCorrelacao.removeAllItems();

        comboBoxEixoXCorrelacao.addItem("");
        comboBoxEixoYCorrelacao.addItem("");
        comboBoxEixoZCorrelacao.addItem("");
        comboBoxGruposCorrelacao.addItem("");

        for (int i = 0; i < matrizDados.getClasses().length; i++) {
            comboBoxEixoXCorrelacao.addItem(matrizDados.getClasses()[i]);
            comboBoxEixoYCorrelacao.addItem(matrizDados.getClasses()[i]);
            comboBoxEixoZCorrelacao.addItem(matrizDados.getClasses()[i]);

        }

        for (int i = 0; i < getQntGrupos(); i++) {
            comboBoxGruposCorrelacao.addItem(i + 1);
        }
        comboBoxEixoXCorrelacao.setSelectedIndex(1);
        comboBoxEixoYCorrelacao.setSelectedIndex(2);
        comboBoxGruposCorrelacao.setSelectedIndex(1);

        //dispersao geral
        comboBoxEixoX.removeAllItems();
        comboBoxEixoY.removeAllItems();
        comboBoxEixoZ.removeAllItems();

        comboBoxEixoX.addItem("");
        comboBoxEixoY.addItem("");
        comboBoxEixoZ.addItem("");

        for (int i = 0; i < matrizDados.getClasses().length; i++) {
            comboBoxEixoX.addItem(matrizDados.getClasses()[i]);
            comboBoxEixoY.addItem(matrizDados.getClasses()[i]);
            comboBoxEixoZ.addItem(matrizDados.getClasses()[i]);

        }

        comboBoxEixoX.setSelectedIndex(1);
        comboBoxEixoY.setSelectedIndex(2);
        comboBoxEixoZ.setSelectedIndex(0);

        //dispersao grupos
        comboBoxEixoXGrupos.removeAllItems();
        comboBoxEixoYGrupos.removeAllItems();
        comboBoxEixoZGrupos.removeAllItems();
        comboBoxGrupos.removeAllItems();

        comboBoxEixoXGrupos.addItem("");
        comboBoxEixoYGrupos.addItem("");
        comboBoxEixoZGrupos.addItem("");
        comboBoxGrupos.addItem("");

        for (int i = 0; i < matrizDados.getClasses().length; i++) {
            comboBoxEixoXGrupos.addItem(matrizDados.getClasses()[i]);
            comboBoxEixoYGrupos.addItem(matrizDados.getClasses()[i]);
            comboBoxEixoZGrupos.addItem(matrizDados.getClasses()[i]);

        }

        for (int i = 0; i < getQntGrupos(); i++) {
            comboBoxGrupos.addItem(i + 1);
        }
        comboBoxEixoXGrupos.setSelectedIndex(1);
        comboBoxEixoYGrupos.setSelectedIndex(2);
        comboBoxGrupos.setSelectedIndex(1);

        // matriz
        comboBoxGruposMatriz.removeAllItems();


        comboBoxGruposMatriz.addItem("");

        for (int i = 0; i < getQntGrupos(); i++) {
            comboBoxGruposMatriz.addItem(i + 1);
        }
        comboBoxGruposMatriz.setSelectedIndex(0);

    }

    public static JComboBox getComboBoxEixoX() {
        return comboBoxEixoX;
    }

    public static void setComboBoxEixoX(JComboBox comboBoxEixoX) {
        TecnicasDispersao.comboBoxEixoX = comboBoxEixoX;
    }

    public static JComboBox getComboBoxEixoY() {
        return comboBoxEixoY;
    }

    public static void setComboBoxEixoY(JComboBox comboBoxEixoY) {
        TecnicasDispersao.comboBoxEixoY = comboBoxEixoY;
    }

    public static JComboBox getComboBoxEixoZ() {
        return comboBoxEixoZ;
    }

    public static void setComboBoxEixoZ(JComboBox comboBoxEixoZ) {
        TecnicasDispersao.comboBoxEixoZ = comboBoxEixoZ;
    }

    private void setVetorGrupos() {
        if (vetorGrupos != null) {
            boolean vai = true;
            for (int i = 0; i < vetorGrupos.length; i++) {
                if (vetorGrupos[i] == comboBoxGrupos.getSelectedIndex()) {
                    vetorGrupos[i] = 0;
                    vai = false;
                    break;
                }
            }
            if (vai) {
                for (int i = 0; i < vetorGrupos.length; i++) {
                    if (vetorGrupos[i] == 0 && comboBoxGrupos.getSelectedIndex() != 0) {
                        vetorGrupos[i] = comboBoxGrupos.getSelectedIndex();
                        break;
                    }
                }


            }
            System.out.println("Vetor Grupos: ");
            for (int i = 0; i < vetorGrupos.length; i++) {
                System.out.println("v = " + vetorGrupos[i]);
            }
            comboBoxGrupos.setSelectedIndex(0);
        }
    }

    public static int[] getVetorGrupos() {
        return vetorGrupos;
    }

    public static void setVetorGrupos(int[] vetorGrupos) {
        TecnicasDispersao.vetorGrupos = vetorGrupos;
    }

    public static JComboBox getComboBoxEixoXGrupos() {
        return comboBoxEixoXGrupos;
    }

    public static void setComboBoxEixoXGrupos(JComboBox comboBoxEixoXGrupos) {
        TecnicasDispersao.comboBoxEixoXGrupos = comboBoxEixoXGrupos;
    }

    public static JComboBox getComboBoxEixoYGrupos() {
        return comboBoxEixoYGrupos;
    }

    public static void setComboBoxEixoYGrupos(JComboBox comboBoxEixoYGrupos) {
        TecnicasDispersao.comboBoxEixoYGrupos = comboBoxEixoYGrupos;
    }

    public static JComboBox getComboBoxEixoZGrupos() {
        return comboBoxEixoZGrupos;
    }

    public static void setComboBoxEixoZGrupos(JComboBox comboBoxEixoZGrupos) {
        TecnicasDispersao.comboBoxEixoZGrupos = comboBoxEixoZGrupos;
    }

    public static int getGrupoEscolhidoMatriz() {
        return grupoEscolhidoMatriz;
    }

    public static void setGrupoEscolhidoMatriz(int grupoEscolhidoMatriz) {
        TecnicasDispersao.grupoEscolhidoMatriz = grupoEscolhidoMatriz;
    }

    public static JComboBox getComboBoxEixoXCorrelacao() {
        return comboBoxEixoXCorrelacao;
    }

    public static void setComboBoxEixoXCorrelacao(JComboBox comboBoxEixoXCorrelacao) {
        TecnicasDispersao.comboBoxEixoXCorrelacao = comboBoxEixoXCorrelacao;
    }

    public static JComboBox getComboBoxEixoYCorrelacao() {
        return comboBoxEixoYCorrelacao;
    }

    public static void setComboBoxEixoYCorrelacao(JComboBox comboBoxEixoYCorrelacao) {
        TecnicasDispersao.comboBoxEixoYCorrelacao = comboBoxEixoYCorrelacao;
    }

    public static JComboBox getComboBoxEixoZCorrelacao() {
        return comboBoxEixoZCorrelacao;
    }

    public static void setComboBoxEixoZCorrelacao(JComboBox comboBoxEixoZCorrelacao) {
        TecnicasDispersao.comboBoxEixoZCorrelacao = comboBoxEixoZCorrelacao;
    }

    public static JComboBox getComboBoxGrupos() {
        return comboBoxGrupos;
    }

    public static void setComboBoxGrupos(JComboBox comboBoxGrupos) {
        TecnicasDispersao.comboBoxGrupos = comboBoxGrupos;
    }

    public static JComboBox getComboBoxGruposCorrelacao() {
        return comboBoxGruposCorrelacao;
    }

    public static void setComboBoxGruposCorrelacao(JComboBox comboBoxGruposCorrelacao) {
        TecnicasDispersao.comboBoxGruposCorrelacao = comboBoxGruposCorrelacao;
    }

    public static JComboBox getComboBoxGruposMatriz() {
        return comboBoxGruposMatriz;
    }

    public static void setComboBoxGruposMatriz(JComboBox comboBoxGruposMatriz) {
        TecnicasDispersao.comboBoxGruposMatriz = comboBoxGruposMatriz;
    }
}
