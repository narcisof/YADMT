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
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import moduledefault.clustering.aco.ACOClustering;
import moduledefault.clustering.recuperacaogrupos.LigacaoCompletaRec;
import moduledefault.clustering.recuperacaogrupos.LigacaoMediaRec;
import moduledefault.clustering.recuperacaogrupos.LigacaoSimplesRec;
import moduledefault.clustering.recuperacaogrupos.MFaino;
import moduledefault.clustering.recuperacaogrupos.WardRec;
import moduledefault.clustering.uteis.AvaliacaoAgrupamento;
import moduledefault.clustering.uteis.Base;
import moduledefault.clustering.uteis.Cluster;
import moduledefault.clustering.uteis.Operações_Mat;
import moduledefault.clustering.uteis.Padrao;
import moduledefault.clustering.uteis.Índices;
import moduledefault.clustering.view.frames.JFrameFormigas;
import moduledefault.clustering.visualization.TecnicasDispersao;
import moduledefault.clustering.visualization.GraficoDispersaoSimulacao;
import view.jpanel.JPanelClustering;

/**
 *
 * @author Mateus
 */
public final class PanelFormigas extends javax.swing.JPanel {

    /**
     * Creates new form panelFormigas
     */
    interfaces.Base base;
    static Base dados;

    public PanelFormigas(interfaces.Base b, JFrameFormigas j) {
        initComponents();
        base = b;
        startMatrizDados();
        Operações_Mat mat = new Operações_Mat();
        mat.Padronização(dados);
//        imprimiBase();
        listaObjetos = new ArrayList<ACOClustering>();
        clusters = new ArrayList<Cluster>();
        listaText = new ArrayList<>();
        frameFormigas = j;
        this.objetoAtual = 0;
        buttonVisualizacao.setEnabled(false);
    }

    public JFrameFormigas getFrameFormigas() {
        return frameFormigas;
    }

