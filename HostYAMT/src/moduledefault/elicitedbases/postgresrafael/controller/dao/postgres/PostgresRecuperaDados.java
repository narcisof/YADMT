/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.controller.dao.postgres;

import util.Estatistica;
import moduledefault.elicitedbases.postgresrafael.model.beans.BaseDados;
import moduledefault.elicitedbases.postgresrafael.model.beans.Coluna;
import moduledefault.elicitedbases.postgresrafael.model.beans.Schema;
import moduledefault.elicitedbases.postgresrafael.model.beans.Tabela;
import moduledefault.elicitedbases.postgresrafael.controller.dao.ColetaMetaDados;
import moduledefault.elicitedbases.postgresrafael.controller.dao.RecuperaDados;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
class PostgresRecuperaDados implements RecuperaDados {

    Connection con;
    Statement stmt;

    public PostgresRecuperaDados(Connection con) {
        this.con = con;
    }

    public void getEstatisticas(Coluna c) {
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String s = "select " + "avg(" + c.getNomeCompleto() + "), " + "max(" + c.getNomeCompleto() + "), " +
                    "min(" + c.getNomeCompleto() + "), " + "count(*)" +
                    " from " + c.getTabela().getNomeCompleto() + ";";
            ResultSet rsEstatistica = stmt.executeQuery(s);
            rsEstatistica.next();
//            System.out.println("avg = " + rsEstatistica.getString("avg") + " max = " + rsEstatistica.getString("max") + " min = " + rsEstatistica.getString("min") + " count = " + rsEstatistica.getString("count"));
            Vector v = new Vector();
            c.setEstatistica(new Estatistica(
                    rsEstatistica.getDouble("avg"),
                    rsEstatistica.getDouble("max"),
                    rsEstatistica.getDouble("min"),
                    rsEstatistica.getInt("count")));
        } catch (SQLException ex) {
            Logger.getLogger(PostgresRecuperaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vector getColuna(Coluna c) {
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String s = "select count(*) from " + c.getTabela().getNomeCompleto() + " ;";
            ResultSet rsEstatistica = stmt.executeQuery(s);
            rsEstatistica.next();
            int count = rsEstatistica.getInt("count");

            ResultSet rs = stmt.executeQuery("select " + c.getNomeCompleto() + " from " + c.getTabela().getNomeCompleto() + ";");
            Vector coluna = new Vector(count);
            coluna.add(c);
            int i = 1;
            while (rs.next()) {
                i++;
                coluna.add(rs.getObject(c.getNome()));
            }
            return coluna;
        } catch (SQLException ex) {
            Logger.getLogger(PostgresRecuperaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Vector getTabela(Tabela t) {
        System.out.println("getTabela");
        try {
            Vector coluna;
            Vector matriz = new Vector();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("select * from " + t.getNomeCompleto() + ";");
            ResultSetMetaData rsm = rs.getMetaData();
            for (int i = 1; i <= rsm.getColumnCount(); i++) {
                coluna = new Vector(rsm.getColumnName(i).length());
                coluna.add(rsm.getColumnName(i));
                rs.beforeFirst();
                while (rs.next()) {
                    coluna.add(rs.getObject(i));
                }
                matriz.add(coluna);
            }
            return matriz;
        } catch (SQLException ex) {
            Logger.getLogger(PostgresRecuperaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Vector getSchema(Schema s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Vector getBaseDados(BaseDados b) {
        try {
            Vector baseDados = new Vector();
            Vector coluna,tabelas ,matriz ;
            ResultSet rs;
            ResultSetMetaData rsm;
            ColetaMetaDados cmd = b.getDaoFactory().getSqlColetaDados(con);
            Vector schema = cmd.getSchemas();
            for (Iterator it = schema.iterator(); it.hasNext();) {
                tabelas = cmd.getTabelas((String) it.next());
                for (Iterator it2 = tabelas.iterator(); it2.hasNext();) {
                    String nomeTabela = (String) it2.next();
                    stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    rs = stmt.executeQuery("select * from " + nomeTabela + ";");
                    matriz = new Vector();
                    rsm = rs.getMetaData();
                    for (int i = 1; i <= rsm.getColumnCount(); i++) {
                        coluna = new Vector();
                        coluna.add(rsm.getColumnName(i));
                        rs.beforeFirst();
                        while (rs.next()) {
                            coluna.add(rs.getObject(i));
                        }
                        matriz.add(coluna);
                    }
                    baseDados.add(matriz);
                }
            }
            return baseDados;
        } catch (SQLException ex) {
            Logger.getLogger(PostgresRecuperaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
