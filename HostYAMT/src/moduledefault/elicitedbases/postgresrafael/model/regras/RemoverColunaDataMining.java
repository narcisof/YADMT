/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.model.regras;

import moduledefault.elicitedbases.postgresrafael.util.jtable.RafaelJTable;
import moduledefault.elicitedbases.postgresrafael.model.beans.BaseDados;
import moduledefault.elicitedbases.postgresrafael.model.beans.Coluna;
import moduledefault.elicitedbases.postgresrafael.model.beans.Schema;
import moduledefault.elicitedbases.postgresrafael.model.beans.Tabela;
import interfaces.util.WaitingDialogInterface;
import moduledefault.elicitedbases.postgresrafael.controller.dao.RecuperaDados;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;
import moduledefault.elicitedbases.postgresrafael.FacadePostgresElicitedBases;
import moduledefault.elicitedbases.postgresrafael.JPanelPostgresElicitedBases;

/**
 *
 * @author rafael
 */
public class RemoverColunaDataMining extends Thread {

    private Vector<WaitingDialogInterface> listner;
    private DefaultMutableTreeNode node;
    private JPanelPostgresElicitedBases jPanelPostgresElicitedBases;
    private int contador;

    public RemoverColunaDataMining(DefaultMutableTreeNode node) {
        this.listner = new Vector();
        this.jPanelPostgresElicitedBases = FacadePostgresElicitedBases.getJPanelPostgresElicitedBases();
        this.node = node;
        this.contador=1;
    }

    private void removeColunaRecursivo(DefaultMutableTreeNode node) {
        RafaelJTable tabela = jPanelPostgresElicitedBases.getPrevia().getRafaelJTable1();
        Object o = node.getUserObject();
        boolean igual = false;
        if (o.getClass().equals(Coluna.class)) {
            jPanelPostgresElicitedBases.getPrevia().remColuna(((Coluna) o).getNome());
            fireAndamento(contador++);
        } else {
            for (int i = 0; i < node.getChildCount(); i++) {
                removeColunaRecursivo(((DefaultMutableTreeNode) node.getChildAt(i)));
            }
        }
    }

    public void addListner(WaitingDialogInterface l) {
        this.listner.add(l);
    }

    public void fireInicio(int nMaximo) {
        for (Iterator<WaitingDialogInterface> it = listner.iterator(); it.hasNext();) {
            WaitingDialogInterface l = it.next();
            l.begin(nMaximo);
        }
//  System.out.println("fireInicio()");
    }

    public void fireFim() {
        for (Iterator<WaitingDialogInterface> it = listner.iterator(); it.hasNext();) {
            WaitingDialogInterface l = it.next();
            l.end();
        }
    // System.out.println("fireFim()");
    }

    public void fireAndamento(int valor) {
        for (Iterator<WaitingDialogInterface> it = listner.iterator(); it.hasNext();) {
            WaitingDialogInterface l = it.next();
            l.processing(valor);
        }
    // System.out.println("fireAndamento() " + valor);
    }

    @Override
    public void run() {
        fireInicio(-1);
        removeColunaRecursivo(node);
        fireFim();
    }
}
