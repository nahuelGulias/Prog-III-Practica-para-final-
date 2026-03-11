package Backtracking;

import java.rmi.Remote;
import java.util.ArrayList;

public class UbicacionDeNumerosNaturales {

    private ArrayList<ArrayList<Integer>> secuencias;


    public ArrayList<ArrayList<Integer>> getSecuencias(ArrayList<Integer> enteros) {
        secuencias = new ArrayList<>();
        ArrayList<Integer> actual = new ArrayList<>();
        boolean [] usados = new boolean [enteros.size()];
        back(enteros, actual,usados,-1);
        return secuencias;
    }

    private void back(ArrayList<Integer> enteros, ArrayList<Integer> actual,boolean [] usados , int anterior) {

        if(actual.size() == enteros.size()) {
            secuencias.add(new ArrayList<>(actual));
            return;
        }


        for(int i = 0; i < enteros.size(); i++) {

            if (!usados[i]) {
                int n = enteros.get(i);

                if(!actual.isEmpty()) {
                    anterior = actual.get(actual.size() - 1);

                    if(n%2==0 && anterior%2==0)
                        continue;
                }

                actual.add(n);
                usados[i] = true;
                back(enteros, actual, usados, anterior);
                actual.remove(actual.size() - 1);
                usados[i] = false;
            }
        }

    }
}
