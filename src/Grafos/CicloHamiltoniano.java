package Grafos;

import javax.xml.transform.SourceLocator;
import java.util.*;

public class CicloHamiltoniano<T>{
    List<Integer> vertices;
    Set<Integer> visitados;
    int mayorPeso;

    public List<Integer> getHamiltoniano(Grafo<T> grafo, int origen) {
        vertices = new ArrayList<>();
        visitados = new HashSet<>();
        mayorPeso = 0;
        List<Integer> actual = new ArrayList<>();
        vertices.add(origen);
        back(grafo,origen,origen,actual, 0);
        return vertices;
    }

    private void back(Grafo<T> grafo, int origen, int destino, List<Integer> actual, int pesoActual) {
        if (origen == destino) {
            if(actual.size() == grafo.cantidadVertices()){
                if(grafo.existeArco(origen,destino)) {
                    if(pesoActual>mayorPeso) {
                        mayorPeso = pesoActual;
                        vertices.clear();
                        vertices.addAll(actual);
                        vertices.add(origen);
                        return;
                    }
                }
            }

        }

        Iterator<Integer> iterator = grafo.obtenerAdyacentes(origen);
        while (iterator.hasNext()) {
            int adyacente = iterator.next();
            if(!visitados.contains(adyacente)) {
                int peso = (int) grafo.obtenerArco(origen,adyacente).getEtiqueta();
                pesoActual += peso;
                actual.add(adyacente);
                visitados.add(adyacente);
                back(grafo,adyacente,destino, actual, pesoActual);
                actual.removeLast();
                visitados.remove(adyacente);
                pesoActual -= peso;
            }
        }




    }



}
