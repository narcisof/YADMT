/*
 * PostgresSqlColetaDados.java
 * Created on 17 de Maio de 2008, 08:51
 *
 */
package moduledefault.elicitedbases.postgresrafael.controller.dao.postgres;

import moduledefault.elicitedbases.postgresrafael.controller.dao.ColetaMetaDados;
import moduledefault.elicitedbases.postgresrafael.model.beans.Coluna;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que contem os metodos para extrair informacoes do banco de dados, tais
 * como schemas tabelas e colunas
 * @author Rafael
 * @version 20080517
 */
public class PostgresColetaMetaDados implements ColetaMetaDados {

    Connection con;

    public PostgresColetaMetaDados(Connection con) {
        this.con = con;
    }

    /**
     * Metodo que recupera os nomes dos Schemas do banco de dados PostgreSQL
     * @return um Vector com todos os Schemas do banco de dados PostgreSQL
     * @author Rafael
     * @version 20080517
     */
    public Vector getSchemas() {
        Vector schemas = new Vector();
        try {
            String schema;
            DatabaseMetaData dmd = con.getMetaData();
            ResultSet rs = dmd.getSchemas();
            while (rs.next()) {
                schema = rs.getString(1);
                schemas.add(schema);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresColetaMetaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schemas;
    }

    /**
     * Metodo que recupera os nomes das Tabelas em um banco de dados PostgreSQL
     * @param schema nome do schema que se deseja coletar informacoes sobre as
     * tabelas, se o valor de schema for nulo ele retornarah o nome de todas as 
     * tabelas que pertencem ao banco
     * @return um Vector com todas as Tabelas do banco de dados PostgreSQL
     * @author Rafael
     * @version 20080517
     */
    public Vector getTabelas(String schema) {
        Vector tabelas = new Vector();
        try {
            DatabaseMetaData dmd = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet resultSet = dmd.getTables(null, schema, "%", types);

            // Get the table names
            while (resultSet.next()) {
                String tableName = resultSet.getString(3);
                tabelas.add(tableName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresColetaMetaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabelas;
    }

//    /**
//     * Metodo que recupera as caracteristicas das colunas de uma tabela em um
//     * banco de dados PostgreSQL
//     * @param tabela nome da tabela que se deseja coletar informacoes sobre as
//     * colunas
//     * @return um Vector com nome, tipo tamanho, tamanho das Colunas de uma
//     * tabela do banco de dados PostgreSQL
//     * @author Rafael
//     * @version 20080517
//     */
//    public Vector getColunas(String tabela) {
//        Vector colunas = new Vector();
//        Coluna coluna;
//        try {
//            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//            //essa gambi eh de proposito, para mim pegar apenas as colunas da tabela
//            ResultSet rs = stmt.executeQuery("SELECT * from \"" + tabela + "\" where false;");
//
//            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
//
//            // retorna o numero total de colunas
//            int numColumns = rsmd.getColumnCount();
//
//            // loop para recuperar os metadados de cada coluna
//            for (int i = 1; i <= numColumns; i++) {
//                coluna = new Coluna(rsmd.getColumnName(i), null, rsmd.getColumnTypeName(i), rsmd.getColumnDisplaySize(i));
//                colunas.add(coluna);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PostgresColetaMetaDados.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return colunas;
//    }

    /**
     * Metodo que recupera as caracteristicas das colunas de uma tabela em um
     * banco de dados PostgreSQL
     * @param tabela nome da tabela que se deseja coletar informacoes sobre as
     * colunas
     * @return um Vector com nome, tipo tamanho, tamanho das Colunas de uma
     * tabela do banco de dados PostgreSQL
     * @author Rafael
     * @version 20080517
     */
    public Vector getColunas(String schema, String tabela) {
        Vector colunas = new Vector();
        Coluna coluna;
        try {
            DatabaseMetaData dmd = con.getMetaData();
            ResultSet resultSet = dmd.getColumns(null, schema, tabela, "%");

            // Get the table names
            while (resultSet.next()) {
                coluna = new Coluna(resultSet.getString("COLUMN_NAME"), null, resultSet.getString("DATA_TYPE"), resultSet.getInt("COLUMN_SIZE"));
                colunas.add(coluna);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresColetaMetaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return colunas;
    }
}
