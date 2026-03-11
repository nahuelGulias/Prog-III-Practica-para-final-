package Grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DevolverCiclo <T>{
    ArrayList<Integer> solucion;
    ArrayList<Integer> actual;
    HashMap<Integer,Color> colores;
    enum Color {AMARILLO,BLANCO,NEGRO}
    boolean encontrado;

    public ArrayList<Integer> getSolucion(Grafo<T> grafo) {
        solucion = new ArrayList<>();
        colores = new HashMap<>();
        actual = new ArrayList<>();
        encontrado = false;

        Iterator<Integer> iterator = grafo.obtenerVertices();
        while (iterator.hasNext()) {
            int v = iterator.next();
            colores.put(v, Color.BLANCO);
        }

        for (int i : colores.keySet()) {
            if (colores.get(i) == Color.BLANCO && !encontrado) {
                dfs(grafo, i);
            }
        }
        return solucion;
    }


    public void dfs(Grafo<T> grafo, int u) {
        colores.put(u, Color.AMARILLO);
        actual.add(u);

        Iterator<Integer> iterator = grafo.obtenerAdyacentes(u);

        while (iterator.hasNext() && !encontrado) {
            int next = iterator.next();

            if(colores.get(next) == Color.BLANCO)
                dfs(grafo, next);
            if (colores.get(next) == Color.AMARILLO) {
                boolean empezar = false;
                for (int vert : actual) {
                    if(vert == next)
                        empezar = true;

                    if(empezar)
                        solucion.add(vert);

                    encontrado = true;
                }


            }
        }
        actual.remove(actual.size()-1);
        colores.put(u, Color.NEGRO);

    }

}
