/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.view.jpanel;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import moduledefault.clustering.kmeans.KMeansPrincipal;
import moduledefault.clustering.uteis.AvaliacaoAgrupamento;
import moduledefault.clustering.uteis.Padrao;
import moduledefault.clustering.uteis.Cluster;
import moduledefault.clustering.uteis.Operações_Mat;
import moduledefault.clustering.view.frames.JFrameHistoricoKmeans;
import moduledefault.clustering.view.frames.JFrameKmeans;
import moduledefault.clustering.visualization.JDialogData;
import moduledefault.clustering.visualization.TecnicasDispersao;

/**
 *
 * @author Mateus
 */
public class PanelKmeans extends javax.swing.JPanel {

    /**
     * Creates new form panelKmeans
     */
    int numK;
    JFrameKmeans frameKmeans;
    public static String[] nomeAtributos;
    StringBuffer buffer;
    int teste_distancia = 0;
    KMeansPrincipal k;
    Collection realClasses;
    ArrayList<KMeansPrincipal> listaObjetos;
    ArrayList<StringBuffer> listaBuffer;
    interfaces.Base base;
    static moduledefault.clustering.uteis.Base dados;
    static moduledefault.clustering.uteis.Base dadosOriginal;
    ArrayList<Cluster> clusters;
    AvaliacaoAgrupamento avaliacao;

    public PanelKmeans(interfaces.Base b, JFrameKmeans k) throws IOException {
        initComponents();
        base = b;
        startMatrizDados();
        frameKmeans = k;
        listaObjetos = new ArrayList<>();
        listaBuffer = new ArrayList<>();
//        visualizacao.setEnabled(false);
//        jButton2.setEnabled(false);
//        jButton1.setEnabled(false);
    }

    public void setNomeClasses(String[] a) {
        PanelKmeans.nomeAtributos = a;
    }

    public JFrameKmeans getFrameKmeans() {
        return frameKmeans;
    }

    public void setFrameKmeans(JFrameKmeans frameKmeans) {
        this.frameKmeans = frameKmeans;
    }

    public Collection getRealClasses() {
        return realClasses;
    }

    public void setRealClasses(Collection realClasses) {
        this.realClasses = realClasses;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButtonExecuta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxDistancias = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        visualizacao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        listResultados = new java.awt.List();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(718, 458));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jButtonExecuta.setText("Executar");
        jButtonExecuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExecutaActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Distância"));

        jLabel1.setText("Função de Distância:");

        jComboBoxDistancias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Chebyshev","CityBlock","Correlação de Kendall","Correlação de Pearson","Correlação de Spearman" ,"Cosseno", "Euclidiana", "Mahalanobis" }));

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

