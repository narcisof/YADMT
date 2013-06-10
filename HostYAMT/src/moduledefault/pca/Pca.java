/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.pca;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;
import interfaces.Base;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author TyTu
 */
public class Pca {

    private Base base;
    EigenvalueDecomposition e;
    int[] colunas;
    double[][] entrada;

    public Pca(Base base) {
        this.base = base;
    }

    public double[][] ObjectToDouble(Object[][] entrada) {
        double[][] d = new double[entrada[0].length][entrada.length];
        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; i < entrada.length; i++) {
            for (int j = 0; j < entrada[0].length; j++) {
                
                try{ //se for numero
                    d[j][i] = new Double(entrada[i][j].toString());
                    
                }catch (NumberFormatException e){ //não é numero!!!!!
                    
                    int index = strings.indexOf(entrada[i][j].toString());
                    if (index >= 0) {
                        d[j][i] = index;
                    } else {
                        strings.add(entrada[i][j].toString());
                        d[j][i] = strings.indexOf(entrada[i][j].toString());
                    }
                }
                
            }
        }
        return d;
    }

    public Object[][] doubleToObject(double[][] d) {
        Object[][] o = new Object[d[0].length][d.length];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                o[j][i] = d[i][j];
            }
        }

        return o;
    }

    public String[] calcula() { //calcula e retorna nome das componentes e valores calculados
        entrada = ObjectToDouble(base.getInput());

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
        e = new EigenvalueDecomposition(new Matrix(covariancia));




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
        String[] saida = new String[d.length];
        colunas = new int[d.length];
        for (int i = d.length-1; i >=0; i--) {
            saida[(d.length-1)-i] = "" + (d[i] / soma);
            colunas[(d.length-1)-i] = i;
        }


        return saida;
    }

    public void extrair(int num) {
        int[] col = new int[num];
        System.arraycopy(colunas, 0, col, 0, num);

        Matrix autovetor = e.getV().getMatrix(0, entrada.length - 1, col);

        /*
         * Transformar os valores        
         */

        Matrix temp = new Matrix(entrada);
//        temp=svd.getV().transpose().times(temp);


//        => temp=e.getV().times(temp);

        temp = autovetor.transpose().times(temp);
        temp = temp.times(-1);
        double[][] saida;
        saida = temp.getArray();

        base.setInput(doubleToObject(saida));
        String[] atributosNovos = new String[base.getInput()[0].length + 1];
        for (int i = 0; i < base.getInput()[0].length; i++) {
            atributosNovos[i] = "PC" + i;
        }
        atributosNovos[base.getInput()[0].length] = base.getAtributes()[base.getAtributes().length - 1];
        base.setAtributes(atributosNovos);

    }

//    public static void transforma(Base base){
//        
//        base.setInput( Pca1.transforma(base.getInput()) );
//        
//        
//        String[] atributosNovos= new String[base.getInput()[0].length+1];
//        for(int i = 0 ;i <base.getInput()[0].length; i++){
//            atributosNovos[i]="PC"+i;
//        }
//        atributosNovos[base.getInput()[0].length] = base.getAtributes()[base.getAtributes().length-1];
//        base.setAtributes(atributosNovos);
//        
//        
//    }
    private void centralizar(double[][] dados) {

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

    public double[][] calculaMatrizCovariancia(double[][] v) {
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
}
