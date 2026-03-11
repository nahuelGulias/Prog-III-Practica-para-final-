package Greedy;

import Grafos.Grafo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
El problema del agente viajero (PAV) busca la ruta más corta posible que visita un conjunto de ciudades
exactamente una vez y regresa al punto de partida.
Entonces dado un grafo no dirigido que representa el problema, escriba un algoritmo en JAVA que obtenga
una solución al PAV mediante una estrategia greedy.
 */
public class Pav2 <T>{

    ArrayList<Integer> solucion;
    Set<Integer> visitados;
    int total = 0;


    public ArrayList<Integer> getSolucion(Grafo<T> grafo, int origen){
        solucion = new ArrayList<>();
        visitados = new HashSet<>();
        int actual = origen;

        solucion.add(actual);
        visitados.add(actual);

        while(visitados.size() < grafo.cantidadVertices()){

            int mejorVecino = -1;
            int menorCosto = Integer.MAX_VALUE;

            Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);
            while(ady.hasNext()){
                int next = ady.next();

                if(!visitados.contains(next)){
                    int costo = (int) grafo.obtenerArco(actual, next).getEtiqueta();
                    if(costo < menorCosto){
                        menorCosto = costo;
                        mejorVecino = next;
                    }
                }
            }
                if(mejorVecino == -1){
                    break;
                }
                solucion.add(mejorVecino);
                visitados.add(mejorVecino);
                total+= menorCosto;
                actual = mejorVecino;
        }
            solucion.add(origen);
            return solucion;
    }

    public int getTotal(){
        return total;
    }
}