    public void setFrameFormigas(JFrameFormigas frameFormigas) {
        this.frameFormigas = frameFormigas;
    }
    /**
     *
     */
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
    LigacaoCompletaRec ligaC;
    LigacaoSimplesRec ligaS;
    LigacaoMediaRec ligaM;
    WardRec ward;
    MFaino achagrupos;
    double[][] matrizDados;
    int teste_distancia = 0;
    JFrameFormigas frameFormigas;
    StringBuffer buffer;
    ArrayList<StringBuffer> listaText;
    int teste_recuperação = 0;
    int objetoAtual;
    static int sleep;
    int numeroExecucoes = 0;
    private static GraficoDispersaoSimulacao GDG;
    int qntGrupos;
    ArrayList<Cluster> clusters;

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
        Executar_formigas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        listResultados = new java.awt.List();
        buttonVisualizacao = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        fundoSimulacao = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxDistancias = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxMetodos = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        statusProgresso = new javax.swing.JProgressBar();
        jSlider1 = new javax.swing.JSlider();

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
            .addComponent(listResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
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
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTabbedPane1.addTab("Resultado", jScrollPane1);

        fundoSimulacao.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                fundoSimulacaoComponentResized(evt);
            }
        });

        javax.swing.GroupLayout fundoSimulacaoLayout = new javax.swing.GroupLayout(fundoSimulacao);
        fundoSimulacao.setLayout(fundoSimulacaoLayout);
        fundoSimulacaoLayout.setHorizontalGroup(
            fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );
        fundoSimulacaoLayout.setVerticalGroup(
            fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Simulação", fundoSimulacao);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Distância"));

        jLabel1.setText("Função de Distância:");

        jComboBoxDistancias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Chebyshev","CityBlock","Correlação" ,"Cosseno", "Euclidiana", "Mahalanobis" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 44, Short.MAX_VALUE))
            .addComponent(jComboBoxDistancias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDistancias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Recuperação de Grupos"));

        jLabel2.setText("Método:");

        jComboBoxMetodos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Completa", "Média", "Simples", "MFaino","Ward" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 104, Short.MAX_VALUE))
            .addComponent(jComboBoxMetodos, 0, 144, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jComboBoxMetodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Progresso"));

        jSlider1.setMaximum(1000);
        jSlider1.setValue(500);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(statusProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Executar_formigas, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonVisualizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Executar_formigas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonVisualizacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Executar_formigasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Executar_formigasActionPerformed
        this.Executar_formigas.setEnabled(false);

        switch (this.jComboBoxDistancias.getSelectedIndex()) {
            case 0:
                JOptionPane.showMessageDialog(null, "Selecione uma Medida de Distância.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.Executar_formigas.setEnabled(true);

                return;
            case 1:
                teste_distancia = 1;
                break;
            case 2:
                teste_distancia = 2;
                break;
            case 3:
                teste_distancia = 3;
                break;
            case 4:
                teste_distancia = 4;
                break;
            case 5:
                teste_distancia = 5;
                break;
            case 6:
                teste_distancia = 6;
                break;
            default:
                break;
        }

        switch (this.jComboBoxMetodos.getSelectedIndex()) {
            case 0:
                JOptionPane.showMessageDialog(null, "Selecione um Método de Recuperação.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.Executar_formigas.setEnabled(true);

                return;
            case 1:
                teste_recuperação = 1;
                break;
            case 2:
                teste_recuperação = 2;
                break;
            case 3:
                teste_recuperação = 3;
                break;
            case 4:
                teste_recuperação = 4;
                break;
            case 5:
                teste_recuperação = 5;
                break;
            default:
                break;
        }

        new Thread() {//instancia nova thread já implementando o método run()
            @Override
            public void run() {//sobrescreve o método run()   
                long tempo = System.currentTimeMillis();
                try {
                    // Executa o Agrupamento
                    Agrupamento(); // Executa o Agrupamento
                } catch (IOException ex) {
                    Logger.getLogger(PanelFormigas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanelFormigas.class.getName()).log(Level.SEVERE, null, ex);
                }
                long tempofinal = System.currentTimeMillis();
                try {
                    Recuperacao(teste_recuperação); //Recuperação
                } catch (IOException ex) {
                    Logger.getLogger(PanelFormigas.class.getName()).log(Level.SEVERE, null, ex);
                }

                imprimiAgrupamento();
                imprimiRecuperacao(teste_recuperação);

                setListaResultados();
                jTextArea1.setText(getBuffer().toString());
                setObjetoAtual();
                Executar_formigas.setEnabled(true);
                buttonVisualizacao.setEnabled(true);
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

    private void listResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listResultadosActionPerformed
    }//GEN-LAST:event_listResultadosActionPerformed

    private void listResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listResultadosMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (listResultados.getSelectedIndex() != -1) {
                StringBuffer text = listaText.get(listResultados.getSelectedIndex());
                jTextArea1.setText(text.toString());
            }
        }
    }//GEN-LAST:event_listResultadosMouseClicked

    private void buttonVisualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVisualizacaoActionPerformed


        TecnicasDispersao.getInstance().setSetou(false);
        TecnicasDispersao.getInstance().setMatrizDados(dados);
        TecnicasDispersao.getInstance().setCluster(clusters);
        TecnicasDispersao.getInstance().setQntGrupos(qntGrupos);
        TecnicasDispersao.getInstance().setCombos();
        TecnicasDispersao.getInstance().setVisible(true);
    }//GEN-LAST:event_buttonVisualizacaoActionPerformed

    private void fundoSimulacaoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_fundoSimulacaoComponentResized
        if (matriz_padrao == null) {
            matriz_padrao = new int[dados.getDimensaoMatriz()][dados.getDimensaoMatriz()];
            pmat(matriz_padrao);
        }
        dispersaoGeral();
        setDispersao(matriz_padrao);
    }//GEN-LAST:event_fundoSimulacaoComponentResized

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        new Thread() {
            @Override
            public void run() {
                setSleep(jSlider1.getMaximum() - jSlider1.getValue());
            }
        }.start();
    }//GEN-LAST:event_jSlider1StateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Correlacao1;
    private javax.swing.JRadioButton Cosseno1;
    private javax.swing.JRadioButton Euclidiana1;
    private javax.swing.JButton Executar_formigas;
    private javax.swing.JButton Executar_teste;
    private javax.swing.JFrame Frame_Teste;
    private javax.swing.JRadioButton Mahalanobis1;
    private javax.swing.JPanel Panel_medidas1;
    private javax.swing.JButton buttonVisualizacao;
    private javax.swing.JFrame fMetodos;
    private static javax.swing.JPanel fundoSimulacao;
    private javax.swing.JTextField iteracoes;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private static javax.swing.JComboBox jComboBoxDistancias;
    private static javax.swing.JComboBox jComboBoxMetodos;
    private javax.swing.JRadioButton jCompleta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jMeans;
    private javax.swing.JRadioButton jMedia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jSimples;
    private static javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton jWard;
    private java.awt.List listResultados;
    private static javax.swing.JProgressBar statusProgresso;
    // End of variables declaration//GEN-END:variables

    void Agrupamento() throws IOException, InterruptedException {
        if (matriz_padrao == null) {
            matriz_padrao = new int[dados.getDimensaoMatriz()][dados.getDimensaoMatriz()];
            pmat(matriz_padrao);
        }
        ACOClustering c = null;
        try {
            c = new ACOClustering(dados, teste_distancia, matriz_padrao);

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
        getOperar().opera_inicial(dados);


        while (getOperar().getCont() < getOperar().getCont2()) {

            try {
                getOperar().iteracao();
                setDispersao(getOperar().getMatriz_padrao());
                repaint();
                Thread.sleep(0);
                vai((getOperar().getCont() * 100) / getOperar().getCont2());
            } catch (IOException ex) {
                Logger.getLogger(PanelFormigas.class.getName()).log(Level.SEVERE, null, ex);
            }
            getOperar().setCont();
        }

        matriz_padrao = null;
    }

    synchronized void imprimiAgrupamento() {
        StringBuffer buffer = new StringBuffer();
        setBuffer(buffer);
        getBuffer().append("===================== Informações =====================");
        getBuffer().append("\n\t\t\tYADMT.Clustering.AC");
        getBuffer().append("\n\t Base: " + getDados().getNome());
        getBuffer().append("\n\t Número de Instâncias: " + getDados().getDataSet().size());
        getBuffer().append("\n\t Atributos: " + (getDados().getAtributos().size() - 1));
        getBuffer().append("\n\t Classes:");
        for (int i = 0; i < getDados().getClasses().size(); i++) {
            getBuffer().append("\n\t\t" + getDados().getClasses().get(i));
        }
        getBuffer().append("\n\t Parâmetros: " + frameFormigas.getSigma() + ";" + frameFormigas.getSigmaMaximo() + ";" + frameFormigas.getSigmaMinimo() + ";"
                + frameFormigas.getSigmaControle() + ";" + frameFormigas.getAlfa() + ";" + frameFormigas.getAlfaMaximo() + ";" + frameFormigas.getAlfaMinimo()
                + ";" + frameFormigas.getAlfaMinimo() + ";" + frameFormigas.getAlfaControle() + ";" + frameFormigas.getFase());
        switch (teste_distancia) {
            case 1:
                getBuffer().append(";Ch;");
                break;
            case 2:
                getBuffer().append(";Ci;");
                break;
            case 3:
                getBuffer().append(";Cor;");
                break;
            case 4:
                getBuffer().append(";Cos;");
                break;
            case 5:
                getBuffer().append(";E;");
                break;
            case 6:
                getBuffer().append(";M;");
                break;
            default:
                break;
        }

        switch (teste_recuperação) {
            case 1:
                getBuffer().append("LC.\n");
                break;
            case 2:
                getBuffer().append("LM.\n");
                break;
            case 3:
                getBuffer().append("LS.\n");
                break;
            case 4:
                getBuffer().append("MF.\n");
                break;
            case 5:
                getBuffer().append("W.\n");
                break;

        }
    }

    synchronized void imprimiRecuperacao(int teste_recuperação) {
        String m = null;
        if (teste_recuperação == 3) {
            m = "Ligação Simples";
        } else if (teste_recuperação == 2) {
            m = "Ligação Media";
        } else if (teste_recuperação == 1) {
            m = "Ligação Completa";
        } else if (teste_recuperação == 5) {
            m = "Ligação Ward";
        } else if (teste_recuperação == 4) {
            m = "Ligação MFaino";
        }
        AvaliacaoAgrupamento avaliacao = new AvaliacaoAgrupamento(clusters, dados.getClasses(), dados);
        getBuffer().append("\n\n\n==================== " + m + " ====================");
        getBuffer().append("\n\tGrupos Formados: " + String.valueOf(clusters.size()));
        getBuffer().append("\n\tÍndice R: ALEATÓRIO");
        getBuffer().append("\n\tÍndice F: " + String.valueOf(avaliacao.getMedidaF()));
        getBuffer().append("\n\tPorcentagem de Acerto: " + String.valueOf(avaliacao.getAcerto()));
        getBuffer().append("\n\tÍndice Idunn: "+String.valueOf(avaliacao.getIndiceDunn()));
        getBuffer().append("\n\tVariância Total: " + String.valueOf(avaliacao.getVariancia()));
        getBuffer().append("\n\nGrupos Formados:\n\n");
//        for (int j = listaGrupos.get(getObjetoAtual())[0].length - 1; j >= 1; j--) {
//            for (int i = 0; i < j; i++) {
//                if (listaGrupos.get(getObjetoAtual())[0][i] > listaGrupos.get(getObjetoAtual())[0][i + 1]) {
//                    int auxLinha = listaGrupos.get(getObjetoAtual())[0][i];
//                    int auxColuna = listaGrupos.get(getObjetoAtual())[1][i];
//                    listaGrupos.get(getObjetoAtual())[0][i] = listaGrupos.get(getObjetoAtual())[0][i + 1];
//                    listaGrupos.get(getObjetoAtual())[1][i] = listaGrupos.get(getObjetoAtual())[1][i + 1];
//                    listaGrupos.get(getObjetoAtual())[0][i + 1] = auxLinha;
//                    listaGrupos.get(getObjetoAtual())[1][i + 1] = auxColuna;
//                }
//            }
//        }

        ArrayList<Integer> grupo;

        //imprime em tela o agrupamento realizado
        String padrao;
        for (int i = 0; i < clusters.size(); i++) {
//            clusters.get(i).setNomeGrupo(dados.getClasses());
            clusters.get(i).setNomeGrupo("Grupo " + (i + 1));
            System.out.println("Grupo = " + (i + 1) + " clusters.getNome() = " + clusters.get(i).getNomeGrupo());
            getBuffer().append("Grupo " + (i + 1) + ":");
            grupo = clusters.get(i).getSortGrupo();
            for (int j = 0; j < grupo.size(); j++) {
                padrao = grupo.get(j) + "";
                switch (padrao.length()) {
                    case 1:
                        padrao += "   ";
                        break;
                    case 2:
                        padrao += "  ";
                        break;
                    case 3:
                        padrao += " ";
                        break;
                }
                if (j % 10 == 0) {
                    getBuffer().append("\n");
                }
                getBuffer().append(padrao);
            }
            getBuffer().append("\n");
            getBuffer().append("\n\nCentróide: "+avaliacao.centroide(clusters.get(i)));
            getBuffer().append("\n\n-------------------------------------------------------\n\n");

        }

        mconfusao = avaliacao.getMconfusao();
        getBuffer().append("\tMatriz Confusão: \n\n");
        char classe = 'a';
        for (int i = 0; i < mconfusao[0].length; i++) {
            getBuffer().append(classe + "\t");
            ++classe;
        }
        getBuffer().append("\n");
        classe = 'a';
        for (int i = 0; i < mconfusao.length; i++) {
            for (int j = 0; j < mconfusao[0].length; j++) {
                getBuffer().append(mconfusao[i][j] + "\t");
                if (j == mconfusao[0].length - 1) {
                    getBuffer().append("\t" + classe + " = " + dados.getClasses().get(i));
                    ++classe;
                }
            }
            getBuffer().append("\n");
        }

    }

    void Recuperacao(int teste_recuperação) throws IOException {


        teste_inicia = 0;
        tempoinicial_rec = System.currentTimeMillis();

        if (teste_recuperação == 3) {
            ligaS = new LigacaoSimplesRec(getOperar().getMatriz_padrao(), dados, getOperar());
            ligaS.inicio();
            formaClusters(ligaS.get_mpos(), ligaS.get_contgrupos());
            qntGrupos = ligaS.get_contgrupos();
        } else if (teste_recuperação == 2) {
            ligaM = new LigacaoMediaRec(getOperar().getMatriz_padrao(), dados, getOperar());
            ligaM.inicio();
            formaClusters(ligaM.get_mpos(), ligaM.get_contgrupos());
            qntGrupos = ligaM.get_contgrupos();
        } else if (teste_recuperação == 1) {
            ligaC = new LigacaoCompletaRec(getOperar().getMatriz_padrao(), dados, getOperar());
            ligaC.inicio();
            formaClusters(ligaC.get_mpos(), ligaC.get_contgrupos());
            qntGrupos = ligaC.get_contgrupos();
        } else if (teste_recuperação == 5) {
            ward = new WardRec(getOperar().getMatriz_padrao(), dados, getOperar());
            ward.inicio();
            formaClusters(ward.get_mpos(), ward.get_contgrupos());
            qntGrupos = ward.get_contgrupos();
        } else if (teste_recuperação == 4) {
            achagrupos = new MFaino(getOperar().getMatriz_padrao(), getOperar());
            achagrupos.inicio();
            formaClusters(achagrupos.get_mpos(), achagrupos.get_contgrupos());
            qntGrupos = achagrupos.get_contgrupos();
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
//            melhormatriz = new int[dados.getDimensão_matriz()][(dados.getDimensão_matriz())];
//            melhormconfusao = new int[numpad][numgrupo];
//            for (int i = 0; i < numpad; i++) {
//                for (int j = 0; j < numgrupo; j++) {
//                    melhormconfusao[i][j] = indice.getMconfusao()[i][j];
//                    melhornumpad = numpad;
//                    melhornumgrupo = numgrupo;
//                }
//            }
//            for (int i = 0; i < dados.getDimensão_matriz(); i++) {
//                for (int j = 0; j < dados.getDimensão_matriz(); j++) {
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
        for (i = 0; i < dados.getDimensaoMatriz(); i++) {
            for (j = 0; j < dados.getDimensaoMatriz(); j++) {
                matriz[i][j] = 0;
            }
        }
        for (y = 1; y <= matrizDados.length; y++) {//coloca os padroes sem repetir na grade
            do {
                i = random.nextInt((int) dados.getDimensaoMatriz());
                j = random.nextInt((int) dados.getDimensaoMatriz());
            } while (matriz[i][j] != 0);
            x++;
            if (matriz[i][j] == 0) {
                matriz[i][j] = x;
            }
        }
    }

    public void setMatrizDados(double[][] matrizDados) {
        this.matrizDados = matrizDados;
    }

    public void startMatrizDados() {
        dados = new moduledefault.clustering.uteis.Base();
        double matriz[][] = new double[base.getInput().length][base.getInput()[0].length]; //= arrayListBases.get(arrayListBases.size() - 1).getInput();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = Double.valueOf(base.getInput()[i][j] + "").doubleValue();
            }
        }
//        padronizacao(base);
        matrizDados = matriz;
        int grupo = 0;
        for (int i = 0; i < matriz.length; i++) {
            Padrao p = new Padrao();
            p.setNumero(grupo);
            ++grupo;
            for (int j = 0; j < matriz[0].length; j++) {
                p.addAtributos(matriz[i][j]);

            }
            p.setClasse(base.getOutput()[i].toString());
            dados.addDataSet(p);
        }

        for (int i = 0; i < base.getAtributes().length; i++) {
            dados.addAtributos(base.getAtributes()[i]);
        }
        dados.setClasses((List) base.getClasses());
        dados.setNome((String) base.getName());
        dados.setDimensaoMatriz();

//        imprimiBase();
        TecnicasDispersao.getInstance().setSetou(false);
        TecnicasDispersao.getInstance().setMatrizDados(dados);
        TecnicasDispersao.getInstance().setQntGrupos(qntGrupos);
        TecnicasDispersao.getInstance().setCombos();

    }

    private void setListaResultados() {
        PanelFormigas.ClusteringText text = new ClusteringText();
        String s = text.toString();
        text.setJTextArea(jTextArea1);
        listResultados.add(s);
        listaText.add(buffer);
    }

    public void attBase(interfaces.Base get) {
        base = get;
        startMatrizDados();
    }

    private void imprimiBase() {
        System.out.println("Nome = " + dados.getNome());
        System.out.println("Atributos = ");
        for (int i = 0; i < dados.getAtributos().size(); i++) {
            System.out.print(dados.getAtributos().get(i) + " ");
        }
        System.out.println("\nClasses = ");
        for (int i = 0; i < dados.getClasses().size(); i++) {
            System.out.print(dados.getClasses().get(i) + " ");
        }
        System.out.println("\ndimensao = " + dados.getDimensaoMatriz());
        System.out.println("Dados: ");
        for (int i = 0; i < dados.getDataSet().size(); i++) {
            for (int j = 0; j < dados.getDataSet().get(i).getAtributos().size(); j++) {
                System.out.print(dados.getDataSet().get(i).getAtributos().get(j) + " ");
            }
            System.out.println("");
        }
    }

    private void formaClusters(int[][] mpos, int numGrupos) {
        clusters = new ArrayList<Cluster>();
        for (int i = 0; i < numGrupos; i++) {
            Cluster cl = new Cluster();
            clusters.add(cl);
        }
        for (int j = mpos[0].length - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (mpos[1][i] > mpos[1][i + 1]) {
                    int auxLinha = mpos[0][i];
                    int auxColuna = mpos[1][i];
                    mpos[0][i] = mpos[0][i + 1];
                    mpos[1][i] = mpos[1][i + 1];
                    mpos[0][i + 1] = auxLinha;
                    mpos[1][i + 1] = auxColuna;
                }
            }
        }
        System.out.println("mpos = ");
        for (int i = 0; i < mpos.length; i++) {
            for (int j = 0; j < mpos[0].length; j++) {
                System.out.print(mpos[i][j] + " ");
            }
            System.out.println("");
        }
        int grupoInicial = mpos[1][0];
        int iterator = 0;
        int cont = 0;
        for (int i = 0; i < numGrupos; i++) {
            for (int j = iterator; j < mpos[0].length; j++) {
                if (mpos[1][j] == grupoInicial) {
                    clusters.get(i).addPadrao(dados.getDataSet().get(mpos[0][j] - 1));
                } else {
                    grupoInicial = mpos[1][j];
                    iterator = j;
                    break;
                }
            }
        }
//
//        System.out.println("numero de clusters: " + clusters.size());
//        for (int i = 0; i < clusters.size(); i++) {
//            System.out.println("clusters: " + (i + 1));
//            System.out.println(clusters.get(i).getNomeGrupo());
//            System.out.println("elementos: ");
//            for (int j = 0; j < clusters.get(i).getGrupo().size(); j++) {
//                System.out.print(clusters.get(i).getGrupo().get(j).getNumero() + " ");
//            }
//            System.out.println();
//        }
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
            GDG = new GraficoDispersaoSimulacao();
        }
        GDG.setSize(fundoSimulacao.getWidth(), fundoSimulacao.getHeight());
        fundoSimulacao.add(GDG);
        GDG.setVisible(true);
    }

    public static void setDispersao(int[][] a) {
        if (GDG == null) {
            GDG = new GraficoDispersaoSimulacao();
        }
        GDG.setACO(a);
    }

    public static JPanel getFundoSimulacao() {
        return fundoSimulacao;
    }

    public static void setFundoSimulacao(JPanel fundoSimulacao) {
        PanelFormigas.fundoSimulacao = fundoSimulacao;
    }

    public static Base getDados() {
        return dados;
    }

    public void vai(final int i) {
        new Thread() {
            @Override
            public void run() {
                statusProgresso.setValue(i);
            }
        }.start();
    }
}
