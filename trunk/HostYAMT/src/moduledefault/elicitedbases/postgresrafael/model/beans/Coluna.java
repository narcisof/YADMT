/*
 * Coluna.java
 * Created on 16 de Maio de 2008, 09:28
 *
 */
package moduledefault.elicitedbases.postgresrafael.model.beans;

import util.Estatistica;
import util.Util;

/**
 *
 * @author Rafael
 * @version
 */
public class Coluna {

    /**
     * Nome da Coluna
     */
    private String nome;
    /**
     * Nome da Tabela que a Coluna se encontra
     */
    private Tabela tabela;
    /**
     * Tipo da coluna (char, int, ...)
     */
    private String tipo;
    /**
     * tamanho da coluna
     */
    private int tamanho;
    /**
     * Estatisticas sobre a coluna
     */
    private Estatistica estatistica;

    /**
     * Construtor Default da Classe Coluna
     */
    public Coluna() {
    }

    public Coluna(String nome, Tabela tabela, String tipo, int tamanho) {
        this.nome = nome;
        this.tabela = tabela;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.estatistica = new Estatistica(0, 0, 0, 0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return nome;
    }

    public Estatistica getEstatistica() {
        return estatistica;
    }

    public String getNomeCompleto(){
        return tabela.getNomeCompleto() + "." + Util.formatDataBase(nome);
    }

    public void setEstatistica(Estatistica estatistica) {
        this.estatistica = estatistica;
    }

    @Override
    public boolean equals(Object obj) {
        try{
            return ((Coluna)obj).getNomeCompleto().equals(getNomeCompleto());
        } catch(Exception ex){
            return false;
        }
    }
}
