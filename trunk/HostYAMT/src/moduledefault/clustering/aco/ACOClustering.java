package moduledefault.clustering.aco;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import moduledefault.clustering.distancias.Chebyshev;
import moduledefault.clustering.distancias.CityBlock;
import moduledefault.clustering.distancias.Correlação;
import moduledefault.clustering.distancias.Cosseno;
import moduledefault.clustering.distancias.DistanciaEuclidiana;
import moduledefault.clustering.distancias.Mahalanobis;
import moduledefault.clustering.uteis.MatrizDados;
import moduledefault.clustering.uteis.Operações_Mat;
import moduledefault.clustering.visualization.TecnicasDispersao;

/**
 *
 * @author Mateus
 */
public class ACOClustering {

    int sigma;
    double sigma_auxiliar = sigma;
    double alfa;
    int cont2, cont;
    double sigmaminimo, sigmamaximo, controlesigma;
    double alfaminimo, alfamaximo, controlealfa;
    double percent1;
    int teste_atribui = 0;
    int form[][];// = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int teste_carrega = 0;
    int linha_anterior, coluna_anterior;
    double[] distâncias = new double[1000];
    double[] distâncias2 = new double[1000];
    int índice = 0;
    int índice2 = 0;
    Operações_Mat matematica;
    double[][] matriz_distancias;
    int contcarrega = 0;
    boolean teste_fases = true;
    int[][] matriz_padrao;
    MatrizDados arquivo;
    double vetorMaiorF[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    MatrizDados dados;
    public ACOClustering(MatrizDados teste, int teste_distancia, int[][] _matriz_padrao) throws IOException {
        arquivo = teste;
        matematica = new Operações_Mat();
//         matematica.Padronização(teste);
        matriz_padrao = new int[_matriz_padrao.length][_matriz_padrao.length];
        matriz_distancias = new double[teste.getLinhas()][teste.getLinhas()];
        for (int i = 0; i < _matriz_padrao.length; i++) {
            for (int j = 0; j < _matriz_padrao.length; j++) {
                matriz_padrao[i][j] = _matriz_padrao[i][j];
            }
        }
        cont = 0;
        if (teste_distancia == 5) {
            DistanciaEuclidiana distância = new DistanciaEuclidiana(teste);
            distância.distancia(teste);
            matriz_distancias = distância.getMatrizDistancias();
        } else {
            if (teste_distancia == 4) {
                Cosseno distância = new Cosseno(teste);
                distância.distancia(teste);
                matriz_distancias = distância.getMatrizDistancias();
            } else {
                if (teste_distancia == 3) {
                    Correlação distância = new Correlação(teste);
                    distância.distancia(teste);
                    matriz_distancias = distância.getMatrizDistancias();
                } else {
                    if (teste_distancia == 6) {
                        Mahalanobis distância = new Mahalanobis(teste);
                        distância.distancia(teste);
                        matriz_distancias = distância.getMatrizDistancias();
                    } else {
                        if (teste_distancia == 2) {
                            CityBlock distancia = new CityBlock(teste);
                            distancia.distancia(teste);
                            matriz_distancias = distancia.getMatrizDistancias();
                        } else {
                            if (teste_distancia == 1) {
                                Chebyshev distancia = new Chebyshev(teste);
                                distancia.distancia(teste);
                                matriz_distancias = distancia.getMatrizDistancias();
                            }
                        }
                    }
                }

            }
        }
//        
//        System.out.println("Matriz correlacao");
//        for (int i = 0; i < matriz_distancias.length; i++) {
//            for (int j = 0; j < matriz_distancias.length; j++) {
//                System.out.print(matriz_distancias[i][j]+";");
//            }
//            System.out.println();
//        }
    }

    public MatrizDados getArquivo() {
        return arquivo;
    }

    public void set_sigma(int set_sigma) {
        sigma = set_sigma;
        set_sigma_auxiliar(sigma);
    }

    public void set_sigma_auxiliar(int set_sigma_auxiliar) {
        sigma_auxiliar = set_sigma_auxiliar;
    }

    public void set_alfa(double set_alfa) {
        alfa = set_alfa;
//        System.out.println("afla = " + alfa);
    }

    public void set_cont2(int colunas, int linhas) throws IOException {
//        cont2 = 500 * (colunas - 1) * linhas;
        cont2 = 150 * (colunas - 1) * linhas;
//        cont2 =300* (colunas - 1) * linhas;
//        cont2 = 675 * (colunas - 1) * linhas;
//        cont2 = 1;
//        cont2 = 1000;
//        System.out.println("cont2 = " + cont2);
    }

    public int getCont2() {
        return this.cont2;
    }

    public void set_percent1(double set_percent1) throws IOException {

        percent1 = set_percent1 / 100;
    }

    public void set_sigmamaximo(int set_sigmamaximo) {
        sigmamaximo = set_sigmamaximo;
    }

    public void set_sigmaminimo(int set_sigmaminimo) {
        sigmaminimo = set_sigmaminimo;
    }

    public void set_alfamaximo(double set_alfamaximo) {
        alfamaximo = set_alfamaximo;
    }

    public void set_alfaminimo(double set_alfaminimo) {
        alfaminimo = set_alfaminimo;
    }

    public void set_controlesigma(int set_controlesigma) {
        controlesigma = set_controlesigma;
    }

    public void set_controlealfa(double set_controlealfa) {
        controlealfa = set_controlealfa;
    }

    public void opera_inicial(MatrizDados matriz_dados) throws IOException, InterruptedException {
        matematica.PA_PG(cont2, percent1, sigmaminimo, sigmamaximo, alfaminimo, alfamaximo, controlesigma, controlealfa);
        dados = matriz_dados;
        //   while ((cont < cont2)) {

        //     }
        //     cont++;

    }

    public void iteracao() throws IOException {
        memset(distâncias);
        memset(distâncias2);
        índice = 0;
        índice2 = 0;
        opera(dados);
        if (cont >= (cont2 * percent1)) {
            sigma_auxiliar *= matematica.getQmenos();
            sigma = (int) sigma_auxiliar;
            alfa = alfa + matematica.getRmenos();
            teste_fases = false;
        } else {
            teste_fases = true;

            sigma_auxiliar *= matematica.getQmais();
            sigma = (int) sigma_auxiliar;
            if (alfa >= 1) {
                alfa = alfa + matematica.getRmais() - 0.01;
            } else {
                alfa = alfa + matematica.getRmais();
            }
        }

    }

    private void opera(MatrizDados matriz_dados) throws IOException {
        int pad = 0;
        int linha_sorteada = 0, coluna_sorteada = 0;
        int aux = 0, cont_vizinhos = 0;
        int i, j, si, sj, ci, cj, c2i, c2j;
        Random random = new Random();
        int principal;
        int teste_formiga = 1;
        int pad_aux;
        int indice_auxiliar = 0;
//        if (teste_carrega == 0) {
//            form = new int[3][10];
//            i = 0;
//            do {
//                do {
//                    pad_aux = (random.nextInt(matriz_dados.getLinhas())) + 1; 	//sorteio padrao
//                    for (j = 0; j <= i; j++) {
//                        if (form[0][j] != pad_aux) {
//                            if (j == i) {
//                                form[0][i] = pad_aux;
//                                teste_formiga = 0;
//                            }
//                        } else {
//                            break;
//                        }
//                    }
//                } while (teste_formiga != 0);
//                i++;
//                teste_formiga = 1;
//            } while (i < 10);
//            teste_carrega = 1;
//
//            //procuro o local das formigas sorteadas
//            for (int y = 0; y < 10; y++) {
//                for (int e = 0; e < matriz_dados.getDimensão_matriz(); e++) {
//                    for (int w = 0; w < matriz_dados.getDimensão_matriz(); w++) {
//                        if (matriz_padrao[e][w] == form[0][y]) {
//                            form[1][y] = e;
//                            form[2][y] = w;
//
//                        }
//                    }
//                }
//            }
//        }
//        int sorteio_indice;
//        int[] controle_indice = new int[10];
//        memset(controle_indice);
//        int teste_indice = 0;
//        i = 0;
//        do {
//            do {
//                sorteio_indice = (random.nextInt(10)) + 1; 	//sorteio padrao
//                for (j = 0; j <= i; j++) {
//                    if (controle_indice[j] != sorteio_indice) {
//                        if (j == i) {
//                            controle_indice[i] = sorteio_indice;
//                            teste_indice = 0;
//                        }
//                    } else {
//                        break;
//                    }
//                }
//            } while (teste_indice != 0);
//            i++;
//            teste_indice = 1;
//        } while (i < 10);

//        for (int w = 0; w < 10; w++) {
//         indice_auxiliar = controle_indice[w] - 1;
//            pad = form[indice_auxiliar]; 	//sorteio padrao
        pad = (random.nextInt(matriz_dados.getLinhas())) + 1;
//        for (int w = 0; w < 10; w++) {
        principal = pad;
        buscaant(pad, matriz_padrao, matriz_dados);
        linha_sorteada = random.nextInt(matriz_dados.getDimensão_matriz());
        coluna_sorteada = random.nextInt(matriz_dados.getDimensão_matriz());
        ci = sigma;
        cj = sigma;
        c2i = sigma;
        c2j = sigma;
        si = linha_sorteada;
        sj = coluna_sorteada;
        while (si - ci < 0) {
            --ci;
        }
        while (si + c2i >= matriz_dados.getDimensão_matriz()) {
            --c2i;
        }
        while (sj - cj < 0) {
            --cj;
        }
        while (sj + c2j >= matriz_dados.getDimensão_matriz()) {
            --c2j;
        }

        for (i = si - ci; i <= si + c2i; i++) {
            for (j = sj - cj; j <= sj + c2j; j++) {
                if (matriz_padrao[i][j] != 0) {
                    aux = matriz_padrao[i][j];
                    analisairis(principal, aux, 2, matriz_dados);
                    cont_vizinhos++;
                }
            }
        }
        matematica.calculos(2, cont_vizinhos, matriz_dados, distâncias2, sigma, alfa, índice2);
//            vetorMaiorF[w] = matematica.getFun2();
//        }

//        double maiorF = Double.MIN_VALUE;
//        int indiceNovo = 0;
//        for (int w = 0; w < 10; w++) {
//            if (vetorMaiorF[w] > maiorF) {
//                maiorF = vetorMaiorF[w];
//                linha_sorteada = form[1][w];
//                coluna_sorteada = form[2][w];
//                indiceNovo = w;
//            }
//        }
//        form[0][indiceNovo] = pad;
        descarrega(linha_sorteada, coluna_sorteada, pad, matriz_padrao, matriz_dados);
        memset(distâncias);
        memset(distâncias2);
        índice = 0;
        índice2 = 0;
//        }

    }

    private void descarrega(int linha_descarrega, int coluna_descarrega, int pad, int[][] matriz_padrao, MatrizDados matriz_dados) throws IOException {
        int i = 0, j = 0;
        int contador = 0, contador2 = 0;
        int si = 0, sj = 0, ci = 1, cj = 1, c2i = 1, c2j = 1;
        int[] vetlin = new int[100];
        int[] vetcol = new int[100];
        int principal = pad;
        int auxpos, aux = 0, cont_vizinhos = 0;
        int linha_a_descarregar, coluna_a_descarregar;
        double Pdrop1;
        double Pdrop2;
        Pdrop1 = matematica.fPdrop(1);
        Pdrop2 = matematica.fPdrop(2);
        Random random = new Random();
        double teste = 0;
        int contador3 = 0;
        teste = 0.13397;
        if (Pdrop2 >= teste) {
            if (Pdrop2 > Pdrop1) {
                if (matriz_padrao[linha_descarrega][coluna_descarrega] != 0) {

                    ci = cj = c2i = c2j = 1;
                    si = linha_descarrega;
                    sj = coluna_descarrega;
                    while (contador <= sigma) {
                        if (si - ci < 0) {
                            --ci;
                        }
                        if (si + c2i > matriz_dados.getDimensão_matriz()) {
                            --c2i;
                        }
                        if (sj - cj < 0) {
                            --cj;
                        }
                        if (sj + c2j > matriz_dados.getDimensão_matriz()) {
                            --c2j;
                        }
                        for (i = si - ci; i < si + c2i; i++) {
                            for (j = sj - cj; j < sj + c2j; j++) {
                                if (matriz_padrao[i][j] == 0) {
                                    contador++;
                                    vetlin[contador2] = i;
                                    vetcol[contador2] = j;
                                    contador2++;
                                }
                            }
                        }
                        if (contador == 0) {
                            ++ci;
                            ++c2i;
                            ++cj;
                            ++c2j;
                        }
                        contador3++;
                    }
                    if (contador2 == 1) {
                        auxpos = 0;
                    } else {
                        auxpos = random.nextInt(contador2);
                    }
                    linha_a_descarregar = vetlin[auxpos];
                    coluna_a_descarregar = vetcol[auxpos];
                    ci = 1;
                    cj = 1;
                    c2i = 1;
                    c2j = 1;
                    si = linha_a_descarregar;
                    sj = coluna_a_descarregar;
                    while (si - ci < 0) {
                        --ci;
                    }
                    while (si + c2i >= matriz_dados.getDimensão_matriz()) {
                        --c2i;
                    }
                    while (sj - cj < 0) {
                        --cj;
                    }
                    while (sj + c2j >= matriz_dados.getDimensão_matriz()) {
                        --c2j;
                    }

                    for (i = si - ci; i <= si + c2i; i++) {
                        for (j = sj - cj; j <= sj + c2j; j++) {
                            if (matriz_padrao[i][j] != 0) {
                                aux = matriz_padrao[i][j];
                                analisairis(principal, aux, 2, matriz_dados);
                                cont_vizinhos++;
                            }
                        }
                    }
                    matematica.calculos(2, cont_vizinhos, matriz_dados, distâncias2, 1, alfa, índice2);
                    Pdrop2 = matematica.fPdrop(2);
                    if ((Pdrop2) >= Pdrop1) {

                        matriz_padrao[linha_a_descarregar][coluna_a_descarregar] = pad;
                        matriz_padrao[linha_anterior][coluna_anterior] = 0;
                        memset(vetlin);
                        memset(vetcol);
                        contcarrega = 0;

                    }
                } else {
                    if (pad != 0) {
                        matriz_padrao[linha_descarrega][coluna_descarrega] = pad;
                        matriz_padrao[linha_anterior][coluna_anterior] = 0;
                        contcarrega = 0;
                    }
                }

            }
        }
    }

    private void analisairis(int principal, int pad, int i, MatrizDados matriz_dados) throws IOException {
        int auxiliar_principal = principal - 1;
        int auxiliar_padrao = pad - 1;
        if (i == 1) {
            distâncias[índice] = matriz_distancias[auxiliar_principal][auxiliar_padrao];
            índice++;
        } else {
            if (i == 2) {
                distâncias2[índice2] = matriz_distancias[auxiliar_principal][auxiliar_padrao];
                índice2++;
            }
        }
    }

    private void memset(int[] vetlin) {
        for (int j = 0; j < vetlin.length; j++) {
            vetlin[j] = 0;
        }
    }

    private void memset(double[] vetlin) {
        for (int j = 0; j < vetlin.length; j++) {
            vetlin[j] = 0;
        }
    }

    private void buscaant(int pad, int[][] matriz_padrao, MatrizDados matriz_dados) throws IOException {
        int aux = 0;
        int cont_vizinhos = 0;
        int i, j, si, sj, ci, cj, c2i, c2j;
        int principal = pad;
        for (i = 0; i < matriz_dados.getDimensão_matriz(); i++) {
            for (j = 0; j < matriz_dados.getDimensão_matriz(); j++) {
                if (matriz_padrao[i][j] == pad) {
                    linha_anterior = i;
                    coluna_anterior = j;
                }
            }
        }

        si = linha_anterior;
        sj = coluna_anterior;
        ci = 1;
        cj = 1;
        c2i = 1;
        c2j = 1;
        while (si - ci < 0) {
            --ci;
        }
        while (si + c2i >= matriz_dados.getDimensão_matriz()) {
            --c2i;
        }
        while (sj - cj < 0) {
            --cj;
        }
        while (sj + c2j >= matriz_dados.getDimensão_matriz()) {
            --c2j;
        }
        for (i = (si - ci); i <= (si + c2i); i++) {
            for (j = (sj - cj); j <= (sj + c2j); j++) {
                if (matriz_padrao[i][j] != 0) {
                    if (matriz_padrao[i][j] != pad) {
                        aux = matriz_padrao[i][j];
                        analisairis(principal, aux, 1, matriz_dados);
                        cont_vizinhos++;
                    }
                }
            }
        }
        matematica.calculos(1, cont_vizinhos, matriz_dados, distâncias, sigma, alfa, índice);
    }

    double sorteia() {
        double aux = 0;
        while (aux == 1 || aux == 0) {
            aux = Math.random();
        }
        return aux;
    }

    public int[][] getMatriz_padrao() {
        return matriz_padrao;
    }

    public int getSigma() {
        return sigma;
    }

    public double getSigma_auxiliar() {
        return sigma_auxiliar;
    }

    public double getAlfa() {
        return alfa;
    }

    public int getCont() {
        return cont;
    }

    public void setCont() {
        cont++;
    }

    public double getSigmaminimo() {
        return sigmaminimo;
    }

    public double getSigmamaximo() {
        return sigmamaximo;
    }

    public double getControlesigma() {
        return controlesigma;
    }

    public double getAlfaminimo() {
        return alfaminimo;
    }

    public double getAlfamaximo() {
        return alfamaximo;
    }

    public double getControlealfa() {
        return controlealfa;
    }

    public double getPercent1() {
        return percent1;
    }
}
