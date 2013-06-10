/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelExtracao.java
 *
 * Created on 07/10/2012, 23:35:22
 */
package view.jpanel;

import controller.FacadeHost;
import controller.Host;
import interfaces.Base;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import moduledefault.pca.Pca;
import util.SalvarARFF;

/**
 *
 * @author TyTu
 */
public class JPanelExtracao extends javax.swing.JPanel implements Observer {

    private ArrayList<Base> arrayListBases = new ArrayList<Base>();
    private Pca pca;

    /** Creates new form JPanelExtracao */
    public JPanelExtracao() {
        FacadeHost.getHost().addObserver(this);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonCalcular = new javax.swing.JButton();
        jButtonExtrair = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        salvarNovaBase = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jButtonCalcular.setText("Calcular");
        jButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularActionPerformed(evt);
            }
        });

        jButtonExtrair.setText("Extrair");
        jButtonExtrair.setEnabled(false);
        jButtonExtrair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExtrairActionPerformed(evt);
            }
        });

        jTextField1.setText("0");

        jLabel1.setText("Número de Características:");

        salvarNovaBase.setText("Salvar Nova Base");
        salvarNovaBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarNovaBaseActionPerformed(evt);
            }
        });

        jButton1.setText("Visulizar dados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCalcular)
                .addGap(18, 18, 18)
                .addComponent(jButtonExtrair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(salvarNovaBase)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCalcular, jButtonExtrair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCalcular)
                    .addComponent(jButtonExtrair)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salvarNovaBase)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCalcular, jButtonExtrair});

    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularActionPerformed
        // TODO add your handling code here:

        pca = new Pca(arrayListBases.get(arrayListBases.size() - 1));
        String[] valores = pca.calcula();
        String[] nomes = new String[3];
        String[][] data = new String[valores.length][3];
        double soma = 0;

        nomes[0] = "Caracteristica";
        nomes[1] = "Valor";
        nomes[2] = "Valor Acumulado";
        for (int i = 0; i < valores.length; i++) {
            data[i][0] = "PCA" + i;
            data[i][1] = valores[i] + "";
            soma += Double.parseDouble(valores[i]);
            data[i][2] = soma + "";

        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, nomes));
        jTextField1.setText(valores.length + "");

        jButtonExtrair.setEnabled(true);

    }//GEN-LAST:event_jButtonCalcularActionPerformed

    private void jButtonExtrairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExtrairActionPerformed
        // TODO add your handling code here:

        pca.extrair(Integer.parseInt(jTextField1.getText()));
        JOptionPane.showMessageDialog(null, "Base extraida");
        jButtonExtrair.setEnabled(false);
        pca = null;

    }//GEN-LAST:event_jButtonExtrairActionPerformed

    private void salvarNovaBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarNovaBaseActionPerformed
        // TODO add your handling code here:
        String nome = JOptionPane.showInputDialog(null, "Nome para a nova Base");
        
        if (SalvarARFF.salvarBase(arrayListBases.get(arrayListBases.size() - 1), nome)) {
            JOptionPane.showMessageDialog(null, "Base Salva");
        }

    }//GEN-LAST:event_salvarNovaBaseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Base b = arrayListBases.get(arrayListBases.size() - 1);
        Object[][] data = new Object[b.getInput().length][b.getInput()[0].length+1];
//        System.arraycopy(b.getInput(), 0, data, 0, b.getInput().length);
        for(int i=0;i<b.getInput().length;i++){
            for(int j=0;j<b.getInput()[0].length;j++){
                data[i][j]=b.getInput()[i][j];
            }
        }
        
//        System.arraycopy(b.getOutput(), 0, data[data.length-1], 0, b.getOutput().length);
        for(int i =0; i<b.getOutput().length ; i++){
            data[i][data[0].length-1]=b.getOutput()[i];
        }
        
        new moduledefault.elicitedbases.arff.view.JDialogData(FacadeHost.getViewMain(), true, data, b.getAtributes()).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCalcular;
    private javax.swing.JButton jButtonExtrair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton salvarNovaBase;
    // End of variables declaration//GEN-END:variables

    public void update(Observable o, Object o1) {
        if (o instanceof Host) {
            if ((o1 instanceof Base) && ((Base) o1).hasMeta()) {
                arrayListBases.add((Base) o1);
            }
        }
    }
}
