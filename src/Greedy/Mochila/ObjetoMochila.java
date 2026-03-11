package Greedy.Mochila;

public class ObjetoMochila implements Comparable<ObjetoMochila> {

    int peso;
    int valor;

    public ObjetoMochila(int valor, int peso) {
        this.valor = valor;
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public int compareTo(ObjetoMochila o) {
        double local = this.getValor()/this.getPeso();
        double other = o.getValor()/o.getPeso();

        return Double.compare(local, other);
    }
}
