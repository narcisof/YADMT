/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import moduledefault.clustering.distancias.Correlação;
import moduledefault.clustering.uteis.Base;
import moduledefault.clustering.uteis.Cluster;
import moduledefault.clustering.uteis.Padrao;

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
    private static MatrizCorrelacao MC;
    private static CoordenadasParalelas CP;
    private static Radviz RV;
    private static CoordenadasParalelasCirculares CPC;
    private static TecnicasDispersao INSTANCE;
    private static Base matrizDados;
    private static ArrayList<Cluster> clusters;
    private static int qntGrupos;
    private static int[] vetorGrupos;
    private static int grupoEscolhidoMatriz = 0;
    static boolean setou = false;
    static StringBuffer bufferLogGrupos;
    JPanel[][] quadroPanels;
    JPanel[][] quadroPanelsPixels;
    private static double dvrpX;
    private static double dvrpY;
    private static double dvrpZ;
    private static double dpontoX;
    private static double dpontoY;
    private static double dpontoZ;
    private static double ddistancia;

    public boolean isSetou() {
        return setou;
    }

    public static void setSetou(boolean setou) {
        TecnicasDispersao.setou = setou;
    }

    public static int getQntGrupos() {
        return qntGrupos;
    }

    public static void setQntGrupos(int qntGrupos) {
        TecnicasDispersao.qntGrupos = qntGrupos;
        vetorGrupos = new int[TecnicasDispersao.qntGrupos];
    }

//    public static void setComponentes() {
//        comboBoxEixoX.setSelectedIndex(0);
//        comboBoxEixoY.setSelectedIndex(0);
//        comboBoxEixoZ.setSelectedIndex(0);
//        comboBoxEixoXGrupos.setSelectedIndex(0);
//        comboBoxEixoYGrupos.setSelectedIndex(0);
//        comboBoxEixoZGrupos.setSelectedIndex(0);
//        comboBoxGrupos.setSelectedIndex(0);
//        comboBoxGruposMatriz.setSelectedIndex(0);
//    }
    public TecnicasDispersao() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
