/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.som;

import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public final class RedeSOM {

    private int iteracoes;
    private int raioInicial;
    private double raio;
    private double alfa;
    private double alfaInicial;
    private Neuronio[][] rede;
    private Base dataSet;
    private int gridX = 0;
    private int gridY = 0;
    private double t1;
    private double t2 = 500;
    private String distancia;
    private String atualiza;
    //
    private float erroQuantização;
    private float erroTopologico;

    public RedeSOM() {
        this.raioInicial = 0;
        this.iteracoes = 0;
        this.alfa = 0;
        //
        this.erroQuantização = 0;
        this.erroTopologico = 0;
    }

    public RedeSOM(int x, int y) {
        this.gridX = x;
        this.gridY = y;
        //
        this.erroQuantização = 0;
        this.erroTopologico = 0;
    }

    public RedeSOM(int x, int y, int raioI, int t, float apredizagem, Base data, String dis, String at) {
        setGridX(x);
        setGridY(y);
        rede = new Neuronio[x][y]; //crio a rede 

        setRaio(raioI); //raio inicial da rede
        raio = raioI;
        t1 = Math.log(500 / raioI);

        setAlfa(apredizagem); //apredizagem inicial da rede
        alfaInicial = apredizagem;

        setIteracoes(t); //numero de iteracoes
        dataSet = data; //base de dados 

        distancia = dis;
        atualiza = at;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Neuronio n = new Neuronio(dataSet.getDataSet().get(0).getAtributos().size(), i, j); //coloco os neuronios na rede
                rede[i][j] = n;
            }
        }
        //
        this.erroQuantização = 0;
        this.erroTopologico = 0;
    }

    public void startRede(int x) {
        OpMath math = new OpMath();

        for (int y = 0; y < dataSet.getDataSet().size(); y++) {//apresento os padroes a rede
            double menorDis = Double.MAX_VALUE;
            int posI = 0, posJ = 0;

            //FASE COMPETITIVA
            double result = 0;
            for (int i = 0; i < getGridX(); i++) {
                for (int j = 0; j < getGridY(); j++) {
                    switch (distancia) {
                        case "euclidiana":
                            result = math.euclidiana(dataSet.getDataSet().get(y).getAtributos(), rede[i][j].getPesos());
                            break;
                    }
                    if (result < menorDis) {
                        menorDis = result;
                        posI = i;
                        posJ = j;
                    }
                }
            }
            //Encontrou o neuronio vencedor

            //FASE COOPERATIVA
            //Atualiza Vizinhos
            int ci = raioInicial;
            int cj = raioInicial;
            int c2i = raioInicial;
            int c2j = raioInicial;
            int si = posI;
            int sj = posJ;

            while (si - ci < 0) {
                --ci;
            }
            while (si + c2i >= getGridX()) {
                --c2i;
            }
            while (sj - cj < 0) {
                --cj;
            }
            while (sj + c2j >= getGridY()) {
                --c2j;
            }

            for (int i = si - ci; i <= si + c2i; i++) {
                for (int j = sj - cj; j <= sj + c2j; j++) {
                    //FASE ADAPTATIVA
                    atualizaPesos(i, j, y, posI, posJ);
                }
            }
        }

        //ATUALIZAÇÃO
        //Atualiza Raio
        raio = raioInicial * Math.exp((-x) / (t1));

        //Atualiza Aprendizagem
        switch (atualiza) {
            case "linear":
                alfa = alfaInicial * (1 - (x / t2));
                break;
            case "exponencial":
                alfa = (alfaInicial * Math.exp((-x) / (t2)));
                break;
            case "reciproca":
                alfa = alfaInicial / (1 + ((100 * x) / t2));
                break;
        }
    }

    public void atualizaPesos(int i, int j, int pad, int posI, int posJ) {
        OpMath math = new OpMath();
        double d = math.euclidiana(posI, posJ, i, j);
        double h = 0;

        //Função Gaussina
        h = Math.exp((-Math.pow(d, 2)) / (2 * Math.pow(raio, 2)));

        for (int k = 0; k < dataSet.getDataSet().get(0).getAtributos().size(); k++) {
            double result = rede[i][j].getPesos().get(k) + alfa * h * (dataSet.getDataSet().get(pad).getAtributos().get(k) - rede[i][j].getPesos().get(k));
            rede[i][j].getPesos().set(k, result);
        }
    }

    public void carregaPadroes() {
        OpMath math = new OpMath();

        for (int y = 0; y < dataSet.getDataSet().size(); y++) {//apresento os padroes a rede

            double menorDis = 1000000;
            int posI = 0, posJ = 0;

            double result = 0;
            for (int i = 0; i < getGridX(); i++) {
                for (int j = 0; j < getGridY(); j++) {
                    switch (distancia) {
                        case "euclidiana":
                            result = math.euclidiana(dataSet.getDataSet().get(y).getAtributos(), rede[i][j].getPesos());
                            break;
                    }

                    if (result < menorDis) {
                        menorDis = result;
                        posI = i;
                        posJ = j;
                    }
                }
            }
            //Encontrou o neuronio vencedor
            rede[posI][posJ].addPadrao(dataSet.getDataSet().get(y));
        }
    }

    public void calcErro() {
        OpMath math = new OpMath();
        for (int y = 0; y < dataSet.getDataSet().size(); y++) {//apresento os padroes a rede
            double menorDis = Double.MAX_VALUE;
            double menorDis2 = Double.MAX_VALUE;
            Neuronio BMU = null;
            Neuronio BMU2 = null;
            int posI = 0, posJ = 0;

            //FASE COMPETITIVA
            double result = 0;
            for (int i = 0; i < getGridX(); i++) {
                for (int j = 0; j < getGridY(); j++) {
                    result = math.euclidiana(dataSet.getDataSet().get(y).getAtributos(), rede[i][j].getPesos());
                    if (result < menorDis) {
                        menorDis = result;
                        BMU2 = BMU;
                        BMU = rede[i][j];
                    } else if (result < menorDis2) {
                        menorDis2 = result;
                        BMU2 = rede[i][j];
                    }
                }
            }
            //Calcula o Erro
            erroQuantização += menorDis;
            erroTopologico += neroniosAdjacentes(BMU, BMU2);
        }

        erroQuantização = erroQuantização / dataSet.getDataSet().size();
        erroTopologico = erroTopologico / dataSet.getDataSet().size();
    }

    public int neroniosAdjacentes(Neuronio n1, Neuronio n2) {
        int adj = 1;
        if (n1.getI() == n2.getI() - 1 && n1.getJ() == n2.getJ() - 1) {
            adj = 0;
        }
        if (n1.getI() == n2.getI() - 1 && n1.getJ() == n2.getJ()) {
            adj = 0;
        }
        if (n1.getI() == n2.getI() - 1 && n1.getJ() == n2.getJ() + 1) {
            adj = 0;
        }
        //
        if (n1.getI() == n2.getI() && n1.getJ() == n2.getJ() - 1) {
            adj = 0;
        }
        if (n1.getI() == n2.getI() && n1.getJ() == n2.getJ()) {
            adj = 0;
        }
        if (n1.getI() == n2.getI() && n1.getJ() == n2.getJ() + 1) {
            adj = 0;
        }
        //
        if (n1.getI() == n2.getI() + 1 && n1.getJ() == n2.getJ() - 1) {
            adj = 0;
        }
        if (n1.getI() == n2.getI() + 1 && n1.getJ() == n2.getJ()) {
            adj = 0;
        }
        if (n1.getI() == n2.getI() + 1 && n1.getJ() == n2.getJ() + 1) {
            adj = 0;
        }
        return adj;
    }

    public ArrayList<Neuronio> getListNeuronios(){
        ArrayList<Neuronio> n = new ArrayList<>();
        for (int i = 0; i < rede.length; i++) {
            for (int j = 0; j < rede[0].length; j++) {
                n.add(rede[i][j]);
            }
        }
        return n;
    }
    public float getErroQuantização() {
        return erroQuantização;
    }

    public float getErroTopologico() {
        return erroTopologico;
    }

    public Base getDataSet() {
        return dataSet;
    }

    public void setDataSet(Base dataSet) {
        this.dataSet = dataSet;
    }

    public double getAlfa() {
        return alfa;
    }

    public void setAlfa(float alfa) {
        this.alfa = alfa;
    }

    public int getIteracoes() {
        return iteracoes;
    }

    public void setIteracoes(int iteracoes) {
        this.iteracoes = iteracoes;
    }

    public int getRaioInicial() {
        return raioInicial;
    }

    public void setRaio(int raioInicial) {
        this.raioInicial = raioInicial;
    }

    public Neuronio[][] getRede() {
        return rede;
    }

    public void setRede(Neuronio[][] rede) {
        this.rede = rede;
    }

    public int getGridX() {
        return gridX;
    }

    public void setGridX(int gridX) {
        this.gridX = gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public void setGridY(int gridY) {
        this.gridY = gridY;
    }

    public Neuronio getNeuronio(int i, int j) {
        if ((i >= 0) && (j >= 0)) {
            return rede[i][j];
        } else {
            return null;
        }
    }

    public void setNeuronio(int i, int j, Neuronio n) {
        if ((i >= 0) && (j >= 0)) {
            rede[i][j] = n;
        }

    }
}
