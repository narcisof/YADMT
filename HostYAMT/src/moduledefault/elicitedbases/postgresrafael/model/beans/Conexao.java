/*
 * Conexao.java
 * Created on 18 de Maio de 2008, 08:15
 *
 */
package moduledefault.elicitedbases.postgresrafael.model.beans;

/**
 * Classe que contem as informacoes basicas para fazer a conexao com a base de dados
 * @author Rafael
 * @version
 */
public class Conexao {

    /**
     * Qual a base de dados que serah feita a conexao
     */
    private String baseDados;
    /**
     * Caminho do tipo endereco
     */
    private String caminhoBancoDados;
    /**
     * Nome do banco de dados
     */
    private String nomeBanco;
    /**
     * Porta que eh feita a conexao com o banco de dados
     */
    private int porta;
    /**
     * Nome do usuario a se conectar base de dados
     */
    private String usuario;
    /**
     * Senha do usuario na base de dados
     */
    private char[] senha;

    public Conexao(String baseDados, String caminhoBancoDados, String nomeBanco, int porta, String usuario, char[] senha) {
        this.baseDados = baseDados;
        this.caminhoBancoDados = caminhoBancoDados;
        this.nomeBanco = nomeBanco;
        this.porta = porta;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getBaseDados() {
        return baseDados;
    }

    public void setBaseDados(String baseDados) {
        this.baseDados = baseDados;
    }

    public String getCaminhoBancoDados() {
        return caminhoBancoDados;
    }

    public void setCaminhoBancoDados(String caminhoBancoDados) {
        this.caminhoBancoDados = caminhoBancoDados;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = (nomeBanco + "/").replaceAll("//","/");
    }
}
