package Greedy;

import Grafos.Grafo;
import Grafos.GrafoDirigido;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GrafoDirigido<Integer> g = new GrafoDirigido<>();

        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);

        // 3. Agregamos los arcos (Origen, Destino, Peso/Etiqueta)
        // Para que el viajante funcione bien, el grafo suele ser completo
        g.agregarArco(1, 2, 10);
        g.agregarArco(1, 3, 15);
        g.agregarArco(1, 4, 20);

        g.agregarArco(2, 1, 10);
        g.agregarArco(2, 3, 35);
        g.agregarArco(2, 4, 25);

        g.agregarArco(3, 1, 15);
        g.agregarArco(3, 2, 35);
        g.agregarArco(3, 4, 30);

        g.agregarArco(4, 1, 20);
        g.agregarArco(4, 2, 25);
        g.agregarArco(4, 3, 30);

        Pav2 vg = new Pav2();

        System.out.println("Calculando ruta desde el origen 0...");
        ArrayList<Integer> ruta = vg.getSolucion(g, 1);

        System.out.println("Ruta Greedy encontrada: " + ruta);
        System.out.println("Total: " + vg.getTotal());
    }
}