        jButton1.setText("Imprimir Histórico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        visualizacao.setText("Visualização");
        visualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizacaoActionPerformed(evt);
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
            .addComponent(listResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(listResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton2.setText("Visualizar Dados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExecuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(visualizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButtonExecuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(11, 11, 11)
                .addComponent(visualizacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExecutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExecutaActionPerformed

        this.jButtonExecuta.setEnabled(false);
        switch (this.jComboBoxDistancias.getSelectedIndex()) {
            case 0:
                JOptionPane.showMessageDialog(null, "Selecione uma Medida de Distância.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.jButtonExecuta.setEnabled(true);
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
            case 7:
                teste_distancia = 7;
                break;
            case 8:
                teste_distancia = 8;
                break;
            default:
                break;
        }
        this.numK = frameKmeans.getK();
        boolean paradaAutomatica = frameKmeans.isParadaAutomatica();
        boolean seedAleatorios = frameKmeans.isSeedAleatorios();
        int seeds = 0;
        if (!seedAleatorios) {
            seeds = frameKmeans.getSeeds();
        }
        int maxIteracoes = frameKmeans.getMaxIteracoes();
        int iteracoesParada = frameKmeans.getIteracoes();
        k = new KMeansPrincipal(dados, numK, paradaAutomatica, seedAleatorios, seeds, maxIteracoes, iteracoesParada, teste_distancia);
        k.start();
        formaClusters(k.getM(), numK);
        imprimiAgrupamento();
        getBuffer().append(k.imprimi(clusters));
        getBuffer().append("\n\nMatriz Confusão:\n");
        int[][] mconfusao = avaliacao.getMconfusao();
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
        jTextArea3.setText(getBuffer().toString());
        listaObjetos.add(k);
        setListaResultados();
        this.jButtonExecuta.setEnabled(true);
    }//GEN-LAST:event_jButtonExecutaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imprimiAgrupamento();
        getBuffer().append(k.imprimiHistorico(clusters));
        getBuffer().append("\n\nMatriz Confusão:\n\n");
        int[][] mconfusao = k.mConfusao();
        char classe = 'a';
        for (int i = 0; i < mconfusao.length; i++) {
            getBuffer().append(classe + "\t");
            ++classe;
        }
        getBuffer().append("\n");
        classe = 'a';
        for (int i = 0; i < mconfusao.length; i++) {
            for (int j = 0; j < mconfusao.length; j++) {
                getBuffer().append(mconfusao[i][j] + "\t");
                if (j == mconfusao[0].length - 1) {
                    getBuffer().append("\t" + classe);// " = " + nomeClasses[i]);
                    ++classe;
                }
            }
            getBuffer().append("\n");
        }
        JFrameHistoricoKmeans hK = new JFrameHistoricoKmeans(getBuffer());
        hK.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void visualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizacaoActionPerformed
//        for (int i = 0; i < dados.getDataSet().size(); i++) {
//            for (int j = 0; j < dados.getAtributos().size()-1; j++) {
//                System.out.print("");
//            }
//        }

        TecnicasDispersao.getInstance().setSetou(false);
        TecnicasDispersao.getInstance().setMatrizDados(dados);
        TecnicasDispersao.getInstance().setCluster(clusters);
        TecnicasDispersao.getInstance().setQntGrupos(numK);
        TecnicasDispersao.getInstance().setCombos();
        TecnicasDispersao.getInstance().setVisible(true);
        TecnicasDispersao.getInstance().inicia();
    }//GEN-LAST:event_visualizacaoActionPerformed

    private void listResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listResultadosMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (listResultados.getSelectedIndex() != -1) {
                StringBuffer text = listaBuffer.get(listResultados.getSelectedIndex());
                jTextArea3.setText(text.toString());
            }
        }
    }//GEN-LAST:event_listResultadosMouseClicked

    private void listResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listResultadosActionPerformed
    }//GEN-LAST:event_listResultadosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String[] atributos = new String[dadosOriginal.getAtributos().size() + 2];
        atributos[0] = "ID";
        for (int j = 0; j < dadosOriginal.getAtributos().size(); j++) {
            atributos[j + 1] = dadosOriginal.getAtributos().get(j);
        }
        atributos[atributos.length - 1] = "Cluster_ID";

        Object[][] data = new Object[dadosOriginal.getDataSet().size()][dadosOriginal.getDataSet().get(0).getAtributos().size() + 3];
        for (int i = 0; i < dadosOriginal.getDataSet().size(); i++) {
            data[i][0] = dadosOriginal.getDataSet().get(i).getNumero();
        }
        for (int i = 0; i < dadosOriginal.getDataSet().size(); i++) {
            for (int j = 0; j < dadosOriginal.getDataSet().get(0).getAtributos().size(); j++) {
                data[i][j + 1] = dadosOriginal.getDataSet().get(i).getAtributos().get(j);
            }
        }
        for (int i = 0; i < dadosOriginal.getDataSet().size(); i++) {
            data[i][dadosOriginal.getDataSet().get(0).getAtributos().size() + 1] = dadosOriginal.getDataSet().get(i).getClasse();
        }
        for (int i = 0; i < clusters.size(); i++) {
            for (int j = 0; j < clusters.get(i).getGrupo().size(); j++) {
                data[clusters.get(i).getGrupo().get(j).getNumero()][data[0].length - 1] = clusters.get(i).getNomeGrupo();
            }
        }
        new JDialogData((Frame) frameKmeans, true, data, atributos).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonExecuta;
    private static javax.swing.JComboBox jComboBoxDistancias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea3;
    private java.awt.List listResultados;
    private javax.swing.JButton visualizacao;
    // End of variables declaration//GEN-END:variables

    public void startMatrizDados() {
        dados = new moduledefault.clustering.uteis.Base();
        double matriz[][] = new double[base.getInput().length][base.getInput()[0].length]; //= arrayListBases.get(arrayListBases.size() - 1).getInput();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = Double.valueOf(base.getInput()[i][j] + "").doubleValue();
            }
        }

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
        dadosOriginal = dados.copy();
        Operações_Mat m = new Operações_Mat();
        m.Padronização(dados);

//        System.out.println("linhas = " + dados.getDataSet().size());
//        System.out.println("colunas = " + (dados.getAtributos().size() - 1));
        TecnicasDispersao.getInstance().setSetou(false);
        TecnicasDispersao.getInstance().setMatrizDados(dados);
        TecnicasDispersao.getInstance().setQntGrupos(numK);
        TecnicasDispersao.getInstance().setCombos();

    }

    public static List<String> getNomeClasses() {
        return dados.getClasses();
    }

    void imprimiAgrupamento() {
        StringBuffer buffer1 = new StringBuffer();
        setBuffer(buffer1);
        getBuffer().append("===================== Informações =====================");
        getBuffer().append("\n\t\t\tYADMT.Clustering.AC");
        getBuffer().append("\n\t Base: " + dados.getNome());
        getBuffer().append("\n\t Número de Instâncias: " + dados.getDataSet().size());
        getBuffer().append("\n\t Atributos: " + (dados.getAtributos().size() - 1));
        getBuffer().append("\n\t Classes:");
        for (int i = 0; i < dados.getClasses().size(); i++) {
            getBuffer().append("\n\t\t" + dados.getClasses().get(i));
        }
        getBuffer().append("\n\tParâmetros: " + frameKmeans.getK() + ";" + frameKmeans.isParadaAutomatica() + ";" + frameKmeans.getIteracoes() + ";"
                + frameKmeans.getMaxIteracoes() + ";" + frameKmeans.isSeedAleatorios() + ";" + frameKmeans.getSeeds());
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
        getBuffer().append("\n");
        avaliacao = new AvaliacaoAgrupamento(clusters, dados.getClasses(), dados);
        getBuffer().append("\n\tMedida R: "+avaliacao.getIndiceAleatorio());
        getBuffer().append("\n\tMedida F: " + String.valueOf(avaliacao.getMedidaF()));
        getBuffer().append("\n\tPorcentagem de Acerto: " + String.valueOf(avaliacao.getAcerto()));
        getBuffer().append("\n\tÍndice Idunn: " + String.valueOf(avaliacao.getIndiceDunn()));
        getBuffer().append("\n\tVariância Total: " + String.valueOf(avaliacao.getVariancia()));

    }

    private void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }

    private StringBuffer getBuffer() {
        return this.buffer;
    }

    private void setListaResultados() {
        PanelKmeans.ClusteringText text = new PanelKmeans.ClusteringText();
        String s = text.toString();
        text.setJTextArea(jTextArea3);
        listResultados.add(s);
        listaBuffer.add(getBuffer());
    }

    public void attBase(interfaces.Base get) {
        base = get;
        startMatrizDados();
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
//        System.out.println("mpos = ");
//        for (int i = 0; i < mpos.length; i++) {
//            for (int j = 0; j < mpos[0].length; j++) {
//                System.out.print(mpos[i][j] + " ");
//            }
//            System.out.println("");
//        }
        int grupoInicial = mpos[1][0];
        int iterator = 0;
        int cont = 0;
        for (int i = 0; i < numGrupos; i++) {
            for (int j = iterator; j < mpos[0].length; j++) {
                if (mpos[1][j] == grupoInicial) {
                    clusters.get(i).addPadrao(dados.getDataSet().get(mpos[0][j]));
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
            return formatter.format(date) + " - K-means";

        }
    }
}
//     String[] nomesColunas = new String[dados.getAtributos().size() + 2];
//        nomesColunas[0] = "ID";
//        for (int i = 0; i < dados.getAtributos().size(); i++) {
//            nomesColunas[i + 1] = dados.getAtributos().get(i);
//        }
//        nomesColunas[dados.getAtributos().size() + 2] = "Cluster";
//        DefaultTableModel modelo = new DefaultTableModel(nomesColunas, dados.getDataSet().size());
//        modelo.setNumRows(0);
//        JTable tabelaBase = new JTable();
//        tabelaBase.setModel(modelo);
//        String[] temp = new String[nomesColunas.length];
//        for (int i = 0; i < clusters.size(); i++) {
//            for (int j = 0; j < clusters.get(i).getGrupo().size(); j++) {
//                temp[0] = clusters.get(i).getGrupo().get(j).getNumero() + "";
//                for (int l = 0; l < clusters.get(i).getGrupo().get(j).getAtributos().size(); l++) {
//                    temp[l + 1] = clusters.get(i).getGrupo().get(j).getAtributos().get(l) + "";
//                }
//                temp[clusters.get(i).getGrupo().get(j).getAtributos().size() + 1] = clusters.get(i).getGrupo().get(j).getClasse();
//                temp[clusters.get(i).getGrupo().get(j).getAtributos().size() + 2] = clusters.get(i).getNomeGrupo();
//                modelo.addRow(temp);
//            }
//        }
//        JFrame frameTabela = new JFrame("Tabela de Resultados");
//        frameTabela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        JPanel panel = new JPanel();
//        JScrollPane scroll = new JScrollPane();
//        scroll.setSize(tabelaBase.getWidth(), 700);
//        scroll.setViewportView(tabelaBase);
//        panel.add(scroll);
//        frameTabela.add(panel);
//        frameTabela.pack();
//        frameTabela.setLocationRelativeTo(null);
//        frameTabela.setVisible(true);

