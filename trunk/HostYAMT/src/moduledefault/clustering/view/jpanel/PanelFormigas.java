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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import moduledefault.clustering.aco.ACOClustering;
import moduledefault.clustering.recuperacaogrupos.LigacaoCompleta;
import moduledefault.clustering.recuperacaogrupos.LigacaoMedia;
import moduledefault.clustering.recuperacaogrupos.LigacaoSimples;
import moduledefault.clustering.recuperacaogrupos.MFaino;
import moduledefault.clustering.recuperacaogrupos.Ward;
import moduledefault.clustering.uteis.MatrizDados;
import moduledefault.clustering.uteis.Operações_Mat;
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
    public PanelFormigas(double[][] base, String[] grupos, JFrameFormigas j, String[] aa) {

        initComponents();
        nomesClasses = aa;
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
        buttonVisualizacao.setEnabled(false);
    }
    /**
     *
     */
    String[] nomesClasses;
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
    private static GraficoDispersaoSimulacao GDG;
    int qntGrupos;

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

        javax.swing.GroupLayout fundoSimulacaoLayout = new javax.swing.GroupLayout(fundoSimulacao);
        fundoSimulacao.setLayout(fundoSimulacaoLayout);
        fundoSimulacaoLayout.setHorizontalGroup(
            fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        fundoSimulacaoLayout.setVerticalGroup(
            fundoSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
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
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxDistancias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDistancias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxMetodos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMetodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Executar_formigas, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonVisualizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(27, 27, 27)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Executar_formigas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonVisualizacao)
                        .addGap(48, 48, 48)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                System.out.println("Matriz Grupos:;");
                for (int i = 0; i < listaGrupos.get(getObjetoAtual()).length; i++) {
                    for (int j = 0; j < listaGrupos.get(getObjetoAtual())[0].length; j++) {
                        if (j == 0) {

                            System.out.print("\t;" + listaGrupos.get(getObjetoAtual())[i][j] + ";");
                        } else {
                            System.out.print(listaGrupos.get(getObjetoAtual())[i][j] + ";");
                        }
                    }
                    System.out.println("");
                }
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
                System.out.println("Item selecionado = " + listResultados.getSelectedIndex());
                jTextArea1.setText(text.toString());
            }
        }
    }//GEN-LAST:event_listResultadosMouseClicked

    private void buttonVisualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVisualizacaoActionPerformed
        TecnicasDispersao.getInstance().setMatrizDados(teste);
        TecnicasDispersao.getInstance().setMatrizGrupos(listaGrupos.get(getObjetoAtual() - 1));
        TecnicasDispersao.getInstance().setQntGrupos(qntGrupos);
        TecnicasDispersao.getInstance().setCombos();
        TecnicasDispersao.getInstance().setVisible(true);
    }//GEN-LAST:event_buttonVisualizacaoActionPerformed

    private void fundoSimulacaoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_fundoSimulacaoComponentResized
        if (matriz_padrao == null) {
            matriz_padrao = new int[teste.getDimensão_matriz()][teste.getDimensão_matriz()];
            pmat(matriz_padrao);
        }
        dispersaoGeral();
        setDispersao(matriz_padrao);
    }//GEN-LAST:event_fundoSimulacaoComponentResized
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jSimples;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton jWard;
    private java.awt.List listResultados;
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
        //  ClusteringFrameVisualization.getInstance().setVisible(false);
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
        getBuffer().append("\n\t Número de Instâncias: " + teste.getLinhas());
        getBuffer().append("\n\t Atributos: " + (teste.getColunas() - 1));
        getBuffer().append("\n\t Classes:");
        for (int i = 0; i < nomesClasses.length; i++) {
            getBuffer().append("\n\t\t" + nomesClasses[i]);
        }
//        Matriz Final
//        getBuffer().append("\n\n");
//        for (int i = 0; i < getOperar().getMatriz_padrao().length; i++) {
//            for (int j = 0; j < getOperar().getMatriz_padrao().length; j++) {
//                getBuffer().append(String.valueOf(getOperar().getMatriz_padrao()[i][j]) + " ");
//            }
//            getBuffer().append("\n");
//        }
//        getBuffer().append("\n\n");
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
        getBuffer().append("\n\n\n================ " + m + " ================");
        System.out.println("Método " + m + ";");
        getBuffer().append("\n\tGrupos Formados: " + String.valueOf(indice.getContgrupo()));
        System.out.println("Grupos Formados:; " + String.valueOf(indice.getContgrupo()) + ";");
        getBuffer().append("\n\tÍndice R: " + String.valueOf(indice.getR()));
        System.out.println("Índice R:; " + String.valueOf(indice.getR()) + ";");
        getBuffer().append("\n\tÍndice F: " + String.valueOf(indice.getFfinal()));
        System.out.println("Índice F:; " + String.valueOf(indice.getFfinal()) + ";");
        getBuffer().append("\n\tPorcentagem de Acerto: " + String.valueOf(indice.getPorcentagem()));
        System.out.println("Porcentagem de Acerto:; " + String.valueOf(indice.getPorcentagem()) + ";");
        getBuffer().append("\n\tÍndice Idunn: " + String.valueOf(indice.getIdunn()));
        System.out.println("Índice Idunn:; " + String.valueOf(indice.getIdunn()) + ";");
        getBuffer().append("\n\tVariância Total: " + String.valueOf(indice.getVtotal()));
        System.out.println("Variância Total:; " + String.valueOf(indice.getVtotal()) + ";");
        getBuffer().append("\n\tMatriz Confusão:");
        System.out.println("Matriz Confusão:" + ";");

