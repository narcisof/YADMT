/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.controller.dao;

import java.util.Vector;

/**
 *
 * @author Rafael
 */
public interface ColetaMetaDados {
    //public ColetaMetaDados(Connection con);
    public Vector getSchemas();
    public Vector getTabelas(String schema);
////    public Vector getColunas(String name);
    public Vector getColunas(String schema, String name);
//    public Vector pegaTipoColuna(String name);
//    public Vector pegaTamanhoColuna(String name);
//    public void alteraColuna(String name);
//    public Vector frenteDados(String NomeTabela);
//    public Vector trasDados(String NomeTabela);
//    public void go0();
//    public void atualizaLinha(Vector aux);
//    public void insereLinha(Vector aux);
//    public int apagaLinha();
}
