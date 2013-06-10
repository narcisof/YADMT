/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.model.regras;

import moduledefault.elicitedbases.postgresrafael.model.beans.BaseDados;
import moduledefault.elicitedbases.postgresrafael.model.beans.Conexao;
import moduledefault.elicitedbases.postgresrafael.controller.dao.DaoFactory;
import java.awt.Color;
import java.sql.Connection;
import moduledefault.elicitedbases.postgresrafael.FacadePostgresElicitedBases;
import moduledefault.elicitedbases.postgresrafael.JPanelPostgresElicitedBases;

/**
 *
 * @author rafael
 */
public class ConectarBaseDados extends Thread {

    private static final Color VERDE = new Color(0, 149, 0);
    JPanelPostgresElicitedBases jPanelPostgresElicitedBases;

    public ConectarBaseDados() {
        jPanelPostgresElicitedBases = FacadePostgresElicitedBases.getJPanelPostgresElicitedBases();
    }

    @Override
    public void run() {
        String qualBanco = jPanelPostgresElicitedBases.getMetadados().getJCSgbdSelectedItem();
        String caminho = jPanelPostgresElicitedBases.getMetadados().getJTCaminhoText();
        int porta = Integer.parseInt(jPanelPostgresElicitedBases.getMetadados().getJTPortaText());
        String nome = jPanelPostgresElicitedBases.getMetadados().getJTNomeBancoText();
        String usuario = jPanelPostgresElicitedBases.getMetadados().getJTUsuarioText();
        char[] senha = jPanelPostgresElicitedBases.getMetadados().getJPSenhaPassword();

        Conexao c = new Conexao(qualBanco, caminho, nome, porta, usuario, senha);
        DaoFactory dao = DaoFactory.getDaoFactory(qualBanco, c);

        BaseDados bd = new BaseDados(nome, dao);
//        jPanelPostgresElicitedBases.addBaseDados(bd);
        try {
            Connection con = bd.getDaoFactory().createConnection();
        } catch (NullPointerException npe) {
            jPanelPostgresElicitedBases.getMetadados().setJLErroTextColor(Color.RED);
            jPanelPostgresElicitedBases.getMetadados().setJLErroText("Não Foi possível realizar a conexão com o banco de dados, SGBD inválido");

        }

        String erro = bd.getDaoFactory().getErro();
        if (erro.compareTo("") == 0) {
            jPanelPostgresElicitedBases.getMetadados().setJLErroTextColor(VERDE);
            jPanelPostgresElicitedBases.getMetadados().setJLErroText("Conexão criada com sucesso!");

            jPanelPostgresElicitedBases.getSelecionaColuna().createNodes(bd);

            jPanelPostgresElicitedBases.nextPanel();
        } else {
            jPanelPostgresElicitedBases.getMetadados().setJLErroTextColor(Color.RED);
            jPanelPostgresElicitedBases.getMetadados().setJLErroText(erro);
        }


//        jPanelPostgresElicitedBases.setEnabledAtJPAbas(JPAbas.jPSelecionaColunas, true);

    }
}
