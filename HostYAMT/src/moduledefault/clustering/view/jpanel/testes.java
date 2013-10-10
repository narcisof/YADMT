/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.view.jpanel;

import java.util.ArrayList;
import java.util.List;
import moduledefault.clustering.distancias.CorrelacaoSpearman;
import moduledefault.clustering.uteis.Base;
import moduledefault.clustering.uteis.Operações_Mat;
import moduledefault.clustering.uteis.Padrao;
import moduledefault.clustering.view.frames.JFrameFormigas;
import moduledefault.clustering.visualization.TecnicasDispersao;

/**
 *
 * @author Mateus
 */
public class testes {

    interfaces.Base base;
    static Base dados;
    double[][] matrizDados;

    public testes(interfaces.Base b, JFrameFormigas j) {

        base = b;
//        startMatrizDados();
//        Operações_Mat mat = new Operações_Mat();
//        mat.Padronização(dados);
//        CorrelacaoSpearman c = new CorrelacaoSpearman(dados);
//        double []dados1 = new double[10];
//        double []dados2 = new double[10];
//           dados1[0] = 106;
//                dados1[1] = 86;
//                dados1[2] = 100;
//                dados1[3] = 101;
//                dados1[4] = 99;
//                dados1[5] = 103;
//                dados1[6] = 97;
//                dados1[7] = 113;
//                dados1[8] = 112;
//                dados1[9] = 110;
//
//                dados2[0] = 7;
//                dados2[1] = 0;
//                dados2[2] = 27;
//                dados2[3] = 50;
//                dados2[4] = 28;
//                dados2[5] = 29;
//                dados2[6] = 20;
//                dados2[7] = 12;
//                dados2[8] = 6;
//                dados2[9] = 17;
//                List<Double> l1 = new ArrayList<>();
//                List<Double> l2 = new ArrayList<>();
//                l1.add(dados1[0]);
//                l1.add(dados1[1]);
//                l1.add(dados1[2]);
//                l1.add(dados1[3]);
//                l1.add(dados1[4]);
//                l1.add(dados1[5]);
//                l1.add(dados1[6]);
//                l1.add(dados1[7]);
//                l1.add(dados1[8]);
//                l1.add(dados1[9]);
//                
//                
//                l2.add(dados2[0]);
//                l2.add(dados2[1]);
//                l2.add(dados2[2]);
//                l2.add(dados2[3]);
//                l2.add(dados2[4]);
//                l2.add(dados2[5]);
//                l2.add(dados2[6]);
//                l2.add(dados2[7]);
//                l2.add(dados2[8]);
//                l2.add(dados2[9]);
//                
//                
//                
//        System.out.println("c = "+c.spearman(l1, l2));
    }

    public void startMatrizDados() {
        dados = new moduledefault.clustering.uteis.Base();
        double matriz[][] = new double[base.getInput().length][base.getInput()[0].length]; //= arrayListBases.get(arrayListBases.size() - 1).getInput();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = Double.valueOf(base.getInput()[i][j] + "").doubleValue();
            }
        }
//        padronizacao(base);
        matrizDados = matriz;
        int grupo = 0;
        for (int i = 0; i < matriz.length; i++) {
            Padrao p = new Padrao();
            p.setNumero(grupo);
            ++grupo;
            for (int j = 0; j < matriz[0].length; j++) {
                p.addAtributos(matriz[i][j]);

            }
            p.setClasse(base.getOutput()[i].toString());
            dados.addDataSet(p);
        }

        for (int i = 0; i < base.getAtributes().length; i++) {
            dados.addAtributos(base.getAtributes()[i]);
        }
        dados.setClasses((List) base.getClasses());
        dados.setNome((String) base.getName());
        dados.setDimensaoMatriz();



    }
}
