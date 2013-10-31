/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.visualization.Classes;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author alienware
 */
public class Poligono implements java.io.Serializable {

    private String tipo;
    private ArrayList<Ponto> pontos;//Lista de pontos do poligono
    private ArrayList<Aresta> arestas;//Lista de arestas do poligono
    private ArrayList<Face> faces;//Lista de faces do poligono
    private double RotationX;
    private double RotationY;
    private double RotationZ;
    private double ScaleX;
    private double ScaleY;
    private double ScaleZ;
    private double ShearXonZ;//Cizalhamento
    private double ShearYonZ;
    private double ShearYonX;
    private double ShearZonX;
    private double ShearXonY;
    private double ShearZonY;
    private long TranslationX;
    private long TranslationY;
    private long TranslationZ;
    private Color cor;
    private Color corFace;
    private int numPontos;
    private int raio;
    private int altura;

    public Poligono() {
        this.pontos = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.faces = new ArrayList<>();

//        this.pontos.add(new Ponto("centro",0,0,0));

        RotationX = 0;
        RotationY = 0;
        RotationZ = 0;

        ScaleX = 1;
        ScaleY = 1;
        ScaleZ = 1;

        ShearXonZ = 0;//Cizalhamento
        ShearYonZ = 0;
//
        ShearYonX = 0;
        ShearZonX = 0;

        ShearXonY = 0;
        ShearZonY = 0;

        TranslationX = 0;
        TranslationY = 0;
        TranslationZ = 0;

        cor = Color.black;
        corFace = Color.white;

    }

    public void setCorFace(Color cor) {
        this.corFace = cor;
    }

    public Poligono(ArrayList<Ponto> pontos, ArrayList<Aresta> arestas,
            ArrayList<Face> faces) {
        this.pontos = pontos;
        this.arestas = arestas;
        this.faces = faces;

        RotationX = 0;
        RotationY = 0;
        RotationZ = 0;

        ScaleX = 1;
        ScaleY = 1;
        ScaleZ = 1;

        ShearXonZ = 0;//Cizalhamento
        ShearYonZ = 0;

        ShearYonX = 0;
        ShearZonX = 0;

        ShearXonY = 0;
        ShearZonY = 0;

        TranslationX = 0;
        TranslationY = 0;
        TranslationZ = 0;

        cor = Color.black;
        corFace = Color.white;

    }

    public Poligono copy() {
        Poligono resultado = new Poligono();

        for (Ponto p : this.pontos) {
            resultado.addPonto(new Ponto(p.getNome(), p.getX(), p.getY(), p.getZ(), p.getCor()));
        }
        for (Aresta a : this.arestas) {
            resultado.addAresta(a.getNome(), a.getPonto_1().getNome(), a.
                    getPonto_2().getNome());
        }
        Color fc = null;
        for (Face f : this.getFaces()) {
            Face face = new Face(resultado);
            for (Aresta a : f.getArestas()) {
                face.addAresta(a.getNome());
            }
            resultado.addFace(face);
        }


        resultado.Rotacionar(this.RotationX, this.RotationY, this.RotationZ);

        resultado.Transladar(this.TranslationX, this.TranslationY,
                this.TranslationZ);
        resultado.Escalar(this.ScaleX, this.ScaleY, this.ScaleZ);
        //fazer as funç~eos de cizalhamento

        resultado.CizalharXonY(ShearXonY);
        resultado.CizalharZonY(ShearZonY);

        resultado.CizalharXonZ(ShearXonZ);
        resultado.CizalharYonZ(ShearYonZ);

        resultado.CizalharYonX(ShearYonX);
        resultado.CizalharZonX(ShearZonX);

        resultado.setCor(this.getCor());
        resultado.setCorFace(this.getCorFace());


        return resultado;

    }

    public void addPonto(Ponto p) {
        pontos.add(p);
    }

    public void addPonto(String nome, double x, double y, double z) {
        pontos.add(new Ponto(nome, x, y, z, Color.black));
    }

    public void addAresta(Aresta a) {
        arestas.add(a);
    }

    public void addAresta(String nome, Ponto p1, Ponto p2) {
        arestas.add(new Aresta(p1, p2, nome));
    }

    public void addAresta(String nome, String p1, String p2) {
        this.addAresta(nome, getPonto(p1), getPonto(p2));
    }

    public void addFace(Face f) {
        this.faces.add(f);
    }

