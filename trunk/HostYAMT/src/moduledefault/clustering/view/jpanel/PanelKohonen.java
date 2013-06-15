/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.view.jpanel;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import moduledefault.clustering.kohonen.Base;
import moduledefault.clustering.kohonen.Cluster;
import moduledefault.clustering.kohonen.ClusteringSOM;
import moduledefault.clustering.kohonen.OpMath;
import moduledefault.clustering.kohonen.Padrao;
import moduledefault.clustering.kohonen.RedeKohonen;
import moduledefault.clustering.kohonen.visualization.FrameVisualization;
import moduledefault.clustering.view.frames.JFrameKohonenConfig;
import moduledefault.clustering.view.frames.JFrameKohonenConfigDensidade;

/**
 *
 * @author Thiago Magalhães Faino
 */
public final class PanelKohonen extends javax.swing.JPanel {

    //Variaveis Kohonen
    private ArrayList<interfaces.Base> arrayListBases = new ArrayList<>();
    private Base dados;
    private RedeKohonen rede = null;
    private int gridX = 0;
    private int gridY = 0;
    private String distancia;
    private String vizinhanca;
    private String atualiza;
    private String agrupamento;
    private int raio;
    private int iteracoes;
    private float alfa;
    //
    private double[][] matrizU;
    private static RedeKohonen redeaux;
    //
    Thread t;
    private static int sleep = 0;
    //
    JFrameKohonenConfig frameKohonen;
    //
    JFrameKohonenConfigDensidade densidadeConfig = null;

    public PanelKohonen(ArrayList<interfaces.Base> b, JFrameKohonenConfig fk) {
        initComponents();
        frameKohonen = fk;
        arrayListBases = b;
        carregaBase();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoVizinhanca = new javax.swing.ButtonGroup();
        grupoDistancia = new javax.swing.ButtonGroup();
        grupoAprendizagem = new javax.swing.ButtonGroup();
        grupoGrade = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        campoGridX = new javax.swing.JSpinner();
        campoGridY = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoAprendizagem = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campoRaio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        campoIteracoes = new javax.swing.JSpinner();
        bVisualizacao = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        agrupamentoDensidade = new javax.swing.JRadioButton();
        jButtonConfigDensidade = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configurações da Rede"));

        jLabel4.setText("Número de Linhas:");

        campoGridX.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(1), null, Integer.valueOf(1)));
        campoGridX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                campoGridXStateChanged(evt);
            }
        });

        campoGridY.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(1), null, Integer.valueOf(1)));
        campoGridY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                campoGridYStateChanged(evt);
            }
        });

        jLabel5.setText("Número de Colunas:");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, campoGridX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, campoGridY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(campoGridX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(campoGridY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 11, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Aprendizagem"));

        jLabel2.setText("Aprendizagem inicial:");

        campoAprendizagem.setText("0.1");

        org.jdesktop.layout.GroupLayout jPanel10Layout = new org.jdesktop.layout.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(campoAprendizagem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel10Layout.createSequentialGroup()
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campoAprendizagem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Vizinhança"));

        jLabel3.setText("Raio inicial:");

        campoRaio.setText("2");

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(campoRaio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel8Layout.createSequentialGroup()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campoRaio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setText("Número de Iterações:");

        inicio.setText("Inicia");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        campoIteracoes.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(500), Integer.valueOf(1), null, Integer.valueOf(1)));
        campoIteracoes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                campoIteracoesStateChanged(evt);
            }
        });

        bVisualizacao.setText("Visualização");
        bVisualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVisualizacaoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jProgressBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(bVisualizacao, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(inicio, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(campoIteracoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(campoIteracoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(inicio)
                    .add(bVisualizacao))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(12, 12, 12))
        );

        jTextArea.setEditable(false);
        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Agrupamento"));

        agrupamentoDensidade.setSelected(true);
        agrupamentoDensidade.setText("Matriz de Densidade");

        jButtonConfigDensidade.setText("Config");
        jButtonConfigDensidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfigDensidadeActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(agrupamentoDensidade)
                .add(18, 18, 18)
                .add(jButtonConfigDensidade)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(agrupamentoDensidade)
                    .add(jButtonConfigDensidade))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jScrollPane1)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(23, 78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        //função de distanicia
        if (frameKohonen.getOpEuclidiana().isSelected()) {
            distancia = "euclidiana";
        }
        if (frameKohonen.getOpGaussiana().isSelected()) {
            vizinhanca = "gaussiana";
        }
        //Funcao de Atualização
        if (frameKohonen.getOpExponencial().isSelected()) {
            atualiza = "exponencial";
        }
        if (frameKohonen.getOpLinear().isSelected()) {
            atualiza = "linear";
        }
        if (frameKohonen.getOpReciproca().isSelected()) {
            atualiza = "reciproca";
        }
        //Agrupamento
        if (agrupamentoDensidade.isSelected()) {
            agrupamento = "densidade";
            if (densidadeConfig == null) {
                densidadeConfig = new JFrameKohonenConfigDensidade();
            }
        }

        inicio.setEnabled(false);
        startKohonen();

        repaint();
    }//GEN-LAST:event_inicioActionPerformed

    private void campoGridXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_campoGridXStateChanged
//
    }//GEN-LAST:event_campoGridXStateChanged

    private void campoGridYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_campoGridYStateChanged
