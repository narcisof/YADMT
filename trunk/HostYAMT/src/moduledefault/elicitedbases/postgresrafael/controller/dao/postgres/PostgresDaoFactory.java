/*
 * PostgreSQL.java
 *
 * Created on 11 de Agosto de 2006, 21:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.controller.dao.postgres;

import moduledefault.elicitedbases.postgresrafael.model.beans.Conexao;
import moduledefault.elicitedbases.postgresrafael.controller.dao.ColetaMetaDados;
import moduledefault.elicitedbases.postgresrafael.controller.dao.DaoFactory;
import moduledefault.elicitedbases.postgresrafael.controller.dao.RecuperaDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;

/**
 *
 * @author elboiago
 */
public class PostgresDaoFactory extends DaoFactory {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String DBURL = "jdbc:postgresql://";
    private Conexao conexao;
    private String erro;

    public PostgresDaoFactory(Conexao conexao) {
        this.conexao = conexao;
        this.erro = new String();
    }

    /**
     * Metodo que cria a conexao com a base de dados com as informacoes contidas
     * em conexao. Este metodo implementa o padrao singleton.
     * @return a conexao com a base de dados
     */
    public synchronized Connection createConnection() {
        erro = new String();
        if (conexao != null) {
            try {
                Class.forName(DRIVER);
                Connection postgres = DriverManager.getConnection(DBURL +
                        conexao.getCaminhoBancoDados() +
                        conexao.getNomeBanco(),
                        conexao.getUsuario(),
                        Util.toString(conexao.getSenha()));
                return postgres;
            } catch (SQLException ex) {
                Logger.getLogger(PostgresDaoFactory.class.getName()).log(Level.SEVERE, null, ex);
                erro = ex.toString();
                return null;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PostgresDaoFactory.class.getName()).log(Level.SEVERE, null, ex);
                erro = ex.toString();
                return null;
            }
        }
        return null;
    }

    @Override
    public ColetaMetaDados getSqlColetaDados(Connection con) {
        return new PostgresColetaMetaDados(con);
    }

    @Override
    public Conexao getConexao() {
        return conexao;
    }

    @Override
    public RecuperaDados getReuperaDados(Connection con) {
        return new PostgresRecuperaDados(con);
    }

    @Override
    public String getErro() {
        return erro;
    }
}
