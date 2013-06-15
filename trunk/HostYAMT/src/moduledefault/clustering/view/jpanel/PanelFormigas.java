/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.view.jpanel;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import moduledefault.clustering.aco.ACOClustering;
import moduledefault.clustering.kohonen.visualization.FrameVisualization;
import moduledefault.clustering.recuperacaogrupos.LigacaoCompleta;
import moduledefault.clustering.recuperacaogrupos.LigacaoMedia;
import moduledefault.clustering.recuperacaogrupos.LigacaoSimples;
import moduledefault.clustering.recuperacaogrupos.MFaino;
import moduledefault.clustering.recuperacaogrupos.Ward;
import moduledefault.clustering.uteis.MatrizDados;
import moduledefault.clustering.uteis.Operações_Mat;
import moduledefault.clustering.uteis.Índices;
import moduledefault.clustering.view.frames.JFrameFormigas;
import moduledefault.clustering.visualization.ClusteringFrameVisualization;
import moduledefault.clustering.visualization.GraficoDispersaoGeral;
import view.jpanel.JPanelClustering;

/**
 *
 * @author Mateus
 */
public final class PanelFormigas extends javax.swing.JPanel {

    /**
     * Creates new form panelFormigas
     */
    public PanelFormigas(double[][] base, String[] grupos, JFrameFormigas j) {
        initComponents();
        this.matrizDados = base;
        teste = new MatrizDados();
        this.grupos = grupos;
        startMatrizDados();
        Operações_Mat mat = new Operações_Mat();
        mat.Padronização(teste);
        listaObjetos = new ArrayList<ACOClustering>();
        listaGrupos = new ArrayList<int[][]>();
        listaText = new ArrayList<>();
        frameFormigas = j;
        System.out.println("antes = " + frameFormigas.getSigma());
        this.objetoAtual = 0;
        for (int i = 0; i < teste.getLinhas(); i++) {
            for (int w = 0; w < teste.getColunas(); w++) {
                System.out.print(" " + teste.getMatriz_dados()[i][w]);
            }
            System.out.println();
        }
    }
    /**
     *
     */
    ArrayList<int[][]> listaGrupos;
    ArrayList<ACOClustering> listaObjetos;
    double melhorconfusao = Integer.MIN_VALUE;
    int numpad = 0;
    int[][] mconfusao;
    int numgrupo;
    int[][] melhormconfusao;
    int teste_inicia = 0;
    int[][] melhormatriz;
    float vtotal = 0, idunn = Integer.MAX_VALUE, ffinal = 0;
    float r = 0;
    int melhornumpad = 0;
    int melhornumgrupo = 0;
    long tempo3;
    int[][] melhormatrizfinal;
    int[][] melhormconfusaofinal;
    int[][] matriz_padrao = null;
    JPanelClustering interfaceAnt;
    ACOClustering operar = null;
    StringBuffer guarda;
    long tempoinicial_rec;
    long tempofinal_rec;
    Índices indice;
    LigacaoCompleta ligaC;
    LigacaoSimples ligaS;
    LigacaoMedia ligaM;
    Ward ward;
    MFaino achagrupos;
    double[][] matrizDados;
    String[] grupos;
    static MatrizDados teste;
    int teste_distancia = 0;
    JFrameFormigas frameFormigas;
    StringBuffer buffer;
    ArrayList<StringBuffer> listaText;
    int teste_recuperação = 0;
    int objetoAtual;
    static int sleep;
    int numeroExecucoes = 0;
    private static GraficoDispersaoGeral GDG;

    synchronized public ACOClustering getOperar() {
        return operar;
    }

