package Grafos;

import java.util.concurrent.CancellationException;

public class Main {
    public static void main(String[] args) {
        Detectar2Ciclos devolver = new Detectar2Ciclos();
        GrafoDirigido grafo = new GrafoDirigido();

        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArco(1,0, null);
        grafo.agregarArco(0,3, null);
        grafo.agregarArco(3,1, null);
        grafo.agregarArco(0,4, null);
        grafo.agregarArco(3,2, null);
        grafo.agregarArco(2,1, null);

        System.out.println(devolver.tieneDosCiclos(grafo));
    }
}
