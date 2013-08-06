/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.recuperacaogrupos;


import java.io.IOException;
import java.util.Scanner;
import moduledefault.clustering.aco.ACOClustering;

/**
 *
 * @author Mateus
 */
public class MFaino {

    int op = 1;
    int pos = 0;
    int busca = 0;
    int contgrupo = 0;
    int sizepos;
    Scanner in = new Scanner(System.in);
    int[][] m;// = new int[matriz.length][matriz.length];
    int[][] maux;// = new int[matriz.length][matriz.length];
    int linhas;
    int[][] mpos;
    int[][] mpos2;
    StringBuffer string3;
    ACOClustering x;

    public MFaino(int[][] matriz, ACOClustering x_) {
        string3 = new StringBuffer();
        x = x_;
        linhas = matriz.length;
        m = new int[matriz.length][matriz.length];
        maux = new int[matriz.length][matriz.length];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < linhas; j++) {
                m[i][j] = matriz[i][j];
            }
        }
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < linhas; j++) {
                maux[i][j] = m[i][j];
            }
        }

        sizepos = (linhas * linhas) * 2;
        mpos = new int[2][sizepos];
        mpos2 = new int[2][sizepos];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < sizepos; j++) {
                mpos[i][j] = 0;
            }
        }
    }

    public void inicio() throws IOException {
// int op = 1;
        for (int i = 0; i < linhas; i++) {//faz a busca na matriz para encontrar os padroes
            for (int j = 0; j < linhas; j++) {
                if (m[i][j] != 0) {//assim que o primeiro padrao é encontrado
                    mpos[0][pos] = i; //Salva a posição do dele, que sera o 1ºdo grupo
                    mpos[1][pos] = j;
                    ++pos;
                    grupos(i, j, m, mpos);//e manda esse padrao para o precedimento "grupos" que vai analisar
                    //e buscar os outros padroes que pentencem a esse mesmo grupo	
                    ++pos;// pos = controle para salvar em ordem as posições na matriz
                    ++busca;// busca = controla qual padrão que será mandado para a função grupos
                    ++contgrupo;//contgrupo = conta quantos grupos foram encontrados
                }
            }
        }//FIM PASSO 4
        atualizavetor(maux, mpos);
        //imprimefinal(maux,mpos);


        if (op == 1) {//Enquanto o usuario desejar agrupar os isolados, e enquanto houver isolados para serem agrupados...	
            //PASSO 5
            while (op != 0) {
                procura(maux, mpos);//procura o padrao isolado para ser agrupado
                //FIM PASSO 5
            }
        }
        int cont = 0;
        for (int i = 0; i < pos; i++) {
            if ((mpos[0][i] != 0) && (mpos[1][i] != 0)) {
                mpos2[0][cont] = mpos[0][i];
                mpos2[1][cont] = mpos[1][i];
                cont++;
            }
        }

    }

    public int get_contgrupos() {
        return contgrupo;
    }

    public int[][] get_mpos() {
        return mpos2;
    }

    public int getPos() {
        return pos;
    }

    void grupos(int lin, int col, int[][] m, int[][] mpos) { //
        int padrao, inc = 0;
        padrao = m[lin][col];

        while (busca != pos) {
            int si = lin;
            int sj = col;
            int ci = 1, cj = 1, c2i = 1, c2j = 1;//variaveis para garantir que nao busque um padrao fora da dimensao da matriz
            //Procura dos vizinhos do Padrão
            while (si - ci < 0) {
                --ci;
            }
            while (si + c2i >= linhas) {
                --c2i;
            }
            while (sj - cj < 0) {
                --cj;
            }
            while (sj + c2j >= linhas) {
                --c2j;
            }
            inc = 0;
            for (int i = (si - ci); i <= (si + c2i); i++) {
                for (int j = (sj - cj); j <= (sj + c2j); j++) {
                    if ((m[i][j] != 0) && (m[i][j] != padrao)) {// Se o Vizinho for diferente de 0 e não for o próprio padrão...
                        for (int x = 0; x < pos; x++) {
                            if ((i == mpos[0][x]) && (j == mpos[1][x]))//Verifica se o Vizinho já foi salvo na matriz das posições...
                            {
                                ++inc; // Se o Vizinho já foi salvo ++inc
                            }
                        }
                        if (inc == 0) { // Senão Salva a posição do Vizinho na matriz das posições
                            mpos[0][pos] = i;
                            mpos[1][pos] = j;
                            ++pos;
                        }
                        inc = 0;
                    }
                }
            }
            ++busca;
            grupos(mpos[0][busca], mpos[1][busca], m, mpos);
        }
        //Atualiza a Matriz Apagando os Padrões já Agrupados
        for (int j = 0; j < sizepos; j++) {
            m[mpos[0][j]][mpos[1][j]] = 0;
        }
    }

    void atualizavetor(int[][] maux, int[][] mpos) {//Atualiza a matriz "mpos"
        int j = 0, grupo = 1;
        while (j != pos) {
            mpos[0][j] = maux[mpos[0][j]][mpos[1][j]];//coloca na 1ª linha o valor padrao, onde primeiramente estava salvo somente sua posição 
            mpos[1][j] = grupo;//e na segunda linha é informado o grupo do padrao
            ++j;
            if ((mpos[0][j] == 0) && (mpos[1][j] == 0)) {
                ++j;
                ++grupo;
            }
        }
    }

    void agrupa(int[][] maux, int grp, int isolado, int[][] mpos) {
        int aux = 0, lin = 0, col = 0, pad = 0;
        //isolado = padrao que está isolado
        //grp = grupo que o isolado pertence
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < linhas; j++) {
                if (maux[i][j] == isolado) {
                    lin = i; // salva a posição onde o padrao isolado está
                    col = j;
                    break;
                }
            }
        }
        int si = lin;
        int sj = col;
        int ci = 1, cj = 1, c2i = 1, c2j = 1;//variaveis para garantir que nao busque um padrao fora da dimensao da matriz
        while (aux == 0) {//A partir da posição do padrao isolado Expande até encontrar algum grupo 
            while (si - ci < 0) {
                --ci;
            }
            while (si + c2i >= linhas) {
                --c2i;
            }
            while (sj - cj < 0) {
                --cj;
            }
            while (sj + c2j >= linhas) {
                --c2j;
            }
            int para = 0;
            int clin = 1, ccol = 1, tlin = 1, tcol = 1;
            for (int i = (si - ci); i <= (si + c2i); i++) {
                for (int j = (sj - cj); j <= (sj + c2j); j++) {
                    if ((maux[i][j] != 0) && (maux[i][j] != isolado)) {//Acha o padrao mais proximo
                        pad = maux[i][j];//salva o padrao encontrado
                        aux = 1;//variavel de controle, para que ao primeiro padrao encontrado(o mais prox) seja o escolhido
                        //system("pause");
                        if (aux == 1)//ao achar o padrao mais prox, sair e garantir que o primeiro seja escolhido
                        {
                            break;
                        }
                        //////////////
                    }
                }
                if (aux == 1)//ao achar o padrao mais prox, sair e garantir que o primeiro seja escolhido
                {
                    break;
                }
            }
            if (aux == 1)//ao achar o padrao mais prox, sair e garantir que o primeiro seja escolhido
            {
                break;
            }
            ++ci;
            ++cj;
            ++c2i;
            ++c2j;
        }
        int novogrupo = 0;
        for (int i = 0; i < pos; i++) {//faz a busca na matriz "mpos" para saber qual grupo o padrao mais proximo pertence
            if (mpos[0][i] == pad) {
                novogrupo = mpos[1][i];//novogrupo = isolado pertencerá a este grupo agora
            }
        }
        for (int i = 0; i < pos; i++) {//faz a busca na matriz"mpos" para alterar o grupo do isolado
            if (mpos[0][i] == isolado) {
                mpos[1][i] = novogrupo;
            }
        }
        for (int i = 0; i < pos; i++) {//faz a busca na matriz "mpos" para alterar os demais grupos, ja que o grupo do isolado nao existe mais 
            if (mpos[1][i] > grp) {
                mpos[1][i] = mpos[1][i] - 1;
            }
        }
    }

    void procura(int[][] maux, int[][] mpos) {
        int grp = contgrupo, aux = 0, isolado = 0;
        //grp recebe a quantidades de grupos encontrados
        if (op == 1) {//se a resposta for sim
            while (grp != 0) {//enquanto nao for verificado para todos os grupos...
                for (int i = 0; i < pos; i++) {//faz a busca no vetor "mpos" para saber qual é o primeiro padrao isolado
                    if (mpos[1][i] == grp) {//se nessa posição do vetor for = ao grupo que esta sendo buscado
                        ++aux;//faz soma os padroes desse grupo
                        isolado = mpos[0][i];
                    }
                }
                if (aux == 1) {//achou um grupo com apenas 1 elemento(padrao isolado)
                    agrupa(maux, grp, isolado, mpos);//manda para o precedimento agrupa, para agrupar com o 
                    break;//grupo mais proximo
                } else {//senao...
                    --grp;//decrementa para ser analisado o proximo grupo 
                    aux = 0;//zera a variavel que faz a soma dos padroes de cada grupo
                }
            }
            if ((grp == 0) && (aux == 0)) {//se grp = 0 e nao encontrar nenhum padrao isolado, chegou ao fim desse processo
                //nao existe mais padroes isolados
                //system("pause");
                op = 0;
            } else {
                --contgrupo;//contrgrupo = é a variavel que controla quantos grupos foram formados, como agrupou um grupo isolado
            }		//o grupo do isolado deixou de existir, sendo assim -1 grupo no total
        }
    }
}