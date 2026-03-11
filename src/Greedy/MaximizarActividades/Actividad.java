package Greedy.MaximizarActividades;

public class Actividad implements Comparable<Actividad> {

    protected int comienzoI;
    protected int finI;


    public int getComienzoI() {
        return comienzoI;
    }

    public int getFinI() {
        return finI;
    }

    @Override
    public int compareTo(Actividad o) {
        return Integer.compare(finI,o.finI);
    }
}
