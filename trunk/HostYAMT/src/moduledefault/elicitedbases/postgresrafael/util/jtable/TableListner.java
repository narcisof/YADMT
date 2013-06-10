/*
 * TableListner.java
 * Created on 31 de Maio de 2008, 08:16
 *
 */
package moduledefault.elicitedbases.postgresrafael.util.jtable;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Rafael
 * @version
 */
public class TableListner implements MouseInputListener {

    RafaelJTable tabela;

    /**
     * Construtor Default da Classe TableListner
     */
    public TableListner(RafaelJTable tabela) {
        this.tabela = tabela;
    }

    public void mouseClicked(MouseEvent e) {
        tabela.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
    }
}
