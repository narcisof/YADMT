/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kohonen.visualization;

import javax.vecmath.Vector3d;

/**
 *
 * @author Thiago Faino
 */
public class UtilKohonenVisualization {

    public void Util() {
    }
     public static Vector3d calcula_n(Vector3d VRP, Vector3d P) {
         
        Vector3d N = new Vector3d();
        Vector3d n = new Vector3d();
        N.sub(VRP, P);
       
        // Normaliza N
        N.normalize();
        n = N;
      
        return n;
    }

    public static Vector3d calcula_v(Vector3d n) {
        
        Vector3d V = new Vector3d();
        Vector3d v = new Vector3d();
        Vector3d Y = new Vector3d(0, 0, -1);
        Vector3d Y1 = new Vector3d(0, 0, -1);
        double resY1;
        // Projetar um vetor Y com norma 1 (0,1,0)
        // V = Y - (Y*n) * n
        // (Y*n) * n = Y1
        // V = Y - Y1
        Y1.scale(Y1.dot(n), n);
        V.sub(Y, Y1);
        
        // Normaliza V
        V.normalize();
        v = V;
        return v;
    }

    public static Vector3d calcula_u(Vector3d v, Vector3d n) {
        Vector3d u = new Vector3d();
        // u = vxn
        u = new Vector3d();
        u.cross(v, n);
        
        return u;
    }
    public static double[] subVector(double[] a, double[] b){
        double[] result = new double[3];
        
        for (int i = 0; i < 3; i++) {
            result[i] = a[i] - b[i];
        }
        return result;
    }
    
    public static double[] normaVector(double[] a){
        double N = 0;
        double[] result = new double[3];
        
        for (int i = 0; i < 3; i++) {
            N += Math.pow(a[i], 2);
        }
        N = Math.sqrt(N);
        for (int i = 0; i < 3; i++) {
            result[i] = a[i]/N;
        }
        
        return result;
    }
    public static double[][] multiMatriz(double a[][], double b[][], int res_linha, int res_coluna) {

        int row, column, i;
        double aux;
        double c[][] = new double[res_linha][res_coluna];
        for (row = 0; row < c.length; row++) {
            // multiplicação das matrizes  
            for (column = 0; column < c[row].length; column++) {
                aux = 0;
                for (i = 0; i < a[row].length; i++) {
                    aux = aux + a[row][i] * b[i][column];
                }
                c[row][column] = aux;

            }
        }
        
        for (int x = 0; x < res_linha; x++) {
            for (int j = 0; j < res_coluna; j++) {
                c[x][j] = ( Math.round( (c[x][j] * 100000.0) ) ) / 100000.0;  
            }
            
        }
        return c;
    }
}
