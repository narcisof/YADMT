 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import java.util.ArrayList;
import java.util.List;
import moduledefault.clustering.kmeans.Centroide;
import moduledefault.clustering.uteis.Base;
import moduledefault.clustering.uteis.Padrao;

/**
 *
 * @author Mateus
 */
public class CorrelacaoPearson {

    Base base;
    double[][] matrizDistancias;

    public CorrelacaoPearson(Base teste) {
        System.out.println("pearson");
        base = teste.copy();
        setMatrizDistancias(teste.getDataSet().size());
    }

    public CorrelacaoPearson() {
    }

    public void distancia() {
        double somador1 = 0;
        double somador2 = 0;
        double media1 = 0;
        double media2 = 0;
        double somatorio1 = 0;
        double somatorio2 = 0;
        double somatorio3 = 0;
        double raiz;
        double correlacao = 0;

        for (int y = 0; y < base.getDataSet().size(); y++) {
            for (int w = 0; w < base.getDataSet().size(); w++) {
                for (int i = 0; i < base.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somador1 += base.getDataSet().get(y).getAtributos().get(i);
                }
                media1 = somador1 / (base.getDataSet().get(0).getAtributos().size() - 1);
                for (int i = 0; i < base.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somador2 += base.getDataSet().get(w).getAtributos().get(i);
                }
                media2 = somador2 / (base.getDataSet().get(0).getAtributos().size() - 1);
                for (int i = 0; i < base.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio1 += (base.getDataSet().get(y).getAtributos().get(i) - media1) * (base.getDataSet().get(w).getAtributos().get(i) - media2);
                }
                for (int i = 0; i < base.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio2 += Math.pow((base.getDataSet().get(y).getAtributos().get(i) - media1), 2);
                }
                for (int i = 0; i < base.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio3 += Math.pow((base.getDataSet().get(w).getAtributos().get(i) - media2), 2);
                }
                raiz = Math.sqrt((somatorio2 * somatorio3));
                correlacao = somatorio1 / raiz;
                matrizDistancias[y][w] = 1 - correlacao;
                somador1 = 0;
                somador2 = 0;
                somatorio1 = 0;
                somatorio2 = 0;
                somatorio3 = 0;
                media1 = 0;
                media2 = 0;
                raiz = 0;
                correlacao = 0;
            }

        }
        padronizacaDistancias(matrizDistancias);
    }

    public double distancia(List<Double> vet1, List<Double> vet2) {
        double somador1 = 0;
        double somador2 = 0;
        double media1 = 0;
        double media2 = 0;
        double somatorio1 = 0;
        double somatorio2 = 0;
        double somatorio3 = 0;
        double raiz;
        double correlacao = 0;

        for (int i = 0; i < vet1.size(); i++) {
            somador1 += vet1.get(i);
        }
        media1 = somador1 / (vet1.size());
        for (int i = 0; i < vet2.size(); i++) {
            somador2 += vet2.get(i);
        }
        media2 = somador2 / (vet2.size());
        for (int i = 0; i < vet1.size(); i++) {
            somatorio1 += (vet1.get(i) - media1) * (vet2.get(i) - media2);
        }
        for (int i = 0; i < vet1.size(); i++) {
            somatorio2 += Math.pow((vet1.get(i) - media1), 2);
        }
        for (int i = 0; i < vet2.size(); i++) {
            somatorio3 += Math.pow((vet2.get(i) - media2), 2);
        }
        raiz = Math.sqrt((somatorio2 * somatorio3));
        correlacao = somatorio1 / raiz;
        return correlacao;
    }

