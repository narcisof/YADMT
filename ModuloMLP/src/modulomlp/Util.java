package modulomlp;

public class Util {
    public static double erroQuadratico(double[] a, double[] b){
        double erro=0.0;
        for (int i= 0; i < a.length; i++) {
            erro += (a[i] - b[i])*(a[i] - b[i]);
        }
        
        return erro/2.0;
    }
    public static double distanciaEuclidiana(double[] p, double[] q) {
        double distancia = 0.0;
        double aux = 0.0;
        if (p.length == q.length) {
            for (int i = 0; i < p.length; i++) {
                aux = p[i] - q[i];
                distancia += aux * aux;
            }
        }
        return Math.sqrt(distancia);
    }

}
