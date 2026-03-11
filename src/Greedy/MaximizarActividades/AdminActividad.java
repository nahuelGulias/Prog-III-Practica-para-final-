package Greedy.MaximizarActividades;

import java.util.ArrayList;
import java.util.Collections;

public class AdminActividad {

    ArrayList<Actividad> solucion = new ArrayList<>();

    public ArrayList<Actividad> getActividades(
            ArrayList<Actividad> actividades
    ) {
        Collections.sort(actividades);


        if(actividades.isEmpty()){
            return solucion;
        }

        int finUltima = actividades.getFirst().getFinI();

        for (int i = 1; i < actividades.size() - 1 ; i++) {

            Actividad aux = actividades.get(i);

            if (aux.getComienzoI() >= finUltima) {
                solucion.add(aux);
                finUltima = aux.getFinI();
            }
        }

        return new ArrayList<>(actividades);
    }
}
