/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package moduledefault.elicitedbases.postgresrafael.util.jtable;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author evaristowb
 */
public class RafaelDefaultTableModel extends DefaultTableModel {
    public RafaelDefaultTableModel(int x, int y){
        super(x, y);
    }

    public Vector getColumnIdentifiers() {
        return columnIdentifiers;
    }
}