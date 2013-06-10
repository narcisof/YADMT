/*
 * RafaelTreeModelListener.java
 * Created on 25 de Maio de 2008, 08:23
 *
 */
package moduledefault.elicitedbases.postgresrafael.util.jtree;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 *
 * @author Rafael
 * @version
 */
public class RafaelTreeModelListener implements TreeModelListener {

    RafaelJTree arvore;

    /**
     * Construtor Default da Classe RafaelTreeModelListener
     */
    public RafaelTreeModelListener(RafaelJTree arvore) {
        this.arvore = arvore;
    }

    public void treeNodesChanged(TreeModelEvent e) {
    }

    public void treeNodesInserted(TreeModelEvent e) {
        TreePath path = e.getTreePath();
//        System.out.println(arvore.getNode(path).toString());
    }

    public void treeNodesRemoved(TreeModelEvent e) {
    }

    public void treeStructureChanged(TreeModelEvent e) {
        TreePath path = e.getTreePath();
//        System.out.println(arvore.getNode(path).toString());
    }
}
