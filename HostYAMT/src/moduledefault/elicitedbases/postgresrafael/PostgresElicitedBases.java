/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package moduledefault.elicitedbases.postgresrafael;

import moduledefault.elicitedbases.postgresrafael.JPanelPostgresElicitedBases;
import moduledefault.elicitedbases.postgresrafael.FacadePostgresElicitedBases;
import annotations.ElicitedBasesModuleAnnotation;
import annotations.ModuleAnnotation;
import interfaces.Base;
import moduledefault.elicitedbases.postgresrafael.model.regras.ConectarBaseDados;
import interfaces.HostInterface;
import interfaces.preprocess.ElicitedBasesModuleInterface;
import interfaces.util.WaitingDialogInterface;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import moduledefault.elicitedbases.postgresrafael.model.regras.AdicionaColunaDataMining;
import moduledefault.elicitedbases.postgresrafael.model.regras.RemoverColunaDataMining;

/**
 *
 * @author evaristowb
 */
@ModuleAnnotation(name="Bases PostgreSQL")
@ElicitedBasesModuleAnnotation
public class PostgresElicitedBases implements ElicitedBasesModuleInterface {

    HostInterface hostInterface = null;
    JPanelPostgresElicitedBases jPanelPostgresElicitedBases;

    public PostgresElicitedBases() {
        FacadePostgresElicitedBases.setPostgresElicitedBases(this);
        jPanelPostgresElicitedBases = new JPanelPostgresElicitedBases();
        FacadePostgresElicitedBases.setJPanelPostgresElicitedBases(jPanelPostgresElicitedBases);
    }
//
//    public JPanel getPaiPanel() {
//        return jPanelPostgresElicitedBases;
//    }

    public void setHost(HostInterface hi) {
        hostInterface = hi;
    }


    public JPanel getMainPanel() {
        return jPanelPostgresElicitedBases;
    }

//    public void addBase(Base base){
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    /**
     * Metodo que faz a coneccao para a base de dados selecionada no JCSgbd
     * @author Rafael Voltolini
     * @version 20080530
     */
    public void conectarBaseDados() {
        ConectarBaseDados cbd = new ConectarBaseDados();
        cbd.start();
    }

    /**
     * Metodo que adiciona colunas na RafaelJTree da JPPreviaDados
     * @param obj objeto que contem as informacoes basicas para recuperar os
     * dados da base dados, este Object pode ser uma BaseDados, Tabela
     * ou Coluna, nao ha a necessidade de Schema, jah que nao sao mais
     * visualizados pelo usuario
     * @author Rafael Voltolini
     * @version 20080708
     */
    public void addColuna(DefaultMutableTreeNode node) {
//        Espera e = new Espera(this.getJFrame(), true, "Adicionando colunas, aguarde");
        WaitingDialogInterface e = hostInterface.getWaitingDialog(true, "Adicionando colunas, aguarde");
        AdicionaColunaDataMining aC = new AdicionaColunaDataMining(node);
        aC.addListner(e);
        aC.start();
        //java.awt.EventQueue.invokeLater(e);

//        e.setVisible(true);
        e.visible();
    }

    /**
     * Metodo que adiciona colunas na RafaelJTree da JPPreviaDados
     * @param obj objeto que contem as informacoes basicas para recuperar os
     * dados da base dados, este Object pode ser uma BaseDados, Tabela
     * ou Coluna, nao ha a necessidade de Schema, jah que nao sao mais
     * visualizados pelo usuario
     * @author Rafael Voltolini
     * @version 20080708
     */
    public void remColuna(DefaultMutableTreeNode node) {
//        Espera e = new Espera(this.getJFrame(), true, "Adicionando colunas, aguarde");
        WaitingDialogInterface e = hostInterface.getWaitingDialog(true, "Removendo colunas, aguarde");
        RemoverColunaDataMining aC = new RemoverColunaDataMining(node);
        aC.addListner(e);
        aC.start();
        //java.awt.EventQueue.invokeLater(e);

//        e.setVisible(true);
        e.visible();
    }

    public void addBase(Base base){
        hostInterface.addBase(base);
    }
}
