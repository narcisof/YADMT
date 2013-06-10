/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.kohonen.visualization;

import java.awt.Point;
import java.util.ArrayList;
import javax.vecmath.Vector3d;

/**
 *
 * @author Thiago Faino
 */
public final class Projetor {

    double VRP[] = new double[4]; //Posicao do observador no mundo
    double Ponto[] = {0, 0, 0, 1}; //Ponto onde a camera esta apontada
    private Vector3d u, n, v;
    double viewPort[] = {0, 0, 110, 20}; //Tamanho da tela
    double Dx; //Xmax - Xmin da viewport
    double Dy; //Ymax - Ymin da viewport
    double window[] = {0, 0, 10, 5};  //(cu, cv) = centro da window su = 1/2 largura da window sv = 1/2 altura da window
    //distancia entre o observador e os planos de recorte frontal e traseiro
    double near = 70; //Zmin
    double far = 130; //Zmax
    double zmin = 0.538462; //near/far
    double d; //distancia entre o observador e o plano
    double Dz = 60; //far - near 
    //Transformacao de camera
    double V[][] = new double[4][4]; //R*T = Realiza a conversão das coordenadas de mundo para coordenadas de câmera
    //Transformacao de Recorte
    double C[][] = new double[4][4]; //D*E = Realiza a transformação de recorte
    //Transformacao perspectiva
    double P[][] = new double[4][4]; //Faz a projeção perspectiva levando o VRP para o infinito. A projeção passa a ser uma projeção paralela ortográfica ao ignorar a coordenada z    
    //Trnasformacao do Dispositivo
    double S[][] = new double[4][4]; //M*L*K = Realiza o mapeamento do volume canônico para coordenadas da viewport
    //Transformacao Ortografica
    double O[][] = new double[4][4];
    //Concatenacao Final
    double TP[][] = new double[4][4]; //S*P*C*V = Faz o mapeamento em perspectiva das coordenadas do objeto de SRU para SRT

    public Projetor(int tamX, int tamY) {
        Dx = tamX;
        Dy = tamY;
    }

    public void camera() {
        //MODELO DE CAMERA ALVY RAY SMITH

        Vector3d auxP = new Vector3d(Ponto[0], Ponto[1], Ponto[2]);
        Vector3d auxVRP = new Vector3d(VRP[0], VRP[1], VRP[2]);
        n = UtilKohonenVisualization.calcula_n(auxP, auxVRP);
        v = UtilKohonenVisualization.calcula_v(n);
        u = UtilKohonenVisualization.calcula_u(n, v);

        double R[][] = new double[4][4]; //Realiza uma seqüência de rotações que alinha os eixos dos sistemas de coordenadas do mundo e de câmera
        double T[][] = new double[4][4]; //Realiza a translação que move a câmera para a origem do mundo

        R[0][0] = u.x;
        R[0][1] = u.y;
        R[0][2] = u.z;
        R[0][3] = 0;
        R[1][0] = v.x;
        R[1][1] = v.y;
        R[1][2] = v.z;
        R[1][3] = 0;
        R[2][0] = n.x;
        R[2][1] = n.y;
        R[2][2] = n.z;
        R[2][3] = 0;
        R[3][0] = 0;
        R[3][1] = 0;
        R[3][2] = 0;
        R[3][3] = 1;

        T[0][0] = 1;
        T[0][1] = 0;
        T[0][2] = 0;
        T[0][3] = -VRP[0];
        T[1][0] = 0;
        T[1][1] = 1;
        T[1][2] = 0;
        T[1][3] = -VRP[1];
        T[2][0] = 0;
        T[2][1] = 0;
        T[2][2] = 1;
        T[2][3] = -VRP[2];
        T[3][0] = 0;
        T[3][1] = 0;
        T[3][2] = 0;
        T[3][3] = 1;

        V = UtilKohonenVisualization.multiMatriz(R, T, 4, 4);

    }