    synchronized public void setOperar(ACOClustering operar) {
        this.operar = operar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Frame_Teste = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        Panel_medidas1 = new javax.swing.JPanel();
        Euclidiana1 = new javax.swing.JRadioButton();
        Cosseno1 = new javax.swing.JRadioButton();
        Mahalanobis1 = new javax.swing.JRadioButton();
        Correlacao1 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        iteracoes = new javax.swing.JTextField();
        Executar_teste = new javax.swing.JButton();
        fMetodos = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jCompleta = new javax.swing.JRadioButton();
        jMedia = new javax.swing.JRadioButton();
        jSimples = new javax.swing.JRadioButton();
        jWard = new javax.swing.JRadioButton();
        jMeans = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Panel_recuperacao = new javax.swing.JPanel();
        Simples = new javax.swing.JRadioButton();
        Media = new javax.swing.JRadioButton();
        Completa = new javax.swing.JRadioButton();
        Ward = new javax.swing.JRadioButton();
        Faino = new javax.swing.JRadioButton();
        Panel_medidas = new javax.swing.JPanel();
        Euclidiana = new javax.swing.JRadioButton();
        Cosseno = new javax.swing.JRadioButton();
        Mahalanobis = new javax.swing.JRadioButton();
        Correlacao = new javax.swing.JRadioButton();
        Executar_formigas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        listResultados = new java.awt.List();
        buttonVisualizacao = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        fundoSimulacao = new javax.swing.JPanel();
        sliderVelocidade = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        statusProgresso = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        labelProgresso = new javax.swing.JLabel();

        Panel_medidas1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Medidas"));

        Euclidiana1.setSelected(true);
        Euclidiana1.setText("Distância Euclidiana");

        Cosseno1.setText("Similiridade de Cosseno");

        Mahalanobis1.setText("Mahalanobis");

        Correlacao1.setText("Correlação");

        javax.swing.GroupLayout Panel_medidas1Layout = new javax.swing.GroupLayout(Panel_medidas1);
        Panel_medidas1.setLayout(Panel_medidas1Layout);
        Panel_medidas1Layout.setHorizontalGroup(
            Panel_medidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_medidas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_medidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cosseno1)
                    .addComponent(Euclidiana1)
                    .addComponent(Mahalanobis1)
                    .addComponent(Correlacao1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_medidas1Layout.setVerticalGroup(
            Panel_medidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_medidas1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Euclidiana1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cosseno1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Mahalanobis1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Correlacao1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel13.setText("Número de Iterações:");

        iteracoes.setText("0");

        Executar_teste.setText("OK");
        Executar_teste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Executar_testeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(iteracoes, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Executar_teste, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel_medidas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_medidas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(iteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Executar_teste))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Frame_TesteLayout = new javax.swing.GroupLayout(Frame_Teste.getContentPane());
        Frame_Teste.getContentPane().setLayout(Frame_TesteLayout);
        Frame_TesteLayout.setHorizontalGroup(
            Frame_TesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Frame_TesteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Frame_TesteLayout.setVerticalGroup(
            Frame_TesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Frame_TesteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jCompleta.setText("Ligação Completa");
        jCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCompletaActionPerformed(evt);
            }
        });

        jMedia.setText("Ligação Media");

        jSimples.setText("Ligação Simples");

        jWard.setText("Ward");

        jMeans.setText("Kmeans");

        jButton2.setText("Executar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCompleta)
                    .addComponent(jMedia)
                    .addComponent(jSimples)
                    .addComponent(jWard)
                    .addComponent(jMeans)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton2)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCompleta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jMedia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSimples)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jWard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jMeans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fMetodosLayout = new javax.swing.GroupLayout(fMetodos.getContentPane());
        fMetodos.getContentPane().setLayout(fMetodosLayout);
        fMetodosLayout.setHorizontalGroup(
            fMetodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fMetodosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fMetodosLayout.setVerticalGroup(
            fMetodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fMetodosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setFocusCycleRoot(true);
        setPreferredSize(new java.awt.Dimension(718, 458));

        Panel_recuperacao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Recuperação de Grupos"));

        Simples.setText("Ligação Simples");
        Simples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimplesActionPerformed(evt);
            }
        });

