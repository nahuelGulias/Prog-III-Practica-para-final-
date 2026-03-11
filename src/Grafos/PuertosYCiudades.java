package Grafos;

import javax.swing.event.MenuKeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PuertosYCiudades<T> {

    HashMap<Integer, String> solucion;
    int[] distancia;
    boolean[] visitados;


    public HashMap<Integer, String> getSolucion(Grafo<T> g, List<Integer> puertos) {

        int n = g.cantidadVertices();
        solucion = new HashMap<>();
        distancia = new int[n];
        visitados = new boolean[n];

        for (int i = 0; i < n; i++) {
            distancia[i] = Integer.MAX_VALUE;
            visitados[i] = false;
        }

        for (Integer puerto : puertos) {
            distancia[puerto] = 0;
        }

        for (int i = 0; i < n; i++) {
            int u = obtenerMenor(distancia, visitados);

            if (u == -1) {
                return null;
            }

            visitados[u] = true;

            //relajacion
            Iterator<Integer> it = g.obtenerAdyacentes(u);

            while (it.hasNext()) {

                int v = it.next();
                int peso = 0;//(int) g.obtenerArco(u, v).getEtiqueta();

                //si no lo visite y la distancia de mi siguiente (0 si no ha sido descubierto) + el COSTO
                // de ir desde u hacia v es menor a la distancia que tengo calculada(infinito)
                if (!visitados[v] && distancia[u] + peso < distancia[v]) {

                    distancia[v] = distancia[u] + peso; // la nueva distancia de v (que era infinito)
                    // se vuelve la distancia de ir a u + el costo de ir a v


                }
            }

        }
        return armarSolucion(g);
    }

    private HashMap<Integer, String> armarSolucion(Grafo<T> g) {
        Iterator<Integer> vertices = g.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (distancia[vertice] == Integer.MAX_VALUE) {
                solucion.put(vertice, "Inalcanzable");
            }
            solucion.put(vertice, "Distancia" + distancia[vertice]);

        }
        return solucion;
    }

    private int obtenerMenor(int[] distancia, boolean[] visitados) {

        int min = Integer.MAX_VALUE; //infinito
        int indice = -1;

        for (int i = 0; i < distancia.length; i++) { // recorro todas las distancias
            if (!visitados[i] && distancia[i] < min) { //si no lo visite y la distancia actual es menor a infinito
                min = distancia[i]; // guardo
                indice = i; // actualizo el inidice
            }
        }
        return indice; // devuelvo el indice de la menor dist

    }

}
