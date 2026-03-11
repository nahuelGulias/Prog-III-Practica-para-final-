package Grafos;

import java.util.HashMap;
import java.util.Iterator;

public class DepthFirstSearch<T> {
    enum Color {BLANCO, AMARILLO, NEGRO};
    private HashMap<Integer,Color> colores; // Mapeo de verticesID correspondientes a un COLOR
    private boolean hayCiclo;

    public boolean DepthFirstSearch(GrafoDirigido<T> grafo) {
        colores = new HashMap<Integer,Color>();
        hayCiclo = false;

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            colores.put(vertices.next(), Color.BLANCO);
        }

        for(int v : colores.keySet()) {
            if(colores.get(v)==Color.BLANCO) {
                dfs(v,grafo);
            }
        }


        return hayCiclo;
    }

    private void dfs(int v, GrafoDirigido<T> grafo) {
        colores.put(v, Color.AMARILLO);

        Iterator<Integer> ady = grafo.obtenerAdyacentes(v);
        while(ady.hasNext() && !hayCiclo) {
            int next = ady.next();
            if(colores.get(next)==Color.BLANCO) {
                dfs(next,grafo);
            }else if(colores.get(next)==Color.AMARILLO) {
                hayCiclo = true;
            }
        }
        colores.put(v, Color.NEGRO);
    }
}
