/*
 * RafaelJTabel.java
 * Created on 25 de Maio de 2008, 08:14
 *
 */
package moduledefault.elicitedbases.postgresrafael.util.jtable;

import java.awt.Color;
import java.awt.Component;
import moduledefault.elicitedbases.postgresrafael.model.beans.Coluna;
import java.awt.Font;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Rafael
 * @version
 */
public class RafaelJTable extends JTable {
    public static final Color colorMeta = Color.yellow;
    private boolean metaAtribute = false;

    /**
     * Construtor Default da Classe RafaelJTabel
     */
    public RafaelJTable() {
        super();
        this.setModel(new RafaelDefaultTableModel(0, 0));
        TableListner tl = new TableListner(this);
        this.addMouseListener(tl);
        this.addMouseMotionListener(tl);
        this.setFont(new Font("Calibri", Font.PLAIN, 12));
    }

    public void addColumn(Vector v) {
        Coluna nome = (Coluna) v.get(0);
        v.remove(0);
//********É adicionado a coluna de indice como sting implementação do java*********
        ((RafaelDefaultTableModel) this.getModel()).addColumn(nome, v);
    }

    public Object[][] getInput() {
        if(((RafaelDefaultTableModel) this.getModel()).getColumnCount() > 1){
            Object[][] input = new Object[((RafaelDefaultTableModel) this.getModel()).getRowCount()][((RafaelDefaultTableModel) this.getModel()).getColumnCount() - 1];
            for (int i = 0; i < ((RafaelDefaultTableModel) this.getModel()).getRowCount(); i++) {
                for (int j = 0; j < ((RafaelDefaultTableModel) this.getModel()).getColumnCount() - 1; j++) {
                    input[i][j] = ((RafaelDefaultTableModel) this.getModel()).getValueAt(i, j);
                }
            }
            return input;
        }
        return null;
    }

    public Object[] getInput(int linha) {
        if(((RafaelDefaultTableModel) this.getModel()).getColumnCount() > 0){
            Object[] input = new Object[((RafaelDefaultTableModel) this.getModel()).getColumnCount() - 1];
            for (int j = 0; j < ((RafaelDefaultTableModel) this.getModel()).getColumnCount() - 1; j++) {
                input[j] = ((RafaelDefaultTableModel) this.getModel()).getValueAt(linha, j);
            }
            return input;
        }
        return null;
    }
    
//
//    public Object[] getLinhaInput() {
//        Object[] input = new Object[this.getColumnCount() - 1];
//        for (int j = 0; j < this.getColumnCount() - 1; j++) {
//            input[j] = this.getValueAt(0, j);
//        }
//        return input;
//    }
    
    public Object[] getOutput() {
        if(metaAtribute){
            Object[] output = new Object[((RafaelDefaultTableModel) this.getModel()).getRowCount()];
            for (int i = 0; i < ((RafaelDefaultTableModel) this.getModel()).getRowCount(); i++) {
                output[i] = ((RafaelDefaultTableModel) this.getModel()).getValueAt(i, ((RafaelDefaultTableModel) this.getModel()).getColumnCount() - 1);
            }
            return output;
        }
        return null;
    }


    public Vector getColumnIdentifiers() {
        return ((RafaelDefaultTableModel) this.getModel()).getColumnIdentifiers();
    }

    /*
     * Metodo para proibir edições na RafaelJTable
     * @param row
     * @param column
     * @return
     *
    @Override
    public boolean isCellEditable(int row, int column) {
    return false;
    }*/
    
    public void removeColumn(String coluna) {
        TableColumn col = getColumn(coluna);
        int columnModelIndex = col.getModelIndex();
        Vector data = ((RafaelDefaultTableModel)this.getModel()).getDataVector();
        Vector colIds = getColumnIdentifiers();
        removeColumn(col);

        colIds.removeElementAt(columnModelIndex);
        for (int r=0; r<data.size();r++)
            ((Vector)data.get(r)).removeElementAt(columnModelIndex);
        ((RafaelDefaultTableModel)this.getModel()).setDataVector(data, colIds);

        for (Enumeration enume = getColumnModel().getColumns(); enume.hasMoreElements(); ) {
            TableColumn c = (TableColumn)enume.nextElement();
            if (c.getModelIndex() >= columnModelIndex) {
                c.setModelIndex(c.getModelIndex()-1);
            }
        }
        ((RafaelDefaultTableModel)this.getModel()).fireTableStructureChanged();
    }

