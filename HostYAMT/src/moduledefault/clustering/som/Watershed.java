/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Thiago M. Faino
 */
public class Watershed {

    ArrayList<Pixel> pilha = new ArrayList<>();
    ArrayList<ArrayList<Elemento>> grupos;

    public Watershed() {
        
    }

    public ArrayList<ArrayList<Elemento>> watershed(double[][] matrizU, int[][] Lentrada) {
        int largura = matrizU.length;
        int altura = matrizU[0].length;

        double max = 0;
        for (int i = 0; i < matrizU.length; i++) {
            for (int j = 0; j < matrizU[0].length; j++) {
                if (matrizU[i][j] > max) {
                    max = matrizU[i][j];
                }
            }
        }

        int[][] f = new int[matrizU.length][matrizU[0].length]; //imagem de entrada
        double num;
        for (int i = 0; i < matrizU.length; i++) {
            for (int j = 0; j < matrizU[0].length; j++) {
                num = (matrizU[i][j] * 255) / max;
                f[i][j] = (int) num;
            }
        }

        int[][] L;
        if (Lentrada == null) {
            L = marcadores(matrizU); //imagem com os marcadores - Saida do algoritmo
        } else {
            L = new int[Lentrada.length][Lentrada[0].length];
            for (int i = 0; i < Lentrada.length; i++) {
                System.arraycopy(Lentrada[i], 0, L[i], 0, Lentrada[0].length);
            }
        }

        int[][] ws = new int[largura][altura]; //linhas de watershed
        boolean[][] flag = new boolean[largura][altura];

        //Inicialização
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                if (L[i][j] != 0) {
                    pilha.add(new Pixel(i, j, f[i][j]));
                }
                ws[i][j] = 0;
                flag[i][j] = false;
            }
        }

        SelectionSort(pilha);
        while (!pilha.isEmpty()) {
            Pixel p = pilha.remove(0);
            int x = p.getX();
            int y = p.getY();
            flag[x][y] = true;
            ArrayList<Pixel> aux = new ArrayList<>();
            for (int i = (x - 1); i <= (x + 1); i++) {
                for (int j = (y - 1); j <= (y + 1); j++) {
                    if ((i >= largura) || (i < 0) || (j >= altura) || (j < 0)) {
                        continue;
                    }
                    if (flag[i][j] == false) {
                        if (L[i][j] == 0) {
                            L[i][j] = L[x][y];
                            aux.add(new Pixel(i, j, f[i][j]));
                        } else {
                            if ((L[x][y] != L[i][j]) && (ws[x][y] == 0 && ws[i][j] == 0)) {
                                ws[i][j] = 1;
                            }
                        }
                    }
                }
            }
            SelectionSort(aux);
            for (int i = 0; i < aux.size(); i++) {
                pilha.add(aux.get(i));
            }
        }

        int[][] water = new int[ws.length][ws[0].length];
        for (int i = 0; i < water.length; i++) {
            for (int j = 0; j < water[0].length; j++) {
                if (ws[i][j] == 0) {
                    water[i][j] = 1;
                }else{
                    water[i][j] = 0;
                }
            }
        }
        ArrayList<ArrayList<Elemento>> result = componentesList(water);
        FrameWatershed frame = new FrameWatershed(ws, result);
        frame.setVisible(true);
        return result;
    }

    public int[][] marcadores(double matrizU[][]) {
        //Aplica escala 0 - 255
        double max = 0;
        for (int i = 0; i < matrizU.length; i++) {
            for (int j = 0; j < matrizU[0].length; j++) {
                if (matrizU[i][j] > max) {
                    max = matrizU[i][j];
                }
            }
        }
        int[][] matriz = new int[matrizU.length][matrizU[0].length];
        double num;
        for (int i = 0; i < matrizU.length; i++) {
            for (int j = 0; j < matrizU[0].length; j++) {
                num = (matrizU[i][j] * 255) / max;
                matriz[i][j] = (int) num;
            }
        }

        int max1 = 0;
        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > max1) {
                    max1 = matriz[i][j];
                }
                if (matriz[i][j] < min1) {
                    min1 = matriz[i][j];
                }
            }
        }

        ArrayList<int[][]> listaLimiar = new ArrayList<>();
        for (int i = min1; i < max1; i++) {
            int[][] aux = new int[matriz.length][matriz[0].length];
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz[0].length; k++) {
                    if (matriz[j][k] < i) {
                        aux[j][k] = 0;
                    } else {
                        aux[j][k] = 1;
                    }
                }
            }
            listaLimiar.add(aux);
        }

        ArrayList<Integer> grafico = new ArrayList<>();
        for (int i = min1; i < max1; i++) {
            dilation(listaLimiar.get(i), 1);
            grafico.add(componentes(listaLimiar.get(i)));
        }

        int limiar = 0;
        int k = 0;
        int maxlimiar = 0;
        int numero;
        for (int i = 0; i < grafico.size() - 1; i++) {
            numero = grafico.get(i);
            for (int j = i + 1; j < grafico.size(); j++) {
                if (numero == grafico.get(j)) {
                    ++k;
                } else {
                    break;
                }
            }
            if (k > maxlimiar) {
                maxlimiar = k;
                limiar = i;
            }
            k = 0;
        }
        //System.out.println("marcadores: " + grafico.get(limiar));
        //System.out.println("limiar escolhido: " + limiar);
        ////////////////

        int[][] aux = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] < limiar + 1) {
                    aux[i][j] = 1;
                } else {
                    aux[i][j] = 0;
                }
            }
        }
        dilation(aux, 1);
        ArrayList<ArrayList<Elemento>> marcadores = componentesList(aux);
        int cont = 1;
        
        for (int i = 0; i < marcadores.size(); i++) {
            for (int j = 0; j < marcadores.get(i).size(); j++) {
                aux[marcadores.get(i).get(j).getI()][marcadores.get(i).get(j).getJ()] = cont;
            }
            ++cont;
        }
        return aux;
    }

    public int componentes(int[][] matriz) {
        int result = 0;
        //
        ArrayList<Elemento> elementos;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != 0) {
                    elementos = new ArrayList<>();
                    elementos.add(new Elemento(i, j));
                    analise(elementos, matriz, 0);
                    remove(elementos, matriz);
                    ++result;
                }
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Elemento>> componentesList(int[][] matriz) {
        ArrayList<ArrayList<Elemento>> result = new ArrayList<>();
        //
        ArrayList<Elemento> elementos;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != 0) {
                    elementos = new ArrayList<>();
                    elementos.add(new Elemento(i, j));
                    analise(elementos, matriz, 0);
                    result.add(elementos);
                    remove(elementos, matriz);
                }
            }
        }
        return result;
    }

    public void analise(ArrayList<Elemento> elementos, int[][] matriz, int cont) {
        Elemento padrao = elementos.get(cont);
        for (int i = (padrao.getI() - 1); i <= (padrao.getI() + 1); i++) {
            for (int j = (padrao.getJ() - 1); j <= (padrao.getJ() + 1); j++) {
                if ((i >= matriz.length) || (i < 0) || (j >= matriz[0].length) || (j < 0)
                        || (i == padrao.getI() && j == padrao.getJ())) {
                    continue;
                }
                if (matriz[i][j] != 0 && !contains(elementos, i, j)) {
                    elementos.add(new Elemento(i, j));
                    ++cont;
                    analise(elementos, matriz, cont);
                }
            }
        }
    }

    public boolean contains(ArrayList<Elemento> elementos, int i, int j) {
        boolean flag = false;
        for (int k = 0; k < elementos.size(); k++) {
            Elemento pad = elementos.get(k);
            if (pad.getI() == i && pad.getJ() == j) {
                flag = true;
            }
        }
        return flag;
    }

    public void remove(ArrayList<Elemento> elementos, int[][] matriz) {
        for (int i = 0; i < elementos.size(); i++) {
            matriz[elementos.get(i).getI()][elementos.get(i).getJ()] = 0;
        }
    }

    public static void erosion(int[][] bmp, int n) {
        int max, level;
        int largura = bmp.length;
        int altura = bmp[0].length;

        int[][] dilationParcial = new int[largura][altura];

        for (int y = 0; y < largura; y++) {
            for (int x = 0; x < altura; x++) {
                max = Integer.MIN_VALUE;
                for (int i = -n; i <= n; i++) {
                    if (x + i < 0 || x + i >= altura) {
                        continue;
                    }
                    level = bmp[y][x + i];
                    if (level > max) {
                        max = level;
                    }
                }
                dilationParcial[y][x] = max;
            }
        }

        for (int y = 0; y < largura; y++) {
            for (int x = 0; x < altura; x++) {
                max = Integer.MIN_VALUE;
                for (int j = -n; j <= n; j++) {
                    if (y + j < 0 || y + j >= largura) {
                        continue;
                    }
                    level = dilationParcial[y + j][x];
                    if (level > max) {
                        max = level;
                    }
                }
                bmp[y][x] = max;
            }
        }
    }

    public static void dilation(int[][] bmp, int n) {
        int min, level;
        int largura = bmp.length;
        int altura = bmp[0].length;

        int[][] erosionParcial = new int[largura][altura];

        for (int y = 0; y < largura; y++) {
            for (int x = 0; x < altura; x++) {
                min = Integer.MAX_VALUE;
                for (int i = -n; i <= n; i++) {
                    if (x + i < 0 || x + i >= altura) {
                        continue;
                    }
                    level = bmp[y][x + i];
                    if (level < min) {
                        min = level;
                    }
                }
                erosionParcial[y][x] = min;
            }
        }

        for (int y = 0; y < largura; y++) {
            for (int x = 0; x < altura; x++) {
                min = Integer.MAX_VALUE;
                for (int j = -n; j <= n; j++) {
                    if (y + j < 0 || y + j >= largura) {
                        continue;
                    }
                    level = erosionParcial[y + j][x];
                    if (level < min) {
                        min = level;
                    }
                }
                bmp[y][x] = min;
            }
        }
    }
    
     //TROCAR POR MERGE SORT
    public void SelectionSort(ArrayList<Pixel> pixel) { //ORDENA EM ORDEM CRESCENTE POR PADRÕES CARREGADOS
        int index_min;
        Pixel aux;

        for (int i = 0; i < pixel.size(); i++) {
            index_min = i;
            for (int j = i + 1; j < pixel.size(); j++) {
                if (pixel.get(j).getRgb() < pixel.get(index_min).getRgb()) {
                    index_min = j;
                }
            }
            if (index_min != i) {
                aux = pixel.get(index_min);
                pixel.set(index_min, pixel.get(i));
                pixel.set(i, aux);
            }
        }
        Collections.reverse(pixel);
    }
}
