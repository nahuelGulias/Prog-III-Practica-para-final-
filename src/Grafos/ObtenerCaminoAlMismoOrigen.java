package Grafos;

import java.util.Iterator;
import java.util.LinkedList;

public class ObtenerCaminoAlMismoOrigen<T> {

    private LinkedList<Integer> solucion = new LinkedList<>();

    public LinkedList<Integer> getCamino(Grafo<T> grafo, int origen) {
        solucion.clear();
        LinkedList<Integer> camino = new LinkedList<>();

        camino.add(origen);
        dfs(grafo, origen, origen, camino);

        return solucion;
    }

    private void dfs(Grafo<T> grafo, int origen, int actual, LinkedList<Integer> camino) {

        Iterator<Integer> it = grafo.obtenerAdyacentes(actual);
        while (it.hasNext()) {
            int vecino = it.next();

            // si volvemos al origen y el camino tiene al menos una arista
            if (vecino == origen && camino.size() > 1) {
                solucion.clear();
                solucion.addAll(camino);
                solucion.add(origen); // cerrar el ciclo
                return;
            }

            if (!camino.contains(vecino)) {
                camino.add(vecino);
                dfs(grafo, origen, vecino, camino);
                camino.removeLast();
            }
        }
    }
}
