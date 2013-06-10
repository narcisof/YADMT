/*
 * RafaelJTree.java
 * Created on 24 de Maio de 2008, 10:20
 *
 */
package moduledefault.elicitedbases.postgresrafael.util.jtree;

import moduledefault.elicitedbases.postgresrafael.model.beans.BaseDados;
import moduledefault.elicitedbases.postgresrafael.model.beans.Coluna;
import moduledefault.elicitedbases.postgresrafael.model.beans.Schema;
import moduledefault.elicitedbases.postgresrafael.model.beans.Tabela;
import moduledefault.elicitedbases.postgresrafael.controller.dao.ColetaMetaDados;
import java.awt.Font;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Rafael
 * @version
 */
public class RafaelJTree extends JTree {

    DefaultTreeModel modeloArvore;
    DefaultMutableTreeNode top;

    /**
     * Construtor Default da Classe RafaelJTree
     */
    public RafaelJTree() {
        super();
        TreeListener tl = new TreeListener(this);
        top = new DefaultMutableTreeNode("Root");
        modeloArvore = new DefaultTreeModel(top);
        setModel(modeloArvore);
        setToolTipText(TOOL_TIP_TEXT_KEY);
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        getSelectionModel().addTreeSelectionListener(tl);
        setShowsRootHandles(true);
        setCellRenderer(new RenderTree());
        addMouseListener(tl);
        addMouseMotionListener(tl);
        this.setFont(new Font("Calibri", Font.PLAIN,12));
    }

    public DefaultMutableTreeNode getNode(TreePath path) {
        return (DefaultMutableTreeNode) path.getLastPathComponent();
    }

    public void addTreeModelListner(TreeModelListener treeModelListener) {
        modeloArvore.addTreeModelListener(treeModelListener);
    }

    public void createNodes(BaseDados bd) {
        Vector schemas;
        Vector tabelas;
        Vector colunas;

        DefaultMutableTreeNode conexaoT = null;
        DefaultMutableTreeNode schemaT = null;
        DefaultMutableTreeNode tabelaT = null;
        DefaultMutableTreeNode colunaT = null;

        ColetaMetaDados cmd = bd.getDaoFactory().getSqlColetaDados(bd.getDaoFactory().createConnection());
        //RecuperaDados rd = bd.getDaoFactory().getReuperaDados(bd.getDaoFactory().createConnection());
        schemas = cmd.getSchemas();
        conexaoT = new DefaultMutableTreeNode(bd);
        for (Iterator it2 = schemas.iterator(); it2.hasNext();) {
            Schema s = new Schema((String) it2.next(), bd);
            schemaT = new DefaultMutableTreeNode(s);
            tabelas = cmd.getTabelas(s.getNome());
            Iterator it3 = tabelas.iterator();
            if(it3.hasNext()){
                while(it3.hasNext()) {
                    Tabela t = new Tabela((String) it3.next(), s);
                    tabelaT = new DefaultMutableTreeNode(t);
    ////                colunas = cmd.getColunas(t.getNome());
                    colunas = cmd.getColunas(s.getNome(), t.getNome());
                    for (Iterator it4 = colunas.iterator(); it4.hasNext();) {
                        Coluna c = (Coluna) it4.next();
                        c.setTabela(t);
                        //rd.getEstatisticas(c);
                        colunaT = new DefaultMutableTreeNode(c);
                        tabelaT.add(colunaT);
                    }
////                    conexaoT.add(tabelaT);
                    schemaT.add(tabelaT);
                }
                conexaoT.add(schemaT);
            }
        }
        top.add(conexaoT);

        modeloArvore.reload();
    }

    public void adicionar(DefaultMutableTreeNode node) {
        if (node.isLeaf()) {
            adicionarLeaf(node);
        } else {
            adicionarNLeaf(node);
        }
        modeloArvore.reload();
    }

    public void remover(DefaultMutableTreeNode node) {
        TreePath path = this.getNextMatch(node.getUserObject().toString(), 0, Position.Bias.Forward);
        DefaultMutableTreeNode mNode = (DefaultMutableTreeNode) path.getLastPathComponent();
        modeloArvore.removeNodeFromParent(node);
        modeloArvore.reload();
    }

    private void adicionarNLeaf(DefaultMutableTreeNode node) {
        int q = node.getChildCount();
        for (int i = 0; i < q; i++) {
            DefaultMutableTreeNode n = (DefaultMutableTreeNode) node.getChildAt(i);
            if (n.isLeaf()) {
                adicionarLeaf(n);
            } else {
                adicionarNLeaf(n);
            }
        }
    }