    public static double[][] distanciaKmeans(int linhas, int k, double[][] matriz, ArrayList<Centroide> centroide) {
        double somador1 = 0;
        double somador2 = 0;
        double media1 = 0;
        double media2 = 0;
        double somatorio1 = 0;
        double somatorio2 = 0;
        double somatorio3 = 0;
        double raiz;
        double correlacao;
        double[][] resultado = new double[linhas][k];
        for (int y = 0; y < linhas; y++) {
            for (int w = 0; w < k; w++) {
                for (int i = 0; i < k; i++) {
                    somador1 += matriz[y][i];
                }
                media1 = somador1 / (k);
                for (int i = 0; i < k; i++) {
                    somador2 += centroide.get(w).getAtributos().get(i);
                }
                media2 = somador2 / (k);
                for (int i = 0; i < k; i++) {
                    somatorio1 += (matriz[y][i] - media1) * (centroide.get(w).getAtributos().get(i) - media2);
                }
                for (int i = 0; i < k; i++) {
                    somatorio2 += Math.pow((matriz[y][i] - media1), 2);
                }
                for (int i = 0; i < k; i++) {
                    somatorio3 += Math.pow((centroide.get(w).getAtributos().get(i) - media2), 2);
                }
                raiz = Math.sqrt((somatorio2 * somatorio3));
                correlacao = somatorio1 / raiz;
                resultado[y][w] = (float) correlacao;
                somador1 = 0;
                somador2 = 0;
                somatorio1 = 0;
                somatorio2 = 0;
                somatorio3 = 0;
                media1 = 0;
                media2 = 0;
                raiz = 0;
                correlacao = 0;
            }

        }
        return resultado;
    }

    public void distanciaGrupos(Base teste) {
        double somador1 = 0;
        double somador2 = 0;
        double media1 = 0;
        double media2 = 0;
        double somatorio1 = 0;
        double somatorio2 = 0;
        double somatorio3 = 0;
        double raiz;
        double correlacao = 0;


        for (int y = 0; y < teste.getDataSet().size(); y++) {
            for (int w = 0; w < teste.getDataSet().size(); w++) {
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somador1 += teste.getDataSet().get(y).getAtributos().get(i);
                }
                media1 = somador1 / (teste.getDataSet().get(0).getAtributos().size() - 1);
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somador2 += teste.getDataSet().get(w).getAtributos().get(i);
                }
                media2 = somador2 / (teste.getDataSet().get(0).getAtributos().size() - 1);
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio1 += (teste.getDataSet().get(y).getAtributos().get(i) - media1) * (teste.getDataSet().get(w).getAtributos().get(i) - media2);
                }
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio2 += Math.pow((teste.getDataSet().get(y).getAtributos().get(i) - media1), 2);
                }
                for (int i = 0; i < teste.getDataSet().get(0).getAtributos().size() - 1; i++) {
                    somatorio3 += Math.pow((teste.getDataSet().get(w).getAtributos().get(i) - media2), 2);
                }
                raiz = Math.sqrt((somatorio2 * somatorio3));
                correlacao = somatorio1 / raiz;
                matrizDistancias[y][w] = correlacao;
                somador1 = 0;
                somador2 = 0;
                somatorio1 = 0;
                somatorio2 = 0;
                somatorio3 = 0;
                media1 = 0;
                media2 = 0;
                raiz = 0;
                correlacao = 0;
            }

        }

//        for (int i = 0; i < teste.getDataSet().size(); i++) {
//            for (int j = 0; j < teste.getDataSet().size(); j++) {
//                System.out.print(matrizDistancias[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public void trasnpoe(Base base) {
        if (base != null) {
            double[][] resultado = new double[base.getDataSet().get(0).getAtributos().size()][base.getDataSet().size()];
            double[][] matriz = new double[base.getDataSet().size()][base.getDataSet().get(0).getAtributos().size()];

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = base.getDataSet().get(i).getAtributos().get(j);
                }
            }
            for (int i = 0; i < resultado.length; i++) {
                for (int j = 0; j < resultado[0].length; j++) {
                    resultado[i][j] = matriz[j][i];
                }
            }
            Base auxBase = base.copy();
            auxBase.setDataSet();
            int grupo = 0;
            for (int i = 0; i < resultado.length; i++) {
                Padrao p = new Padrao();
                p.setNumero(grupo);
                ++grupo;
                for (int j = 0; j < resultado[0].length; j++) {
                    p.addAtributos(resultado[i][j]);

                }
//            p.setClasse(Base.getOutput()[i].toString());
                auxBase.addDataSet(p);
            }
            setMatrizDistancias(auxBase.getDataSet().size());
            distanciaGrupos(auxBase);
        }
    }

    public void padronizacaDistancias(double[][] matriz) {
        double menor = 0;
        double maior = 0;
        int cont = 0;

        maior = Double.MIN_VALUE;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] /= maior;
            }
        }
    }

    public double[][] getMatrizDistancias() {
        return matrizDistancias;
    }

    public void setMatrizDistancias(int linhas) {
        this.matrizDistancias = new double[linhas][linhas];
    }
}
