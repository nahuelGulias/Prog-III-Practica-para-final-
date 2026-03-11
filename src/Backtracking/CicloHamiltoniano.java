package Backtracking;

import Grafos.Arco;
import Grafos.Grafo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CicloHamiltoniano<T> {
    ArrayList<Integer> camino;
    Set<Integer> visitados;
    int mejorPeso;


    public ArrayList<Integer> getCamino(Grafo<T> grafo, int inicio) {
        camino = new ArrayList<>();
        visitados = new HashSet<>();
        ArrayList<Integer> actual = new ArrayList<>();
        camino.add(inicio);
        actual.add(inicio);

        solucion(grafo, actual,inicio, inicio, 0);
        return camino;
    }

    private void solucion(Grafo<T> grafo, ArrayList<Integer> actual, int origen, int destino, int pesoActual) {
        if(origen == destino){
            if(grafo.existeArco(destino, origen)){
                Arco<T> arcoVuelta = grafo.obtenerArco(destino, origen);
                pesoActual += (int) arcoVuelta.getEtiqueta();
                if(pesoActual >= mejorPeso){
                    camino.clear();
                    camino.addAll(actual);
                }
            }
        }

        Iterator<Integer> it = grafo.obtenerAdyacentes(origen);
        while(it.hasNext()){
            int vecino = it.next();
            if(!visitados.contains(vecino)){
                int peso = (int) grafo.obtenerArco(origen,vecino).getEtiqueta();
                pesoActual += peso;
                actual.add(vecino);
                visitados.add(vecino);
                solucion(grafo, actual,origen,destino,pesoActual);
                actual.remove(actual.size()-1);
                visitados.remove(visitados.size()-1);
                pesoActual -= peso;
            }
        }

    }

}