    @Override
    public String toString() {
        String s = new String();
        RafaelDefaultTableModel modelo = (RafaelDefaultTableModel) this.getModel();
        for (int j = 0; j < modelo.getColumnCount(); j++) {
            s += modelo.getColumnName(j) + "\t";
        }

        for (int i = 0; i < modelo.getRowCount(); i++) {
            s += "\n";
            for (int j = 0; j < modelo.getColumnCount(); j++) {
                s += modelo.getValueAt(i, j).toString() + "\t";
            }
        }
        s += "\n";
        return s;
    }

    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex) {
        Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
        if(metaAtribute && vColIndex == getColumnCount() - 1){
            c.setBackground(colorMeta);
        } else {
            c.setBackground(getBackground());
        }
        return c;
    }

    public boolean isMetaAtribute() {
        return metaAtribute;
    }

    public void setMetaAtribute(boolean metaAtribute) {
        this.metaAtribute = metaAtribute;
        repaint();
    }
}

//class Estudos extends JFrame {
//
//    public Estudos() {
//        super("Exemplo de uma tabela simples");
//
//        final RafaelDefaultTableModel modelo = new RafaelDefaultTableModel();
//
//// constrói a tabela
//        final JTable tabela = new JTable(modelo);
//        tabela.setAutoCreateColumnsFromModel(false);
//
//// Cria duas colunas
//        modelo.addColumn("Nome");
//        modelo.addColumn("Idade");
//
//        JButton btn = new JButton("Inserir Colunas");
//        btn.addActionListener(
//                new ActionListener() {
//
//                    public void actionPerformed(ActionEvent e) {
//                        String titulo = JOptionPane.showInputDialog(null,
//                                "Informe o título para a nova coluna:");
//                        int pos = Integer.parseInt(JOptionPane.showInputDialog(null,
//                                "Informe a posição da nova coluna:"));
//
//// testa se a posição é válida
//                        if (pos > (modelo.getColumnCount() - 1)) {
//                            pos = 0;
//                        }
//
//// Insere uma coluna na posição especificada
//                        insertColumn(tabela, titulo, null, pos);
//                    }
//                });
//
//        JButton btn2 = new JButton("Excluir Colunas");
//        btn2.addActionListener(
//                new ActionListener() {
//
//                    public void actionPerformed(ActionEvent e) {
//                        int pos = Integer.parseInt(JOptionPane.showInputDialog(null,
//                                "Informe a posição da coluna a ser excluída:"));
//
//// testa se a posição é válida
//                        if (pos < modelo.getColumnCount()) // remove a coluna na posição especificada
//                        {
//                            removeColumnAndData(tabela, pos);
//                        }
//                    }
//                });
//
//        tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
//
//        Container c = getContentPane();
//        c.setLayout(new FlowLayout());
//
//        JScrollPane scrollPane = new JScrollPane(tabela);
//        c.add(scrollPane);
//        c.add(btn);
//        c.add(btn2);
//
//        setSize(400, 300);
//        setVisible(true);
//    }
//
//    public void betterAddColumn(JTable table, Object headerLabel,
//            Object[] values) {
//        RafaelDefaultTableModel model = (RafaelDefaultTableModel) table.getModel();
//        TableColumn col = new TableColumn(model.getColumnCount());
//
//        if (table.getAutoCreateColumnsFromModel()) {
//            throw new IllegalStateException();
//        }
//        col.setHeaderValue(headerLabel);
//        table.addColumn(col);
//        model.addColumn(headerLabel.toString(), values);
//    }
//
//    public void insertColumn(JTable table, Object headerLabel,
//            Object[] values, int vColIndex) {
//        betterAddColumn(table, headerLabel, values);
//        table.moveColumn(table.getColumnCount() - 1, vColIndex);
//    }
//
//    public void removeColumnAndData(JTable table, int vColIndex) {
//        RafaelDefaultTableModel model = (RafaelDefaultTableModel)table.getModel();
//        TableColumn col = table.getColumnModel().getColumn(vColIndex);
//        int columnModelIndex = col.getModelIndex();
//        Vector data = model.getDataVector();
//        Vector colIds = model.getColumnIdentifiers();
//
//        table.removeColumn(col);
//
//        colIds.removeElementAt(columnModelIndex);
//
//        for (int r=0; r<data.size();r++) {
//            Vector row = (Vector)data.get(r);
//            row.removeElementAt(columnModelIndex);
//        }
//        model.setDataVector(data, colIds);
//
//        Enumeration enume = table.getColumnModel().getColumns();
//        for (; enume.hasMoreElements(); ) {
//            TableColumn c = (TableColumn)enume.nextElement();
//            if (c.getModelIndex() >= columnModelIndex) {
//                c.setModelIndex(c.getModelIndex()-1);
//            }
//        }
//        model.fireTableStructureChanged();
//    }
//
//    public static void main(String args[]){
//        Estudos app = new Estudos();
//        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//}
//
//class RafaelDefaultTableModel extends RafaelDefaultTableModel {
//    public Vector getColumnIdentifiers() {
//        return columnIdentifiers;
//    }
//}