    public void recorte() {
        double D[][] = new double[4][4]; //Faz um cisalhamento para alinhar o centro da imagem com o eixo z. Necessário porque a janela de imagem pode não estar centralizada.
        double E[][] = new double[4][4]; //Faz um escalonamento tal que a base da pirâmide de visão seja mapeada o quadrado unitário sobre o plano z = 1

        D[0][0] = 1;
        D[0][1] = 0;
        D[0][2] = -window[0] / d;
        D[0][3] = 0;
        D[1][0] = 0;
        D[1][1] = 1;
        D[1][2] = -window[1] / d;
        D[1][3] = 0;
        D[2][0] = 0;
        D[2][1] = 0;
        D[2][2] = 1;
        D[2][3] = 0;
        D[3][0] = 0;
        D[3][1] = 0;
        D[3][2] = 0;
        D[3][3] = 1;


        E[0][0] = d / (window[2] * far);
        E[0][1] = 0;
        E[0][2] = 0;
        E[0][3] = 0;
        E[1][0] = 0;
        E[1][1] = d / (window[3] * far);
        E[1][2] = 0;
        E[1][3] = 0;
        E[2][0] = 0;
        E[2][1] = 0;
        E[2][2] = 1 / far;
        E[2][3] = 0;
        E[3][0] = 0;
        E[3][1] = 0;
        E[3][2] = 0;
        E[3][3] = 1;

        C = UtilKohonenVisualization.multiMatriz(E, D, 4, 4);
    }

    public void ortografica() {
        double Fo[][] = new double[4][4];
        double Go[][] = new double[4][4];


        Fo[0][0] = 1;
        Fo[0][1] = 0;
        Fo[0][2] = 0;
        Fo[0][3] = 0;
        Fo[1][0] = 0;
        Fo[1][1] = 1;
        Fo[1][2] = 0;
        Fo[1][3] = 0;
        Fo[2][0] = 0;
        Fo[2][1] = 0;
        Fo[2][2] = 1;
        Fo[2][3] = -near;
        Fo[3][0] = 0;
        Fo[3][1] = 0;
        Fo[3][2] = 0;
        Fo[3][3] = 1;

        Go[0][0] = 1 / window[2];
        Go[0][1] = 0;
        Go[0][2] = 0;
        Go[0][3] = 0;
        Go[1][0] = 0;
        Go[1][1] = 1 / window[3];
        Go[1][2] = 0;
        Go[1][3] = 0;
        Go[2][0] = 0;
        Go[2][1] = 0;
        Go[2][2] = 1 / (far - near);
        Go[2][3] = 0;
        Go[3][0] = 0;
        Go[3][1] = 0;
        Go[3][2] = 0;
        Go[3][3] = 1;

        O = UtilKohonenVisualization.multiMatriz(Fo, Go, 4, 4);
    }

