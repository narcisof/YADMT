package moduledefault.clustering.uteis;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import moduledefault.clustering.kmeans.Historico;

public class MatrizDados {

    double[][] matriz_dados;
    int linhas = 0;
    int colunas = 0;
    int dimensão_matriz = 0;

    public double[][] getMatriz_dados() {
        return matriz_dados;
    }

    public void setMatriz_dados(double[][] matriz_dados) {
        this.matriz_dados = new double[matriz_dados.length][matriz_dados[0].length];
        for(int i = 0;i < matriz_dados.length;i++){
            for(int j = 0;j < matriz_dados[0].length;j++){
                this.matriz_dados[i][j] = matriz_dados[i][j];
            }
        }
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public int getDimensão_matriz() {
        return dimensão_matriz;
    }

    public void setDimensão_matriz() {
       dimensão_matriz = (int) Math.sqrt((10 * linhas));
    }




   
}
