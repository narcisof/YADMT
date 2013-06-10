/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package moduledefault.elicitedbases.postgresrafael;

/**
 *
 * @author evaristowb
 */
public class FacadePostgresElicitedBases {

    private static PostgresElicitedBases postgresElicitedBases;
    private static JPanelPostgresElicitedBases jPanelPostgresElicitedBases;

    private FacadePostgresElicitedBases() {
    }

    public static PostgresElicitedBases getPostgresElicitedBases() {
        return postgresElicitedBases;
    }

    public static void setPostgresElicitedBases(PostgresElicitedBases postgresElicitedBases) {
        FacadePostgresElicitedBases.postgresElicitedBases = postgresElicitedBases;
    }

    public static JPanelPostgresElicitedBases getJPanelPostgresElicitedBases() {
        return jPanelPostgresElicitedBases;
    }

    public static void setJPanelPostgresElicitedBases(JPanelPostgresElicitedBases jPanelPostgresElicitedBases) {
        FacadePostgresElicitedBases.jPanelPostgresElicitedBases = jPanelPostgresElicitedBases;
    }
}