//        repaint();

        dvrpX = 1;
        dvrpY = 1;
        dvrpZ = 1;
        dpontoX = 0;
        dpontoY = 0;
        dpontoZ = 0;
        ddistancia = 10;
    }

    public static synchronized TecnicasDispersao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TecnicasDispersao();
        } else {
            INSTANCE.repaint();
        }
        bufferLogGrupos = new StringBuffer();
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        fundoDispersaoGeral = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxEixoX = new javax.swing.JComboBox();
        comboBoxEixoY = new javax.swing.JComboBox();
        comboBoxEixoZ = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        campoTexto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        vrpX = new javax.swing.JSpinner();
        vrpY = new javax.swing.JSpinner();
        vrpZ = new javax.swing.JSpinner();
        pontoX = new javax.swing.JSpinner();
        pontoY = new javax.swing.JSpinner();
        pontoZ = new javax.swing.JSpinner();
        distancia = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        fundoMatrizCorrelacao = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxGruposMatriz = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        fundoDispersaoGrupos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxEixoXGrupos = new javax.swing.JComboBox();
        comboBoxEixoYGrupos = new javax.swing.JComboBox();
        comboBoxEixoZGrupos = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logDispersaoGrupos = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comboBoxGrupos = new javax.swing.JComboBox();
        tabCorrelacao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fundoCorrelacao = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaBase = new javax.swing.JTable();
        tabParalelas = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        fundoParalelas = new javax.swing.JPanel();
        fundoRadviz = new javax.swing.JPanel();
        fundoCirculares = new javax.swing.JPanel();
        fundoPixelOriented = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        fundoOrientedPixel = new javax.swing.JPanel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabs.setBackground(new java.awt.Color(255, 255, 255));
        tabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabsMouseClicked(evt);
            }
        });
        tabs.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                tabsComponentResized(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        fundoDispersaoGeral.setBackground(new java.awt.Color(255, 255, 255));
        fundoDispersaoGeral.setPreferredSize(new java.awt.Dimension(474, 474));

        javax.swing.GroupLayout fundoDispersaoGeralLayout = new javax.swing.GroupLayout(fundoDispersaoGeral);
        fundoDispersaoGeral.setLayout(fundoDispersaoGeralLayout);
        fundoDispersaoGeralLayout.setHorizontalGroup(
            fundoDispersaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );
        fundoDispersaoGeralLayout.setVerticalGroup(
            fundoDispersaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Eixos"));

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
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxEixoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxEixoZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxEixoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEixoY, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEixoZ, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        vrpX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vrpXStateChanged(evt);
            }
        });

        vrpY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vrpYStateChanged(evt);
            }
        });

        vrpZ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vrpZStateChanged(evt);
            }
        });

        pontoX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pontoXStateChanged(evt);
            }
        });

        pontoY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pontoYStateChanged(evt);
            }
        });

        pontoZ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pontoZStateChanged(evt);
            }
        });

        distancia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                distanciaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(fundoDispersaoGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(vrpX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(vrpY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pontoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pontoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(708, 708, 708)
                                .addComponent(vrpZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pontoZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(78, 78, 78))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(708, 708, 708)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(fundoDispersaoGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(campoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vrpX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pontoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pontoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vrpY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pontoZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vrpZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabs.addTab("Gráfico Dispersão Geral", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        fundoMatrizCorrelacao.setBackground(new java.awt.Color(255, 255, 255));
        fundoMatrizCorrelacao.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                fundoMatrizCorrelacaoComponentHidden(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                fundoMatrizCorrelacaoComponentResized(evt);
            }
        });

        javax.swing.GroupLayout fundoMatrizCorrelacaoLayout = new javax.swing.GroupLayout(fundoMatrizCorrelacao);
        fundoMatrizCorrelacao.setLayout(fundoMatrizCorrelacaoLayout);
        fundoMatrizCorrelacaoLayout.setHorizontalGroup(
            fundoMatrizCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fundoMatrizCorrelacaoLayout.setVerticalGroup(
            fundoMatrizCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 87, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupos"));

        jLabel8.setText("Grupos:");

        comboBoxGruposMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGruposMatrizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxGruposMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(782, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboBoxGruposMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fundoMatrizCorrelacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fundoMatrizCorrelacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabs.addTab("Matriz de Correlação", jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        fundoDispersaoGrupos.setBackground(new java.awt.Color(255, 255, 255));
        fundoDispersaoGrupos.setPreferredSize(new java.awt.Dimension(474, 474));

        javax.swing.GroupLayout fundoDispersaoGruposLayout = new javax.swing.GroupLayout(fundoDispersaoGrupos);
        fundoDispersaoGrupos.setLayout(fundoDispersaoGruposLayout);
        fundoDispersaoGruposLayout.setHorizontalGroup(
            fundoDispersaoGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        fundoDispersaoGruposLayout.setVerticalGroup(
            fundoDispersaoGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Eixos"));

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
                .addContainerGap(320, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxEixoXGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEixoYGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEixoZGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));

        logDispersaoGrupos.setColumns(20);
        logDispersaoGrupos.setRows(5);
        jScrollPane1.setViewportView(logDispersaoGrupos);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupos"));

        jLabel7.setText("Grupos:");

        comboBoxGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxGruposMouseClicked(evt);
            }
        });
        comboBoxGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGruposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fundoDispersaoGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fundoDispersaoGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Gráfico Dispersão Grupos", jPanel4);

        tabCorrelacao.setBackground(new java.awt.Color(255, 255, 255));
        tabCorrelacao.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                tabCorrelacaoComponentResized(evt);
            }
        });

        jScrollPane2.setToolTipText("");
        jScrollPane2.setAutoscrolls(true);

        fundoCorrelacao.setBackground(new java.awt.Color(255, 255, 255));
        fundoCorrelacao.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                fundoCorrelacaoComponentResized(evt);
            }
        });

        javax.swing.GroupLayout fundoCorrelacaoLayout = new javax.swing.GroupLayout(fundoCorrelacao);
        fundoCorrelacao.setLayout(fundoCorrelacaoLayout);
        fundoCorrelacaoLayout.setHorizontalGroup(
            fundoCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 893, Short.MAX_VALUE)
        );
        fundoCorrelacaoLayout.setVerticalGroup(
            fundoCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(fundoCorrelacao);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));

        jScrollPane3.setViewportView(tabelaBase);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabCorrelacaoLayout = new javax.swing.GroupLayout(tabCorrelacao);
        tabCorrelacao.setLayout(tabCorrelacaoLayout);
        tabCorrelacaoLayout.setHorizontalGroup(
            tabCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCorrelacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabCorrelacaoLayout.setVerticalGroup(
            tabCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCorrelacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("Correlação", tabCorrelacao);

        javax.swing.GroupLayout fundoParalelasLayout = new javax.swing.GroupLayout(fundoParalelas);
        fundoParalelas.setLayout(fundoParalelasLayout);
        fundoParalelasLayout.setHorizontalGroup(
            fundoParalelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
        );
        fundoParalelasLayout.setVerticalGroup(
            fundoParalelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(fundoParalelas);

        javax.swing.GroupLayout tabParalelasLayout = new javax.swing.GroupLayout(tabParalelas);
        tabParalelas.setLayout(tabParalelasLayout);
        tabParalelasLayout.setHorizontalGroup(
            tabParalelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabParalelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        tabParalelasLayout.setVerticalGroup(
            tabParalelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabParalelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        tabs.addTab("Coordenadas Paralelas", tabParalelas);

        javax.swing.GroupLayout fundoRadvizLayout = new javax.swing.GroupLayout(fundoRadviz);
        fundoRadviz.setLayout(fundoRadvizLayout);
        fundoRadvizLayout.setHorizontalGroup(
            fundoRadvizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        fundoRadvizLayout.setVerticalGroup(
            fundoRadvizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 691, Short.MAX_VALUE)
        );

        tabs.addTab("RadViz", fundoRadviz);

        javax.swing.GroupLayout fundoCircularesLayout = new javax.swing.GroupLayout(fundoCirculares);
        fundoCirculares.setLayout(fundoCircularesLayout);
        fundoCircularesLayout.setHorizontalGroup(
            fundoCircularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        fundoCircularesLayout.setVerticalGroup(
            fundoCircularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 691, Short.MAX_VALUE)
        );

        tabs.addTab("Coordenadas Paralelas Circulares", fundoCirculares);

        jScrollPane5.setToolTipText("");
        jScrollPane5.setAutoscrolls(true);

        fundoOrientedPixel.setBackground(new java.awt.Color(255, 255, 255));
        fundoOrientedPixel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                fundoOrientedPixelComponentResized(evt);
            }
        });

        javax.swing.GroupLayout fundoOrientedPixelLayout = new javax.swing.GroupLayout(fundoOrientedPixel);
        fundoOrientedPixel.setLayout(fundoOrientedPixelLayout);
        fundoOrientedPixelLayout.setHorizontalGroup(
            fundoOrientedPixelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 893, Short.MAX_VALUE)
        );
        fundoOrientedPixelLayout.setVerticalGroup(
            fundoOrientedPixelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(fundoOrientedPixel);

        javax.swing.GroupLayout fundoPixelOrientedLayout = new javax.swing.GroupLayout(fundoPixelOriented);
        fundoPixelOriented.setLayout(fundoPixelOrientedLayout);
        fundoPixelOrientedLayout.setHorizontalGroup(
            fundoPixelOrientedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoPixelOrientedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                .addContainerGap())
        );
        fundoPixelOrientedLayout.setVerticalGroup(
            fundoPixelOrientedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoPixelOrientedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        tabs.addTab("Orientada à Pixel", fundoPixelOriented);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabsComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabsComponentResized
        dispersaoGeral();
        dispersaoGrupos();
//        setQuadroPanels();
//        setQuadroPanelsOrientadaPixels();
        setCoordenadasParalelas();
        setRadviz();
        setCirculares();
    }//GEN-LAST:event_tabsComponentResized

    private void comboBoxGruposMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGruposMatrizActionPerformed
        if (setou) {
            matrizCorrelacao();
            grupoEscolhidoMatriz = comboBoxGruposMatriz.getSelectedIndex();
            if (grupoEscolhidoMatriz != 0) {
                Base aux = getMatrizDadosCorrelacao();
                if (aux != null) {
                    setMatrizGruposCorrelacao(aux);
                    MC.setRepinta(false);
                    repaint();
                } else {
                    MC.setRepinta(true);
                    repaint();
                }
            }
        } else {
            setMatrizGruposCorrelacao(null);
        }
    }//GEN-LAST:event_comboBoxGruposMatrizActionPerformed
    private void comboBoxGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGruposActionPerformed

        if (setou) {
            setVetorGrupos();
            repaint();
        }
    }//GEN-LAST:event_comboBoxGruposActionPerformed

    private void comboBoxEixoZGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoZGruposActionPerformed
        //    repaint();
    }//GEN-LAST:event_comboBoxEixoZGruposActionPerformed

    private void comboBoxEixoYGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoYGruposActionPerformed
        //   repaint();
    }//GEN-LAST:event_comboBoxEixoYGruposActionPerformed

    private void comboBoxEixoXGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoXGruposActionPerformed
        //   repaint();
    }//GEN-LAST:event_comboBoxEixoXGruposActionPerformed

    private void comboBoxEixoZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoZActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoZActionPerformed

    private void comboBoxEixoYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoYActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoYActionPerformed

    private void comboBoxEixoXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoXActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoXActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //matrizDados = null;
    }//GEN-LAST:event_formWindowClosing

    private void comboBoxGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxGruposMouseClicked
    }//GEN-LAST:event_comboBoxGruposMouseClicked

    private void fundoMatrizCorrelacaoComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_fundoMatrizCorrelacaoComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_fundoMatrizCorrelacaoComponentHidden

    private void fundoMatrizCorrelacaoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_fundoMatrizCorrelacaoComponentResized
