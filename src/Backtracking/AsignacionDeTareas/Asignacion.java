package Backtracking.AsignacionDeTareas;

import java.util.ArrayList;

public class Asignacion {
        ArrayList<Tarea> tareas = new ArrayList<>();
        ArrayList<Procesador> procesadores = new ArrayList<>();
        int tiempoMinimo;
        ArrayList<Procesador> mejorSolucion = new ArrayList<>();

    public ArrayList<Procesador> asignar( ArrayList<Tarea> tareas) {
        tiempoMinimo = Integer.MAX_VALUE;
        back( 0, 0);
        return this.procesadores;

    }

    private void back(int indice, int tiempoActual) {


        if(indice == tareas.size()) {

            tiempoActual = calcularCarga() ;

            if (tiempoActual < tiempoMinimo) {
                tiempoMinimo = tiempoActual;
                guardarSolucion();
            }
            return;
        }
        Tarea tarea = tareas.get(indice);



        for (Procesador p : procesadores) {
            p.addTarea(tarea);
            if (p.cargaActual <= tiempoMinimo) //PODA
                back(indice+1, tiempoActual);
            p.delete(tarea);
        }

    }

    private int calcularCarga() {
        int carga = 0;

        for (Procesador p : procesadores) {
            if (p.getCargaActual()>carga) {
                carga = p.getCargaActual();
            }
        }
        return carga;
    }

    private void guardarSolucion() {

    }

}
