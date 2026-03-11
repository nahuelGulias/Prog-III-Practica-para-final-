package Grafos;

import java.util.*;

//public class Detectar2Ciclos<T> {
//    HashMap<Integer,Color> colores = new HashMap<>();
//    HashMap<Integer,Integer> padres = new HashMap<>();
//    List<List<Arco<T>>> ciclos = new ArrayList<>();
//    enum Color {AMARILLO, BLANCO, NEGRO}
//
//
//    public boolean tieneDosCiclos(Grafo<T>grafo){
//
//        Iterator<Integer> iterator= grafo.obtenerVertices();
//        while(iterator.hasNext()){
//            int u = iterator.next();
//            colores.put(u,Color.BLANCO);
//        }
//        for(int i : colores.keySet()){
//            if (colores.get(i) == Color.BLANCO)
//               return dfs(grafo, i);
//        }
//    return false;
//    }
//
//
//    private boolean dfs(Grafo<T> grafo, int u) {
//        colores.put(u,Color.AMARILLO);
//
//        Iterator<Integer> iterator= grafo.obtenerAdyacentes(u);
//        while(iterator.hasNext()) {
//            int v = iterator.next();
//            if (colores.get(v) == Color.BLANCO){
//                padres.put(v, u);
//            if (dfs(grafo, v)) return true;
//            }
//            if(colores.get(v) == Color.AMARILLO) {
//
//                List<Arco<T>> nuevoCiclo = reconstruirCiclo(grafo,u,v);
//
//                for(List<Arco<T>> ciclo : ciclos){
//                    if(!compartenArco(ciclo,nuevoCiclo))
//                        return true;
//                }
//
//                ciclos.add(nuevoCiclo);
//            }
//
//        }
//        colores.put(u,Color.NEGRO);
//        return false;
//    }
//
//    private boolean compartenArco(List<Arco<T>> cicloViejo, List<Arco<T>> nuevoCiclo) {
//        for (Arco<T> a1 : cicloViejo) {
//            for (Arco<T> a2 : nuevoCiclo) {
//                if (a1.equals(a2)) {
//                    return true; // comparten al menos uno
//                }
//            }
//        }
//
//        return false; // no comparten ninguno
//    }
//
//    private List<Arco<T>> reconstruirCiclo(Grafo<T> grafo, int u, int v) {
//        List<Arco<T>> ciclo = new ArrayList<>();
//
//        int actual = u;
//
//        ciclo.add(grafo.obtenerArco(u, v));
//
//        while (actual != v) {
//
//            int padre = padres.get(actual);
//            ciclo.add(grafo.obtenerArco(padre, actual));
//            actual = padre;
//        }
//
//        return ciclo;
//    }
//
//

    public class Detectar2Ciclos<T> {
        private Map<Integer, Color> colores = new HashMap<>();
        private Map<Integer, Integer> padres = new HashMap<>();
        private Set<String> arcosProhibidos = new HashSet<>(); // "u-v" para identificar arcos usados

        enum Color { BLANCO, AMARILLO, NEGRO }

        public boolean tieneDosCiclos(Grafo<T> grafo) {
            // 1. Intentar encontrar el primer ciclo
            if (!encontrarYMarcarCiclo(grafo)) return false;

            // 2. Resetear estados para la segunda búsqueda
            colores.clear();
            padres.clear();

            // 3. Intentar encontrar un segundo ciclo (el DFS ignorará arcosProhibidos)
            return encontrarYMarcarCiclo(grafo);
        }

        private boolean encontrarYMarcarCiclo(Grafo<T> grafo) {
            Iterator<Integer> it = grafo.obtenerVertices();
            while (it.hasNext()) colores.put(it.next(), Color.BLANCO);

            for (int v : colores.keySet()) {
                if (colores.get(v) == Color.BLANCO) {
                    if (dfs(grafo, v)) return true;
                }
            }
            return false;
        }

        private boolean dfs(Grafo<T> grafo, int u) {
            colores.put(u, Color.AMARILLO);
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(u);

            while (adyacentes.hasNext()) {
                int v = adyacentes.next();
                // Si el arco ya fue usado en el primer ciclo, lo ignoramos
                if (arcosProhibidos.contains(u + "-" + v)) continue;

                if (colores.get(v) == Color.BLANCO) {
                    padres.put(v, u);
                    if (dfs(grafo, v)) return true;
                }
                if (colores.get(v) == Color.AMARILLO) {
                    // ¡Ciclo encontrado! Lo marcamos para que no se use de nuevo
                    marcarCamino(u, v);
                    return true;
                }
            }
            colores.put(u, Color.NEGRO);
            return false;
        }

        // Registra los arcos del ciclo en el Set de prohibidos
        private void marcarCamino(int u, int v) {
            arcosProhibidos.add(u + "-" + v); // El arco que cierra el ciclo (1-0)
            int actual = u; // 1
            while (actual != v && padres.containsKey(actual)) { // 1!=0 - 3!=0 - 0!= TERMINA
                int padre = padres.get(actual); // 1it 3 - 2it 0
                arcosProhibidos.add(padre + "-" + actual);// 1it 3->1 - 2it 0->3 - 3it termina arcosProhibidos {1-0 (inicio metodo) , 3-1, 0-3}
                actual = padre; // 1it 1 -> 2it 3 -> 0
            }
        }
    }


