package Grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    protected  HashMap<Integer,HashMap<Integer,Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            vertices.put(verticeId, new HashMap<>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (vertices.containsKey(verticeId)) {
            for (HashMap<Integer,Arco<T>> arcosSalientes : vertices.values()){
                arcosSalientes.remove(verticeId);
            }
            vertices.remove(verticeId);
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
            Arco<T> arco = new Arco<>(verticeId1, verticeId2, etiqueta);
            vertices.get(verticeId1).put(verticeId2, arco);
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if(vertices.containsKey(verticeId1)) {
            if(existeArco(verticeId1, verticeId2)) {
                vertices.get(verticeId1).remove(verticeId2);
            }
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
            return vertices.get(verticeId1).containsKey(verticeId2);
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if(existeArco(verticeId1, verticeId2)) {
            return vertices.get(verticeId1).get(verticeId2);
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int cantidad = 0;
        for(HashMap<Integer, Arco<T>> ady : vertices.values()) {
            cantidad += ady.size();
        }
        return cantidad;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> adyacentes = new ArrayList<>();
        if(vertices.containsKey(verticeId)) {
            adyacentes.addAll(vertices.get(verticeId).keySet());
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        for(HashMap<Integer, Arco<T>> ady : vertices.values()) {
            arcos.addAll(ady.values());
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        if(vertices.containsKey(verticeId)) {
            for(Arco<T> arco : vertices.get(verticeId).values()) {
                arcos.add(arco);
            }
        }
        return arcos.iterator();
    }
}