    public void perspectiva() {
        double F[][] = new double[4][4]; //Translada zmin para a origem
        double G[][] = new double[4][4]; //Escala o volume canônico em z para que o plano traseiro coincida com o plano z = 1
        double H[][] = new double[4][4]; //Realiza a transformação projetiva
        double J[][] = new double[4][4]; //Multiplica as 3 primeiras linhas da matriz I pelo escalar  1/zmin. Leva o tronco da pirâmide no prisma com dimensões 2.zmin em x e y e zmin em z.
        double I[][]; //Concatenação das Matrizes F, G e H

        F[0][0] = 1;
        F[0][1] = 0;
        F[0][2] = 0;
        F[0][3] = 0;
        F[1][0] = 0;
        F[1][1] = 1;
        F[1][2] = 0;
        F[1][3] = 0;
        F[2][0] = 0;
        F[2][1] = 0;
        F[2][2] = 1;
        F[2][3] = -zmin;
        F[3][0] = 0;
        F[3][1] = 0;
        F[3][2] = 0;
        F[3][3] = 1;

        G[0][0] = 1;
        G[0][1] = 0;
        G[0][2] = 0;
        G[0][3] = 0;
        G[1][0] = 0;
        G[1][1] = 1;
        G[1][2] = 0;
        G[1][3] = 0;
        G[2][0] = 0;
        G[2][1] = 0;
        G[2][2] = 1 / (1 - zmin);
        G[2][3] = 0;
        G[3][0] = 0;
        G[3][1] = 0;
        G[3][2] = 0;
        G[3][3] = 1;

        H[0][0] = 1;
        H[0][1] = 0;
        H[0][2] = 0;
        H[0][3] = 0;
        H[1][0] = 0;
        H[1][1] = 1;
        H[1][2] = 0;
        H[1][3] = 0;
        H[2][0] = 0;
        H[2][1] = 0;
        H[2][2] = 1;
        H[2][3] = 0;
        H[3][0] = 0;
        H[3][1] = 0;
        H[3][2] = (1 - zmin) / zmin;
        H[3][3] = 1;

        I = UtilKohonenVisualization.multiMatriz(G, F, 4, 4);

        I = UtilKohonenVisualization.multiMatriz(H, I, 4, 4);

        J[0][0] = 1 / zmin * I[0][0];
        J[0][1] = 0;
        J[0][2] = 0;
        J[0][3] = 0;
        J[1][0] = 0;
        J[1][1] = 1 / zmin * I[1][1];
        J[1][2] = 0;
        J[1][3] = 0;
        J[2][0] = 0;
        J[2][1] = 0;
        J[2][2] = 1 / zmin * I[2][2];
        J[2][3] = 1 / zmin * I[2][3];
        J[3][0] = 0;
        J[3][1] = 0;
        J[3][2] = I[3][2];
        J[3][3] = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                P[i][j] = J[i][j] * zmin;
            }
        }

    }

    public void dispositivo() {
        double K[][] = new double[4][4]; //Translada o volume de visão canônico de forma que o vértice (-1 -1 0 1) vá para a origem e aplica um fator de escala de 0,5 em x e y
        double L[][] = new double[4][4];
        double M[][] = new double[4][4]; //Faz o arredondamento para o pixel inteiro mais próximo

        K[0][0] = 0.5;
        K[0][1] = 0;
        K[0][2] = 0;
        K[0][3] = 0.5;
        K[1][0] = 0;
        K[1][1] = 0.5;
        K[1][2] = 0;
        K[1][3] = 0.5;
        K[2][0] = 0;
        K[2][1] = 0;
        K[2][2] = 1;
        K[2][3] = 0;
        K[3][0] = 0;
        K[3][1] = 0;
        K[3][2] = 0;
        K[3][3] = 1;

        L[0][0] = Dx;
        L[0][1] = 0;
        L[0][2] = 0;
        L[0][3] = viewPort[0];
        L[1][0] = 0;
        L[1][1] = Dy;
        L[1][2] = 0;
        L[1][3] = viewPort[1];
        L[2][0] = 0;
        L[2][1] = 0;
        L[2][2] = Dz;
        L[2][3] = near;
        L[3][0] = 0;
        L[3][1] = 0;
        L[3][2] = 0;
        L[3][3] = 1;

        M[0][0] = 1;
        M[0][1] = 0;
        M[0][2] = 0;
        M[0][3] = 0.5;
        M[1][0] = 0;
        M[1][1] = 1;
        M[1][2] = 0;
        M[1][3] = 0.5;
        M[2][0] = 0;
        M[2][1] = 0;
        M[2][2] = 1;
        M[2][3] = 0.5;
        M[3][0] = 0;
        M[3][1] = 0;
        M[3][2] = 0;
        M[3][3] = 1;

        S = UtilKohonenVisualization.multiMatriz(L, K, 4, 4);
        S = UtilKohonenVisualization.multiMatriz(M, S, 4, 4);

    }

    public void sruTOsrt() {//0 = Perspectiva  1 = Ortografica
        double aux1[][];
        double aux2[][];
        aux1 = UtilKohonenVisualization.multiMatriz(C, V, 4, 4);
        aux2 = UtilKohonenVisualization.multiMatriz(S, P, 4, 4);
        TP = UtilKohonenVisualization.multiMatriz(aux2, aux1, 4, 4);
    
}
public ArrayList<Point> convert3Dto2D(double a[][], int colunas, double vrp[], int aux, double pe[]) { //op = 0(Perspectiva) op = 1 (Ortografica)
        VRP = vrp; //Posicao do observador no mundo
        Ponto = pe;
        d = aux;
        camera();
        recorte();
        perspectiva();
        dispositivo();
        sruTOsrt();

        ArrayList<Point> pontos = new ArrayList<>();
        double pontosfinal[][] = UtilKohonenVisualization.multiMatriz(TP, a, 4, colunas);

        for (int j = 0; j < colunas; j++) {
            pontosfinal[0][j] = pontosfinal[0][j] / pontosfinal[3][j];
            pontosfinal[1][j] = pontosfinal[1][j] / pontosfinal[3][j];
            pontosfinal[2][j] = pontosfinal[2][j] / pontosfinal[3][j];
            pontosfinal[3][j] = pontosfinal[3][j] / pontosfinal[3][j];
        }

        for (int j = 0; j < colunas; j++) {
            Point p = new Point((int) pontosfinal[0][j], (int) pontosfinal[1][j]);
            pontos.add(p);
        }
        return pontos;
    }

    public double[][] getTP() {
        return TP;
    }

    public void setTP(double[][] TP) {
        this.TP = TP;
    }
}
