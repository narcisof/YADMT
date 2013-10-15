/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialogData.java
 *
 * Created on 02/10/2010, 01:08:02
 */
package moduledefault.clustering.visualization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Fernando
 */
public class JDialogData extends javax.swing.JDialog {

    /**
     * Creates new form JDialogData
     */
    Object [][] data;
    String [] columnNames;
    public JDialogData(java.awt.Frame parent, boolean modal, Object[][] _data, String[] _columnNames) {
        
        super(parent, modal);
        initComponents();
        data = _data;
        columnNames = _columnNames;
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        
        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2, getWidth(), getHeight());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedColumnCount();
        System.out.println("index = "+index);
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);
        jTable1.setAutoCreateRowSorter(true);
        new SortAction(jTable1, index);
    }//GEN-LAST:event_jTable1MouseClicked
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JDialogData dialog = new JDialogData(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

  public class SortAction implements ActionListener {

        private JTable table;
        private int column;

        public SortAction(JTable table, int column) {
            this.table = table;
            this.column = column;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            RowSorter<? extends TableModel> rowSorter = table.getRowSorter();
            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(rowSorter.getSortKeys());
            boolean found = false;
            SortOrder order = SortOrder.ASCENDING;
            for (int index = 0; index < sortKeys.size(); index++) {
                RowSorter.SortKey key = sortKeys.get(index);
                if (key.getColumn() == column) {
                    found = true;
                    System.out.println("Found existing sort key for column " + column);
                    switch (key.getSortOrder()) {
                        case ASCENDING:
                            order = SortOrder.DESCENDING;
                            sortKeys.set(index, new RowSorter.SortKey(column, order));
                            break;
                        case DESCENDING:
                            order = SortOrder.UNSORTED;
                            sortKeys.remove(index);
                            break;
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("Add new sort key for column " + column);
                sortKeys.add(new RowSorter.SortKey(column, order));
            }
            System.out.println("List contains " + sortKeys.size());
            RowSorter newSorter = new TableRowSorter(table.getModel());
            newSorter.setSortKeys(sortKeys);
            table.setRowSorter(newSorter);
            switch (order) {
                case ASCENDING:
                    ((JButton) e.getSource()).setText("+");
                    break;
                case DESCENDING:
                    ((JButton) e.getSource()).setText("-");
                    break;
                default:
                    ((JButton) e.getSource()).setText(" ");
                    break;
            }
        }
    }
}

