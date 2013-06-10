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
public class Tabela {

    /**
     * Nome da Tabela
     */
    private String nome;
    /**
     * Nome do Schema que a Tabela se encontra
     */
    private Schema schema;

    public Tabela(String nome, Schema schema) {
        this.nome = nome;
        this.schema = schema;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public String getNomeCompleto(){
        return schema.getNomeCompleto() + "." + Util.formatDataBase(nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