    public Ponto getPonto(String nome) {
        for (Ponto p : pontos) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    public double getRotationX() {
        return RotationX;
    }

    public double getRotationY() {
        return RotationY;
    }

    public double getRotationZ() {
        return RotationZ;
    }

    public double getScaleX() {
        return ScaleX;
    }

    public double getScaleY() {
        return ScaleY;
    }

    public double getScaleZ() {
        return ScaleZ;
    }

    public double getShearXonZ() {
        return ShearXonZ;
    }

    public double getShearYonZ() {
        return ShearYonZ;
    }

    public double getShearYonX() {
        return ShearYonX;
    }

    public double getShearZonX() {
        return ShearZonX;
    }

    public double getShearXonY() {
        return ShearXonY;
    }

    public double getShearZonY() {
        return ShearZonY;
    }

    public long getTranslationX() {
        return TranslationX;
    }

    public long getTranslationY() {
        return TranslationY;
    }

    public long getTranslationZ() {
        return TranslationZ;
    }

    public int getNumPontos() {
        return numPontos;
    }

    public int getRaio() {
        return raio;
    }

    public int getAltura() {
        return altura;
    }

    public Color getCor() {
        return cor;
    }

    public Color getCorFace() {
        return corFace;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Aresta getAresta(String nome) {
        for (Aresta a : arestas) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Ponto> getPontos() {
        return this.pontos;
    }

    public ArrayList<Aresta> getArestas() {
        return this.arestas;
    }

    public ArrayList<Face> getFaces() {
        return this.faces;
    }

    public Matriz getMatrizPontos() {
        Matriz resultado = new Matriz();
        resultado.setPontos(this.getPontos());
        return resultado;

    }

    public Ponto getCentro() {
        return this.getPonto("centro");
    }

    public String getTipo() {

        return tipo;
    }

    public void setPontos(Matriz mat) {
        int iterador = 0;
        for (Ponto p : pontos) {
            p.setX((mat.get(0, iterador)));
            p.setY((mat.get(1, iterador)));
            p.setZ((mat.get(2, iterador)));
            iterador++;
        }
    }

    public void setPontos(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public void setFaces(ArrayList<Face> faces) {
        this.faces = faces;
    }

    public void Rotacionar(double x, double y, double z) {
        this.RotationX += x;
        this.RotationY += y;
        this.RotationZ += z;
    }

    public void RotacionarX(double x) {
        this.RotationX += x;
    }

    public void RotacionarY(double y) {
        this.RotationY += y;
    }

    public void RotacionarZ(double z) {
        this.RotationZ += z;
    }

    public void Transladar(long x, long y, long z) {
        this.TranslationX += x;
        this.TranslationY += y;
        this.TranslationZ += z;
    }

    public void TransladarX(long x) {
        this.TranslationX += x;
    }

    public void TransladarY(long y) {
        this.TranslationY += y;
    }

    public void TransladarZ(long z) {
        this.TranslationZ += z;
    }

    public void Escalar(double x, double y, double z) {
        this.ScaleX *= x;

        this.ScaleY *= y;

        this.ScaleZ *= z;

    }

    public void EscalarX(double x) {
        this.ScaleX *= x;

    }

    public void EscalarY(double y) {
        this.ScaleY *= y;

    }

    public void EscalarZ(double z) {
        this.ScaleZ *= z;

    }

    public void CizalharXonZ(double x) {
        this.ShearXonZ += x;
    }

    public void CizalharYonZ(double x) {
        this.ShearYonZ += x;
    }

    public void CizalharYonX(double x) {
        this.ShearYonX += x;
    }

    public void CizalharZonX(double x) {
        this.ShearZonX += x;
    }

    public void CizalharXonY(double x) {
        this.ShearXonY += x;
    }

    public void CizalharZonY(double x) {
        this.ShearZonY += x;
    }

    public Poligono Transformar() {
        Poligono resultado = this.copy();
        //Matrizes de rotação
        Matriz Rx = Matriz.gerarRotacaoX(this.RotationX);
        Matriz Ry = Matriz.gerarRotacaoY(this.RotationY);
        Matriz Rz = Matriz.gerarRotacaoZ(this.RotationZ);

        //Matriz de escala
        Matriz SC = Matriz.gerarEscala(ScaleX, ScaleY, ScaleZ);

        //Matriz de cizalhamento

        Matriz ShXonZ = Matriz.gerarCizalhamentoXonZ(ShearXonZ);
        Matriz ShYonZ = Matriz.gerarCizalhamentoYonZ(ShearYonZ);

        Matriz ShXonY = Matriz.gerarCizalhamentoXonY(ShearXonY);
        Matriz ShZonY = Matriz.gerarCizalhamentoZonY(ShearZonY);

        Matriz ShYonX = Matriz.gerarCizalhamentoYonX(ShearYonX);
        Matriz ShZonX = Matriz.gerarCizalhamentoZonX(ShearZonX);

        //Matriz de Translação

        Matriz TRF = Matriz.
                gerarTranslacao(this.TranslationX, this.TranslationY,
                this.TranslationZ);

        //Matriz de pontos
        Matriz PTR = resultado.getMatrizPontos();

        //Calculos

        Matriz aux = Matriz.multiplicacao(TRF, SC);
        aux = Matriz.multiplicacao(aux, Rz);
        aux = Matriz.multiplicacao(aux, Ry);
        aux = Matriz.multiplicacao(aux, Rx);
        aux = Matriz.multiplicacao(aux, ShXonZ);
        aux = Matriz.multiplicacao(aux, ShYonZ);
        aux = Matriz.multiplicacao(aux, ShXonY);
        aux = Matriz.multiplicacao(aux, ShZonY);
        aux = Matriz.multiplicacao(aux, ShYonX);
        aux = Matriz.multiplicacao(aux, ShZonX);
        aux = Matriz.multiplicacao(aux, PTR);


        resultado.setPontos(aux);
        return resultado;
    }

    public Poligono TransformarPerpectiva() {

        Poligono p = this.copy();
        p.Transladar(-150, -150, -150);
        p = p.Transformar();
        return p;
    }

    public Matriz getPontosTransformados() {
        Matriz Rx = Matriz.gerarRotacaoX(this.RotationX);
        Matriz Ry = Matriz.gerarRotacaoY(this.RotationY);
        Matriz Rz = Matriz.gerarRotacaoZ(this.RotationZ);

        //Matriz de escala
        Matriz SC = Matriz.gerarEscala(ScaleX, ScaleY, ScaleZ);

        //Matriz de cizalhamento

        Matriz ShXonZ = Matriz.gerarCizalhamentoXonZ(ShearXonZ);
        Matriz ShYonZ = Matriz.gerarCizalhamentoYonZ(ShearYonZ);

        Matriz ShXonY = Matriz.gerarCizalhamentoXonY(ShearXonY);
        Matriz ShZonY = Matriz.gerarCizalhamentoZonY(ShearZonY);

        Matriz ShYonX = Matriz.gerarCizalhamentoYonX(ShearYonX);
        Matriz ShZonX = Matriz.gerarCizalhamentoZonX(ShearZonX);

        //Matriz de Translação

        Matriz TRF = Matriz.
                gerarTranslacao(this.TranslationX, this.TranslationY,
                this.TranslationZ);

        //Matriz de pontos
        Matriz PTR = this.getMatrizPontos();

        //Calculos

        Matriz aux = Matriz.multiplicacao(TRF, SC);
        aux = Matriz.multiplicacao(aux, Rz);
        aux = Matriz.multiplicacao(aux, Ry);
        aux = Matriz.multiplicacao(aux, Rx);
        aux = Matriz.multiplicacao(aux, ShXonZ);
        aux = Matriz.multiplicacao(aux, ShYonZ);
        aux = Matriz.multiplicacao(aux, ShXonY);
        aux = Matriz.multiplicacao(aux, ShZonY);
        aux = Matriz.multiplicacao(aux, ShYonX);
        aux = Matriz.multiplicacao(aux, ShZonX);
        aux = Matriz.multiplicacao(aux, PTR);


        return aux;

    }

    public void GerarPrisma(int nPontosBase, int raio, int altura, ArrayList<Ponto> _pontos) {

        this.tipo = "Prisma";
        this.pontos = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.faces = new ArrayList<>();
        this.numPontos = nPontosBase;
        this.raio = raio;
        this.altura = altura;

//        this.pontos.add(new Ponto("centro", 0, 0, 0));

        double angulo;

        Matriz rotacao;

        Matriz ponto = new Matriz(4, 1);
        ponto.set(0, 0, 0);//x
        ponto.set(1, 0, raio);//y
        ponto.set(2, 0, (altura / 2) * -1);//z
        ponto.set(3, 0, 1);//w

//        int nome = 0;
//        Ponto p;
//
//        for (int i = 0; i < nPontosBase; i++) {
//            angulo = ((360.0 / nPontosBase) * i);
//            rotacao = Matriz.gerarRotacaoZ(angulo);
//
//            Matriz auxPonto = Matriz.multiplicacao(rotacao, ponto);
//
//            nome++;
//            p = new Ponto(String.valueOf(nome), (auxPonto.get(0, 0)),
//                    (auxPonto.get(1, 0)), (auxPonto.
//                    get(2, 0)));
//            this.pontos.add(p);
//            p = new Ponto(String.valueOf(nome + nPontosBase), (auxPonto.
//                    get(0, 0)), (auxPonto.get(1, 0)),
//                    altura / 2);
//            this.pontos.add(p);
//
//        }
        this.pontos = _pontos;

        //conecta base e gera sua face
        Face f = new Face(this);
        for (int i = 1; i < nPontosBase + 1; i++) {
            if (i != nPontosBase) {
                this.arestas.add(new Aresta(this.getPonto(String.valueOf(i)),
                        this.getPonto(String.valueOf(i + 1)),
                        String.valueOf(i) + "-" + String.valueOf(i + 1)));

                f.addAresta(String.valueOf(i) + "-" + String.valueOf(i + 1));

            } else {
                this.arestas.add(new Aresta(this.getPonto(String.valueOf(i)),
                        this.getPonto(String.valueOf(1)),
                        String.valueOf(i) + "-" + String.valueOf(1)));

                f.addAresta(String.valueOf(i) + "-" + String.valueOf(1));

            }
        }
        this.faces.add(f);
        f = new Face(this);
        //conecta topo

        for (int i = nPontosBase + 1; i < (nPontosBase * 2) + 1; i++) {
            if (i != nPontosBase * 2) {
                Ponto p1 = this.getPonto(String.valueOf(i));
                Ponto p2 = this.getPonto(String.valueOf(i + 1));
                String nomeAresta = String.valueOf(i) + "-" + String.valueOf(i
                        + 1);

                this.arestas.add(new Aresta(p1, p2, nomeAresta));
                f.addAresta(String.valueOf(i) + "-" + String.valueOf(i + 1));
            } else {
                Ponto p1 = this.getPonto(String.valueOf(i));
                Ponto p2 = this.getPonto(String.valueOf(nPontosBase + 1));
                String nomeAresta = String.valueOf(i) + "-" + String.
                        valueOf(nPontosBase + 1);

                this.arestas.add(new Aresta(p1, p2, nomeAresta));
                f.addAresta(String.valueOf(i) + "-" + String.
                        valueOf(nPontosBase + 1));
            }
        }
        this.faces.add(f);
        //coneta-base-topo;

        for (int i = 1; i < nPontosBase + 1; i++) {
            this.arestas.add(new Aresta(this.getPonto(String.valueOf(i)),
                    this.getPonto(String.valueOf(i + nPontosBase)),
                    String.valueOf(i) + "-" + String.valueOf(i + nPontosBase)));
        }

        //cria faces restantes

        for (int i = 1; i < nPontosBase + 1; i++) {
            f = new Face(this);
            if (i != nPontosBase) {
                f.addAresta(String.valueOf(i) + "-" + String.valueOf(i
                        + nPontosBase));//base-topo
                f.addAresta(String.valueOf(i + 1) + "-" + String.valueOf(i
                        + nPontosBase + 1));//base-topo
                f.addAresta(String.valueOf(i + nPontosBase) + "-" + String.
                        valueOf(i + nPontosBase + 1));//topo-topo

                f.addAresta(String.valueOf(i) + "-" + String.valueOf(i + 1));//base-base
            } else {

                f.addAresta(String.valueOf(i) + "-" + String.valueOf(i
                        + nPontosBase));//base-topo
                f.addAresta(String.valueOf(1) + "-" + String.valueOf(nPontosBase
                        + 1));//base-topo
                f.addAresta(String.valueOf(i) + "-" + String.valueOf(1));//base-base
                f.addAresta(String.valueOf(i + nPontosBase) + "-" + String.
                        valueOf(nPontosBase + 1));//topo-topo
            }
            this.faces.add(f);
        }


    }

    public void GerarPrisma(int nPontosBase, int raio, int altura) {

        this.tipo = "Prisma";
        this.pontos = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.faces = new ArrayList<>();
        this.numPontos = nPontosBase;
        this.raio = raio;
        this.altura = altura;

        this.pontos.add(new Ponto("centro", 0, 0, 0, Color.BLACK));

        double angulo;

        Matriz rotacao;

        Matriz ponto = new Matriz(4, 1);
        ponto.set(0, 0, 0);//x
        ponto.set(1, 0, raio);//y
        ponto.set(2, 0, (altura / 2) * -1);//z
        ponto.set(3, 0, 1);//w

        int nome = 0;
        Ponto p;

        for (int i = 0; i < nPontosBase; i++) {
            angulo = ((360.0 / nPontosBase) * i);
            rotacao = Matriz.gerarRotacaoZ(angulo);

            Matriz auxPonto = Matriz.multiplicacao(rotacao, ponto);

            nome++;
            p = new Ponto(String.valueOf(nome), (auxPonto.get(0, 0)), (auxPonto.get(1, 0)), (auxPonto.get(2, 0)), Color.black);
            this.pontos.add(p);
            p = new Ponto(String.valueOf(nome + nPontosBase), (auxPonto.get(0, 0)), (auxPonto.get(1, 0)), altura / 2, Color.black);
            this.pontos.add(p);

        }

        //conecta base e gera sua face
        Face f = new Face(this);
        for (int i = 1; i < nPontosBase + 1; i++) {
            if (i != nPontosBase) {
                this.arestas.add(new Aresta(this.getPonto(String.valueOf(i)),
                        this.getPonto(String.valueOf(i + 1)),
                        String.valueOf(i) + "-" + String.valueOf(i + 1)));

                f.addAresta(String.valueOf(i) + "-" + String.valueOf(i + 1));

            } else {
                this.arestas.add(new Aresta(this.getPonto(String.valueOf(i)),
                        this.getPonto(String.valueOf(1)),
                        String.valueOf(i) + "-" + String.valueOf(1)));

                f.addAresta(String.valueOf(i) + "-" + String.valueOf(1));

            }
        }
        this.faces.add(f);
        f = new Face(this);
        //conecta topo

        for (int i = nPontosBase + 1; i < (nPontosBase * 2) + 1; i++) {
            if (i != nPontosBase * 2) {
                Ponto p1 = this.getPonto(String.valueOf(i));
                Ponto p2 = this.getPonto(String.valueOf(i + 1));
                String nomeAresta = String.valueOf(i) + "-" + String.valueOf(i
                        + 1);

                this.arestas.add(new Aresta(p1, p2, nomeAresta));
                f.addAresta(String.valueOf(i) + "-" + String.valueOf(i + 1));
            } else {
                Ponto p1 = this.getPonto(String.valueOf(i));
                Ponto p2 = this.getPonto(String.valueOf(nPontosBase + 1));
                String nomeAresta = String.valueOf(i) + "-" + String.
                        valueOf(nPontosBase + 1);

                this.arestas.add(new Aresta(p1, p2, nomeAresta));
                f.addAresta(String.valueOf(i) + "-" + String.
                        valueOf(nPontosBase + 1));
            }
        }
        this.faces.add(f);
        //coneta-base-topo;

        for (int i = 1; i < nPontosBase + 1; i++) {
            this.arestas.add(new Aresta(this.getPonto(String.valueOf(i)),
                    this.getPonto(String.valueOf(i + nPontosBase)),
                    String.valueOf(i) + "-" + String.valueOf(i + nPontosBase)));
        }

        //cria faces restantes

        for (int i = 1; i < nPontosBase + 1; i++) {
            f = new Face(this);
            if (i != nPontosBase) {
                f.addAresta(String.valueOf(i) + "-" + String.valueOf(i
                        + nPontosBase));//base-topo
                f.addAresta(String.valueOf(i + 1) + "-" + String.valueOf(i
                        + nPontosBase + 1));//base-topo
                f.addAresta(String.valueOf(i + nPontosBase) + "-" + String.
                        valueOf(i + nPontosBase + 1));//topo-topo

                f.addAresta(String.valueOf(i) + "-" + String.valueOf(i + 1));//base-base
            } else {

                f.addAresta(String.valueOf(i) + "-" + String.valueOf(i
                        + nPontosBase));//base-topo
                f.addAresta(String.valueOf(1) + "-" + String.valueOf(nPontosBase
                        + 1));//base-topo
                f.addAresta(String.valueOf(i) + "-" + String.valueOf(1));//base-base
                f.addAresta(String.valueOf(i + nPontosBase) + "-" + String.
                        valueOf(nPontosBase + 1));//topo-topo
            }
            this.faces.add(f);
        }


    }
}