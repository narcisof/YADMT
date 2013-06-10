package rna.basico.funcoes;

public class FuncaoLogistica implements FuncaoAtivacao {

    public double calcular(double valor) {
        return (1 / (1 + Math.exp(-valor)));
    }

    public double derivada(double valor) {
        return valor * (1 - valor);
    }
}
