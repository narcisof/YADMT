/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization;

import java.awt.Color;

/**
 *
 * @author alienware
 */
public class Ponto implements java.io.Serializable {

    private String nome;
    private double X;
    private double Y;
    private double Z;
    private Color cor;
    private int[] ys;
    private int[] xs;
    private int i;
    private int j;

    public Ponto() {
        nome = "";
    }

    public Ponto(String nome, double X, double Y, double Z, Color _cor) {
        this.nome = nome;
        this.X = X;
        this.Y = Y;
        this.Z = Z;
        this.cor = _cor;
    }

    public Ponto(int i, int j, double X, double Y, double Z, Color _cor) {
        this.i = i;
        this.j = j;
        this.X = X;
        this.Y = Y;
        this.Z = Z;
        this.cor = _cor;
    }

    public Ponto(String nome, int[] x, int[] y, Color _cor) {
        this.xs = x;
        this.ys = y;
        this.cor = _cor;
        this.nome = nome;
    }

    public Ponto copy() {
        Ponto r = new Ponto(this.nome, this.X, this.Y, this.Z, this.cor);
        return r;
    }

    public void print(String s) {
        System.out.println(s + " -> nome = " + this.getNome() + " x= " + this.getX() + " y= " + this.getY() + " Z= " + this.getZ() + " \n");
    }

    public String getNome() {
        return nome;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getZ() {
        return Z;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setX(double X) {
        this.X = X;
    }

    public void setY(double Y) {
        this.Y = Y;
    }

    public void setZ(double Z) {
        this.Z = Z;
    }

    public Vetor vetor() {
        return new Vetor(this.X, this.Y, this.Z, 1);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ponto other = (Ponto) obj;
        if (this.X != other.X) {
            return false;
        }
        if (this.Y != other.Y) {
            return false;
        }
        if (this.Z != other.Z) {
            return false;
        }
        return true;
    }

    public Color getCor() {
        return cor;
    }

    public int[] getYs() {
        return ys;
    }

    public int[] getXs() {
        return xs;
    }
}
