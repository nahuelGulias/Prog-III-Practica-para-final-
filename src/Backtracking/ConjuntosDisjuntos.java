package Backtracking;

import java.util.ArrayList;

public class ConjuntosDisjuntos {
    private ArrayList<ArrayList<Integer>> subconjuntos;


    public ArrayList<ArrayList<Integer>> getConjuntosDisjuntos(ArrayList<Integer> enteros) {
        this.subconjuntos = new ArrayList<>();
        ArrayList<Integer> subA = new ArrayList<>();
        ArrayList<Integer> subB = new ArrayList<>();

        back(enteros, 0, subA, subB);
        return subconjuntos;
    }

    private void back(ArrayList<Integer> enteros, int i, ArrayList<Integer> subA, ArrayList<Integer> subB) {

        if(i == enteros.size()) {
            if(esSolucion(subA,subB)){
                subconjuntos.clear();
                subconjuntos.add(new ArrayList<>(subA));
                subconjuntos.add(new ArrayList<>(subB));
                return;
            }
        }

        int valor = enteros.get(i);


        subA.add(valor);
        back(enteros, i + 1, subA, subB);
        subA.remove(subA.size() - 1);

        subB.add(valor);
        back(enteros, i + 1, subA, subB);
        subB.remove(subB.size() - 1);
    }

    private boolean esSolucion(ArrayList<Integer> subA, ArrayList<Integer> subB) {
        int sumaA = 0, sumaB = 0;
        for ( int n : subA ) {
            sumaA += n;
        }
        for ( int n : subB ) {
            sumaB += n;
        }
        return sumaA == sumaB;
    }

}
