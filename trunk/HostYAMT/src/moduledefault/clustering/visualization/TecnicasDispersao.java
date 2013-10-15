/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import moduledefault.clustering.distancias.CorrelacaoKendallTau;
import moduledefault.clustering.distancias.CorrelacaoPearson;
import moduledefault.clustering.distancias.CorrelacaoSpearman;
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
    private static LinePlot LP;
    private static GraficoDispersaoGrupo GDGr;
    private static GraficoDispersaoGeral GDG;
    private static MatrizCorrelacao MC;
    private static CoordenadasParalelas CP;
    private static CoordenadasParalelasCirculares CPC;
    private static TecnicasDispersao INSTANCE;
    private static Base matrizDados;
    private static ArrayList<Cluster> clusters;
    private static int qntGrupos;
    private static ArrayList<String> vetorGrupos;
    private static int grupoEscolhidoMatriz = 0;
    static boolean setou = false;
    static StringBuffer bufferLogGrupos;
    static JPanel[][] quadroPanels;
    JPanel[][] quadroPanelsPixels;
    static int tamanhoOriginalCorrelacaoX;
    static int tamanhoOriginalCorrelacaoY;
    static int tamanhoOriginalParalelaX;
    static int tamanhoOriginalParalelaY;
    static int tamanhoPontoGeral;
    static int tamanhoPontoGrupos;
    DefaultListModel listModelA = new DefaultListModel();
    DefaultListModel listModelB = new DefaultListModel();
    DefaultListModel listModelAParalelas = new DefaultListModel();
    DefaultListModel listModelBParalelas = new DefaultListModel();
    static boolean desenharPontos = false;
    static boolean desenharPontosCirculares = false;
    static int distanciaEixos;
    static boolean isBase = true;
    static ArrayList<Ponto> pontosGerais;
    boolean isSelecionadoPontoGeral = false;
    static boolean pintarPontoGeral = false;
    static ArrayList<Ponto> pontosPintarGeral;
    static ArrayList<Ponto> pontosCoordParalelas;
    boolean isSelecionadoPontoParalela = false;
    static boolean pintarPontoParalela = false;
    static ArrayList<Ponto> pontosPintarParalela;
    static int expessuraLinha;
    static private Integer expessuraLinhaCircular;
    static private boolean isSelecionadoPontoParalelaCircular;
    static private ArrayList<Ponto> pontosPintarParalelaCircular;
    static private boolean pintarPontoParalelaCircular;
    static ArrayList<Ponto> pontosCoordParalelasCirculares;
    static public boolean geralLinePlot;
    private boolean isSelecionadoPontoGrupos;
    static private ArrayList<Ponto> pontosPintarGrupos;
    static private boolean pintarPontoGrupos;
    static private ArrayList<Ponto> pontosGrupos;
    static public ArrayList<Ponto> matrizPontos;
    static private boolean isSelecionadoPontoMatrizCorrelacao;
    static private ArrayList<Ponto> pontosPintarMatrizCorrelacao;
    static private boolean pintarPontoMatrizCorrelacao;

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

    }

    public TecnicasDispersao() {
        initComponents();
        setLocationRelativeTo(null);
//        this.setResizable(false);
        tamanhoOriginalCorrelacaoX = this.getFundoCorrelacao().getWidth();
        tamanhoOriginalCorrelacaoY = this.getFundoCorrelacao().getHeight();
        tamanhoOriginalParalelaX = this.getFundoParalelas().getWidth();
        tamanhoOriginalParalelaY = this.getFundoParalelas().getHeight();
        tamanhoPontoGeral = 2;
        sTamanhoPonto.setValue(tamanhoPontoGeral);
        tamanhoPontoGrupos = 2;
        sTamanhoPontoGrupos.setValue(tamanhoPontoGrupos);
        distanciaEixos = 350;
        sDistanciaEixos.setValue(distanciaEixos);
        expessuraLinha = 1;
        sExpessuraLinha.setValue(expessuraLinha);
        expessuraLinhaCircular = 1;
        sExpessuraLinhaCircular.setValue(expessuraLinhaCircular);
//        repaint();

    }

    public static synchronized TecnicasDispersao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TecnicasDispersao();
        } else {
            INSTANCE.repaint();
            System.out.println("Repaint getInstance");
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
        jPanel9 = new javax.swing.JPanel();
        fundoDispersaoGeral = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxEixoX = new javax.swing.JComboBox();
        comboBoxEixoY = new javax.swing.JComboBox();
        comboBoxEixoZ = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextGeral = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        sTamanhoPonto = new javax.swing.JSpinner();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        rotacionarXPositivo = new javax.swing.JButton();
        rotacionarXNegativo = new javax.swing.JButton();
        rotacionarYPositivo = new javax.swing.JButton();
        rotacionarYNegativo = new javax.swing.JButton();
        zoomIn = new javax.swing.JButton();
        zoomOut = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxGruposMatriz = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        comboCorrelacoes = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        padroesGrupo = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        fundoMatrizCorrelacao = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        fundoDispersaoGrupos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxEixoXGrupos = new javax.swing.JComboBox();
        comboBoxEixoYGrupos = new javax.swing.JComboBox();
        comboBoxEixoZGrupos = new javax.swing.JComboBox();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaGrupos = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaGruposSelecionados = new javax.swing.JList();
        adicionar = new javax.swing.JButton();
        deletar = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        areaTextGrupos = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        sTamanhoPontoGrupos = new javax.swing.JSpinner();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        rotacionarXPositivoGrupo = new javax.swing.JButton();
        rotacionarYNegativoGrupo = new javax.swing.JButton();
        rotacionarYPositivoGrupo = new javax.swing.JButton();
        rotacionarXNegativoGrupo = new javax.swing.JButton();
        zoomInGrupo = new javax.swing.JButton();
        zoomOutGrupo = new javax.swing.JButton();
        tabCorrelacao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fundoCorrelacao = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaBase = new javax.swing.JTable();
        tabParalelas = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        fundoParalelas = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        sDistanciaEixos = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        sExpessuraLinha = new javax.swing.JSpinner();
        jPanel12 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jScrollPane8 = new javax.swing.JScrollPane();
        textAreaParalelas = new javax.swing.JTextArea();
        fundoCirculares = new javax.swing.JPanel();
        fundoCircular = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        sExpessuraLinhaCircular = new javax.swing.JSpinner();
        jPanel16 = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        textAreaParalelasCirculares = new javax.swing.JTextArea();

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

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        fundoDispersaoGeral.setBackground(new java.awt.Color(255, 255, 255));
        fundoDispersaoGeral.setPreferredSize(new java.awt.Dimension(474, 474));
        fundoDispersaoGeral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fundoDispersaoGeralMouseClicked(evt);
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
            .addGap(0, 473, Short.MAX_VALUE)
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
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxEixoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxEixoY, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxEixoZ, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        areaTextGeral.setColumns(20);
        areaTextGeral.setRows(5);
        jScrollPane1.setViewportView(areaTextGeral);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Log", jPanel13);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Tamanho de Ponto:");

        sTamanhoPonto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sTamanhoPontoStateChanged(evt);
            }
        });

        jCheckBox1.setText("Selecionar Ponto");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sTamanhoPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(328, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(sTamanhoPonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aparência", jPanel8);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        rotacionarXPositivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_up.png"))); // NOI18N
        rotacionarXPositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotacionarXPositivoActionPerformed(evt);
            }
        });

        rotacionarXNegativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_down.png"))); // NOI18N
        rotacionarXNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotacionarXNegativoActionPerformed(evt);
            }
        });

        rotacionarYPositivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_right.png"))); // NOI18N
        rotacionarYPositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotacionarYPositivoActionPerformed(evt);
            }
        });

        rotacionarYNegativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_left.png"))); // NOI18N
        rotacionarYNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotacionarYNegativoActionPerformed(evt);
            }
        });

        zoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoom_in.png"))); // NOI18N
        zoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomInActionPerformed(evt);
            }
        });

        zoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoom_out.png"))); // NOI18N
        zoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(rotacionarYNegativo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rotacionarYPositivo))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(rotacionarXPositivo))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(rotacionarXNegativo)))
                .addGap(107, 107, 107)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(zoomIn)
                    .addComponent(zoomOut))
                .addGap(168, 168, 168))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rotacionarXPositivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rotacionarYNegativo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rotacionarYPositivo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rotacionarXNegativo)
                .addGap(30, 30, 30))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(zoomIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zoomOut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Controles 3D", jPanel10);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fundoDispersaoGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addGap(286, 286, 286))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fundoDispersaoGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("Gráfico Dispersão Geral", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupos"));

        jLabel8.setText("Grupos:");

        comboBoxGruposMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGruposMatrizActionPerformed(evt);
            }
        });

        jLabel12.setText("Coeficiente de Correlação:");

        comboCorrelacoes.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Kendall Tau", "Pearson", "Spearman"}));
        comboCorrelacoes.setSelectedIndex(1);
        comboCorrelacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCorrelacoesActionPerformed(evt);
            }
        });

        jLabel14.setText("Padrões no Grupo:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxGruposMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboCorrelacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(padroesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(padroesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(comboBoxGruposMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(comboCorrelacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addGap(3, 3, 3))
        );

        fundoMatrizCorrelacao.setBackground(new java.awt.Color(255, 255, 255));
        fundoMatrizCorrelacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fundoMatrizCorrelacaoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fundoMatrizCorrelacaoLayout = new javax.swing.GroupLayout(fundoMatrizCorrelacao);
        fundoMatrizCorrelacao.setLayout(fundoMatrizCorrelacaoLayout);
        fundoMatrizCorrelacaoLayout.setHorizontalGroup(
            fundoMatrizCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1051, Short.MAX_VALUE)
        );
        fundoMatrizCorrelacaoLayout.setVerticalGroup(
            fundoMatrizCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        jScrollPane7.setViewportView(fundoMatrizCorrelacao);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        tabs.addTab("Matriz de Correlação", jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        fundoDispersaoGrupos.setBackground(new java.awt.Color(255, 255, 255));
        fundoDispersaoGrupos.setPreferredSize(new java.awt.Dimension(474, 474));
        fundoDispersaoGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fundoDispersaoGruposMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fundoDispersaoGruposLayout = new javax.swing.GroupLayout(fundoDispersaoGrupos);
        fundoDispersaoGrupos.setLayout(fundoDispersaoGruposLayout);
        fundoDispersaoGruposLayout.setHorizontalGroup(
            fundoDispersaoGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fundoDispersaoGruposLayout.setVerticalGroup(
            fundoDispersaoGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        listaGrupos.setModel(listModelA);
        listaGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaGruposMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(listaGrupos);

        listaGruposSelecionados.setModel(listModelB);
        jScrollPane6.setViewportView(listaGruposSelecionados);

        adicionar.setText(">>");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        deletar.setText("<<");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adicionar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deletar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adicionar)
                .addGap(18, 18, 18)
                .addComponent(deletar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Seleção de Grupos", jPanel14);

        areaTextGrupos.setColumns(20);
        areaTextGrupos.setRows(5);
        jScrollPane10.setViewportView(areaTextGrupos);

        jTabbedPane2.addTab("Log", jScrollPane10);

        jLabel10.setText("Tamanho Ponto:");

        sTamanhoPontoGrupos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sTamanhoPontoGruposStateChanged(evt);
            }
        });

        jCheckBox4.setText("Selecionar Ponto");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox4)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sTamanhoPontoGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(sTamanhoPontoGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox4)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Aparência", jPanel7);

        rotacionarXPositivoGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_up.png"))); // NOI18N
        rotacionarXPositivoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotacionarXPositivoGrupoActionPerformed(evt);
            }
        });

        rotacionarYNegativoGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_left.png"))); // NOI18N
        rotacionarYNegativoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotacionarYNegativoGrupoActionPerformed(evt);
            }
        });

        rotacionarYPositivoGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_right.png"))); // NOI18N
        rotacionarYPositivoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotacionarYPositivoGrupoActionPerformed(evt);
            }
        });

        rotacionarXNegativoGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_down.png"))); // NOI18N
        rotacionarXNegativoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotacionarXNegativoGrupoActionPerformed(evt);
            }
        });

        zoomInGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoom_in.png"))); // NOI18N
        zoomInGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomInGrupoActionPerformed(evt);
            }
        });

        zoomOutGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoom_out.png"))); // NOI18N
        zoomOutGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomOutGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(rotacionarYNegativoGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rotacionarYPositivoGrupo))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(rotacionarXPositivoGrupo))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(rotacionarXNegativoGrupo)))
                .addGap(107, 107, 107)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(zoomInGrupo)
                    .addComponent(zoomOutGrupo))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(rotacionarXPositivoGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rotacionarYNegativoGrupo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rotacionarYPositivoGrupo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rotacionarXNegativoGrupo))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(zoomInGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(zoomOutGrupo)))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Controles 3D", jPanel17);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fundoDispersaoGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fundoDispersaoGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGap(0, 1034, Short.MAX_VALUE)
        );
        fundoCorrelacaoLayout.setVerticalGroup(
            fundoCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(fundoCorrelacao);

        jScrollPane3.setViewportView(tabelaBase);

        jTabbedPane4.addTab("Correlação Atributo por Atributo", jScrollPane3);

        javax.swing.GroupLayout tabCorrelacaoLayout = new javax.swing.GroupLayout(tabCorrelacao);
        tabCorrelacao.setLayout(tabCorrelacaoLayout);
        tabCorrelacaoLayout.setHorizontalGroup(
            tabCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCorrelacaoLayout.createSequentialGroup()
                .addGroup(tabCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabCorrelacaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE))
                    .addGroup(tabCorrelacaoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane4)))
                .addContainerGap())
        );
        tabCorrelacaoLayout.setVerticalGroup(
            tabCorrelacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCorrelacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tabs.addTab("Scatter Matrix", tabCorrelacao);

        tabParalelas.setBackground(new java.awt.Color(255, 255, 255));

        fundoParalelas.setBackground(new java.awt.Color(255, 255, 255));
        fundoParalelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fundoParalelasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fundoParalelasLayout = new javax.swing.GroupLayout(fundoParalelas);
        fundoParalelas.setLayout(fundoParalelasLayout);
        fundoParalelasLayout.setHorizontalGroup(
            fundoParalelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
        );
        fundoParalelasLayout.setVerticalGroup(
            fundoParalelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(fundoParalelas);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Distância entre Eixos:");

        sDistanciaEixos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sDistanciaEixosStateChanged(evt);
            }
        });

        jLabel11.setText("Tamanho da Linha:");

        sExpessuraLinha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sExpessuraLinhaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sDistanciaEixos, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(sExpessuraLinha))
                .addContainerGap(854, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(sDistanciaEixos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sExpessuraLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Aparência", jPanel6);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jRadioButton3.setText("Desenhar Pontos");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Selecionar Ponto");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        textAreaParalelas.setColumns(20);
        textAreaParalelas.setRows(5);
        jScrollPane8.setViewportView(textAreaParalelas);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addComponent(jCheckBox2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Seleção de Linhas", jPanel12);

        javax.swing.GroupLayout tabParalelasLayout = new javax.swing.GroupLayout(tabParalelas);
        tabParalelas.setLayout(tabParalelasLayout);
        tabParalelasLayout.setHorizontalGroup(
            tabParalelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabParalelasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabParalelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabParalelasLayout.setVerticalGroup(
            tabParalelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabParalelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        tabs.addTab("Coordenadas Paralelas", tabParalelas);

        fundoCircular.setBackground(new java.awt.Color(255, 255, 255));
        fundoCircular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fundoCircularMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fundoCircularLayout = new javax.swing.GroupLayout(fundoCircular);
        fundoCircular.setLayout(fundoCircularLayout);
        fundoCircularLayout.setHorizontalGroup(
            fundoCircularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fundoCircularLayout.setVerticalGroup(
            fundoCircularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Tamanho da Linha:");

        sExpessuraLinhaCircular.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sExpessuraLinhaCircularStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(23, 23, 23)
                .addComponent(sExpessuraLinhaCircular, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(874, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(sExpessuraLinhaCircular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Aparência", jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jRadioButton4.setText("Desenhar Pontos");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Selecionar Ponto");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        textAreaParalelasCirculares.setColumns(20);
        textAreaParalelasCirculares.setRows(5);
        jScrollPane9.setViewportView(textAreaParalelasCirculares);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane5.addTab("Seleção de Linhas", jPanel16);

        javax.swing.GroupLayout fundoCircularesLayout = new javax.swing.GroupLayout(fundoCirculares);
        fundoCirculares.setLayout(fundoCircularesLayout);
        fundoCircularesLayout.setHorizontalGroup(
            fundoCircularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundoCircular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane5)
        );
        fundoCircularesLayout.setVerticalGroup(
            fundoCircularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoCircularesLayout.createSequentialGroup()
                .addComponent(fundoCircular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane5)
                .addGap(9, 9, 9))
        );

        tabs.addTab("Coordenadas Paralelas Circulares", fundoCirculares);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //matrizDados = null;
    }//GEN-LAST:event_formWindowClosing

    private void tabsComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabsComponentResized
        //        dispersaoGeral();
        //        dispersaoGrupos();
        //        setQuadroPanels();
        ////        setQuadroPanelsOrientadaPixels();
        //        setCoordenadasParalelas();
        //        setRadviz();
//        setCirculares();
    }//GEN-LAST:event_tabsComponentResized

    private void tabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabsMouseClicked
        //        setQuadroPanels();
    }//GEN-LAST:event_tabsMouseClicked

    private void tabCorrelacaoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabCorrelacaoComponentResized
        //        setQuadroPanels();
        //        repaint();
    }//GEN-LAST:event_tabCorrelacaoComponentResized

    private void fundoCorrelacaoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_fundoCorrelacaoComponentResized
    }//GEN-LAST:event_fundoCorrelacaoComponentResized

    private void comboBoxEixoZGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoZGruposActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoZGruposActionPerformed

    private void comboBoxEixoYGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoYGruposActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoYGruposActionPerformed

    private void comboBoxEixoXGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoXGruposActionPerformed
        repaint();
    }//GEN-LAST:event_comboBoxEixoXGruposActionPerformed

    private void comboBoxGruposMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGruposMatrizActionPerformed
        setMatrizCorrelacao();
    }//GEN-LAST:event_comboBoxGruposMatrizActionPerformed

    private void comboBoxEixoZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoZActionPerformed
        repaint();
        System.out.println("comboBoxEixoZActionPerformed");
    }//GEN-LAST:event_comboBoxEixoZActionPerformed

    private void comboBoxEixoYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoYActionPerformed
        repaint();
        System.out.println("comboBoxEixoYActionPerformed");
    }//GEN-LAST:event_comboBoxEixoYActionPerformed

    private void comboBoxEixoXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEixoXActionPerformed
        repaint();
        System.out.println("comboBoxEixoXActionPerformed");
    }//GEN-LAST:event_comboBoxEixoXActionPerformed

    private void sTamanhoPontoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sTamanhoPontoStateChanged
        tamanhoPontoGeral = Integer.valueOf(sTamanhoPonto.getValue().toString());
        repaint();
        System.out.println("sTamanhoPontoStateChanged");
    }//GEN-LAST:event_sTamanhoPontoStateChanged

    private void listaGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaGruposMouseClicked
    }//GEN-LAST:event_listaGruposMouseClicked

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        if (!listaGrupos.isSelectionEmpty()) {
            swapAToB(listaGrupos.getSelectedIndices());
        }
    }//GEN-LAST:event_adicionarActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        if (!listaGruposSelecionados.isSelectionEmpty()) {
            swapBToA(listaGruposSelecionados.getSelectedIndices());
        }
    }//GEN-LAST:event_deletarActionPerformed

    private void sTamanhoPontoGruposStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sTamanhoPontoGruposStateChanged
        tamanhoPontoGrupos = Integer.valueOf(sTamanhoPontoGrupos.getValue().toString());
        repaint();
        System.out.println("sTamanhoPontoGruposStateChanged");
    }//GEN-LAST:event_sTamanhoPontoGruposStateChanged

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if (jRadioButton3.isSelected()) {
            desenharPontos = true;
        } else {
            desenharPontos = false;
        }
        repaint();
        System.out.println("jRadioButton3ActionPerformed");
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void sDistanciaEixosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sDistanciaEixosStateChanged
        distanciaEixos = Integer.valueOf(sDistanciaEixos.getValue().toString());
        setCoordenadasParalelas();
        repaint();
        System.out.println("        sDistanciaEixosStateChanged\n" + "");
    }//GEN-LAST:event_sDistanciaEixosStateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (!isSelecionadoPontoGeral) {
            isSelecionadoPontoGeral = true;
            pontosPintarGeral = new ArrayList<>();
        } else {
            isSelecionadoPontoGeral = false;
            pintarPontoGeral = false;
            pontosPintarGeral.clear();
            repaint();
            System.out.println("jCheckBox1ActionPerformed");
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void fundoDispersaoGeralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fundoDispersaoGeralMouseClicked
        if (isSelecionadoPontoGeral) {
            int x = evt.getX();
            int y = evt.getY();

            for (int i = 0; i < pontosGerais.size(); i++) {
//                System.out.println("x = "+x+" y = "+y+" xP = "+pontosGerais.get(i).getX()+" yP= "+pontosGerais.get(i).getY());
                if (isNear(x, y, pontosGerais.get(i), tamanhoPontoGeral)) {
                    pontosPintarGeral.add(pontosGerais.get(i));
                    pintarPontoGeral = true;
//                    System.out.println("entrou");
                }
            }
            repaint();
            System.out.println("fundoDispersaoGeralMouseClicked");
            setarTextArea(pontosPintarGeral, areaTextGeral);
        }
    }//GEN-LAST:event_fundoDispersaoGeralMouseClicked

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (!isSelecionadoPontoParalela) {
            isSelecionadoPontoParalela = true;
            pontosPintarParalela = new ArrayList<>();
        } else {
            isSelecionadoPontoParalela = false;
            pintarPontoParalela = false;
            pontosPintarParalela.clear();
            repaint();
            System.out.println("jCheckBox2ActionPerformed");
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void fundoParalelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fundoParalelasMouseClicked
        if (isSelecionadoPontoParalela) {
            int x = evt.getX();
            int y = evt.getY();
            pontosPintarParalela.clear();
            for (int i = 0; i < pontosCoordParalelas.get(0).getYs().length; i++) {
                for (int j = 0; j < pontosCoordParalelas.size(); j++) {
                    if (isNear(x, y, pontosCoordParalelas.get(j).getXs()[i], pontosCoordParalelas.get(j).getYs()[i], 4)) {
                        for (int k = 0; k < pontosCoordParalelas.size(); k++) {
                            if (pontosCoordParalelas.get(j).getYs()[i] == pontosCoordParalelas.get(k).getYs()[i] && pontosCoordParalelas.get(j).getXs()[i] == pontosCoordParalelas.get(k).getXs()[i]) {
                                if (!contain(pontosCoordParalelas.get(k), pontosPintarParalela)) {
                                    pontosPintarParalela.add(pontosCoordParalelas.get(k));
                                    pintarPontoParalela = true;
                                }
                            }
                        }
                    }
                }
            }
            repaint();
            System.out.println("fundoParalelasMouseClicked");
            setarTextArea(pontosPintarParalela, textAreaParalelas);
        }
    }//GEN-LAST:event_fundoParalelasMouseClicked

    private void sExpessuraLinhaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sExpessuraLinhaStateChanged
        expessuraLinha = Integer.valueOf(sExpessuraLinha.getValue().toString());
        repaint();
        System.out.println("sExpessuraLinhaStateChanged");
    }//GEN-LAST:event_sExpessuraLinhaStateChanged

    private void sExpessuraLinhaCircularStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sExpessuraLinhaCircularStateChanged
        expessuraLinhaCircular = Integer.valueOf(sExpessuraLinhaCircular.getValue().toString());
        repaint();
        System.out.println("sExpessuraLinhaCircularStateChanged");
    }//GEN-LAST:event_sExpessuraLinhaCircularStateChanged

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        if (jRadioButton4.isSelected()) {
            desenharPontosCirculares = true;
        } else {
            desenharPontosCirculares = false;
        }
        repaint();
        System.out.println("jRadioButton4ActionPerformed");
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if (!isSelecionadoPontoParalelaCircular) {
            isSelecionadoPontoParalelaCircular = true;
            pontosPintarParalelaCircular = new ArrayList<>();
        } else {
            isSelecionadoPontoParalelaCircular = false;
            pintarPontoParalelaCircular = false;
            pontosPintarParalelaCircular.clear();
            repaint();
            System.out.println("jCheckBox3ActionPerformed");
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void fundoCircularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fundoCircularMouseClicked
        if (isSelecionadoPontoParalelaCircular) {
            int x = evt.getX();
            int y = evt.getY();
            pontosPintarParalelaCircular.clear();
            for (int i = 0; i < pontosCoordParalelasCirculares.get(0).getYs().length; i++) {
                for (int j = 0; j < pontosCoordParalelasCirculares.size(); j++) {
                    if (isNear(x, y, pontosCoordParalelasCirculares.get(j).getXs()[i], pontosCoordParalelasCirculares.get(j).getYs()[i], 4)) {
                        for (int k = 0; k < pontosCoordParalelasCirculares.size(); k++) {
                            if (pontosCoordParalelasCirculares.get(j).getYs()[i] == pontosCoordParalelasCirculares.get(k).getYs()[i] && pontosCoordParalelasCirculares.get(j).getXs()[i] == pontosCoordParalelasCirculares.get(k).getXs()[i]) {
                                if (!contain(pontosCoordParalelasCirculares.get(k), pontosPintarParalelaCircular)) {
                                    pontosPintarParalelaCircular.add(pontosCoordParalelasCirculares.get(k));
                                    pintarPontoParalelaCircular = true;

                                }
                            }
                        }
                    }
                }
            }
            repaint();
            System.out.println("fundoCircularMouseClicked");
            setarTextArea(pontosPintarParalelaCircular, textAreaParalelasCirculares);
        }
    }//GEN-LAST:event_fundoCircularMouseClicked

    private void rotacionarXPositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotacionarXPositivoActionPerformed
        GDG.girarX(10);
    }//GEN-LAST:event_rotacionarXPositivoActionPerformed

    private void rotacionarXNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotacionarXNegativoActionPerformed
        GDG.girarX(-10);
    }//GEN-LAST:event_rotacionarXNegativoActionPerformed

    private void rotacionarYPositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotacionarYPositivoActionPerformed
        GDG.girarY(10);
    }//GEN-LAST:event_rotacionarYPositivoActionPerformed

    private void rotacionarYNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotacionarYNegativoActionPerformed
        GDG.girarY(-10);
    }//GEN-LAST:event_rotacionarYNegativoActionPerformed

    private void zoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomInActionPerformed
        GDG.setDistancia(1);
    }//GEN-LAST:event_zoomInActionPerformed

    private void zoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomOutActionPerformed
        GDG.setDistancia(-1);
    }//GEN-LAST:event_zoomOutActionPerformed

    private void comboCorrelacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCorrelacoesActionPerformed
        setMatrizCorrelacao();
    }//GEN-LAST:event_comboCorrelacoesActionPerformed

    private void rotacionarXPositivoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotacionarXPositivoGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotacionarXPositivoGrupoActionPerformed

    private void rotacionarYNegativoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotacionarYNegativoGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotacionarYNegativoGrupoActionPerformed

    private void rotacionarYPositivoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotacionarYPositivoGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotacionarYPositivoGrupoActionPerformed

    private void rotacionarXNegativoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotacionarXNegativoGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotacionarXNegativoGrupoActionPerformed

    private void zoomInGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomInGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zoomInGrupoActionPerformed

    private void zoomOutGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomOutGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zoomOutGrupoActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        if (!isSelecionadoPontoGrupos) {
            isSelecionadoPontoGrupos = true;
            pontosPintarGrupos = new ArrayList<>();
        } else {
            isSelecionadoPontoGrupos = false;
            pintarPontoGrupos = false;
            pontosPintarGrupos.clear();
            repaint();
            System.out.println("jCheckBox1ActionPerformed");
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void fundoDispersaoGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fundoDispersaoGruposMouseClicked
        if (isSelecionadoPontoGrupos) {
            int x = evt.getX();
            int y = evt.getY();

            for (int i = 0; i < pontosGrupos.size(); i++) {
//                System.out.println("x = "+x+" y = "+y+" xP = "+pontosGerais.get(i).getX()+" yP= "+pontosGerais.get(i).getY());
                if (isNear(x, y, pontosGrupos.get(i), tamanhoPontoGrupos)) {
                    pontosPintarGrupos.add(pontosGrupos.get(i));
                    pintarPontoGrupos = true;
//                    System.out.println("entrou");
                }
            }
            repaint();
            System.out.println("fundoDispersaoGeralMouseClicked");
            setarTextArea(pontosPintarGrupos, areaTextGrupos);
        }
    }//GEN-LAST:event_fundoDispersaoGruposMouseClicked

    private void fundoMatrizCorrelacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fundoMatrizCorrelacaoMouseClicked
    }//GEN-LAST:event_fundoMatrizCorrelacaoMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JTextArea areaTextGeral;
    private javax.swing.JTextArea areaTextGrupos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private static javax.swing.JComboBox comboBoxEixoX;
    private static javax.swing.JComboBox comboBoxEixoXGrupos;
    private static javax.swing.JComboBox comboBoxEixoY;
    private static javax.swing.JComboBox comboBoxEixoYGrupos;
    private static javax.swing.JComboBox comboBoxEixoZ;
    private static javax.swing.JComboBox comboBoxEixoZGrupos;
    private static javax.swing.JComboBox comboBoxGruposMatriz;
    private javax.swing.JComboBox comboCorrelacoes;
    private javax.swing.JButton deletar;
    private static javax.swing.JPanel fundoCircular;
    private static javax.swing.JPanel fundoCirculares;
    private static javax.swing.JPanel fundoCorrelacao;
    private static javax.swing.JPanel fundoDispersaoGeral;
    private static javax.swing.JPanel fundoDispersaoGrupos;
    private static javax.swing.JPanel fundoMatrizCorrelacao;
    private static javax.swing.JPanel fundoParalelas;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private static javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JList listaGrupos;
    private javax.swing.JList listaGruposSelecionados;
    private javax.swing.JLabel padroesGrupo;
    private javax.swing.JButton rotacionarXNegativo;
    private javax.swing.JButton rotacionarXNegativoGrupo;
    private javax.swing.JButton rotacionarXPositivo;
    private javax.swing.JButton rotacionarXPositivoGrupo;
    private javax.swing.JButton rotacionarYNegativo;
    private javax.swing.JButton rotacionarYNegativoGrupo;
    private javax.swing.JButton rotacionarYPositivo;
    private javax.swing.JButton rotacionarYPositivoGrupo;
    private javax.swing.JSpinner sDistanciaEixos;
    private static javax.swing.JSpinner sExpessuraLinha;
    private static javax.swing.JSpinner sExpessuraLinhaCircular;
    private javax.swing.JSpinner sTamanhoPonto;
    private javax.swing.JSpinner sTamanhoPontoGrupos;
    private javax.swing.JPanel tabCorrelacao;
    private javax.swing.JPanel tabParalelas;
    private static javax.swing.JTable tabelaBase;
    private static javax.swing.JTabbedPane tabs;
    private javax.swing.JTextArea textAreaParalelas;
    private javax.swing.JTextArea textAreaParalelasCirculares;
    private javax.swing.JButton zoomIn;
    private javax.swing.JButton zoomInGrupo;
    private javax.swing.JButton zoomOut;
    private javax.swing.JButton zoomOutGrupo;
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

    private static void dispersaoGeral() {
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
                    switch (comboCorrelacoes.getSelectedIndex()) {
                        case 1:
                            CorrelacaoKendallTau ckt = new CorrelacaoKendallTau(grupos);
                            ckt.distancia();
                            MC.setMatrizGrupos(ckt.getMatrizDistancias());
                            break;
                        case 2:
                            CorrelacaoPearson cor = new CorrelacaoPearson(grupos);
                            cor.distanciaGrupos(grupos);
                            MC.setMatrizGrupos(cor.getMatrizDistancias());
                            break;
                        case 3:
                            CorrelacaoSpearman cs = new CorrelacaoSpearman(grupos);
                            cs.distancia();
                            MC.setMatrizGrupos(cs.getMatrizDistancias());
                            break;
                        default:
                            break;
                    }
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
        padroesGrupo.setText(numElemento + "");
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


        comboBoxEixoXGrupos.addItem("");
        comboBoxEixoYGrupos.addItem("");
        comboBoxEixoZGrupos.addItem("");


        for (int i = 0; i < matrizDados.getAtributos().size() - 1; i++) {
            comboBoxEixoXGrupos.addItem(matrizDados.getAtributos().get(i));
            comboBoxEixoYGrupos.addItem(matrizDados.getAtributos().get(i));
            comboBoxEixoZGrupos.addItem(matrizDados.getAtributos().get(i));

        }


        comboBoxEixoXGrupos.setSelectedIndex(1);
        comboBoxEixoYGrupos.setSelectedIndex(2);


        // matriz
        comboBoxGruposMatriz.removeAllItems();
        comboBoxGruposMatriz.addItem("");

        for (int i = 0; i < getQntGrupos(); i++) {
            comboBoxGruposMatriz.addItem(i + 1);
        }
        comboBoxGruposMatriz.setSelectedIndex(0);

//        logDispersaoGrupos.setText("");
        setSetou(true);
    }

    private static void dispersaoGrupos() {
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

    public static JComboBox getComboBoxGruposMatriz() {
        return comboBoxGruposMatriz;
    }

    public static void setComboBoxGruposMatriz(JComboBox comboBoxGruposMatriz) {
        TecnicasDispersao.comboBoxGruposMatriz = comboBoxGruposMatriz;
    }

    public static int getTamanhoPontoGrupos() {
        return tamanhoPontoGrupos;
    }

    public static void setQuadroPanels() {

        if (matrizDados != null) {
//            fundoCorrelacao.setSize(tamanhoOriginalCorrelacaoX, tamanhoOriginalCorrelacaoY);
//            fundoCorrelacao.setPreferredSize(new Dimension(tamanhoOriginalCorrelacaoX, tamanhoOriginalCorrelacaoY));
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

    public static void setCoordenadasParalelas() {
        if (matrizDados != null) {
            if (CP == null) {
                CP = new CoordenadasParalelas();
            }
//            System.out.println("tamanhoX = " + tamanhoOriginalParalelaX);
//            System.out.println("tamanhoX = " + tamanhoOriginalParalelaY);
            fundoParalelas.setSize(tamanhoOriginalParalelaX, tamanhoOriginalParalelaY);
            fundoParalelas.setPreferredSize(new Dimension(tamanhoOriginalParalelaX, tamanhoOriginalParalelaY));
            CP.setSize(tamanhoOriginalParalelaX, tamanhoOriginalParalelaY);
            int numEixos = matrizDados.getDataSet().get(0).getAtributos().size();
            int inicioX = 50;
            int distanciaEixo = getDistanciaEixos();
            fundoParalelas.setSize((distanciaEixo * (numEixos) + inicioX * 2) - distanciaEixo, fundoParalelas.getHeight());
            fundoParalelas.setPreferredSize(new Dimension((distanciaEixo * (numEixos) + inicioX * 2) - distanciaEixo, fundoParalelas.getHeight()));
            CP.setSize(fundoParalelas.getWidth(), fundoParalelas.getHeight());
            fundoParalelas.add(CP);
        }
    }

    public static JPanel getFundoCorrelacao() {
        return fundoCorrelacao;
    }

    private static void setCorrelacoes() {
        CorrelacaoPearson cor = new CorrelacaoPearson(matrizDados);
        cor.trasnpoe(matrizDados);
        double[][] matrizCorrelacaoTransposta = cor.getMatrizDistancias();
//        for (int i = 0; i < matrizCorrelacaoTransposta.length; i++) {
//            for (int j = 0; j < matrizCorrelacaoTransposta[0].length; j++) {
////                System.out.print(matrizCorrelacaoTransposta[i][j] + " ");
//            }
//            System.out.println();
//        }
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

    public static JPanel getFundoParalelas() {
        return fundoParalelas;
    }

    private static void setCirculares() {
        if (CPC == null) {
            CPC = new CoordenadasParalelasCirculares();
        }
        CPC.setSize(fundoCircular.getWidth(), fundoCircular.getHeight());
        fundoCircular.add(CPC);
    }

    public static JPanel getFundoCirculares() {
        return fundoCircular;
    }

    public void inicia() {
        dispersaoGeral();
        iniciaListaGrupos();
        dispersaoGrupos();
        setQuadroPanels();
//        setQuadroPanelsOrientadaPixels();
        setCoordenadasParalelas();
//        setRadviz();
        setCirculares();
//        setLinePlot();
    }

    public static int getTamanhoPontoGeral() {
        return tamanhoPontoGeral;
    }

    public static void setTamanhoPontoGeral(int tamanhoPontoGeral) {
        TecnicasDispersao.tamanhoPontoGeral = tamanhoPontoGeral;
    }

    private void iniciaListaGrupos() {
        vetorGrupos = new ArrayList<>();
        String[] nomes = new String[qntGrupos];
        for (int i = 0; i < qntGrupos; i++) {
            nomes[i] = "Cluster_" + (i + 1);
        }
        DefaultListModel dl = new DefaultListModel();
        for (int i = 0; i < nomes.length; i++) {
            dl.addElement(nomes[i]);
            //System.out.println(attributes[i]);
        }
        setListModelA(dl);
        setListModelB(new DefaultListModel());
    }

    private void swapAToB(int[] selectedIndices) {
        if (selectedIndices != null) {
            Object[] aux = new Object[selectedIndices.length];
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                aux[i] = listModelA.remove(selectedIndices[i]);
            }
            for (int i = 0; i < aux.length; i++) {
                listModelB.addElement(aux[i]);
            }
            for (int i = 0; i < listModelB.size(); i++) {
                vetorGrupos.add(listModelB.get(i).toString());
            }
            repaint();
            System.out.println("swapAToB");
        }
    }

    private void swapBToA(int[] selectedIndices) {
        if (selectedIndices != null) {
            Object[] aux = new Object[selectedIndices.length];
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                aux[i] = listModelB.remove(selectedIndices[i]);
            }
            for (int i = 0; i < aux.length; i++) {
                listModelA.addElement(aux[i]);
            }
            vetorGrupos.clear();
            for (int i = 0; i < listModelB.size(); i++) {
                vetorGrupos.add(listModelB.get(i).toString());
            }
            repaint();
            System.out.println("swapBToA");
        }
    }

    public void setListModelA(DefaultListModel listModel) {
        this.listModelA.clear();
        for (int i = 0; i < listModel.size(); i++) {
            this.listModelA.addElement(listModel.get(i));
        }
    }

    /**
     * sets the list of selected columns
     *
     * @param listModel
     */
    public void setListModelB(DefaultListModel listModel) {
        this.listModelB.clear();
        for (int i = 0; i < listModel.size(); i++) {
            this.listModelB.addElement(listModel.get(i));
        }
    }

    public static ArrayList<String> getVetorGrupos() {
        return vetorGrupos;
    }

    public static boolean isDesenharPontos() {
        return desenharPontos;
    }

    public static int getDistanciaEixos() {
        return distanciaEixos;
    }

    public static ArrayList<Ponto> getPontosGerais() {
        return pontosGerais;
    }

    public static void setPontosGerais(ArrayList<Ponto> _pontosGerais) {
        pontosGerais = _pontosGerais;
    }

    private boolean isNear(int x, int y, Ponto p, int tamanhoPonto) {

        if (Math.abs(x - p.getX()) <= tamanhoPonto && Math.abs(y - p.getY()) <= tamanhoPonto) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Ponto> getPontosPintar() {
        return pontosPintarGeral;
    }

    public static boolean isPintarPonto() {
        return pintarPontoGeral;
    }

    private void setarTextArea(ArrayList<Ponto> pontosPintar, JTextArea areaTextGeral) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < pontosPintar.size(); i++) {
            buffer.append("Ponto Selecionado = " + pontosPintar.get(i).getNome() + "\n");
            buffer.append("\tAtributos: ");
            int index = Integer.valueOf(pontosPintar.get(i).getNome()) - 1;
            for (int j = 0; j < matrizDados.getDataSet().get(index).getAtributos().size(); j++) {
                buffer.append(matrizDados.getDataSet().get(index).getAtributos().get(j) + " ");
            }
            buffer.append("\n");
        }
        areaTextGeral.setText(buffer.toString());
    }

    private boolean isNear(int x, int y, int x1, int y1, int tamanhoPonto) {

        if (Math.abs(y - y1) <= tamanhoPonto && Math.abs(x - x1) <= tamanhoPonto) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Ponto> getPontosPintarGeral() {
        return pontosPintarGeral;
    }

    public static void setPontosPintarGeral(ArrayList<Ponto> pontosPintarGeral) {
        TecnicasDispersao.pontosPintarGeral = pontosPintarGeral;
    }

    public static ArrayList<Ponto> getPontosCoordParalelas() {
        return pontosCoordParalelas;
    }

    public static void setPontosCoordParalelas(ArrayList<Ponto> pontosCoordParalelas) {
        TecnicasDispersao.pontosCoordParalelas = pontosCoordParalelas;
    }

    public boolean isIsSelecionadoPontoParalela() {
        return isSelecionadoPontoParalela;
    }

    public void setIsSelecionadoPontoParalela(boolean isSelecionadoPontoParalela) {
        this.isSelecionadoPontoParalela = isSelecionadoPontoParalela;
    }

    public static boolean isPintarPontoParalela() {
        return pintarPontoParalela;
    }

    public static void setPintarPontoParalela(boolean pintarPontoParalela) {
        TecnicasDispersao.pintarPontoParalela = pintarPontoParalela;
    }

    public static ArrayList<Ponto> getPontosPintarParalela() {
        return pontosPintarParalela;
    }

    public static void setPontosPintarParalela(ArrayList<Ponto> pontosPintarParalela) {
        TecnicasDispersao.pontosPintarParalela = pontosPintarParalela;
    }

    public static int getExpessuraLinha() {
        return expessuraLinha;
    }

    public static int getExpessuraLinhaCircular() {
        return expessuraLinhaCircular;
    }

    public static boolean isDesenharPontosCirculares() {
        return desenharPontosCirculares;
    }

    public static ArrayList<Ponto> getPontosPintarParalelaCircular() {
        return pontosPintarParalelaCircular;
    }

    public static boolean isPintarPontoParalelaCircular() {
        return pintarPontoParalelaCircular;
    }

    public static ArrayList<Ponto> getPontosCoordParalelasCirculares() {
        return pontosCoordParalelasCirculares;
    }

    public static void setPontosCoordParalelasCirculares(ArrayList<Ponto> pontosCoordParalelasCirculares) {
        TecnicasDispersao.pontosCoordParalelasCirculares = pontosCoordParalelasCirculares;
    }

    private boolean contain(Ponto p, ArrayList<Ponto> pontos) {
        if (pontos != null) {
            if (!pontos.isEmpty()) {
                for (int i = 0; i < pontos.size(); i++) {
                    if (p.getNome().equals(pontos.get(i).getNome())) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        }
        return false;
    }

    private void setMatrizCorrelacao() {
        if (setou) {
            matrizCorrelacao();
            grupoEscolhidoMatriz = comboBoxGruposMatriz.getSelectedIndex();
            if (grupoEscolhidoMatriz != 0) {
                Base aux = getMatrizDadosCorrelacao();
                if (aux != null) {
                    setMatrizGruposCorrelacao(aux);
                    MC.setRepinta(false);
                    repaint();
                    System.out.println("repaint aux!=null matrizcorrelacao");
                } else {
                    MC.setRepinta(true);
                    repaint();
                    System.out.println("repaint aux==null matrizcorrelacao");
                }
            }
        } else {
            setMatrizGruposCorrelacao(null);
        }
    }

//    private void setLinePlot() {
//        if (LP == null) {
//            LP = new LinePlot();
//        }
//        LP.setSize(fundoLinePlot.getWidth(), fundoLinePlot.getHeight());
//        fundoLinePlot.add(LP);
//    }
//
//    public static JPanel getFundoLinePlot() {
//        return fundoLinePlot;
//    }
    static boolean isGeralLinePlot() {
        return geralLinePlot;
    }

    public static ArrayList<Ponto> getPontosPintarGrupos() {
        return pontosPintarGrupos;
    }

    public static boolean isPintarPontoGrupos() {
        return pintarPontoGrupos;
    }

    public static ArrayList<Ponto> getPontosGrupos() {
        return pontosGrupos;
    }

    public static void setPontosGrupos(ArrayList<Ponto> pontosGrupos) {
        TecnicasDispersao.pontosGrupos = pontosGrupos;
    }

    public static ArrayList<Ponto> getMatrizPontos() {
        return matrizPontos;
    }

    public static void setMatrizPontos(ArrayList<Ponto> matrizPontos) {
        TecnicasDispersao.matrizPontos = matrizPontos;
    }

    public static ArrayList<Ponto> getPontosPintarMatrizCorrelacao() {
        return pontosPintarMatrizCorrelacao;
    }

    public static void setPontosPintarMatrizCorrelacao(ArrayList<Ponto> pontosPintarMatrizCorrelacao) {
        TecnicasDispersao.pontosPintarMatrizCorrelacao = pontosPintarMatrizCorrelacao;
    }

    public static boolean isPintarPontoMatrizCorrelacao() {
        return pintarPontoMatrizCorrelacao;
    }

    public static void setPintarPontoMatrizCorrelacao(boolean pintarPontoMatrizCorrelacao) {
        TecnicasDispersao.pintarPontoMatrizCorrelacao = pintarPontoMatrizCorrelacao;
    }
}