    private void adicionarLeaf(DefaultMutableTreeNode node) {
        DefaultMutableTreeNode nc = null, nt = null, ns = null, nb = null;

        Object o = node.getUserObject();
        Coluna c = null;
        Tabela t = null;
        Schema s = null;
        BaseDados b = null;
        if (o.getClass().equals(Coluna.class)) {
            c = (Coluna) o;
            t = c.getTabela();
            s = t.getSchema();
            b = s.getBaseDados();
        }
        if (o.getClass().equals(Tabela.class)) {
            t = (Tabela) o;
            s = t.getSchema();
            b = s.getBaseDados();
        }
        if (o.getClass().equals(Schema.class)) {
            s = (Schema) o;
            b = s.getBaseDados();
        }
        if (o.getClass().equals(BaseDados.class)) {
            b = (BaseDados) o;
        }

        if (b != null) {
            int q = top.getChildCount();
//            boolean igual = false;
//            for (int i = 0; !igual && i < q; i++) {
//                if (((BaseDados) ((DefaultMutableTreeNode) top.getChildAt(i)).getUserObject()).getNome().equals(b.getNome())) {
//                    igual = true;
//                    nb = (DefaultMutableTreeNode) top.getChildAt(i);
//                }
//            }
//            if (!igual) {
//                nb = new DefaultMutableTreeNode(b);
//            }
//            if (t != null) {
//                q = nb.getChildCount();
//                igual = false;
//                for (int i = 0; !igual && i < q; i++) {
//                    if (((Tabela) ((DefaultMutableTreeNode) nb.getChildAt(i)).getUserObject()).getNome().equals(t.getNome())) {
//                        igual = true;
//                        nt = (DefaultMutableTreeNode) nb.getChildAt(i);
//                    }
//                }
//                if (!igual) {
//                    nt = new DefaultMutableTreeNode(t);
//                }
//                if (c != null) {
//                    q = nt.getChildCount();
//                    igual = false;
//                    for (int i = 0; !igual && i < q; i++) {
//                        if (((Coluna) ((DefaultMutableTreeNode) nt.getChildAt(i)).getUserObject()).getNome().equals(c.getNome())) {
//                            igual = true;
//                            nc = (DefaultMutableTreeNode) nt.getChildAt(i);
//                        }
//                    }
//                    if (!igual) {
//                        nc = new DefaultMutableTreeNode(c);
//                    }
//                    nt.add(nc);
//                }
//                nb.add(nt);
//            }
//            top.add(nb);

            for (int i = 0; i < q; i++) {
                if (((BaseDados) ((DefaultMutableTreeNode) top.getChildAt(i)).getUserObject()).getNome().equals(b.getNome())) {
                    nb = (DefaultMutableTreeNode) top.getChildAt(i);
                    break;
                }
            }
            if (nb==null) {
                nb = new DefaultMutableTreeNode(b);
            }
            if(s!=null){
                q = nb.getChildCount();
                for (int i = 0;i < q; i++) {
                    if (((Schema) ((DefaultMutableTreeNode) nb.getChildAt(i)).getUserObject()).getNome().equals(s.getNome())) {
                        ns = (DefaultMutableTreeNode) nb.getChildAt(i);
                        break;
                    }
                }
                if (ns==null) {
                    ns = new DefaultMutableTreeNode(s);
                }
                if (t != null) {
                    q = ns.getChildCount();
                    for (int i = 0;i < q; i++) {
                        if (((Tabela) ((DefaultMutableTreeNode) ns.getChildAt(i)).getUserObject()).getNome().equals(t.getNome())) {
                            nt = (DefaultMutableTreeNode) ns.getChildAt(i);
                            break;
                        }
                    }
                    if (nt==null) {
                        nt = new DefaultMutableTreeNode(t);
                    }
                    if (c != null) {
                        q = nt.getChildCount();
                        for (int i = 0;i < q; i++) {
                            if (((Coluna) ((DefaultMutableTreeNode) nt.getChildAt(i)).getUserObject()).getNome().equals(c.getNome())) {
                                nc = (DefaultMutableTreeNode) nt.getChildAt(i);
                                break;
                            }
                        }
                        if (nc==null) {
                            nc = new DefaultMutableTreeNode(c);
                        }
                        nt.add(nc);
                    }
                    ns.add(nt);
                }
                nb.add(ns);
            }
            top.add(nb);
        }
    }
}
