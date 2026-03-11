package Backtracking.AsignacionInvitados;

import Final1202.Invitados.Invitado;

import java.util.ArrayList;

public class Asignacion {

    ArrayList<ArrayList<Invitado>> asignados = new ArrayList<>();

    public void add(ArrayList<Invitado> invitados) {
        if (!asignados.contains(invitados)) {
                asignados.add(invitados);
        }
    }

    public void clear() {
        asignados.clear();

    }

    @Override
    public String toString() {
        return "Asignacion{" +
                "asignados=" + asignados +
                '}';
    }
}
