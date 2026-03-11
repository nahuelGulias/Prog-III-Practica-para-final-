package Grafos;

import java.util.ArrayList;
import java.util.Iterator;

//Escriba un algoritmo en JAVA que dado un grafo G, devuelva en una lista, si existe, un camino de longitud mayor
//a d que vaya desde v hasta un vértice w. Los valores de d, v y w serán dados por parámetro.
public class CaminoDeLongitudEspecifica<T>{

    ArrayList<Integer> solucion;

    public ArrayList<Integer> getSolucion(Grafo<T> grafo, int longitudEspecifica, int verticeV, int verticeW ) {
        solucion = new ArrayList<>();
        ArrayList<Integer> parcial = new ArrayList<>();
        backtracking(grafo, longitudEspecifica, verticeV, verticeW, parcial);
        return solucion;
    }

    private void backtracking(Grafo<T> grafo, int longitudEspecifica, int origen, int destino, ArrayList<Integer> actual) {

        if (origen == destino) {
            if (actual.size()== longitudEspecifica) {
                solucion.clear();
                solucion.addAll(new ArrayList<>(actual));
                return;
            }
        }

        if (actual.size() > longitudEspecifica) {
            return;
        }

        Iterator<Integer> it = grafo.obtenerAdyacentes(origen);
        while (it.hasNext()) {
            int next = it.next();

            actual.add(next);
            backtracking(grafo, longitudEspecifica, next, destino, actual);
            actual.remove(actual.size()-1);

        }


 
    }

}
