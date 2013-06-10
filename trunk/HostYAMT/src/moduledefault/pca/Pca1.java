/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.pca;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;
import java.math.BigDecimal;
import java.util.LinkedList;

/**
 *
 * @author TyTu
 */
public class Pca1 {

    public static Object[][] transforma(Object[][] entrada) {
        return doubleToObject(transforma(ObjectToDouble(entrada)));
    }

    public static double[][] ObjectToDouble(Object[][] entrada) {
        double[][] d = new double[entrada[0].length][entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            for (int j = 0; j < entrada[0].length; j++) {
                    d[j][i] = new Double(entrada[i][j].toString());
            }
        }
        return d;
    }

    public static Object[][] doubleToObject(double[][] d) {
        Object[][] o = new Object[d[0].length][d.length];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                o[j][i] = d[i][j];
            }
        }

        return o;
    }

    public static double[][] transforma(double[][] entrada) {

        double[][] saida = new double[1][1];

        /*
         * Copiar input
         */
        //double[][] dados= cloneInput(entrada);


        /**
         * Centralizar na média
         */
        centralizar(entrada);        

        /*
         * Calcular matriz de covariância
         */
        double[][] covariancia;
        covariancia = calculaMatrizCovariancia(entrada);


        /*
         * Calcular Autovalores e Autovetores da Matriz de Covariancia
         */

        /* usando EigenvalueDecomposition ***funciona    */
        EigenvalueDecomposition e = new EigenvalueDecomposition(new Matrix(covariancia));




//        SingularValueDecomposition svd = new SingularValueDecomposition(new Matrix(covariancia));
//        printMatriz(svd.getV().getArray());
//        

        /*
         * Decidir quantas componentes principais
         */
        LinkedList<Integer> lista = new LinkedList<Integer>();
        double[] d = e.getRealEigenvalues();
        double soma = 0;
        for (int i = 0; i < d.length; i++) {
            soma += d[i];
            lista.add(i);
        }
        
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i] + "\t quanto explica=  " + (d[i] / soma));
        }

        int[] colunas = new int[d.length];    

        while (!lista.isEmpty()) {
            double max = Double.MIN_VALUE;
            int valor = 0;
            for (int i = 0; i < d.length; i++) {
                if (lista.contains(i)) {
                    if (max < d[i]) {
                        max = d[i];
                        valor = i;
                    }
                }
            }
            colunas[d.length - lista.size()] = valor;
            lista.remove(new Integer(valor));
        }


        
        
        Matrix autovetor = e.getV().getMatrix(0, entrada.length - 1, colunas);

        /*
         * Transformar os valores        
         */

        Matrix temp = new Matrix(entrada);
//        temp=svd.getV().transpose().times(temp);


//        => temp=e.getV().times(temp);

        temp = autovetor.transpose().times(temp);
        temp = temp.times(-1);
        saida = temp.getArray();


        return saida;
    }

    private static double[][] cloneInput(Object[][] input) {
        double[][] s = new double[input.length][input[0].length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                s[i][j] = (Double) input[i][j];
            }
        }
        return s;
    }

    private static void centralizar(double[][] dados) {

        //inicializa
        double soma[] = new double[dados.length];
        for (int y = 0; y < soma.length; y++) {
            soma[y] = 0;
        }

        //soma
        for (int linha = 0; linha < dados[0].length; linha++) {
            for (int coluna = 0; coluna < dados.length; coluna++) {
                soma[coluna] += dados[coluna][linha];
            }
        }

        //centraliza na media
        for (int coluna = 0; coluna < dados.length; coluna++) {
            for (int linha = 0; linha < dados[0].length; linha++) {
                dados[coluna][linha] = dados[coluna][linha] - (soma[coluna] / dados[0].length);
            }
        }

    }

    public static double[][] calculaMatrizCovariancia(double[][] v) {
//        int m = v.length;
//        int n = v[0].length;
        int n = v.length;
        int m = v[0].length;
        double[][] X = new double[n][n];
        int degrees = (m - 1);
        double c;
        double s1;
        double s2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c = 0;
                s1 = 0;
                s2 = 0;
                for (int k = 0; k < m; k++) {
                    s1 += v[i][k];
                    s2 += v[j][k];
                }
                s1 = s1 / m;
                s2 = s2 / m;
                for (int k = 0; k < m; k++) {
                    c += (v[i][k] - s1) * (v[j][k] - s2);
                }
                X[i][j] = c / degrees;
            }
        }
        return X;
    }

    public static void printMatriz(double[][] p) {
        System.out.println("******************");


        for (int y = 0; y < p[0].length; y++) {
            for (int x = 0; x < p.length; x++) {
                System.out.print(p[x][y]);
                if ((x + 1) != p.length) {
                    System.out.print(",");
                }
            }
            System.out.println("");
        }

        System.out.println("******************");
    }
    
    
    
    
    
}
