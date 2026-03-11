package Grafos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> {
   private enum Estado {VISITADO, NO_VISITADO};
   private HashMap<Integer, Estado> estados ;

    public BreadthFirstSearch() {
        estados = new HashMap<Integer, Estado>();

    }

    public void breadthFirstSearch(Grafo<T> grafo) {
        Queue<Integer> cola = new LinkedList<>();

        Iterator<Integer> ady = grafo.obtenerVertices();
        while (ady.hasNext()) {
            int vertice = ady.next();
            estados.put(vertice, Estado.NO_VISITADO);
        }

        for (Integer v : estados.keySet()) {
            if (estados.get(v) == Estado.NO_VISITADO) {
                bfs(grafo,v,cola);
            }
        }
    }

    private void bfs(Grafo<T> grafo, Integer v, Queue<Integer> cola) {
        estados.put(v, Estado.VISITADO);
        cola.add(v);

        while (!cola.isEmpty()) {
            Integer x = cola.poll();
            Iterator<Integer> ady = grafo.obtenerAdyacentes(x);
            while (ady.hasNext()) {
                int next = ady.next();
                if (estados.get(next)==Estado.NO_VISITADO) {
                    estados.put(next, Estado.VISITADO);
                    cola.add(next);
                }
            }

        }

    }
}
