/*
 * JPResultadoADGrafico.java
 *
 * Created on 23 de Setembro de 2008, 14:09
 */
package moduledefault.classify.c45.rafael.view.jpanel;

//import a_Visao.Interface.IJPResultadoAlgoritmo;
import moduledefault.classify.c45.rafael.view.jpanel.graph.AreaDesenho;
import moduledefault.classify.c45.rafael.view.jpanel.graph.Aresta;
import moduledefault.classify.c45.rafael.view.jpanel.graph.MapaGrafico;
import moduledefault.classify.c45.rafael.view.jpanel.graph.Propriedades;
import moduledefault.classify.c45.rafael.view.jpanel.graph.Vertice;
//import b_Controle.FacadeSwing;
import moduledefault.classify.c45.rafael.AD;
//import c_Modelo.Regras.FacadeFactory;
import moduledefault.classify.c45.rafael.jadti.DecisionTree;
import moduledefault.classify.c45.rafael.jadti.KnownSymbolicValue;
import moduledefault.classify.c45.rafael.jadti.LeafNode;
import moduledefault.classify.c45.rafael.jadti.Node;
import moduledefault.classify.c45.rafael.jadti.NumericalTest;
import moduledefault.classify.c45.rafael.jadti.ScoreTestNode;
import java.awt.Dimension;
import java.awt.Point;
import moduledefault.classify.c45.rafael.jadti.Test;

/**
 *
 * @author  rafael
 */
public class JPResultadoADGrafico extends javax.swing.JPanel /* implements IJPResultadoAlgoritmo */{

    public static final int dh = 100;
    public static final int dv = 100;
    int folha;
    int maiorNivel;
//    FacadeSwing facadeSwing;
    AreaDesenho desenho;
    MapaGrafico mapa;
    AD ad;

    /** Creates new form JPResultadoADGrafico */
    public JPResultadoADGrafico() {
        initComponents();
//        facadeSwing = FacadeFactory.getFacadeSwing();

    //this.revalidate();
    //facadeSwing.getTeste().pack();
    }

    public void inicializaInterface(AD ad) {
        desenho = (AreaDesenho) jPanel1;
        desenho.setLocation(0, 0);
        desenho.setEditavel(true);
        desenho.novoGrafo();
        mapa = desenho.getGrafoGrafico();
//        ad = (AD) facadeSwing.getClassificacao();
        DecisionTree arvore = ad.getArvore();
        //int nivel = ad.nNodes();
        //System.out.println("nivel: " + nivel);
        folha = maiorNivel = 1;
        //recursivo(null, arvore.root(), dh * (int) Math.pow(2, nivel), 50, nivel - 1, 0);
        recursivo(arvore.root(), 1);
        desenho.setPreferredSize(new Dimension(dh * folha, (maiorNivel + 1) * dv));
        //desenho.revalidate();
        jScrollPane1.revalidate();
        if (maiorNivel > 15) {
            desenho.setZoom(0.125);
        } else if (maiorNivel > 10) {
            desenho.setZoom(0.25);
        } else if (maiorNivel > 5) {
            desenho.setZoom(0.5);
        } else {
            desenho.setZoom(1);
        }
        desenho.setFolha(folha);
        desenho.setMaiorNivel(maiorNivel);
        jLZoom.setText(desenho.getZoom() + "x");
    }

