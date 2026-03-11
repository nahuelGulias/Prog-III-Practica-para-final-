package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class SubconjuntosDisjuntosPersonasConFuerza {

    ArrayList<ArrayList<Integer>> subconjuntos;



    public String getSolucion(ArrayList<Integer> personas, int cantSubconjuntos) {
        subconjuntos = new ArrayList<>();

        for (int i = 0; i < cantSubconjuntos ; i++) {
            subconjuntos.add(new ArrayList<Integer>());
        }

        int [] sumas = new int[cantSubconjuntos];

        Collections.sort(personas, Collections.reverseOrder());

        for (int p : personas){ //Para cada persona {7,4,3,1}

            for (int i = sumas.length-1; i >= 0; i--) { // Para cada suma me guardo la fuerza de la persona

                int sumaEntrante = sumas[i] + p;
                boolean rompe = false;

                if (i > 0 && sumas[i-1] <= sumaEntrante) {
                    rompe = true;
                }

                if(!rompe) {
                    sumas[i] += p;
                    subconjuntos.get(i).add(p);
                    break;
                }
            }


        }

        return difTotal(sumas) + subconjuntos.toString();

    }

    private int difTotal(int[] sumas) {
        return sumas[0] - sumas[sumas.length-1];
    }

}
