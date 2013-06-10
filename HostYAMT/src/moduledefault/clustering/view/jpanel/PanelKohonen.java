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
import moduledefault.clustering.kohonen.OpMath;
import moduledefault.clustering.kohonen.Padrao;
import moduledefault.clustering.kohonen.RedeKohonen;
import moduledefault.clustering.kohonen.visualization.FrameVisualization;

/**
 *
 * @author Thiago Magalhães Faino
 */
public final class PanelKohonen extends javax.swing.JPanel {

    //Variaveis Kohonen
    private ArrayList<interfaces.Base> arrayListBases = new ArrayList<>();
    private Base dados = new Base();
    private RedeKohonen rede = null;
    private int gridX = 0;
    private int gridY = 0;
    private String distancia;
    private String vizinhanca;
    private String atualiza;
    private int raio;
    private int iteracoes;
    private float alfa;
    //
    private double[][] matrizU;
    private static RedeKohonen redeaux;
    //
    Thread t;
    private static int sleep = 0;
    
    public PanelKohonen(ArrayList<interfaces.Base> b) {
        initComponents();

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
        jLabel13 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoAprendizagem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        opLinear = new javax.swing.JRadioButton();
        opReciproca = new javax.swing.JRadioButton();
        opExponencial = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        opEuclidiana = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        opGaussiana = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        campoRaio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        campoIteracoes = new javax.swing.JSpinner();
        bVisualizacao = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

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

        jLabel13.setText("Tipo da Grade:");

        grupoGrade.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Retangular");

        grupoGrade.add(jRadioButton2);
        jRadioButton2.setText("Hexagonal");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel13)
                    .add(jLabel4)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(campoGridX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jRadioButton1)
                    .add(jRadioButton2)
                    .add(campoGridY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel13)
                    .add(jRadioButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jRadioButton2)
                .add(1, 1, 1)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(campoGridX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campoGridY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Aprendizagem"));

        jLabel2.setText("Aprendizagem inicial:");

        campoAprendizagem.setText("0.1");

        jLabel11.setText("Função de Atualização:");

        grupoAprendizagem.add(opLinear);
        opLinear.setText("Linear");

        grupoAprendizagem.add(opReciproca);
        opReciproca.setText("Recíproca");

        grupoAprendizagem.add(opExponencial);
        opExponencial.setSelected(true);
        opExponencial.setText("Exponencial");

        org.jdesktop.layout.GroupLayout jPanel10Layout = new org.jdesktop.layout.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel11)
                    .add(jLabel2))
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(opLinear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(opReciproca)
                    .add(jPanel10Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(campoAprendizagem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(opExponencial)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel10Layout.createSequentialGroup()
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campoAprendizagem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(opExponencial))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(opReciproca)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(opLinear))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Distância"));

        grupoDistancia.add(opEuclidiana);
        opEuclidiana.setSelected(true);
        opEuclidiana.setText("Euclidiana");

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(opEuclidiana)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .add(opEuclidiana)
                .add(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Vizinhança"));

        grupoVizinhanca.add(opGaussiana);
        opGaussiana.setSelected(true);
        opGaussiana.setText("Gaussiana");

        jLabel3.setText("Raio inicial:");

        campoRaio.setText("2");

        jLabel12.setText("Função de Vizinhança:");

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel8Layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(18, 18, 18)
                        .add(campoRaio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel8Layout.createSequentialGroup()
                        .add(jLabel12)
                        .add(18, 18, 18)
                        .add(opGaussiana)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel8Layout.createSequentialGroup()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campoRaio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(opGaussiana)
                    .add(jLabel12)))
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
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(campoIteracoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE))
                            .add(inicio, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campoIteracoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(bVisualizacao)
                    .add(inicio))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        if (opEuclidiana.isSelected()) {
            distancia = "euclidiana";
        }
        if (opGaussiana.isSelected()) {
            vizinhanca = "gaussiana";
        }
        //Funcao de Atualização
        if (opExponencial.isSelected()) {
            atualiza = "exponencial";
        }
        if (opLinear.isSelected()) {
            atualiza = "linear";
        }
        if (opReciproca.isSelected()) {
            atualiza = "reciproca";
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
        FrameVisualization.setDados(dados);
        FrameVisualization.getInstance(rede, matrizU).setVisible(true);
    }//GEN-LAST:event_bVisualizacaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton opEuclidiana;
    private javax.swing.JRadioButton opExponencial;
    private javax.swing.JRadioButton opGaussiana;
    private javax.swing.JRadioButton opLinear;
    private javax.swing.JRadioButton opReciproca;
    // End of variables declaration//GEN-END:variables

    public void startKohonen() {
        gridX = Integer.parseInt(campoGridX.getValue().toString());
        gridY = Integer.parseInt(campoGridY.getValue().toString());

        raio = Integer.parseInt(campoRaio.getText());
        iteracoes = Integer.parseInt(campoIteracoes.getValue().toString());
        alfa = Float.parseFloat(campoAprendizagem.getText());

        rede = new RedeKohonen(gridX, gridY, raio, iteracoes, alfa, dados, distancia, vizinhanca, atualiza); //cria a Rede
        jProgressBar1.setMaximum(iteracoes);
        
        FrameVisualization.setMaxStatus(iteracoes);
        FrameVisualization.setLabel("Executando");
        
        t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < iteracoes; i++) {
                    vai(i);
                    rede.startRede(i); //inicia o Kohonen
                    FrameVisualization.setRede(rede);
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
                FrameVisualization.getInstance(rede, matrizU);
                inicio.setEnabled(true);
                
            }
        };
        t.start();
        
    }

    public void vai(final int i) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jProgressBar1.setValue(i);
                FrameVisualization.setStatus(i);
            }
        });
    }

    public void carregaBase() {
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


    }

    public void padronizacao(double matriz[][]) {
        double menor;
        double maior;
        int cont = 0;
        while (cont < matriz[0].length) {
            menor = 10000;
            maior = -10000;
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

    public Base getDados() {
        return dados;
    }

    public static void setSleep(int sleep) {
        PanelKohonen.sleep = sleep;
    }
    
}