        Media.setText("Ligação Média");
        Media.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediaActionPerformed(evt);
            }
        });

        Completa.setText("Ligação Completa");
        Completa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompletaActionPerformed(evt);
            }
        });

        Ward.setText("Método Ward");
        Ward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WardActionPerformed(evt);
            }
        });

        Faino.setText("Recuperação M_Faino");
        Faino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FainoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_recuperacaoLayout = new javax.swing.GroupLayout(Panel_recuperacao);
        Panel_recuperacao.setLayout(Panel_recuperacaoLayout);
        Panel_recuperacaoLayout.setHorizontalGroup(
            Panel_recuperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_recuperacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_recuperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Simples)
                    .addComponent(Media)
                    .addComponent(Completa)
                    .addComponent(Ward)
                    .addComponent(Faino))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_recuperacaoLayout.setVerticalGroup(
            Panel_recuperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_recuperacaoLayout.createSequentialGroup()
                .addComponent(Simples)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Media)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Completa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ward)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Faino))
        );

        Panel_medidas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Medidas"));

        Euclidiana.setText("Distância Euclidiana");
        Euclidiana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EuclidianaActionPerformed(evt);
            }
        });

        Cosseno.setText("Similiridade de Cosseno");
        Cosseno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CossenoActionPerformed(evt);
            }
        });

        Mahalanobis.setText("Mahalanobis");
        Mahalanobis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MahalanobisActionPerformed(evt);
            }
        });

        Correlacao.setText("Correlação");
        Correlacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorrelacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_medidasLayout = new javax.swing.GroupLayout(Panel_medidas);
        Panel_medidas.setLayout(Panel_medidasLayout);
        Panel_medidasLayout.setHorizontalGroup(
            Panel_medidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_medidasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_medidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cosseno)
                    .addComponent(Euclidiana)
                    .addComponent(Mahalanobis)
                    .addComponent(Correlacao)))
        );
        Panel_medidasLayout.setVerticalGroup(
            Panel_medidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_medidasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Euclidiana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cosseno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Mahalanobis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Correlacao))
        );

        Executar_formigas.setText("Executar Formigas");
        Executar_formigas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Executar_formigasActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Resultados")));

        listResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listResultadosMouseClicked(evt);
            }
        });
        listResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listResultadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(listResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        buttonVisualizacao.setText("Visualização");
        buttonVisualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVisualizacaoActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTabbedPane1.addTab("Resultado", jScrollPane1);

        fundoSimulacao.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                fundoSimulacaoComponentResized(evt);
            }
        });

        sliderVelocidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderVelocidadeStateChanged(evt);
            }
        });

        jLabel1.setText("Velocidade:");

        jLabel2.setText("Progresso:");

        javax.swing.GroupLayout fundoSimulacaoLayout = new javax.swing.GroupLayout(fundoSimulacao);
        fundoSimulacao.setLayout(fundoSimulacaoLayout);
        fundoSimulacaoLayout.setHorizontalGroup(
            fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoSimulacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fundoSimulacaoLayout.createSequentialGroup()
                        .addComponent(statusProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(sliderVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        fundoSimulacaoLayout.setVerticalGroup(
            fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoSimulacaoLayout.createSequentialGroup()
                .addContainerGap(352, Short.MAX_VALUE)
                .addGroup(fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoSimulacaoLayout.createSequentialGroup()
                        .addGroup(fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sliderVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelProgresso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Simulação", fundoSimulacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel_recuperacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_medidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Executar_formigas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonVisualizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Panel_medidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Panel_recuperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Executar_formigas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonVisualizacao)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Executar_formigasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Executar_formigasActionPerformed
        this.Executar_formigas.setEnabled(false);
        if (!Euclidiana.isSelected() && !Correlacao.isSelected() && !Cosseno.isSelected() && !Mahalanobis.isSelected()) {
            JOptionPane.showMessageDialog(null, "Selecione uma Medida", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
            return;
        }

        //1 - EUCLIDIANA 2 - Cosseno 3 - Correlação 4 - Mahalanobis PADRAO EUCLIDIANA
        if (Euclidiana.isSelected()) {
            teste_distancia = 1;
        } else {
            if (Cosseno.isSelected()) {
                teste_distancia = 2;
            } else {
                if (Correlacao.isSelected()) {
                    teste_distancia = 3;
                } else {
                    if (Mahalanobis.isSelected()) {
                        teste_distancia = 4;
                    }
                }
            }
        }

        if (!Simples.isSelected()
                && !Completa.isSelected() && !Media.isSelected() && !Ward.isSelected() && !Faino.isSelected()) {
            JOptionPane.showMessageDialog(null, "Selecione um método", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
            return;
        }

        /*
         * Teste recuperação 1 - Ligação Simples 2 - Ligação Média 3 - Ligação
         * Completa 4 - Método Ward 5 - Recuperação M_Faino
         */

        if (Simples.isSelected()) {
            teste_recuperação = 1;
        } else {
            if (Media.isSelected()) {
                teste_recuperação = 2;
            } else {
                if (Completa.isSelected()) {
                    teste_recuperação = 3;
                } else {
                    if (Ward.isSelected()) {
                        teste_recuperação = 4;
                    } else {
                        if (Faino.isSelected()) {
                            teste_recuperação = 5;
                        }
                    }
                }
            }
        }


        new Thread() {//instancia nova thread já implementando o método run()
            @Override
            public void run() {//sobrescreve o método run()   
                long tempo = System.currentTimeMillis();
                try {
                    // Executa o Agrupamento
                    Agrupamento(); // Executa o Agrupamento
                    System.out.println("fez agrupamento");
                } catch (IOException ex) {
                    Logger.getLogger(PanelFormigas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanelFormigas.class.getName()).log(Level.SEVERE, null, ex);
                }
                long tempofinal = System.currentTimeMillis();
                System.out.println("Tempo final: " + (tempofinal - tempo));
                try {
                    Recuperacao(teste_recuperação); //Recuperação
                } catch (IOException ex) {
                    Logger.getLogger(PanelFormigas.class.getName()).log(Level.SEVERE, null, ex);
                }

                imprimiAgrupamento();
                imprimiRecuperacao(teste_recuperação);
                setListaResultados();
                jTextArea1.setText(getBuffer().toString());
                ClusteringFrameVisualization.setGrupos(listaGrupos.get(getObjetoAtual()));
                setObjetoAtual();

                Executar_formigas.setEnabled(true);
            }
        }.start();//inicia a thread.
        numeroExecucoes++;

    }//GEN-LAST:event_Executar_formigasActionPerformed

    private void Executar_testeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Executar_testeActionPerformed
    }//GEN-LAST:event_Executar_testeActionPerformed

    private void jCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCompletaActionPerformed
    }//GEN-LAST:event_jCompletaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    }//GEN-LAST:event_jButton3ActionPerformed

    private void EuclidianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EuclidianaActionPerformed
        if (Euclidiana.isSelected()) {
            Correlacao.setEnabled(false);
            Cosseno.setEnabled(false);
            Mahalanobis.setEnabled(false);
        } else {
            Correlacao.setEnabled(true);
            Cosseno.setEnabled(true);
            Mahalanobis.setEnabled(true);
        }
    }//GEN-LAST:event_EuclidianaActionPerformed

    private void CossenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CossenoActionPerformed
        if (Cosseno.isSelected()) {
            Euclidiana.setEnabled(false);
            Correlacao.setEnabled(false);
            Mahalanobis.setEnabled(false);
        } else {
            Euclidiana.setEnabled(true);
            Correlacao.setEnabled(true);
            Mahalanobis.setEnabled(true);
        }
    }//GEN-LAST:event_CossenoActionPerformed

    private void MahalanobisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MahalanobisActionPerformed
        if (Mahalanobis.isSelected()) {
            Euclidiana.setEnabled(false);
            Cosseno.setEnabled(false);
            Correlacao.setEnabled(false);
        } else {
            Euclidiana.setEnabled(true);
            Cosseno.setEnabled(true);
            Correlacao.setEnabled(true);
        }
    }//GEN-LAST:event_MahalanobisActionPerformed

    private void CorrelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorrelacaoActionPerformed
        if (Correlacao.isSelected()) {
            Euclidiana.setEnabled(false);
            Cosseno.setEnabled(false);
            Mahalanobis.setEnabled(false);
        } else {
            Euclidiana.setEnabled(true);
            Cosseno.setEnabled(true);
            Mahalanobis.setEnabled(true);
        }
    }//GEN-LAST:event_CorrelacaoActionPerformed

    private void SimplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimplesActionPerformed
        if (Simples.isSelected()) {
            Completa.setEnabled(false);
            Media.setEnabled(false);
            Ward.setEnabled(false);
            Faino.setEnabled(false);
        } else {
            Completa.setEnabled(true);
            Media.setEnabled(true);
            Ward.setEnabled(true);
            Faino.setEnabled(true);
        }
    }//GEN-LAST:event_SimplesActionPerformed

    private void MediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediaActionPerformed
        if (Media.isSelected()) {
            Completa.setEnabled(false);
            Simples.setEnabled(false);
            Ward.setEnabled(false);
            Faino.setEnabled(false);
        } else {
            Completa.setEnabled(true);
            Simples.setEnabled(true);
            Ward.setEnabled(true);
            Faino.setEnabled(true);
        }
    }//GEN-LAST:event_MediaActionPerformed

    private void CompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompletaActionPerformed
        if (Completa.isSelected()) {
            Media.setEnabled(false);
            Simples.setEnabled(false);
            Ward.setEnabled(false);
            Faino.setEnabled(false);
        } else {
            Media.setEnabled(true);
            Simples.setEnabled(true);
            Ward.setEnabled(true);
            Faino.setEnabled(true);
        }
    }//GEN-LAST:event_CompletaActionPerformed

    private void WardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WardActionPerformed
        if (Ward.isSelected()) {
            Media.setEnabled(false);
            Simples.setEnabled(false);
            Completa.setEnabled(false);
            Faino.setEnabled(false);
        } else {
            Media.setEnabled(true);
            Simples.setEnabled(true);
            Completa.setEnabled(true);
            Faino.setEnabled(true);
        }
    }//GEN-LAST:event_WardActionPerformed

    private void FainoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FainoActionPerformed
        if (Faino.isSelected()) {
            Media.setEnabled(false);
            Simples.setEnabled(false);
            Completa.setEnabled(false);
            Ward.setEnabled(false);
        } else {
            Media.setEnabled(true);
            Simples.setEnabled(true);
            Completa.setEnabled(true);
            Ward.setEnabled(true);
        }
    }//GEN-LAST:event_FainoActionPerformed

    private void listResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listResultadosActionPerformed
    }//GEN-LAST:event_listResultadosActionPerformed

    private void listResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listResultadosMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (listResultados.getSelectedIndex() != -1) {
                StringBuffer text = listaText.get(listResultados.getSelectedIndex());
                System.out.println("Item selecionado = " + listResultados.getSelectedIndex());
                jTextArea1.setText(text.toString());
            }
        }
    }//GEN-LAST:event_listResultadosMouseClicked

    private void buttonVisualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVisualizacaoActionPerformed
    }//GEN-LAST:event_buttonVisualizacaoActionPerformed

    private void fundoSimulacaoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_fundoSimulacaoComponentResized
        if (matriz_padrao == null) {
            matriz_padrao = new int[teste.getDimensão_matriz()][teste.getDimensão_matriz()];
            pmat(matriz_padrao);
        }
        dispersaoGeral();
        setDispersao(matriz_padrao);
    }//GEN-LAST:event_fundoSimulacaoComponentResized

    private void sliderVelocidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderVelocidadeStateChanged
        setSleep(100 - sliderVelocidade.getValue());
    }//GEN-LAST:event_sliderVelocidadeStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Completa;
    private javax.swing.JRadioButton Correlacao;
    private javax.swing.JRadioButton Correlacao1;
    private javax.swing.JRadioButton Cosseno;
    private javax.swing.JRadioButton Cosseno1;
    private javax.swing.JRadioButton Euclidiana;
    private javax.swing.JRadioButton Euclidiana1;
    private javax.swing.JButton Executar_formigas;
    private javax.swing.JButton Executar_teste;
    private javax.swing.JRadioButton Faino;
    private javax.swing.JFrame Frame_Teste;
    private javax.swing.JRadioButton Mahalanobis;
    private javax.swing.JRadioButton Mahalanobis1;
    private javax.swing.JRadioButton Media;
    private javax.swing.JPanel Panel_medidas;
    private javax.swing.JPanel Panel_medidas1;
    private javax.swing.JPanel Panel_recuperacao;
    private javax.swing.JRadioButton Simples;
    private javax.swing.JRadioButton Ward;
    private javax.swing.JButton buttonVisualizacao;
    private javax.swing.JFrame fMetodos;
    private static javax.swing.JPanel fundoSimulacao;
    private javax.swing.JTextField iteracoes;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JRadioButton jCompleta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jMeans;
    private javax.swing.JRadioButton jMedia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jSimples;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton jWard;
    private static javax.swing.JLabel labelProgresso;
    private java.awt.List listResultados;
    private javax.swing.JSlider sliderVelocidade;
    private static javax.swing.JProgressBar statusProgresso;
    // End of variables declaration//GEN-END:variables

    void Agrupamento() throws IOException, InterruptedException {
        if (matriz_padrao == null) {
            matriz_padrao = new int[teste.getDimensão_matriz()][teste.getDimensão_matriz()];
            pmat(matriz_padrao);
        }
//        for (int i = 0; i < teste.getDimensão_matriz(); i++) {
//            for (int j = 0; j < teste.getDimensão_matriz(); j++) {
//                System.out.print(" " + matriz_padrao[i][j]);
//            }
//            System.out.println();
//        }
        ACOClustering c = null;
        try {
            c = new ACOClustering(teste, teste_distancia, matriz_padrao);
        } catch (IOException ex) {
            Logger.getLogger(PanelFormigas.class.getName()).log(Level.SEVERE, null, ex);
        }
        setOperar(c);
        listaObjetos.add(getOperar());
        getOperar().set_percent1((frameFormigas.getFase()));
        getOperar().set_cont2(matrizDados[0].length, matrizDados.length);
        getOperar().set_sigma(frameFormigas.getSigma());
        getOperar().set_sigmamaximo(frameFormigas.getSigmaMaximo());
        getOperar().set_sigmaminimo(frameFormigas.getSigmaMinimo());
        getOperar().set_controlesigma(frameFormigas.getSigmaControle());
        getOperar().set_alfa(frameFormigas.getAlfa());
        getOperar().set_alfamaximo(frameFormigas.getAlfaMaximo());
        getOperar().set_alfaminimo(frameFormigas.getAlfaMinimo());
        getOperar().set_controlealfa(frameFormigas.getAlfaControle());
        getOperar().opera_inicial(teste);


        while (getOperar().getCont() < getOperar().getCont2()) {

            try {
                getOperar().iteracao();
                setDispersao(getOperar().getMatriz_padrao());
                repaint();
                Thread.sleep(sleep);
            } catch (IOException ex) {
                Logger.getLogger(PanelFormigas.class.getName()).log(Level.SEVERE, null, ex);
            }
            getOperar().setCont();
          //  vai(getOperar().getCont());
        }

        matriz_padrao = null;
    }

    synchronized void imprimiAgrupamento() {
        StringBuffer buffer = new StringBuffer();
        setBuffer(buffer);
        getBuffer().append("===================== Informações =====================");
        getBuffer().append("\n\t YADMT.Clustering.AC");
        getBuffer().append("\n\t Base: ");
        getBuffer().append("\n\t Número de Instâncias: " + teste.getLinhas());
        getBuffer().append("\n\t Atributos: " + (teste.getColunas() - 1));
        String grupo = grupos[0];
        for (int i = 0; i < grupos.length; i++) {
            if (!grupo.equals(grupos[i])) {
                getBuffer().append("\n\t\t" + grupo);
                grupo = grupos[i];
            }
        }
        getBuffer().append("\n\t\t" + grupo);
//        Matriz Final
        getBuffer().append("\n\n");
        for (int i = 0; i < getOperar().getMatriz_padrao().length; i++) {
            for (int j = 0; j < getOperar().getMatriz_padrao().length; j++) {
                getBuffer().append(String.valueOf(getOperar().getMatriz_padrao()[i][j]) + " ");
            }
            getBuffer().append("\n");
        }
        getBuffer().append("\n\n");
    }

    synchronized void imprimiRecuperacao(int teste_recuperação) {
        String m = null;
        if (teste_recuperação == 1) {
            m = "Ligação Simples";
        } else if (teste_recuperação == 2) {
            m = "Ligação Media";
        } else if (teste_recuperação == 3) {
            m = "Ligação Completa";
        } else if (teste_recuperação == 4) {
            m = "Ligação Ward";
        } else if (teste_recuperação == 5) {
            m = "Ligação MFaino";
        }
        getBuffer().append("================ " + m + " ================");
        getBuffer().append("\n\tMétodo Ligação Simples");
        getBuffer().append("\n\t\tGrupos Formados: " + String.valueOf(indice.getContgrupo()));
        getBuffer().append("\n\t\tÍndice R: " + String.valueOf(indice.getR()));
        getBuffer().append("\n\t\tÍndice F: " + String.valueOf(indice.getFfinal()));
        getBuffer().append("\n\t\tPorcentagem de Acerto: " + String.valueOf(indice.getPorcentagem()));
        getBuffer().append("\n\t\tÍndice Idunn: " + String.valueOf(indice.getIdunn()));
        getBuffer().append("\n\t\tVariância Total: " + String.valueOf(indice.getVtotal()));
        getBuffer().append("\n\tMatriz Confusão:");
        for (int i = 0; i < indice.getMconfusao().length; i++) {
            for (int j = 0; j < indice.getMconfusao().length; j++) {
                getBuffer().append("\t\t" + indice.getMconfusao()[i][j] + " ");
            }
            getBuffer().append("\n");
        }
    }

    void Recuperacao(int teste_recuperação) throws IOException {


        teste_inicia = 0;
        /*
         * Teste recuperação 1 - Ligação Simples 2 - Ligação Média 3 - Ligação
         * Completa 4 - Método Ward 5 - Recuperação M_Faino
         */
        tempoinicial_rec = System.currentTimeMillis();

        if (teste_recuperação == 1) {
            ligaS = new LigacaoSimples(getOperar().getMatriz_padrao(), teste, getOperar());
            ligaS.inicio();
            listaGrupos.add(ligaS.get_mpos());
            indice = new Índices(getOperar().getMatriz_padrao(), teste, ligaS.get_mpos(), ligaS.get_contgrupos(), ligaS.getNumpad(), getOperar());
            indice.inicio();
        } else if (teste_recuperação == 2) {
            ligaM = new LigacaoMedia(getOperar().getMatriz_padrao(), teste, getOperar());
            ligaM.inicio();
            listaGrupos.add(ligaM.get_mpos());
            indice = new Índices(getOperar().getMatriz_padrao(), teste, ligaM.get_mpos(), ligaM.get_contgrupos(), ligaM.getNumpad(), getOperar());
            indice.inicio();
        } else if (teste_recuperação == 3) {
            ligaC = new LigacaoCompleta(getOperar().getMatriz_padrao(), teste, getOperar());
            ligaC.inicio();
            listaGrupos.add(ligaC.get_mpos());
            indice = new Índices(getOperar().getMatriz_padrao(), teste, ligaC.get_mpos(), ligaC.get_contgrupos(), ligaC.getNumpad(), getOperar());
            indice.inicio();
        } else if (teste_recuperação == 4) {
            ward = new Ward(getOperar().getMatriz_padrao(), teste, getOperar());
            ward.inicio();
            listaGrupos.add(ward.get_mpos());
            indice = new Índices(getOperar().getMatriz_padrao(), teste, ward.get_mpos(), ward.get_contgrupos(), ward.getNumpad(), getOperar());
            indice.inicio();

        } else if (teste_recuperação == 5) {
            achagrupos = new MFaino(getOperar().getMatriz_padrao(), getOperar());
            achagrupos.inicio();
            listaGrupos.add(achagrupos.get_mpos());
            indice = new Índices(getOperar().getMatriz_padrao(), teste, achagrupos.get_mpos(), achagrupos.get_contgrupos(), achagrupos.getPos(), getOperar());
            indice.inicio();
        }

//        tempofinal_rec = System.currentTimeMillis();
//        tempo3 = tempofinal_rec - tempoinicial_rec;
//        numpad = indice.getNumpad();
//        numgrupo = indice.getContgrupo();
//        int somaacertos = 0;
//        float porcentagem = 0;
//        for (int i = 0; i < numpad; i++) {
//            for (int j = 0; j < numgrupo; j++) {
//                if (i == j) {
//                    somaacertos += indice.getMconfusao()[i][j];
//                }
//            }
//        }
//        porcentagem = (somaacertos * 100) / matrizDados.length;
//        if (porcentagem > melhorconfusao) {
//            melhorconfusao = porcentagem;
//            melhormatriz = new int[teste.getDimensão_matriz()][(teste.getDimensão_matriz())];
//            melhormconfusao = new int[numpad][numgrupo];
//            for (int i = 0; i < numpad; i++) {
//                for (int j = 0; j < numgrupo; j++) {
//                    melhormconfusao[i][j] = indice.getMconfusao()[i][j];
//                    melhornumpad = numpad;
//                    melhornumgrupo = numgrupo;
//                }
//            }
//            for (int i = 0; i < teste.getDimensão_matriz(); i++) {
//                for (int j = 0; j < teste.getDimensão_matriz(); j++) {
//                    melhormatriz[i][j] = operar.getMatriz_padrao()[i][j];
//                }
//            }
//            vtotal = indice.getVtotal();
//            idunn = indice.getIdunn();
//            ffinal = indice.getFfinal();
//            r = indice.getR();
//
//        }


    }

    void pmat(int[][] matriz) {
        int i = 0, j = 0, x = 0, y;
        Random random = new Random();
        for (i = 0; i < teste.getDimensão_matriz(); i++) {
            for (j = 0; j < teste.getDimensão_matriz(); j++) {
                matriz[i][j] = 0;
            }
        }
        for (y = 1; y <= matrizDados.length; y++) {//coloca os padroes sem repetir na grade
            do {
                i = random.nextInt((int) teste.getDimensão_matriz());
                j = random.nextInt((int) teste.getDimensão_matriz());
            } while (matriz[i][j] != 0);
            x++;
            if (matriz[i][j] == 0) {
                matriz[i][j] = x;
            }
        }
    }

    public void setGrupos(String[] grupos) {
        this.grupos = grupos;
    }

    public void setMatrizDados(double[][] matrizDados) {
        this.matrizDados = matrizDados;
    }

    public void startMatrizDados() {
        String grupo;
        grupo = grupos[0];
        double[][] base = new double[this.matrizDados.length][this.matrizDados[0].length + 1];
        for (int i = 0; i < this.matrizDados.length; i++) {
            for (int j = 0; j < this.matrizDados[0].length; j++) {
                base[i][j + 1] = this.matrizDados[i][j];
            }
        }

        int contadorGrupos = 1;
        for (int i = 0; i < grupos.length; i++) {
            if (!grupo.equals(grupos[i])) {
                grupo = grupos[i];
                contadorGrupos++;
            }
            base[i][0] = contadorGrupos;
        }


        teste.setColunas(base[0].length);
        teste.setLinhas(base.length);
        teste.setDimensão_matriz();
        teste.setMatriz_dados(base);
        teste.setGrupos(grupos);
        System.out.println("co " + teste.getColunas());
        System.out.println("li " + teste.getLinhas());
        System.out.println("di " + teste.getDimensão_matriz());

    }

    private void setListaResultados() {
        PanelFormigas.ClusteringText text = new ClusteringText();
        String s = text.toString();
        text.setJTextArea(jTextArea1);
        listResultados.add(s);
        listaText.add(buffer);
    }

    class ClusteringText {

        final DateFormat formatter;
        private JTextArea text;
        private Date date;

        public ClusteringText() {
            date = new Date();
            formatter = new SimpleDateFormat("HH:mm:ss");
        }

        /**
         * returns the text area
         *
         * @return
         */
        public JTextArea getJTextArea() {
            return text;
        }

        /**
         * sets the text area
         *
         * @param text
         */
        public void setJTextArea(JTextArea text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return formatter.format(date) + " - Ant-Clustering";

        }
    }

    synchronized public int getObjetoAtual() {
        return objetoAtual;
    }

    synchronized public void setObjetoAtual() {
        this.objetoAtual++;
    }

    synchronized public StringBuffer getBuffer() {
        return buffer;
    }

    synchronized public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }

    public static void setSleep(int s) {
        sleep = s;
    }

    private static void dispersaoGeral() {
        if (GDG == null) {
            GDG = new GraficoDispersaoGeral();
        }
        GDG.setSize(fundoSimulacao.getWidth(), fundoSimulacao.getHeight());
        fundoSimulacao.add(GDG);
        GDG.setVisible(true);
    }

    public static void setDispersao(int[][] a) {
        if (GDG == null) {
            GDG = new GraficoDispersaoGeral();
        }
        GDG.setACO(a);
    }

    public static JPanel getFundoSimulacao() {
        return fundoSimulacao;
    }

    public static void setFundoSimulacao(JPanel fundoSimulacao) {
        PanelFormigas.fundoSimulacao = fundoSimulacao;
    }

    public static MatrizDados getDados() {
        return teste;
    }

    public void vai(final int i) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 setStatus(i);
            }
        });
    }

    public static void setStatus(int i) {
        if (statusProgresso != null) {
            statusProgresso.setValue(i);
            if (i == statusProgresso.getMaximum() - 1) {
                labelProgresso.setText("Finalizado.");
            } else {
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        switch (labelProgresso.getText()) {
                            case "Executando":
                                labelProgresso.setText("Executando.");
                                break;
                            case "Executando.":
                                labelProgresso.setText("Executando..");
                                break;
                            case "Executando..":
                                labelProgresso.setText("Executando...");
                                break;
                            case "Executando...":
                                labelProgresso.setText("Executando");
                                break;
                        }
                    }
                };
                t.start();
            }
        }
    }
}
