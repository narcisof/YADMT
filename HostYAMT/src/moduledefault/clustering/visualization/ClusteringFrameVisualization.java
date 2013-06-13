/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import javax.swing.JPanel;
import moduledefault.clustering.aco.ACOClustering;
import moduledefault.clustering.uteis.MatrizDados;

/**
 *
 * @author Mateus
 */
public final class ClusteringFrameVisualization extends javax.swing.JFrame {

    /**
     * Creates new form ClusteringFrameVisualization
     */
    private static GraficoDispersao GD;
    private static ClusteringFrameVisualization INSTANCE;
    private static MatrizDados dados;
    private static ACOClustering aco;
    private static double matrizDados[][];
    private static int linhas;
    private static int colunas;
    private static int matrizPadroes[][];

    private static void setFormiga(ACOClustering a) {
        if (a != null) {
            aco = a;
            linhas = dados.getDimensão_matriz();
            colunas = dados.getDimensão_matriz();
            matrizDados = dados.getMatriz_dados();
        }
    }

    private static void dispersao() {
        if (GD == null) {
            GD = new GraficoDispersao(getMatrizPadroes());
        }
        GD.setSize(fundoDispersão.getWidth(), fundoDispersão.getHeight());
        fundoDispersão.add(GD);
        System.out.println("entrou aqui");
        fundoDispersão.repaint();
    }

    public static void setDispersao(int[][] a) {
        if (GD == null) {
            GD = new GraficoDispersao(a);
        }
        GD.setACO(a);
    }

    private static void analisaBotoes() {
        if(graficoDispersao.isSelected()){
            dispersao();
        }
    }

    public ClusteringFrameVisualization() {
        initComponents();
        repaint();
    }