//        fundoMatrizCorrelacao.getGraphics().clearRect(0, 0, fundoMatrizCorrelacao.getWidth(), fundoMatrizCorrelacao.getHeight());
    }//GEN-LAST:event_fundoMatrizCorrelacaoComponentResized

    private void fundoCorrelacaoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_fundoCorrelacaoComponentResized
    }//GEN-LAST:event_fundoCorrelacaoComponentResized

    private void tabCorrelacaoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabCorrelacaoComponentResized
        setQuadroPanels();
        repaint();
    }//GEN-LAST:event_tabCorrelacaoComponentResized

    private void tabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabsMouseClicked
//        setQuadroPanels();
    }//GEN-LAST:event_tabsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void vrpXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_vrpXStateChanged
        dvrpX = (Double.valueOf(vrpX.getValue().toString()));
        repaint();
    }//GEN-LAST:event_vrpXStateChanged

    private void vrpYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_vrpYStateChanged
        dvrpY = (Double.valueOf(vrpY.getValue().toString()));
        repaint();
    }//GEN-LAST:event_vrpYStateChanged

    private void vrpZStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_vrpZStateChanged
        dvrpY = (Double.valueOf(vrpZ.getValue().toString()));
        repaint();
    }//GEN-LAST:event_vrpZStateChanged

    private void pontoXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pontoXStateChanged
        dpontoX = (Double.valueOf(pontoX.getValue().toString()));
        repaint();
    }//GEN-LAST:event_pontoXStateChanged

    private void pontoYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pontoYStateChanged
        dpontoY = (Double.valueOf(pontoY.getValue().toString()));
        repaint();
    }//GEN-LAST:event_pontoYStateChanged

    private void pontoZStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pontoZStateChanged
        dpontoZ = (Double.valueOf(pontoZ.getValue().toString()));
        repaint();
    }//GEN-LAST:event_pontoZStateChanged

    private void distanciaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_distanciaStateChanged
        ddistancia = (Double.valueOf(distancia.getValue().toString()));
        repaint();
    }//GEN-LAST:event_distanciaStateChanged

    private void fundoOrientedPixelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_fundoOrientedPixelComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_fundoOrientedPixelComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField campoTexto;
    private static javax.swing.JComboBox comboBoxEixoX;
    private static javax.swing.JComboBox comboBoxEixoXGrupos;
    private static javax.swing.JComboBox comboBoxEixoY;
    private static javax.swing.JComboBox comboBoxEixoYGrupos;
    private static javax.swing.JComboBox comboBoxEixoZ;
    private static javax.swing.JComboBox comboBoxEixoZGrupos;
    private static javax.swing.JComboBox comboBoxGrupos;
    private static javax.swing.JComboBox comboBoxGruposMatriz;
    private javax.swing.JSpinner distancia;
    private static javax.swing.JPanel fundoCirculares;
    private static javax.swing.JPanel fundoCorrelacao;
    private static javax.swing.JPanel fundoDispersaoGeral;
    private static javax.swing.JPanel fundoDispersaoGrupos;
    private static javax.swing.JPanel fundoMatrizCorrelacao;
    private static javax.swing.JPanel fundoOrientedPixel;
    private static javax.swing.JPanel fundoParalelas;
    private javax.swing.JPanel fundoPixelOriented;
    private static javax.swing.JPanel fundoRadviz;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private static javax.swing.JTextArea logDispersaoGrupos;
    private javax.swing.JSpinner pontoX;
    private javax.swing.JSpinner pontoY;
    private javax.swing.JSpinner pontoZ;
    private javax.swing.JPanel tabCorrelacao;
    private javax.swing.JPanel tabParalelas;
    private javax.swing.JTable tabelaBase;
    private static javax.swing.JTabbedPane tabs;
    private javax.swing.JSpinner vrpX;
    private javax.swing.JSpinner vrpY;
    private javax.swing.JSpinner vrpZ;
    // End of variables declaration//GEN-END:variables

    public static Base getMatrizDados() {
        return matrizDados;
    }

    public static void setMatrizDados(Base m) {
        matrizDados = m;
    }

    public static ArrayList<Cluster> getClusters() {
        return clusters;
    }

    public static void setCluster(ArrayList<Cluster> cl) {
        TecnicasDispersao.clusters = cl;
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

    private void setMatrizGruposCorrelacao(Base grupos) {
        if (MC == null) {
            MC = new MatrizCorrelacao();
        } else {
            if (grupoEscolhidoMatriz != 0) {
                if (grupos != null) {
                    Correlação cor = new Correlação(grupos);
                    cor.distanciaGrupos(grupos);
                    MC.setMatrizGrupos(cor.getMatrizDistancias());
                } else {
                    MC.setMatrizGrupos(null);
                }
            }
        }
    }

    private Base getMatrizDadosCorrelacao() {
        int grupo = grupoEscolhidoMatriz;
        int numElemento = clusters.get(grupo - 1).getGrupo().size();
        if (numElemento < 10 && comboBoxGruposMatriz.getSelectedIndex() != 0) {
            JOptionPane.showMessageDialog(null, "Poucos Padrões para este Grupo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        Base aux = new Base();
        aux.setLinhas(numElemento);
        aux.setColunas(getMatrizDados().getDataSet().get(0).getAtributos().size());
        double[][] resultado = new double[numElemento][getMatrizDados().getDataSet().get(0).getAtributos().size()];
        int contadorResultado = 0;
        for (int i = 0; i < clusters.get(grupo - 1).getGrupo().size(); i++) {
            int padrao = clusters.get(grupo - 1).getGrupo().get(i).getNumero();
            for (int j = 0; j < getMatrizDados().getDataSet().get(padrao).getAtributos().size(); j++) {
                resultado[i][j] = getMatrizDados().getDataSet().get(padrao).getAtributos().get(j);
            }
        }
        int grupos = 0;
        for (int i = 0; i < resultado.length; i++) {
            Padrao p = new Padrao();
            p.setNumero(grupo);
            ++grupos;
            for (int j = 0; j < resultado[0].length; j++) {
                p.addAtributos(resultado[i][j]);
            }
//            p.setClasse(base.getOutput()[i].toString());
            aux.addDataSet(p);
        }
        return aux;
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


        //dispersao geral
        comboBoxEixoX.removeAllItems();
        comboBoxEixoY.removeAllItems();
        comboBoxEixoZ.removeAllItems();

        comboBoxEixoX.addItem("");
        comboBoxEixoY.addItem("");
        comboBoxEixoZ.addItem("");

        for (int i = 0; i < matrizDados.getAtributos().size() - 1; i++) {
            comboBoxEixoX.addItem(matrizDados.getAtributos().get(i));
            comboBoxEixoY.addItem(matrizDados.getAtributos().get(i));
            comboBoxEixoZ.addItem(matrizDados.getAtributos().get(i));

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

        for (int i = 0; i < matrizDados.getAtributos().size(); i++) {
            comboBoxEixoXGrupos.addItem(matrizDados.getAtributos().get(i));
            comboBoxEixoYGrupos.addItem(matrizDados.getAtributos().get(i));
            comboBoxEixoZGrupos.addItem(matrizDados.getAtributos().get(i));

        }

        for (int i = 0; i < getQntGrupos(); i++) {
            comboBoxGrupos.addItem("Grupo " + (i + 1));
        }
        comboBoxEixoXGrupos.setSelectedIndex(1);
        comboBoxEixoYGrupos.setSelectedIndex(2);
        comboBoxGrupos.setSelectedIndex(0);

        // matriz
        comboBoxGruposMatriz.removeAllItems();
        comboBoxGruposMatriz.addItem("");

        for (int i = 0; i < getQntGrupos(); i++) {
            comboBoxGruposMatriz.addItem(i + 1);
        }
        comboBoxGruposMatriz.setSelectedIndex(0);

        logDispersaoGrupos.setText("");
        setSetou(true);
    }

    private void dispersaoGrupos() {
        if (GDGr == null) {
            GDGr = new GraficoDispersaoGrupo();
        }
        GDGr.setSize(fundoDispersaoGrupos.getWidth(), fundoDispersaoGrupos.getHeight());
        fundoDispersaoGrupos.add(GDGr);
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
                    if (comboBoxGrupos.getSelectedIndex() != 0) {
                        bufferLogGrupos.append("Grupo Desselecionado: [" + vetorGrupos[i] + "]\n");
                    }
                    vetorGrupos[i] = 0;
                    vai = false;
                    break;
                }
            }
            if (vai) {
                for (int i = 0; i < vetorGrupos.length; i++) {
                    if (vetorGrupos[i] == 0 && comboBoxGrupos.getSelectedIndex() != 0) {
                        vetorGrupos[i] = comboBoxGrupos.getSelectedIndex();
                        bufferLogGrupos.append("Grupo Selecionado: [" + vetorGrupos[i] + "]\n");
                        break;
                    }
                }


            }
            boolean semGrupos = true;
            int numGruposSelecionados = 0;
            for (int i = 0; i < vetorGrupos.length; i++) {
                if (vetorGrupos[i] != 0) {
                    semGrupos = false;
                    numGruposSelecionados++;
                }
            }
            if (semGrupos) {
                bufferLogGrupos.append("Sem Grupos para Visualização\n");
            } else {
                if (numGruposSelecionados == 1) {
                    bufferLogGrupos.append("Grupo Selecionado para Visualização: ");
                    for (int i = 0; i < vetorGrupos.length; i++) {
                        if (vetorGrupos[i] != 0) {
                            bufferLogGrupos.append("[" + vetorGrupos[i] + "]\n");
                        }
                    }
                } else {
                    bufferLogGrupos.append("Grupos Selecionado para Visualização: [");
                    int ultimoGrupo = 1;
                    for (int i = 0; i < vetorGrupos.length; i++) {
                        if (vetorGrupos[i] != 0) {
                            if (ultimoGrupo == numGruposSelecionados) {
                                bufferLogGrupos.append(vetorGrupos[i] + "]");
                            } else {
                                bufferLogGrupos.append(vetorGrupos[i] + ", ");
                            }
                            ultimoGrupo++;
                        }
                    }
//                    bufferLogGrupos.append("]");
                    bufferLogGrupos.append("\n");
                }

            }
            comboBoxGrupos.setSelectedIndex(0);
            logDispersaoGrupos.setText(bufferLogGrupos.toString());

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

    public static JComboBox getComboBoxGrupos() {
        return comboBoxGrupos;
    }

    public static void setComboBoxGrupos(JComboBox comboBoxGrupos) {
        TecnicasDispersao.comboBoxGrupos = comboBoxGrupos;
    }

    public static JComboBox getComboBoxGruposMatriz() {
        return comboBoxGruposMatriz;
    }

    public static void setComboBoxGruposMatriz(JComboBox comboBoxGruposMatriz) {
        TecnicasDispersao.comboBoxGruposMatriz = comboBoxGruposMatriz;
    }

    public void setLogDispersaoGrupos() {
        this.logDispersaoGrupos = new JTextArea();
    }

    public void setQuadroPanels() {

        if (matrizDados != null) {
            quadroPanels = new JPanel[matrizDados.getDataSet().get(0).getAtributos().size()][matrizDados.getDataSet().get(0).getAtributos().size()];
            int inicioX = 50;
            int inicioY = 50;
            for (int i = 0; i < quadroPanels.length; i++) {
                inicioX = 50;
                for (int j = 0; j < quadroPanels[0].length; j++) {
                    QuadroPanel aux;
                    if (i == j) {
                        aux = new QuadroPanel(1, i + 1, matrizDados, i, j);
                    } else {
                        aux = new QuadroPanel(2, i + 1, matrizDados, i, j);
                    }
                    aux.setLocation(inicioX, inicioY);
                    aux.setSize(150, 150);
                    quadroPanels[i][j] = aux;
                    fundoCorrelacao.add(quadroPanels[i][j]);
                    quadroPanels[i][j].setVisible(true);
                    inicioX += 200;
                    int largura = 150 * quadroPanels[0].length + (50 * quadroPanels[0].length);
                    int altura = 150 * quadroPanels.length + (50 * quadroPanels.length) + 50;
                    fundoCorrelacao.setSize(largura, altura);
                    fundoCorrelacao.setPreferredSize(new Dimension(largura, altura));
//                    if (i == j) {
//                        paintPanels(1, i + 1, quadroPanels[i][j].getGraphics(), matrizDados);
//                    }
                    fundoCorrelacao.updateUI();
                    jScrollPane2.updateUI();
                }
                inicioY += 200;
            }
            setCorrelacoes();
        }
    }
    public void setQuadroPanelsOrientadaPixels() {

        if (matrizDados != null) {
            quadroPanelsPixels = new JPanel[matrizDados.getDataSet().get(0).getAtributos().size()][matrizDados.getDataSet().get(0).getAtributos().size()];
            int inicioX = 50;
            int inicioY = 50;
            for (int i = 0; i < quadroPanelsPixels.length; i++) {
                inicioX = 50;
                for (int j = 0; j < quadroPanelsPixels[0].length; j++) {
                    OrientedPixels aux = null;
                    
                    aux.setLocation(inicioX, inicioY);
                    aux.setSize(150, 150);
                    quadroPanelsPixels[i][j] = aux;
                    fundoOrientedPixel.add(quadroPanelsPixels[i][j]);
                    quadroPanelsPixels[i][j].setVisible(true);
                    inicioX += 200;
                    int largura = 150 * quadroPanelsPixels[0].length + (50 * quadroPanelsPixels[0].length);
                    int altura = 150 * quadroPanelsPixels.length + (50 * quadroPanelsPixels.length) + 50;
                    fundoOrientedPixel.setSize(largura, altura);
                    fundoOrientedPixel.setPreferredSize(new Dimension(largura, altura));
//                    if (i == j) {
//                        paintPanels(1, i + 1, quadroPanels[i][j].getGraphics(), matrizDados);
//                    }
                    fundoOrientedPixel.updateUI();
                    jScrollPane5.updateUI();
                }
                inicioY += 200;
            }
        }
    }

    public void setCoordenadasParalelas() {
        if (CP == null) {
            CP = new CoordenadasParalelas();
        }
        CP.setSize(fundoParalelas.getWidth(), fundoParalelas.getHeight());
        fundoParalelas.add(CP);
        int numEixos = matrizDados.getDataSet().get(0).getAtributos().size();
        int inicioX = 50;
        int distanciaEixos = 350;
        fundoParalelas.setSize((distanciaEixos * (numEixos) + inicioX) - 300, fundoParalelas.getHeight());
        fundoParalelas.setPreferredSize(new Dimension((distanciaEixos * (numEixos) + inicioX) - 300, fundoParalelas.getHeight()));

    }

    public static JPanel getFundoCorrelacao() {
        return fundoCorrelacao;
    }

    private void setCorrelacoes() {
        Correlação cor = new Correlação();
        cor.trasnpoe(matrizDados);
        double[][] matrizCorrelacaoTransposta = cor.getMatrizDistancias();
        for (int i = 0; i < matrizCorrelacaoTransposta.length; i++) {
            for (int j = 0; j < matrizCorrelacaoTransposta[0].length; j++) {
                System.out.print(matrizCorrelacaoTransposta[i][j] + " ");
            }
            System.out.println();
        }
        String[] nomesColunas = new String[matrizDados.getAtributos().size() - 1];
        for (int i = 0; i < nomesColunas.length; i++) {
            nomesColunas[i] = matrizDados.getAtributos().get(i);
        }

        DefaultTableModel modelo = new DefaultTableModel(nomesColunas, matrizDados.getAtributos().size() - 1);
        modelo.setNumRows(0);
        tabelaBase.setModel(modelo);
        String[] temp = new String[nomesColunas.length];
        for (int i = 0; i < matrizCorrelacaoTransposta.length; i++) {
            for (int j = 0; j < matrizCorrelacaoTransposta[0].length; j++) {
                double valor;
                DecimalFormat df = new DecimalFormat("0.00000");
                valor = matrizCorrelacaoTransposta[i][j];
                String str = df.format(valor);
                temp[j] = str;
            }
            modelo.addRow(temp);
        }

    }

    public static double getDvrpX() {
        return dvrpX;
    }

    public static double getDvrpY() {
        return dvrpY;
    }

    public static double getDvrpZ() {
        return dvrpZ;
    }

    public static double getDpontoX() {
        return dpontoX;
    }

    public static double getDpontoY() {
        return dpontoY;
    }

    public static double getDpontoZ() {
        return dpontoZ;
    }

    public static double getDdistancia() {
        return ddistancia;
    }

    public static JPanel getFundoParalelas() {
        return fundoParalelas;
    }

    private void setRadviz() {
        if (RV == null) {
            RV = new Radviz();
        }
        RV.setSize(fundoRadviz.getWidth(), fundoRadviz.getHeight());
        fundoRadviz.add(RV);
    }

    private void setCirculares() {
        if (CPC == null) {
            CPC = new CoordenadasParalelasCirculares();
        }
        CPC.setSize(fundoCirculares.getWidth(), fundoCirculares.getHeight());
        fundoCirculares.add(CPC);
    }

    public static JPanel getFundoRadviz() {
        return fundoRadviz;
    }

    public static JPanel getFundoCirculares() {
        return fundoCirculares;
    }
}
