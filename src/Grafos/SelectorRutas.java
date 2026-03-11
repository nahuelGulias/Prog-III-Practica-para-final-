package Grafos;

import java.util.Iterator;
import java.util.LinkedList;

/*
Dado un grafo no orientado que modela las rutas de la provincia de Buenos Aires,
DEVOLVER TODOS LOS CAMINOS alternativos que se pueden tomar para ir
desde la ciudad de Buenos Aires a la ciudad de Tandil, considerando que en el tramo Las Flores-Rauch está cortado al tránsito.
 */
public class SelectorRutas <T>{
    private LinkedList<LinkedList<Integer>> caminos;


    public LinkedList<LinkedList<Integer>> getCaminos(Grafo<T> grafo, int buenosAires, int tandil, int lasFlores, int rauch) {
       caminos.clear();
       LinkedList<Integer> alternativas = new LinkedList<>();
       alternativas.add(buenosAires);
       getTramos(grafo, buenosAires, tandil,lasFlores, rauch, alternativas);
       return caminos;
    }

    private void getTramos(Grafo<T> grafo, int actual, int destino, int lasFlores, int rauch, LinkedList<Integer> alternativas) {
        if (actual == destino) {
            caminos.clear();
            caminos.add(alternativas);
        }

        Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);
        while (ady.hasNext()) {
            int vecino = ady.next();
            if ((actual == lasFlores && vecino == rauch) || (actual == rauch && vecino == lasFlores)) {
                continue;
            }

            if(!alternativas.contains(vecino)) {
                alternativas.add(vecino);
                getTramos(grafo, vecino, destino,lasFlores,rauch, alternativas);
                alternativas.removeLast();
            }
        }

    }

}
