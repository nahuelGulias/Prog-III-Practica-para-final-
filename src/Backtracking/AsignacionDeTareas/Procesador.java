package Backtracking.AsignacionDeTareas;

import java.util.ArrayList;

public class Procesador {
    ArrayList<Tarea> tareas;
    int cargaActual;

    public int getCargaActual() {
        return cargaActual;
    }

    public Procesador() {
        tareas = new ArrayList<>();
    }

    public void addTarea(Tarea t) {
        if (!tareas.contains(t)) {
            tareas.add(t);
            cargaActual+= t.getTiempo();
        }
    }

    public ArrayList<Tarea> getTareas() {
        return new ArrayList<>(tareas);
    }

    public void delete(Tarea t) {
        if (tareas.contains(t)) {
            tareas.remove(t);
            cargaActual-= t.getTiempo();
        }
    }
}
