package Backtracking.AsignacionInvitados;

import Final1202.Invitados.Invitado;

import java.util.ArrayList;
import java.util.List;


public class AsignacionDeInvitados {

    Asignacion solucion;
    ArrayList<ArrayList<Invitado>> mesasConformadas;
    int mayorAfinidad;

    public Asignacion asignarMesas(List<Invitado> invitados, int M, int k) {
        for (int i = 0; i < M; i++) {
            mesasConformadas.add(new ArrayList<>());
        }
        mayorAfinidad = 0;
        back(invitados, M, k, 0, 0);
        return solucion;

    }

    private void back(List<Invitado> invitados, int m, int k, int i, int afinidadActual) {
        // Poda por proximidad
        for (ArrayList<Invitado> mesa : mesasConformadas) {
            afinidadActual += calcularAfinidad(mesa);
        }

        int invitadosRestantes = invitados.size() - i;

        int cotaMaxima = afinidadActual + invitadosRestantes * 10;

        if (cotaMaxima <= mayorAfinidad) {
            return;
        }


        if (i == invitados.size()) {

            int total = 0;

            for (ArrayList<Invitado> mesa : mesasConformadas) {
                total += calcularAfinidad(mesa);
            }

            if (total > mayorAfinidad) {

                mayorAfinidad = total;
                solucion.clear();

                for (ArrayList<Invitado> mesa : mesasConformadas) {
                    solucion.add(mesa);
                }

            }

        }

        Invitado invitado = invitados.get(i);

        for (int j = 0; j < mesasConformadas.size(); j++) {

            if (mesasConformadas.get(j).size() < k) {

                mesasConformadas.get(j).add(invitado);

                back(invitados, m, k, i + 1, afinidadActual);

                mesasConformadas.get(j).remove(mesasConformadas.get(j).size() - 1);

            }

        }

    }

    private int calcularAfinidad(ArrayList<Invitado> m) {
        return 0;
    }

}
