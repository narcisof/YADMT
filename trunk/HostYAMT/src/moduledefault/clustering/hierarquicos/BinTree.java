/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.hierarquicos;

import java.util.ArrayList;

/**
 *
 * @author Thiago M. Faino
 */
public class BinTree {

    private Node root;
    ArrayList<Node> base;
    

    public BinTree(Node root) {
        this.root = root;
    }

    public BinTree() {
        this.root = null;
    }

    public void createTree(int[][] dendograma, int altura, int largura) {
                
        ArrayList<Integer> baseAux = ordena(dendograma);
        base = new ArrayList<>();
        
        int bordaX = 10;
        int bordaY = 10;
        int horizontal = largura - (2 * bordaX);
        int tam = horizontal / dendograma.length;
        int aux = tam;
        for (int i = 0; i < baseAux.size(); i++) {            
            base.add(new Node(baseAux.get(i), bordaX + tam, altura - bordaY));
            tam += aux;
        }

        for (int i = 0; i < dendograma.length - 1; i++) {
            for (int j = 0; j < dendograma[0].length; j++) {
                if (dendograma[i][j] != dendograma[i + 1][j]) {
                    int x = base.get(dendograma[i][j]-1).getX() + base.get(dendograma[i + 1][j]-1).getX();
                    int y = base.get(dendograma[i][j]-1).getY() + base.get(dendograma[i + 1][j]-1).getY();
                    x /= 2;
                    y /= 2;
                    Node n = new Node(dendograma[i + 1][j], x, y); //pai
                    n.setLeft(base.get(dendograma[i + 1][j]-1));
                    n.setRight(base.get(dendograma[i][j]-1));
                    base.get(dendograma[i + 1][j]-1).setPai(n);
                    base.get(dendograma[i][j]-1).setPai(n);
                }
            }
        }
    }
    
    
    public ArrayList<Integer> ordena(int[][] dendograma) {

        ArrayList<Integer> base = new ArrayList<>();
        ArrayList<Integer> baseAux = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();

        for (int i = 0; i < dendograma.length; i++) {
            base.add(dendograma[0][i]);
            baseAux.add(dendograma[0][i]);
        }

        for (int i = 0; i < dendograma.length - 1; i++) {
            for (int j = 0; j < dendograma[0].length; j++) {
                aux.clear();
                if (dendograma[i][j] != dendograma[i + 1][j]) {
//                    System.out.println("");
                    for (int k = 0; k < dendograma[0].length; k++) {
                        if (dendograma[i][k] == dendograma[i][j]) {
                            aux.add(k);
                        }
                    }

                    int pos = 0;
                    for (int k = baseAux.size()-1; k >= 0 ; k--) {
                        if (baseAux.get(k) == dendograma[i + 1][j]) {
                            pos = k + 1;
                            break;
                        }
                    }

                    for (int k = 0; k < aux.size(); k++) {
                        int x = base.indexOf(dendograma[0][aux.get(k)]);
                        int coco = base.remove(x);
                        if (pos + k >= base.size()) {
                            base.add(coco);
                            baseAux.add(dendograma[i + 1][j]);
                        } else {
                            base.add(pos + k, coco);
                            baseAux.add(pos + k, dendograma[i + 1][j]);
                        }
                    }
                }
            }

        }

        return base;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public ArrayList<Node> getBase() {
        return base;
    }
}