    public static synchronized ClusteringFrameVisualization getInstance(ACOClustering a) {
        if (INSTANCE == null) {
            INSTANCE = new ClusteringFrameVisualization();
            setFormiga(a);
           analisaBotoes();
              //dispersao();
        } else {
        }
        INSTANCE.repaint();
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGuias = new javax.swing.JTabbedPane();
        panelGraficoDispersao = new javax.swing.JPanel();
        graficoDispersao = new javax.swing.JCheckBox();
        grafoDispersao = new javax.swing.JCheckBox();
        dispersaoCorrelacao = new javax.swing.JCheckBox();
        fundoDispersão = new javax.swing.JPanel();
        panelDistribuicao = new javax.swing.JPanel();
        segmentoRegular = new javax.swing.JCheckBox();
        segmentoCircular = new javax.swing.JCheckBox();
        fundoDistribuicao = new javax.swing.JPanel();
        panelProjecoesGeometricas = new javax.swing.JPanel();
        coordenadasParalelas2D = new javax.swing.JCheckBox();
        coordenadasParalelas3D = new javax.swing.JCheckBox();
        andrewCurve = new javax.swing.JCheckBox();
        gravitationalForce = new javax.swing.JCheckBox();
        fundoProjecoes = new javax.swing.JPanel();
        panelDendograma = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        graficoDispersao.setText("Gráfico de Dispersão");
        graficoDispersao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficoDispersaoActionPerformed(evt);
            }
        });

        grafoDispersao.setText("Grafo de Dispersão");
        grafoDispersao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grafoDispersaoActionPerformed(evt);
            }
        });

        dispersaoCorrelacao.setText("Dispersão de Correlação");
        dispersaoCorrelacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispersaoCorrelacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fundoDispersãoLayout = new javax.swing.GroupLayout(fundoDispersão);
        fundoDispersão.setLayout(fundoDispersãoLayout);
        fundoDispersãoLayout.setHorizontalGroup(
            fundoDispersãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fundoDispersãoLayout.setVerticalGroup(
            fundoDispersãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelGraficoDispersaoLayout = new javax.swing.GroupLayout(panelGraficoDispersao);
        panelGraficoDispersao.setLayout(panelGraficoDispersaoLayout);
        panelGraficoDispersaoLayout.setHorizontalGroup(
            panelGraficoDispersaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGraficoDispersaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGraficoDispersaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fundoDispersão, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelGraficoDispersaoLayout.createSequentialGroup()
                        .addComponent(graficoDispersao)
                        .addGap(18, 18, 18)
                        .addComponent(grafoDispersao)
                        .addGap(18, 18, 18)
                        .addComponent(dispersaoCorrelacao)
                        .addGap(0, 334, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGraficoDispersaoLayout.setVerticalGroup(
            panelGraficoDispersaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGraficoDispersaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGraficoDispersaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(graficoDispersao)
                    .addComponent(grafoDispersao)
                    .addComponent(dispersaoCorrelacao))
                .addGap(18, 18, 18)
                .addComponent(fundoDispersão, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelGuias.addTab("Dispersão", panelGraficoDispersao);

        segmentoRegular.setText("Segmento Retangular");

        segmentoCircular.setText("Segmento Circular");

        javax.swing.GroupLayout fundoDistribuicaoLayout = new javax.swing.GroupLayout(fundoDistribuicao);
        fundoDistribuicao.setLayout(fundoDistribuicaoLayout);
        fundoDistribuicaoLayout.setHorizontalGroup(
            fundoDistribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fundoDistribuicaoLayout.setVerticalGroup(
            fundoDistribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDistribuicaoLayout = new javax.swing.GroupLayout(panelDistribuicao);
        panelDistribuicao.setLayout(panelDistribuicaoLayout);
        panelDistribuicaoLayout.setHorizontalGroup(
            panelDistribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDistribuicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDistribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fundoDistribuicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDistribuicaoLayout.createSequentialGroup()
                        .addComponent(segmentoRegular)
                        .addGap(18, 18, 18)
                        .addComponent(segmentoCircular)
                        .addGap(0, 495, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDistribuicaoLayout.setVerticalGroup(
            panelDistribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDistribuicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDistribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(segmentoRegular)
                    .addComponent(segmentoCircular))
                .addGap(18, 18, 18)
                .addComponent(fundoDistribuicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelGuias.addTab("Distribuição de Pixels", panelDistribuicao);

        coordenadasParalelas2D.setText("Coordenadas Paralelas 2D");

        coordenadasParalelas3D.setText("Coordenadas Paralelas 3D");

        andrewCurve.setText("Andrew's Curve");

        gravitationalForce.setText("Gravitational Force");

        javax.swing.GroupLayout fundoProjecoesLayout = new javax.swing.GroupLayout(fundoProjecoes);
        fundoProjecoes.setLayout(fundoProjecoesLayout);
        fundoProjecoesLayout.setHorizontalGroup(
            fundoProjecoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fundoProjecoesLayout.setVerticalGroup(
            fundoProjecoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelProjecoesGeometricasLayout = new javax.swing.GroupLayout(panelProjecoesGeometricas);
        panelProjecoesGeometricas.setLayout(panelProjecoesGeometricasLayout);
        panelProjecoesGeometricasLayout.setHorizontalGroup(
            panelProjecoesGeometricasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProjecoesGeometricasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProjecoesGeometricasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fundoProjecoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelProjecoesGeometricasLayout.createSequentialGroup()
                        .addComponent(coordenadasParalelas2D)
                        .addGap(18, 18, 18)
                        .addComponent(coordenadasParalelas3D)
                        .addGap(18, 18, 18)
                        .addComponent(andrewCurve)
                        .addGap(18, 18, 18)
                        .addComponent(gravitationalForce)
                        .addGap(0, 181, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelProjecoesGeometricasLayout.setVerticalGroup(
            panelProjecoesGeometricasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProjecoesGeometricasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProjecoesGeometricasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coordenadasParalelas2D)
                    .addComponent(coordenadasParalelas3D)
                    .addComponent(andrewCurve)
                    .addComponent(gravitationalForce))
                .addGap(18, 18, 18)
                .addComponent(fundoProjecoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelGuias.addTab("Projeções Geométricas", panelProjecoesGeometricas);

        javax.swing.GroupLayout panelDendogramaLayout = new javax.swing.GroupLayout(panelDendograma);
        panelDendograma.setLayout(panelDendogramaLayout);
        panelDendogramaLayout.setHorizontalGroup(
            panelDendogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        panelDendogramaLayout.setVerticalGroup(
            panelDendogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );

        panelGuias.addTab("Distribuição Hierárquica", panelDendograma);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGuias)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGuias)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void graficoDispersaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficoDispersaoActionPerformed
        if (graficoDispersao.isSelected()) {
            grafoDispersao.setEnabled(false);
            dispersaoCorrelacao.setEnabled(false);
        } else {
            grafoDispersao.setEnabled(true);
            dispersaoCorrelacao.setEnabled(true);
        }
        analisaBotoes();
    }//GEN-LAST:event_graficoDispersaoActionPerformed

    private void grafoDispersaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grafoDispersaoActionPerformed
        if (grafoDispersao.isSelected()) {
            graficoDispersao.setEnabled(false);
            dispersaoCorrelacao.setEnabled(false);
        } else {
            graficoDispersao.setEnabled(true);
            dispersaoCorrelacao.setEnabled(true);
        }
        analisaBotoes();
    }//GEN-LAST:event_grafoDispersaoActionPerformed

    private void dispersaoCorrelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispersaoCorrelacaoActionPerformed
        if (dispersaoCorrelacao.isSelected()) {
            graficoDispersao.setEnabled(false);
            grafoDispersao.setEnabled(false);
        } else {
            graficoDispersao.setEnabled(true);
            grafoDispersao.setEnabled(true);
        }
        analisaBotoes();
    }//GEN-LAST:event_dispersaoCorrelacaoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox andrewCurve;
    private javax.swing.JCheckBox coordenadasParalelas2D;
    private javax.swing.JCheckBox coordenadasParalelas3D;
    private javax.swing.JCheckBox dispersaoCorrelacao;
    private static javax.swing.JPanel fundoDispersão;
    private static javax.swing.JPanel fundoDistribuicao;
    private static javax.swing.JPanel fundoProjecoes;
    private static javax.swing.JCheckBox graficoDispersao;
    private javax.swing.JCheckBox grafoDispersao;
    private javax.swing.JCheckBox gravitationalForce;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel panelDendograma;
    private javax.swing.JPanel panelDistribuicao;
    private javax.swing.JPanel panelGraficoDispersao;
    private javax.swing.JTabbedPane panelGuias;
    private javax.swing.JPanel panelProjecoesGeometricas;
    private javax.swing.JCheckBox segmentoCircular;
    private javax.swing.JCheckBox segmentoRegular;
    // End of variables declaration//GEN-END:variables

    public static JPanel getFundoDispersão() {
        return fundoDispersão;
    }

    public void setFundoDispersão(JPanel fundoDispersão) {
        this.fundoDispersão = fundoDispersão;
    }

    public static JPanel getFundoDistribuicao() {
        return fundoDistribuicao;
    }

    public void setFundoDistribuicao(JPanel fundoDistribuicao) {
        this.fundoDistribuicao = fundoDistribuicao;
    }

    public static JPanel getFundoProjecoes() {
        return fundoProjecoes;
    }

    public void setFundoProjecoes(JPanel fundoProjecoes) {
        this.fundoProjecoes = fundoProjecoes;
    }

    public static MatrizDados getDados() {
        return dados;
    }

    public static void setDados(MatrizDados d) {
        dados = d;
    }

    public static void setMatrizPadroes(int[][] m) {
        matrizPadroes = m;
    }

    public static int[][] getMatrizPadroes() {
        return matrizPadroes;
    }
}
