/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

/**
 *
 * @author alienware
 */
public class Aresta implements java.io.Serializable
{

    private Ponto ponto_1;
    private Ponto ponto_2;
    private String nome;

    public Aresta()
    {
        ponto_1 = null;
        ponto_2 = null;
        nome = "";
    }

    public Aresta(Ponto ponto_1, Ponto ponto_2, String nome)
    {
        this.ponto_1 = ponto_1;
        this.ponto_2 = ponto_2;
        this.nome = nome;
    }

    public Ponto getPonto_1()
    {
        return ponto_1;
    }

    public Ponto getPonto_2()
    {
        return ponto_2;
    }

    public String getNome()
    {
        return nome;
    }

    public void setPonto_1(Ponto ponto_1)
    {
        this.ponto_1 = ponto_1;
    }

    public void setPonto_2(Ponto ponto_2)
    {
        this.ponto_2 = ponto_2;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
}
