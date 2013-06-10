/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.model.beans;

import moduledefault.elicitedbases.postgresrafael.controller.dao.DaoFactory;

/**
 *
 * @author Rafael
 */
public class BaseDados {

    /**
     * Nome da Base de Dados
     */
    private String nome;
    /**
     * Conexao com a Base de Dados
     */
    private DaoFactory dao;

    public BaseDados(String nome, DaoFactory dao) {
        this.nome = nome;
        this.dao = dao;
    }

    public DaoFactory getDaoFactory() {
        return dao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