//
    }//GEN-LAST:event_campoGridYStateChanged

    private void campoIteracoesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_campoIteracoesStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIteracoesStateChanged

    private void bVisualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVisualizacaoActionPerformed
        FrameVisualization.getInstance().setDados(dados);
        FrameVisualization.getInstance().setVisible(true);
    }//GEN-LAST:event_bVisualizacaoActionPerformed

    private void jButtonConfigDensidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfigDensidadeActionPerformed
        if (densidadeConfig == null) {
            densidadeConfig = new JFrameKohonenConfigDensidade();
        }
        densidadeConfig.setVisible(true);
    }//GEN-LAST:event_jButtonConfigDensidadeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton agrupamentoDensidade;
    private javax.swing.JButton bVisualizacao;
    private javax.swing.JTextField campoAprendizagem;
    private javax.swing.JSpinner campoGridX;
    private javax.swing.JSpinner campoGridY;
    private javax.swing.JSpinner campoIteracoes;
    private javax.swing.JTextField campoRaio;
    private javax.swing.ButtonGroup grupoAprendizagem;
    private javax.swing.ButtonGroup grupoDistancia;
    private javax.swing.ButtonGroup grupoGrade;
    private javax.swing.ButtonGroup grupoVizinhanca;
    private javax.swing.JButton inicio;
    private javax.swing.JButton jButtonConfigDensidade;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables

    public void startKohonen() {
        gridX = Integer.parseInt(campoGridX.getValue().toString());
        gridY = Integer.parseInt(campoGridY.getValue().toString());

        raio = Integer.parseInt(campoRaio.getText());
        iteracoes = Integer.parseInt(campoIteracoes.getValue().toString());
        alfa = Float.parseFloat(campoAprendizagem.getText());

        rede = new RedeKohonen(gridX, gridY, raio, iteracoes, alfa, dados, distancia, vizinhanca, atualiza); //cria a Rede
        jProgressBar1.setMaximum(iteracoes);

        FrameVisualization.getInstance().setMaxStatus(iteracoes);
        FrameVisualization.getInstance().setLabel("Executando");

        t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < iteracoes; i++) {
                    atualizaStatus(i);
                    rede.startRede(i); //inicia o Kohonen
                    FrameVisualization.getInstance().setRede(rede);
                    repaint();
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PanelKohonen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                rede.carregaPadroes(); //carrega os padroes...
                //Calcula a matriz U
                OpMath math = new OpMath();
                matrizU = math.matrizU(gridX, gridY, rede);
                //
                FrameVisualization.getInstance().setVisualization(rede, matrizU);
                inicio.setEnabled(true);

                //AGRUPAMENTO
                clusterig();
            }
        };
        t.start();

    }

    public void clusterig() {
        ClusteringSOM cluster = new ClusteringSOM(rede);
        ArrayList<Cluster> clusters = new ArrayList<>();

        switch (agrupamento) {
            case "densidade":
                clusters = cluster.clusteringDensidade(Double.parseDouble(densidadeConfig.getCampoErro().getText()));
                break;
        }

        //imprime em tela o agrupamento realizado
        jTextArea.setText("");
        for (int i = 0; i < clusters.size(); i++) {
            jTextArea.append("Cluster " + i + ":\n");
            for (int j = 0; j < clusters.get(i).getNeuronios().size(); j++) {
                for (int k = 0; k < clusters.get(i).getNeuronios().get(j).getPadroes().size(); k++) {
                    jTextArea.append(clusters.get(i).getNeuronios().get(j).getPadroes().get(k).getNumero() + " ");

                }
            }
            jTextArea.append("\n");
        }
    }

    public void atualizaStatus(final int i) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jProgressBar1.setValue(i);
                FrameVisualization.setStatus(i);
            }
        });
    }

    public void carregaBase() {
        dados = new Base();
        double base[][] = new double[arrayListBases.get(arrayListBases.size() - 1).getInput().length][arrayListBases.get(arrayListBases.size() - 1).getInput()[0].length]; //= arrayListBases.get(arrayListBases.size() - 1).getInput();
        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < base[0].length; j++) {
                base[i][j] = Double.valueOf(arrayListBases.get(arrayListBases.size() - 1).getInput()[i][j] + "").doubleValue();
            }
        }
        padronizacao(base);

        int grupo = 0;
        for (int i = 0; i < base.length; i++) {
            Padrao p = new Padrao();
            p.setNumero(grupo);
            ++grupo;
            for (int j = 0; j < base[0].length; j++) {
                p.addAtributos(base[i][j]);

            }
            p.setGrupo(arrayListBases.get(arrayListBases.size() - 1).getOutput()[i].toString());
            dados.addDataSet(p);
        }

        FrameVisualization.getInstance().setDados(dados);
        FrameVisualization.getInstance().setRede(null);
        FrameVisualization.getInstance().setMatrizU(null);
        FrameVisualization.getInstance().repaint();
    }

    public void padronizacao(double matriz[][]) {
        double menor = Double.MAX_VALUE;
        double maior = Double.MIN_VALUE;
        int cont = 0;
        while (cont < matriz[0].length) {
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[i][cont] < menor) {
                    menor = matriz[i][cont];
                }

                if (matriz[i][cont] > maior) {
                    maior = matriz[i][cont];
                }
            }
            for (int i = 0; i < matriz.length; i++) {
                matriz[i][cont] -= menor;
            }
            maior -= menor;
            for (int i = 0; i < matriz.length; i++) {
                matriz[i][cont] /= maior;
            }
            cont++;
        }
    }

    public void addBase(interfaces.Base b) {
        arrayListBases.add(b);
        carregaBase();
    }

    public Base getDados() {
        return dados;
    }

    public static void setSleep(int sleep) {
        PanelKohonen.sleep = sleep;
    }
}
