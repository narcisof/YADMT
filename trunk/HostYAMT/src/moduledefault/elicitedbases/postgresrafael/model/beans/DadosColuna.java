/*
 * DadosColuna.java
 * Created on 25 de Maio de 2008, 19:46
 *
 */

package moduledefault.elicitedbases.postgresrafael.model.beans;

import java.util.Vector;

/**
 *
 * @author Rafael
 * @version
 */
public class DadosColuna {
    private Coluna coluna;
    private Vector Dados;

    public DadosColuna(Coluna coluna, Vector Dados) {
        this.coluna = coluna;
        this.Dados = Dados;
    }

    public Vector getDados() {
        return Dados;
    }

    public void setDados(Vector Dados) {
        this.Dados = Dados;
    }

    public Coluna getColuna() {
        return coluna;
    }

    public void setColuna(Coluna coluna) {
        this.coluna = coluna;
    }
    
}
