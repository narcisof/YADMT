/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.util.jcombobox;

import moduledefault.elicitedbases.postgresrafael.view.jpanel.JPMetaDados;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.StringTokenizer;

/**
 *
 * @author Rafael
 */
public class ComboListener implements ItemListener {

    JPMetaDados panel;
    
    public ComboListener(JPMetaDados panel) {
        this.panel = panel;
    }

    public void itemStateChanged(ItemEvent e) {
        String token = null;
        
        for (StringTokenizer stringTokenizer = new StringTokenizer(e.getItem().toString());
                stringTokenizer.hasMoreTokens();) {
            token = stringTokenizer.nextToken("()");
        }
        if(token.compareTo("SE") == 0) {
            panel.setEnabledJText(false);
        } else {
            panel.setEnabledJText(true);
        }

    }
}
