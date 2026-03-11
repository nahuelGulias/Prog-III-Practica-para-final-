package Greedy;

import Grafos.Grafo;

import java.util.*;

public class PAV <T>{
    Set<Integer> visitados = new HashSet<>();
    List<Integer> camino = new ArrayList<>();
    int actual;



    public List<Integer> getCamino(Grafo<T> g) {

        Iterator<Integer> it = g.obtenerVertices();
        if(!it.hasNext())
            return camino;

        int origen = it.next();
        actual = origen;

        camino.add(actual);
        visitados.add(actual);

        while(visitados.size() < g.cantidadVertices()){

            int mejorVecino = -1;
            int merjoCosto = Integer.MAX_VALUE;

            Iterator<Integer> it2 = g.obtenerAdyacentes(actual);
            while(it2.hasNext()){
                int vecino = it2.next();
                int costo = (int )g.obtenerArco(actual, vecino).getEtiqueta();

                if(costo < merjoCosto){
                    merjoCosto = costo;
                    mejorVecino = vecino;
                }
            }

            if(mejorVecino == -1){
                break;
            }

            camino.add(mejorVecino);
            visitados.add(mejorVecino);
            actual = mejorVecino;

        }

        camino.add(actual);
        return camino;



    }
}
