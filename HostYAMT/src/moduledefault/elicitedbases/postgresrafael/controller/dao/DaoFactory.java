/*
 * DAOFactory.java
 *
 * Created on 11 de Agosto de 2006, 21:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package moduledefault.elicitedbases.postgresrafael.controller.dao;

import moduledefault.elicitedbases.postgresrafael.model.beans.Conexao;
import moduledefault.elicitedbases.postgresrafael.controller.dao.postgres.PostgresDaoFactory;
import java.sql.Connection;

/**
 * Classe que implementa o padrao Abstract Factory para criar os objetos
 * responsaveis por trabalhar com a persistencia dos dados
 * @author Rafael
 * @version 20080517
 */
public abstract class DaoFactory {

    /**
     * Metodo que seleciona qual eh a Factory que deve responder pela persistencia
     * @param qualBanco qual a base de dados que o cliente deseja a Factory
     * @param conexao objeto com as informacoes basicas para conectar a base de dados
     * @return uma instancia de uma Factory para criar os objetos
     * @author Rafael
     * @version 20080517
     */
    public static DaoFactory getDaoFactory(String qualBanco, Conexao conexao) {
        if (qualBanco.equals("PostgreSQL")) {
            return new PostgresDaoFactory(conexao);
        }
        return null;
    }

    /**
     * Metodo que cria a conexao para a base de dados
     * @return a conexao com a base de dados
     * @author Rafael
     * @version 20080517
     */
    public abstract Connection createConnection();

    /**
     * Metodo que cria uma instancia de ColetaMetaDados
     * @param con conexao a base de dados
     * @return uma instancia de ColetaMetadados
     * @author Rafael
     * @version 20080517
     */
    public abstract ColetaMetaDados getSqlColetaDados(
            Connection con);

    /**
     * Metodo que cria uma instancia de RecuperaDados
     * @param con conexao a base de dados
     * @return uma instancia de RecuperaDados
     * @author Rafael
     * @version 20080517
     */
    public abstract RecuperaDados getReuperaDados(
            Connection con);

    /**
     * Metodo que recupera a Conexao que tem as informacoes basicas para a 
     * conexao com a base de dados
     * @return o objeto com as informacoes basicas da conexao com a base de dados
     * @author Rafael
     * @version 20080517
     */
    public abstract Conexao getConexao();

    /**
     * Metodo que recupera o erro que foi causado ao tentar fazer a conexao com
     * a base de dados
     * @return uma String com a mensagem de erro que ocorreu ao tentar conectar
     * a base de dados
     * @author Rafael
     * @version 20080708
     */
    public abstract String getErro();
}
