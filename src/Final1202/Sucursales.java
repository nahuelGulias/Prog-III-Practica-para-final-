package Final1202;

import Grafos.Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class Sucursales<T> {

    HashMap<Integer,String> solucion;
    int [] distancia;
    boolean [] visitados;

    public HashMap<Integer, String> getAsignacion(Grafo<T> grafo, int origen){

        int n = grafo.cantidadVertices();
        distancia = new int[n];
        visitados = new boolean[n];
        solucion = new HashMap<>();

        for (int i = 0; i < n; i++) {
            distancia[i] = Integer.MAX_VALUE;
        }

        distancia[origen] = 0;

        for (int i = 0; i < n; i++) {

            int u = obtenerMenor(distancia,visitados);

            if (u == -1) break;

            visitados[u] = true;


            //Etapa de relajacion
            Iterator<Integer> ady = grafo.obtenerAdyacentes(u);
            while (ady.hasNext()) {
                int v = ady.next();

                int peso = (int) grafo.obtenerArco(u,v).getEtiqueta();

                if(!visitados[v] && (distancia[u] + peso < distancia[v])){
                    distancia[v] = distancia[u] + peso;

                }

            }
        }

        return armarSolucion(grafo);
        }

    private HashMap<Integer, String> armarSolucion(Grafo<T> grafo) {

        Iterator<Integer> vertices = grafo.obtenerVertices();

        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if(distancia[vertice] == Integer.MAX_VALUE){
                solucion.put(vertice,"inalcanzable");
            }
            else
                solucion.put(vertice,"Distancia " + distancia[vertice]);

        }
        return solucion;
    }

    private int obtenerMenor(int [] distancia, boolean[] visitados) {

        int min = Integer.MAX_VALUE;
        int indice = -1;

        for (int i = 0; i < distancia.length; i++) {
            if(!visitados[i] && distancia[i] < min){
                min = distancia[i];
                indice = i;
            }
        }
        return indice;
    }
}
