/*
 * RecuperaDados.java
 * Created on 25 de Maio de 2008, 07:53
 *
 */
package moduledefault.elicitedbases.postgresrafael.controller.dao;


import moduledefault.elicitedbases.postgresrafael.model.beans.BaseDados;
import moduledefault.elicitedbases.postgresrafael.model.beans.Coluna;
import moduledefault.elicitedbases.postgresrafael.model.beans.Schema;
import moduledefault.elicitedbases.postgresrafael.model.beans.Tabela;
import java.util.Vector;

/**
 *
 * @author Rafael
 * @version
 */
public interface RecuperaDados {

    //public RecuperaDados (Connection con);
    public Vector getColuna(Coluna c);
    public Vector getTabela(Tabela t);
    public Vector getSchema(Schema s);
    public Vector getBaseDados(BaseDados b);
    public void getEstatisticas(Coluna c);
}
