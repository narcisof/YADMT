/*
 * RenderTree.java
 * Created on 24 de Maio de 2008, 09:54
 *
 */
package moduledefault.elicitedbases.postgresrafael.util.jtree;

import moduledefault.elicitedbases.postgresrafael.model.beans.BaseDados;
import moduledefault.elicitedbases.postgresrafael.model.beans.Coluna;
import moduledefault.elicitedbases.postgresrafael.model.beans.Schema;
import moduledefault.elicitedbases.postgresrafael.model.beans.Tabela;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Rafael
 * @version
 */
public class RenderTree extends DefaultTreeCellRenderer {

    ImageIcon bdIcon;
    ImageIcon scIcon;
    ImageIcon tbIcon;
    ImageIcon clIcon;

    public RenderTree() {
        bdIcon = new ImageIcon(getClass().getResource("/images/DataBase.GIF"));
        scIcon = new ImageIcon(getClass().getResource("/images/Schema.GIF"));
        tbIcon = new ImageIcon(getClass().getResource("/images/Tabel.GIF"));
        clIcon = new ImageIcon(getClass().getResource("/images/Column.GIF"));
    }

    @Override
    public Component getTreeCellRendererComponent(
            JTree tree, Object value, boolean sel, boolean expanded,
            boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(
                tree, value, sel,
                expanded, leaf, row,
                hasFocus);

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        if (node.getUserObject().getClass().equals(BaseDados.class)) {
            setIcon(bdIcon);
        }
        if (node.getUserObject().getClass().equals(Schema.class)) {
            setIcon(scIcon);
        }
        if (node.getUserObject().getClass().equals(Tabela.class)) {
            setIcon(tbIcon);
        }
        if (node.getUserObject().getClass().equals(Coluna.class)) {
            setIcon(clIcon);
        }
        return this;
    }
}
