package Final1202.Invitados;

import java.util.ArrayList;
import java.util.List;

public class Afinidad {

    ArrayList<ArrayList<Invitado>> asignacionDePersonas;
    ArrayList<ArrayList<Invitado>> mesasActuales;
    int mayorAfinidad;

    public ArrayList<ArrayList<Invitado>> getAsignacionDePersonas(List<Invitado> invitados, int mesas, int kLugares) {
        asignacionDePersonas = new ArrayList<>();
        mesasActuales = new ArrayList<>();

        for (int i = 0; i < mesas; i++) {
            mesasActuales.add(new ArrayList<>());
        }


        back(invitados, 0, kLugares);
        return asignacionDePersonas;

    }

    private void back(List<Invitado> invitados, int i, int kLugares) {

        if (i == invitados.size()) {
            int total = 0;

            for (ArrayList<Invitado> mesa : mesasActuales) {
                total += calcularAfinidad(mesa);
            }

            if (total > mayorAfinidad) {

                mayorAfinidad = total;
                asignacionDePersonas.clear();

                for (ArrayList<Invitado> mesa : mesasActuales) {

                    asignacionDePersonas.add(new ArrayList<>(mesa));

                }
            }
            return;
        }


        Invitado invitado = invitados.get(i);

        for (int m = 0; m < mesasActuales.size(); m++) {

            if (mesasActuales.get(m).size() < kLugares) {

                mesasActuales.get(m).add(invitado);

                back(invitados, i + 1, kLugares);

                mesasActuales.get(m).remove(mesasActuales.get(m).size() - 1);
            }
        }
    }

    private int calcularAfinidad(List<Invitado> actual) {
        return 0;
    }

}
