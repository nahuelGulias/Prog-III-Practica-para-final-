package Grafos;

import java.util.Iterator;
import java.util.LinkedList;

public class ObtenerCaminoMasCorto <T> {
    private LinkedList<Integer> solucion;

    public LinkedList<Integer> getCaminoCorto(Grafo<T> g, int v1, int v2){
        solucion.clear();
        LinkedList<Integer> camino = new LinkedList<>();
        getCaminoMasCorto(g, v1, v2, camino);
        return new LinkedList<>(solucion);
    }

    public void getCaminoMasCorto(Grafo<T> g, int v1, int v2, LinkedList<Integer> camino){
        if(v1==v2){
            if(camino.size()<solucion.size()){
                solucion.clear();
                solucion.addAll(camino);
            }
        }
        else{
            Iterator<Integer> ady = g.obtenerAdyacentes(v1);
            while (ady.hasNext()) {
                int elem =  ady.next();
                if(!camino.contains(elem)){
                    camino.add(elem);
                    getCaminoMasCorto(g, elem, v2, camino);
                    camino.removeLast();
                }

            }
        }
    }
}
