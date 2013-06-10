/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.model.beans;

import util.Util;

/**
 *
 * @author Rafael
 */
public class Schema {

    /**
     * Nome do Schema
     */
    private String nome;
    /**
     * Nome da Base de Dados que o Schema se encontra
     */
    private BaseDados baseDados;

    public Schema(String nome, BaseDados baseDados) {
        this.nome = nome;
        this.baseDados = baseDados;
    }

    public BaseDados getBaseDados() {
        return baseDados;
    }

    public void setBaseDados(BaseDados baseDados) {
        this.baseDados = baseDados;
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

    public String getNomeCompleto(){
        return Util.formatDataBase(nome);
    }
}
