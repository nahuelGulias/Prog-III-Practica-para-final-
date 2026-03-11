package Grafos;

import java.util.ArrayList;
import java.util.Iterator;

//Escriba en JAVA un algoritmo basado en DFS que dado un
//grafo dirigido aciclico G, con vértices que tienen color negro o rojo,
//encuentre y devuelva si existe un camino entre un vértice de inicio V. y
//otro vértice de fin W, que no contenga dos vértices seguidos del mismo color.
public class CaminoDesdeVHaciaW<T>  {

    ArrayList<Integer> solucion;

    public ArrayList<Integer> getCamino(Grafo<T> g, int v, int w){
        solucion = new ArrayList<>();
        ArrayList<Integer> parcial = new ArrayList<Integer>();
        parcial.add(v);
        back(g, v, w, parcial);
        return solucion;

    }

    private void back(Grafo<T> g, int v, int w, ArrayList<Integer> parcial) {

        if(v==w){
            solucion.clear();
            solucion.addAll(parcial);
            return;
        }

        Iterator<Integer> it = g.obtenerAdyacentes(v);
        while(it.hasNext()){
            int next = it.next();
            //if(v.getColor() != next.getColor() && !parcial.contains(next)){
                parcial.add(next);
                back(g, next, w, parcial);
                parcial.remove(parcial.size()-1);
            //}
        }
    }


}