    private Vertice recursivo(Node node, int nivel) {
        Vertice filho1, filho0, vertice;
        if (node instanceof LeafNode) {
            vertice = desenho.inserirVertice(new Point((folha++) * dh, dv * nivel), Vertice.TIPO_COR_1);
            KnownSymbolicValue d = ((LeafNode) node).goalValue();
            vertice.setRotulo("" + d.intValue);
        } else {
            filho1 = recursivo(node.son(1), nivel + 1);
            filho0 = recursivo(node.son(0), nivel + 1);
            vertice = desenho.inserirVertice(new Point((filho0.getPo().x + filho1.getPo().x) / 2, dv * nivel), Vertice.TIPO_COR_0);

//            Aresta a = new Aresta(new Propriedades(), ((NumericalTest) ((ScoreTestNode) node).test()).issueToString(1));
            Aresta a = new Aresta(new Propriedades(), ((ScoreTestNode) node).test().issueToString(1));
            a.setIdOrigem(vertice.getIdentificador());
            a.setPOrigem(vertice.getPo());
            a.setIdDestino(filho1.getIdentificador());
            a.setPDestino(filho1.getPo());
            mapa.inserirAresta(a);

//            a = new Aresta(new Propriedades(), ((NumericalTest) ((ScoreTestNode) node).test()).issueToString(0));
            a = new Aresta(new Propriedades(), ((ScoreTestNode) node).test().issueToString(0));
            a.setIdOrigem(vertice.getIdentificador());
            a.setPOrigem(vertice.getPo());
            a.setIdDestino(filho0.getIdentificador());
            a.setPDestino(filho0.getPo());
            mapa.inserirAresta(a);

            vertice.setRotulo("" + ((ScoreTestNode) node).test().toString());
        }
        if (nivel > maiorNivel) {
            maiorNivel = nivel;
        }
        return vertice;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">   
/*    private void recursivo(Vertice pai, Node node, int x, int y, int nivel, int k) {
    Vertice v;
    Aresta a;
    if (node.isLeaf()) {
    LeafNode leaf = (LeafNode) node;
    KnownSymbolicValue d = leaf.goalValue();
    //s += ("Classe = " + d.intValue) + "\n";
    v = desenho.inserirVertice(new Point(x, y), Vertice.TIPO_COR_1);
    v.setRotulo("" + d.intValue);
    if (pai != null) {
    a = new Aresta(new Propriedades(), ((NumericalTest) ((ScoreTestNode) node.getFather()).test()).issueToString(k));
    a.setIdOrigem(pai.getIdentificador());
    a.setPOrigem(pai.getPo());
    a.setIdDestino(v.getIdentificador());
    a.setPDestino(v.getPo());
    mapa.inserirAresta(a);
    }
    
    } else {
    ScoreTestNode test = (ScoreTestNode) node;
    Test t = test.test();
    //s += ("Se (" + t.toString() + ") então") + "\n";
    
    v = desenho.inserirVertice(new Point(x, y), Vertice.TIPO_COR_0);
    v.setRotulo(t.toString());
    if (pai != null) {
    a = new Aresta(new Propriedades(), ((NumericalTest) ((ScoreTestNode) node.getFather()).test()).issueToString(k));
    a.setIdOrigem(pai.getIdentificador());
    a.setPOrigem(pai.getPo());
    a.setIdDestino(v.getIdentificador());
    a.setPDestino(v.getPo());
    //a.set
    mapa.inserirAresta(a);
    }
    if (test.son(1) != null) {
    recursivo(v, test.son(1), x - (dh * (int) Math.pow(2, nivel)), y + dv, nivel - 1, 1);
    }
    if (test.son(0) != null) {
    recursivo(v, test.son(0), x + (dh * (int) Math.pow(2, nivel)), y + dv, nivel - 1, 0);
    }
    }
    }*/// </editor-fold>  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        /*
        jPanel1 = new javax.swing.JPanel();
        */ jPanel1=new AreaDesenho(jScrollPane1);
        jLabel1 = new javax.swing.JLabel();
        jBZoomIn = new javax.swing.JButton();
        jBZoomOut = new javax.swing.JButton();
        jLZoom = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(798, 598));
        setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(774, 549));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(774, 549));
        jScrollPane1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane1MouseWheelMoved(evt);
            }
        });

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jPanel2.setMinimumSize(new java.awt.Dimension(772, 547));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(null);
        jPanel1.setMinimumSize(new java.awt.Dimension(772, 547));
        jPanel1.setPreferredSize(new java.awt.Dimension(772, 547));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jPanel1, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 750;
        gridBagConstraints.ipady = 525;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 12, 12);
        add(jScrollPane1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12));
        jLabel1.setText("Zoom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 0, 0);
        add(jLabel1, gridBagConstraints);

        jBZoomIn.setFont(new java.awt.Font("Calibri", 0, 12));
        jBZoomIn.setText("+");
        jBZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBZoomInActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(jBZoomIn, gridBagConstraints);

        jBZoomOut.setFont(new java.awt.Font("Calibri", 0, 12));
        jBZoomOut.setText("-");
        jBZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBZoomOutActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(jBZoomOut, gridBagConstraints);

        jLZoom.setFont(new java.awt.Font("Calibri", 0, 12));
        jLZoom.setText("Zoom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 0, 0);
        add(jLZoom, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
//
    private void jScrollPane1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane1MouseWheelMoved
        if (evt.isControlDown()) {
            if (evt.getWheelRotation() < 0) {
                jBZoomInActionPerformed(null);
            } else {
                jBZoomOutActionPerformed(null);
            }
        }
    }//GEN-LAST:event_jScrollPane1MouseWheelMoved

    private void jBZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBZoomInActionPerformed
        desenho.zoomIn();
        jLZoom.setText(desenho.getZoom() + "x");
}//GEN-LAST:event_jBZoomInActionPerformed

    private void jBZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBZoomOutActionPerformed
        desenho.zoomOut();
        jLZoom.setText(desenho.getZoom() + "x");
}//GEN-LAST:event_jBZoomOutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBZoomIn;
    private javax.swing.JButton jBZoomOut;
    private javax.swing.JLabel jLZoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    //
//
//    public String getRelatorio() {
//        return "Árvore de Decisão:\n" +
//                "Entropia: " + ad.getEntropia() + "\n" +
//                "Score: " + ad.getScore() + "\n\n" +
//                ad.getArvoreString();
//    }
}
