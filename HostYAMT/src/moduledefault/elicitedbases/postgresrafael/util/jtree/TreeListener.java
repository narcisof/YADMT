/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.util.jtree;

import moduledefault.elicitedbases.postgresrafael.model.beans.Coluna;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Rafael
 */
public class TreeListener implements TreeSelectionListener, MouseListener, MouseMotionListener {

    JTree jTArvore;

    public TreeListener(JTree jTArvore) {
        this.jTArvore = jTArvore;
    }

    public void valueChanged(TreeSelectionEvent e) {
    /*
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTArvore.getLastSelectedPathComponent();
    if (node != null) {
    Object nodeInfo = node.getUserObject();
    if (node.isLeaf()) {
    BookInfo book = (BookInfo) nodeInfo;
    System.out.println(book.toString());
    } else {
    System.out.println(":P");
    }}*/
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        TreePath tp = jTArvore.getPathForLocation(p.x, p.y);
        if (tp != null) {
            DefaultMutableTreeNode n = (DefaultMutableTreeNode) tp.getLastPathComponent();
            Object obj = n.getUserObject();
            if (obj instanceof Coluna) {
                Coluna c = (Coluna) obj;
                jTArvore.setToolTipText(c.getEstatistica().toString());
            }
        }

    //jTArvore.get
    //((DefaultTreeModel) jTArvore.getModel()).;

    }
}
