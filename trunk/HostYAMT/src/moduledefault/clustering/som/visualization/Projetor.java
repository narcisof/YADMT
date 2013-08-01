/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som.visualization;

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

        double R[][] = {{u.x, u.y, u.z, 0}, //Realiza uma seqüência de rotações que alinha os eixos dos sistemas de coordenadas do mundo e de câmera
            {v.x, v.y, v.z, 0},
            {n.x, n.y, n.z, 0},
            {0, 0, 0, 1}};

        double T[][] = {{1, 0, 0, -VRP[0]}, //Realiza a translação que move a câmera para a origem do mundo
            {0, 1, 0, -VRP[1]},
            {0, 0, 1, -VRP[2]},
            {0, 0, 0, 1}};

        V = UtilKohonenVisualization.multiMatriz(R, T, 4, 4);

    }

    public void recorte() {
        double D[][] = {{1, 0, -window[0] / d, 0}, //Faz um cisalhamento para alinhar o centro da imagem com o eixo z. Necessário porque a janela de imagem pode não estar centralizada.
            {0, 1, -window[1] / d, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}};

        double E[][] = {{d / (window[2] * far), 0, 0, 0}, //Faz um escalonamento tal que a base da pirâmide de visão seja mapeada o quadrado unitário sobre o plano z = 1
            {0, d / (window[3] * far), 0, 0},
            {0, 0, 1 / far, 0},
            {0, 0, 0, 1}};

        C = UtilKohonenVisualization.multiMatriz(E, D, 4, 4);
    }

    public void perspectiva() {
        double I[][]; //Concatenação das Matrizes F, G e H

        double F[][] = {{1, 0, 0, 0}, //Translada zmin para a origem
            {0, 1, 0, 0},
            {0, 0, 1, -zmin},
            {0, 0, 0, 1}};

        double G[][] = {{1, 0, 0, 0}, //Escala o volume canônico em z para que o plano traseiro coincida com o plano z = 1
            {0, 1, 0, 0},
            {0, 0, 1 / (1 - zmin), 0},
            {0, 0, 0, 1}};

        double H[][] = {{1, 0, 0, 0}, //Realiza a transformação projetiva
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, (1 - zmin) / zmin, 1}};


        I = UtilKohonenVisualization.multiMatriz(G, F, 4, 4);
        I = UtilKohonenVisualization.multiMatriz(H, I, 4, 4);

        double J[][] = {{1 / zmin * I[0][0], 0, 0, 0}, //Multiplica as 3 primeiras linhas da matriz I pelo escalar  1/zmin. Leva o tronco da pirâmide no prisma com dimensões 2.zmin em x e y e zmin em z.
            {0, 1 / zmin * I[1][1], 0, 0},
            {0, 0, 1 / zmin * I[2][2], 1 / zmin * I[2][3]},
            {0, 0, I[3][2], 0}};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                P[i][j] = J[i][j] * zmin;
            }
        }

    }

    public void dispositivo() {
        double K[][] = {{0.5, 0, 0, 0.5}, //Translada o volume de visão canônico de forma que o vértice (-1 -1 0 1) vá para a origem e aplica um fator de escala de 0,5 em x e y
            {0, 0.5, 0, 0.5},
            {0, 0, 1, 0},
            {0, 0, 0, 1}};

        double L[][] = {{Dx, 0, 0, viewPort[0]},
            {0, Dy, 0, viewPort[1]},
            {0, 0, Dz, near},
            {0, 0, 0, 1}};

        double M[][] = {{1, 0, 0, 0.5}, //Faz o arredondamento para o pixel inteiro mais próximo
            {0, 1, 0, 0.5},
            {0, 0, 1, 0.5},
            {0, 0, 0, 1}};

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

}
