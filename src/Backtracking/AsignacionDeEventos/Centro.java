package Backtracking.AsignacionDeEventos;

import java.util.ArrayList;

public class Centro {
    ArrayList<ArrayList<Evento>> soluciones;
    int cantidadMayor;

    public ArrayList<ArrayList<Evento>> getSoluciones(ArrayList<Evento> eventos) {
        soluciones = new ArrayList<>();
        cantidadMayor = 0;
        ArrayList<Evento> actual = new ArrayList<>();
        int cantidad = 0;
        back(eventos,actual,0, cantidad);
        return soluciones;


    }

    private void back(ArrayList<Evento> eventos, ArrayList<Evento> actual, int i, int cantidad) {
        if( i == eventos.size()) {
            if (cantidad > 0) { // Solo si encontramos algo útil
                if (cantidad > cantidadMayor) {
                    cantidadMayor = cantidad;
                    soluciones.clear();
                    soluciones.add(new ArrayList<>(actual));
                } else if (cantidad == cantidadMayor) {
                    soluciones.add(new ArrayList<>(actual));
                }
            }
            return;
        }

        Evento evento = eventos.get(i);


        if ( actual.isEmpty() || evento.getInicio() > actual.get(actual.size()-1).getFin() ) {
            actual.add(evento);
            cantidad++;
            back(eventos, actual, i + 1, cantidad);
            cantidad--;
            actual.remove(actual.size() - 1);
        }

        back(eventos, actual, i + 1, cantidad );


    }


}
