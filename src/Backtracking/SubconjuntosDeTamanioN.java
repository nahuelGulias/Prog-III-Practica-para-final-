package Backtracking;

import java.util.ArrayList;

/*
Utilizando la técnica Backtracking, escriba un algoritmo que dado un conjunto de números enteros,
devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro),
cuyas sumas sean exactamente cero.
Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3,
los subconjuntos que suman cero son: {-7, -1, 8} y {-3, -2, 5}.
 */
public class SubconjuntosDeTamanioN {

    ArrayList<ArrayList<Integer>> solucion = new ArrayList<>();


    public ArrayList<ArrayList<Integer>> getSolucion(ArrayList<Integer> enteros, int tamanio) {
        back(0, tamanio, enteros, new ArrayList<Integer>(), 0);
        return solucion;

    }

    private void back(int i, int tamanio, ArrayList<Integer> enteros, ArrayList<Integer> actual, int sumaActual) {

        if (actual.size() == tamanio) {
            if (sumaActual == 0)
                solucion.add(new ArrayList<>(actual));

            return;
        }


        if (i == enteros.size())
            return;


        if (actual.size() > tamanio)
            return;


        int valor = enteros.get(i);

        actual.add(valor);
        back(i + 1, tamanio, enteros, actual, sumaActual + valor);
        actual.remove(actual.size() - 1);

        back(i + 1, tamanio, enteros, actual, sumaActual);


    }
}