//        if (nomesClasses != null) {
//            for (int i = 0; i < indice.getMconfusao().length; i++) {
//                for (int j = 0; j < indice.getMconfusao().length; j++) {
//                    getBuffer().append("\t\t" + indice.getMconfusao()[i][j] + " ");
//
//                }
//                getBuffer().append("\n");
//            }
//        }

        getBuffer().append("\nGrupos Formados:");
        for (int j = listaGrupos.get(getObjetoAtual())[0].length - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (listaGrupos.get(getObjetoAtual())[0][i] > listaGrupos.get(getObjetoAtual())[0][i + 1]) {
                    int auxLinha = listaGrupos.get(getObjetoAtual())[0][i];
                    int auxColuna = listaGrupos.get(getObjetoAtual())[1][i];
                    listaGrupos.get(getObjetoAtual())[0][i] = listaGrupos.get(getObjetoAtual())[0][i + 1];
                    listaGrupos.get(getObjetoAtual())[1][i] = listaGrupos.get(getObjetoAtual())[1][i + 1];
                    listaGrupos.get(getObjetoAtual())[0][i + 1] = auxLinha;
                    listaGrupos.get(getObjetoAtual())[1][i + 1] = auxColuna;
                }
            }
        }

        for (int k = 0; k < indice.getContgrupo(); k++) {
            getBuffer().append("Grupo: "+(k+1)+"\n");
            for (int i = 0; i < listaGrupos.get(getObjetoAtual()).length; i++) {
                for (int j = 0; j < listaGrupos.get(getObjetoAtual())[0].length; j++) {
                    if(listaGrupos.get(getObjetoAtual())[1][j] == (k+1)){
                        getBuffer().append(listaGrupos.get(getObjetoAtual())[0][j]+" ");
                    }
                }
            }
            getBuffer().append("\n\n-------------------------------\n\n");
        }
    }

    void Recuperacao(int teste_recuperação) throws IOException {


        teste_inicia = 0;
        /*
         * Teste recuperação 1 - Ligação Simples 2 - Ligação Média 3 - Ligação
         * Completa 4 - Método Ward 5 - Recuperação M_Faino
         */
        tempoinicial_rec = System.currentTimeMillis();

        if (teste_recuperação == 3) {
            ligaS = new LigacaoSimples(getOperar().getMatriz_padrao(), teste, getOperar());
            ligaS.inicio();
            listaGrupos.add(ligaS.get_mpos());
            qntGrupos = ligaS.get_contgrupos();
            indice = new Índices(getOperar().getMatriz_padrao(), teste, ligaS.get_mpos(), ligaS.get_contgrupos(), ligaS.getNumpad(), getOperar());
            indice.inicio();
            System.out.println("fez as paradas");
        } else if (teste_recuperação == 2) {
            ligaM = new LigacaoMedia(getOperar().getMatriz_padrao(), teste, getOperar());
            ligaM.inicio();
            qntGrupos = ligaM.get_contgrupos();
            listaGrupos.add(ligaM.get_mpos());
            indice = new Índices(getOperar().getMatriz_padrao(), teste, ligaM.get_mpos(), ligaM.get_contgrupos(), ligaM.getNumpad(), getOperar());
            indice.inicio();
        } else if (teste_recuperação == 1) {
            ligaC = new LigacaoCompleta(getOperar().getMatriz_padrao(), teste, getOperar());
            ligaC.inicio();
            qntGrupos = ligaC.get_contgrupos();
            listaGrupos.add(ligaC.get_mpos());
            indice = new Índices(getOperar().getMatriz_padrao(), teste, ligaC.get_mpos(), ligaC.get_contgrupos(), ligaC.getNumpad(), getOperar());
            indice.inicio();
        } else if (teste_recuperação == 5) {
            ward = new Ward(getOperar().getMatriz_padrao(), teste, getOperar());
            ward.inicio();
            qntGrupos = ward.get_contgrupos();
            listaGrupos.add(ward.get_mpos());
            indice = new Índices(getOperar().getMatriz_padrao(), teste, ward.get_mpos(), ward.get_contgrupos(), ward.getNumpad(), getOperar());
            indice.inicio();
        } else if (teste_recuperação == 4) {
            achagrupos = new MFaino(getOperar().getMatriz_padrao(), getOperar());
            achagrupos.inicio();
            qntGrupos = achagrupos.get_contgrupos();
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
        ArrayList<String> atributos = new ArrayList<>();
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


        teste.setClasses(nomesClasses);
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

    public static MatrizDados getDados() {
        return teste;
    }
//    public void vai(final int i) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                 setStatus(i);
//            }
//        });
//    }
//    public static void setStatus(int i) {
//        if (statusProgresso != null) {
//            statusProgresso.setValue(i);
//            if (i == statusProgresso.getMaximum() - 1) {
//                labelProgresso.setText("Finalizado.");
//            } else {
//                Thread t = new Thread() {
//                    @Override
//                    public void run() {
//                        switch (labelProgresso.getText()) {
//                            case "Executando":
//                                labelProgresso.setText("Executando.");
//                                break;
//                            case "Executando.":
//                                labelProgresso.setText("Executando..");
//                                break;
//                            case "Executando..":
//                                labelProgresso.setText("Executando...");
//                                break;
//                            case "Executando...":
//                                labelProgresso.setText("Executando");
//                                break;
//                        }
//                    }
//                };
//                t.start();
//            }
//        }
//    }
}
